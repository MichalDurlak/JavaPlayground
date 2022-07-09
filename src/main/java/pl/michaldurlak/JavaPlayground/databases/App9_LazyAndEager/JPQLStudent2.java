package pl.michaldurlak.JavaPlayground.databases.App9_LazyAndEager;

import pl.michaldurlak.JavaPlayground.databases.App8_JPQL.JPQLStudent1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JPQLStudent2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String nazwisko;


    public JPQLStudent2(String name, String nazwisko) {
        this.name = name;
        this.nazwisko = nazwisko;
    }

    private JPQLStudent2(){

    }

    @Override
    public String toString() {
        return "JPQLStudent2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
