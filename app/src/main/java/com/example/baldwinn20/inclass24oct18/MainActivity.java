package com.example.baldwinn20.inclass24oct18;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, GestureDetector.OnGestureListener {

    private CircleView cv;
    private GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv = (CircleView)findViewById(R.id.circleView);
        cv.setOnTouchListener(this);

        detector = new GestureDetector(this, this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {

        cv.setXC( (int)e.getX() );
        cv.setYC((int)e.getY());
        cv.invalidate();

        return detector.onTouchEvent(e);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        //find if touch is on the circle-----add method to circle view to find distance to circle center

        if(!cv.overlapsCircle((int)e2.getX(), (int)e2.getY()))
            return false;

        //move circle to under finger
        cv.setXC((int)e2.getX());
        cv.setYC((int)e2.getY());

        //redraw
        cv.invalidate();

        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

        Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        VibrationEffect effect = VibrationEffect.createOneShot(1000,VibrationEffect.DEFAULT_AMPLITUDE);
        v.vibrate(effect);

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return true;
    }
}
