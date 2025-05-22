package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StorageWindow extends JComponent {
    private JPanel contentPane;
    private StorageTableModel storageTableModel;
    private JTable storageTable;
    private JScrollPane tableScrollPane;
    private JButton addItem;
    private JButton deleteItem;
    private JButton editItem;
    private JButton searchButton;
    private JTextField searchField;
    private JTextArea AplicabilityTextArea;
    private JTable applicabilityItemTable;


//    public StorageWindow() {
//        // Инициализация модели таблицы
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("Артикул");
//        model.addColumn("Наименование");
//        model.addColumn("Единица измерения");
//        model.addColumn("Описание");
//        model.addRow(new Object[]{1234567, "Продукт", "шт.", "описание продукта"});
//        storageTable.setModel(model);
//    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new StorageWindow().contentPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

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
    }
}
