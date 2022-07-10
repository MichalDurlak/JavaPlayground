package pl.michaldurlak.JavaPlayground.functional;

import pl.michaldurlak.JavaPlayground.functional.domain.Indeks;
import pl.michaldurlak.JavaPlayground.functional.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;
import java.util.function.*;

public class App {

    public static void main(String[] args) {


        // interfejs funkcyjny -> czyli posiada tylko jedną metodę (przyklady poniżej)

        //1 Runnable z tematyki wielowątkowości
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        };

        //2 Comparable
        Comparable<String> c = new Comparable<String>() {
            @Override
            public int compareTo(String o) {
                return 0;
            }
        };


        //3 Możemy sami stworzyć taki interfejs
        Movable m = new Movable() {
            @Override
            public int move(String direction) {
                return 0;
            }
        };

        // każde interfejs funkcyjny można zastąpić LAMBDĄ przykład poniżej:

        Runnable ru = () -> {
            System.out.println("A");
        };

        // gdy jest jedno wyrażenie wystarczy zapisać to tak

        Runnable ru1 = () -> System.out.println("A");

        // dla Comparable
        Comparable<String> co = (String o) -> 0;

        // nie potrzebujemy zaznaczać deklarować typu poniżej String direction, ponieważ program to wydedukuje po interfejsie + skracamy kod
        Movable mo = direction -> 11;



        Runnable rb = () -> System.out.println("B");
        test("B",rb);



//  PREDICATE
        List<Student> studentList = createData();

        //Predicaty przydadza sie podczas na przyklad filtrowania
        // Tworzymy nowa metode ktora bierze liste oraz predicate jesli tak to zwraca liste ze wszystkich true
        Predicate<Student> isAndrzej = student -> student.getName().equals("Andrzej");

        Predicate<Student> over30 = student -> student.getAge()>30;

        getAndrzej(studentList);
        getOver30(studentList);
        filterStudents(studentList, isAndrzej);
        filterStudents(studentList, over30);

        //kilkukrotne filtorwanie czy Andrzej lub czy ma 30 lat
        Predicate<Student> and = isAndrzej.or(over30);
        //wszyscy, ktorzy nie maja na imie Andrzej
        Predicate<Student> andr = isAndrzej.negate();

// CONSUMER
        // interfejs, który na podstawie obiektu nie zwraca nic

        //bierze obiekt, robi operacje i nic nie zwraca
        Consumer<Student> printStudentsNames = student -> System.out.println(student.getName());
        Consumer<Student> printStudentsNamesToUppercase = student -> System.out.println(student.getName().toUpperCase());

        //wypisuje wszystkich studentów
        consumeStudents(studentList, printStudentsNames);

        //polaczenie filtrowania i consume
        //wyfiltruj wszystkich po 30 i wypisz liste studentow
        consumeStudents(filterStudents(studentList, over30), printStudentsNames);

        //laczenie consumerow
        //na poczatku wywolaj printStudentsName a pozniej printStudentNamesToUppercase
        Consumer<Student> studentConsumer = printStudentsNames.andThen(printStudentsNamesToUppercase);
        consumeStudents(filterStudents(studentList, over30), studentConsumer);

// SUPPLY
        //przeciwieństwo Consumera, nie bierze żadnych argumentów a zwraca obiekt danego typu
        Supplier<List<Student>> supplyPredefinedStudents = () -> createData();
        Supplier<List<Student>> supplyPredefinedStudentsReference = App::createData;

//Function
        //interfejs, który bierze jeden typ obiektu, modyfikuje go i zwraca inny typ obiektu
        Function<Student, String> getStudentNameFunction = student -> student.getName();

        //BiFunction - to funkcja ktora bierze obiekty 2 typow a zwraca 3 typ
        BiFunction<String, Student, Integer> biFunction = new BiFunction<String, Student, Integer>() {
            @Override
            public Integer apply(String s, Student student) {
                return 0;
            }
        };

