package hr.algebra.view.handler;

import java.awt.datatransfer.Transferable;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.TransferHandler;

import hr.algebra.model.Author;

public class AuthorsTransferHandler extends TransferHandler {

  private static boolean isImportingToPreservedModelList = false;
  private final boolean preserveModel;

  public AuthorsTransferHandler(boolean preserveModel) {
    this.preserveModel = preserveModel;
  }

  @Override
  public int getSourceActions(JComponent c) {
    return MOVE;
  }

  @Override
  protected Transferable createTransferable(JComponent c) {
    List<Author> selectedAuthors = ((JList<Author>) c).getSelectedValuesList();
    return new AuthorTransferable(selectedAuthors);
  }

  @Override
  protected void exportDone(JComponent source, Transferable data, int action) {
    if (action == MOVE && !preserveModel && isImportingToPreservedModelList) {
      JList<Author> list = (JList<Author>) source;
      AuthorTransferable transferable = (AuthorTransferable) data;
      DefaultListModel<Author> model = (DefaultListModel<Author>) list.getModel();
      for (Author author : transferable.getAuthors()) {
        model.removeElement(author);
      }
    }
  }

  @Override
  public boolean canImport(TransferSupport support) {
    return support.isDataFlavorSupported(AuthorTransferable.AUTHOR_FLAVOR);
  }

  @Override
  public boolean importData(TransferSupport support) {
    if (!canImport(support)) {
      return false;
    }
    isImportingToPreservedModelList = preserveModel;
    if (preserveModel) {
      return true;
    }
    JList<Author> targetList = (JList<Author>) support.getComponent();
    DefaultListModel<Author> model = (DefaultListModel<Author>) targetList.getModel();
    Transferable transferable = support.getTransferable();
    try {
      List<Author> authors = (List<Author>) transferable.getTransferData(AuthorTransferable.AUTHOR_FLAVOR);
      for (Author author : authors) {
        if (!model.contains(author)) {
          model.addElement(author);
        }
      }
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}