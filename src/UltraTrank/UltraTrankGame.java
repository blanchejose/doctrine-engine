package UltraTrank;

import Doctrine.Canvas;
import Doctrine.Game;

import java.util.ArrayList;

public class UltraTrankGame extends Game {
private GamePad gamePad;
private Tank tank;
private ArrayList<Missile> missiles;
    @Override
    public void initialize() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        missiles = new ArrayList<>();
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
        for (Missile missile : missiles) {
            missile.update();
        }

    }

    @Override
    public void draw(Canvas canvas) {
    tank.draw(canvas);
    for (Missile missile : missiles) {
        missile.draw(canvas);
    }
    }
}
