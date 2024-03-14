package com.mirohaap.towerofhanoitutor;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tower {
    static final Color TOWER_COLOR = Color.GREY;
    static final int TOWER_WIDTH = 20;
    static final int TOWER_HEIGHT = 200;
    public Rectangle frontEnd;
    private int x;
    private int y;

    public Tower(int x, int y) {
        this.x = x;
        this.y = y;
        this.frontEnd = new Rectangle();
        this.frontEnd.setX(x);
        this.frontEnd.setY(y);
        this.frontEnd.setHeight(TOWER_HEIGHT);
        this.frontEnd.setWidth(TOWER_WIDTH);
        this.frontEnd.setFill(TOWER_COLOR);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
        this.frontEnd.setX(x);
        this.frontEnd.setY(y);
    }

    public void draw() {}
}
