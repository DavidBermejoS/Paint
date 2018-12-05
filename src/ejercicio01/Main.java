package ejercicio01;

import java.awt.*;

/**
 * <h2>Clase principal Main</h2>
 * @author David Bermejo Simon
 **/
public class Main {

    /**
     * Hilo principal "main"
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Window window = new Window();
                window.runWindow();
            }
        });
    }
}
