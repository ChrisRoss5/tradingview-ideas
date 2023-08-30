package hr.algebra.view.model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.AbstractTableModel;

import hr.algebra.MessageUtils;
import hr.algebra.dal.repository.SymbolRepository;
import hr.algebra.model.Symbol;
import hr.algebra.view.IdeasPanel;

public class SymbolTableModel extends AbstractTableModel {

  private static final String[] COLUMN_NAMES = { "Id", "Name", "Description", "Link", "" };

  private List<Symbol> symbols;
  private SymbolRepository symbolRepository;

  public SymbolTableModel(SymbolRepository symbolRepository) throws Exception {
    this.symbolRepository = symbolRepository;
    setSymbols(symbolRepository.selectSymbols());
  }

  public void setSymbols(List<Symbol> symbols) {
    this.symbols = symbols;
    fireTableDataChanged();
  }

  public boolean addSymbol(Symbol symbol) {
    try {
      int symbolId = symbolRepository.createSymbol(symbol);
      symbols.add(new Symbol(symbolId, symbol.getName(), symbol.getDescription(), symbol.getLink()));
      int newRow = symbols.size() - 1;
      fireTableRowsInserted(newRow, newRow);
      return true;
    } catch (Exception ex) {
      if (ex.getMessage().contains("Violation of UNIQUE KEY constraint")) {
        MessageUtils.showErrorMessage("Error", "Symbol with this link already exists!");
      } else {
        Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to create symbol!");
      }
    }
    return false;
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
    Symbol symbol = symbols.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return symbol.getId();
      case 1:
        return symbol.getName();
      case 2:
        return symbol.getDescription();
      case 3:
        return symbol.getLink();
      case 4:
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
    Symbol symbol = symbols.get(rowIndex);
    if (columnIndex == getColumnCount() - 1) {
      if (!MessageUtils.showConfirmDialog("Delete symbol",
          "Are you sure you want to delete " + symbol.getName() + "?")) {
        return;
      }
      try {
        symbolRepository.deleteSymbol(symbol.getId());
        symbols.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
      } catch (Exception ex) {
        Logger.getLogger(SymbolTableModel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to delete symbol!");
      }
      return;
    }
    try {
      switch (columnIndex) {
        case 1:
          symbol.setName((String) value);
          break;
        case 2:
          symbol.setDescription((String) value);
          break;
        case 3:
          symbol.setLink((String) value);
          break;
      }
      symbolRepository.updateSymbol(symbol.getId(), symbol);
      fireTableRowsUpdated(rowIndex, rowIndex);
    } catch (Exception ex) {
      if (ex.getMessage().contains("Violation of UNIQUE KEY constraint")) {
        MessageUtils.showErrorMessage("Error", "Symbol with this link already exists!");
      } else {
        Logger.getLogger(IdeasPanel.class.getName()).log(Level.SEVERE, null, ex);
        MessageUtils.showErrorMessage("Error", "Unable to update symbol!");
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
