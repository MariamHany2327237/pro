package Pages.ChooseL.S;

import Map1.single.Map1_S;
import Map2.Single.Map2_S;
import Pages.Home.HomePage;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class ChooseLS extends JFrame {

    public static boolean enable2 = true;
    public static boolean enable3 = false;
    public static boolean enable4 = true;
    public static void main(String[] args) {
        new ChooseLS();
    }

    public ChooseLS() {
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
        level2.setBackground(new Color(0, 0, 128));
                level2.setForeground(Color.WHITE);


        level2.addActionListener(evt -> level2ActionPerformed());
        getContentPane().add(level2);
        level2.setBounds(225, 120, 150, 40);
        level2.setEnabled(enable2);



        GLCanvas glcanvas;
        Animator animator;

        ChooseLSGlEventListener listener = new ChooseLSGlEventListener();
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
        new Map1_S().setVisible(true);
    }

    private void level2ActionPerformed() {
        this.dispose();
        new Map2_S().setVisible(true);
    }



    public void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            new HomePage().setVisible(true);
        }
    }

}
