import java.awt.*;

public abstract class Game {
    private static final int SLEEP = 25;
    private  RenderingEngine renderingEngine;
    private boolean playing = true;
   private long before;
   public abstract void update();
   public abstract void drawOnBuffer(Graphics2D buffer);

    Game() {
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