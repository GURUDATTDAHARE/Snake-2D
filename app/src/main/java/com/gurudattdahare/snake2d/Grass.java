package com.gurudattdahare.snake2d;

import android.graphics.Bitmap;

public class Grass {
    private Bitmap bitmap;
    private int x,y,width,hight;

    public Grass(Bitmap bitmap, int x, int y, int width, int hight) {
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        this.width = width;
        this.hight = hight;
    }

    public Grass() {
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }
}
