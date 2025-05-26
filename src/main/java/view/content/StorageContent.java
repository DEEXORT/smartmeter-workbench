package view.content;

import view.ApplicabilityTableModel;
import view.StorageTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StorageContent extends JComponent {
    private JPanel contentPane;
    private StorageTableModel storageTableModel;
    private JTable storageTable;
    private JScrollPane tableScrollPane;
    private JButton addItem;
    private JButton deleteItem;
    private JButton editItem;
    private JButton searchButton;
    private JTextField searchField;
    private JTable applicabilityItemTable;
    private JLabel applicabilityLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Артикул");
        model.addColumn("Наименование");
        model.addColumn("Единица измерения");
        model.addColumn("Описание");
        model.addRow(new Object[]{1234567, "Продукт", "шт.", "описание продукта"});
        storageTable = new JTable(model);

        ApplicabilityTableModel applicabilityTableModel = new ApplicabilityTableModel();
        applicabilityTableModel.addData(new String[]{"7772842", "Счетчик электроэнергии 3Ф НЕВА СТ414 139 BCSPIO22-G3E"});
        applicabilityItemTable = new JTable(applicabilityTableModel);
        applicabilityItemTable.getColumnModel().getColumn(0).setMaxWidth(100);
    }

    public JPanel getContentPane() {
        return contentPane;
    }
}
