package AlphaViking;

import Doctrine.Canvas;
import Doctrine.CollidableRepository;
import Doctrine.StaticEntity;

import java.awt.*;

public class Blockada extends StaticEntity {

    public Blockada() {
        CollidableRepository.getInstance().registerEntity(this);
    }
    @Override
    public void draw(Canvas canvas) {
        if(Config.DEBUG){
            canvas.drawRectangle(this, new Color(255,0,0,100));
        }
    }
}
