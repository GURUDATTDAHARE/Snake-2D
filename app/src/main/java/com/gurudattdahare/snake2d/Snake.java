package com.gurudattdahare.snake2d;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

public class Snake {
    private Bitmap bm,bm_head_up,bm_head_down,bm_head_left,bm_head_right,bm_body_vertical,bm_body_horizontal, bm_body_top_to_rigth,
            bm_body_right_to_top, bm_body_bottom_to_right, bm_body_right_to_bottom,bm_tail_right,bm_tail_left,bm_tail_up,bm_tail_down;
     private int x,y,length;
     private ArrayList<PartsSnake> partsSnakeArrayList=new ArrayList<>();

     private boolean move_left,move_right,move_top,move_bottom;

    public Snake(Bitmap bm, int x, int y, int length) {
        this.bm = bm;
        this.x = x;
        this.y = y;
        this.length = length;
        bm_body_right_to_bottom =Bitmap.createBitmap(bm,0,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_body_bottom_to_right =Bitmap.createBitmap(bm,GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_body_horizontal=Bitmap.createBitmap(bm,2*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_body_right_to_top =Bitmap.createBitmap(bm,3*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_body_top_to_rigth =Bitmap.createBitmap(bm,4*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_body_vertical=Bitmap.createBitmap(bm,5*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_head_down=Bitmap.createBitmap(bm,6*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_head_left=Bitmap.createBitmap(bm,7*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_head_right=Bitmap.createBitmap(bm,8*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_head_up=Bitmap.createBitmap(bm,9*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_tail_up=Bitmap.createBitmap(bm,10*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_tail_right=Bitmap.createBitmap(bm,11*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_tail_left=Bitmap.createBitmap(bm,12*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        bm_tail_down=Bitmap.createBitmap(bm,13*GameView.sizeofmap,0,GameView.sizeofmap,GameView.sizeofmap);
        partsSnakeArrayList.add(new PartsSnake(bm_head_right,x,y));
        for(int i=1;i<length-1;i++){
            partsSnakeArrayList.add(new PartsSnake(bm_body_horizontal,partsSnakeArrayList.get(i-1).getX()-GameView.sizeofmap,y));
        }
        partsSnakeArrayList.add(new PartsSnake(bm_tail_right,partsSnakeArrayList.get(length-2).getX()-GameView.sizeofmap,y));

        setMove_right(false);
    }
    public void draw(Canvas canvas){
        for(int i=0;i<length;i++){
            canvas.drawBitmap(partsSnakeArrayList.get(i).getBm(),partsSnakeArrayList.get(i).getX(),partsSnakeArrayList.get(i).getY(),null);
        }
//        canvas.drawBitmap(bm_body_right_to_bottom,x-3*GameView.sizeofmap,y,null);
//        canvas.drawBitmap(bm_body_bottom_to_right,x-2*GameView.sizeofmap,y,null);
//        canvas.drawBitmap(bm_body_horizontal,x-GameView.sizeofmap,y,null);
//        canvas.drawBitmap(bm_body_right_to_top,x,y,null);
//        canvas.drawBitmap(bm_body_top_to_rigth,x+GameView.sizeofmap,y,null);
//        canvas.drawBitmap(bm_body_vertical,x+2*GameView.sizeofmap,y,null);
//        canvas.drawBitmap(bm_head_down,x+3*GameView.sizeofmap,y,null);
//        canvas.drawBitmap(bm_head_left,x+4*GameView.sizeofmap,y,null);
//        canvas.drawBitmap(bm_head_right,x+5*GameView.sizeofmap,y,null);
//        canvas.drawBitmap(bm_head_up,x+5*GameView.sizeofmap,y+GameView.sizeofmap,null);
//        canvas.drawBitmap(bm_tail_up,x+5*GameView.sizeofmap,y+2*GameView.sizeofmap,null);
//        canvas.drawBitmap(bm_tail_right,x+5*GameView.sizeofmap,y+3*GameView.sizeofmap,null);
//        canvas.drawBitmap(bm_tail_left,x+5*GameView.sizeofmap,y+4*GameView.sizeofmap,null);
//        canvas.drawBitmap(bm_tail_down,x+5*GameView.sizeofmap,y+5*GameView.sizeofmap,null);


    }

    public Bitmap getBm() {
        return bm;
    }

    public void setBm(Bitmap bm) {
        this.bm = bm;
    }

    public Bitmap getBm_head_up() {
        return bm_head_up;
    }

    public void setBm_head_up(Bitmap bm_head_up) {
        this.bm_head_up = bm_head_up;
    }

    public Bitmap getBm_head_down() {
        return bm_head_down;
    }

    public void setBm_head_down(Bitmap bm_head_down) {
        this.bm_head_down = bm_head_down;
    }

    public Bitmap getBm_head_left() {
        return bm_head_left;
    }

    public void setBm_head_left(Bitmap bm_head_left) {
        this.bm_head_left = bm_head_left;
    }

    public Bitmap getBm_head_right() {
        return bm_head_right;
    }

    public void setBm_head_right(Bitmap bm_head_right) {
        this.bm_head_right = bm_head_right;
    }

    public Bitmap getBm_body_vertical() {
        return bm_body_vertical;
    }

    public void setBm_body_vertical(Bitmap bm_body_vertical) {
        this.bm_body_vertical = bm_body_vertical;
    }

    public Bitmap getBm_body_horizontal() {
        return bm_body_horizontal;
    }

    public void setBm_body_horizontal(Bitmap bm_body_horizontal) {
        this.bm_body_horizontal = bm_body_horizontal;
    }

    public Bitmap getBm_body_top_to_rigth() {
        return bm_body_top_to_rigth;
    }

    public void setBm_body_top_to_rigth(Bitmap bm_body_top_to_rigth) {
        this.bm_body_top_to_rigth = bm_body_top_to_rigth;
    }

    public Bitmap getBm_body_right_to_top() {
        return bm_body_right_to_top;
    }

    public void setBm_body_right_to_top(Bitmap bm_body_right_to_top) {
        this.bm_body_right_to_top = bm_body_right_to_top;
    }

    public Bitmap getBm_body_bottom_to_right() {
        return bm_body_bottom_to_right;
    }

    public void setBm_body_bottom_to_right(Bitmap bm_body_bottom_to_right) {
        this.bm_body_bottom_to_right = bm_body_bottom_to_right;
    }

    public Bitmap getBm_body_right_to_bottom() {
        return bm_body_right_to_bottom;
    }

    public void setBm_body_right_to_bottom(Bitmap bm_body_right_to_bottom) {
        this.bm_body_right_to_bottom = bm_body_right_to_bottom;
    }

    public Bitmap getBm_tail_right() {
        return bm_tail_right;
    }

    public void setBm_tail_right(Bitmap bm_tail_right) {
        this.bm_tail_right = bm_tail_right;
    }

    public Bitmap getBm_tail_left() {
        return bm_tail_left;
    }

    public void setBm_tail_left(Bitmap bm_tail_left) {
        this.bm_tail_left = bm_tail_left;
    }

    public Bitmap getBm_tail_up() {
        return bm_tail_up;
    }

    public void setBm_tail_up(Bitmap bm_tail_up) {
        this.bm_tail_up = bm_tail_up;
    }

    public Bitmap getBm_tail_down() {
        return bm_tail_down;
    }

    public void setBm_tail_down(Bitmap bm_tail_down) {
        this.bm_tail_down = bm_tail_down;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<PartsSnake> getPartsSnakeArrayList() {
        return partsSnakeArrayList;
    }

    public void setPartsSnakeArrayList(ArrayList<PartsSnake> partsSnakeArrayList) {
        this.partsSnakeArrayList = partsSnakeArrayList;
    }

    public boolean isMove_left() {
        return move_left;
    }

    public void setMove_left(boolean move_left) {
        s();
        this.move_left = move_left;
    }

    public boolean isMove_right() {
        return move_right;
    }

    public void setMove_right(boolean move_right) {
        s();
        this.move_right = move_right;
    }

    public boolean isMove_top() {
        return move_top;
    }

    public void setMove_top(boolean move_top) {
        s();
        this.move_top = move_top;
    }

    public boolean isMove_bottom() {
        return move_bottom;
    }

    public void setMove_bottom(boolean move_bottom) {
        s();
        this.move_bottom = move_bottom;
    }
    public void s(){
        move_bottom=false;
        move_left=false;
        move_right=false;
        move_top=false;
    }
    public void update(){
        for(int i=length-1;i>0;i--){
            partsSnakeArrayList.get(i).setX(partsSnakeArrayList.get(i-1).getX());
            partsSnakeArrayList.get(i).setY(partsSnakeArrayList.get(i-1).getY());
        }
        if(move_right){
            partsSnakeArrayList.get(0).setX(partsSnakeArrayList.get(0).getX()+GameView.sizeofmap);
            partsSnakeArrayList.get(0).setBm(bm_head_right);
        }else if(move_left){
            partsSnakeArrayList.get(0).setX(partsSnakeArrayList.get(0).getX()-GameView.sizeofmap);
            partsSnakeArrayList.get(0).setBm(bm_head_left);
        }else if(move_top){
            partsSnakeArrayList.get(0).setY(partsSnakeArrayList.get(0).getY()-GameView.sizeofmap);
            partsSnakeArrayList.get(0).setBm(bm_head_up);
        }else if(move_bottom){
            partsSnakeArrayList.get(0).setY(partsSnakeArrayList.get(0).getY()+GameView.sizeofmap);
            partsSnakeArrayList.get(0).setBm(bm_head_down);
        }
        for(int i=1;i<length-1;i++){
            if((partsSnakeArrayList.get(i).getrLeft().intersect(partsSnakeArrayList.get(i+1).getrBody())
            &&partsSnakeArrayList.get(i).getrBottom().intersect(partsSnakeArrayList.get(i-1).getrBody())
            )||(partsSnakeArrayList.get(i).getrLeft().intersect(partsSnakeArrayList.get(i-1).getrBody())
                    &&partsSnakeArrayList.get(i).getrBottom().intersect(partsSnakeArrayList.get(i+1).getrBody()))){
                                  partsSnakeArrayList.get(i).setBm(bm_body_right_to_bottom);

            }else if((partsSnakeArrayList.get(i).getrRigth().intersect(partsSnakeArrayList.get(i+1).getrBody())
                    &&partsSnakeArrayList.get(i).getrBottom().intersect(partsSnakeArrayList.get(i-1).getrBody())
            )||(partsSnakeArrayList.get(i).getrRigth().intersect(partsSnakeArrayList.get(i-1).getrBody())
                    &&partsSnakeArrayList.get(i).getrBottom().intersect(partsSnakeArrayList.get(i+1).getrBody()))){
                partsSnakeArrayList.get(i).setBm(bm_body_bottom_to_right);
            }else if((partsSnakeArrayList.get(i).getrLeft().intersect(partsSnakeArrayList.get(i+1).getrBody())
                    &&partsSnakeArrayList.get(i).getrTop().intersect(partsSnakeArrayList.get(i-1).getrBody())
            )||(partsSnakeArrayList.get(i).getrLeft().intersect(partsSnakeArrayList.get(i-1).getrBody())
                    &&partsSnakeArrayList.get(i).getrTop().intersect(partsSnakeArrayList.get(i+1).getrBody()))){
                partsSnakeArrayList.get(i).setBm(bm_body_right_to_top);
            }else if((partsSnakeArrayList.get(i).getrRigth().intersect(partsSnakeArrayList.get(i+1).getrBody())
                    &&partsSnakeArrayList.get(i).getrTop().intersect(partsSnakeArrayList.get(i-1).getrBody())
            )||(partsSnakeArrayList.get(i).getrRigth().intersect(partsSnakeArrayList.get(i-1).getrBody())
                    &&partsSnakeArrayList.get(i).getrTop().intersect(partsSnakeArrayList.get(i+1).getrBody()))){
                partsSnakeArrayList.get(i).setBm(bm_body_top_to_rigth);
            }else if((partsSnakeArrayList.get(i).getrTop().intersect(partsSnakeArrayList.get(i+1).getrBody())
                    &&partsSnakeArrayList.get(i).getrBottom().intersect(partsSnakeArrayList.get(i-1).getrBody())
            )||(partsSnakeArrayList.get(i).getrTop().intersect(partsSnakeArrayList.get(i-1).getrBody())
                    &&partsSnakeArrayList.get(i).getrBottom().intersect(partsSnakeArrayList.get(i+1).getrBody()))){
                partsSnakeArrayList.get(i).setBm(bm_body_vertical);
            }else if((partsSnakeArrayList.get(i).getrLeft().intersect(partsSnakeArrayList.get(i+1).getrBody())
                    &&partsSnakeArrayList.get(i).getrRigth().intersect(partsSnakeArrayList.get(i-1).getrBody())
            )||(partsSnakeArrayList.get(i).getrLeft().intersect(partsSnakeArrayList.get(i-1).getrBody())
                    &&partsSnakeArrayList.get(i).getrRigth().intersect(partsSnakeArrayList.get(i+1).getrBody()))){
                partsSnakeArrayList.get(i).setBm(bm_body_horizontal);
            }else{
                if(move_right){
                    partsSnakeArrayList.get(i).setBm(bm_body_horizontal);
                }else if(move_bottom){
                    partsSnakeArrayList.get(i).setBm(bm_body_vertical);
                }else if(move_top){
                    partsSnakeArrayList.get(i).setBm(bm_body_vertical);
                }else{
                    partsSnakeArrayList.get(i).setBm(bm_body_horizontal);
                }
            }
        }
        if(partsSnakeArrayList.get(length-1).getrRigth().intersect(partsSnakeArrayList.get(length-2).getrBody())){
            partsSnakeArrayList.get(length-1).setBm(bm_tail_right);
        }else if(partsSnakeArrayList.get(length-1).getrLeft().intersect(partsSnakeArrayList.get(length-2).getrBody())){
            partsSnakeArrayList.get(length-1).setBm(bm_tail_left);
        }else if(partsSnakeArrayList.get(length-1).getrTop().intersect(partsSnakeArrayList.get(length-2).getrBody())){
            partsSnakeArrayList.get(length-1).setBm(bm_tail_up);
        }else {
            partsSnakeArrayList.get(length-1).setBm(bm_tail_down);
        }
    }
    public void addPart(){
        PartsSnake p=partsSnakeArrayList.get(length-1);
        length++;
        if(p.getBm()==bm_tail_right){
          partsSnakeArrayList.add(new PartsSnake(bm_tail_right,p.getX()-GameView.sizeofmap,p.getY()));
        }else if(p.getBm()==bm_tail_left){
            partsSnakeArrayList.add(new PartsSnake(bm_tail_left,p.getX()+GameView.sizeofmap,p.getY()));
        }else if(p.getBm()==bm_tail_up){
            partsSnakeArrayList.add(new PartsSnake(bm_tail_up,p.getX(),p.getY()+GameView.sizeofmap));
        }else if(p.getBm()==bm_tail_down){
            partsSnakeArrayList.add(new PartsSnake(bm_tail_down,p.getX(),p.getY()-GameView.sizeofmap));
        }

    }

}
