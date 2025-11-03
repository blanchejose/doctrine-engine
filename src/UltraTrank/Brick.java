package UltraTrank;

import Doctrine.Canvas;
import Doctrine.CollidableRepository;
import Doctrine.StaticEntity;

import java.awt.*;

public class Brick extends StaticEntity {
    public Brick(int x, int y) {
        setDimension(16,16);
        moveTo(x,y);
        CollidableRepository.getInstance().registerEntity(this);//qunad on creew un brick elle reste dabs le moteur de collision
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRectangle(this, Color.WHITE);
    }
}
