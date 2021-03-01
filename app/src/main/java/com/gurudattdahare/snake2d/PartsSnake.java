package com.gurudattdahare.snake2d;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class PartsSnake {
    private Bitmap bm;
    private int x,y;
    private Rect rBody,rTop,rBottom,rLeft,rRigth;

    public PartsSnake(Bitmap bm, int x, int y) {
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

    public Rect getrBody() {
        return new Rect(x,y,x+GameView.sizeofmap,y+GameView.sizeofmap);
    }

    public void setrBody(Rect rBody) {
        this.rBody = rBody;
    }

    public Rect getrTop() {
        return new Rect(x,y-10*Constrant.SCREEN_HIGHT/1920,x+GameView.sizeofmap,y);
    }

    public void setrTop(Rect rTop) {
        this.rTop = rTop;
    }

    public Rect getrBottom() {
        return new Rect(x,y+GameView.sizeofmap,x+GameView.sizeofmap,y+GameView.sizeofmap+10*Constrant.SCREEN_HIGHT/1920);
    }

    public void setrBottom(Rect rBottom) {
        this.rBottom = rBottom;
    }

    public Rect getrLeft() {
        return new Rect(x-10*Constrant.SCREEN_WIDTH/1080,y,x,y+GameView.sizeofmap);
    }

    public void setrLeft(Rect rLeft) {
        this.rLeft = rLeft;
    }

    public Rect getrRigth() {
        return new Rect(x+GameView.sizeofmap,y,x+GameView.sizeofmap+10*Constrant.SCREEN_WIDTH/1080,y+GameView.sizeofmap);
    }

    public void setrRigth(Rect rRigth) {
        this.rRigth = rRigth;
    }
}
