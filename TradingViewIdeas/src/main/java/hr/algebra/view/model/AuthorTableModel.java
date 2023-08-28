package hr.algebra.view.model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.AbstractTableModel;

import hr.algebra.dal.repository.AuthorRepository;
import hr.algebra.model.Author;
import hr.algebra.utilities.MessageUtils;
import hr.algebra.view.IdeasPanel;

public class AuthorTableModel extends AbstractTableModel {

  private static final String[] COLUMN_NAMES = { "Id", "Name", "Link", "" };

  private List<Author> authors;
  private AuthorRepository authorRepository;

  public AuthorTableModel(AuthorRepository authorRepository) throws Exception {
    this.authorRepository = authorRepository;
    setAuthors(authorRepository.selectAuthors());
  }

  public void setAuthors(List<Author> authors) {
    this.authors = authors;
    fireTableDataChanged();
  }

  public boolean addAuthor(Author author) {
    try {
      int authorId = authorRepository.createAuthor(author);
      authors.add(new Author(authorId, author.getName(), author.getLink()));
      int newRow = authors.size() - 1;
      fireTableRowsInserted(newRow, newRow);
      return true;
    } catch (Exception ex) {
      if (ex.getMessage().contains("Violation of UNIQUE KEY constraint")) {
        MessageUtils.showErrorMessage("Error", "Author with this link already exists!");
      } else {
        Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to create author!");
      }
    }
    return false;
  }

  @Override
  public int getRowCount() {
    return authors.size();
  }

  @Override
  public int getColumnCount() {
    return COLUMN_NAMES.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Author author = authors.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return author.getId();
      case 1:
        return author.getName();
      case 2:
        return author.getLink();
      case 3:
        return "Delete";
      default:
        throw new RuntimeException("No such column");
    }
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return columnIndex != 0;
  }

  @Override
  public void setValueAt(Object value, int rowIndex, int columnIndex) {
    Author author = authors.get(rowIndex);
    if (columnIndex == getColumnCount() - 1) {
      if (!MessageUtils.showConfirmDialog("Delete author",
          "Are you sure you want to delete " + author.getName() + "?")) {
        return;
      }
      try {
        authorRepository.deleteAuthor(author.getId());
        authors.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
      } catch (Exception ex) {
        Logger.getLogger(AuthorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to delete author!");
      }
      return;
    }
    try {
      switch (columnIndex) {
        case 1:
          author.setName((String) value);
          break;
        case 2:
          author.setLink((String) value);
          break;
      }
      authorRepository.updateAuthor(author.getId(), author);
      fireTableRowsUpdated(rowIndex, rowIndex);
    } catch (Exception ex) {
      if (ex.getMessage().contains("Violation of UNIQUE KEY constraint")) {
        MessageUtils.showErrorMessage("Error", "Author with this link already exists!");
      } else {
        Logger.getLogger(AuthorTableModel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to update author!");
      }
    }
  }

  @Override
  public String getColumnName(int column) {
    return COLUMN_NAMES[column];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return Integer.class;
    }
    return super.getColumnClass(columnIndex);
  }
}
