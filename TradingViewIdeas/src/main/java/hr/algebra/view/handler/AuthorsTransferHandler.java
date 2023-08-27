package hr.algebra.view.handler;

import java.awt.datatransfer.Transferable;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.TransferHandler;

import hr.algebra.model.Author;

public class AuthorsTransferHandler extends TransferHandler {

  boolean preserveModel;

  public AuthorsTransferHandler(boolean preserveModel) {
    this.preserveModel = preserveModel;
  }

  @Override
  public int getSourceActions(JComponent c) {
    return COPY_OR_MOVE;
  }

  @Override
  protected Transferable createTransferable(JComponent c) {
    JList<Author> list = (JList<Author>) c;
    List<Author> selectedAuthors = list.getSelectedValuesList();
    return new AuthorTransferable(selectedAuthors);
  }

  @Override
  protected void exportDone(JComponent source, Transferable data, int action) {
    if (action == MOVE && preserveModel) {
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
    if (!preserveModel) {
      return true;
    }
    if (!canImport(support)) {
      return false;
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