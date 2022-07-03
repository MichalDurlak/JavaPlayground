package pl.michaldurlak.JavaPlayground.databases.App1;

import pl.michaldurlak.JavaPlayground.databases.App1.domain.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // stworzenie tabeli STUDENT
        createTableForStudent();

        // stworzenie dwóch studentów na bazie klasy Student
        Student student1 = new Student(1,"Pawel");
        Student student2 = new Student(2,"Dawid");


        // wrzucenie studentów do bazy danych
        insertStudent(student1);
        insertStudent(student2);

        // odczyt studentow z bazy danych
        List<Student> studentList = getStudents();

        studentList.forEach(System.out::println);

    }

    private static void createTableForStudent() throws SQLException, ClassNotFoundException {
        Connection connection = H2Configuration.getDBConnection();

        // zwroci obiekt statment dzieki ktoremu mozemy wykonywac na bazie danych SQLe (surowe zapytania do bazy)
        Statement statement = connection.createStatement();

        // polecenie na utworzenie tabeli student wraz z polami id oraz name
        String createTable = "CREATE TABLE STUDENT(id int primary key,name varchar(255))";

        // wyslanie polecenia do wykonania
        statement.execute(createTable);

        connection.commit();

    }

    private static void insertStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection = H2Configuration.getDBConnection();

        // zwroci obiekt statment dzieki ktoremu mozemy wykonywac na bazie danych SQLe (surowe zapytania do bazy)
        Statement statement = connection.createStatement();

        // pobranie z klasy student id oraz name i wrzucenie tego do bazy
        String insert = "INSERT INTO STUDENT VALUES( "+student.getId()+", \'"+student.getName()+"\')";

        // wyslanie polecenia do wykonania
        statement.execute(insert);

        connection.commit();

    }

    private static List<Student> getStudents() throws SQLException, ClassNotFoundException {

        List<Student> tempList = new ArrayList<Student>();

        Connection connection = H2Configuration.getDBConnection();

        // zwroci obiekt statment dzieki ktoremu mozemy wykonywac na bazie danych SQLe (surowe zapytania do bazy)
        Statement statement = connection.createStatement();

        // pobranie z klasy student id oraz name i wrzucenie tego do bazy

        ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT");

        while (resultSet.next()){

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            tempList.add(new Student(id, name));

        }

        connection.commit();

        return tempList;

    }
}
