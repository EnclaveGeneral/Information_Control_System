/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages;

/**
 *
 * @author godpo
 */
public class AbortOrProceed extends javax.swing.JFrame {

    /**
     * Creates new form AbortOrProceed
     */
    public AbortOrProceed() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PageTitle = new javax.swing.JLabel();
        NoButton = new javax.swing.JButton();
        YesButton = new javax.swing.JButton();
        BackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(750, 920));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PageTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        PageTitle.setForeground(new java.awt.Color(255, 255, 255));
        PageTitle.setText("Do You Wish To Close This Page?");
        jPanel1.add(PageTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 94, -1, 60));

        NoButton.setBackground(new java.awt.Color(0, 0, 204));
        NoButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        NoButton.setForeground(new java.awt.Color(204, 0, 0));
        NoButton.setText("Negative");
        jPanel1.add(NoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 140, 45));

        YesButton.setBackground(new java.awt.Color(0, 0, 204));
        YesButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        YesButton.setForeground(new java.awt.Color(0, 204, 51));
        YesButton.setText("Affirmative");
        YesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesButtonActionPerformed(evt);
            }
        });
        jPanel1.add(YesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 140, 45));

        BackGround.setIcon(new javax.swing.ImageIcon("P:\\Coding Files\\EnclaveLibrary\\LibraryManagement\\src\\main\\java\\VisualFiles\\EncaveLogo.jpg")); // NOI18N
        jPanel1.add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 920));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesButtonActionPerformed
        
    }//GEN-LAST:event_YesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AbortOrProceed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbortOrProceed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbortOrProceed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbortOrProceed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbortOrProceed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private javax.swing.JButton NoButton;
    private javax.swing.JLabel PageTitle;
    private javax.swing.JButton YesButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}