package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class MyView extends View
{
    Paint paint = null;
    public MyView(Context context)
    {
        super(context);
        paint = new Paint();
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();

        int size = 250;
        int radius;
        radius = 300;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
// Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#CD5C5C"));

        Log.d("AWARE", "onDraw:");
        for (int i = size; i < y; i=i+size*2) {
            Log.d("AWARE", "onDraw:"+i+"");
            for (int j = size; j < x; j=j+size*2) {
                Log.d("AWARE", "onDraw: i="+i+" j="+j);
                canvas.drawCircle(j, i, size, paint);
            }
        }
    }
}