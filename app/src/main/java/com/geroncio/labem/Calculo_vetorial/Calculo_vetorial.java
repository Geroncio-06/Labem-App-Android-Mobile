package com.geroncio.labem.Calculo_vetorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.geroncio.labem.Algebra_vetorial.Algebra_vetorial;
import com.geroncio.labem.MainActivity2;
import com.geroncio.labem.R;

public class Calculo_vetorial extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    ImageButton gradientecartesiano, gradrientecilindrico, gradienteesferico, divergentecartesiano,
            divergentecilindrico, divergenteesferico, rotacionalcartesiano, rotacionalcilindrico,
            rotacionalesferico, integraldelina, voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_vetorial);



        Inicializate();
        ChamarActivity();


    }

    /**
     * Linkando variaveis globais com objetos na tela de layout*/
    private void Inicializate() {
        gradientecartesiano = findViewById(R.id.gradientecartesiano);
        gradrientecilindrico = findViewById(R.id.cv_gradientecilindrico);
        gradienteesferico = findViewById(R.id.cv_gradienteesferico);
        divergentecartesiano = findViewById(R.id.cv_divergentecartesiano);
        divergentecilindrico = findViewById(R.id.cv_divergentecilindrico);
        divergenteesferico = findViewById(R.id.cv_divergenteesferico);
        rotacionalcartesiano = findViewById(R.id.cv_rotacionalcartesiano);
        rotacionalcilindrico = findViewById(R.id.cv_rotacionalcilindrico);
        rotacionalesferico = findViewById(R.id.cv_rotacionalesferico);
        integraldelina = findViewById(R.id.cv_integraldelinha);

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
    private void ChamarActivity(){
        gradientecartesiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GradienteCartesiano.class));
                overridePendingTransition(0, 0);
            }
        });

        gradrientecilindrico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CvGradientecilindrico.class));
                overridePendingTransition(0, 0);
            }
        });

        gradienteesferico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CvGradienteesferico.class));
                overridePendingTransition(0, 0);
            }
        });

        divergentecartesiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CvDivergentecartesiano.class));
                overridePendingTransition(0, 0);
            }
        });

        divergentecilindrico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CvDivergentecilindrico.class));
                overridePendingTransition(0, 0);
            }
        });

        divergenteesferico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CvDivergenteesferico.class));
                overridePendingTransition(0, 0);
            }
        });

        rotacionalcartesiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CvRotacionalcartesiano.class));
                overridePendingTransition(0, 0);
            }
        });

        rotacionalcilindrico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CvRotacionalcilindrico.class));
                overridePendingTransition(0, 0);
            }
        });

        rotacionalesferico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CvRotacionalesferico.class));
                overridePendingTransition(0, 0);
            }
        });

        integraldelina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CvIntegraldelinha.class));
                overridePendingTransition(0, 0);
            }
        });
    }
}