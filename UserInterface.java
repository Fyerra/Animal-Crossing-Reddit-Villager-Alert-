import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class UserInterface extends JFrame {



    JTextField field, field2;
    JButton button;
    static String str;
    static String str2;
    static boolean bool = false;
    public UserInterface() {

        JPanel pan = new JPanel();
        JFrame fr = new JFrame();

        field = new JTextField("Villagername", 30);
        field2 = new JTextField("Refreshrate", 30);


        setTitle("Animal Crossing - Villager Finder für Reddit");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pan.add(field);
        pan.add(field2);
        add(pan);

        field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                field.setText(JOptionPane.showInputDialog("please enter value"));
                str = field.getText();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        field2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                field2.setText(JOptionPane.showInputDialog("please enter value"));
                str2 = field2.getText();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        button = new JButton("Start/Stop");
        pan.add(button);
        button.setBounds(240, 100, 60, 40);
        button.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bool = !bool;
                if (bool == false) {
                    System.out.println("Stopp");
                }
                else {
                    System.out.println("Start");
                }
            }
        });


    }

    public void main(String[] args) {

    }

    public String getTextVil() {
        if (str == null) {
            str = field.getText();
        }
        return str;
    }

    public int getTextS() {
         int s = Integer.parseInt(str2);
         return s;
    }

//    public JButton getButton() {
//        return button;
//    }

    public boolean getBool() {
        return bool;
    }
}
