package listeners;

import view.MainWindow;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameListener extends WindowAdapter {
    private MainWindow mainWindow;

    public FrameListener(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }


    @Override
    public void windowClosing(WindowEvent e) {
        this.mainWindow.exit();
    }
}
