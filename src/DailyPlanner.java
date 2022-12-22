import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Objects;

public class DailyPlanner {


    private final String heading;
    private String description;
    private final Type taskType;
    private LocalDate localDate;
    private Repeatability repeatability;

    public DailyPlanner(String heading,
                        String description,
                        Type taskType,
                        Repeatability repeatability,
                        LocalDate localDate) {
        if (heading == null) {
            throw new IllegalArgumentException("Добавьте название!!!");
        } else {
            this.heading = heading;
        }
        setDescription(description);
        if (taskType == null) {
            throw new IllegalArgumentException("Тип задачи не указан!!!");
        } else {
            this.taskType = taskType;
        }
        setLocalDate(localDate);
        setRepeatability(repeatability);
    }


    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Описание не заполнено");
        } else {
            this.description = description;
        }

    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Type getTaskType() {
        return taskType;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Repeatability repeatability) {
        if (repeatability == null) {
            throw new IllegalArgumentException("Введите повторяемость!!!");
        } else {
            this.repeatability = repeatability;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyPlanner that = (DailyPlanner) o;
        return heading.equals(that.heading) && description.equals(that.description) && taskType == that.taskType && localDate.equals(that.localDate) && repeatability == that.repeatability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(heading, description, taskType, localDate, repeatability);
    }

    @Override
    public String toString() {
        return "Задача -" + "\n" +
                "Название - " + heading + '\n' +
                "Описание - " + description + '\n' +
                "Тип - " + taskType.getType() + '\n' +
                "Дата - " + localDate + '\n' +
                "Частота повторений - " + repeatability.getNameR() + "\n"
                ;
    }

    public static void createDaily() {


    }

    public static void getDailyPlan(Map<DailyPlanner, Integer> planer) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(JOptionPane.showInputDialog(null, "Введите дату"),
                    dateTimeFormatter);
            for (DailyPlanner planner : planer.keySet()) {
                if (planner.getLocalDate().equals(date)) {
                    JOptionPane.showMessageDialog(null, "задача" + planner);
                }
                if (!planner.getLocalDate().equals(date)) {
                    JOptionPane.showMessageDialog(null, "Нет задач на текущую дату -" + date);
                }
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Введены некорректные данные");
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Введены некорректные данные");
        }

    }

    public static void delete(Map<DailyPlanner, Integer> planer) {

        Integer num = Integer.valueOf(JOptionPane.showInputDialog(null,
                "Введите номер(значение) задачи"));
        for (Map.Entry<DailyPlanner, Integer> entry : planer.entrySet()) {
            if (num == entry.getValue()) {
                planer.remove(entry, num);
            }
        }
        JOptionPane.showMessageDialog(null, planer);

    }

    public static void inputTask(Map<DailyPlanner, Integer> planer) {

        try {


            Icon icon = new Icon() {
                @Override
                public void paintIcon(Component c, Graphics g, int x, int y) {

                }

                @Override
                public int getIconWidth() {
                    return 0;
                }

                @Override
                public int getIconHeight() {
                    return 0;
                }
            };
            Repeatability[] repeatabilities = {Repeatability.SINGLE,
                    Repeatability.DAILY,
                    Repeatability.WEEKLY,
                    Repeatability.MONTHLY,
                    Repeatability.ANNUAL};
            Type[] types = {Type.PERSONAL, Type.WORKED};
            DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            planer.put(new DailyPlanner(JOptionPane.showInputDialog(null, "Введите название"),
                            JOptionPane.showInputDialog(null, "Введите описание задачи"),
                            Type.valueOf(String.valueOf(JOptionPane.showInputDialog(null,
                                    "Введите тип задачи: \n" +
                                            "  WORKED(\"Рабочая\"),\n" +
                                            "    PERSONAL(\"Личная\")", "Тип задачи",
                                    JOptionPane.INFORMATION_MESSAGE, icon, types, types[0]))),
                            Repeatability.valueOf(String.valueOf(JOptionPane.showInputDialog(null,
                                    "Введите повторяемость для задачи: \n" +
                                            "SINGLE(\"Однократная\")\n" +
                                            "    DAILY(\"Ежедневная\")\n" +
                                            "    WEEKLY(\"Еженедельная\")\n" +
                                            "    MONTHLY(\"Еженедельная\")\n" +
                                            "    ANNUAL(\"Ежегодная\")", "Повторяемость задачи", JOptionPane.INFORMATION_MESSAGE, icon,
                                    repeatabilities, repeatabilities[0]
                            ))),
                            LocalDate.parse(JOptionPane.showInputDialog(null,
                                    "Введите дату \n" +
                                            "В формате (чч.мм.гггг)"), dateTimeFormatter1)),
                    Integer.valueOf(JOptionPane.showInputDialog(null, "Введите номер задания")));
            JOptionPane.showMessageDialog(null, "Задание успешео добавлено в ваш календарь: \n" +
                    "Список всех задач:  \n" +
                    planer);

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Введена некорректная дата!!!",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Введены некорректные данные!!!",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException i) {
            JOptionPane.showMessageDialog(null, "Введены некорректные данные!!!",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}





