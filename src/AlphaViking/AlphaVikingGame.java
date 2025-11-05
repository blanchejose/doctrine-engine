package AlphaViking;



import AlphaViking.GamePad;
import AlphaViking.Player;
import Doctrine.Canvas;
import Doctrine.Game;

public class AlphaVikingGame extends Game {

    private AlphaViking.Player player;
    private AlphaViking.GamePad gamePad;
    private  World world;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        player.moveTo(200,200);
        world = new World();
        world.load();

    }

    @Override
    public void update() {
        if(gamePad.isQuitPressed()){
            stop();
        }
      player.update();
    }

    @Override
    public void draw(Canvas canvas) {
        world.draw(canvas);
        player.draw(canvas);

    }
}
