package view;

import controller.Controller;
import listeners.ButtonsListener;
import model.Product;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainWindow extends JFrame {
    private Controller controller;
    Vector<Product> vectorProducts = new Vector<>();
    private JPanel productsPanel = new JPanel();
    private List<Product> products = new ArrayList<>();
    private JList<Product> productList = new JList<>();

    public Product getProductSelected() {
        return productSelected;
    }

    private Product productSelected;

    public MainWindow(Controller controller) {
        this.controller = controller;
        init();
    }

    private void init() {
        initGui();
//        FrameListener frameListener = new FrameListener(this);
    }

    private void initGui() {
        setTitle("SmartMeter Workbench");
        setResizable(true);
        setMinimumSize(new Dimension(800,500));
        getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton newProduct = new JButton("Добавить продукт");
        JButton deleteProduct = new JButton("Удалить продукт");

        newProduct.setActionCommand(Operation.ADD_PRODUCT.getName());
        deleteProduct.setActionCommand(Operation.DELETE_PRODUCT.getName());

        // Подписчики
        newProduct.addActionListener(new ButtonsListener(controller, this));
        deleteProduct.addActionListener(new ButtonsListener(controller, this));
        productList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                productSelected = productList.getSelectedValue();
            }
        });

        productsPanel.add(newProduct);
        productsPanel.add(deleteProduct);

        showProductList();
        setVisible(true);
    }

    public void exit() {
        this.controller.exit();
    }

    private void showProductList() {
        getProducts();
        JScrollPane jScrollPane = new JScrollPane(productList);
        jScrollPane.setPreferredSize(new Dimension(400, 400));
        productsPanel.add(jScrollPane);
        getContentPane().add(productsPanel);
    }

    public void updateProductList() {
        System.out.println("Обновление списка продукции...");
        vectorProducts.clear(); // Чистка старых значений
        getProducts();
    }

    private void getProducts() {
        // Получение списка продукции из модели
        products = controller.getAllProducts();
        for (Product product : products) {
            vectorProducts.add(product);
            System.out.println(product);
        }
        productList.setListData(vectorProducts);
    }

    private void deleteProduct() {

    }
}
