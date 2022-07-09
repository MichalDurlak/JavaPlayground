package pl.michaldurlak.JavaPlayground.databases.App8_JPQL;

public class CountResult {

    private String name;
    private long count;

    public CountResult(String name, long count) {
        this.name = name;
        this.count = count;
    }

    public CountResult(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountResult{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
