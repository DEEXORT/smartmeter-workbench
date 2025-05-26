package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JComponent {
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JPanel headerPanel;
    private final JFrame mainWindow = new JFrame();

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
        // Инициализация хэдера приложения
        headerPanel = new JPanel();


        // Инициализация главного меню приложения
        menuPanel = new JPanel();
        MenuBar menuBar = new MenuBar();
        // Подписчики меню приложения
        menuBar.getStorageButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                contentPanel.add(new StorageWindow().getContentPane());
                mainWindow.pack();
                mainWindow.setLocationRelativeTo(null);
            }
        });
        menuPanel.add(menuBar.getNavigationBarPanel());
    }
}
