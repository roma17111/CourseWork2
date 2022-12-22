import javax.print.DocFlavor;
import java.io.Serializable;
import java.util.Objects;

public class CountId implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Integer count = 1;
    private final Integer id;

    public CountId() {
        this.id = count++;
    }

    public static Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountId countId = (CountId) o;
        return id.equals(countId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "id задачи - " + id;
    }
}
