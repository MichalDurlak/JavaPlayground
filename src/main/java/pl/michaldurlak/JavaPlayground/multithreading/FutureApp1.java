package multithreading;

import java.sql.Time;
import java.util.concurrent.*;

public class FutureApp1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // runAsync
        CompletableFuture.runAsync( () -> System.out.println(Thread.currentThread().getName()));
        CompletableFuture.runAsync( () -> System.out.println(Thread.currentThread().getName()));
        CompletableFuture.runAsync( () -> System.out.println(Thread.currentThread().getName()));
        CompletableFuture.runAsync( () -> System.out.println(Thread.currentThread().getName()));


        // supplyAsync:


        // wywolanie łańcuchowe
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 2;
        },executorService).thenApplyAsync(result -> result*2).thenApplyAsync(result -> result+1).thenAccept( result -> System.out.println(result + " - " + java.time.LocalTime.now()));

        System.out.println(java.time.LocalTime.now());

        System.out.println("NEW TASK");
        // wywolanie normalne
        CompletableFuture<Integer> resultSupplyAsyncNormal = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 2;
        },executorService).thenApplyAsync(result -> result*2).thenApplyAsync(result -> result+1);

        System.out.println(java.time.LocalTime.now());
        System.out.println(resultSupplyAsyncNormal.get());
        System.out.println(java.time.LocalTime.now());



        executorService.shutdown();
    }

}
