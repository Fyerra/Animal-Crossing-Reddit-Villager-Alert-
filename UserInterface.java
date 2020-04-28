import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JFrame {

    JTextField field, field2;
    JButton button;
    JTextArea area;
    static String str;
    static String str2;
    static boolean bool = false;
    static JButton start;
    static JTextField begin;
    static JTextField end;
    static JTextArea ausgabe;

    public UserInterface() {

        JPanel middlePanel = new JPanel ();
        middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Area" ) );

        JPanel pan = new JPanel();
        JFrame fr = new JFrame();

        field = new JTextField("Villagername", 30);
        field2 = new JTextField("Refreshrate", 30);
        area = new JTextArea(3, 40);
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBounds(10, 11, 455, 249);


        setTitle("Animal Crossing - Villager Finder für Reddit");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        button = new JButton("Start");
        button.setVisible(true);
        button.setBounds(100, 100, 200, 50);

        pan.add(field);
        pan.add(field2);
        pan.add(area);
        pan.add(scrollPane);
        pan.add(button);
        add(pan);

        area.setRows(5);
        area.setColumns(25);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                field.setText(JOptionPane.showInputDialog("Bitte hier Name des gesuchten Bewohners eingeben."));
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
                field2.setText(JOptionPane.showInputDialog("Zeit zwischen Prüfungen eingeben (in Sekunden, mindestens 10)."));
                str2 = field2.getText();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

  /*      button = new JButton("Start/Stop");
        pan.add(button);
        button.setBounds(240, 100, 60, 40);
        button.setVisible(true); */
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bool = !bool;
                if (bool == false) {
                    area.append("Stopp\r\n");
                    button.setText("Start");
                }
                else {
                    area.append("Start\r\n");
                    button.setText("Stopp");
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

    public JTextArea getArea() {
        return area;
    }
//    public JButton getButton() {
//        return button;
//    }

    public boolean getBool() {
        return bool;
    }

}
