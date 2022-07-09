package pl.michaldurlak.JavaPlayground.databases.App6_OneToMany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "University6_App6")
public class UniversityApp6 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @OneToMany
    private Set<StudentApp6> students;


    private UniversityApp6(){

    }

    public UniversityApp6(String name) {
        this.students = new HashSet<>();
        this.name = name;
    }



    public void addStuddent(StudentApp6 studentApp6){
        students.add(studentApp6);
    }


    @Override
    public String toString() {
        return "UniversityApp6{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
