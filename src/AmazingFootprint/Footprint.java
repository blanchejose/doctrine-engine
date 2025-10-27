package AmazingFootprint;

import Doctrine.Canvas;
import Doctrine.StaticEntity;
import java.awt.*;
import java.util.Random;

public class Footprint extends StaticEntity {

    public Footprint(int x, int y) {
        moveTo(x, y);
        setDimension(5,5);
    }

    private int getRandomValue(){
        return new Random().nextInt(256);
    }

    public void draw(Canvas canvas ){
        Color color = new Color(getRandomValue(),getRandomValue(),getRandomValue());
        canvas.drawRectangle(this,color);
    }
}
