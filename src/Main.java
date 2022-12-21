import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<DailyPlanner, Integer> planer = new HashMap<>();
        planer.put(new DailyPlanner("Курсовая", "Нужно сдать как можно скорее", Type.WORKED,
                Repeatability.SINGLE,
                LocalDate.of(2022, 12, 20)), 1);


        JOptionPane jOptionPane = new JOptionPane();
        try (Scanner scanner = new Scanner(System.in)) {
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
    }

    private static void inputTask(Map<DailyPlanner, Integer> planer) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        planer.put(new DailyPlanner(JOptionPane.showInputDialog(null, "Введите название"),
                        JOptionPane.showInputDialog(null, "Введите описание задачи"),
                        Type.WORKED,
                        Repeatability.SINGLE,
                        LocalDate.parse(JOptionPane.showInputDialog(null,
                                "Введите дату"), dateTimeFormatter)),
                Integer.valueOf(JOptionPane.showInputDialog(null, "Введите номер задания")));
        JOptionPane.showMessageDialog(null,"Задание успешео добавлено в ваш календарь" +
                "");

    }


}