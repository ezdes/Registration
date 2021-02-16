package Registration;

import Snake.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignInFrame {

    private static JFrame frame;

    private static JTextField tf1;
    private static JPasswordField tf2;

    private static JLabel label1;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static JLabel label5;
    private static JLabel label6;

    private static JButton button1;
    private static JButton button2;
    private static JButton button3;
    private static JCheckBox checkBox;

    private static String email;

    public SignInFrame() {
        frame = new JFrame();
        frame.setSize(500, 450);
        frame.setTitle("Registration");
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        label1 = new JLabel();
        frame.add(label1);
        label1.setBounds(194, 20, 160, 50);
        label1.setFont(new Font("SERIF", Font.BOLD, 40));
        label1.setText("Sign in");

        label2 = new JLabel();
        frame.add(label2);
        label2.setBounds(60, 144, 160, 30);
        label2.setFont(new Font("SERIF", Font.BOLD, 17));
        label2.setText("Email:");

        tf1 = new JTextField();
        frame.add(tf1);
        tf1.setBounds(120, 140, 250, 40);
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
                tf1.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' ||
                        e.getKeyCode() == 8 || e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z'
                        || e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z' || e.getKeyCode() == 33 ||
                        e.getKeyCode() == 35 || e.getKeyCode() == 36 || e.getKeyCode() == 37 ||
                        e.getKeyCode() == 38 || e.getKeyCode() == 39 || e.getKeyCode() == 42 ||
                        e.getKeyCode() == 43 || e.getKeyCode() == 45 || e.getKeyCode() == 47 ||
                        e.getKeyCode() == 61 || e.getKeyCode() == 63 || e.getKeyCode() == 94 ||
                        e.getKeyCode() == 95 || e.getKeyCode() == 96);

            }
        });

        label3 = new JLabel();
        frame.add(label3);
        label3.setBounds(370, 144, 160, 30);
        label3.setFont(new Font("SERIF", Font.BOLD, 17));
        label3.setText("@gmail.com");

        label4 = new JLabel();
        frame.add(label4);

        label4.setBounds(35, 234, 160, 30);
        label4.setFont(new Font("SERIF", Font.BOLD, 17));
        label4.setText("Password:");

        tf2 = new JPasswordField();
        frame.add(tf2);
        tf2.setBounds(120, 230, 250, 40);
        tf2.setFont(new Font("SERIF", Font.BOLD, 17));
        tf2.setBorder(null);

        checkBox = new JCheckBox("Show");
        frame.add(checkBox);
        checkBox.setBounds(373, 226, 80, 50);
        checkBox.setBackground(Color.LIGHT_GRAY);
        checkBox.setBorder(null);
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox.isSelected()) tf2.setEchoChar((char) 0);

                else tf2.setEchoChar('•');
            }
        });

        button1 = new JButton("Sign in");
        frame.add(button1);
        button1.setBounds(197, 320, 90, 40);
        button1.setFont(new Font("SERIF", Font.BOLD, 23));
        button1.setBackground(Color.ORANGE);
        button1.setFocusPainted(false);
        button1.setBorder(null);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() ==  button1) {
                    if (UserDb.check()){
                        JOptionPane.showMessageDialog(null, "Successfully signed in!");
                        new GameFrame();
                        frame.dispose();
                    }

                    else {
                        JOptionPane.showMessageDialog(null, "1.Be careful! Make sure that you entered correct data.\n" +
                                "5. Wrong email or password", "Wrong data!", JOptionPane.ERROR_MESSAGE);
                        refresh();
                    }
                }
            }
        });

        label5 = new JLabel();
        frame.add(label5);
        label5.setBounds(315, 280, 200, 30);
        label5.setFont(new Font("SERIF", Font.BOLD, 17));
        label5.setText("Don't have an account?");

        button2 = new JButton("Sign up");
        frame.add(button2);
        button2.setBounds(350, 320, 90, 40);
        button2.setFont(new Font("SERIF", Font.BOLD, 23));
        button2.setBackground(Color.ORANGE);
        button2.setFocusPainted(false);
        button2.setBorder(null);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button2) {
                    frame.dispose();
                    new SignUpFrame();
                }
            }
        });

        label6 = new JLabel();
        frame.add(label6);
        label6.setBounds(30, 280, 200, 30);
        label6.setFont(new Font("SERIF", Font.BOLD, 17));
        label6.setText("Forgot password?");

        button3 = new JButton("Reset");
        frame.add(button3);
        button3.setBounds(54, 320, 90, 40);
        button3.setFont(new Font("SERIF", Font.BOLD, 23));
        button3.setBackground(Color.ORANGE);
        button3.setFocusPainted(false);
        button3.setBorder(null);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button3) {
                    email = JOptionPane.showInputDialog("Enter email:");
                    if (UserDb.isExistEmail()) {
                        EmailSender.send(email);
                        System.out.println(30);
                        new ConfirmFrameForReset();
                        disableAll();
                    }
                    else {
                        if (email != null)
                            JOptionPane.showMessageDialog(null, "1.Be careful! Make sure that you entered correct data.\n" +
                                    "5. This email doesn't exist in our database!", "Wrong data!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
    public static void refresh() {
        tf1.setText("");
        tf2.setText("");
    }

    public static void disableAll() {
        tf1.setEnabled(false);
        tf2.setEnabled(false);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        checkBox.setEnabled(false);
    }

    public static void enableAll() {
        tf1.setEnabled(true);
        tf2.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        checkBox.setEnabled(true);
    }

    public static String getEmail() {
        return email;
    }

    public static JTextField getTf1() {
        return tf1;
    }

    public static JPasswordField getTf2() {
        return tf2;
    }
}
