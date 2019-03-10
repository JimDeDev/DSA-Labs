/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BouncingBalls;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author gjr5542
 */
public class Ball implements Runnable {

    private static int worldWidth, worldHeight;
    private static int MAX_SPEED = 30;
    private int size;
    private int dx, dy;
    private int x, y;

    private Color color;


    private boolean ballAlive = true;

    public Ball(int worldWidth, int worldHeight) {
        Random rand = new Random();

        this. worldWidth = worldWidth;
        this.worldHeight = worldHeight;

        this.size = rand.nextInt(50) + 20;
        this.x = rand.nextInt(this.worldWidth - size);
        this.y = rand.nextInt(this.worldHeight - size);
        this.dx = rand.nextInt(MAX_SPEED) + 1;
        this.dy = rand.nextInt(MAX_SPEED) + 1;
        this.color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));

    }

    private void moveBall() {
        if (x >= worldWidth - size || x <= 0) {
            this.dx *= -1;
        }
        if (y > worldHeight - size || y <= 0) {
            this.dy *= -1;
        }

        this.x += dx;
        this.y += dy;
    }

    public void drawBall(Graphics g) {
       g.setColor(color);
       g.fillOval(x, y, size, size);

    }

    @Override
    public void run() {
        while(ballAlive) {
            this.moveBall();
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
        }
    }

    public static void setWorldWidth(int worldWidth) {
        Ball.worldWidth = worldWidth;
    }

    public static void setWorldHeight(int worldHeight) {
        Ball.worldHeight = worldHeight;
    }

    public boolean kill() {
        this.ballAlive = false;
        return true;
    }

    public void centre() {
        this.position(this.worldWidth / 2 - size / 2, this.worldHeight / 2 - size / 2);
    }

    public boolean position(int x, int y) {
        if (locationWithinWorld(x, y)) {
            this.x = x - size / 2;
            this.y = y - size / 2;
            return true;
        }
        return false;
    }

    private boolean locationWithinWorld(int x, int y) {
        if (x > 0 && x < worldWidth - size && y > 0 && y < worldHeight - size) {
            return true;
        } else {
            System.out.println("Not within world");
        return false;
        }
    }
}
