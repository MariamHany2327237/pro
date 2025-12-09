
package Pages.GameOver;

import Pages.ChooseL.S.ChooseLS;
import Pages.Home.HomePage;
import javax.sound.sampled.Clip;
import java.awt.event.WindowEvent;
import static Core.GameUtils.playMusic;
import Pages.Choose_Player.ChoosePlayer;
import java.awt.Color;

public class GameOver extends javax.swing.JFrame {
    static Clip voice;

    public GameOver() {
        initComponents();
        setLocationRelativeTo(null);
        if (voice == null) voice = playMusic("src/Assets/lose.wav", false);
        if (HomePage.voice != null) HomePage.voice.stop();
    }

   
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        Restart = new javax.swing.JButton();
        Menu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        Restart.setFont(new java.awt.Font("Segoe UI", 0, 24));
        Restart.setBackground(new Color(0, 0, 128));
        Restart.setForeground(Color.WHITE);

        Restart.setText("Restart");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed();
            }
        });

        Menu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
         Menu.setBackground(new Color(0, 0, 128));
        Menu.setForeground(Color.WHITE);

        Menu.setText("Back to Menu");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed();
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("src\\Assets\\lose.png"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Restart, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Restart, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RestartActionPerformed() {
        new ChooseLS().setVisible(true);
    }

    private void MenuActionPerformed() {
        this.dispose();
        new ChoosePlayer().setVisible(true);
    }

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new GameOver().setVisible(true));
    }

  
    private javax.swing.JButton Menu;
    private javax.swing.JButton Restart;
    private javax.swing.JLabel jLabel2;
   
    public void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            voice.stop();
            new HomePage().setVisible(true);
            HomePage.voice.start();
        }
    }
}