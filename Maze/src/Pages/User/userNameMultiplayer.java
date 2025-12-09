
package Pages.User;

import Map2.Multi.Map2ListenerM;
import Pages.ChooseL.M.ChooseLM;
import Pages.Choose_Player.ChoosePlayer;
import Pages.Home.HomePage;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static Pages.Home.HomePage.voice;
import java.awt.Color;

public class userNameMultiplayer extends javax.swing.JFrame {

    public userNameMultiplayer() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void SaveUser(String s) {

        try (FileWriter f = new FileWriter("UsersList.txt", true);
             BufferedWriter b = new BufferedWriter(f);
             PrintWriter p = new PrintWriter(b);) {
            p.println(s + " ");
            p.flush();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Player1Label = new javax.swing.JLabel();
        Player1TextField = new javax.swing.JTextField();
        DoneBTN = new javax.swing.JButton();
        BackBTN = new javax.swing.JButton();
        Player2Label = new javax.swing.JLabel();
        Player2TextField = new javax.swing.JTextField();

        Player1Label.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        Player1Label.setText("Player 1");

        Player1TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //Player1TextFieldActionPerformed(evt);
            }
        });

        DoneBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
          DoneBTN.setBackground(new Color(0, 0, 128));
        DoneBTN.setForeground(Color.WHITE);
        DoneBTN.setText("Play");
        DoneBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    DoneBTNActionPerformed();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        BackBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
          BackBTN.setBackground(new Color(0, 0, 128));
        BackBTN.setForeground(Color.WHITE);
        BackBTN.setText("Back");
        BackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBTNActionPerformed();
            }
        });

        Player2Label.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        Player2Label.setText("Player 2");

        Player2TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //Player2TextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(Player1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Player2Label)
                .addGap(114, 114, 114))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(Player1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(Player2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DoneBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Player1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Player2Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Player1TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(Player2TextField))
                .addGap(33, 33, 33)
                .addComponent(DoneBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BackBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DoneBTNActionPerformed() throws IOException{

        if (Player2TextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Player 2 Name : ", "Player", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (Player1TextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Player 1 Name : ", "Player", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            boolean flag = false;
            Scanner input = new Scanner(new File("UsersList.txt"));
            while (input.hasNext()) {
                String nameInText = Player1TextField.getText();
                String nameInUser = input.nextLine();
                nameInUser = nameInUser.substring(0, nameInUser.indexOf(' ') == -1 ? nameInUser.length() : nameInUser.indexOf( ' '));

                if (nameInText.equals(nameInUser)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                SaveUser(Player2TextField.getText()+ " ");
                SaveUser(Player1TextField.getText()+ " ");
                 // For Now
                Map2ListenerM.userName1 = Player1TextField.getText();
                Map2ListenerM.userName2 = Player2TextField.getText();
            }
        } catch (IOException e) {
        }

        this.dispose();
        new ChooseLM().setVisible(true);
    }

    private void BackBTNActionPerformed() {
        this.dispose();
        new ChoosePlayer().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(userNameMultiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userNameMultiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userNameMultiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userNameMultiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new userNameMultiplayer().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBTN;
    private javax.swing.JButton DoneBTN;
    private javax.swing.JLabel Player1Label;
    private javax.swing.JTextField Player1TextField;
    private javax.swing.JLabel Player2Label;
    private javax.swing.JTextField Player2TextField;
    // End of variables declaration//GEN-END:variables

    public void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            voice.stop();
            new HomePage().setVisible(true);
            if(voice!=null){
            voice.start();
            } 
            else{
                voice.stop();
            }
        }
    }
}