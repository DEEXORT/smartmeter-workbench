package view;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StorageTableModel extends AbstractTableModel {
    private int countColumns = 5;
    private ArrayList<String[]> data;

    public StorageTableModel() {
        this.data = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return countColumns;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = data.get(rowIndex);
        return row[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 -> {
                return "Артикул";
            }
            case 1 -> {
                return "Наименование";
            }
            case 2 -> {
                return "Единица измерения";
            }
            case 3 -> {
                return "Описание";
            }
        }
        return "";
    }

    public void addDataRow(String[] row) {
        data.add(row);
    }
}
