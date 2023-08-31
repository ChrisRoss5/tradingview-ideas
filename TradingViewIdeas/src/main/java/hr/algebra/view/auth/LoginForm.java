package hr.algebra.view.auth;

import javax.swing.JOptionPane;

import hr.algebra.TradingViewIdeas;
import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.UserRepository;
import hr.algebra.model.User;

import java.util.Optional;
import java.util.logging.Logger;

public class LoginForm extends javax.swing.JFrame {

  private final UserRepository userRepository;

  public LoginForm() {
    userRepository = RepositoryFactory.getUserRepository();
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lbRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setPreferredSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(81, 66, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        tfUsername.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(79, 18, 0, 65);
        getContentPane().add(tfUsername, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 66, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        pfPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 65);
        getContentPane().add(pfPassword, gridBagConstraints);

        btnLogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 197;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 66, 0, 65);
        getContentPane().add(btnLogin, gridBagConstraints);

        lbRegister.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbRegister.setForeground(new java.awt.Color(51, 102, 255));
        lbRegister.setText("Register?");
        lbRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRegisterMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 66, 79, 0);
        getContentPane().add(lbRegister, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLoginActionPerformed
    String username = tfUsername.getText().trim();
    String password = new String(pfPassword.getPassword());
    Optional<User> user = Optional.empty();
    try {
      user = userRepository.login(username, password);
    } catch (Exception ex) {
      Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(LoginForm.this,
          "Unable to login.",
          "Login Failed", JOptionPane.ERROR_MESSAGE);
    }
    if (user.isPresent()) {
      dispose();
      new TradingViewIdeas(user.get()).setVisible(true);
    } else {
      JOptionPane.showMessageDialog(LoginForm.this,
          "Invalid username or password. Please try again.",
          "Login Failed", JOptionPane.ERROR_MESSAGE);
    }
  }// GEN-LAST:event_btnLoginActionPerformed

  private void lbRegisterMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lbRegisterMouseClicked
    dispose();
    new RegisterForm().setVisible(true);
  }// GEN-LAST:event_lbRegisterMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbRegister;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
