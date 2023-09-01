package hr.algebra.view.handler;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.List;

import hr.algebra.model.Author;

public class AuthorTransferable implements Transferable {
  public static final DataFlavor AUTHOR_FLAVOR = new DataFlavor(
      Author.class, "Author");

  private final List<Author> authors;

  public AuthorTransferable(List<Author> authors) {
    this.authors = authors;
  }

  public List<Author> getAuthors() {
    return authors;
  }

  @Override
  public DataFlavor[] getTransferDataFlavors() {
    return new DataFlavor[] { AUTHOR_FLAVOR };
  }

  @Override
  public boolean isDataFlavorSupported(DataFlavor flavor) {
    return flavor.equals(AUTHOR_FLAVOR);
  }

  @Override
  public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
    if (isDataFlavorSupported(flavor)) {
      return authors;
    }
    throw new UnsupportedFlavorException(flavor);
  }
}
