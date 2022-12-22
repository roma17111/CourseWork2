import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<DailyPlanner, Integer> planer = new HashMap<>();
        planer.put(new DailyPlanner("Курсовая", "Нужно сдать как можно скорее", Type.WORKED,
                Repeatability.SINGLE,
                LocalDate.of(2022, 12, 20)), 1);


            label:
            while (true) {
                int menu = Integer.parseInt(JOptionPane.showInputDialog(null,

                        "1. Добавить задачу" + '\n' +
                                "2. Удалить задачу" + '\n' +
                                "3. Получить задачу на указанный день" + '\n' +
                                "0. Выход"));
                ;
                switch (menu) {
                    case 1:
                        inputTask(planer);
                        break;
                    case 2:
                        DailyPlanner.delete(planer);
                        break;
                    case 3:
                        DailyPlanner.getDailyPlan(planer);
                        break;
                    case 0:
                        break label;
                }
            }

    }

    public static void inputTask(Map<DailyPlanner, Integer> planer) {
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        planer.put(new DailyPlanner(JOptionPane.showInputDialog(null, "Введите название"),
                        JOptionPane.showInputDialog(null, "Введите описание задачи"),
                        Type.valueOf(JOptionPane.showInputDialog(null,"Введите тип задачи: \n" +
                                "  WORKED(\"Рабочая\"),\n" +
                                "    PERSONAL(\"Личная\")")),
                        Repeatability.valueOf(JOptionPane.showInputDialog(null,
                                "Введите повторяемость задачи: \n" +
                                        " SINGLE(\"Однократная\")\n" +
                                        "    DAILY(\"Ежедневная\")\n" +
                                        "    WEEKLY(\"Еженедельная\")\n" +
                                        "    MONTHLY(\"Еженедельная\")\n" +
                                        "    ANNUAL(\"Ежегодная\")")),
                        LocalDate.parse(JOptionPane.showInputDialog(null,
                                "Введите дату"), dateTimeFormatter1)),
                Integer.valueOf(JOptionPane.showInputDialog(null, "Введите номер задания")));
        JOptionPane.showMessageDialog(null,"Задание успешео добавлено в ваш календарь: \n"  +
                planer);

    }


}