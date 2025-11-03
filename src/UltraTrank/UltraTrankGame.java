package UltraTrank;

import Doctrine.Canvas;
import Doctrine.CollidableRepository;
import Doctrine.Game;
import Doctrine.StaticEntity;

import java.util.ArrayList;
import java.util.Collections;

public class UltraTrankGame extends Game {
private GamePad gamePad;
private Tank tank;
private ArrayList<Missile> missiles;
private ArrayList<Brick> bricks;


    @Override
    public void initialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        missiles = new ArrayList<>();
        bricks = new ArrayList<>();
        bricks.add(new Brick(500,100));
        bricks.add(new Brick(500,116));
        bricks.add(new Brick(500,132));
        bricks.add(new Brick(484,148));
        bricks.add(new Brick(500,164));

    }

    @Override
    public void update() {
        if(gamePad.isQuitPressed()){
            stop();
        }
        if (gamePad.isFirePressed()) {
            Missile missile = tank.fire();
            if (missile != null) {
                missiles.add(missile);
            }
        }
        tank.update();
        ArrayList<StaticEntity> KilledElements = new ArrayList<>();

        for (Missile missile : missiles) {
            missile.update();
            for (Brick brick : bricks) {
                if (missile.hitBoxIntersectsWith(brick)) {
                    KilledElements.add(brick);
                    KilledElements.add(missile);
                }
            }
        }
        for(StaticEntity entity : KilledElements){
           if(entity instanceof Brick){
               bricks.remove(entity);
           }
           if(entity instanceof Missile){
               missiles.remove(entity);
           }
        }
        CollidableRepository.getInstance().unregisterEntities(KilledElements);

    }

    @Override
    public void draw(Canvas canvas) {
    tank.draw(canvas);
    for (Missile missile : missiles) {
        missile.draw(canvas);
    }
    for (Brick brick : bricks) {
        brick.draw(canvas);
    }
    }
}
