package hr.algebra.view.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ButtonCellEditor extends DefaultCellEditor {

  protected JButton button;

  public ButtonCellEditor() {
    super(new JCheckBox());
    button = new JButton();
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    button.setText((value == null) ? "" : value.toString());
    return button;
  }
}