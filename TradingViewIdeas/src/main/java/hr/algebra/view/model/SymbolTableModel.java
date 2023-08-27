package hr.algebra.view.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import hr.algebra.model.Symbol;

public class SymbolTableModel extends AbstractTableModel {

  private static final String[] COLUMN_NAMES = { "Id", "Name", "Description", "Link" };

  private List<Symbol> symbols;

  public SymbolTableModel(List<Symbol> symbols) {
    this.symbols = symbols;
  }

  public void setSymbols(List<Symbol> symbols) {
    this.symbols = symbols;
    fireTableDataChanged();
  }

  @Override
  public int getRowCount() {
    return symbols.size();
  }

  @Override
  public int getColumnCount() {
    return COLUMN_NAMES.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return symbols.get(rowIndex).getId();
      case 1:
        return symbols.get(rowIndex).getName();
      case 2:
        return symbols.get(rowIndex).getDescription();
      case 3:
        return symbols.get(rowIndex).getLink();
      default:
        throw new RuntimeException("No such column");
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
