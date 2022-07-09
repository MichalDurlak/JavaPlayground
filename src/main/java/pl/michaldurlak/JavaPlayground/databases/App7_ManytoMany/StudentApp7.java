package pl.michaldurlak.JavaPlayground.databases.App7_ManytoMany;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.Set;

@Entity
public class StudentApp7 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany
    private Set<Classes> classes;

    public StudentApp7(String name) {
        this.name = name;
    }

    private StudentApp7(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "StudentApp7{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes=" + classes +
                '}';
    }
}
