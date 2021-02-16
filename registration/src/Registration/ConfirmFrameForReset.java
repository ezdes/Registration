package Registration;
import javax.swing.*;
import java.awt.event.*;

public class ConfirmFrameForReset extends AbstractConfirm {


    public ConfirmFrameForReset() {

        getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                SignInFrame.enableAll();
                SignInFrame.refresh();
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
        EmailSender.send(SignInFrame.getEmail());
    }

    @Override
    public void confirm() {
        if (EmailSender.checkCode(getTf1().getText())) {
            getFrame().dispose();
            JOptionPane.showMessageDialog(null, "Successfully confirmed!");
            new ResetFrame();
        }

        else {
            JOptionPane.showMessageDialog(null, "Incorrect code!", "Error", JOptionPane.ERROR_MESSAGE);
            getTf1().setText("");
        }
    }
}
