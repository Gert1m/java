package com.example.deathgun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Upgrade extends AppCompatActivity implements Serializable {

    int weaponLvl, startCost, countWeaponUp;
    int damageLvl, startCost2, countDamageUp;
    int petLvl, getStartCost3, countPetUp;
    int caseWeapon, caseDamage, casePet;
    TextView coin2,gem2, weaponCost, damageCost;
    ImageView back, weaponUp, damageUp, petUp;
    private int coins, gems;
    double costMulty1, costMulty2;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade);

        //начальная цена оружия, урона, питомца
        startCost=12;
        startCost2=10;

        costMulty1=2.5;
        costMulty2=2.5;

        coin2 = findViewById(R.id.coins);
        //gem2 = findViewById(R.id.gems);
        back = findViewById(R.id.back);
        weaponUp = findViewById(R.id.weaponLvlUp);
        damageUp = findViewById(R.id.damageLvlUp);
        //petUp = findViewById(R.id.petLvlUp);
        weaponCost = findViewById(R.id.weaponCost);
        damageCost = findViewById(R.id.damageCost);
        handler = new Handler();

        //получение валют
        Intent intent = getIntent();
        coins = intent.getIntExtra("coins1", 0);
        gems = intent.getIntExtra("gems1", 0);

        //назад
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                intent1.putExtra("coins2", coins);
                intent1.putExtra("gems2",gems);
                startActivity(intent1);
                finish();
                
            }
        });
        //улучшение оружия
        weaponUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (weaponLvl) {
                    case 0:
                        switch (caseWeapon) {
                            case 0:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl1)).setImageResource(R.drawable.yellow);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 1:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl1)).setImageResource(R.drawable.orange);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 2:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl1)).setImageResource(R.drawable.green);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                        }
                        break;
                    case 1:
                        switch (caseWeapon) {
                            case 0:
                                if (coins >= startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl2)).setImageResource(R.drawable.yellow);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 1:
                                if (coins >= startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl2)).setImageResource(R.drawable.orange);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 2:
                                if (coins >= startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl2)).setImageResource(R.drawable.green);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (caseWeapon) {
                            case 0:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl3)).setImageResource(R.drawable.yellow);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 1:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl3)).setImageResource(R.drawable.orange);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 2:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl3)).setImageResource(R.drawable.green);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch (caseWeapon) {
                            case 0:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl4)).setImageResource(R.drawable.yellow);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 1:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl4)).setImageResource(R.drawable.orange);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 2:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl4)).setImageResource(R.drawable.green);
                                    WeaponLvl();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                        }
                        break;
                    case 4:
                        switch (caseWeapon) {
                            case 0:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl5)).setImageResource(R.drawable.yellow);
                                    WeaponLvl2();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                                case 1:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl5)).setImageResource(R.drawable.orange);
                                    WeaponLvl2();
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 2:
                                if (coins>=startCost) {
                                    ((ImageView) findViewById(R.id.weaponLvl5)).setImageResource(R.drawable.green);
                                    coins = coins-startCost;
                                    weaponCost.setText("Макс. уровень");
                                    ((ImageView) findViewById(R.id.weaponCoin)).setAlpha(1);
                                    Format();
                                    startCost = (int) (startCost*costMulty1);
                                    countWeaponUp++;
                                    caseWeapon++;
                                    ((TextView) findViewById(R.id.countWeaponUp)).setText(countWeaponUp+"");
                                }
                                else {
                                    weaponCost.setText("Не хватает "+(startCost-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                        }
                        break;
                }
            }
            private void Text() {
                weaponCost.setText("Цена "+startCost);
            }
            private void WeaponLvl() {
                coins = coins-startCost;
                Format();
                startCost = (int) (startCost*costMulty1);
                weaponCost.setText("Цена "+startCost);
                costMulty1=costMulty1-0.1;
                countWeaponUp++;
                ((TextView) findViewById(R.id.countWeaponUp)).setText(countWeaponUp+"");
                weaponLvl++;
            }
            private void WeaponLvl2() {
                coins = coins-startCost;
                Format();
                startCost = (int) (startCost*costMulty1);
                weaponCost.setText("Цена "+startCost);
                countWeaponUp++;
                ((TextView) findViewById(R.id.countWeaponUp)).setText(countWeaponUp+"");
                caseWeapon++;
                weaponLvl=0;
            }
        });
        //улучшение урона
        damageUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (damageLvl) {
                    case 0:
                        switch (caseDamage) {
                            case 0:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl1)).setImageResource(R.drawable.yellow);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 1:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl1)).setImageResource(R.drawable.orange);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 2:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl1)).setImageResource(R.drawable.green);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                        }
                        break;
                    case 1:
                        switch (caseDamage) {
                            case 0:
                                if (coins >= startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl2)).setImageResource(R.drawable.yellow);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 1:
                                if (coins >= startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl2)).setImageResource(R.drawable.orange);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 2:
                                if (coins >= startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl2)).setImageResource(R.drawable.green);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                        }
                        break;
                    case 2:
                        switch (caseDamage) {
                            case 0:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl3)).setImageResource(R.drawable.yellow);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 1:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl3)).setImageResource(R.drawable.orange);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 2:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl3)).setImageResource(R.drawable.green);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch (caseDamage) {
                            case 0:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl4)).setImageResource(R.drawable.yellow);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 1:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl4)).setImageResource(R.drawable.orange);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 2:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl4)).setImageResource(R.drawable.green);
                                    DamageLvl();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                        }
                        break;
                    case 4:
                        switch (caseDamage) {
                            case 0:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl5)).setImageResource(R.drawable.yellow);
                                    DamageLvl2();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 1:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl5)).setImageResource(R.drawable.orange);
                                    DamageLvl2();
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                            case 2:
                                if (coins>=startCost2) {
                                    ((ImageView) findViewById(R.id.damageLvl5)).setImageResource(R.drawable.green);
                                    coins = coins-startCost2;
                                    damageCost.setText("Макс. уровень");
                                    ((ImageView) findViewById(R.id.damageCoin)).setAlpha(1);
                                    Format();
                                    countDamageUp++;
                                    caseDamage++;
                                    ((TextView) findViewById(R.id.countDamageUp)).setText(countDamageUp+"");
                                }
                                else {
                                    damageCost.setText("Не хватает "+ (startCost2-coins));
                                    handler.postDelayed(this::Text,1000);
                                }
                                break;
                        }
                        break;
                }
            }
            private void Text() {
                damageCost.setText("Цена "+startCost2);
            }
            private void DamageLvl() {
                coins = coins-startCost2;
                Format();
                startCost2 = (int) (startCost2*costMulty2);
                damageCost.setText("Цена "+startCost2);
                costMulty2 = costMulty2-0.1;
                countDamageUp++;
                ((TextView) findViewById(R.id.countDamageUp)).setText(countDamageUp+"");
                damageLvl++;
            }
            private void DamageLvl2() {
                coins = coins-startCost2;
                Format();
                startCost2 = (int) (startCost2*costMulty2);
                damageCost.setText("Цена "+startCost2);
                costMulty2 = costMulty2-0.1;
                countDamageUp++;
                ((TextView) findViewById(R.id.countDamageUp)).setText(countDamageUp+"");
                caseDamage++;
                damageLvl=0;
            }
        });

        handler.postDelayed(this::Format, 0);
        coin2.setText(coins + "");
        gem2.setText(gems + "");
    }
    private void Format() {
        double coinFormat = coins;
        DecimalFormat df = new DecimalFormat("#.##");
        if (coinFormat < 1000)
            coin2.setText(coins + "");
        if (coinFormat >= 1000 && coinFormat<1000000) {
            coinFormat = coinFormat/1000;
            coin2.setText(df.format(coinFormat) + "k");
        }
        if (coinFormat >= 1000000) {
            coinFormat = coinFormat/1000000;
            coin2.setText(df.format(coinFormat) + "m");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor save = sharedPreferences.edit();
        save.putInt("coins", coins);
        save.putInt("gems", gems);
        save.putInt("countWeaponUp", countWeaponUp);
        save.putInt("countDamageUp", countDamageUp);
        save.putInt("caseWeapon", caseWeapon);
        save.putInt("weaponLvl", weaponLvl);
        save.putInt("caseDamage", caseDamage);
        save.putInt("damageLvl", damageLvl);
        save.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences load = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        coins = load.getInt("coins", 0);
        gems = load.getInt("gems", 0);
        countWeaponUp = load.getInt("countWeaponUp", 0);
        countDamageUp = load.getInt("countDamageUp", 0);
        caseWeapon = load.getInt("caseWeapon", 0);
        weaponLvl = load.getInt("weaponLvl", 0);
        caseDamage = load.getInt("caseDamage", 0);
        damageLvl = load.getInt("damageLvl", 0);
        UpgradeSave();
    }

    public void UpgradeSave() {
        //оружие
            if (countWeaponUp >= 1) {
                ((ImageView) findViewById(R.id.weaponLvl1)).setImageResource(R.drawable.yellow);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 2) {
                ((ImageView) findViewById(R.id.weaponLvl2)).setImageResource(R.drawable.yellow);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 3) {
                ((ImageView) findViewById(R.id.weaponLvl3)).setImageResource(R.drawable.yellow);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 4) {
                ((ImageView) findViewById(R.id.weaponLvl4)).setImageResource(R.drawable.yellow);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 5) {
                ((ImageView) findViewById(R.id.weaponLvl5)).setImageResource(R.drawable.yellow);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 6) {
                ((ImageView) findViewById(R.id.weaponLvl1)).setImageResource(R.drawable.orange);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 7) {
                ((ImageView) findViewById(R.id.weaponLvl2)).setImageResource(R.drawable.orange);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 8) {
                ((ImageView) findViewById(R.id.weaponLvl3)).setImageResource(R.drawable.orange);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 9) {
                ((ImageView) findViewById(R.id.weaponLvl4)).setImageResource(R.drawable.orange);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 10) {
                ((ImageView) findViewById(R.id.weaponLvl5)).setImageResource(R.drawable.orange);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 13) {
                ((ImageView) findViewById(R.id.weaponLvl1)).setImageResource(R.drawable.green);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 12) {
                ((ImageView) findViewById(R.id.weaponLvl2)).setImageResource(R.drawable.green);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 13) {
                ((ImageView) findViewById(R.id.weaponLvl3)).setImageResource(R.drawable.green);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
            if (countWeaponUp >= 14) {
                ((ImageView) findViewById(R.id.weaponLvl4)).setImageResource(R.drawable.green);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
            }
        weaponCost.setText("Цена " + startCost);
            if (countWeaponUp >= 15) {
                ((ImageView) findViewById(R.id.weaponLvl5)).setImageResource(R.drawable.green);
                startCost = (int) (startCost * costMulty1);
                costMulty1 = costMulty1 - 0.1;
                weaponCost.setText("Макс. уровень");
            }
        ((TextView) findViewById(R.id.countWeaponUp)).setText(countWeaponUp + "");
            //урон
        if (countDamageUp >= 1) {
            ((ImageView) findViewById(R.id.damageLvl1)).setImageResource(R.drawable.yellow);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 2) {
            ((ImageView) findViewById(R.id.damageLvl2)).setImageResource(R.drawable.yellow);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 3) {
            ((ImageView) findViewById(R.id.damageLvl3)).setImageResource(R.drawable.yellow);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 4) {
            ((ImageView) findViewById(R.id.damageLvl4)).setImageResource(R.drawable.yellow);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 5) {
            ((ImageView) findViewById(R.id.damageLvl5)).setImageResource(R.drawable.yellow);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 6) {
            ((ImageView) findViewById(R.id.damageLvl1)).setImageResource(R.drawable.orange);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 7) {
            ((ImageView) findViewById(R.id.damageLvl2)).setImageResource(R.drawable.orange);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 8) {
            ((ImageView) findViewById(R.id.damageLvl3)).setImageResource(R.drawable.orange);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 9) {
            ((ImageView) findViewById(R.id.damageLvl4)).setImageResource(R.drawable.orange);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 10) {
            ((ImageView) findViewById(R.id.damageLvl5)).setImageResource(R.drawable.orange);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 11) {
            ((ImageView) findViewById(R.id.damageLvl1)).setImageResource(R.drawable.green);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 12) {
            ((ImageView) findViewById(R.id.damageLvl2)).setImageResource(R.drawable.green);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 13) {
            ((ImageView) findViewById(R.id.damageLvl3)).setImageResource(R.drawable.green);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        if (countDamageUp >= 14) {
            ((ImageView) findViewById(R.id.damageLvl4)).setImageResource(R.drawable.green);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
        }
        damageCost.setText("Цена "+startCost2);
        if (countDamageUp >= 15) {
            ((ImageView) findViewById(R.id.damageLvl5)).setImageResource(R.drawable.green);
            startCost2 = (int) (startCost2 * costMulty2);
            costMulty2 = costMulty2 - 0.1;
            damageCost.setText("Макс. уровень");
        }
        ((TextView) findViewById(R.id.countDamageUp)).setText(countDamageUp + "");
    }
}