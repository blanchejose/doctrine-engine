package AlphaViking;

import Doctrine.Canvas;
import Doctrine.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tree extends StaticEntity {
    private static final String SPRITE_PATH="images/tree.png";
    private Image image;
    public Tree() {
        load();
    }

    private void load(){
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(SPRITE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void draw(Canvas canvas) {
canvas.drawImage(image,x,y);
    }
}
