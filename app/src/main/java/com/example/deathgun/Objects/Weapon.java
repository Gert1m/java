package com.example.deathgun.Objects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.deathgun.GameView;
import com.example.deathgun.R;

public class Weapon {

    private int x, y = 0;
    private int width, height;
    private int weaponSet = 0, shot = 0;
    public boolean isMove = false;
    private Bitmap weapon, shoot;
    private GameView gameView;

    public Weapon(GameView gameView, int screenX, int screenY, Resources resources) {
        this.gameView = gameView;
        weapon = BitmapFactory.decodeResource(resources, R.drawable.weapon);
        shoot = BitmapFactory.decodeResource(resources, R.drawable.shoot);
        width = weapon.getWidth() / 2;
        height = weapon.getHeight() / 2;
        weapon = Bitmap.createScaledBitmap(weapon, width, height, false);
        shoot = Bitmap.createScaledBitmap(shoot, width, height, false);
        x = screenX/2 - weapon.getWidth()/2;
        y = screenY-weapon.getHeight();
    }

    public Rect getCollisionShape() {
        return new Rect(x, y, x + width, y + height);
    }

    public Bitmap getWeapon() {

        if (isMove) {
            if (weaponSet == 0) {
                weaponSet++;
                return weapon;
            } else if (weaponSet > 0) {
                weaponSet--;
                gameView.newBullet();
                return shoot;
            }
        } else return weapon;

        return null;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isMove(Boolean isMove) {
        return isMove;
    }

    public void setMove(boolean move) {
        isMove = move;
    }

    public void setShot(int shot) {
        this.shot = shot;
    }

    public int getShot() {
        return shot;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
