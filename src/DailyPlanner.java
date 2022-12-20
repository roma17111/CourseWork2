import java.time.LocalDate;

public class DailyPlanner {

    private final String heading;
    private  String description;
    private boolean taskType;
    private final LocalDate date;

    public DailyPlanner(String heading, String description, boolean taskType, LocalDate date) {
        this.heading = heading;
        this.description = description;
        this.taskType = taskType;
        this.date = date;
    }
}
