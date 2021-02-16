package Snake;

import Registration.SignInFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    private static final int DELAY = 80;
    private int[] x = new int[GAME_UNITS];
    private int[] y = new int[GAME_UNITS];
    private int bodyParts = 6;
    private int applesEaten;
    private int appleX;
    private int appleY;
    private char direction = 'R';
    private boolean running;
    private Timer timer;
    private Random random;
    private JButton restartButton;
    private JButton exitButton;
    private JButton button;

    GamePanel() {
        exitButton = new JButton("Exit");
        restartButton = new JButton("Restart");
        button = new JButton("Log out");
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if (running) {
            //to draw matrix
//            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
//                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
//                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
//            }


            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);


            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                } else {
                    g.setColor(new Color(45, 180, 0));
                }
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }


            g.setColor(Color.RED);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, 50);
        } else {

            gameOver(g);
        }
    }

    public void newApple() {


        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

    }

    public void move() {

        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {

            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;

            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;


            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;


            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {

        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {

        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }

            if (x[0] < 0) {
                running = false;
            }

            if (x[0] > SCREEN_WIDTH) {
                running = false;
            }

            if (y[0] < 0) {
                running = false;
            }

            if (y[0] > SCREEN_HEIGHT) {
                running = false;
            }

            if (!running) {
                timer.stop();
            }
        }
    }


    public void gameOver(Graphics g) {

        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics1.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);


        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics2.stringWidth("Score: " + applesEaten)) / 2, 50);

        button.setFocusPainted(false);
        button.setFont(new Font("Ink Free", Font.BOLD, 20));
        button.setBorder(new LineBorder(Color.BLACK));
        button.setBackground(Color.RED);
        button.setBounds((SCREEN_WIDTH - 500) / 2, SCREEN_HEIGHT - 100, 120, 45);
        this.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    GameFrame.close();
                    new SignInFrame();
                }
            }
        });

        restartButton.setFocusPainted(false);
        restartButton.setFont(new Font("Ink Free", Font.BOLD, 20));
        restartButton.setBorder(new LineBorder(Color.BLACK));
        restartButton.setBackground(Color.RED);
        restartButton.setBounds((SCREEN_WIDTH - 120) / 2, SCREEN_HEIGHT - 100, 120, 45);
        this.add(restartButton);


        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == restartButton) {
                    GameFrame.close();
                    new GameFrame();
                }
            }
        });


        exitButton.setFocusPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setFont(new Font("Ink Free", Font.BOLD, 20));
        exitButton.setBorder(new LineBorder(Color.BLACK));
        exitButton.setBackground(Color.RED);
        exitButton.setBounds((SCREEN_WIDTH - 120) / 2, SCREEN_HEIGHT - 50, 120, 45);
        this.add(exitButton);


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == exitButton) {
                    System.exit(0);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();

    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;

                case KeyEvent.VK_S:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;


                case KeyEvent.VK_D:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;


                case KeyEvent.VK_A:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
            }
        }
    }
}
