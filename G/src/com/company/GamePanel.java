package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static com.company.Constants.*;

public class GamePanel extends JPanel implements Runnable {


    char direction = 'R';
    int applePosX;
    int applePosY;
    boolean running = false;
    static int body = 4;
    int[] x = new int[FRAME_WIDTH];
    int[] y = new int[FRAME_HEIGHT];


    public GamePanel(){

        this.setPreferredSize(new Dimension(800,600));
        this.setFocusable(true);
        addKeyListener(new PLAY());
        new Thread(this).start();
        gameStart();
    }

    public void gameStart(){
        running = true;
        apple();
        System.out.println(" x : " + x[0] + " : " + x[1]);
        System.out.println(" y : " + y[0] + " : " + y[1]);
    }
    @Override
    public void run() {
        while (running){
            move();
            eatCheck();
            repaint();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
    }

    public void move(){

        for (int i = body; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if(direction == 'R')
            x[0] += _UNIT;
        if(direction == 'L')
            x[0] -= _UNIT;
        if(direction == 'U')
            y[0] -= _UNIT;
        if(direction == 'D')
            y[0] += _UNIT;
    }
    public void eatCheck(){
        if(x[0] == applePosX && y[0] == applePosY){
            grow();
            apple();
        }
    }

    private void grow() {
        body++;
    }

    private void apple() {
        applePosX = (int) (Math.random() * FRAME_WIDTH/_UNIT) * _UNIT;
        applePosY = (int) (Math.random() * FRAME_HEIGHT/_UNIT) * _UNIT;
    }

    public void draw(Graphics g){

        g.setColor(Color.red);
        g.fillOval(applePosX, applePosY, _UNIT, _UNIT);

        g.setColor(Color.CYAN);
        for(int i = 0; i < body; i++)
                g.fillRect(x[i], y[i], _UNIT, _UNIT);

    }


    public class PLAY extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                if(direction != 'R')
                    direction = 'L';
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                if(direction != 'L')
                    direction = 'R';
            }
            if (e.getKeyCode() == KeyEvent.VK_UP){
                if(direction != 'D')
                    direction = 'U';
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN){
                if(direction != 'U')
                    direction = 'D';
            }
        }
    }
}
