package pl.michaldurlak.JavaPlayground.databases.App7_ManytoMany;

import org.springframework.core.io.ClassPathResource;
import pl.michaldurlak.JavaPlayground.databases.App1.domain.Student;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "classes")
    private Set<StudentApp7> students;


    public Classes(String name) {
        students = new HashSet<>();
        this.name = name;
    }

    private Classes(){

    }

    public void addStudent(StudentApp7 studentApp7){
        students.add(studentApp7);
    }

}
