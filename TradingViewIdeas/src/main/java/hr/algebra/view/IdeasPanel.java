package hr.algebra.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.AuthorRepository;
import hr.algebra.dal.repository.IdeaAuthorRepository;
import hr.algebra.dal.repository.IdeaRepository;
import hr.algebra.dal.repository.ImageRepository;
import hr.algebra.dal.repository.MarketRepository;
import hr.algebra.model.Idea;
import hr.algebra.model.Market;
import hr.algebra.model.Symbol;
import hr.algebra.utilities.FileUtils;
import hr.algebra.utilities.IconUtils;
import hr.algebra.utilities.MessageUtils;
import hr.algebra.view.model.IdeasTableModel;

public class IdeasPanel extends javax.swing.JPanel {

  private static final IdeaRepository ideaRepository = RepositoryFactory.getIdeaRepository();
  private static final IdeaAuthorRepository ideaAuthorRepository = RepositoryFactory.getIdeaAuthorRepository();
  private static final AuthorRepository authorRepository = RepositoryFactory.getAuthorRepository();
  private static final MarketRepository marketRepository = RepositoryFactory.getMarketRepository();
  private static final ImageRepository imageRepository = RepositoryFactory.getImageRepository();

  private List<JTextComponent> validationFields;
  private List<JLabel> errorLabels;

  private Idea selectedIdea;
  private ImageIcon imageIcon;

