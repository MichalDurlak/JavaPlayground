package pl.michaldurlak.JavaPlayground.databases.App7_ManytoMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaApp7 {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaPlaygroundPersistence");

    static EntityManager entityManager = factory.createEntityManager();


    public static void main(String[] args) {

    }
}