        //BinaryOperator - laczy 2 te same typy w 1
        BinaryOperator<Student> binaryOperator = new BinaryOperator<Student>() {
            @Override
            public Student apply(Student student, Student student2) {
                return null;
            }
        };

//
        //IntPredicate - na podstawie Inta zwraca się boolean
        IntPredicate o = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return false;
            }
        };

        DoublePredicate doublePredicate = new DoublePredicate() {
            @Override
            public boolean test(double value) {
                return false;
            }
        };

        //IntFunction - funkcja ktora na podstawie inta zwraca klase na przyklad student
        IntFunction<Integer> i = new IntFunction<Integer>() {
            @Override
            public Integer apply(int value) {
                return null;
            }
        };

        //ToIntFunction - funkcja ktora bierze klase studenta i zwraca int
        ToIntFunction<Student> getStudentAge = new ToIntFunction<Student>() {
            @Override
            public int applyAsInt(Student value) {
                return value.getAge();
            }
        };


//METHOD REFERENCE
        // :: -> marker dla metod referencyjnych
        Supplier<List<Student>> supplyPredefinedStudentsBeforeReference = () -> createData();
        Supplier<List<Student>> supplyPredefinedStudentsAfterReference = App::createData;

        Consumer<String> stringConsumerBeforeReference = (String x) -> referenceMethodTest(x);
        Consumer<String> stringConsumerAfterReference = App::referenceMethodTest;

        // 1 - dluga wersja implementacji BiFunction
        BiFunction<Student, String, Student> changeIndex = new BiFunction<Student, String, Student>() {
            @Override
            public Student apply(Student student, String newIndexNumber) {
                return student.changeIndexNumber(newIndexNumber);
            }
        };
        // 2 - jedna linijka implementacji
        BiFunction<Student, String, Student> changeIndexShortcut = (student, newIndexNumber) -> student.changeIndexNumber(newIndexNumber);

        // 3 - jedna linijka ale z method reference
        BiFunction<Student, String, Student> changeIndexShortcutAfterMethodReference = Student::changeIndexNumber;



//OPTIONAL
        Student getFirstStudent = supplyPredefinedStudentsAfterReference.get().get(0);
        Optional<Indeks> indexFirstStudent = getFirstStudent.getIndex();
        // czy ten Optional nie jest pusty
        if(indexFirstStudent.isPresent()){
            System.out.println(indexFirstStudent.get().getIndexNumber());
        }

        //jesli index jest dostepny zawołaj jakiegoś Customera. Customer na podstawie jakiegoś obiektu coś zrobi ale nic nie zwroci
        indexFirstStudent.ifPresent(in -> System.out.println(in.getIndexNumber()));

        //orElse() -> jesli indeks jest pusty, podaj jakiś inny index
        //orElseGet() -> przesyłamy supplier, podaj jakis inny index
        //orElseThrow() ->
//        indexFirstStudent.filter(ix -> { ix.getIndexNumber().equals("123")});

        // map -> na podstawie indexu (ktory moze byc lub moze go nie być), przemapuje nam index na stringa którym jest numer indeksu
//        indexFirstStudent.map()
    }



    private static void referenceMethodTest(String x){

    }

    private static void consumeStudents(List<Student> students, Consumer<Student> consumer){
        for(Student s : students){
            consumer.accept(s);
        }
    }

    private static List<Student> filterStudents(List<Student> studentsList, Predicate<Student> predicate){
        List<Student> result = new ArrayList<>();

        for(Student s : studentsList){
            if(predicate.test(s)){
                result.add(s);
            }
        }

        return result;
    }

    private static void getOver30(List<Student> studentList) {

        List<Student> result = new ArrayList<>();

        for(Student s : studentList){
            if(s.getAge() > 30){
                result.add(s);
            }
        }

    }

    private static void getAndrzej(List<Student> studentList) {

        List<Student> result = new ArrayList<>();

        for(Student s : studentList){
            if(s.getName().equals("Andrzej")){
                result.add(s);
            }
        }

    }

    private static List<Student> createData() {
        List<Student> result = new ArrayList<>();

        result.add(new Student("Pawel",31,"123"));
        result.add(new Student("Tomek",29,"1234"));
        result.add(new Student("Andrzej",32,"12345"));

        return result;
    }

    // można dodać wymagany parametr do funkcji jako Runnable
    public static void test(String name, Runnable a){

    }
}
