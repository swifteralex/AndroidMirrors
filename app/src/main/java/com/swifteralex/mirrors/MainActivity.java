package com.swifteralex.mirrors;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout myLayout = new LinearLayout(this);

        DrawView drawnLasers = new DrawView(this);
        drawnLasers.setBackgroundColor(Color.WHITE);
        drawnLasers.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        myLayout.addView(drawnLasers);

        setContentView(myLayout);

        drawnLasers.draw(new Canvas());
    }
}

class DrawView extends View {
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
}
