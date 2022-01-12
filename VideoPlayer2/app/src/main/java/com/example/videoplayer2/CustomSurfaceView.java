package com.example.videoplayer2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float circleX = 0;
    private float circleY = 0;
    public CustomSurfaceView(Context context) {
        super(context);
        setFocusable(true);
        if(surfaceHolder == null) {
           // Get surfaceHolder object.
            surfaceHolder = getHolder();
            // Add this as surfaceHolder callback object.
            surfaceHolder.addCallback(this);
        }
        if(paint == null)
        {
            paint = new Paint();
            paint.setColor(Color.RED);
        }
        // Set the parent view background color. This can not set surfaceview background color.
        this.setBackgroundColor(Color.BLUE);
        // Set current surfaceview at top of the view tree.
        this.setZOrderOnTop(true);
        this.getHolder().setFormat(PixelFormat.TRANSLUCENT);
    }
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawBall();
    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
    /* This method will be invoked to draw a circle in canvas. */
    public void drawBall()
    {
        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.CYAN);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);
        // Draw the circle.
        canvas.drawCircle(circleX, circleY, 100, paint);
        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
    /* This method will be invoked to draw a circle in canvas. */
    public void drawRect()
    {
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.BLUE);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);
        // Draw the rectangle.
        canvas.drawRect(circleX, circleY, circleX + 200, circleY + 200, paint);
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
    public float getCircleX() {
        return circleX;
    }
    public void setCircleX(float circleX) {
        this.circleX = circleX;
    }
    public float getCircleY() {
        return circleY;
    }
    public void setCircleY(float circleY) {
        this.circleY = circleY;
    }
    public Paint getPaint() {
        return paint;
    }
    public void setPaint(Paint paint) {
        this.paint = paint;
    }
}