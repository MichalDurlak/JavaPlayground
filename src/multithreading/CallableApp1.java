package multithreading;

import java.util.concurrent.*;

public class CallableApp1 {

    // Callable zwraca jakiś wynik !

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executor = Executors.newFixedThreadPool(2);
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> returnRandomNumber = () -> {
            TimeUnit.SECONDS.sleep(4);
            return 5;
        };

        Future<Integer> result = executor.submit(returnRandomNumber);


        Integer resultAnswer = null;

        try {
            resultAnswer = result.get(5,TimeUnit.SECONDS);

        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }


        System.out.println(resultAnswer);

        executor.shutdown();
    }

}
