import javax.swing.*;
import javax.swing.text.html.Option;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JOptionPane.showMessageDialog(null, "Вас приветствует планировщик задач.",
                "Добро пожаловть.", JOptionPane.INFORMATION_MESSAGE);
        createPanel(planer);

    }

    public static void createPanel(Map<DailyPlanner, Integer> planer) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Выберите пункт меню");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        JButton jButton1 = new JButton("Добавить задачу");
        JButton jButton2 = new JButton("Удалить задачу");
        JButton jButton3 = new JButton("Получить задачу на указанный день");
        JButton jButton4 = new JButton("Получить список всех задач");
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        jPanel.setSize(270, 180);
        jPanel.setVisible(true);
        frame.getContentPane().add(jPanel);
        frame.setPreferredSize(new Dimension(270, 180));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DailyPlanner.inputTask(planer);

            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DailyPlanner.delete(planer);
            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DailyPlanner.getDailyPlan(planer);
            }
        });
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, planer);
            }
        });
    }
}