package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FutureApp3HandleException {

    public static void main(String[] args) throws IllegalAccessException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        final boolean err = true;


        // po 5 sekundach sprawdzi czy err jest true czy false a nastepnie obsłużymy wyjątek zwracając liczbę 9 -> na sam koniec wypisujemy result

         CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (err){
                throw new IllegalArgumentException("Wrong Arg");
            }
           return 12;
        }, executorService).exceptionally(exception -> {
            System.out.println("ERROR !!" + exception.getMessage());
            return 9;
        }).thenAccept(result -> System.out.println(result));




        executorService.shutdown();



    }


}
