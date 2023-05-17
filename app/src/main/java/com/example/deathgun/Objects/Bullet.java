package com.example.deathgun.Objects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.deathgun.R;

public class Bullet {

    private int x=0, y=0;
    private Bitmap bullet;
    private int width, height;

    public Bullet(Resources resources) {
        bullet = BitmapFactory.decodeResource(resources, R.drawable.bullet);
        width = bullet.getWidth() / 21;
        height = bullet.getHeight() / 21;
        bullet = Bitmap.createScaledBitmap(bullet, width, height, false);
    }

    public Rect getCollisionShape() {
        return new Rect(x, y, x + width, y + height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public Bitmap getBullet() {
        return bullet;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
