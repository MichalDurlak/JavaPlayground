package multithreading;

public class MyThread extends Thread{

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("My Thread - Name of thread: " + Thread.currentThread().getName());
    }


}
