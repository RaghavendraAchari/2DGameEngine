package com.raghav.platformgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PlatformView extends SurfaceView implements Runnable{
    public static final String TAG = "PlatformView";
    private Context context;
    private boolean debugging = true;
    private volatile boolean running;
    private Thread gameThread = null;

    private Paint mPaint;
    private Canvas mCanvas;
    private SurfaceHolder mSurfaceHolder;

    long startFrameTime, timeThisFrame, fps;

    private LevelManager levelManager;
    private ViewPort viewPort;
    InputController inputController;

    public PlatformView(Context context , int x, int y) {
        super(context);
        this.context = context;

        mSurfaceHolder = getHolder();
        mPaint = new Paint();
    }

    public void pause() {
        running = false;
        try{
            gameThread.join();
        }catch (Exception e){
            Log.e(TAG, "Error in pause()");
        }
    }

    public void resume() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (running){
            startFrameTime = System.currentTimeMillis();

            update();
            draw();
            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if(timeThisFrame >= 1){
                fps = 1000 / timeThisFrame;
            }
        }
    }

    private void draw() {
        if(mSurfaceHolder.getSurface().isValid()){
            mCanvas = mSurfaceHolder.lockCanvas();
            //TODO: implement drawing

            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }

    private void update() {

    }
}
