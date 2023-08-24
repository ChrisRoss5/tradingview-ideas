package hr.algebra.view;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.IdeaRepository;
import hr.algebra.model.Idea;
import hr.algebra.utilities.FileUtils;
import hr.algebra.utilities.IconUtils;
import hr.algebra.utilities.MessageUtils;
import hr.algebra.view.model.IdeaTableModel;

public class IdeasPanel extends javax.swing.JPanel {

  private static final String DIR = "assets";

  private List<JTextComponent> validationFields;
  private List<JLabel> errorLabels;

  private IdeaRepository repository;
  private IdeaTableModel articlesTableModel;

  private Idea selectedArticle;

  public IdeasPanel() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    tbArticles = new javax.swing.JTable();
    lbIcon = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    tfTitle = new javax.swing.JTextField();
    lbTitleError = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    tfLink = new javax.swing.JTextField();
    lbLinkError = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    lbDescriptionError = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    taDescription = new javax.swing.JTextArea();
    jLabel8 = new javax.swing.JLabel();
    tfPublishedDate = new javax.swing.JTextField();
    lbPublishedDateError = new javax.swing.JLabel();
    tfPicturePath = new javax.swing.JTextField();
    btnChooseImage = new javax.swing.JButton();
    btnAdd = new javax.swing.JButton();
    btnUpdate = new javax.swing.JButton();
    btnDelete = new javax.swing.JButton();
    lbPicturePathError = new javax.swing.JLabel();

    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        formComponentShown(evt);
      }
    });

    tbArticles.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
            { null, null, null, null },
            { null, null, null, null },
            { null, null, null, null },
            { null, null, null, null }
        },
        new String[] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }));
    tbArticles.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tbArticlesMouseClicked(evt);
      }
    });
    tbArticles.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tbArticlesKeyReleased(evt);
      }
    });
    jScrollPane1.setViewportView(tbArticles);

    lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N

    jLabel2.setText("Title");

    lbTitleError.setForeground(new java.awt.Color(204, 0, 0));
    lbTitleError.setText("X");

    jLabel4.setText("Link");

    lbLinkError.setForeground(new java.awt.Color(204, 0, 0));
    lbLinkError.setText("X");

    jLabel6.setText("Description");

    lbDescriptionError.setForeground(new java.awt.Color(204, 0, 0));
    lbDescriptionError.setText("X");

    taDescription.setColumns(20);
    taDescription.setLineWrap(true);
    taDescription.setRows(5);
    jScrollPane2.setViewportView(taDescription);

    jLabel8.setText("Published date (yyyy-dd-MMThh:mm:ss)");

    tfPublishedDate.setName("Date"); // NOI18N

    lbPublishedDateError.setForeground(new java.awt.Color(204, 0, 0));
    lbPublishedDateError.setText("X");

    tfPicturePath.setEditable(false);

    btnChooseImage.setText("Choose");
    btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnChooseImageActionPerformed(evt);
      }
    });

    btnAdd.setText("Add");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAddActionPerformed(evt);
      }
    });

    btnUpdate.setText("Update");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnUpdateActionPerformed(evt);
      }
    });

    btnDelete.setBackground(new java.awt.Color(204, 0, 51));
    btnDelete.setForeground(new java.awt.Color(255, 255, 255));
    btnDelete.setText("Delete");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnDeleteActionPerformed(evt);
      }
    });

    lbPicturePathError.setForeground(new java.awt.Color(204, 0, 0));
    lbPicturePathError.setText("X");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 604,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfLink, javax.swing.GroupLayout.Alignment.LEADING,
                                                    javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                    .createSequentialGroup()
                                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 279,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                    .createSequentialGroup()
                                                    .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                            false)
                                                        .addComponent(tfPublishedDate)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                            223, Short.MAX_VALUE))
                                                    .addGap(18, 18, 18)
                                                    .addComponent(lbPublishedDateError,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbDescriptionError,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbLinkError, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        20, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 500,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfPicturePath)
                                .addGap(18, 18, 18)
                                .addComponent(btnChooseImage)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbPicturePathError, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTitleError, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbLinkError, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescriptionError, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                            javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPublishedDateError, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPublishedDate, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPicturePathError, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 342,
                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseImage)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap()));
  }// </editor-fold>//GEN-END:initComponents

  private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
    if (!formValid()) {
      return;
    }
    try {
      /* String localPicturePath = uploadPicture();
      Idea article = new Idea(
          tfTitle.getText().trim(),
          tfLink.getText().trim(),
          taDescription.getText().trim(),
          localPicturePath,
          LocalDateTime.parse(tfPublishedDate.getText().trim(), Idea.DATE_FORMATTER));
      repository.createIdea(article);
      articlesTableModel.setIdeas(repository.selectIdeas()); */

      clearForm();
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to create article!");
    }
  }// GEN-LAST:event_btnAddActionPerformed

  private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
    if (selectedArticle == null) {
      MessageUtils.showInformationMessage("Wrong operation", "Please choose article to update");
      return;
    }
    if (!formValid()) {
      return;
    }
    try {
      if (!tfPicturePath.getText().trim().equals(selectedArticle.getPicturePath())) {
        if (selectedArticle.getPicturePath() != null) {
          Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
        }
        String localPicturePath = uploadPicture();
        selectedArticle.setPicturePath(localPicturePath);
      }

      selectedArticle.setTitle(tfTitle.getText().trim());
      selectedArticle.setLink(tfLink.getText().trim());
      selectedArticle.setDescription(taDescription.getText().trim());
      selectedArticle.setPublishedDate(LocalDateTime.parse(tfPublishedDate.getText().trim(), Idea.DATE_FORMATTER));

      repository.updateIdea(selectedArticle.getId(), selectedArticle);
      articlesTableModel.setIdeas(repository.selectIdeas());

      clearForm();
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to update article!");
    }

  }// GEN-LAST:event_btnUpdateActionPerformed

  private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
    if (selectedArticle == null) {
      MessageUtils.showInformationMessage("Wrong operation", "Please choose article to delete");
      return;
    }
    if (MessageUtils.showConfirmDialog(
        "Delete article",
        "Do you really want to delete article?")) {
      try {
        if (selectedArticle.getPicturePath() != null) {
          Files.deleteIfExists(Paths.get(selectedArticle.getPicturePath()));
        }
        repository.deleteIdea(selectedArticle.getId());
        articlesTableModel.setIdeas(repository.selectIdeas());

        clearForm();
      } catch (Exception ex) {
        Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to delete article!");
      }
    }
  }// GEN-LAST:event_btnDeleteActionPerformed

  private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChooseImageActionPerformed
    Optional<File> file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
    if (file.isEmpty()) {
      return;
    }
    tfPicturePath.setText(file.get().getAbsolutePath());
    setIcon(lbIcon, file.get());
  }// GEN-LAST:event_btnChooseImageActionPerformed

  private void setIcon(JLabel label, File file) {
    try {
      label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
    } catch (IOException ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to set icon!");
    }
  }

  private void tbArticlesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tbArticlesMouseClicked
    showArticle();
  }// GEN-LAST:event_tbArticlesMouseClicked

  private void tbArticlesKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_tbArticlesKeyReleased
    showArticle();
  }// GEN-LAST:event_tbArticlesKeyReleased

  // init() cannot be done in JPanel constructor, but when the form is shown!
  // JPanel constructor is called from JFrame constructor, and there may not yet
  // be articles to show
  // articles can be shown only after they have been parsed for the first time
  private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown

    init();
  }// GEN-LAST:event_formComponentShown

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAdd;
  private javax.swing.JButton btnChooseImage;
  private javax.swing.JButton btnDelete;
  private javax.swing.JButton btnUpdate;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JLabel lbDescriptionError;
  private javax.swing.JLabel lbIcon;
  private javax.swing.JLabel lbLinkError;
  private javax.swing.JLabel lbPicturePathError;
  private javax.swing.JLabel lbPublishedDateError;
  private javax.swing.JLabel lbTitleError;
  private javax.swing.JTextArea taDescription;
  private javax.swing.JTable tbArticles;
  private javax.swing.JTextField tfLink;
  private javax.swing.JTextField tfPicturePath;
  private javax.swing.JTextField tfPublishedDate;
  private javax.swing.JTextField tfTitle;
  // End of variables declaration//GEN-END:variables

  private void init() {
    try {
      initValidation();
      hideErrors();
      initRepository();
      initTable();
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
      System.exit(1);
    }
  }

  private void initValidation() {
    validationFields = Arrays.asList(tfTitle, tfLink, taDescription, tfPublishedDate, tfPicturePath);
    errorLabels = Arrays.asList(lbTitleError, lbLinkError, lbDescriptionError, lbPublishedDateError,
        lbPicturePathError);
  }

  private void hideErrors() {
    errorLabels.forEach(e -> e.setVisible(false));
  }

  private void initRepository() throws Exception {
    repository = RepositoryFactory.getIdeaRepository();
  }

  private void initTable() throws Exception {
    tbArticles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tbArticles.setAutoCreateRowSorter(true);
    tbArticles.setRowHeight(25);
    articlesTableModel = new IdeaTableModel(repository.selectIdeas());
    tbArticles.setModel(articlesTableModel);
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
    return ok;
  }

  private void clearForm() {
    hideErrors();
    validationFields.forEach(e -> e.setText(""));
    lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png")));
    selectedArticle = null;
  }

  private String uploadPicture() throws IOException {
    String picturePath = tfPicturePath.getText();
    String ext = picturePath.substring(picturePath.lastIndexOf("."));
    String pictureName = UUID.randomUUID() + ext;
    String localPicturePath = DIR + File.separator + pictureName;

    FileUtils.copy(picturePath, localPicturePath);
    return localPicturePath;
  }

  private void showArticle() {
    clearForm();
    int selectedRow = tbArticles.getSelectedRow();
    int rowIndex = tbArticles.convertRowIndexToModel(selectedRow);
    int selectedArticleId = (int) articlesTableModel.getValueAt(rowIndex, 0);

    try {
      Optional<Idea> optArticle = repository.selectIdea(selectedArticleId);
      if (optArticle.isPresent()) {
        selectedArticle = optArticle.get();
        fillForm(selectedArticle);
      }
    } catch (Exception ex) {
      Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Error", "Unable to show article!");
    }
  }

  private void fillForm(Idea article) {
    if (article.getPicturePath() != null && Files.exists(Paths.get(article.getPicturePath()))) {
      tfPicturePath.setText(article.getPicturePath());
      setIcon(lbIcon, new File(article.getPicturePath()));
    }
    tfTitle.setText(article.getTitle());
    tfLink.setText(article.getLink());
    taDescription.setText(article.getDescription());
    tfPublishedDate.setText(article.getPublishedDate().format(Idea.DATE_FORMATTER));
  }

}
