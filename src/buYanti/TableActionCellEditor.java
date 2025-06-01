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
import java.util.ArrayList;
import java.util.List;
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
                // Ambil data dari DashboardAdmin.arsipData berdasarkan baris
        LaundryData data = DashboardAdmin.arsipData.get(row);

        // Siapkan data layanan sesuai format konstruktor Nota
        List<Object[]> layanan = new ArrayList<>();
        layanan.add(new Object[]{data.getLayanan(), data.getBerat(), data.getHarga()});

        // Buka jendela Nota dengan data lengkap
        Nota nota = new Nota(
            data.getNama(),
            data.getDeadline(),
            data.getAlamat(),
            layanan
        );
        nota.setVisible(true);
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
