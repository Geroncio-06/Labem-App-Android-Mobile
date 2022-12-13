package com.geroncio.labem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView gear1, gear2,gear3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        inicializate();
        animRotate();
        chamadadeActivity();

    }

    private void inicializate() {
        gear1 = findViewById(R.id.gear_1);
        gear2 = findViewById(R.id.gear_2);
        gear3 = findViewById(R.id.gear_3);
    }

    /**Aplicar animação de rotação a um objeto*/

    private void animRotate() {
        gear1.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotateh));
        gear2.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotateah));
        gear3.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotateh2));
    }

    private void chamadadeActivity(){

        new Handler().postDelayed(() -> {
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            String main = "main";
            i.putExtra("STRING_I_FIELD", main);
            startActivity(i);


            finish();
        },4600);

    }

}