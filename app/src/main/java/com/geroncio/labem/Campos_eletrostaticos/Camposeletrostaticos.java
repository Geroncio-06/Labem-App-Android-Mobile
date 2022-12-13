package com.geroncio.labem.Campos_eletrostaticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.geroncio.labem.Calculo_vetorial.Calculo_vetorial;
import com.geroncio.labem.MainActivity2;
import com.geroncio.labem.R;

public class Camposeletrostaticos extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    ImageButton fcoulomb, itenscampele, linhasdecarga, superficiedecargas, volumedecargas, potencialemlina, potencialemsuperficie, potencialvolume, densidadedeenergia, voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camposeletrostaticos);

        Inicializate();
        ChamarActivity();
    }

    /**
     * Linkando variaveis globais com objetos na tela de layout*/
    private void Inicializate(){
        fcoulomb = findViewById(R.id.cmpeletrCoulomb);
        itenscampele = findViewById(R.id.ce_intensidadecampele);
        linhasdecarga = findViewById(R.id.ce_linhadecargas);
        superficiedecargas = findViewById(R.id.ce_superficiedecargas);
        volumedecargas = findViewById(R.id.ce_volumedecargas);
        potencialemlina = findViewById(R.id.ce_potencialemlinha);
        potencialemsuperficie = findViewById(R.id.ce_potencialemsuperficie);
        potencialvolume = findViewById(R.id.ce_poencialvolume);
        densidadedeenergia = findViewById(R.id.cedensidadedeenergia);

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
        fcoulomb.setOnClickListener(view -> {
            startActivity(new Intent(Camposeletrostaticos.this, CeForcacoulomb.class));
            overridePendingTransition(0, 0);
        });

        itenscampele.setOnClickListener(view -> {
            startActivity(new Intent(Camposeletrostaticos.this, CeIntensidadecamposeletricos.class));
            overridePendingTransition(0, 0);
        });

        linhasdecarga.setOnClickListener(view -> {
            startActivity(new Intent(Camposeletrostaticos.this, CeLinadecargas.class));
            overridePendingTransition(0, 0);
        });

        superficiedecargas.setOnClickListener(view -> {
            startActivity(new Intent(Camposeletrostaticos.this, CeSuperficiedecargas.class));
            overridePendingTransition(0, 0);
        });

        volumedecargas.setOnClickListener(view -> {
            startActivity(new Intent(Camposeletrostaticos.this, CeVolumedecargas.class));
            overridePendingTransition(0, 0);
        });

        potencialemlina.setOnClickListener(view -> {
            startActivity(new Intent(Camposeletrostaticos.this, CePotencialeletricolinha.class));
            overridePendingTransition(0, 0);
        });

        potencialemsuperficie.setOnClickListener(view -> {
            startActivity(new Intent(Camposeletrostaticos.this, CePotencialeletricoSuperficie.class));
            overridePendingTransition(0, 0);
        });

        potencialvolume.setOnClickListener(view -> {
            startActivity(new Intent(Camposeletrostaticos.this, CePotencialeletricoVolume.class));
            overridePendingTransition(0, 0);
        });
        densidadedeenergia.setOnClickListener(view -> {
            startActivity(new Intent(Camposeletrostaticos.this, CeTrabalholinha.class));
            overridePendingTransition(0, 0);
        });
    }
}