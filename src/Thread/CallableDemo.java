package Thread;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws Exception {

        Callable<Integer> task = () -> {
            System.out.println("Calculating...");
            Thread.sleep(1000);
            return 10 + 20;  // returns result
        };

        FutureTask<Integer> future = new FutureTask<>(task);

        Thread t = new Thread(future);
        t.start();

        System.out.println("Result = " + future.get()); // waits & gets result
    }
}
