package com.raghav.platformgame;

import android.content.Context;
import android.graphics.Bitmap;

public abstract class GameObject {
    private Vector2Piont5D worldLocation;
    private float width, height;

    private boolean active = true;
    private boolean visible = true;
    private int animFrameCount = 1;
    private char type;

    private String bitmapName;

    public abstract void update(long fps, float gravity);

    public String getBitmapName(){
        return bitmapName;
    }

    public Bitmap prepareBitmap(Context context, String bitmapName, int pixelPerMeter){

    }
}
