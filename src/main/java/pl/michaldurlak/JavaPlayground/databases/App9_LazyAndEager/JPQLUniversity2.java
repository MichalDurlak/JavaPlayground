package pl.michaldurlak.JavaPlayground.databases.App9_LazyAndEager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JPQLUniversity2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    // LAZY -> jeśli dana relacja nie jest używana, nie musi dociągać informacji o studentach
    // EAGER -> za każdym razem zaciąga wszystkie dane
    // dla relacji one to one domyślnie ustawiony jest eager, dla relacji many to many domyślna wartość to lazy
    private List<JPQLStudent2> listOfStudents;

    public JPQLUniversity2(String name) {
        this.name = name;
        this.listOfStudents = new ArrayList<>();
    }

    private JPQLUniversity2(){

    }

    @Override
    public String toString() {
        return "JPQLUniversity2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listOfStudents=" + listOfStudents +
                '}';
    }

    public void addStudent(JPQLStudent2 studentData) {
        this.listOfStudents.add(studentData);
    }
}
