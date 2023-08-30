package hr.algebra.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.JTextComponent;

import hr.algebra.FileUtils;
import hr.algebra.MessageUtils;
import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.AuthorRepository;
import hr.algebra.dal.repository.IdeaAuthorRepository;
import hr.algebra.dal.repository.IdeaRepository;
import hr.algebra.dal.repository.ImageRepository;
import hr.algebra.dal.repository.MarketRepository;
import hr.algebra.dal.repository.SymbolRepository;
import hr.algebra.model.Author;
import hr.algebra.model.Idea;
import hr.algebra.model.Market;
import hr.algebra.model.Symbol;
import hr.algebra.view.handler.AuthorsTransferHandler;
import hr.algebra.view.model.IdeaTableModel;

public class IdeasPanel extends javax.swing.JPanel {

  private final IdeaRepository ideaRepository;
  private final AuthorRepository authorRepository;
  private final IdeaAuthorRepository ideaAuthorRepository;
  private final SymbolRepository symbolRepository;
  private final MarketRepository marketRepository;
  private final ImageRepository imageRepository;

  private List<JTextComponent> validationFields;
  private List<JComboBox<?>> validationComboBoxes;
  private List<JLabel> errorLabels;

  private Idea selectedIdea;
  private Market selectedMarket;
  private ImageIcon imageIcon;
  private double imageRatio;
  private boolean formLoaded;

