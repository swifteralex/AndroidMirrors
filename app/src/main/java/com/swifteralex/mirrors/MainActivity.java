package com.swifteralex.mirrors;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static float rayAngle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        Timer timer = new Timer();
        final int FPS = 60;
        TimerTask updateFrame = new RotateRays();
        timer.scheduleAtFixedRate(updateFrame, 0, 1000/FPS);
    }

    public class RotateRays extends TimerTask {
        public void run(){
            ImageView rays = findViewById(R.id.imageView2);
            rays.setRotation(rayAngle += 0.06f);
        }
    }
}

/*class DrawView extends View {
    Paint paint = new Paint();

    static float i = 0;

    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10f);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(i, i, 540, 1080, paint);
        i += 100;
    }
}*/
