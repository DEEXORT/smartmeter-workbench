package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Product> products = new ArrayList<>();

    public Model() {
        // Тестовые изначальные данные
        products.add(new Product(32, 123563, "test", SectionProduct.PRODUCT));
    }

    // Создание продукта без внутренних компонентов
    public Product createProduct(int id, int article, String name, SectionProduct section) {
        Product newProduct = new Product(id, article, name, section);
        products.add(newProduct);
        return newProduct;
    }

    // Удаление продукта из списка
    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    // Создание продукта с внутренними компонентами
    public Product createProduct(int id,
                          int article,
                          String name,
                          SectionProduct section,
                          List<Product> products) {

        Product newProduct = new Product(id, article, name, section);
        newProduct.setComponents(products);
        products.add(newProduct);
        return newProduct;
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
