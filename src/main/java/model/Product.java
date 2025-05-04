package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private int article;
    private String name;
    private List<Product> components;
    private SectionProduct section; // раздел покупной единицы

    public Product(int id, int article, String name, SectionProduct section) {
        this.id = id;
        this.article = article;
        this.name = name;
        this.components = new ArrayList<>();
        this.section = section;
    }

    public void setComponents(List<Product> components) {
        this.components = components;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return article + " " + name;
    }
}
