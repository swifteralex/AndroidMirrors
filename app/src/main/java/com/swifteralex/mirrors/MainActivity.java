package com.swifteralex.mirrors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(50000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        findViewById(R.id.imageView2).startAnimation(rotateAnimation);
    }

    public void levelSelectClicked(View view) {
        Intent intent = new Intent(this, LevelSelectActivity.class);
        startActivity(intent);
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
