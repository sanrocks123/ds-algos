/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package oops;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sanrockzz.gradledemo.dto.Counter;
import sanrockzz.gradledemo.dto.Employee;

/**
 * Java Source ConcurrentTest.java created on Mar 20, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class ConcurrentTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testBlockingQueue() {
        final BlockingQueue<Employee> bQueue = new ArrayBlockingQueue<>(10);

        final Runnable producer = () -> {

            final Employee e = new Employee(new Random().nextInt(), "a");
            try {
                bQueue.put(e);
            }
            catch (final InterruptedException e1) {
                e1.printStackTrace();
            }
            log.info("{} produced {}", Thread.currentThread().getName(), e);
        };

        final Runnable consumer = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                final Employee e = bQueue.take();
                log.info("{} consumed {}", Thread.currentThread().getName(), e);
            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        };

        final ExecutorService execSvc = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 10; i++) {
            execSvc.execute(new Thread(producer));
            execSvc.execute(new Thread(consumer));
        }
        execSvc.shutdown();
        while (!execSvc.isTerminated()) {
        }

    }

    @Test
    public void testJoin() throws InterruptedException {

        final Thread t1 = new Thread(() -> {
            try {
                log.info("{} started", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                log.info("{} done", Thread.currentThread().getName());
            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Thread t2 = new Thread(() -> {
            try {
                log.info("{} started", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                log.info("{} done", Thread.currentThread().getName());
            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        });

        final Thread t3 = new Thread(() -> {
            try {
                log.info("{} started", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
                log.info("{} done", Thread.currentThread().getName());
            }
            catch (final InterruptedException e) {
                e.printStackTrace();
            }
        });

        t3.setName("t3");
        t3.start();

        t2.setName("t2");
        t2.start();

        t1.setName("t1");
        t1.start();

        t3.join();

        t2.join();

        t1.join();
    }

    @Ignore
    @Test
    public void testLocks() {

        final Lock lock = new ReentrantLock();
        final Counter count = new Counter();

        final Runnable task = () -> {
            try {
                log.info("Thread {}, Trying for lock", Thread.currentThread().getName());
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    try {
                        final int tt = count.getCount() + 1;
                        count.setCount(tt);
                        log.info("Thread {}, Acquired, count {}", Thread.currentThread().getName(), count.getCount());
                    }
                    finally {
                        lock.unlock();
                    }
                }
                else {
                    log.info("Thread {}, Not Acquired, count {}", Thread.currentThread().getName(), count.getCount());
                }
            }
            catch (final InterruptedException e) {
                log.error("Error ", e);
            }
        };

        final ExecutorService eSvc = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            eSvc.execute(new Thread(task));
        }

        eSvc.shutdown();
        while (!eSvc.isTerminated()) {
        }
    }

    @Test
    public void testProducerConsumer() {
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        final AtomicInteger count = new AtomicInteger(5);

        final Runnable producer = () -> {
            while (count.get() != 0) {
                try {
                    final int number = new Random().nextInt();
                    queue.put(number);
                    count.decrementAndGet();
                    log.info("Thread {} Produced {}", Thread.currentThread().getName(), number);
                }
                catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        final Runnable consumer = () -> {
            while (!queue.isEmpty()) {
                try {
                    final int number = queue.take();
                    System.out.println("Thread " + Thread.currentThread().getName() + " Consumed " + number);
                }
                catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }

    @Ignore
    @Test
    public void testProducerConsumerUsingLocks() {

        final Counter count = new Counter();
        final Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        count.setEnable(false);

        final Runnable r1 = () -> {

            while (count.isEnable()) {
                try {
                    log.info("{}, trying lock", Thread.currentThread().getName());
                    if (lock.tryLock(5, TimeUnit.SECONDS)) {
                        try {
                            log.info("{}, lock acquired", Thread.currentThread().getName());
                            if (count.getCount() == 0) {
                                log.info("{}, incrementing count", Thread.currentThread().getName());
                                final int tt = count.getCount() + 1;
                                count.setCount(tt);

                                TimeUnit.SECONDS.sleep(3);
                                condition.signal();
                            }
                            else {
                                log.info("{}, count not ZERO, waiting", Thread.currentThread().getName());
                                condition.await(5, TimeUnit.SECONDS);
                            }
                        }
                        finally {
                            lock.unlock();
                            log.info("{}, lock released", Thread.currentThread().getName());
                        }
                    }
                    else {
                        log.info("{}, lock acquire failed", Thread.currentThread().getName());
                    }
                }
                catch (final InterruptedException e) {
                    log.error("Error", e);
                }
            }
        };

        final Runnable r2 = () -> {

            while (count.isEnable()) {
                try {
                    log.info("{}, trying lock", Thread.currentThread().getName());
                    if (lock.tryLock(5, TimeUnit.SECONDS)) {
                        try {
                            log.info("{}, lock acquired", Thread.currentThread().getName());
                            if (count.getCount() == 1) {
                                log.info("{}, decrememting count", Thread.currentThread().getName());
                                final int tt = count.getCount() - 1;
                                count.setCount(tt);

                                TimeUnit.SECONDS.sleep(3);
                                condition.signal();
                            }
                            else {
                                log.info("{}, count ZERO, waiting", Thread.currentThread().getName());
                                condition.await(5, TimeUnit.SECONDS);
                            }
                        }
                        finally {
                            lock.unlock();
                            log.info("{}, lock released", Thread.currentThread().getName());
                        }
                    }
                    else {
                        log.info("{}, lock acquire failed", Thread.currentThread().getName());
                    }
                }
                catch (final InterruptedException e) {
                    log.error("Error", e);
                }
            }
        };

        final ExecutorService eSvc = Executors.newWorkStealingPool();

        eSvc.execute(new Thread(r1));
        eSvc.execute(new Thread(r2));

        eSvc.shutdown();
        while (!eSvc.isTerminated()) {
        }
    }

}
