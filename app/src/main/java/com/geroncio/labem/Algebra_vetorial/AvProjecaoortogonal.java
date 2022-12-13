package com.geroncio.labem.Algebra_vetorial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.geroncio.labem.Others.Info;
import com.geroncio.labem.R;

import java.text.DecimalFormat;

public class AvProjecaoortogonal extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    EditText p1_x, p1_y, p1_z, p2_x, p2_y, p2_z;
    android.widget.Button calcular;
    TextView infoM, passosresult;
    ImageButton voltar, passos;
    LinearLayout layoutpassos;
    ProgressBar progress;
    Double p1x, p1y, p1z, p2x, p2y, p2z;
    SharedPreferences preferences;
    String decimaisnum = "3";
    DecimalFormat df = new DecimalFormat("#0.0");
    ImageView ajuda;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_av_projecaoortogonal);


        Inicializate();
        Calcular();
    }

    /**
     * Linkando variaveis globais com objetos na tela de layout*/
    protected void Inicializate(){
        p1_x = findViewById(R.id.p1_x); p1_y = findViewById(R.id.p1_y); p1_z = findViewById(R.id.p1_z);
        p2_x = findViewById(R.id.p2_x); p2_y = findViewById(R.id.p2_y); p2_z = findViewById(R.id.p2_z);
        calcular = findViewById(R.id.calcular);
        infoM = findViewById(R.id.infoM);
        voltar = findViewById(R.id.voltar);
        progress = findViewById(R.id.progress);
        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos); passosresult = findViewById(R.id.passosresult);

        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "AvProjecaoortogonal.class";
            i.putExtra("STRING_ACTIVITY", main);
            startActivity(i);
        });

        voltar.setOnClickListener(view -> {
            startActivity(new Intent(AvProjecaoortogonal.this, Algebra_vetorial.class));
            finish();
        });


    }

    /**
     * Código para executar os calculos*/
    @SuppressLint("SetTextI18n")
    protected void  Calcular(){

        /**
         * Evento clicar em calcular*/
        calcular.setOnClickListener(view -> {

            /**
             * Objeto de carregamento fica visivel na tela*/
            progress.setVisibility(View.VISIBLE);

            /**
             * Objeto texto vai escrever tudo que estiver entre aspas, no caso aqui nada.*/
            infoM.setText("");

            /**
             * O código dentro do Handler sofre um delay programado, só será executado
             * depois de um tempo desejado*/
            new Handler().postDelayed(() -> {

                /**
                 * try executa o código normalmente caso não hja erro
                 * catch é um código de fuga caso haja erro dentro de try*/

                try {

                    /**
                     * Resgatando texto escrito em caixa de texto e passando para a variavel*/
                    p1x = Double.parseDouble(p1_x.getText().toString());
                    p1y = Double.parseDouble(p1_y.getText().toString());p1z = Double.parseDouble(p1_z.getText().toString());
                    p2x = Double.parseDouble(p2_x.getText().toString());
                    p2y = Double.parseDouble(p2_y.getText().toString()); p2z = Double.parseDouble(p2_z.getText().toString());

                    /**
                     * Introduzindo variaveis locais do tipo texto (String)*/
                    String result1 = df.format(p1x * p2x + p1y * p2y + p1z * p2z);
                    String result2 = df.format(p2x * p2x + p2y * p2y + p2z * p2z);
                    String result3 = df.format((p1x * p2x + p1y * p2y + p1z * p2z) / (p2x * p2x + p2y * p2y + p2z * p2z));

                    String result = "" + df.format(((p1x * p2x + p1y * p2y + p1z * p2z) / (p2x * p2x + p2y * p2y + p2z * p2z)) * (p2x)) + "<b>âx</b> + " + df.format(((p1x * p2x + p1y * p2y + p1z * p2z) / (p2x * p2x + p2y * p2y + p2z * p2z)) * (p2y)) + "<b>ây</b> + " + df.format(((p1x * p2x + p1y * p2y + p1z * p2z) / (p2x * p2x + p2y * p2y + p2z * p2z)) * (p2z))+ "<b>âz</b>";
                    String resultinfo = "" + df.format(((p1x * p2x + p1y * p2y + p1z * p2z) / (p2x * p2x + p2y * p2y + p2z * p2z)) * (p2x)) + "<b>âx</b> + " + df.format(((p1x * p2x + p1y * p2y + p1z * p2z) / (p2x * p2x + p2y * p2y + p2z * p2z)) * (p2y)) + "<b>ây</b> + " + df.format(((p1x * p2x + p1y * p2y + p1z * p2z) / (p2x * p2x + p2y * p2y + p2z * p2z)) * (p2z))+ "<b>âz</b>";


                    String resultpassos = "<b>U</b> = (x<sub>1</sub>, y<sub>1</sub>, z<sub>1</sub>) , <b>V</b> = (x<sub>2</sub>, y<sub>2</sub>, z<sub>2</sub>)"+
                            "<br>"+
                            "<br><b>U &middot V</b> = x<sub>1</sub>*x<sub>2</sub> + y<sub>1</sub>*y<sub>2</sub> + z<sub>1</sub>*z<sub>2</sub>" +
                            "<br>|<b>V</b>| = √[(x<sub>2</sub><sup>2</sup>) + (y<sub>2</sub><sup>2</sup>) + (z<sub>2</sub><sup>2</sup>)]"+
                            "<br>"+
                            "<br>"+
                            "<br>Proj(<b>U</b>,<b>V</b>) = | |"+ result1+"|/("+result2+") |*("+df.format(p2x)+"<b>âx</b> + "+df.format(p2y)+"<b>ây</b> + "+df.format(p2z)+"<b>âz</b>)" +
                            "<br>"+
                            "<br>"+
                            "<br>Proj(<b>U</b>,<b>V</b>) = ("+result3+")*("+df.format(p2x)+"<b>âx</b> + "+df.format(p2y)+"<b>ây</b> + "+df.format(p2z)+"<b>âz</b>)" +
                            "<br>"+
                            "<br>Proj(<b>U</b>,<b>V</b>) = "+result;

                    resultpassos = resultpassos.replace("+ -","- ");
                    resultinfo = resultinfo.replace("+ -","- ");



                    infoM.setText(Html.fromHtml("Proj(<b>U</b>,<b>V</b>) = "+resultinfo));
                    infoM.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisoito));
                    infoM.setTextColor(getResources().getColor(R.color.black));
                    passosresult.setText(Html.fromHtml(resultpassos));


                    Passos();
                }
                catch (Exception e){
                    infoM.setText(R.string.erro);
                    infoM.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                    infoM.setTextColor(getResources().getColor(R.color.black2));
                    passosresult.setText("");

                    passos.setImageResource(R.drawable.ic_eye_lightblack);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                    layoutParams.height = 0;
                    layoutpassos.setLayoutParams(layoutParams);
                }

                /**
                 * Objeto de carregamento fica invisivel na tela*/

                progress.setVisibility(View.INVISIBLE);

            },500);


        });


    }

    /**
     * Objeto de carregamento fica invisivel*/
    protected void Passos(){


        if (counter == 1){
            //passos visivel
            passos.setOnClickListener(view -> {
                passos.setImageResource(R.drawable.ic_eye_vermelhoestacao);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                layoutParams.height = 1000;
                layoutpassos.setLayoutParams(layoutParams);
                counter = 0;
                Passos();
            });
        }
        if (counter == 0){
            //passos oculto
            passos.setOnClickListener(view -> {
                passos.setImageResource(R.drawable.ic_eye_lightblack);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                layoutParams.height = 0;
                layoutpassos.setLayoutParams(layoutParams);
                counter = 1;
                Passos();
            });
        }


    }

    /**
     * Verificando se houve atualizalções nas variaveis universais do aplicativo */
    @Override
    protected void onResume(){
        super.onResume();

        /**
         * Recebendo valor da variavel universal guardada em Labem com nome Numberdecimals, definido por mim*/
        preferences = getSharedPreferences("Labem", Context.MODE_PRIVATE);
        decimaisnum = preferences.getString("Numberdecimals","3");

        if (decimaisnum.equals("2")){
            df = new DecimalFormat("#0.00");
        }
        if (decimaisnum.equals("3")){
            df = new DecimalFormat("#0.000");
        }
        if (decimaisnum.equals("4")){
            df = new DecimalFormat("#0.0000");
        }

    }

}