package MovingRectangle;
import AmazingFootprint.GamePad;
import Doctrine.Canvas;
import Doctrine.Controller;

import java.awt.*;

public class Player {
    private final GamePad gamePad;
    private Controller controller;
    private int x;
    private int y;
    private int speed;

    public Player(GamePad gamePad) {
        this.gamePad = gamePad;
        x=200;
        y =200;
        speed =3;
    }
    public void update() {
        if (gamePad.isUpPressed()){
            y -= speed;
        }else if (gamePad.isDownPressed()){
            y += speed;
        }else if (gamePad.isRightPressed()){

            x += speed;
        }else if (gamePad.isLeftPressed()){
            x -= speed;
        }
    }
    public void draw(Canvas canvas) {
        canvas.drawRectangle(x,y,20,60,Color.white);
    }
}