  public IdeasPanel() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        tabbedPaneMarkets = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbIdeas = new javax.swing.JTable();
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
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lbIcon = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1000, 778));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setResizeWeight(0.5);

        tabbedPaneMarkets.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabbedPaneMarkets.setPreferredSize(new java.awt.Dimension(920, 433));

        tbIdeas.setAutoCreateRowSorter(true);
        tbIdeas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbIdeas.setShowGrid(true);
        tbIdeas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbIdeasMouseClicked(evt);
            }
        });
        tbIdeas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbIdeasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbIdeas);

        tabbedPaneMarkets.addTab("tab1", jScrollPane1);

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

        jScrollPane4.setViewportView(lsAuthors);

        jLabel8.setText("Picture path");

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 6, 0));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd);

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

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(tfPublishedDate)
                                    .addComponent(cbSymbol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                    .addComponent(tfTitle, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbLinkError)
                                    .addComponent(lbDescriptionError)
                                    .addComponent(lbPublishedDateError)
                                    .addComponent(lbSymbolError)
                                    .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                        .addComponent(lbPicturePathError)))
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
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
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

  private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
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
          marketRepository.selectMarkets().get(0));
      ideaRepository.createIdea(idea);
      updateTableModels();
      clearForm();
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to create idea!");
    }
  }// GEN-LAST:event_btnAddActionPerformed

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
        String localPicturePath = uploadImage();
        selectedIdea.setPicturePath(localPicturePath);
      }
      selectedIdea.setTitle(tfTitle.getText().trim());
      selectedIdea.setLink(tfLink.getText().trim());
      selectedIdea.setDescription(taDescription.getText().trim());
      selectedIdea.setPublishedDate(LocalDateTime.parse(tfPublishedDate.getText().trim(), Idea.DATE_FORMATTER));
      ideaRepository.updateIdea(selectedIdea.getId(), selectedIdea);
      updateTableModels();
      clearForm();
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to update idea!");
    }

  }// GEN-LAST:event_btnUpdateActionPerformed

  private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
    if (selectedIdea == null) {
      MessageUtils.showInformationMessage("Wrong operation", "Please choose idea to delete");
      return;
    }
    if (MessageUtils.showConfirmDialog(
        "Delete idea",
        "Do you really want to delete idea?")) {
      try {
        if (selectedIdea.getPicturePath() != null) {
          Files.deleteIfExists(Paths.get(selectedIdea.getPicturePath()));
        }
        ideaRepository.deleteIdea(selectedIdea.getId());
        updateTableModels();
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
    //setIcon(lbIcon, file.get());
  }// GEN-LAST:event_btnChooseImageActionPerformed

  private void setIcon(JLabel label, File file) {
    try {
      label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
    } catch (IOException ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to set icon!");
    }
  }

  private void tbIdeasMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbIdeasMouseClicked
  }// GEN-LAST:event_tbIdeasMouseClicked

  private void tbIdeasKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_tbIdeasKeyReleased
  }// GEN-LAST:event_tbIdeasKeyReleased

  private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
    init();
  }// GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbSymbol;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbDescriptionError;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbLinkError;
    private javax.swing.JLabel lbPicturePathError;
    private javax.swing.JLabel lbPublishedDateError;
    private javax.swing.JLabel lbSymbolError;
    private javax.swing.JLabel lbTitleError;
    private javax.swing.JList<String> lsAuthors;
    private javax.swing.JList<String> lsIdeaAuthors;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTabbedPane tabbedPaneMarkets;
    private javax.swing.JTable tbIdeas;
    private javax.swing.JTextField tfLink;
    private javax.swing.JTextField tfPicturePath;
    private javax.swing.JTextField tfPublishedDate;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables

  private void init() {
    try {
      initTabbedPane();
      initLbIcon();
      initValidation();
      hideErrors();
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
      System.exit(1);
    }
  }

  private void initTabbedPane() throws Exception {
    tabbedPaneMarkets.removeAll();
    List<Market> dbMarkets = marketRepository.selectMarkets();
    for (Market market : dbMarkets) {
      JTable table = new JTable();
      IdeasTableModel ideasTableModel = new IdeasTableModel(new ArrayList<>());
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
    updateTableModels();
  }

  private void initLbIcon() {
    resetLbIcon();
    lbIcon.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        updateLbIcon();
      }
    });
  }

  private void resetLbIcon() {
    setLbIcon(new ImageIcon(getClass().getResource("/assets/no_image.png")));
  }

  private void setLbIcon(ImageIcon imageIcon) {
    this.imageIcon = imageIcon;
    updateLbIcon();
  }

  private void updateLbIcon() {
    double ratio = (double) imageIcon.getIconWidth() / imageIcon.getIconHeight();
    int w = lbIcon.getWidth();
    int h = (int) (w / ratio);
    Image newImage = imageIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
    lbIcon.setIcon(new ImageIcon(newImage));
    lbIcon.setSize(w, h);
    lbIcon.repaint();
    lbIcon.setPreferredSize(new Dimension(w, h));
        lbIcon.repaint();
    lbIcon.setPreferredSize(new Dimension(w, h));
        lbIcon.repaint();
    System.out.println("h: " + h + " | H: " + lbIcon.getHeight());
  }

  private void initValidation() {
    validationFields = Arrays.asList(tfTitle, tfLink, taDescription, tfPublishedDate, tfPicturePath);
    errorLabels = Arrays.asList(lbTitleError, lbLinkError, lbDescriptionError, lbPublishedDateError,
        lbPicturePathError);
  }

  private void hideErrors() {
    errorLabels.forEach(e -> e.setVisible(false));
    lbSymbolError.setVisible(false);
  }

  private boolean formValid() {
    hideErrors();
    boolean ok = true;
    for (int i = 0; i < validationFields.size(); i++) {
      ok &= !validationFields.get(i).getText().trim().isEmpty();
      errorLabels.get(i).setVisible(validationFields.get(i).getText().trim().isEmpty());
      if ("Date".equals(validationFields.get(i).getName())) {
        try {
          LocalDateTime.parse(validationFields.get(i).getText().trim(), Idea.DATE_FORMATTER);
        } catch (Exception e) {
          ok = false;
          errorLabels.get(i).setVisible(true);
        }
      }
    }
    if (cbSymbol.getSelectedIndex() == -1) {
      ok = false;
      lbSymbolError.setVisible(true);
    }
    return ok;
  }

  private void clearForm() {
    hideErrors();
    validationFields.forEach(e -> e.setText(""));
    cbSymbol.setSelectedIndex(-1);
    resetLbIcon();
    selectedIdea = null;
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

  private void showIdea(JTable table, IdeasTableModel ideasTableModel) {
    clearForm();
    int selectedRow = table.getSelectedRow();
    int rowIndex = table.convertRowIndexToModel(selectedRow);
    int selectedIdeaId = (int) ideasTableModel.getValueAt(rowIndex, 0);
    try {
      Optional<Idea> optIdea = ideaRepository.selectIdea(selectedIdeaId);
      if (optIdea.isPresent()) {
        selectedIdea = optIdea.get();
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
      //setIcon(lbIcon, new File(idea.getPicturePath()));
    }
    tfTitle.setText(idea.getTitle());
    tfLink.setText(idea.getLink());
    taDescription.setText(idea.getDescription());
    tfPublishedDate.setText(idea.getPublishedDate().format(Idea.DATE_FORMATTER));
    cbSymbol.setSelectedItem(idea.getSymbol());
    try {
      String authors = ideaAuthorRepository.selectAuthorIdsByIdea(idea).stream()
          .map(id -> {
            try {
              return authorRepository.selectAuthor(id).get().getName();
            } catch (Exception ex) {
              Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
              return null;
            }
          })
          .filter(Objects::nonNull).toList().toString();
      lsIdeaAuthors.setSelectedValue(authors, true);
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to show authors!");
    }
  }

  private void updateTableModels() throws Exception {
    List<Idea> dbIdeas = ideaRepository.selectIdeas();
    List<Market> dbMarkets = marketRepository.selectMarkets();
    for (Market market : dbMarkets) {
      List<Idea> marketIdeas = dbIdeas.stream()
          .filter(idea -> idea.getMarket().getId() == market.getId())
          .toList();
      getIdeasTableModel(dbMarkets.indexOf(market)).setIdeas(marketIdeas);
    }
  }

  private IdeasTableModel getIdeasTableModel(int index) {
    return (IdeasTableModel) ((JTable) ((JScrollPane) tabbedPaneMarkets.getComponentAt(index)).getViewport().getView())
        .getModel();
  }
}
