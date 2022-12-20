import java.time.LocalDate;
import java.time.LocalDateTime;

public enum Repeatability {


    SINGLE("Однократная"),
    DAILY("Ежедневная"),
    WEEKLY("Еженедельная"),
    MONTHLY("Еженедельная"),
    ANNUAL("Ежегодная");

    private String nameR;

    Repeatability(String nameR) {
        this.nameR = nameR;
    }

    public String getNameR() {
        return nameR;
    }

    public static void checkRepeat(Repeatability repeatability) {
        if (repeatability == SINGLE) {
            System.out.println("Повторяемость однократная");
        }
        if (repeatability == DAILY) {
            System.out.println("Следующее повторение - " + LocalDateTime.now().plusDays(1));
        } if (repeatability == WEEKLY) {
            System.out.println("Следующее повторение - " + LocalDateTime.now().plusDays(7));
        } if (repeatability == MONTHLY) {
            System.out.println("Следующее повторение - " + LocalDateTime.now().plusMonths(1));
        } if (repeatability == ANNUAL) {
            System.out.println("Следующее повторение - " + LocalDateTime.now().plusYears(1));
        }
    }


}
