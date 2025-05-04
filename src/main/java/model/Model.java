import java.util.List;

public class Model {
    private List<Product> products;

    Model() {

    }

    // Создание продукта без внутренних компонентов
    Product createProduct(int id, int article, String name, SectionProduct section) {
        return new Product(id, article, name, section);
    }

    // Создание продукта с внутренними компонентами
    Product createProduct(int id,
                          int article,
                          String name,
                          SectionProduct section,
                          List<Product> products) {

        Product product = new Product(id, article, name, section);
        product.setComponents(products);
        return product;
    }
}
