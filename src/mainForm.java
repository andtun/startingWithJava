import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainForm {
    int progress = 0;
    String curAlg;
    String CUR_ALG_TEXT = "Работаем над ";

    private JPanel panel1;
    private JButton btn;
    private JProgressBar pbr;
    private JLabel workingOn;
    private JTextField numField;
    private JCheckBox includeStupid;

    TimeTracker[] getAlgs() {
        if (includeStupid.isSelected()) {
            return new TimeTracker[]{
                    new TimeTracker(new Sort.CountingSort(), "countingsort"),
                    new TimeTracker(new Sort.CombSort(), "combsort"),
                    new TimeTracker(new Sort.InsertionSort(), "insertionsort"),
                    new TimeTracker(new Sort.GnomeSortYulia(), "gnomesort"),
                    new TimeTracker(new Sort.CombSortYulia(), "yuliacomb"),
                    new TimeTracker(new Sort.InsertionSortYulia(), "yuliainsertion"),
                    new TimeTracker(new Sort.InsertionSort(), "inserionsort"),
                    new TimeTracker(new Sort.quicksort(), "quicksort"),
                    new TimeTracker(new Sort.bubblesort(), "bubblesort"),
                    new TimeTracker(new Sort.PyramidSort(), "pyramidsort"),
                    new TimeTracker(new Sort.StupidSort(), "stupidsort"),
            };
        }
        else {
            return new TimeTracker[]{
                    new TimeTracker(new Sort.CountingSort(), "countingsort"),
                    new TimeTracker(new Sort.CombSort(), "combsort"),
                    new TimeTracker(new Sort.InsertionSort(), "insertionsort"),
                    new TimeTracker(new Sort.GnomeSortYulia(), "gnomesort"),
                    new TimeTracker(new Sort.CombSortYulia(), "yuliacomb"),
                    new TimeTracker(new Sort.InsertionSortYulia(), "yuliainsertion"),
                    new TimeTracker(new Sort.InsertionSort(), "inserionsort"),
                    new TimeTracker(new Sort.quicksort(), "quicksort"),
                    new TimeTracker(new Sort.bubblesort(), "bubblesort"),
                    new TimeTracker(new Sort.PyramidSort(), "pyramidsort"),
            };
        }
    }

    void alert(String text) {
        JOptionPane.showMessageDialog(null, text, text, JOptionPane.INFORMATION_MESSAGE);
    }

    void alert(String heading, String text) {
        JOptionPane.showMessageDialog(null, text, heading, JOptionPane.INFORMATION_MESSAGE);
    }

    int getSize() {
        try {
            return Integer.parseInt(numField.getText());
        }
        catch (Exception e) {
            return -1;
        }
    }

    public mainForm() {
        numField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                pbr.setValue(0);
                workingOn.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    progress = 0;
                    curAlg = "";
                    testAll(getSize());
                }
                catch (Exception ex) {
                    alert("Ошибка!!!");
                }
            }
        });
    }


    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setContentPane(new mainForm().panel1);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private void testAll(int n) {
        // create a list
        int[] list = new int[n];
        // fill the list
        ArrayTools.fill.random(list, 10000);

        TimeTracker[] algs = getAlgs();
        pbr.setMaximum(algs.length);

        Thread mainThread = new Thread(() -> { // main thread
            try {
                for (TimeTracker track : algs) {
                    workingOn.setText("Работаем над: " + track.name);
                    curAlg = CUR_ALG_TEXT + track.name;
                    track.sort(list);
                    progress += 1;
                }
                TimeTracker best = RunDat.minResult(algs);
                alert("Лучший результат", "Самый быстрый алгоритм - " + best.name + "\nРезультат: " + Double.toString(best.result));
                Thread.sleep(1);

            }
            catch (Exception interrupt) {
                alert(interrupt.getMessage());
            }
        });

        mainThread.start();

        Thread changesListener = new Thread(() -> {
            try {
                while (progress <= pbr.getMaximum()) {
                    pbr.setValue(progress);
                    workingOn.setText(curAlg);
                    Thread.sleep(1);
                }
            }

            catch (Exception e) {
                alert(e.getMessage());
            }
        });

        changesListener.start();

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
