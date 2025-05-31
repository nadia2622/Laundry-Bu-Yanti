/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buYanti;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;


/**
 *
 * @author HP
 */
public class TabelActionCellEditor extends AbstractCellEditor implements TableCellEditor{
    
    private PanelAction action;
    private final DashboardAdmin dashboard;
    private int editingRow;
    
    public TabelActionCellEditor(DashboardAdmin dashboard){
        this.dashboard = dashboard;
        
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) {
        
        this.editingRow = row;
        action = new PanelAction();

        action.cmdEdit.addActionListener(e -> {
            fireEditingStopped();
            
            String nama = (String) dashboard.getTable().getValueAt(editingRow, 0);
            String layanan = (String) dashboard.getTable().getValueAt(editingRow, 1);
            String alamat = (String) dashboard.getTable().getValueAt(editingRow, 2);
            String berat = (String) dashboard.getTable().getValueAt(editingRow, 3);
            String harga = (String) dashboard.getTable().getValueAt(editingRow, 4);
            String deadline = (String) dashboard.getTable().getValueAt(editingRow, 5);
            
            KelolaData kelolaData = new KelolaData(dashboard);
            kelolaData.setData(nama, layanan, alamat, berat, harga, deadline, editingRow);
            kelolaData.setVisible(true);
            dashboard.setVisible(false);
            
        });

        action.cmdDelete.addActionListener(e -> {
            fireEditingStopped();
            
            int confirm = JOptionPane.showConfirmDialog(null, "Yakin data akan dihapus?", "Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) dashboard.getTable().getModel();
                model.removeRow(editingRow);
            }
        });
        
        action.cmdDone.addActionListener(e -> {
        fireEditingStopped();

        String nama = (String) dashboard.getTable().getValueAt(editingRow, 0);
        String layanan = (String) dashboard.getTable().getValueAt(editingRow, 1);
        String alamat = (String) dashboard.getTable().getValueAt(editingRow, 2);
        String berat = (String) dashboard.getTable().getValueAt(editingRow, 3);
        String harga = (String) dashboard.getTable().getValueAt(editingRow, 4);
        String deadline = (String) dashboard.getTable().getValueAt(editingRow, 5);

        LaundryData data = new LaundryData(nama, layanan, alamat, berat, harga, deadline);
        DashboardAdmin.arsipData.add(data);
        
        DefaultTableModel model = (DefaultTableModel) dashboard.getTable().getModel();
        model.removeRow(editingRow);

        JOptionPane.showMessageDialog(null, "Data berhasil dipindahkan ke Arsip.");
    });


        return action;
    }
    
    @Override
    public Object getCellEditorValue() {
        return null;
    }
}

