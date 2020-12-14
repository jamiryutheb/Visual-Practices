package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Char{

    int x;
    int y;
    int speed;
    int index;
    int distance;
    int thickness;

    public Char(int x, int y)  {
        this.index = (int) (Math.random() * CharList.list.size());
        this.x = x;
        this.y = y;
        this.distance = (int)(Math.random() * 10);
        this.speed = (int)(Math.random() * distance + 2) + 2;
        this.thickness = (int)(Math.random() * (distance + 40));
    }

    public void rain() {
        y = (y > 900) ?  0 : (y +=speed);
    }

    public void draw(GraphicsContext gc) {
        gc.setFont(new Font("", thickness));
        gc.setFill(Color.rgb(0,200,70));
        gc.fillText(CharList.list.get(index) , x, y);
        if(y % 10 == 0)
            index = (int) (Math.random() * CharList.list.size());
    }
}
