package Pages.ChooseL.M;

import Map1.multi.Map1_M;
import Map2.Multi.Map2_M;
import Pages.Home.HomePage;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ChooseLM extends JFrame {

    public static void main(String[] args) {
        new ChooseLM();
    }

    public ChooseLM() {
        JButton level1 = new JButton();
        JButton level2 = new JButton();

        level1.setFont(new Font("Maiden Orange", Font.PLAIN, 32)); // NOI18N
        level1.setText("Level 1");
        level1.setBackground(new Color(0, 0, 128));
         level1.setForeground(Color.WHITE);


        level1.addActionListener(evt -> level1ActionPerformed());
        getContentPane().add(level1);
        level1.setBounds(225, 70, 150, 40);

        level2.setFont(new Font("Maiden Orange", Font.PLAIN, 32)); // NOI18N
        level2.setText("Level 2");
        level2.setBackground(new  Color(0, 0, 128));
        level2.setForeground(Color.WHITE);

        level2.addActionListener(evt -> level2ActionPerformed());
        getContentPane().add(level2);
        level2.setBounds(225, 120, 150, 40);



        GLCanvas glcanvas;
        Animator animator;

        ChooseLMGlEventListener listener = new ChooseLMGlEventListener();
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

    private void level1ActionPerformed() {
        this.dispose();
        new Map1_M().setVisible(true);
    }

    private void level2ActionPerformed() {
        this.dispose();
        new Map2_M().setVisible(true);
    }



    public void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            new HomePage().setVisible(true);
        }
    }

}