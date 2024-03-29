package programming.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NatwestTest {

    private static class ChildThread implements Callable<Integer> {

        /*
         * (non-Javadoc)
         *
         * @see java.util.concurrent.Callable#call()
         */
        @Override
        public Integer call() throws Exception {
            System.out.println("waiting for 3 secs");
            TimeUnit.SECONDS.sleep(5);
            return 1;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final ExecutorService execSvc = Executors.newFixedThreadPool(1);

        final Future<Integer> childResponse = execSvc.submit(new NatwestTest.ChildThread());

        // execSvc.shutdown();
        System.out.println(childResponse.get());
        System.out.println("main thread working");

    }

}
