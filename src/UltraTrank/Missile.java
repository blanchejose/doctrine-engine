package UltraTrank;

import Doctrine.Canvas;
import Doctrine.Direction;
import Doctrine.MovableEntity;

import java.awt.*;

public class Missile extends MovableEntity {

    public Missile(Tank tank) {
        setSpeed(5);
        setDirection(tank.getDirection());
        initialize(tank);
    }
    @Override
    public void update() {
    move();
    if(x >=820){
        x = -20;
    }
    if(y >=620){
        y = -20;
    }

    }

    @Override
    public void draw(Canvas canvas) {
    canvas.drawRectangle(this, Color.YELLOW);
    }

    private void initialize(Tank tank) {
        if (tank.getDirection() == Direction.RIGHT) {
            moveTo(tank.getX()+ tank.getWidth() + 1, tank.getY()+ 15 - 1);
            setDimension(8,4);
        }else if(tank.getDirection() == Direction.LEFT) {
            moveTo(tank.getX() - 9,tank.getY() +  15 - 1);
            setDimension(8,4);

        }else if(tank.getDirection() == Direction.DOWN) {
            moveTo(tank.getX() + 15 - 1, tank.getY()+tank.getHeight()+1 );
            setDimension(4,8);

        }else if(tank.getDirection() == Direction.UP) {
            moveTo(tank.getX()+ 15-1, tank.getY() - 9);
            setDimension(4,8);

        }
    }
}
