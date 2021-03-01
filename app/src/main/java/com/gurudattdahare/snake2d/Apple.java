package com.gurudattdahare.snake2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Apple {
    private Bitmap bm;
    private int x,y;
    private Rect rect;

    public Apple(Bitmap bm, int x, int y) {
        this.bm = bm;
        this.x = x;
        this.y = y;
    }

    public Bitmap getBm() {
        return bm;
    }

    public void setBm(Bitmap bm) {
        this.bm = bm;
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

    public Rect getRect() {
        return new Rect(x,y,x+GameView.sizeofmap,y+GameView.sizeofmap);
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }
    public void draw(Canvas canvas){
        canvas.drawBitmap(bm,x,y,null);
    }
    public void reset(int mx,int my){
        this.x=mx;
        this.y=my;

    }
}
