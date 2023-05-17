package com.example.deathgun.Objects;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.deathgun.GameView;
import com.example.deathgun.R;

public class Background {
    private GameView gameView;
    private Bitmap background;
    private int x = 0, y = 0;

    public Background(int screenX, int screenY, Resources resources) {
        background = BitmapFactory.decodeResource(resources, R.drawable.background);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Bitmap getBackground() {
        return background;
    }
}
