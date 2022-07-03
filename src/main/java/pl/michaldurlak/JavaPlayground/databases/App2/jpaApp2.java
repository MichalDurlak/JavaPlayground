package pl.michaldurlak.JavaPlayground.databases.App2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaApp2 {

    // java persistent api -> standard interfejsów które wspierają z pracą z baza danych
    // jesli aplikacja chce działać z baza danych to APLIKACJA komunikuje się z JPA a następnie JPA komunikuje sie z BAZĄ DANYCH
    // trzeba myslec jako osobna aplikacja
    // JPA posiada cache, ktory nie zawsze zwraca dane z bazy danych

    public static void main(String[] args) {

        //persistenceUnitName -> wpisujemy nazwe z persistence.xml
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaPlaygroundPersistence");

        // klasa ktora odpowiada za jednorazowe polaczenie z baza danych
        EntityManager entityManager = factory.createEntityManager();



    }
}
