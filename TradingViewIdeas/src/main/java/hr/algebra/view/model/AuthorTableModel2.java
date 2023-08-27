package hr.algebra.view.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import hr.algebra.model.Author;

public class AuthorTableModel2 extends AbstractTableModel {

  private static final String[] COLUMN_NAMES = { "Id", "Name", "Link", "Delete" };

  private List<Author> authors;

  public AuthorTableModel2(List<Author> authors) {
    this.authors = authors;
  }

  public void setAuthors(List<Author> authors) {
    this.authors = authors;
    fireTableDataChanged();
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
        return null;
    }
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return columnIndex != 0; // Make all columns except the first one editable
  }

  @Override
  public void setValueAt(Object value, int rowIndex, int columnIndex) {
    if (columnIndex == 3) { // Delete button column
      authors.remove(rowIndex);
      fireTableRowsDeleted(rowIndex, rowIndex);
    }
    System.out.println("Value: " + value + ", row: " + rowIndex + ", column: " + columnIndex);
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
