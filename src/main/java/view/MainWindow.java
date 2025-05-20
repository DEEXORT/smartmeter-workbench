package view;

import controller.Controller;
import view.listeners.ButtonsListener;
import model.Product;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class MainWindow extends JFrame {
    private final Controller controller;
    Vector<Product> vectorProducts = new Vector<>();
    private final JPanel productsPanel = new JPanel();
    private final JList<Product> productList = new JList<>(); // JFrame список с продукцией
    private Product productSelected; // Выбранная продукция из списка

    public Product getProductSelected() {
        return productSelected;
    }

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
        addButtonToPanel("Добавить продукцию", Operation.ADD_PRODUCT);

        JButton deleteProduct = new JButton("Удалить продукт");
        addButtonToPanel("Удалить продукцию", Operation.DELETE_PRODUCT);

        productList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                productSelected = productList.getSelectedValue();
            }
        });

        getProducts();
        JScrollPane jScrollPane = new JScrollPane(productList);
        jScrollPane.setPreferredSize(new Dimension(400, 400));
        productsPanel.add(jScrollPane);
        getContentPane().add(productsPanel);

        setVisible(true);
    }

    private void addButtonToPanel(String btnName, Operation operation) {
        JButton newButton = new JButton(btnName);
        newButton.setActionCommand(operation.getName());
        newButton.addActionListener(new ButtonsListener(controller, this));
        productsPanel.add(newButton);
    }

    public void exit() {
        this.controller.exit();
    }

    public void updateProductList() {
        System.out.println("Обновление списка продукции...");
        vectorProducts.clear(); // Чистка старых значений
        getProducts();
    }

    private void getProducts() {
        // Получение списка продукции из БД
        List<Product> products = controller.getAllProducts();
        for (Product product : products) {
            vectorProducts.add(product);
            System.out.println(product);
        }
        productList.setListData(vectorProducts);
    }

    private void deleteProduct() {

    }
}
