package ejercicio01;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <h2>Clase Window</h2>
 * Esta clase sera la encargada de gestionar la interfaz, sus componentes y los listeners
 * de los mismos.
 *
 * @author David Bermejo Simon
 **/
public class Window {

    File rectangleImg;
    File circleImg;


    JFrame frame;

    JPanel panelIzquierda;
    JPanel panelDerecha;
    JLabel labelCuadrado, labelCirculo, labelPosicionX, labelPosicionY;

    JTextField textPosicionX;
    JTextField textPosicionY;

    JLabel lienzo;
    BufferedImage canvas;


    public Window() {

        this.frame = new JFrame("Paint In");
        this.frame.setBounds(400, 300, 800, 600);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //inicialiazamos los file de las imagenes de iconos:
        rectangleImg = new File("rsc/rectangle.png");
        circleImg = new File("rsc/circle.png");

    }

    public void addComponents(){
        this.frame.setLayout(new GridBagLayout());
        GridBagConstraints settings;

        //PANEL IZQUIERDO
        panelIzquierda = new JPanel();
        panelIzquierda.setLayout(new GridBagLayout());
        panelIzquierda.setBackground(Color.blue);
        settings = new GridBagConstraints();
        settings.gridx=0;
        settings.gridy=0;
        settings.fill=GridBagConstraints.BOTH;
        settings.ipadx=20;
        settings.ipady=20;
        frame.add(panelIzquierda,settings);


        //PANEL DERECHO
        panelDerecha = new JPanel();
        panelDerecha.setBackground(Color.cyan);
        settings = new GridBagConstraints();
        settings.gridx=1;
        settings.gridy=0;
        settings.weightx=4;
        settings.weighty=1;
        settings.fill=GridBagConstraints.BOTH;
        frame.add(panelDerecha,settings);

        //label rectangulo.
        labelCuadrado = new JLabel();
        labelCuadrado.setIcon(getImageIcon(rectangleImg,80,50));
        settings = new GridBagConstraints();
        settings.gridx=0;
        settings.gridy = 0;
        settings.ipadx=20;
        settings.ipady=20;
        panelIzquierda.add(labelCuadrado, settings);

        //label circulo.
        labelCirculo = new JLabel();
        labelCirculo.setIcon(getImageIcon(circleImg,80,50));
        settings = new GridBagConstraints();
        settings.gridx=0;
        settings.gridy = 1;
        settings.ipadx=20;
        settings.ipady=20;
        panelIzquierda.add(labelCirculo, settings);




    }

    private ImageIcon getImageIcon(File filePhoto, int width, int height) {
        canvas = null;
        Image image;
        try{
            canvas = ImageIO.read(filePhoto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = canvas.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        return imageIcon;
    }


    public void addListeners(){

    }


    public void runWindow(){
        this.frame.setVisible(true);
        addComponents();
        addListeners();
    }

}
