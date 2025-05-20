package listeners;

import controller.Controller;
import model.Product;
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
            Product productSelected = mainWindow.getProductSelected();
            if (productSelected != null) {
                this.controller.deleteProduct(productSelected.getId());
            }
        }
    }
}
