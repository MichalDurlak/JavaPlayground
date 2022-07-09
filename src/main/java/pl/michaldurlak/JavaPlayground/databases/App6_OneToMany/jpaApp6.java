package pl.michaldurlak.JavaPlayground.databases.App6_OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaApp6 {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaPlaygroundPersistence");

    static EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {




        //stworzenie studentów
        entityManager.getTransaction().begin();
        StudentApp6 michalStudent = new StudentApp6("Michal");
        StudentApp6 pawelStudent = new StudentApp6("Pawel");
        entityManager.merge(michalStudent);
        entityManager.merge(pawelStudent);
        entityManager.getTransaction().commit();







//         dodanie do listy studentow
        entityManager.getTransaction().begin();
        UniversityApp6 ug = entityManager.merge(new UniversityApp6("UG"));
        ug.addStuddent(michalStudent);
        ug.addStuddent(pawelStudent);
        entityManager.getTransaction().commit();

        UniversityApp6 universityApp6 = entityManager.find(UniversityApp6.class, 1);
        System.out.println(universityApp6);

//        StudentApp6 studentWithID1 = entityManager.find(StudentApp6.class, 1);
//        StudentApp6 studentWithID2 = entityManager.find(StudentApp6.class, 2);
//        System.out.println(studentWithID1);
//        System.out.println(studentWithID2);

    }

}
