package com.example.deathgun.Objects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.deathgun.R;

public class Mob {

    private int x=0, y=0, speed=20, health = 5;
    private Bitmap mob;
    private int width, height;

    public Mob (int screenX, int screenY, Resources resources) {
        mob = BitmapFactory.decodeResource(resources, R.drawable.mob);
        width = mob.getWidth() / 3;
        height = mob.getHeight() / 3;
        mob = Bitmap.createScaledBitmap(mob, width, height, false);
        x = screenX / 2;
        y = 0;
    }

    public Rect getCollisionShape() {
        return new Rect(x, y, x + width, y + height);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Bitmap getMob() {
        return mob;
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
