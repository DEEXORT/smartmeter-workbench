package controller;

import model.Model;
import model.Product;
import model.SectionProduct;
import view.MainWindowOld;

import java.util.List;

public class Controller {
    private Model model;
    private MainWindowOld mainWindowOld;

    public Controller(Model model) {
        this.model = model;
        this.mainWindowOld = new MainWindowOld(this);
    }

    public void createProduct() {
        Product meter = this.model.createProduct(1, 6782345, "Счетчик", SectionProduct.PRODUCT);
        System.out.println("Добавлен продукт " + meter);
        this.mainWindowOld.updateProductList();
    }

    public void exit() {
        System.exit(0);
    }

    public void deleteProduct(int id) {
        this.model.deleteProduct(id);
        this.mainWindowOld.updateProductList();
    }

    public List<Product> getAllProducts() {
        return this.model.getAllProducts();
    }
}
