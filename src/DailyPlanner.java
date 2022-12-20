import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class DailyPlanner {

    private int id;

    private static int count = 1;

    private final String heading;
    private String description;
    private final Type taskType;
    private final LocalDateTime localDateTime;
    private Repeatability repeatability;

    public DailyPlanner(String heading,
                        String description,
                        Type taskType,
                        Repeatability repeatability) {
        if (heading == null) {
            throw new IllegalArgumentException("Добавьте название!!!");
        }else {
            this.heading = heading;
        }
        this.id = count++;
        this.description = description;
        this.taskType = taskType;
        this.localDateTime = LocalDateTime.now();
        this.repeatability = repeatability;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        DailyPlanner.count = count;
    }

    public Type getTaskType() {
        return taskType;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Repeatability repeatability) {
        this.repeatability = repeatability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyPlanner that = (DailyPlanner) o;
        return taskType == that.taskType && heading.equals(that.heading) && description.equals(that.description) && localDateTime.equals(that.localDateTime) && repeatability == that.repeatability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(heading, description, taskType, localDateTime, repeatability);
    }

    @Override
    public String toString() {
        return "DailyPlanner{" +
                id +
                "heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                ", taskType=" + taskType +
                ", localDateTime=" + localDateTime +
                ", repeatability=" + repeatability +
                '}';
    }
}
