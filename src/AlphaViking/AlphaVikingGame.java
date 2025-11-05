package AlphaViking;



import AlphaViking.GamePad;
import AlphaViking.Player;
import Doctrine.Canvas;
import Doctrine.Game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AlphaVikingGame extends Game {

    private AlphaViking.Player player;
    private AlphaViking.GamePad gamePad;
    private  World world;
    private Tree tree;
    private int soundCooldown;

    @Override
    public void initialize() {
        gamePad = new GamePad();
        player = new Player(gamePad);
        player.moveTo(200,200);
        world = new World();
        world.load();
        tree = new Tree(300,350);
        tree.moveTo(300,350);

        try{
                Clip clip = AudioSystem.getClip();
            AudioInputStream stream = AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResourceAsStream("audios/music.wav"));
            clip.open(stream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }catch (Exception e){
            e.printStackTrace();
        }

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
        soundCooldown--;
        if(soundCooldown < 0){
            soundCooldown = 0;
        }
        if(gamePad.isFirePressed()&& soundCooldown ==0){
        soundCooldown = 100;
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream stream = AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResourceAsStream("audios/fire.wav"));
            clip.open(stream);
            clip.start();
        }catch (Exception e){
            e.printStackTrace();

        }

        }

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
