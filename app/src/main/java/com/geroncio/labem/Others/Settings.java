package com.geroncio.labem.Others;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.geroncio.labem.MainActivity2;
import com.geroncio.labem.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Settings extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RadioGroup radiodecimais;
    ImageButton voltar;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String decimaisnum = "3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferences = getSharedPreferences("Labem", Context.MODE_PRIVATE);
        decimaisnum = preferences.getString("Numberdecimals","3");

        Inicializate();



        voltar.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            String main = "nomain";
            i.putExtra("STRING_I_FIELD", main);
            startActivity(i);
            finish();
        });

        if (decimaisnum.equals("2")){
            radiodecimais.check(R.id.radiodoisdecimais);
        }
        if (decimaisnum.equals("3")){
            radiodecimais.check(R.id.radiotresdecimais);
        }
        if (decimaisnum.equals("4")){
            radiodecimais.check(R.id.radioquatrodecimais);
        }

        CheckBox();

    }

    private void Inicializate() {
        bottomNavigationView = findViewById(R.id.bottom_navigation4);
        radiodecimais = findViewById(R.id.radiodecimais);
        voltar = findViewById(R.id.voltar);
    }

    @SuppressLint("NonConstantResourceId")
    private void CheckBox(){
        radiodecimais.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i){
                case R.id.radiodoisdecimais:
                    editor = preferences.edit();
                    editor.putString("Numberdecimals","2");
                    editor.commit();
                    break;

                case R.id.radiotresdecimais:
                    editor = preferences.edit();
                    editor.putString("Numberdecimals","3");
                    editor.commit();
                    break;

                case R.id.radioquatrodecimais:
                    editor = preferences.edit();
                    editor.putString("Numberdecimals","4");
                    editor.commit();
                    break;
            }
        });
    }


    @Override
    protected void onResume(){
        super.onResume();

        bottomNavigationView.setSelectedItemId(R.id.settings);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.home:
                    startActivity(new Intent(getApplicationContext()
                            , MainActivity2.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.calculator:
                    startActivity(new Intent(getApplicationContext()
                            ,Calculator.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.settings:
                    return true;

            }
            return false;
        });
    }

}