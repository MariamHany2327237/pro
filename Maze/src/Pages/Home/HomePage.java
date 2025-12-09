package Pages.Home;

import Pages.Choose_Player.ChoosePlayer;
import Pages.HowToPlay.HowToPlay;
import javax.media.opengl.GLCanvas;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import static Core.GameUtils.playMusic;

public class HomePage extends JFrame {
    public static Clip voice;

    public static void main(String[] args) {
        new HomePage();
    }

    public HomePage() {
        if (voice == null) voice = playMusic("src/Assets/home.wav", true);
        JButton Play = new JButton();
        JButton exit = new JButton();
        JButton help = new JButton();



        Play.setFont(new java.awt.Font("Maiden Orange", Font.PLAIN, 32)); // NOI18N
        Play.setText("Play");
        Play.setBackground(new Color(0, 0, 128));
        Play.setForeground(Color.WHITE);

        Play.addActionListener(evt -> startActionPerformed());
        getContentPane().add(Play);
        Play.setBounds(225, 220, 150, 40);

        help.setFont(new java.awt.Font("Maiden Orange", Font.PLAIN, 32)); // NOI18N
        help.setText("Help");
        help.setBackground(new Color(0, 0, 128));
        help.setForeground(Color.WHITE);

        help.addActionListener(evt -> helpActionPerformed());
        getContentPane().add(help);
        help.setBounds(30, 30, 170, 40);

        exit.setFont(new java.awt.Font("Maiden Orange", Font.PLAIN, 32)); // NOI18N
        exit.setText("Exit");
        exit.setBackground(new Color(0, 0, 128));
        exit.setForeground(Color.WHITE);

        exit.addActionListener(evt -> exitActionPerformed());
        getContentPane().add(exit);
        exit.setBounds(430, 30, 150, 40);

        GLCanvas glcanvas;


        HomePageGlEventListener listener = new HomePageGlEventListener();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);


        setTitle("Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }

    private void exitActionPerformed() {
        System.exit(0);
    }

    private void startActionPerformed() {
        this.dispose();
        new ChoosePlayer().setVisible(true);

    }

    private void helpActionPerformed() {
        this.dispose();
        new HowToPlay().setVisible(true);
    }
}
