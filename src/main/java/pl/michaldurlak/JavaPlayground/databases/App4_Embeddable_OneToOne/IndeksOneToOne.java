package pl.michaldurlak.JavaPlayground.databases.App4_Embeddable_OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class IndeksOneToOne {

    @Id
    private int id;

    private int indeks;

    //RELACJA DWUKIERUNKOWA mapowanie "zwrotne" aby miec informacje o studencie
    @OneToOne(mappedBy =  "indeksOneToOne" ) //podajemy indeks z klasy gdzie jest przypieta w tym wypadku studentapp4
    private StudentApp4 owner;

    public IndeksOneToOne(int id, int indeks, StudentApp4 owner) {
        this.id = id;
        this.indeks = indeks;
        this.owner = owner;
    }

    public IndeksOneToOne(int id, int indeks) {
        this.id = id;
        this.indeks = indeks;
    }

    private IndeksOneToOne() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    @Override
    public String toString() {
        return "IndeksOneToOne{" +
                "id=" + id +
                ", indeks=" + indeks +
                ", studentApp4=" + owner +
                '}';
    }

    public StudentApp4 getOwner() {
        return owner;
    }

    public void setOwner(StudentApp4 owner) {
        this.owner = owner;
    }
}
