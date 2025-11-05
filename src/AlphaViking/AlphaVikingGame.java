package AlphaViking;



import AlphaViking.GamePad;
import AlphaViking.Player;
import Doctrine.Canvas;
import Doctrine.Game;

public class AlphaVikingGame extends Game {

    private AlphaViking.Player player;
    private AlphaViking.GamePad gamePad;
    private  World world;
    private Tree tree;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        player.moveTo(200,200);
        world = new World();
        world.load();
        tree = new Tree(300,350);
        tree.moveTo(300,350);

    }

    @Override
    public void update() {
        if(gamePad.isQuitPressed()){
            stop();
        }

      player.update();
        if(player.getY() < tree.getY() +52){
            tree.blockadaFromTop();
        }else {
            tree.blockadaToBottom();        }

    }

    @Override
    public void draw(Canvas canvas) {
        world.draw(canvas);
        if(player.getY() < tree.getY() +52){
            player.draw(canvas);
            tree.draw(canvas);

        } else  {
            tree.draw(canvas);

            player.draw(canvas);
        }


    }
}
