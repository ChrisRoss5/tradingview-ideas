package hr.algebra;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;

import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.IdeaRepository;
import hr.algebra.model.IdeaArchive;
import hr.algebra.model.User;
import hr.algebra.view.AdminPanel;
import hr.algebra.view.AuthorsPanel;
import hr.algebra.view.IdeasPanel;
import hr.algebra.view.SymbolsPanel;
import hr.algebra.view.auth.LoginForm;

// https://www.tradingview.com/publishing-tools/

public class TradingViewIdeas extends javax.swing.JFrame {

  private static final String IDEAS = "Ideas";
  private static final String AUTHORS = "Authors";
  private static final String SYMBOLS = "Symbols";
  private static final String ADMIN = "Admin";
  private static final String EXPORT_FILENAME = "src/main/xml/ideas.xml";

  private final IdeaRepository ideaRepository;

  private final User user;

  public TradingViewIdeas(User user) {
    this.user = user;
    ideaRepository = RepositoryFactory.getIdeaRepository();
    initComponents();
    configurePanels();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    tpContent = new javax.swing.JTabbedPane();
    jMenuBar1 = new javax.swing.JMenuBar();
    menuExport = new javax.swing.JMenu();
    miExportIdeas = new javax.swing.JMenuItem();
    menuAccount = new javax.swing.JMenu();
    miLogOut = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    tpContent.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

    menuExport.setMnemonic('D');
    menuExport.setText("Export");

    miExportIdeas.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    miExportIdeas.setMnemonic('I');
    miExportIdeas.setText("Export Ideas");
    miExportIdeas.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        miExportIdeasActionPerformed(evt);
      }
    });
    menuExport.add(miExportIdeas);

    jMenuBar1.add(menuExport);

    menuAccount.setMnemonic('A');
    menuAccount.setText("Account");

    miLogOut.setAccelerator(
        javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
    miLogOut.setMnemonic('O');
    miLogOut.setText("Log out");
    miLogOut.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        miLogOutActionPerformed(evt);
      }
    });
    menuAccount.add(miLogOut);

    jMenuBar1.add(menuAccount);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpContent, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE));

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void miExportIdeasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miExportIdeasActionPerformed
    try {
      JAXBUtils.save(new IdeaArchive(ideaRepository.selectIdeas()), EXPORT_FILENAME);
      MessageUtils.showInformationMessage("Info", "Ideas saved!");
    } catch (Exception ex) {
      MessageUtils.showErrorMessage("Error", "Unable to export ideas!");
      Logger.getLogger(TradingViewIdeas.class.getName()).log(Level.SEVERE, null, ex);
    }
  }// GEN-LAST:event_miExportIdeasActionPerformed

  private void miLogOutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_miLogOutActionPerformed
    dispose();
    new LoginForm().setVisible(true);
  }// GEN-LAST:event_miLogOutActionPerformed

  public static void main(String args[]) {
    // https://github.com/JFormDesigner/FlatLaf/tree/main/flatlaf-intellij-themes#themes
    FlatGitHubDarkIJTheme.setup();
    java.awt.EventQueue.invokeLater(() -> {
      new LoginForm().setVisible(true);
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenu menuAccount;
  private javax.swing.JMenu menuExport;
  private javax.swing.JMenuItem miExportIdeas;
  private javax.swing.JMenuItem miLogOut;
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
