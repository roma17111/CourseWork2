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
                printMenu();
                System.out.print("Выберите пункт меню: ");
                JOptionPane.showInputDialog(null,

                        "1. Добавить задачу" + '\n' +
                                "2. Удалить задачу" + '\n' +
                                "3. Получить задачу на указанный день" + '\n' +
                                "0. Выход");
                if (jOptionPane.getWantsInput()) {
                    int menu = Integer.parseInt(JOptionPane.showInputDialog(null,

                            "1. Добавить задачу" + '\n' +
                                    "2. Удалить задачу" + '\n' +
                                    "3. Получить задачу на указанный день" + '\n' +
                                    "0. Выход"));;
                    switch (menu) {
                        case 1:
                            inputTask();
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
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Map<DailyPlanner, Integer> planer ) {

    }

    private static void printMenu() {
        System.out.println(

                        "1. Добавить задачу" + '\n' +
                         "2. Удалить задачу" + '\n' +
                         "3. Получить задачу на указанный день" + '\n' +
                         "0. Выход"

        );
    }
}