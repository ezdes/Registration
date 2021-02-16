package Registration;

import javax.swing.*;
import java.awt.event.*;

public class ConfirmFrame extends AbstractConfirm {

    public ConfirmFrame() {

        getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SignUpFrame.refresh();
                SignUpFrame.enableButton();
            }
        });

        getButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == getButton1()) {
                    confirm();
                }
            }
        });

        getButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resend();
            }
        });

    }

    @Override
    public void resend() {
        EmailSender.send();
    }

    @Override
    public void confirm() {
        if (EmailSender.checkCode(getTf1().getText())) {
            getFrame().dispose();
            JOptionPane.showMessageDialog(null, "Successfully signed up!");
            UserDb.insert();
            SignUpFrame.close();
            getFrame().dispose();
            new SignInFrame();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect code!", "Error", JOptionPane.ERROR_MESSAGE);
            getTf1().setText("");

        }
    }
}
