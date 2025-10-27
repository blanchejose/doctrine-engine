package Doctrine;

public abstract class MovableEntity extends StaticEntity {
    private int speed =1;
    private Direction direction = Direction.UP;
    public abstract void update();
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
