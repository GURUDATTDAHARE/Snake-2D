package com.gurudattdahare.snake2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class GameView  extends View {
    private Bitmap grass1,grass2,bmSnake,bmApple;
    private  int h=21,w=12;
    public static  int sizeofmap=75*Constrant.SCREEN_WIDTH/1080;
    private ArrayList<Grass> arrayList=new ArrayList<>();
    private Snake snake;
    private boolean move=false;
    private float mx,my;
    private Handler handler;
    private Runnable runnable;
    public GameView(Context context) {
        super(context);
        guru();
    }
   private Apple apple;
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        guru();
    }
    public void guru(){
        grass1= BitmapFactory.decodeResource(this.getResources(),R.drawable.grass);
        grass1=Bitmap.createScaledBitmap(grass1,sizeofmap,sizeofmap,true);
        grass2=BitmapFactory.decodeResource(getResources(),R.drawable.grass1);
        grass2=Bitmap.createScaledBitmap(grass2,sizeofmap,sizeofmap,true);
        bmSnake=BitmapFactory.decodeResource(getResources(),R.drawable.snake);
        bmSnake=Bitmap.createScaledBitmap(bmSnake,14*sizeofmap,sizeofmap,true);
        bmApple =BitmapFactory.decodeResource(getResources(),R.drawable.apple);
        bmApple=Bitmap.createScaledBitmap(bmApple,sizeofmap,sizeofmap,true);

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if((i+j)%2==0){
                 arrayList.add(new Grass(grass1,j*sizeofmap+Constrant.SCREEN_WIDTH/2-(w/2)*sizeofmap,i*sizeofmap+100*Constrant.SCREEN_HIGHT/1920,
                         sizeofmap,sizeofmap)) ;
                }else {
                    arrayList.add(new Grass(grass2,j*sizeofmap+Constrant.SCREEN_WIDTH/2-(w/2)*sizeofmap,i*sizeofmap+100*Constrant.SCREEN_HIGHT/1920,
                            sizeofmap,sizeofmap)) ;
                }
            }
        }
        snake=new Snake(bmSnake,arrayList.get(126).getX(),arrayList.get(126).getY(),4);
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                 invalidate();
            }
        };
        apple=new Apple(bmApple,arrayList.get(randomApple()[0]).getX(),arrayList.get(randomApple()[1]).getY());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int a=event.getActionMasked();
        switch (a){
            case MotionEvent.ACTION_MOVE:
                if (move==false){
                    mx=event.getX();
                    my=event.getY();
                    move=true;
                }else {
                    if (mx-event.getX()>100*Constrant.SCREEN_WIDTH/1080&& !snake.isMove_right()){
                        mx=event.getX();
                        my=event.getY();
                        snake.setMove_left(true);
                    }else  if (event.getX()-mx>100*Constrant.SCREEN_WIDTH/1080&& !snake.isMove_left()){
                        mx=event.getX();
                        my=event.getY();
                        snake.setMove_right(true);
                    }else  if (my-event.getY()>100*Constrant.SCREEN_WIDTH/1080&& !snake.isMove_bottom()){
                        mx=event.getX();
                        my=event.getY();
                        snake.setMove_top(true);
                    }else  if (event.getY()-my>100*Constrant.SCREEN_WIDTH/1080&& !snake.isMove_top()){
                        mx=event.getX();
                        my=event.getY();
                        snake.setMove_bottom(true);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                mx=0;
                my=0;
                move=false;
                break;

        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
       for(int i=0;i<arrayList.size();i++){
           canvas.drawBitmap(arrayList.get(i).getBitmap(),arrayList.get(i).getX(),arrayList.get(i).getY(),null);
       }
        Log.d("guru1","measuredWidth= "+getMeasuredWidth()+" measuredHigth= "+getMeasuredHeight());
       snake.update();
       snake.draw(canvas);
       apple.draw(canvas);
       if(snake.getPartsSnakeArrayList().get(0).getrBody().intersect(apple.getRect())){
           
           apple.reset(arrayList.get(randomApple()[0]).getX(),arrayList.get(randomApple()[1]).getY());
           snake.addPart();
       }
       handler.postDelayed(runnable,100);
    }
    public  int[] randomApple(){
        int []xy =new int[2];
        Random random=new Random();
        xy[0]=random.nextInt(arrayList.size()-1);
        xy[1]=random.nextInt(arrayList.size()-1);
        Rect r=new Rect(arrayList.get(xy[0]).getX(),arrayList.get(xy[1]).getY(),arrayList.get(xy[0]).getX()+GameView.sizeofmap,arrayList.get(xy[1]).getY()+GameView.sizeofmap);
        Boolean check= true;
        while(check){
            check=false;
            for (int i=0;i<snake.getPartsSnakeArrayList().size();i++){
                if(r.intersect(snake.getPartsSnakeArrayList().get(i).getrBody())){
                    check=true;
                    xy[0]=random.nextInt(arrayList.size()-1);
                    xy[1]=random.nextInt(arrayList.size()-1);
                    r=new Rect(arrayList.get(xy[0]).getX(),arrayList.get(xy[1]).getY(),arrayList.get(xy[0]).getX()+GameView.sizeofmap,
                            arrayList.get(xy[1]).getY()+GameView.sizeofmap);
                }
            }
        }
        return xy;
    }

}
