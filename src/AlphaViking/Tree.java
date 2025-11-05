package AlphaViking;

import Doctrine.Canvas;
import Doctrine.StaticEntity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tree extends StaticEntity {
    private static final String SPRITE_PATH="images/tree.png";
    private Image image;
    private Blockada blockada;

    public Tree(int x, int y) {
        moveTo(x, y);
        blockada = new Blockada();
        blockada.setDimension(30,16);
        blockadaFromTop();
        blockadaToBottom();
        load();
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.drawImage(image,x,y);
        blockada.draw(canvas);
    }
public void blockadaFromTop() {
        blockada.moveTo(x+16,y+64);
}
public void blockadaToBottom() {
        blockada.moveTo(x+16,y+48);
}
    private void load(){
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(SPRITE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
