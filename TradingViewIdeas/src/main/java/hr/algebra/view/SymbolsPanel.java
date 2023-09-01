package hr.algebra.view;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;

import hr.algebra.MessageUtils;
import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.IdeaRepository;
import hr.algebra.dal.repository.SymbolRepository;
import hr.algebra.model.Symbol;
import hr.algebra.view.model.SymbolTableModel;
import hr.algebra.view.ui.ButtonCellEditor;
import hr.algebra.view.ui.ButtonCellRenderer;

public class SymbolsPanel extends javax.swing.JPanel {
  private final SymbolRepository symbolRepository;

  private List<JTextComponent> validationFields;
  private List<JLabel> errorLabels;

  private SymbolTableModel symbolTableModel;
  private IdeaRepository ideaRepository;

  public SymbolsPanel() {
    this.symbolRepository = RepositoryFactory.getSymbolRepository();
    this.ideaRepository = RepositoryFactory.getIdeaRepository();
    initComponents();
    initValidation();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    tbSymbols = new javax.swing.JTable();
    bottomPanel = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    Link = new javax.swing.JLabel();
    tfLink = new javax.swing.JTextField();
    btnCreate = new javax.swing.JButton();
    tfName = new javax.swing.JTextField();
    lbDescriptionError = new javax.swing.JLabel();
    lbLinkError = new javax.swing.JLabel();
    tfDescription = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    lbNameError = new javax.swing.JLabel();

    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        formComponentShown(evt);
      }
    });

    jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 1000));

    tbSymbols.setAutoCreateRowSorter(true);
    tbSymbols.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null },
            { null, null, null, null },
            { null, null, null, null },
            { null, null, null, null }
        },
        new String[] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }));
    tbSymbols.setRowHeight(25);
    tbSymbols.setRowSelectionAllowed(false);
    tbSymbols.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane1.setViewportView(tbSymbols);

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

    lbDescriptionError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    lbDescriptionError.setForeground(new java.awt.Color(255, 51, 51));
    lbDescriptionError.setText("X");

    lbLinkError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    lbLinkError.setForeground(new java.awt.Color(255, 51, 51));
    lbLinkError.setText("X");

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setText("Description");

    lbNameError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    lbNameError.setForeground(new java.awt.Color(255, 51, 51));
    lbNameError.setText("X");

    javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
    bottomPanel.setLayout(bottomPanelLayout);
    bottomPanelLayout.setHorizontalGroup(
        bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(4, 4, 4)
                .addComponent(lbNameError)
                .addGap(18, 18, 18)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDescriptionError)
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
                .addContainerGap(25, Short.MAX_VALUE)));
    bottomPanelLayout.setVerticalGroup(
        bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bottomPanelLayout.createSequentialGroup()
                        .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Link))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescriptionError)
                            .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLinkError)
                            .addComponent(btnCreate)
                            .addComponent(lbNameError))))
                .addGap(30, 30, 30)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
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
    Symbol symbol = new Symbol(tfName.getText().trim(), tfLink.getText().trim(),
        tfDescription.getText().trim());
    if (symbolTableModel.addSymbol(symbol)) {
      clearForm();
    }
  }// GEN-LAST:event_btnCreateActionPerformed

  private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
    try {
      loadTable();
      clearForm();
    } catch (Exception ex) {
      Logger.getLogger(SymbolsPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
      System.exit(1);
    }
  }// GEN-LAST:event_formComponentShown

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel Link;
  private javax.swing.JPanel bottomPanel;
  private javax.swing.JButton btnCreate;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lbDescriptionError;
  private javax.swing.JLabel lbLinkError;
  private javax.swing.JLabel lbNameError;
  private javax.swing.JTable tbSymbols;
  private javax.swing.JTextField tfDescription;
  private javax.swing.JTextField tfLink;
  private javax.swing.JTextField tfName;
  // End of variables declaration//GEN-END:variables

  private void initValidation() {
    validationFields = Arrays.asList(tfName, tfDescription, tfLink);
    errorLabels = Arrays.asList(lbNameError, lbDescriptionError, lbLinkError);
  }

  private void loadTable() throws Exception {
    symbolTableModel = new SymbolTableModel(symbolRepository, ideaRepository);
    tbSymbols.setModel(symbolTableModel);
    TableColumn deleteColumn = tbSymbols.getColumnModel().getColumn(tbSymbols.getColumnCount() - 1);
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
