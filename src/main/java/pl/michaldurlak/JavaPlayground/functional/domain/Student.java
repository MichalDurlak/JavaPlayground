package pl.michaldurlak.JavaPlayground.functional.domain;

import java.util.Optional;

// żadna klasa nie będzie po niej dziedziczyć, niemodyfikowalne
final public class Student {

    private String name;
    private int age;

    private Indeks index;

    public Student(String name, int age, String indexNumber) {
        this.name = name;
        this.age = age;
        this.index = new Indeks(indexNumber);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // może być a może nie być, unikanie zwracania null
    public Optional<Indeks> getIndex() {
        return Optional.ofNullable(this.index);
    }

    // gdy Student zgubi index (założenie) to robimy z niego kopie i przypisujemy nowy numer indeksu tak jak poniżej:
    public Student changeIndexNumber(String newIndexNumber){
        return new Student(this.name,this.age,newIndexNumber);
    }

    // nie ustawiamy tutaj setterow, żeby pod żadnym pozorem nie móc modyfikować wprowadzonych danych
    // musimy się upewnić również że inne klasy nie mogą modyfikować pul
    // immutable = czyli niezmienny

    //Czyste funkcje:
    // Nie robimy setera
    // Tworzenie metod uzasadnionych biznesowo
    // Nie modyfikujemy poza stanem obiektu (czyli na przyklad nie modyfikujemy tutaj klasy indeks)
    // Dla tej samej listy parametrów ustawiamy ten sam wynik
    // klasa typu immutable
    // unikamy null


}
