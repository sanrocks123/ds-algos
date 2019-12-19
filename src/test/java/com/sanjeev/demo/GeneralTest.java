/**
 * Copyright (c) @Sanjeev Saxena 2017. All Rights Reserved.
 */

package com.sanjeev.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sanrockzz.gradledemo.dto.Counter;
import sanrockzz.gradledemo.dto.Employee;

/**
 * Java Source GeneralTest.java created on Apr 17, 2019
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class GeneralTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testASCIICode() {
        System.out.println(Integer.valueOf("v".charAt(0)));
    }

    @Test
    public void testClone() throws CloneNotSupportedException {

        final Counter count = new Counter();
        count.setCount(1);
        final Employee emp = new Employee();
        emp.setEmpId(100);
        emp.setName("Angela");
        count.setEmp(emp);

        log.info("c1 {}", count);

        final Counter c2 = count.copy();
        c2.setCount(2);
        c2.getEmp().setName("Hung");

        log.info("c2 {}", c2);
        log.info("c1 {}", count);
    }

    @Test
    public void testClone1() throws CloneNotSupportedException {
        final Employee e1 = new Employee(123, "sanjeev");
        log.info("e1: {}", e1);
        final Employee e2 = e1.clone();
        e2.setName("Saxena");
        log.info("e2: {}", e2);
    }

    @Test
    public void testErrors() {
        try {
            throw new Error("");
        }
        catch (final Error err) {
            log.info("Error", err);
        }
        log.info("Good to go after Error");
    }

    @Test()
    public void testImmutable() {

        ImmutableClass a = new ImmutableClass(1);
        final ExtendedImmutableClass b = new ExtendedImmutableClass(2);
        log.info("a : {}, b: {}", a.getId(), b.getId());

        b.setId(3);
        a = b;
        log.info("a : {}, b: {}", a.getId(), b.getId());
    }

    @Test
    public void testLRUCache() {

        final BlockingQueue<Employee> queue = new ArrayBlockingQueue<>(3);
        queue.add(new Employee(1, "A"));
        queue.add(new Employee(2, "B"));
        queue.add(new Employee(3, "C"));

        queue.offer(new Employee(4, "D"));

        final int a = 925 % 50;
        log.info("Mod {}", a);
        log.info("Queue {}", queue);
    }

    @Test
    public void testNullReferenceOverriding() {
        final ExtendedImmutableClass ext = new ExtendedImmutableClass(123);
        final Object aa = null;
        ext.printVal(aa);
    }

    @Test
    public void testPriorityQueue() {
        final PriorityBlockingQueue<String> qq = new PriorityBlockingQueue<>();

        qq.put("zzzz");
        qq.put("qqq");
        qq.put("aaa");
        qq.put("bbb");

        log.info("qq {}", qq);

    }

    @Test
    public void testTryCatchReturn() {
        Assert.assertTrue(hello() == 1);
    }

    @Test
    public void testVolatile() {

        final Counter cc = new Counter();
        final Employee e1 = new Employee(1, "a");
        cc.setEmp(e1);

        log.info("cc init {}", cc);

        final Runnable r1 = () -> {
            cc.m1();
            cc.getEmp().setName("b");
            log.info("r1 cc {}", cc);
        };

        final Runnable r2 = () -> {
            // cc.m2();
            // cc.getEmp().setName("c");
            log.info("r2 cc {}", cc);
        };

        final ExecutorService eSvc = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            eSvc.execute(r1);
            eSvc.execute(r2);
        }

        eSvc.shutdown();
        while (!eSvc.isTerminated()) {
        }

    }

    /**
     * @return
     */
    @SuppressWarnings("finally")
    private int hello() {
        try {
            return 0;
        }
        catch (final Exception ex) {
            System.out.println("this is catch");
        }
        finally {
            return 1;
        }
    }

}
