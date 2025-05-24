package view.listeners;

import controller.Controller;
import model.Product;
import view.MainWindowOld;
import view.Operation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsListener implements ActionListener {
    private Controller controller;
    private MainWindowOld mainWindowOld;

    public ButtonsListener(Controller controller, MainWindowOld mainWindowOld) {
        this.controller = controller;
        this.mainWindowOld = mainWindowOld;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Operation.ADD_PRODUCT.getName())) {
            this.controller.createProduct();
        }
        if (e.getActionCommand().equals(Operation.DELETE_PRODUCT.getName())) {
            Product productSelected = mainWindowOld.getProductSelected();
            if (productSelected != null) {
                this.controller.deleteProduct(productSelected.getId());
            }
        }
    }
}
