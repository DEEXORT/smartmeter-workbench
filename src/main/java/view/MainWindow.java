package view;

import javax.swing.*;

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
        mainWindow.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        mainPanel = new JPanel();
        menuPanel = new JPanel();
        menuPanel.add(new NavigationBarWindow().getNavigationBarPanel());
        contentPanel = new JPanel();
        headerPanel = new JPanel();
    }
}
