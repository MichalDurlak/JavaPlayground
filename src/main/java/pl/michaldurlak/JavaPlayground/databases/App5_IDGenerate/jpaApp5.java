package pl.michaldurlak.JavaPlayground.databases.App5_IDGenerate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaApp5 {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaPlaygroundPersistence");

    static EntityManager entityManager = factory.createEntityManager();


    public static void main(String[] args) {

        entityManager.getTransaction().begin();
        StudentApp5 michalStudent = new StudentApp5("Michal");
        StudentApp5 michalStudent1 = new StudentApp5("Michal1");
        entityManager.merge(michalStudent);
        entityManager.merge(michalStudent1);
        entityManager.getTransaction().commit();

        StudentApp5 studentWithID1 = entityManager.find(StudentApp5.class, 1);
        StudentApp5 studentWithID2 = entityManager.find(StudentApp5.class, 2);
        System.out.println(studentWithID1);
        System.out.println(studentWithID2);

    }
}
