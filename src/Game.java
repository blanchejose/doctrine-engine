import java.awt.*;

public class Game {
    private static final int SLEEP = 25;
    private  RenderingEngine renderingEngine;

    private boolean playing = true;
   private Ball ball;
   private long before;
    private int score;

    Game() {
        ball = new Ball(25);
        renderingEngine = new RenderingEngine();
    }
    public void start(){
        renderingEngine.start();
        before = System.currentTimeMillis();
        while(playing){


            update();
            drawOnBuffer(renderingEngine.buildBuffer());
            renderingEngine.drawOnScreen();
            sleep();

        }
    }
    public void update(){
        ball.update();
        if(ball.hasTouched()){
            score +=10;
        }
       // score = score+1;
    }
    public void drawOnBuffer( Graphics2D bufferEngine){
       ball.draw(bufferEngine);
        bufferEngine.setPaint(Color.WHITE);
        bufferEngine.drawString("Score: "+score,10,20);
    }

    private void sleep(){
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