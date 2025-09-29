import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game {
    private static final int SLEEP = 25;
    private JFrame frame;
    private JPanel panel;
    private boolean playing = true;
   private Ball ball;
    private BufferedImage bufferedImage;
    private Graphics2D bufferEngine;
    private long before;
    private int score;

    Game() {
        initializeFrame();
        initializePanel();
        ball = new Ball(25);
    }
    public void start(){
        frame.setVisible(true);
        before = System.currentTimeMillis();
        while(playing){
            bufferedImage = new BufferedImage (800, 600, BufferedImage.TYPE_INT_RGB);
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            bufferEngine = bufferedImage.createGraphics(); //qui permet décrire sur l'image
            bufferEngine.setRenderingHints(hints);//definir comment gerer son affichage

            update();
            drawOnBuffer();
            drawOnScreen();
            long sleep = SLEEP -(System.currentTimeMillis() - before);

            if(sleep <4){
                sleep =4;
            }
            try {
                Thread.sleep(sleep);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            before = System.currentTimeMillis();
        }
    }
    public void update(){
        ball.update();
        if(ball.hasTouched()){
            score +=10;
        }
       // score = score+1;
    }
    public void drawOnBuffer(){
       ball.draw(bufferEngine);
        bufferEngine.setPaint(Color.WHITE);

        bufferEngine.drawString("Score: "+score,10,20);
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
    }
    private void initializeFrame(){
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);//centrer frame
        frame.setResizable(false);//
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// tuer le programme
        frame.setState(JFrame.NORMAL);//l'etat normal
    }
}