package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {
    int width = 1440;
    int height = 900;
    Char[] chars;

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Matrix");
        Group root = new Group();
        Canvas canvas = new Canvas(width,height);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        chars = new Char[500];
        CharList.shuffle();
        Arrays.setAll(chars, i -> new Char((int) (Math.random() * width), (int) (Math.random() * -300)));


        new AnimationTimer() {
            public void handle(long now) {

                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, width , height);

                for (Char aChar : chars) {
                    aChar.draw(gc);
                    aChar.rain();
                }
            }

        }.start();

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
