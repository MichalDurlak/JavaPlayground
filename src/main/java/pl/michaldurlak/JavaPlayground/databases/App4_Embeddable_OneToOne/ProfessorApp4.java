package pl.michaldurlak.JavaPlayground.databases.App4_Embeddable_OneToOne;

import javax.persistence.*;

@Entity(name="ProfessorTable_App4")
public class ProfessorApp4 {

    // ID jest niezbedne
    @Id
    private int id;
    @Column(name="imie", nullable = false)
    private String name;

    @Column(unique = true)
    private String telephone;

    @Embedded
    private AddressApp4 addressApp4;

    //JPA potrafi za pomoca dialectu tłumaczyc polecenia do konkretnej bazy danych. Dialect jest w persistence.xml


    // pusta metoda podobno jest potrzebna ??
    private ProfessorApp4(){

    }

    public ProfessorApp4(int id, String name) {
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
