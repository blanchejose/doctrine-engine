package AmazingFootprint;

import Doctrine.Canvas;
import Doctrine.StaticEntity;

import java.awt.*;
import java.util.Random;
import Doctrine.StaticEntity;
import Doctrine.Canvas;
public class Footprint extends StaticEntity {
    private int x;
    private int y;
    private int width;
    private int height;

    public Footprint(int x, int y) {
        moveTo(x, y);
        setDimension(5,5);


    }

    private int getRandomValue(){
        return new Random().nextInt(256);
    }

    public void draw(Canvas canvas ){
        Color color = new Color(getRandomValue(),getRandomValue(),getRandomValue());
        canvas.drawRectangle(x,y,width,height,color);
    }
}
