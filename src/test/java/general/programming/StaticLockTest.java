package java.programming;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * Java Source StaticLockTest.java created on Jul 12, 2021
 *
 * @author : Sanjeev Saxena
 * @email : sanrocks123@gmail.com
 * @version : 1.0
 */

public class StaticLockTest {

    public synchronized void a() throws InterruptedException {
        System.out.println("display a, lock acquired...");
        TimeUnit.SECONDS.sleep(5);
    }

    public synchronized void b() {
        System.out.println("display b");
    }

    @Test
    public void testStaticMethod() throws InterruptedException {

        new Thread(() -> {
            try {
                new StaticLockTest().a();
            }
            catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }, "a").start();

        new Thread(() -> {
            new StaticLockTest().b();
        }, "b").start();

        TimeUnit.SECONDS.sleep(8);

    }

}
