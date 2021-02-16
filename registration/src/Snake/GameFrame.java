package Snake;

import javax.swing.*;

public class GameFrame  {

    private static JFrame frame;

    public GameFrame(){
        frame = new JFrame();
        frame.add(new GamePanel());
        frame.setTitle("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void close(){
        frame.dispose();
    }
}
