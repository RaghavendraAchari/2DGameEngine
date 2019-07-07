package com.raghav.platformgame;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class PlatformActivity extends Activity {
    private PlatformView mPlatformView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        Point resolution = new Point();
        display.getSize(resolution);

        mPlatformView = new PlatformView(this, resolution.x, resolution.y);
        setContentView(mPlatformView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPlatformView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlatformView.resume();
    }
}
