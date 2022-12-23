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
        File[] files = new File[20];
        files[0] = new File("ячейка1");
        files[1] = new File("ячейка2");
        files[2] = new File("ячейка3");
        files[3] = new File("ячейка4");
        files[4] = new File("ячейка5");
        files[5] = new File("ячейка6");
        files[6] = new File("ячейка7");
        files[7] = new File("ячейка8");
        files[8] = new File("ячейка9");
        files[9] = new File("ячейка10");
        files[10] = new File("ячейка11");
        files[11] = new File("ячейка12");
        files[12] = new File("ячейка13");
        files[13] = new File("ячейка14");
        files[14] = new File("ячейка15");
        files[15] = new File("ячейка16");
        files[16] = new File("ячейка17");
        files[17] = new File("ячейка18");
        files[18] = new File("ячейка19");
        files[19] = new File("ячейка20");
        Map<DailyPlanner, CountId> planer = new HashMap<>();
        planer.put(new DailyPlanner("Курсовая", "Нужно сдать как можно скорее", Type.WORKED,
                Repeatability.SINGLE,
                LocalDate.of(2022, 12, 20)), new CountId());
        FileInputStream fileInputStream = new FileInputStream("F:\\new package17");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.close();

        JOptionPane.showMessageDialog(null, "Вас приветствует планировщик задач.",
                "Добро пожаловть.", JOptionPane.INFORMATION_MESSAGE);

        createPanel(planer,files);

    }

    public static void createPanel(Map<DailyPlanner, CountId> planer,File[] files) {
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
                    DailyPlanner.inputTask(planer,files);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DailyPlanner.delete(planer,files);
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
                    print(planer,files);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR!!!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void print(Map<DailyPlanner, CountId> planer,File[] files) throws IOException, ClassNotFoundException {
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
            FileInputStream fileInputStream = new FileInputStream((File) JOptionPane.showInputDialog(null,
                    "Выберите ячейку","Файл",JOptionPane.INFORMATION_MESSAGE,icon,files,files[0]));

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