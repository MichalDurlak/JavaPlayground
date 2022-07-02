package multithreading;

public class ExecutorApp1 {

    public static void main(String[] args) throws InterruptedException {
        // time when start program
        System.out.println(java.time.LocalTime.now());

        System.out.println("ExecutorService - Name of thread: " + Thread.currentThread().getName());

        Thread thread = new MyThread("MyThread1");

        thread.start();

        Runnable task = () -> {
                System.out.println("My Runnable - Name of thread: " + Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(task, "threadRunnable1");



        thread1.start();

        System.out.println(java.time.LocalTime.now());


        // time when program ends
        Thread endTime = new Thread(() -> System.out.println(java.time.LocalTime.now()), "endTimeThread");
        thread1.join();
        endTime.start();

    }



}
