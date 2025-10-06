package MovingRectangle;
import Doctrine.Canvas;
import Doctrine.Controller;

import java.awt.*;

public class Player {
    private Controller controller;
    private int x;
    private int y;
    private int speed;

    public Player(Controller controller) {
        this.controller = controller;
        x=200;
        y =200;
        speed =3;
    }
    public void update() {
        if (controller.isUpPressed()){
            y -= speed;
        }else if (controller.isDownPressed()){
            y += speed;
        }else if (controller.isRightPressed()){
            x += speed;
        }else if (controller.isLeftPressed()){
            x -= speed;
        }
    }
    public void draw(Canvas canvas) {
        canvas.drawRectangle(x,y,20,60,Color.white);
    }
}
