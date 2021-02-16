package Registration;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractConfirm {
    private static JFrame frame;
    private static JLabel label1;
    private static JLabel label2;
    private static JTextField tf1;
    private static JButton button1;
    private static JButton button2;

    public AbstractConfirm() {
        frame = new JFrame();
        frame.setTitle("Confirm your email");
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        label1 = new JLabel();
        label1.setText("We sent code to your email.");
        label1.setBounds(30, 15, 300, 90);
        label1.setFont(new Font("SERIF", Font.BOLD, 25));
        frame.add(label1);

        label2 = new JLabel();
        label2.setText("Enter code:");
        label2.setBounds(20, 123, 120, 30);
        label2.setFont(new Font("SERIF", Font.BOLD, 17));
        frame.add(label2);

        tf1 = new JTextField();
        tf1.setBounds(117, 125, 120, 30);
        tf1.setFont(new Font("SERIF", Font.BOLD, 17));
        tf1.setBorder(null);
        tf1.setDocument(new JTextFieldLimit(4));
        tf1.setVisible(true);
        frame.add(tf1);

        button1 = new JButton("Confirm");
        button1.setBounds(133, 220, 90, 30);
        button1.setFont(new Font("SERIF", Font.BOLD, 23));
        button1.setBackground(Color.ORANGE);
        button1.setFocusPainted(false);
        button1.setBorder(null);
        frame.add(button1);

        button2 = new JButton("Resend");
        button2.setBounds(20, 220, 90, 30);
        button2.setFont(new Font("SERIF", Font.BOLD, 23));
        button2.setBackground(Color.ORANGE);
        button2.setFocusPainted(false);
        button2.setBorder(null);
        frame.add(button2);
    }

    public abstract void resend();

    public abstract void confirm();

    public static JButton getButton1() {
        return button1;
    }

    public static JButton getButton2() {
        return button2;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        AbstractConfirm.frame = frame;
    }

    public static JTextField getTf1() {
        return tf1;
    }

    public static void setTf1(JTextField tf1) {
        AbstractConfirm.tf1 = tf1;
    }
}
