import java.util.List;

public class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id;
        return hash;
    }
}