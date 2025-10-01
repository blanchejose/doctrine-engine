import Doctrine.Canvas;

import java.awt.*;
import java.util.Random;

public class Ball {
    private int raduis =25;
    private  int x ;
    private  int y ;
    private int velocityX ;
    private int velocityY ;

public Ball(int radius) {
    this.raduis = radius;
   initializePosition();
}
    public void update(){
        x += velocityX;
        y += velocityY;
        if(hasTouchedVertically()){
            velocityY *=-1;
        }
        if( hasTouchedhorizontally()){
            velocityX *=-1;
        }
    }
    public void draw(Canvas canvas){
     canvas.drawCircle(x,y,raduis,Color.RED);
    }
    public boolean hasTouchedVertically(){
    return y <=raduis || y>=600 -raduis;
    }
    public boolean hasTouchedhorizontally(){
        return x <=raduis || x>=800 -raduis;
    }
    public boolean hasTouched(){
    return hasTouchedVertically() || hasTouchedhorizontally();
    }
private void initializePosition() {
    x =randomNumber(raduis * 2, 800 - raduis * 2);
    y =randomNumber(raduis * 2, 600 - raduis * 2);
    velocityX = randomNumber(0, 1) == 0 ? 5 : -5;
    velocityY= randomNumber(0, 1) == 0 ? 5 : -5;
}
    private int randomNumber(int min, int max){
        Random rnd =new Random();
        return (new Random()).nextInt((max - min) +1) + min;
    }
}
