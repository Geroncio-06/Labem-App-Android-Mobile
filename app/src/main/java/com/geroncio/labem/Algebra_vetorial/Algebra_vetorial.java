package com.geroncio.labem.Algebra_vetorial;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.geroncio.labem.MainActivity2;
import com.geroncio.labem.R;

public class Algebra_vetorial extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    ImageButton avd2p, normavetor, versor, coplanariedade, produtoescalar, produtovetorial,
            anguloentrevetores, produtomisto, projecaoortogonal, somavetores, voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algebra_vetorial);

        Inicializate();
        ChamarActivity();
    }

    /**
     * Linkando variaveis globais com objetos na tela de layout*/
    protected void Inicializate(){
        avd2p = findViewById(R.id.av_d2p);
        normavetor = findViewById(R.id.av_normavetor);
        versor = findViewById(R.id.av_versor);
        coplanariedade = findViewById(R.id.av_coplanaridade);
        produtoescalar = findViewById(R.id.av_produtescal);
        produtovetorial = findViewById(R.id.av_produtvet);
        produtomisto = findViewById(R.id.av_produtmisto);
        anguloentrevetores = findViewById(R.id.av_angulo_entre_vet);
        projecaoortogonal = findViewById(R.id.av_projort);
        somavetores = findViewById(R.id.av_somasubvet);
        voltar = findViewById(R.id.voltar);

        voltar.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            String main = "nomain";
            i.putExtra("STRING_I_FIELD", main);
            startActivity(i);
            finish();
        });
    }

    /**
     * Chamar outras atividades através da ação onClick*/
    protected void ChamarActivity(){

        /**
         * Ação de mudar para uma atividade especifíca*/
        avd2p.setOnClickListener(view -> startActivity(new Intent(Algebra_vetorial.this, AvVetordoispontos.class)));

        normavetor.setOnClickListener(view -> startActivity(new Intent(Algebra_vetorial.this, AvNormadovetor.class)));

        versor.setOnClickListener(view -> startActivity(new Intent(Algebra_vetorial.this, VersorVetor.class)));

        coplanariedade.setOnClickListener(view -> startActivity(new Intent(Algebra_vetorial.this, AvCoplanaridadevetores.class)));

        produtoescalar.setOnClickListener(view -> startActivity(new Intent(Algebra_vetorial.this, AvProdutoescalar.class)));

        produtovetorial.setOnClickListener(view -> startActivity(new Intent(Algebra_vetorial.this, AvProdutovetorial.class)));

        produtomisto.setOnClickListener(view -> startActivity(new Intent(Algebra_vetorial.this, AvProdutomisto.class)));

        anguloentrevetores.setOnClickListener(view -> startActivity(new Intent(Algebra_vetorial.this, AvAnguloentrevetores.class)));

        projecaoortogonal.setOnClickListener(view -> startActivity(new Intent(Algebra_vetorial.this, AvProjecaoortogonal.class)));

        somavetores.setOnClickListener(view -> startActivity(new Intent(Algebra_vetorial.this, AvSomavetores.class)));

    }
}