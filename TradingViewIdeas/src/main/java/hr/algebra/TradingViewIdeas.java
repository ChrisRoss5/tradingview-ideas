package hr.algebra;

import hr.algebra.view.IdeasPanel;

import java.util.Optional;

import hr.algebra.auth.LoginForm;
import hr.algebra.model.User;
import hr.algebra.view.AdminPanel;
import hr.algebra.view.AuthorsPanel;
import hr.algebra.view.SymbolsPanel;

// https://www.tradingview.com/publishing-tools/

public class TradingViewIdeas extends javax.swing.JFrame {

  private static final String IDEAS = "Ideas";
  private static final String AUTHORS = "Authors";
  private static final String SYMBOLS = "Symbols";
  private static final String ADMIN = "Admin";

  private User user;

  public TradingViewIdeas(User user) {
    initComponents();
    this.user = user;
    configurePanels();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    tpContent = new javax.swing.JTabbedPane();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setPreferredSize(new java.awt.Dimension(1200, 900));

    tpContent.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContent, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE));

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the default
     * look and feel.
     * For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    System.out.print(javax.swing.UIManager.getInstalledLookAndFeels());
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(TradingViewIdeas.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(TradingViewIdeas.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(TradingViewIdeas.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(TradingViewIdeas.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    }
    // </editor-fold>

    java.awt.EventQueue.invokeLater(() -> {
      new LoginForm().setVisible(true);
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTabbedPane tpContent;
  // End of variables declaration//GEN-END:variables

  private void configurePanels() {
    tpContent.add(IDEAS, new IdeasPanel());
    tpContent.add(AUTHORS, new AuthorsPanel());
    tpContent.add(SYMBOLS, new SymbolsPanel());
    if (user.isAdmin()) {
      tpContent.add(ADMIN, new AdminPanel());
    }
  }
}
