package pl.michaldurlak.JavaPlayground.databases.App4_Embeddable_OneToOne;

import javax.persistence.*;

@Entity(name="StudentTable_App4")
public class StudentApp4 {

    // ID jest niezbedne
    @Id
    private int id;
    @Column(name="imie", nullable = false)
    private String name;

    @Column(unique = true)
    private String telephone;

    @Embedded
    private AddressApp4 addressApp4;

    @OneToOne
    private IndeksOneToOne indeksOneToOne;

    //JPA potrafi za pomoca dialectu tłumaczyc polecenia do konkretnej bazy danych. Dialect jest w persistence.xml


    // pusta metoda podobno jest potrzebna ??
    private StudentApp4(){

    }

    public StudentApp4(int id, String name) {
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
//                ", indeks='" + indeksOneToOne + '\'' +
                '}';
    }

    public void setIndeksOneToOne(IndeksOneToOne indeksOneToOne) {
        this.indeksOneToOne = indeksOneToOne;
    }

    public IndeksOneToOne getIndeksOneToOne() {
        return indeksOneToOne;
    }
}

