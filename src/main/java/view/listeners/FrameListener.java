package view.listeners;

import view.MainWindowOld;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameListener extends WindowAdapter {
    private MainWindowOld mainWindowOld;

    public FrameListener(MainWindowOld mainWindowOld) {
        this.mainWindowOld = mainWindowOld;
    }


    @Override
    public void windowClosing(WindowEvent e) {
        this.mainWindowOld.exit();
    }
}
