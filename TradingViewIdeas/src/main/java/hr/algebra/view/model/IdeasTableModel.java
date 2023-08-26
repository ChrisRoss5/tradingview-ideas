package hr.algebra.view.model;

import hr.algebra.model.Idea;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class IdeasTableModel extends AbstractTableModel {

  private static final String[] COLUMN_NAMES = {
      "Id", "Title", "Link", "Description", "Published date", "Symbol", "Market", "Picture path" };

  private List<Idea> ideas;

  public IdeasTableModel(List<Idea> ideas) {
    this.ideas = ideas;
  }

  public void setIdeas(List<Idea> ideas) {
    this.ideas = ideas;
    fireTableDataChanged();
  }

  @Override
  public int getRowCount() {
    return ideas.size();
  }

  @Override
  public int getColumnCount() {
    // return Article.class.getDeclaredFields().length - 1;
    return COLUMN_NAMES.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return ideas.get(rowIndex).getId();
      case 1:
        return ideas.get(rowIndex).getTitle();
      case 2:
        return ideas.get(rowIndex).getLink();
      case 3:
        return ideas.get(rowIndex).getDescription();
      case 4:
        return ideas.get(rowIndex).getPublishedDate().format(Idea.DATE_FORMATTER);
      case 5:
        return ideas.get(rowIndex).getSymbol().getName();
      case 6:
        return ideas.get(rowIndex).getMarket().getName();
      case 7:
        return ideas.get(rowIndex).getPicturePath();
      default:
        throw new RuntimeException("No such column");
    }
  }

  @Override
  public String getColumnName(int column) {
    return COLUMN_NAMES[column];
  }

  // important for the id ordering
  @Override
  public Class<?> getColumnClass(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return Integer.class;
    }
    return super.getColumnClass(columnIndex);
  }
}
