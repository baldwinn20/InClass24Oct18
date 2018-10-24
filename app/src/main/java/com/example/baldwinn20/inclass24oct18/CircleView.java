package com.example.baldwinn20.inclass24oct18;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class CircleView extends SurfaceView {

    private int x,y;
    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        x=500;
        y=500;
    }

   @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint(Color.GREEN);

        canvas.drawCircle(x,y,200,p);
   }

   public void setXC(int x){
        this.x = x;

   }

   public void setYC(int y){
        this.y = y;
   }

   public int getXC() {
       return x;
   }

    public int getYC() {
        return y;
    }
}
