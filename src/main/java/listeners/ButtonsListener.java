package listeners;

import controller.Controller;
import view.MainWindow;
import view.Operation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener implements ActionListener {
    private Controller controller;
    private MainWindow mainWindow;

    public ButtonsListener(Controller controller, MainWindow mainWindow) {
        this.controller = controller;
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Operation.ADD_PRODUCT.getName())) {
            this.controller.createProduct();
        }
        if (e.getActionCommand().equals(Operation.DELETE_PRODUCT.getName())) {
            this.controller.deleteProduct(mainWindow.getProductSelected().getId());
        }
    }
}
