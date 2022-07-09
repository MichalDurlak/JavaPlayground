package pl.michaldurlak.JavaPlayground.databases.App8_JPQL;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Student.getAll", query = "SELECT s FROM JPQLStudent1 s"),
        @NamedQuery(name = "Student.byName", query = "SELECT s FROM JPQLStudent1 s WHERE s.studentName = :name")
})

public class JPQLStudent1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String studentName;
    private String indeks;

    public JPQLStudent1(String studentName, String indeks) {
        this.studentName = studentName;
        this.indeks = indeks;
    }


    private JPQLStudent1(){

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "JPQLStudent1{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", indeks='" + indeks + '\'' +
                '}';
    }
}
