package view;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuBar extends JPanel {
    private JButton storageButton;
    private JPanel navigationBarPanel;
    private JButton productsButton;
    private JButton editProductsButton;
    private JButton historyButton;

    public JPanel getNavigationBarPanel() {
        return navigationBarPanel;
    }

    public MenuBar() {
        storageButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click mouse");
            }
        });
    }

    public JButton getStorageButton() {
        return storageButton;
    }

    public JButton getProductsButton() {
        return productsButton;
    }

    public JButton getEditProductsButton() {
        return editProductsButton;
    }

    public JButton getHistoryButton() {
        return historyButton;
    }
}
