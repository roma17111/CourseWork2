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

    public LocalDate nextDate(LocalDate localDate) {
        Repeatability repeatability = null;
        if (repeatability == DAILY) {
           return localDate.plusDays(1);
        } if (repeatability == WEEKLY) {
            return localDate.plusDays(7);
        } if (repeatability == MONTHLY) {
            return localDate.plusMonths(1);
        } if (repeatability == ANNUAL) {
            return localDate.plusYears(1);
        }
        return null;
    }


}
