import java.time.LocalDate;
import java.util.Objects;

public class DailyPlanner {

    private final String heading;
    private  String description;
    private final boolean taskType;
    private final LocalDate date;
    private Repeatability repeatability;

    public DailyPlanner(String heading, String description, boolean taskType, LocalDate date, Repeatability repeatability) {
        this.heading = heading;
        this.description = description;
        this.taskType = taskType;
        this.date = date;
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

    public boolean isTaskType() {
        return taskType;
    }

    public LocalDate getDate() {
        return date;
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
        return taskType == that.taskType && heading.equals(that.heading) && description.equals(that.description) && date.equals(that.date) && repeatability == that.repeatability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(heading, description, taskType, date, repeatability);
    }

    @Override
    public String toString() {
        return "DailyPlanner{" +
                "heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                ", taskType=" + taskType +
                ", date=" + date +
                ", repeatability=" + repeatability +
                '}';
    }
}
