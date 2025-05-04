package view;

import controller.Controller;
import listeners.FrameListener;

import javax.swing.*;

public class View extends JFrame {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        init();
    }

    private void init() {
        initGui();
        FrameListener frameListener = new FrameListener(this);
    }

    private void initGui() {
        setTitle("SmartMeter Workbench");
        setVisible(true);
        setResizable(true);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton newProduct = new JButton("Добавить продукт");
        newProduct.
        getContentPane().add(newProduct);
    }

    public void exit() {
        this.controller.exit();
    }
}
