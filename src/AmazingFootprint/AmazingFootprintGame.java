package AmazingFootprint;

import Doctrine.Canvas;
import Doctrine.Game;

import java.awt.*;
import java.util.ArrayList;

public class AmazingFootprintGame extends Game {
    private Player player;
    private GamePad gamePad;
    private ArrayList<Footprint> footprints;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        footprints = new ArrayList<>();
    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()){
        stop();
        }

        player.update();
        if(gamePad.isMoving()){
          footprints.add(player.layFootprint());

        }
    }


    @Override
    public void draw(Canvas canvas) {
    canvas.drawRectangle(0,0,800,600, Color.BLUE);
    for (Footprint footprint : footprints) {
        footprint.draw(canvas);
    }
    player.draw(canvas);

    }
}
