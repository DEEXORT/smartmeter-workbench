package view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JComponent {
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JPanel headerPanel;

    public static void main(String[] args) {
        new MainWindow().init();
    }

    public void init() {
        // Инициализация главного окна
        JFrame mainWindow = new JFrame();
        mainWindow.setContentPane(mainPanel);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setLocationRelativeTo(null); // Позиционирование по центру
        mainWindow.setVisible(true);
        mainWindow.setMinimumSize(mainWindow.getSize());

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        // Инициализация главной панели GUI
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Инициализация главного меню приложения
        menuPanel = new JPanel();
        menuPanel.add(new MenuBar().getNavigationBarPanel());

        // Инициализация контента приложения
        contentPanel = new JPanel();
        contentPanel.add(new StorageWindow().getContentPane());

        // Инициализация хэдера приложения
        headerPanel = new JPanel();
    }
}
