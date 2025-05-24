package view;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ApplicabilityTableModel extends AbstractTableModel {
    // Модель таблицы применяемости комплектующих в продукции
    private final int countColumns = 2;
    private ArrayList<String[]> dataProduct;

    public ApplicabilityTableModel() {
        this.dataProduct = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return dataProduct.size();
    }

    @Override
    public int getColumnCount() {
        return countColumns;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 -> {return "Артикул";}
            case 1 -> {return "Наименование";}
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] row = dataProduct.get(rowIndex);
        return row[columnIndex];
    }

    public void addData(String[] row) {
        dataProduct.add(row);
    }
}
