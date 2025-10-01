package Doctrine;

import java.awt.*;

public class Canvas {
    private Graphics graphics;
    public Canvas(Graphics graphics) {
        this.graphics = graphics;

    }
    public void drawRectangle(int x, int y, int width, int height, Paint paint) {
        graphics.setPaintMode();
        graphics.fillRect(x, y, width, height);

    }
    public void drawCircle(int x, int y, int radius, Paint paint) {
        graphics.setPaintMode();
        graphics.fillOval(x, y, radius*2, radius*2);
    }
    public void drawString(String text, int x, int y, int i, Color white) {
        graphics.setPaintMode();
        graphics.drawString(text, x, y);
    }


}