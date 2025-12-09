/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages.User;

import Map2.Single.Map2ListenerS;
import Pages.ChooseL.S.ChooseLS;
import Pages.Choose_Player.ChoosePlayer;
import Pages.Home.HomePage;
import java.awt.Color;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class userNameSingle extends javax.swing.JFrame {

    public userNameSingle() {

        initComponents();
        setLocationRelativeTo(null);
    }

    public void processWindowEvent(final WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            this.dispose();
            new HomePage().setVisible(true);
        }
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

        DoneBTN = new javax.swing.JButton();
        BackBTN = new javax.swing.JButton();
        Player = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        getContentPane().setBackground(new java.awt.Color(0, 0, 0));

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

        Player.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        Player.setText("Player ");


        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DoneBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BackBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Player, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Player, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(DoneBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(BackBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBTNActionPerformed() {
        this.dispose();
        new ChoosePlayer().setVisible(true);
    }


    private void DoneBTNActionPerformed() throws IOException {
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter your name", "Player", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            boolean flag = false;
            Scanner input = new Scanner(new File("UsersList.txt"));
            while (input.hasNext()) {
                String nameInText = jTextField1.getText();
                String nameInUser = input.nextLine();
                nameInUser = nameInUser.substring(0, nameInUser.indexOf(' ') == -1 ? nameInUser.length() : nameInUser.indexOf(' '));

                if (nameInText.equals(nameInUser)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                SaveUser(jTextField1.getText() + " ");
                // For Now
                Map2ListenerS.userName = jTextField1.getText();
                //Map1Listener.userName= Map2ListenerS.userName= Map3Listener.userName= Map4Listener.userName= Map5Listener.userName = jTextField1.getText();

            }
        } catch (IOException e) {
        }
        this.dispose();
        new ChooseLS().setVisible(true);

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
            java.util.logging.Logger.getLogger(userNameSingle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userNameSingle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userNameSingle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userNameSingle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new userNameSingle().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBTN;
    private javax.swing.JButton DoneBTN;
    private javax.swing.JLabel Player;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}