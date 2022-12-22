import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Main {


    public static void main(String[] args) throws IOException {
        Map<DailyPlanner, CountId> planer = new HashMap<>();
        planer.put(new DailyPlanner("Курсовая", "Нужно сдать как можно скорее", Type.WORKED,
                Repeatability.SINGLE,
                LocalDate.of(2022, 12, 20)), new CountId());
        FileInputStream fileInputStream = new FileInputStream("F:\\new package17");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.close();

        JOptionPane.showMessageDialog(null, "Вас приветствует планировщик задач.",
                "Добро пожаловть.", JOptionPane.INFORMATION_MESSAGE);

        createPanel(planer);

    }

    public static void createPanel(Map<DailyPlanner, CountId> planer) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Выберите пункт меню");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        JButton jButton1 = new JButton("Добавить задачу");
        JButton jButton2 = new JButton("Удалить задачи");
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

                try {
                    DailyPlanner.inputTask(planer);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DailyPlanner.delete(planer);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
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
                try {
                    print(planer);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR!!!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void print(Map<DailyPlanner, CountId> planer) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileInputStream = new FileInputStream(JOptionPane.showInputDialog(null,
                    "Введите название файла"));

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            planer = (Map<DailyPlanner, CountId>) objectInputStream.readObject();
            for (Map.Entry<DailyPlanner, CountId> entry : planer.entrySet()) {
                JOptionPane.showMessageDialog(null, entry);
                objectInputStream.close();
            }
        } catch (NullPointerException n) {

        }


    }
}