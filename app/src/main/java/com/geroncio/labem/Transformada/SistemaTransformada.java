package com.geroncio.labem.Transformada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.geroncio.labem.MainActivity2;
import com.geroncio.labem.R;

public class SistemaTransformada extends AppCompatActivity {

    ImageButton cartcilin, cartesfer, cilindricocartesiano, cilindricoesferico, esfericocartesiano, esfericocilindrico, voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_transformada);

        Inicializate();
        ChamarActivity();
    }

    private void Inicializate() {
        cartcilin = findViewById(R.id.st_cartesianatocilindrico);
        cartesfer = findViewById(R.id.st_cartesianotoesferico);
        cilindricocartesiano = findViewById(R.id.st_cilindricotocartesiano);
        cilindricoesferico = findViewById(R.id.st_cilindricotoesferico);
        esfericocartesiano = findViewById(R.id.st_esfericotocartesiano);
        esfericocilindrico = findViewById(R.id.st_esfericotocilindrico);

        voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            String main = "nomain";
            i.putExtra("STRING_I_FIELD", main);
            startActivity(i);
            finish();
        });
    }

    private void ChamarActivity() {
        cartcilin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SistemaTransformada.this, StcCartesianocilindrico.class));
            }
        });

        cartesfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SistemaTransformada.this, StcCartesianoesferico.class));
            }
        });

        cilindricocartesiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SistemaTransformada.this, StcCilindricocartesiano.class));
            }
        });

        cilindricoesferico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SistemaTransformada.this, StcCilindricoesferico.class));
            }
        });

        esfericocartesiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SistemaTransformada.this, StcEsfericocartesiano.class));
            }
        });

        esfericocilindrico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SistemaTransformada.this, StcEsfericocilindrico.class));
            }
        });
    }
}