package pl.michaldurlak.JavaPlayground.databases.App8_JPQL;

import javax.persistence.*;
import java.util.List;


public class JPQLApp1 {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("JavaPlaygroundPersistence");

    static EntityManager entityManager_JPQL = factory.createEntityManager();


    public static void main(String[] args) {

        createData();

//        entityManager_JPQL.createQuery("from JPQLStudent1").getResultList().forEach(System.out::println);
//        entityManager_JPQL.createQuery("SELECT s FROM JPQLStudent1 s").getResultList().forEach(System.out::println);
//        entityManager_JPQL.createQuery("SELECT s.studentName FROM JPQLStudent1 s").getResultList().forEach(System.out::println);
//        entityManager_JPQL.createQuery("SELECT s.studentName FROM JPQLStudent1 s WHERE s.studentName LIKE '%An%'").getResultList().forEach(System.out::println);
//        entityManager_JPQL.createQuery("SELECT s.studentName FROM JPQLStudent1 s WHERE s.studentName = 'Tomek'").getResultList().forEach(System.out::println);

//        List<JPQLStudent1> resultList = entityManager_JPQL.createQuery("SELECT s.studentName FROM JPQLStudent1 s", JPQLStudent1.class).getResultList();

        // Parametryzacja zapytań w JPQL
//        TypedQuery<JPQLStudent1> query = entityManager_JPQL.createQuery("SELECT s.studentName FROM JPQLStudent1 s WHERE s.studentName = :studentNameQuery",JPQLStudent1.class);
//        query.setParameter("studentNameQuery","Andrzej");
//        System.out.println(query.getSingleResult());

        // Zwracanie konkretnego wyniku
        TypedQuery<QueryResult> query = entityManager_JPQL.createQuery("SELECT new pl.michaldurlak.JavaPlayground.databases.App8_JPQL.QueryResult(s.studentName, s.indeks) FROM JPQLStudent1 s", QueryResult.class);
        query.getResultList().forEach(System.out::println);

        System.out.println("--------------");

        List<CountResult> resultList = entityManager_JPQL.createQuery("SELECT new pl.michaldurlak.JavaPlayground.databases.App8_JPQL.CountResult(s.studentName, COUNT(s)) FROM JPQLStudent1 s GROUP BY s.studentName", CountResult.class).getResultList();
        resultList.forEach(System.out::println);

        System.out.println("--------------");

        List<CountResult> resultList1 = entityManager_JPQL.createQuery("SELECT new pl.michaldurlak.JavaPlayground.databases.App8_JPQL.CountResult(s.studentName, COUNT(s)) FROM JPQLStudent1 s GROUP BY s.studentName HAVING s.studentName LIKE 'A%'", CountResult.class).getResultList();
        resultList1.forEach(System.out::println);

        System.out.println("--------------");
        List<CountResult> resultList2 = entityManager_JPQL.createQuery("SELECT new pl.michaldurlak.JavaPlayground.databases.App8_JPQL.CountResult(s.studentName, COUNT(s)) FROM JPQLStudent1 s GROUP BY s.studentName ORDER BY s.studentName", CountResult.class).getResultList();
        resultList2.forEach(System.out::println);

        // named queries
        // ustalamy zapytanie w encji a poniżej tak je wywołujemy z dowolonego kodu
        entityManager_JPQL.createNamedQuery("Student.getAll",JPQLStudent1.class).getResultList().forEach(System.out::println);

        entityManager_JPQL.createNamedQuery("Student.byName",JPQLStudent1.class).setParameter("name","Tomek").getResultList().forEach(System.out::println);

    }

    private static void createData() {

        entityManager_JPQL.getTransaction().begin();
        JPQLStudent1 andrzej = new JPQLStudent1("Andrzej","123");
        JPQLStudent1 tomek = new JPQLStudent1("Tomek","321");
        JPQLStudent1 andrzej2 = new JPQLStudent1("Andrzej","1234");
        JPQLStudent1 tomek3 = new JPQLStudent1("Tomek","3216");
        entityManager_JPQL.merge(andrzej);
        entityManager_JPQL.merge(tomek);
        entityManager_JPQL.merge(andrzej2);
        entityManager_JPQL.merge(tomek3);
        entityManager_JPQL.getTransaction().commit();

    }

}
