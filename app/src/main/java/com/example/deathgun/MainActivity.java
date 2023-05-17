package com.example.deathgun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    ImageView upgrade, play;
    private int coins, gems, score;
    TextView coinMain, gemMain;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        upgrade = findViewById(R.id.upgrade);
        play = findViewById(R.id.play_icon);
        coinMain = findViewById(R.id.coins);
        gemMain = findViewById(R.id.gems);
        handler = new Handler();

        Intent intent = getIntent();
        coins = intent.getIntExtra("coins2", 0);
        gems = intent.getIntExtra("gems2", 0);
        score = intent.getIntExtra("score", 0);

        //улучшение
        upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Upgrade.class);
                intent1.putExtra("coins1", coins);
                intent1.putExtra("gems1", gems);
                startActivity(intent1);
                finish();
            }
        });


        //игра
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(getApplicationContext(), GameActivity.class);
                game.putExtra("coins1", coins);
                game.putExtra("gems1", gems);
                startActivity(game);
                finish();
            }
        });

        gemMain.setText(gems + "");
        handler.postDelayed(this::Format, 0);
    }

    //форматирование валют
    private void Format() {
        double coinFormat = coins;
        DecimalFormat df = new DecimalFormat("#.##");
        if (coinFormat < 1000)
            coinMain.setText(coins + "");
        if (coinFormat >= 1000 && coinFormat<1000000) {
            coinFormat = coinFormat/1000;
            coinMain.setText(df.format(coinFormat) + "k");
        }
        if (coinFormat >= 1000000) {
            coinFormat = coinFormat/1000000;
            coinMain.setText(df.format(coinFormat) + "m");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor save = sharedPreferences.edit();
        save.putInt("coins", coins);
        save.putInt("gems", gems);
        save.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences load = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        coins = load.getInt("coins", 0);
        gems = load.getInt("gems", 0);
        score = load.getInt("score", 0);

        if (score > 0) {
            coins = coins + score;
            coinMain.setText(coins + "");
            Toast.makeText(this, "We got "+score+" coins", Toast.LENGTH_LONG).show();
            load.edit().remove("score").commit();
        }
    }
}