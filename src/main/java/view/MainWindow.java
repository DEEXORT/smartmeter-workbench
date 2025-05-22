package view;

import controller.Controller;
import model.SectionProduct;
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
    private final Vector<Product> vectorProducts = new Vector<>();
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
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        JPanel productsPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton newProduct = new JButton("Добавить продукт");
        addButtonToPanel("Добавить продукцию", Operation.ADD_PRODUCT, buttonPanel);

        JButton deleteProduct = new JButton("Удалить продукт");
        addButtonToPanel("Удалить продукцию", Operation.DELETE_PRODUCT, buttonPanel);

        productList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                productSelected = productList.getSelectedValue();
            }
        });

        // Лист с продукцией
        getProducts();
        JScrollPane jScrollPane = new JScrollPane(productList);
        jScrollPane.setPreferredSize(new Dimension(400, 400));
        productsPanel.add(jScrollPane);

        // Добавление компонентов в контейнер
        getContentPane().add(productsPanel);
        getContentPane().add(buttonPanel);

        initFieldCreateProduct();

        setVisible(true);
    }

    private void addButtonToPanel(String btnName, Operation operation, JPanel panel) {
        JButton newButton = new JButton(btnName);
        newButton.setActionCommand(operation.getName());
        newButton.addActionListener(new ButtonsListener(controller, this));
        panel.add(newButton);
    }

    public void exit() {
        this.controller.exit();
    }

    public void updateProductList() {
        System.out.println("Обновление списка продукции...");
        vectorProducts.clear(); // Чистка старых значений
        getProducts();
    }

    // Получение списка продукции из БД
    private void getProducts() {
        List<Product> products = controller.getAllProducts();
        for (Product product : products) {
            vectorProducts.add(product);
            System.out.println(product);
        }
        productList.setListData(vectorProducts);
    }

    // Инициализация формы для добавления продукции
    private void initFieldCreateProduct() {
        JPanel formProductPanel = new JPanel();
        // Поле для введения артикула
        JTextField textFieldArticle = new JTextField(15);
        // Поле для введения имени продукции
        JTextField textFieldName = new JTextField(15);
        // SelectBox для выбора категории продукции
        JComboBox<String> comboBoxSection = new JComboBox<>();
        for (SectionProduct section : SectionProduct.values()) {
            comboBoxSection.addItem(section.getName());
        }
        formProductPanel.add(textFieldArticle);
        formProductPanel.add(textFieldName);
        formProductPanel.add(comboBoxSection);

        getContentPane().add(formProductPanel);
    }

    private void deleteProduct() {

    }
}
