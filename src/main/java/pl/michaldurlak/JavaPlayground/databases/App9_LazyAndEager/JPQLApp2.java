package pl.michaldurlak.JavaPlayground.databases.App9_LazyAndEager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPQLApp2 {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaPlaygroundPersistence");

    static EntityManager entityManager_JPQL = factory.createEntityManager();


    public static void main(String[] args) {

        createUsers();

        entityManager_JPQL.createQuery("from JPQLUniversity2").getResultList().forEach(System.out::println);
    }

    private static void createUsers() {

        entityManager_JPQL.getTransaction().begin();
        JPQLStudent2 Tomek = entityManager_JPQL.merge(new JPQLStudent2("Tomek", "XYZ"));
        JPQLStudent2 Michal = entityManager_JPQL.merge(new JPQLStudent2("Michal", "ZYX"));
        JPQLUniversity2 university2 = entityManager_JPQL.merge(new JPQLUniversity2("TEST"));
        university2.addStudent(Tomek);
        university2.addStudent(Michal);
        entityManager_JPQL.merge(university2);
        entityManager_JPQL.getTransaction().commit();

    }
}
