package pl.michaldurlak.JavaPlayground.databases.App3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="StudentTable_App3")
public class StudentApp3 {

    // ID jest niezbedne
    @Id
    private int id;
    @Column(name="imie", nullable = false)
    private String name;

    @Column(unique = true)
    private String telephone;

    //JPA potrafi za pomoca dialectu tłumaczyc polecenia do konkretnej bazy danych. Dialect jest w persistence.xml


    // pusta metoda podobno jest potrzebna ??
    private StudentApp3(){

    }

    public StudentApp3(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}

