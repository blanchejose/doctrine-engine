import java.awt.*;
//difference entre une interface et une classe abstraite
public final class BouncingBallGame extends Game {
    private int score;
    private Ball ball;

    public BouncingBallGame() {
        ball = new Ball(25);
    }
    @Override
    public void initialize() {
        ball = new Ball(25);
    }
    @Override
    public void update(){
        ball.update();
        if(ball.hasTouched()){
            score +=10;
        }
    }
    @Override
    public void draw( Canvas canvas ) {
        ball.draw(canvas);
        canvas.drawString("Score: "+score,10,20);

    }

}
