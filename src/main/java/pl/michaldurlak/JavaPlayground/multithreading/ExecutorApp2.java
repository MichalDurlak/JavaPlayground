package multithreading;

import java.util.concurrent.*;

public class ExecutorApp2 {


    public static void main(String[] args) {

        // single thread
//        ExecutorService executor = Executors.newSingleThreadExecutor();

        // multiple threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // schedule threads
        ScheduledExecutorService executorSchedule = Executors.newScheduledThreadPool(5);


        executor.submit(() -> System.out.println("1st task -> Name of thread -> " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("2nd task -> Name of thread -> " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("3th task -> Name of thread -> " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("4th task -> Name of thread -> " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("5th task -> Name of thread -> " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("6th task -> Name of thread -> " + Thread.currentThread().getName()));
        executor.submit(() -> System.out.println("7th task -> Name of thread -> " + Thread.currentThread().getName()));


        // 5 seconds delay and do task
//        executorSchedule.schedule(() -> System.out.println("TEST"), 5, TimeUnit.SECONDS);

        // do task -> wait 2 seconds -> do task (LOOP)
        executorSchedule.scheduleAtFixedRate(() -> System.out.println("Schedule task " + Thread.currentThread().getName()), 0, 2,TimeUnit.SECONDS);


        executor.shutdown();
//        executorSchedule.shutdown();

    }

}
