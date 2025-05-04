package controller;

import model.Model;
import model.Product;
import model.SectionProduct;
import view.MainWindow;

import java.util.List;

public class Controller {
    private Model model;
    private MainWindow mainWindow;

    public Controller(Model model) {
        this.model = model;
        this.mainWindow = new MainWindow(this);
    }

    public void createProduct() {
        Product meter = this.model.createProduct(1, 6782345, "Счетчик", SectionProduct.PRODUCT);
        System.out.println("Добавлен продукт " + meter);
        this.mainWindow.updateProductList();
    }

    public void exit() {
        System.exit(0);
    }

    public void deleteProduct(int id) {
        this.model.deleteProduct(id);
        this.mainWindow.updateProductList();
    }

    public List<Product> getAllProducts() {
        return this.model.getAllProducts();
    }
}
