package pl.michaldurlak.JavaPlayground.databases.App8_JPQL;

public class QueryResult {

    private String studentName;
    private String indeksNumber;

    public QueryResult(String studentName, String indeksNumber) {
        this.studentName = studentName;
        this.indeksNumber = indeksNumber;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "studentName='" + studentName + '\'' +
                ", indeksNumber='" + indeksNumber + '\'' +
                '}';
    }

    public String getStudentName() {
        return studentName;
    }

    public String getIndeksNumber() {
        return indeksNumber;
    }
}
