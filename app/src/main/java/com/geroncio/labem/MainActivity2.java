package com.geroncio.labem;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;

import com.geroncio.labem.Algebra_vetorial.Algebra_vetorial;
import com.geroncio.labem.Algebra_vetorial.AvProdutovetorial;
import com.geroncio.labem.Calculo_vetorial.Calculo_vetorial;
import com.geroncio.labem.Calculo_vetorial.CvRotacionalcartesiano;
import com.geroncio.labem.Campos_eletrostaticos.Camposeletrostaticos;
import com.geroncio.labem.Campos_eletrostaticos.CeLinadecargas;
import com.geroncio.labem.Campos_magneticos.Camposmagneticos;
import com.geroncio.labem.Campos_magneticos.Correnteemlinha;
import com.geroncio.labem.Others.Calculator;
import com.geroncio.labem.Others.Newseacrchlayout;
import com.geroncio.labem.Others.Settings;
import com.geroncio.labem.Transformada.SistemaTransformada;
import com.geroncio.labem.Transformada.StcCartesianoesferico;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    private View background;
    BottomNavigationView bottomNavigationView;
    Button algebraVetorial, sistemaTransformada;
    Button calculoVetorial, camposEletrostaticos, camposMag;
    ImageButton produtovetorial, cartesianoparaesferico, rotacionalcartesiano, linhadecarga, cmlinha;
    android.widget.Button  search;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        calculoVetorial = findViewById(R.id.buttonl_3);

        overridePendingTransition(R.anim.do_not_move,R.anim.do_not_move);
        background = findViewById(R.id.background);

        Intent intent = getIntent();

        /** Preparando o sistema Android para mudar a animação de entrada de tela*/

        String animation = intent.getStringExtra("STRING_I_FIELD");
        if (animation!=null){
            if(animation.equals("main")){
                if (savedInstanceState == null){

                    background.setVisibility(View.INVISIBLE);

                    final ViewTreeObserver viewTreeObserver = background.getViewTreeObserver();

                    if(viewTreeObserver.isAlive()){

                        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                            @Override
                            public void onGlobalLayout() {
                                circularRevealActivity();
                                background.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                        });

                    }
                }
            }
            else{

            }
        }




        Inicializate();




        search.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, Newseacrchlayout.class));
            overridePendingTransition(0, 0);
        });

        SuggestionFolder();


        AllFolder();





    }


    private void SuggestionFolder() {

        produtovetorial.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, AvProdutovetorial.class));
            overridePendingTransition(0, 0);
        });

        cartesianoparaesferico.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, StcCartesianoesferico.class));
            overridePendingTransition(0, 0);
        });

        rotacionalcartesiano.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, CvRotacionalcartesiano.class));
            overridePendingTransition(0, 0);
        });

        linhadecarga.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, CeLinadecargas.class));
            overridePendingTransition(0, 0);
        });

        cmlinha.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, Correnteemlinha.class));
            overridePendingTransition(0, 0);
        });



    }

    private void AllFolder() {

        algebraVetorial.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, Algebra_vetorial.class));
            overridePendingTransition(0, 0);
        });

        sistemaTransformada.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, SistemaTransformada.class));
            overridePendingTransition(0, 0);
        });

        calculoVetorial.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, Calculo_vetorial.class));
            overridePendingTransition(0, 0);
        });

        camposEletrostaticos.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, Camposeletrostaticos.class));
            overridePendingTransition(0, 0);
        });

        camposMag.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity2.this, Camposmagneticos.class));
            overridePendingTransition(0, 0);
        });
    }

    /**Mudando a entrada normal para uma circular*/
    private void circularRevealActivity() {




        int cx = background.getWidth()/2;
        int cy = background.getHeight()/2;

        float finalRadius = Math.max(background.getWidth(), background.getHeight());

        Animator circularReveal = ViewAnimationUtils.createCircularReveal(
                background,
                cx,
                cy,
                0, //começa a partir do raio 0
                finalRadius);


        circularReveal.setDuration(1200);
        background.setVisibility(View.VISIBLE);
        circularReveal.start();
    }

    private void Inicializate() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        algebraVetorial = findViewById(R.id.button_1);
        sistemaTransformada = findViewById(R.id.button_2);
        search = findViewById(R.id.search_pp);
        produtovetorial = findViewById(R.id.produtovetorial);
        cartesianoparaesferico = findViewById(R.id.home_cartesianotoesferico);
        rotacionalcartesiano = findViewById(R.id.home_rotacionalcartesiano);
        camposEletrostaticos = findViewById(R.id.buttonl_4);
        camposMag = findViewById(R.id.buttonl_5);
        linhadecarga = findViewById(R.id.home_linhadecargas);
        cmlinha = findViewById(R.id.home_cmlinha);


    }


    @Override
    protected void onResume(){
        super.onResume();

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.home:
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