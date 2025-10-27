package AmazingFootprint;

import java.awt.*;
import Doctrine.Canvas;
import Doctrine.MovableEntity;

public class Player extends MovableEntity {
    private GamePad  gamePad;

    public Player(GamePad gamePad) {
    moveTo(200,200);
    setSpeed(3);
    setDimension(20,60);
        this.gamePad = gamePad;
    }
    public void update() {
        if(gamePad.isMoving()) {
            move(gamePad.getDirection());
        }
    }
    public Footprint layFootprint() {
        return new Footprint(x,y);
    }

    public void draw (Canvas canvas){
        canvas.drawRectangle(this,Color.WHITE);
    }

}

