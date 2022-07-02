package multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableApp2 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> jobFirst = () -> {
            TimeUnit.SECONDS.sleep(6);
            return 5;
        };
        Callable<Integer> jobSecond = () -> {
            TimeUnit.SECONDS.sleep(5);

            return 10;
        };
        Callable<Integer> jobThird = () -> {
            TimeUnit.SECONDS.sleep(10);

            return 15;
        };


        List<Callable<Integer>> callableList = Arrays.asList(jobFirst, jobSecond, jobThird);

        // we are waiting when all jobs will end
        List<Future<Integer>> futures1 = executor.invokeAll(callableList);
        // we are waiting only for first end job
        Integer futures2 = executor.invokeAny(callableList);

        for(Future<Integer> f: futures1){
            System.out.println(f.get());
        }

        System.out.println(futures2);

        executor.shutdown();


        // tutaj brakuje ->
        // 1. get blokuje watek ktory ma na przyklad sleep
        // 2. łączenia wywołań w łańcuch
    }
}
