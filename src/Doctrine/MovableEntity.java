package Doctrine;

import java.awt.*;

// cest lui qui peurt entrer en collision avec les affaires car cest lui qui bouge
public abstract class MovableEntity extends StaticEntity {
    private int speed =1;
    private Direction direction = Direction.UP;
    // hitbox ggere les projections

    public abstract void update();
    public Rectangle getHitBox(){
        switch(direction){
            case UP:return  getUpperHitBox();
            case DOWN:return getLowerHitBox();
            case LEFT:return getLeftHitBox();
            case RIGHT: return getRightHitBox();
        }
        return getBounds();
    }
    public boolean hitBoxIntersectsWith(StaticEntity other){
        if(other == null){
            return false;
        }
        return getHitBox().intersects(other.getBounds());


    }

    public  void drawHitBox(Canvas canvas){
        Rectangle rectangle = getHitBox();
        Color color = new Color(255,0,0,200);
        canvas.drawRectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height, color);

    }
    public Rectangle getUpperHitBox(){
        return new Rectangle(x,y - speed,width,speed);
    }
    public Rectangle getLowerHitBox(){
        return new Rectangle(x,y+height,width,speed);
    }
    public Rectangle getLeftHitBox(){
        return new Rectangle(x-speed,y,speed,height);
    }
    public Rectangle getRightHitBox(){
        return new Rectangle(x+width,y,speed,height);
    }
    public void move(){
        x += direction.calculateVelocityX(speed);
        y += direction.calculateVelocityY(speed);
    }
    public void move(Direction direction){
        if(direction != null){
            this.direction = direction;
            move();
        }

    }
    public void moveUP(){
        move(Direction.UP);
    }
    public void moveDown(){
        move(Direction.DOWN);
    }
    public void moveLEFT(){
        move(Direction.LEFT);
    }
    public void moveRIGHT(){
        move(Direction.RIGHT);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
