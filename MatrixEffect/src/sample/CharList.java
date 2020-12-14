package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.stream.IntStream;

public class CharList {


    Char[] chars;
    int y;
    int x;
    int speed;
    int distance;
    int fontSize;
    int width = Main.width;
    int height = Main.height;
    int positioner;

    public CharList(){

        distance = (int) (Math.random() * 6);
        fontSize = distance * 10;
        positioner = fontSize;
        y = (int) (Math.random() * -200);
        x = (int) (Math.random() * width);
        speed = (int) ((Math.random() * 5) + distance/2);
        chars = new Char[(int) (Math.random() * 20) + 5] ;

        IntStream.range(0, chars.length).forEach(i -> {
            chars[i] = new Char(x, y);
            y -= positioner;
        });

    }


    public void render(GraphicsContext g2) {


        g2.setFont(new Font("", fontSize));

       for (int i = 0; i < chars.length; i++) {
            if(i == 0)
                g2.setFill(Color.rgb(0,255,0));
            else
                g2.setFill(Color.rgb(0,141,63));
            chars[i].render(g2);
            chars[i].rain(speed);
            if (Math.random() < 0.007)
                chars[i].reset();
        }

    }


}
