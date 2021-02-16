package Registration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpFrame {
    private static JFrame frame;

    private static JTextField tf1;
    private static JTextField tf2;
    private static JTextField tf3;
    private static JTextField tf4;
    private static JPasswordField tf5;

    private static JLabel label1;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static JLabel label5;
    private static JLabel label6;
    private static JLabel label7;
    private static JLabel label8;
    private static JLabel label9;

    private static JComboBox box1;
    private static JComboBox box2;
    private static JComboBox box3;

    private static JButton button1;
    private static JButton button2;
    private JCheckBox checkbox;
    private static JButton button3;

    private static String numbers[] = {
            "770", "771", "773", "774", "775",
            "776", "777", "778", "779", "220",
            "221", "222", "223", "224", "225",
            "226", "227", "550", "551", "552",
            "553", "554", "555", "556", "557",
            "558", "559", "755", "999", "990",
            "700", "701", "702", "703", "704",
            "705", "706", "707", "708", "709",
            "500", "501", "502", "503", "504",
            "505", "506", "507", "508", "509"
    };

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020", "2021" };

    public SignUpFrame() {
        frame = new JFrame();
        frame.setSize(660, 600);
        frame.setTitle("Registration");
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        label1 = new JLabel();
        frame.add(label1);
        label1.setBounds(270, 20, 160, 50);
        label1.setFont(new Font("SERIF", Font.BOLD, 40));
        label1.setText("Sign up");

        label2 = new JLabel();
        frame.add(label2);
        label2.setBounds(30, 153, 160, 30);
        label2.setFont(new Font("SERIF", Font.BOLD, 17));
        label2.setText("Name:");

        tf1 = new JTextField();
        frame.add(tf1);
        tf1.setBounds(90, 150, 160, 40);
        tf1.setFont(new Font("SERIF", Font.BOLD, 17));
        tf1.setBorder(null);
        tf1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf1.setEditable(e.getButton() == MouseEvent.BUTTON1);
            }
        });
        tf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf1.setEditable(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z' || e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z' || e.getKeyCode() == 8);
            }
        });

        label3 = new JLabel();
        frame.add(label3);
        label3.setBounds(327, 153, 160, 30);
        label3.setFont(new Font("SERIF", Font.BOLD, 17));
        label3.setText("Surname:");

        tf2 = new JTextField();
        frame.add(tf2);
        tf2.setBounds(410, 150, 160, 40);
        tf2.setFont(new Font("SERIF", Font.BOLD, 17));
        tf2.setBorder(null);
        tf2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf2.setEditable(e.getButton() == MouseEvent.BUTTON1);
            }
        });
        tf2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf2.setEditable(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z' || e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z' || e.getKeyCode() == 8);
            }
        });

        label4 = new JLabel();
        frame.add(label4);
        label4.setBounds(49, 254, 160, 30);
        label4.setFont(new Font("SERIF", Font.BOLD, 17));
        label4.setText("+996");

        tf3 = new JTextField();
        frame.add(tf3);
        tf3.setBounds(90, 250, 160, 40);
        tf3.setFont(new Font("SERIF", Font.BOLD, 17));
        tf3.setBorder(null);
        tf3.setDocument(new JTextFieldLimit(9));
        tf3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf3.setEditable(e.getButton() == MouseEvent.BUTTON1);
            }
        });
        tf3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf3.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyCode() == 8);
            }
        });

        box1 = new JComboBox(dates);
        frame.add(box1);
        box1.setBounds(410, 250, 50, 40);
        box1.setFont(new Font("SERIF", Font.BOLD, 17));
        box1.setBorder(null);

        box2 = new JComboBox(months);
        frame.add(box2);
        box2.setBounds(460, 250, 60, 40);
        box2.setFont(new Font("SERIF", Font.BOLD, 17));
        box2.setBorder(null);

        label5 = new JLabel();
        frame.add(label5);
        label5.setBounds(319, 253, 160, 30);
        label5.setFont(new Font("SERIF", Font.BOLD, 17));
        label5.setText("Birth date:");

        box3 = new JComboBox(years);
        frame.add(box3);
        box3.setBounds(520, 250, 65, 40);
        box3.setFont(new Font("SERIF", Font.BOLD, 17));
        box3.setBorder(null);

        label6 = new JLabel();
        frame.add(label6);
        label6.setBounds(190, 354, 160, 30);
        label6.setFont(new Font("SERIF", Font.BOLD, 17));
        label6.setText("Email:");

        tf4 = new JTextField();
        frame.add(tf4);
        tf4.setBounds(250, 350, 160, 40);
        tf4.setFont(new Font("SERIF", Font.BOLD, 17));
        tf4.setBorder(null);
        tf4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf4.setEditable(e.getButton() == MouseEvent.BUTTON1);
            }
        });
        tf4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf4.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' ||
                        e.getKeyCode() == 8 || e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z'
                        || e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z' || e.getKeyCode() == 33 ||
                        e.getKeyCode() == 35 || e.getKeyCode() == 36 || e.getKeyCode() == 37 ||
                        e.getKeyCode() == 38 || e.getKeyCode() == 39 || e.getKeyCode() == 42 ||
                        e.getKeyCode() == 43 || e.getKeyCode() == 45 || e.getKeyCode() == 47 ||
                        e.getKeyCode() == 61 || e.getKeyCode() == 63 || e.getKeyCode() == 94 ||
                        e.getKeyCode() == 95 || e.getKeyCode() == 96);

            }
        });

        label7 = new JLabel();
        frame.add(label7);
        label7.setBounds(415, 353, 160, 30);
        label7.setFont(new Font("SERIF", Font.BOLD, 17));
        label7.setText("@gmail.com");

        label8 = new JLabel();
        frame.add(label8);
        label8.setBounds(165, 424, 160, 30);
        label8.setFont(new Font("SERIF", Font.BOLD, 17));
        label8.setText("Password:");

        tf5 = new JPasswordField();
        frame.add(tf5);
        tf5.setBounds(250, 420, 160, 40);
        tf5.setFont(new Font("SERIF", Font.BOLD, 17));
        tf5.setBorder(null);
        frame.add(tf5);

        checkbox = new JCheckBox("Show");
        frame.add(checkbox);
        checkbox.setBounds(415, 412, 80, 50);
        checkbox.setBackground(Color.LIGHT_GRAY);
        checkbox.setBorder(null);
        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkbox.isSelected()) tf5.setEchoChar((char) 0);

                else tf5.setEchoChar('•');
            }
        });

        button1 = new JButton("Create");
        frame.add(button1);
        button1.setBounds(282, 500, 90, 40);
        button1.setFont(new Font("SERIF", Font.BOLD, 23));
        button1.setBackground(Color.ORANGE);
        button1.setFocusPainted(false);
        button1.setBorder(null);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() ==  button1) {

                    if (UserDb.isExist()) {

                        JOptionPane.showMessageDialog(null, "This email or phone number is already exist in database!", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    else {
                        if (check()) {
                            JOptionPane.showMessageDialog(null, "1.Be careful! Make sure that you entered correct data.\n" +
                                    "2. Name, Surname should not be empty.\n" +
                                    "3. Phone number length should be equal to 9.\n" +
                                    "4. Email should not be empty and its min length should be equal to 6.\n" +
                                    "5. Password should not be empty and its min length should be equal to \n" +
                                    "6. Phone number should be in oshka, megakom or beeline code! For example: 777123456", "Wrong data!", JOptionPane.ERROR_MESSAGE);

                            refresh();
                        } else {
                            EmailSender.send();
                            new ConfirmFrame();
                            disableButton();
                        }
                    }
                }
            }
        });

        label9 = new JLabel();
        frame.add(label9);
        label9.setBounds(440, 465, 200, 30);
        label9.setFont(new Font("SERIF", Font.BOLD, 17));
        label9.setText("Already have an account?");

        button2 = new JButton("Sign in");
        frame.add(button2);
        button2.setBounds(477, 500, 90, 40);
        button2.setFont(new Font("SERIF", Font.BOLD, 23));
        button2.setBackground(Color.ORANGE);
        button2.setFocusPainted(false);
        button2.setBorder(null);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button2) {
                    frame.dispose();
                    new SignInFrame();
                }
            }
        });

        button3 = new JButton("Refresh");
        frame.add(button3);
        button3.setBounds(100, 500, 90, 40);
        button3.setFont(new Font("SERIF", Font.BOLD, 23));
        button3.setBackground(Color.ORANGE);
        button3.setFocusPainted(false);
        button3.setBorder(null);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button3) {
                    refresh();
                }
            }
        });
    }



    public static void close() {
        frame.dispose();
    }

    public static void refresh() {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        box1.setSelectedIndex(0);
        box2.setSelectedIndex(0);
        box3.setSelectedIndex(0);
    }

    public static boolean check() {

        int count = 0;

        if (tf3.getText().length() > 3) {
            for (String number : numbers)
                if (tf3.getText().substring(0, 3).equals(number)) {
                    count++;
                }
        }

        else return true;


        if (count == 0) return true;

        return tf1.getText().equals("") || tf2.getText().equals("") || tf3.getText().equals("")
                || tf3.getText().length() < 9 || tf4.getText().equals("") || tf4.getText().length() < 6
                || tf5.getPassword().length < 8;
    }


    public static void disableButton() {
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        tf1.setEnabled(false);
        tf2.setEnabled(false);
        tf3.setEnabled(false);
        tf4.setEnabled(false);
        tf5.setEnabled(false);
        box1.setEnabled(false);
        box2.setEnabled(false);
        box3.setEnabled(false);
    }

    public static void enableButton() {
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        tf1.setEnabled(true);
        tf2.setEnabled(true);
        tf3.setEnabled(true);
        tf4.setEnabled(true);
        tf5.setEnabled(true);
        box1.setEnabled(true);
        box2.setEnabled(true);
        box3.setEnabled(true);
    }

    public static JTextField getTf1() {
        return tf1;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        SignUpFrame.frame = frame;
    }

    public static JTextField getTf2() {
        return tf2;
    }

    public static void setTf2(JTextField tf2) {
        SignUpFrame.tf2 = tf2;
    }

    public static JTextField getTf3() {
        return tf3;
    }

    public static void setTf3(JTextField tf3) {
        SignUpFrame.tf3 = tf3;
    }

    public static JTextField getTf4() {
        return tf4;
    }

    public static void setTf4(JTextField tf4) {
        SignUpFrame.tf4 = tf4;
    }

    public static JPasswordField getTf5() {
        return tf5;
    }

    public static void setTf5(JPasswordField tf5) {
        SignUpFrame.tf5 = tf5;
    }

    public static JComboBox getBox1() {
        return box1;
    }

    public static void setBox1(JComboBox box1) {
        SignUpFrame.box1 = box1;
    }

    public static JComboBox getBox2() {
        return box2;
    }

    public static void setBox2(JComboBox box2) {
        SignUpFrame.box2 = box2;
    }

    public static JComboBox getBox3() {
        return box3;
    }

    public static void setBox3(JComboBox box3) {
        SignUpFrame.box3 = box3;
    }
}
