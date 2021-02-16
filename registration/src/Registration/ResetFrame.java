package Registration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResetFrame {
    private static JFrame frame;
    private static JPasswordField tf1;
    private static JPasswordField tf2;
    private static JLabel l1;
    private static JLabel l2;
    private static JLabel l3;
    private static JCheckBox box1;
    private static JCheckBox box2;
    private static JButton button;
    public ResetFrame() {
        frame = new JFrame();
        frame.setTitle("New Password");
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SignInFrame.refresh();
                SignInFrame.enableAll();
            }
        });

        l1 = new JLabel();
        l1.setBounds(120, 20, 300, 50);
        l1.setFont(new Font("SERIF", Font.BOLD, 40));
        l1.setText("New Password");
        frame.add(l1);

        l2 = new JLabel();
        l2.setBounds(40, 144, 160, 30);
        l2.setFont(new Font("SERIF", Font.BOLD, 17));
        l2.setText("Password:");
        frame.add(l2);

        tf1 = new JPasswordField();
        frame.add(tf1);
        tf1.setBounds(120, 140, 250, 40);
        tf1.setFont(new Font("SERIF", Font.BOLD, 17));
        tf1.setBorder(null);
        tf1.setVisible(true);

        box1 = new JCheckBox("Show");
        frame.add(box1);
        box1.setBounds(379, 135, 80, 50);
        box1.setBorder(null);
        box1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (box1.isSelected()) tf1.setEchoChar((char) 0);

                else tf1.setEchoChar('•');
            }
        });


        l3 = new JLabel();
        frame.add(l3);
        l3.setBounds(40, 234, 160, 30);
        l3.setFont(new Font("SERIF", Font.BOLD, 17));
        l3.setText("Password:");

        tf2 = new JPasswordField();
        frame.add(tf2);
        tf2.setBounds(120, 230, 250, 40);
        tf2.setFont(new Font("SERIF", Font.BOLD, 17));
        tf2.setBorder(null);
        tf2.setVisible(true);

        box2 = new JCheckBox("Show");
        frame.add(box2);
        box2.setBounds(379, 225, 80, 50);
        box2.setBorder(null);
        box2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (box2.isSelected()) tf2.setEchoChar((char) 0);

                else tf2.setEchoChar('•');
            }
        });

        button = new JButton("Change");
        frame.add(button);
        button.setBounds(197, 320, 90, 40);
        button.setFont(new Font("SERIF", Font.BOLD, 23));
        button.setBackground(Color.ORANGE);
        button.setFocusPainted(false);
        button.setBorder(null);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    if (String.valueOf(tf1.getPassword()).equals(String.valueOf(tf2.getPassword())) && String.valueOf(tf1.getPassword()).length() > 8) {
                        UserDb.change();
                        SignInFrame.enableAll();
                        SignInFrame.refresh();
                        JOptionPane.showMessageDialog(null, "Successfully changed password!");
                        frame.dispose();
                    }

                    else {
                        JOptionPane.showMessageDialog(null, "Passwords do not match or not strong password!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public static void close() {
        frame.dispose();
    }

    public static JPasswordField getTf1() {
        return tf1;
    }

    public static void setTf1(JPasswordField tf1) {
        ResetFrame.tf1 = tf1;
    }


}
