package com.example.deathgun;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;

import com.example.deathgun.Objects.Background;
import com.example.deathgun.Objects.Bullet;
import com.example.deathgun.Objects.Mob;
import com.example.deathgun.Objects.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class GameView extends SurfaceView implements Runnable {

    private Thread thread;
    private boolean isPlaying, gameOver = false;
    private int screenX, screenY, score, damage, kill;
    private int countDamageUp, countWeaponUp;
    private SharedPreferences load;
    private Paint paint;
    private Random random;
    private Canvas canvas;
    private Weapon weapon;
    private Background background;
    private List<Bullet> bulletList, trash;
    private GameActivity activity;
    private Mob[] mob;
    private Upgrade upgrade;

    public GameView(GameActivity activity, int screenX, int screenY) {
        super(activity);
        this.activity = activity;
        this.screenX = screenX;
        this.screenY = screenY;

        paint = new Paint();
        random = new Random();
        upgrade = new Upgrade();
        background = new Background(screenX, screenY, getResources());
        weapon = new Weapon(this, screenX, screenY, getResources());
        bulletList = new ArrayList<>();
        trash = new ArrayList<>();
        mob = new Mob[4];
        load = activity.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        countDamageUp = load.getInt("countDamageUp", 0);
        countWeaponUp = load.getInt("countWeaponUp", 0);

        for (int i = 0; i < 4; i++) {
            Mob mobs = new Mob(screenX, screenY, getResources());
            mobs.setSpeed(random.nextInt(10) + 15);
            mobs.setX(random.nextInt(screenX - mobs.getWidth()));
            mobs.setY(-screenY);
            mob[i] = mobs;
        }

        paint.setTextSize(64);
        paint.setColor(Color.WHITE);
    }

    @Override
    public void run() {

        while (isPlaying) {
            update();
            draw();
            sleep();
        }
    }

    private void update() {

        for (Bullet bullet : bulletList) {
            if (bullet.getY() < 0) {
                trash.add(bullet);
                break;
            }
            bullet.setY(bullet.getY() - 130);
            for (Mob mobs : mob) {
                if (Rect.intersects(mobs.getCollisionShape(), bullet.getCollisionShape())) {
                    damage = damage + 1 + countDamageUp + countWeaponUp;
                    bullet.setY(-bullet.getHeight());
                    if (kill > 3) {
                        mobs.setHealth((int) (mobs.getHealth()*1.3)); //изначально 5
                        kill = 0;
                    }
                    if (damage > mobs.getHealth()) {
                        score++;
                        kill++;
                        mobs.setY(-screenY/2);
                        mobs.setX(random.nextInt(screenX - mobs.getWidth()));
                        bullet.setY(-bullet.getHeight());
                        mobs.setSpeed(random.nextInt(10) + 10);
                        damage = damage - mobs.getHealth();
                    }
                }
            }
        }
        for (Bullet bullet : trash) {
            bulletList.remove(bullet);
        }

        for (Mob mobs : mob) {
            mobs.setY(mobs.getY() + mobs.getSpeed());
            if (mobs.getY() > screenY - mobs.getHeight())
                gameOver = true;
            if (Rect.intersects(mobs.getCollisionShape(), weapon.getCollisionShape()))
                gameOver = true;
        }
    }

    private void draw() {

        if (getHolder().getSurface().isValid()) {

            canvas = getHolder().lockCanvas();

            canvas.drawBitmap(background.getBackground(), background.getX(), background.getY(), paint);
            canvas.drawBitmap(weapon.getWeapon(), weapon.getX(), weapon.getY(), paint);
            for (Bullet bullet : bulletList) {
                canvas.drawBitmap(bullet.getBullet(), bullet.getX(), bullet.getY(), paint);
            }
            for (Mob mobs : mob) {
                canvas.drawBitmap(mobs.getMob(), mobs.getX(), mobs.getY(), paint);
            }
            if (gameOver) {
                canvas.drawText("You Died", screenX / 3, screenY / 2, paint);
                getHolder().unlockCanvasAndPost(canvas);
                score();
                waitBeforeExiting();
                return;
            }
            canvas.drawText(score + "", screenX / 2f, screenY / 8f, paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void sleep() {
        try {
            thread.sleep(17); //17 это 60fps
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getY() >= (screenY*0.66))
                    weapon.setMove(true);
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getY() >= (screenY*0.66)) {
                    weapon.setX((int) event.getX() - weapon.getWidth()/2);
                    //границы
                    if (weapon.getX()<0)
                        weapon.setX(0);
                    if (weapon.getX()+weapon.getWidth() > screenX)
                        weapon.setX(screenX-weapon.getWidth());
                }
                break;
            case MotionEvent.ACTION_UP:
                weapon.setMove(false);
                break;
        }
        return true;
    }

    public void resumeThread() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pauseThread() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void newBullet() {
        Bullet bullet = new Bullet(getResources());
        bullet.setX(weapon.getX() + (weapon.getWidth() / 2) - (bullet.getWidth() / 2));
        bullet.setY(weapon.getY() - bullet.getHeight());
        bulletList.add(bullet);
    }
    public void score() {
        SharedPreferences.Editor save = load.edit();
        save.putInt("score", score);
        save.apply();
    }
    private void waitBeforeExiting() {
        try {
            Thread.sleep(1500);
            activity.startActivity(new Intent(activity, MainActivity.class));
            activity.finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}