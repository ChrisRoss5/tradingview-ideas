package hr.algebra.view;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;

import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.AuthorRepository;
import hr.algebra.model.Author;
import hr.algebra.utilities.MessageUtils;
import hr.algebra.view.model.AuthorTableModel;
import hr.algebra.view.ui.ButtonCellEditor;
import hr.algebra.view.ui.ButtonCellRenderer;

public class AuthorsPanel extends javax.swing.JPanel {
  private List<JTextComponent> validationFields;
  private List<JLabel> errorLabels;

  private final AuthorRepository authorRepository;

  private AuthorTableModel authorTableModel;

  public AuthorsPanel() {
    initComponents();
    initValidation();
    this.authorRepository = RepositoryFactory.getAuthorRepository();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    tbAuthors = new javax.swing.JTable();
    bottomPanel = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    Link = new javax.swing.JLabel();
    tfLink = new javax.swing.JTextField();
    btnCreate = new javax.swing.JButton();
    tfName = new javax.swing.JTextField();
    lbNameError = new javax.swing.JLabel();
    lbLinkError = new javax.swing.JLabel();

    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        formComponentShown(evt);
      }
    });

    jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 1000));

    tbAuthors.setAutoCreateRowSorter(true);
    tbAuthors.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null },
            { null, null, null, null },
            { null, null, null, null },
            { null, null, null, null }
        },
        new String[] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }));
    tbAuthors.setRowHeight(25);
    tbAuthors.setRowSelectionAllowed(false);
    tbAuthors.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane1.setViewportView(tbAuthors);

    bottomPanel.setMinimumSize(new java.awt.Dimension(0, 0));

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel1.setText("Name");

    Link.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    Link.setText("Link");

    btnCreate.setText("Create");
    btnCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCreateActionPerformed(evt);
      }
    });

    lbNameError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    lbNameError.setForeground(new java.awt.Color(255, 51, 51));
    lbNameError.setText("X");

    lbLinkError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    lbLinkError.setForeground(new java.awt.Color(255, 51, 51));
    lbLinkError.setText("X");

    javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
    bottomPanel.setLayout(bottomPanelLayout);
    bottomPanelLayout.setHorizontalGroup(
        bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomPanelLayout.createSequentialGroup()
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNameError))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Link)
                    .addGroup(bottomPanelLayout.createSequentialGroup()
                        .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLinkError)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
                            javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE)));
    bottomPanelLayout.setVerticalGroup(
        bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Link))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNameError)
                    .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLinkError)
                    .addComponent(btnCreate))
                .addGap(30, 30, 30)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE)));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap()));
  }// </editor-fold>//GEN-END:initComponents

  private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCreateActionPerformed
    if (!formValid()) {
      return;
    }
    Author author = new Author(tfName.getText().trim(), tfLink.getText().trim());
    if (authorTableModel.addAuthor(author)) {
      clearForm();
    }
  }// GEN-LAST:event_btnCreateActionPerformed

  private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
    try {
      loadTable();
      clearForm();
    } catch (Exception ex) {
      Logger.getLogger(AuthorsPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
      System.exit(1);
    }
  }// GEN-LAST:event_formComponentShown

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel Link;
  private javax.swing.JPanel bottomPanel;
  private javax.swing.JButton btnCreate;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lbLinkError;
  private javax.swing.JLabel lbNameError;
  private javax.swing.JTable tbAuthors;
  private javax.swing.JTextField tfLink;
  private javax.swing.JTextField tfName;
  // End of variables declaration//GEN-END:variables

  private void initValidation() {
    validationFields = Arrays.asList(tfName, tfLink);
    errorLabels = Arrays.asList(lbNameError, lbLinkError);
  }

  private void loadTable() throws Exception {
    authorTableModel = new AuthorTableModel(authorRepository);
    tbAuthors.setModel(authorTableModel);
    TableColumn deleteColumn = tbAuthors.getColumnModel().getColumn(3);
    deleteColumn.setCellRenderer(new ButtonCellRenderer());
    deleteColumn.setCellEditor(new ButtonCellEditor());
  }

  private void hideErrors() {
    errorLabels.forEach(e -> e.setVisible(false));
  }

  private boolean formValid() {
    hideErrors();
    for (int i = 0; i < validationFields.size(); i++) {
      errorLabels.get(i).setVisible(validationFields.get(i).getText().trim().isEmpty());
    }
    return errorLabels.stream().noneMatch(e -> e.isVisible());
  }

  private void clearForm() {
    hideErrors();
    validationFields.forEach(e -> e.setText(""));
  }
}