  public IdeasPanel() {
    initComponents();
    initValidation();
    initListeners();
    this.ideaRepository = RepositoryFactory.getIdeaRepository();
    this.authorRepository = RepositoryFactory.getAuthorRepository();
    this.ideaAuthorRepository = RepositoryFactory.getIdeaAuthorRepository();
    this.symbolRepository = RepositoryFactory.getSymbolRepository();
    this.marketRepository = RepositoryFactory.getMarketRepository();
    this.imageRepository = RepositoryFactory.getImageRepository();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        tabbedPaneMarkets = new javax.swing.JTabbedPane();
        rightPanel = new javax.swing.JPanel();
        tfTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfLink = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        tfPublishedDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbTitleError = new javax.swing.JLabel();
        lbLinkError = new javax.swing.JLabel();
        lbDescriptionError = new javax.swing.JLabel();
        lbPublishedDateError = new javax.swing.JLabel();
        lbPicturePathError = new javax.swing.JLabel();
        cbSymbol = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsIdeaAuthors = new javax.swing.JList<>();
        lbSymbolError = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JButton();
        tfPicturePath = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        lsAuthors = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lbIcon = new javax.swing.JLabel();
        cbMarket = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lbMarketError = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 778));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jSplitPane1.setDividerLocation(600);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setResizeWeight(0.5);

        tabbedPaneMarkets.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabbedPaneMarkets.setPreferredSize(new java.awt.Dimension(920, 433));
        jSplitPane1.setLeftComponent(tabbedPaneMarkets);

        jLabel2.setText("Title");

        jLabel3.setText("Link");

        jLabel4.setText("Description");

        taDescription.setColumns(20);
        taDescription.setLineWrap(true);
        taDescription.setRows(5);
        jScrollPane2.setViewportView(taDescription);

        jLabel5.setText("Published date");

        jLabel6.setText("Symbol");

        jLabel7.setText("Authors");

        lbTitleError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbTitleError.setForeground(new java.awt.Color(255, 51, 51));
        lbTitleError.setText("X");

        lbLinkError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbLinkError.setForeground(new java.awt.Color(255, 51, 51));
        lbLinkError.setText("X");

        lbDescriptionError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbDescriptionError.setForeground(new java.awt.Color(255, 51, 51));
        lbDescriptionError.setText("X");

        lbPublishedDateError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbPublishedDateError.setForeground(new java.awt.Color(255, 51, 51));
        lbPublishedDateError.setText("X");

        lbPicturePathError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbPicturePathError.setForeground(new java.awt.Color(255, 51, 51));
        lbPicturePathError.setText("X");

        lsIdeaAuthors.setDragEnabled(true);
        jScrollPane3.setViewportView(lsIdeaAuthors);

        lbSymbolError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbSymbolError.setForeground(new java.awt.Color(255, 51, 51));
        lbSymbolError.setText("X");

        btnChooseImage.setText("Choose");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        jScrollPane4.setToolTipText("");

        lsAuthors.setDragEnabled(true);
        jScrollPane4.setViewportView(lsAuthors);

        jLabel8.setText("Picture path");

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 6, 0));

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel2.add(btnCreate);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete);

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N
        lbIcon.setMaximumSize(new java.awt.Dimension(500000, 342000));
        lbIcon.setMinimumSize(new java.awt.Dimension(0, 0));
        lbIcon.setPreferredSize(new java.awt.Dimension(1, 1));

        jLabel9.setText("Market");

        lbMarketError.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbMarketError.setForeground(new java.awt.Color(255, 51, 51));
        lbMarketError.setText("X");

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(tfPicturePath)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPicturePathError))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rightPanelLayout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(16, 16, 16))
                                    .addGroup(rightPanelLayout.createSequentialGroup()
                                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfLink)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(tfTitle, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbLinkError)
                                            .addComponent(lbDescriptionError)
                                            .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfPublishedDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbPublishedDateError))
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSymbol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbSymbolError))
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMarket, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbMarketError, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChooseImage)
                            .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(lbPicturePathError))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbTitleError)
                                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbLinkError))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lbDescriptionError)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPublishedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPublishedDateError)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSymbolError))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbMarket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMarketError))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap())))
        );

        jSplitPane1.setRightComponent(rightPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

  private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCreateActionPerformed
    if (!formValid()) {
      return;
    }
    try {
      String localPicturePath = uploadImage();
      Idea idea = new Idea(
          tfTitle.getText().trim(),
          tfLink.getText().trim(),
          taDescription.getText().trim(),
          localPicturePath,
          LocalDateTime.parse(tfPublishedDate.getText().trim(), Idea.DATE_FORMATTER),
          (Symbol) cbSymbol.getSelectedItem(),
          (Market) cbMarket.getSelectedItem());
      int ideaId = ideaRepository.createIdea(idea);
      List<Entry<Integer, Integer>> ideaAuthors = new ArrayList<>();
      DefaultListModel<Author> model = (DefaultListModel<Author>) lsIdeaAuthors.getModel();
      for (int i = 0; i < lsIdeaAuthors.getModel().getSize(); i++) {
        ideaAuthors.add(Map.entry(ideaId, model.get(i).getId()));
      }
      ideaAuthorRepository.createAssociations(ideaAuthors);
      updateTables();
      clearForm();
    } catch (Exception ex) {
      if (ex.getMessage().contains("Violation of UNIQUE KEY constraint")) {
        MessageUtils.showErrorMessage("Error", "Idea with this link already exists!");
      } else {
        Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to create idea!");
      }
    }
  }// GEN-LAST:event_btnCreateActionPerformed

  private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
    if (selectedIdea == null) {
      MessageUtils.showInformationMessage("Wrong operation", "Please choose idea to update");
      return;
    }
    if (!formValid()) {
      return;
    }
    try {
      if (!tfPicturePath.getText().trim().equals(selectedIdea.getPicturePath())) {
        if (selectedIdea.getPicturePath() != null) {
          Files.deleteIfExists(Paths.get(selectedIdea.getPicturePath()));
        }
        selectedIdea.setPicturePath(uploadImage());
      }
      selectedIdea.setTitle(tfTitle.getText().trim());
      selectedIdea.setLink(tfLink.getText().trim());
      selectedIdea.setDescription(taDescription.getText().trim());
      selectedIdea.setPublishedDate(LocalDateTime.parse(tfPublishedDate.getText().trim(), Idea.DATE_FORMATTER));
      selectedIdea.setSymbol((Symbol) cbSymbol.getSelectedItem());
      selectedIdea.setMarket((Market) cbMarket.getSelectedItem());
      ideaRepository.updateIdea(selectedIdea.getId(), selectedIdea);
      List<Entry<Integer, Integer>> ideaAuthors = new ArrayList<>();
      DefaultListModel<Author> model = (DefaultListModel<Author>) lsIdeaAuthors.getModel();
      for (int i = 0; i < lsIdeaAuthors.getModel().getSize(); i++) {
        ideaAuthors.add(Map.entry(selectedIdea.getId(), model.get(i).getId()));
      }
      ideaAuthorRepository.deleteIdeaAssociations(selectedIdea.getId());
      ideaAuthorRepository.createAssociations(ideaAuthors);
      updateTables();
      clearForm();
    } catch (Exception ex) {
      if (ex.getMessage().contains("Violation of UNIQUE KEY constraint")) {
        MessageUtils.showErrorMessage("Error", "Idea with this link already exists!");
      } else {
        Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to update idea!");
      }
    }

  }// GEN-LAST:event_btnUpdateActionPerformed

  private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
    if (selectedIdea == null) {
      MessageUtils.showInformationMessage("Wrong operation", "Please choose idea to delete");
      return;
    }
    if (MessageUtils.showConfirmDialog(
        "Delete idea",
        "Are you sure you want to delete idea?")) {
      try {
        if (selectedIdea.getPicturePath() != null) {
          Files.deleteIfExists(Paths.get(selectedIdea.getPicturePath()));
        }
        ideaRepository.deleteIdea(selectedIdea.getId());
        ideaAuthorRepository.deleteIdeaAssociations(selectedIdea.getId());
        updateTables();
        clearForm();
      } catch (Exception ex) {
        Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to delete idea!");
      }
    }
  }// GEN-LAST:event_btnDeleteActionPerformed

  private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChooseImageActionPerformed
    Optional<File> file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
    if (file.isEmpty()) {
      return;
    }
    tfPicturePath.setText(file.get().getAbsolutePath());
    setLbIcon(new ImageIcon(file.get().getAbsolutePath()));
  }// GEN-LAST:event_btnChooseImageActionPerformed

  private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
    try {
      formLoaded = false;
      loadTabbedPane();
      loadComboBoxes();
      loadLists();
      resetLbIcon();
      updateTables();
      clearForm();
      formLoaded = true;
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Unrecoverable error", "Cannot load the form!");
      System.exit(1);
    }
  }// GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Market> cbMarket;
    private javax.swing.JComboBox<Symbol> cbSymbol;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbDescriptionError;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbLinkError;
    private javax.swing.JLabel lbMarketError;
    private javax.swing.JLabel lbPicturePathError;
    private javax.swing.JLabel lbPublishedDateError;
    private javax.swing.JLabel lbSymbolError;
    private javax.swing.JLabel lbTitleError;
    private javax.swing.JList<Author> lsAuthors;
    private javax.swing.JList<Author> lsIdeaAuthors;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTabbedPane tabbedPaneMarkets;
    private javax.swing.JTextField tfLink;
    private javax.swing.JTextField tfPicturePath;
    private javax.swing.JTextField tfPublishedDate;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables

  private void initValidation() {
    validationFields = Arrays.asList(tfTitle, tfLink, taDescription, tfPublishedDate, tfPicturePath);
    validationComboBoxes = Arrays.asList(cbSymbol, cbMarket);
    errorLabels = Arrays.asList(lbTitleError, lbLinkError, lbDescriptionError, lbPublishedDateError,
        lbPicturePathError, lbSymbolError, lbMarketError);
  }

  private void initListeners() {
    tabbedPaneMarkets.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        if (formLoaded) {
          try {
            List<Market> dbMarkets = marketRepository.selectMarkets();
            selectedMarket = dbMarkets.get(tabbedPaneMarkets.getSelectedIndex());
            clearForm();
          } catch (Exception ex) {
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot change market!");
            ex.printStackTrace();
          }
        }
      }
    });
    lbIcon.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        if (formLoaded) {
          updateLbIcon();
        }
      }
    });
  }

  private void loadTabbedPane() throws Exception {
    tabbedPaneMarkets.removeAll();
    List<Market> dbMarkets = marketRepository.selectMarkets();
    for (Market market : dbMarkets) {
      JTable table = new JTable();
      IdeaTableModel ideasTableModel = new IdeaTableModel(new ArrayList<>());
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      table.setAutoCreateRowSorter(true);
      table.setRowHeight(25);
      table.setModel(ideasTableModel);
      table.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
          showIdea(table, ideasTableModel);
        }
      });
      table.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
          showIdea(table, ideasTableModel);
        }
      });
      tabbedPaneMarkets.addTab(market.getName(), new JScrollPane(table));
    }
    if (selectedMarket != null && dbMarkets.contains(selectedMarket)) {
      tabbedPaneMarkets.setSelectedIndex(dbMarkets.indexOf(selectedMarket));
    }
  }

  private void loadComboBoxes() throws Exception {
    cbSymbol.removeAllItems();
    for (Symbol symbol : symbolRepository.selectSymbols()) {
      cbSymbol.addItem(symbol);
    }
    cbMarket.removeAllItems();
    for (Market market : marketRepository.selectMarkets()) {
      cbMarket.addItem(market);
    }
  }

  private void loadLists() throws Exception {
    DefaultListModel<Author> sourceModel = new DefaultListModel<>();
    sourceModel.addAll(authorRepository.selectAuthors());
    lsAuthors.setModel(sourceModel);
    lsAuthors.setTransferHandler(new AuthorsTransferHandler(false));
    lsIdeaAuthors.setModel(new DefaultListModel<>());
    lsIdeaAuthors.setTransferHandler(new AuthorsTransferHandler(true));
  }

  private void resetLbIcon() {
    setLbIcon(new ImageIcon(getClass().getResource("/assets/no_image.png")));
  }

  private void setLbIcon(ImageIcon imageIcon) {
    this.imageIcon = imageIcon;
    this.imageRatio = (double) imageIcon.getIconWidth() / imageIcon.getIconHeight();
    updateLbIcon();
  }

  private void updateLbIcon() {
    int lbW = lbIcon.getWidth();
    int imgH = (int) (lbW / imageRatio);
    lbIcon.setPreferredSize(new Dimension(lbW, imgH));
    int lbH = lbIcon.getHeight();
    int imgW = (int) (lbH * imageRatio);
    int w = (imgW > lbW) ? lbW : imgW;
    int h = (imgW > lbW) ? (int) (w / imageRatio) : lbH;
    Image newImage = imageIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
    lbIcon.setIcon(new ImageIcon(newImage));
  }

  private void hideErrors() {
    errorLabels.forEach(e -> e.setVisible(false));
  }

  private boolean formValid() {
    hideErrors();
    int i = 0;
    for (; i < validationFields.size(); i++) {
      errorLabels.get(i).setVisible(validationFields.get(i).getText().trim().isEmpty());
      if ("Date".equals(validationFields.get(i).getName())) {
        try {
          LocalDateTime.parse(validationFields.get(i).getText().trim(), Idea.DATE_FORMATTER);
        } catch (Exception e) {
          errorLabels.get(i).setVisible(true);
        }
      }
    }
    for (JComboBox<?> validationComboBox : validationComboBoxes) {
      errorLabels.get(i++).setVisible(validationComboBox.getSelectedIndex() == -1);
    }
    return errorLabels.stream().noneMatch(e -> e.isVisible());
  }

  private void clearForm() {
    hideErrors();
    validationFields.forEach(e -> e.setText(""));
    validationComboBoxes.forEach(e -> e.setSelectedIndex(-1));
    ((DefaultListModel<Author>) lsIdeaAuthors.getModel()).clear();
    resetLbIcon();
    selectedIdea = null;
    btnUpdate.setEnabled(false);
    btnDelete.setEnabled(false);
  }

  private String uploadImage() {
    try {
      return imageRepository.saveImageFromPath(tfPicturePath.getText().trim());
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to save image!");
    }
    return "";
  }

  private void showIdea(JTable table, IdeaTableModel ideasTableModel) {
    clearForm();
    int selectedRow = table.getSelectedRow();
    int rowIndex = table.convertRowIndexToModel(selectedRow);
    int selectedIdeaId = (int) ideasTableModel.getValueAt(rowIndex, 0);
    try {
      Optional<Idea> optIdea = ideaRepository.selectIdea(selectedIdeaId);
      if (optIdea.isPresent()) {
        selectedIdea = optIdea.get();
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        fillForm(selectedIdea);
      }
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to show idea!");
    }
  }

  private void fillForm(Idea idea) {
    if (idea.getPicturePath() != null && Files.exists(Paths.get(idea.getPicturePath()))) {
      tfPicturePath.setText(idea.getPicturePath());
      setLbIcon(new ImageIcon(idea.getPicturePath()));
    }
    tfTitle.setText(idea.getTitle());
    tfLink.setText(idea.getLink());
    taDescription.setText(idea.getDescription());
    tfPublishedDate.setText(idea.getPublishedDate().format(Idea.DATE_FORMATTER));
    cbSymbol.setSelectedItem(idea.getSymbol());
    cbMarket.setSelectedItem(idea.getMarket());
    try {
      DefaultListModel<Author> model = (DefaultListModel<Author>) lsIdeaAuthors.getModel();
      model.clear();
      for (int authorId : ideaAuthorRepository.selectAuthorIdsByIdea(idea)) {
        Optional<Author> author = authorRepository.selectAuthor(authorId);
        if (author.isPresent()) {
          model.addElement(author.get());
        }
      }
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to show authors!");
    }
  }

  private void updateTables() throws Exception {
    List<Idea> dbIdeas = ideaRepository.selectIdeas();
    List<Market> dbMarkets = marketRepository.selectMarkets();
    for (int i = 0; i < dbMarkets.size(); i++) {
      int marketId = dbMarkets.get(i).getId();
      List<Idea> marketIdeas = dbIdeas.stream()
          .filter(idea -> idea.getMarket().getId() == marketId)
          .toList();
      IdeaTableModel tableModel = (IdeaTableModel) ((JTable) ((JScrollPane) tabbedPaneMarkets.getComponentAt(i))
          .getViewport().getView()).getModel();
      tableModel.setIdeas(marketIdeas);
    }
  }
}
