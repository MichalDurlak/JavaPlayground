package pl.michaldurlak.JavaPlayground.databases.App4_Embeddable_OneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class jpaApp4 {

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

        // Ustawienie indeksu dla nowego studenta
        entityManager.getTransaction().begin();
        StudentApp4 michal = new StudentApp4(3,"Michal");
        IndeksOneToOne michalIndeks = new IndeksOneToOne(3,123456);
        entityManager.merge(michal);
        entityManager.merge(michalIndeks);
        michal.setIndeksOneToOne(michalIndeks);
        michal = entityManager.merge(michal);
        entityManager.getTransaction().commit();

        System.out.println(michal);

        entityManager.getTransaction().begin();
        michalIndeks.setOwner(michal);
        entityManager.merge(michalIndeks);
        entityManager.getTransaction().commit();

        IndeksOneToOne ownerOfIndeks = entityManager.find(IndeksOneToOne.class, 3);
        System.out.println(ownerOfIndeks);
    }

    private static void deleteStudent() {

        StudentApp4 studentApp4 = entityManager.find(StudentApp4.class, 1);

        entityManager.getTransaction().begin();
        entityManager.remove(studentApp4);
        entityManager.getTransaction().commit();
    }

    private static void updateStudent() {

        StudentApp4 kinga = new StudentApp4(1,"Kinga");
        entityManager.getTransaction().begin();
        entityManager.persist(kinga);
        entityManager.getTransaction().commit();

        // szukanie i przypisanie do zmiennej Studenta o id 1
        StudentApp4 studentApp4 = entityManager.find(StudentApp4.class, 1);
        studentApp4.setTelephone("12345678"); // przypisanie studentowi numeru telefonu

        // rozpoczecie transakcji polegajacej na zaktualizowaniu informacji o numerze telefonu
        entityManager.getTransaction().begin();
        entityManager.merge(studentApp4); // jesli nie ma danego studenta w bazie to go tworzy
        entityManager.getTransaction().commit();
    }

    private static void readStudents() {

        // zapytanie o konkretnego studenta
        StudentApp4 student = entityManager.find(StudentApp4.class, 0);
        System.out.println(student);

        // zapytanie o wszystkich studentow
        List from_studentTable_app4 = entityManager.createQuery("from StudentTable_App4").getResultList();

        from_studentTable_app4.forEach(System.out::println);
    }

    private static void createStudent() {


        StudentApp4 pawel = new StudentApp4(0,"Pawel");

        // jpa nie zawsze wysyla od razu zapytanie do bazy, czasami trzyma sobie w cache'u
        // aby to wymusić należy zapakować zapytanie w transakcje begin a pozniej commit
        entityManager.getTransaction().begin();
        entityManager.persist(pawel); //zapisanie do bazy danych
        entityManager.getTransaction().commit();
        // wszystko opakowane w transakcje musi się wykonać. Jeśli zostanie zwrócony wyjątek całą transakcja cofa się i nie dochodzą do skutku

    }

}
