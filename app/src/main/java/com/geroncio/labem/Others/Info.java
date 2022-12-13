package com.geroncio.labem.Others;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import com.geroncio.labem.MainActivity2;
import com.geroncio.labem.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Info extends AppCompatActivity {

    ImageButton voltar;
    BottomNavigationView bottomNavigationView;
    String returnActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Inicializated();

        Intent intent = getIntent();
        returnActivity = intent.getStringExtra("STRING_ACTIVITY");



    }

    private void Inicializated() {

        voltar = findViewById(R.id.voltar);
        bottomNavigationView = findViewById(R.id.navigation);


        voltar.setOnClickListener(view -> {
            try {
                startActivity(new Intent(getApplicationContext(), Class.forName(returnActivity)));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            finish();
        });

    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onResume(){
        super.onResume();

        bottomNavigationView.setItemIconTintList(ColorStateList.valueOf(Color.BLACK));
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.home:
                    startActivity(new Intent(getApplicationContext()
                            , MainActivity2.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.calculator:
                    startActivity(new Intent(getApplicationContext()
                            , Calculator.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.settings:
                    startActivity(new Intent(getApplicationContext()
                            , Settings.class));
                    overridePendingTransition(0, 0);
                    return true;

            }
            return false;
        });

    }

}