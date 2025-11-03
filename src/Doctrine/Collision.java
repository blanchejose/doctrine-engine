package Doctrine;

import java.awt.*;

public class Collision {
    private final MovableEntity entity;

    public Collision(MovableEntity entity) {
        this.entity = entity;
    }
// getAllowedSpeed permet de reduire la distance permise
    public int getAllowedSpeed(Direction direction) {
        switch (direction) {
            case UP: return getAllowedUpSpeed();
            case DOWN: return getAllowedDownSpeed();
            case LEFT: return getAllowedLeftSpeed();
            case RIGHT: return getAllowedRightSpeed();
        }
        return 0;
    }
    private int getAllowedUpSpeed() {
        return distance(other -> entity.y -(other.y +other.height));
    }
    private int getAllowedDownSpeed() {
        return distance(other -> other.y - (entity.y +entity.height));
    }
    private int getAllowedLeftSpeed() {
        return distance(other -> entity.x - (other.x +other.width));
    }
    private int getAllowedRightSpeed() {
        return distance(other -> other.x - (entity.x +entity.width));
    }

    private int distance(DistanceCalculator calculator){
        Rectangle collisionBound = entity.getHitBox();
        int allowedDistance = entity.getSpeed();
        for(StaticEntity other : CollidableRepository.getInstance()){
            if(collisionBound.intersects(other.getBounds())){
                allowedDistance = Math.min(allowedDistance,calculator.calculateWith(other));// la fleche fonctionne comme largument puis le return
            }
        }// pourquoi math.min pour toujours prendre la distance la plus minimale possible
        return allowedDistance;
    }
    // private parceque elle ne vivra jamais en dehors de cette classe
    private interface DistanceCalculator{
        int calculateWith(StaticEntity other); //fonction calculateWith
    }
}
