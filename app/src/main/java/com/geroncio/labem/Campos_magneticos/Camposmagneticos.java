package com.geroncio.labem.Campos_magneticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.geroncio.labem.Campos_eletrostaticos.Camposeletrostaticos;
import com.geroncio.labem.Campos_eletrostaticos.CeForcacoulomb;
import com.geroncio.labem.Campos_eletrostaticos.CeIntensidadecamposeletricos;
import com.geroncio.labem.Campos_eletrostaticos.CeLinadecargas;
import com.geroncio.labem.Campos_eletrostaticos.CePotencialeletricoSuperficie;
import com.geroncio.labem.Campos_eletrostaticos.CePotencialeletricoVolume;
import com.geroncio.labem.Campos_eletrostaticos.CePotencialeletricolinha;
import com.geroncio.labem.Campos_eletrostaticos.CeSuperficiedecargas;
import com.geroncio.labem.Campos_eletrostaticos.CeVolumedecargas;
import com.geroncio.labem.MainActivity2;
import com.geroncio.labem.R;

public class Camposmagneticos extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    ImageButton campMagLinha, cmespira, cmsolenoide, cmsuperficie, cmcabocoaxial, cmdensidadecartesiano, cmdensidadecilindrico,
            cmdensidadecorrente, cmdensidadecorrentecilindro, voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camposmagneticos);

        Inicializate();
        ChamarActivity();
    }

    /**
     * Linkando variaveis globais com objetos na tela de layout*/
    private void Inicializate(){
        campMagLinha = findViewById(R.id.cmpMagLinha);
        cmespira = findViewById(R.id.cm_espira);
        cmsolenoide = findViewById(R.id.cm_solenoide);
        cmsuperficie = findViewById(R.id.cm_superficie);
        cmcabocoaxial = findViewById(R.id.cmcabocoaixial);
        cmdensidadecartesiano = findViewById(R.id.cmdensidadefluxocartesiano);
        cmdensidadecilindrico = findViewById(R.id.cmdensidadefluxocilindrico);
        cmdensidadecorrente = findViewById(R.id.cmdensidadecorrente);
        cmdensidadecorrentecilindro = findViewById(R.id.cmdensidadecorrentecilindrico);

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
        campMagLinha.setOnClickListener(view -> {
            startActivity(new Intent(Camposmagneticos.this, Correnteemlinha.class));
            overridePendingTransition(0, 0);
        });

        cmespira.setOnClickListener(view -> {
            startActivity(new Intent(Camposmagneticos.this, CmEspira.class));
            overridePendingTransition(0, 0);
        });

        cmsolenoide.setOnClickListener(view -> {
            startActivity(new Intent(Camposmagneticos.this, CmSolenoide.class));
            overridePendingTransition(0, 0);
        });

        cmsuperficie.setOnClickListener(view -> {
            startActivity(new Intent(Camposmagneticos.this, CorrenteLamina.class));
            overridePendingTransition(0, 0);
        });

        cmcabocoaxial.setOnClickListener(view -> {
            startActivity(new Intent(Camposmagneticos.this, CmLinhacoaxiallonga.class));
            overridePendingTransition(0, 0);
        });

        cmdensidadecartesiano.setOnClickListener(view -> {
            startActivity(new Intent(Camposmagneticos.this, CmDensidadefluxomagneticocartesiano.class));
            overridePendingTransition(0, 0);
        });

        cmdensidadecilindrico.setOnClickListener(view -> {
            startActivity(new Intent(Camposmagneticos.this, CmDensidadefluxomagneticocilindrico.class));
            overridePendingTransition(0, 0);
        });

        cmdensidadecorrente.setOnClickListener(view -> {
            startActivity(new Intent(Camposmagneticos.this, CmDendidadecorrente.class));
            overridePendingTransition(0, 0);
        });

        cmdensidadecorrentecilindro.setOnClickListener(view -> {
            startActivity(new Intent(Camposmagneticos.this, CmDensidadecorrentecilindrico.class));
            overridePendingTransition(0, 0);
        });
    }
}