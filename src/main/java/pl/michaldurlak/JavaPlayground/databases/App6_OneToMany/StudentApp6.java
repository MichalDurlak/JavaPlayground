package pl.michaldurlak.JavaPlayground.databases.App6_OneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Student6_App6")
public class StudentApp6 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // AUTO - AUTOMATYCZNIE DODAJE +1
    // IDENTITY - BAZA AUTOMATYCZNIE DBA O TO ZEBY WARTOŚĆ BYŁA INDYWIDUALNA
    // SEQUENCE - NA PODSTAWIE SEKWENCJI W BAZIE DANYCH. MOŻEMY TAKĄ SEKWENCJE NAPISAĆ (np. zwiększanie o 2)
    //NUMEROWANIE ZACZYNA SIĘ OD 1
    private int id;
    private String loginStudent;

    public StudentApp6(String loginStudent) {
        this.loginStudent = loginStudent;
    }

    private StudentApp6(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginStudent() {
        return loginStudent;
    }

    public void setLoginStudent(String loginStudent) {
        this.loginStudent = loginStudent;
    }

    @Override
    public String toString() {
        return "StudentApp5{" +
                "id=" + id +
                ", loginStudent='" + loginStudent + '\'' +
                '}';
    }



}
