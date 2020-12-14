package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.MotionBlur;
import javafx.scene.text.Text;


public class Char{

    int x;
    int y;
    int index;
    int size;
    String text;


    public Char(int x, int y)  {
        this.size = Main.list.size();
        this.index = (int) (Math.random() * size);
        this.text = Main.list.get(index);
        this.x = x;
        this.y = y;
    }

    public void rain(int speed) {
            y = (y > 900) ?  0 : (y += speed);
    }

    public void render(GraphicsContext g2) {
        g2.fillText(text, x, y);
    }


    public void reset() {
        this.index = (int) (Math.random() * size);
        this.text = Main.list.get(index);
    }
}
