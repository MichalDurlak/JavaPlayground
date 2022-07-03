package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionApp1 {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Counter counter = new Counter();

        for (int i=0; i<100; i++){
            executorService.submit(() -> counter.setCounter());
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println(counter.getCounter());

    }

}


class Counter {

    private int counter = 0;

    // metoda 1 - dodanie synchronized aby jeden watek mial tylko dostep do zmiennych - BARDZO WAŻNE!!
    synchronized public void setCounter(){
        counter ++;
    }

    // metoda 2 - wszystkie watki biora sobie dwa pierwsze sout'y pozniej ustawiaja sie w kolejce i podnasza liczbe counter o 1 a nastepnie znowu randomowo korzystaja z ostatniego sout'a
    // souty nie są sekcją krytyczną + ustawienia countera jest sekcja krytyczna
    public void setCounterMethod2(){
        System.out.println("WYNIK1");
        System.out.println("WYNIK2");

        synchronized (this){
            counter ++ ;
        }

        System.out.println("WYNIK3");
    }


    //metoda 3 - klasa ktora sama opakowuje i implementuje sekcje krytyczne tak jak na przyklad ten int
    // metoda atomowa - jest zamkniete w synchroniczny blok ktory działa o wiele szybciej niz synchronize
    // minus ze operujemy na obiektach
    private AtomicInteger counter1 = new AtomicInteger(0);

    public void increaseForAtomic(){
        counter1.getAndIncrement();
    }


    public int getCounter(){
        return counter;
    }
}