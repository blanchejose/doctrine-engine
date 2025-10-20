package Doctrine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class RenderingEngine {
    private BufferedImage bufferedImage;
    private Graphics2D bufferEngine;
    private JFrame frame;
    private JPanel panel;
    private  static  RenderingEngine instance;
public static RenderingEngine getInstance() {
    if (instance == null){
        instance = new RenderingEngine();
    }
    return instance;
}

public void addKeyListener(KeyListener listener) {
    panel.addKeyListener(listener);

}
public void start() {
    frame.setVisible(true);
}
public void stop() {
    frame.setVisible(false);
    frame.dispose();
}
public Doctrine.Canvas buildCanvas() {
    bufferedImage = new BufferedImage (800, 600, BufferedImage.TYPE_INT_RGB);
    bufferEngine = bufferedImage.createGraphics();
    bufferEngine.setRenderingHints(buildRenderingHints());
    return new Canvas(bufferEngine);
}



    public void drawOnScreen(){
        Graphics2D graphics =(Graphics2D) panel.getGraphics();
        graphics.drawImage(bufferedImage,0,0,panel);
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();


    }

    private void initializePanel(){
        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        frame.add(panel);
        frame.setUndecorated(true);
    }
    private void initializeFrame(){
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);//centrer frame
        frame.setResizable(false);//
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// tuer le programme
        frame.setState(JFrame.NORMAL);//l'etat normal
    }
    private  RenderingHints buildRenderingHints(){
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        bufferEngine = bufferedImage.createGraphics(); //qui permet décrire sur l'image
        bufferEngine.setRenderingHints(hints);//definir comment gerer son affichage
        return hints;
    }
    private RenderingEngine() {
        initializeFrame();
        initializePanel();
    }
}
