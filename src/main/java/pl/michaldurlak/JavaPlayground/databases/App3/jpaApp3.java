package pl.michaldurlak.JavaPlayground.databases.App3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class jpaApp3 {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaPlaygroundPersistence");

    static EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {

        // CRUD -> skrot od Create, Read, Update, Delete

        //Create
        createStudent();

        //Read
        readStudents();

        //Update
        updateStudent();

        //Delete
        deleteStudent();
    }

    private static void deleteStudent() {

        StudentApp3 studentApp3 = entityManager.find(StudentApp3.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(studentApp3);
        entityManager.getTransaction().commit();
    }

    private static void updateStudent() {

        StudentApp3 kinga = new StudentApp3(1,"Kinga");
        entityManager.getTransaction().begin();
        entityManager.persist(kinga);
        entityManager.getTransaction().commit();

        // szukanie i przypisanie do zmiennej Studenta o id 1
        StudentApp3 studentApp3 = entityManager.find(StudentApp3.class, 1);
        studentApp3.setTelephone("12345678"); // przypisanie studentowi numeru telefonu

        // rozpoczecie transakcji polegajacej na zaktualizowaniu informacji o numerze telefonu
        entityManager.getTransaction().begin();
        entityManager.merge(studentApp3); // jesli nie ma danego studenta w bazie to go tworzy
        entityManager.getTransaction().commit();
    }

    private static void readStudents() {

        // zapytanie o konkretnego studenta
        StudentApp3 student = entityManager.find(StudentApp3.class, 0);
        System.out.println(student);

        // zapytanie o wszystkich studentow
        List from_studentTable_app3 = entityManager.createQuery("from StudentTable_App3").getResultList();

        from_studentTable_app3.forEach(System.out::println);
    }

    private static void createStudent() {


        StudentApp3 pawel = new StudentApp3(0,"Pawel");

        // jpa nie zawsze wysyla od razu zapytanie do bazy, czasami trzyma sobie w cache'u
        // aby to wymusić należy zapakować zapytanie w transakcje begin a pozniej commit
        entityManager.getTransaction().begin();
        entityManager.persist(pawel); //zapisanie do bazy danych
        entityManager.getTransaction().commit();
        // wszystko opakowane w transakcje musi się wykonać. Jeśli zostanie zwrócony wyjątek całą transakcja cofa się i nie dochodzą do skutku

    }
}
