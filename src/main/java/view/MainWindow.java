package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JComponent {
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JPanel headerPanel;
    private final JFrame mainWindow = new JFrame();
    private StorageWindow storageWindow;

    public static void main(String[] args) {
        new MainWindow().init();
    }

    public void init() {
        // Инициализация главного окна
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

        // Инициализация контента приложения
        contentPanel = new JPanel();
        storageWindow = new StorageWindow();
        CardLayout cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);
        contentPanel.add(storageWindow.getContentPane(), "Storage");

        // Инициализация хэдера приложения
        headerPanel = new JPanel();


        // Инициализация главного меню приложения
        menuPanel = new JPanel();
        MenuBar menuBar = new MenuBar();
        // Подписчики меню приложения
        menuBar.getStorageButton().addActionListener(e -> cardLayout.show(contentPanel, "Storage"));
        menuPanel.add(menuBar.getNavigationBarPanel());
    }

}
