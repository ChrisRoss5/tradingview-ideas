/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileUtils {

  private static final String UPLOAD = "Upload";

  public static Optional<File> uploadFile(String description, String... extensions) {
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    chooser.setFileFilter(new FileNameExtensionFilter(description, extensions));
    chooser.setDialogTitle(UPLOAD);
    chooser.setApproveButtonText(UPLOAD);
    chooser.setApproveButtonToolTipText(UPLOAD);
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      File selectedFile = chooser.getSelectedFile();
      String extension = selectedFile.getName().substring(selectedFile.getName().lastIndexOf(".") + 1);
      return Arrays.asList(extensions).contains(extension.toLowerCase()) ? Optional.of(selectedFile) : Optional.empty();
    }
    return Optional.empty();
  }
}
