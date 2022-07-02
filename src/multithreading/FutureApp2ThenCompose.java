package multithreading;

import java.util.concurrent.*;
import java.util.function.BiFunction;

public class FutureApp2ThenCompose {



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // łączenie zadań w sposób zależny


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Long> getUserIDFuture = CompletableFuture.supplyAsync( () -> {

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return getUserID();
                });

        // thenCompose
        CompletableFuture<Void> getUserDetails = getUserIDFuture.thenCompose( userID -> CompletableFuture.supplyAsync( () -> getUserDiscount(userID)).thenAccept(userDiscount -> System.out.println(userDiscount)));


        getUserDetails.get();

        executorService.shutdown();






        // łączenie zdań w sposób niezależny

        CompletableFuture<Long> resultLong1 = CompletableFuture.supplyAsync( () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 431L;
        });


        CompletableFuture<Long> resultLong2 = CompletableFuture.supplyAsync( () -> {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 2L;
        });


        CompletableFuture<Long> longCompletableFuture = resultLong1.thenCombine(resultLong2, (aLong, aLong2) -> aLong * aLong2);

        Long longResult = longCompletableFuture.get();

        System.out.println(longResult);
    }


    public static Long getUserID(){
        return 386L;
    }


    public static Double getUserDiscount(Long userID){
        return 20.0;
    }


}
