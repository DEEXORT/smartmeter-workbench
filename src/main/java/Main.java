import controller.Controller;
import model.Model;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        Model model = new Model();
//        Controller controller = new Controller(model);

        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();
        jPanel.add(new JButton("button"));
        jFrame.add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
