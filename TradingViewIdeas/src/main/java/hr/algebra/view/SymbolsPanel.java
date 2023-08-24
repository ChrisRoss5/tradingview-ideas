package hr.algebra.view;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;

import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.IdeaRepository;
import hr.algebra.model.Idea;
import hr.algebra.utilities.MessageUtils;

public class SymbolsPanel extends javax.swing.JPanel {

  public SymbolsPanel() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        formComponentShown(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1192, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE));
  }// </editor-fold>//GEN-END:initComponents

  private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
    init();
  }// GEN-LAST:event_formComponentShown

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables

  private DefaultListModel<Idea> articlesModel;
  private IdeaRepository repository;

  private void init() {
    try {
      repository = RepositoryFactory.getIdeaRepository();
      articlesModel = new DefaultListModel<>();
      loadModel();
    } catch (Exception ex) {
      Logger.getLogger(SymbolsPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
      System.exit(1);
    }
  }

  private void loadModel() throws Exception {
    List<Idea> articles = repository.selectIdeas();
    articlesModel.clear();
    articles.forEach(articlesModel::addElement);
    //lsArticles.setModel(articlesModel);
  }
}
