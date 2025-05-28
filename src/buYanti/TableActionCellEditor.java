/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buYanti;

/**
 *
 * @author abida
 */
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class TableActionCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JButton button;
    private int row;

    public TableActionCellEditor(JTable table) {
        button = new JButton("Lihat Nota");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped(); // Stop editing
                // 🔽 Aksi ketika tombol ditekan
                // Ambil data dari baris yang sesuai, misalnya:
                String nama = table.getValueAt(row, 0).toString();
                System.out.println("Lihat nota untuk: " + nama);

                // Contoh: buka jendela Nota.java
                new Nota().setVisible(true);
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        this.row = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
