package Pages.Choose_Player;

import Pages.Home.HomePage;
import Pages.User.userNameMultiplayer;
import Pages.User.userNameSingle;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ChoosePlayer extends JFrame {

    public static void main(String[] args) {
        new ChoosePlayer();
    }

    public ChoosePlayer() {
        JButton single = new JButton();
        JButton multi = new JButton();
        JButton back = new JButton();

        single.setFont(new java.awt.Font("Maiden Orange", Font.PLAIN, 32)); // NOI18N
        single.setText("Single");
        single.setBackground(new Color(0, 0, 128));
        single.setForeground(Color.WHITE);

        single.addActionListener(evt -> singleActionPerformed());
        getContentPane().add(single);
        single.setBounds(110, 160, 180, 40);

        multi.setFont(new java.awt.Font("Maiden Orange", Font.PLAIN, 32)); // NOI18N
        multi.setText("Multi");
        multi.setBackground(new Color(0, 0, 128));
        multi.setForeground(Color.WHITE);
        multi.addActionListener(evt -> multiActionPerformed());
        getContentPane().add(multi);
        multi.setBounds(300, 160, 180, 40);

        back.setFont(new Font("Maiden Orange", Font.PLAIN, 32)); // NOI18N
        back.setText("Back");
        back.setBackground(new Color(0, 0, 128));
        back.setForeground(Color.WHITE);

        back.addActionListener(evt -> backActionPerformed());
        getContentPane().add(back);
        back.setBounds(225, 280, 150, 40);

        GLCanvas glcanvas;
        Animator animator;

        ChoosePlayerGlEventListener listener = new ChoosePlayerGlEventListener();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        animator = new FPSAnimator(24);
        animator.add(glcanvas);
        animator.start();

        setTitle("Maze");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }

    private void singleActionPerformed() {
         this.dispose();
        new userNameSingle().setVisible(true);
    }

    private void multiActionPerformed() {
         this.dispose();
        new userNameMultiplayer().setVisible(true);
    }

    private void backActionPerformed() {
        this.dispose();
        new HomePage().setVisible(true);
    }

    public void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            new HomePage().setVisible(true);
        }
    }

}