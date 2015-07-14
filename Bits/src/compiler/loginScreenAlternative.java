package compiler;

import javax.swing.JOptionPane;

public class loginScreenAlternative extends javax.swing.JFrame {

    
    public loginScreenAlternative() {
        initComponents();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        usernameText = new javax.swing.JTextField();
        passwordVariable = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 728));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1366, 728));

        jPanel1.setLayout(null);

        loginButton.setFont(new java.awt.Font("Tekton Pro", 0, 20)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.setBorder(null);
        loginButton.setContentAreaFilled(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loginButton);
        loginButton.setBounds(1020, 457, 160, 30);

        usernameText.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        usernameText.setBorder(null);
        jPanel1.add(usernameText);
        usernameText.setBounds(1002, 266, 197, 17);

        passwordVariable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        passwordVariable.setBorder(null);
        jPanel1.add(passwordVariable);
        passwordVariable.setBounds(1002, 342, 197, 17);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compiler/images/login_screen_1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(1364, 703));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1364, 703);

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        
        String username = usernameText.getText();
        String password = passwordVariable.getText();
        //System.out.println(username);
        session S = new session(username,password);
        int validity = S.startSession();//for checking the status of login
        
        if(validity == -1){
            
            String str = "Sorry! Wrong Password.";
            JOptionPane.showMessageDialog(null, str);
        }
        else if(validity == -2){
            
            String str = "Sorry! Username Doesn't Exist.";
            JOptionPane.showMessageDialog(null, str);
        }
        else if(validity == 0){
            
            String str = "Connection Problem! Please Try Again.";
            JOptionPane.showMessageDialog(null, str);
        }
        else{
            startScreen strt = new startScreen(S);
            strt.setLocation(0, 0);
            strt.setVisible(true);
            setVisible(false);
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginScreenAlternative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginScreenAlternative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginScreenAlternative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginScreenAlternative.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new loginScreenAlternative().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordVariable;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
