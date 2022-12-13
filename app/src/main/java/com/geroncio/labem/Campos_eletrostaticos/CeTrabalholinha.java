package com.geroncio.labem.Campos_eletrostaticos;

import androidx.appcompat.app.AppCompatActivity;

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

import com.geroncio.labem.Others.Info;
import com.geroncio.labem.R;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class CeTrabalholinha extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btnxn, btnpi;
    TextView txtimputx, info, infoM;
    EditText  raioesfera = null;
    String processx = null;
    ProgressBar progress;
    String sfcoulomb;

    android.widget.Button calcular;
    ImageButton fxCalculator;
    LinearLayout fxCalculatorLayout;
    LinearLayout.LayoutParams params;
    boolean tecladox = false;
    boolean calculoClick = false;
    LinearLayout layoutpassos;
    ImageButton voltar, passos;
    ImageView ajuda;
    SharedPreferences preferences;
    String decimaisnum = "3";
    DecimalFormat df = new DecimalFormat("#0.0");
    DecimalFormat df2 = new DecimalFormat("#0.0");
    DecimalFormat df3 = new DecimalFormat("#0.0");
    DecimalFormat df4 = new DecimalFormat("#0.0");
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce_trabalholinha);

        Inicializate();
        InicializateTeclado();

        fxCalculator.setOnClickListener(view -> {

            if (tecladox){

                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 0;
                fxCalculatorLayout.setLayoutParams(params);
                tecladox = false;

            }
            else {

                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 0;
                fxCalculatorLayout.setLayoutParams(params);

                new Handler().postDelayed(() -> {

                    params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                    params.height = 280;
                    fxCalculatorLayout.setLayoutParams(params);

                    tecladox = true;


                },200);

                Teclado();

            }

        });

        Calcular();
    }

    /**
     * Linkando variaveis globais com objetos na tela de layout*/
    private void Inicializate() {
        calcular = findViewById(R.id.calcular);
        fxCalculator = findViewById(R.id.calculator_fxvisible);
        fxCalculatorLayout = findViewById(R.id.calculadora_fx);
        info = findViewById(R.id.infoM);
        infoM = findViewById(R.id.passosresult);
        txtimputx = findViewById(R.id.btnimputx);
        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        raioesfera = findViewById(R.id.raio);
        progress = findViewById(R.id.progress);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "CeTrabalholinha.class";
            i.putExtra("STRING_ACTIVITY", main);
            startActivity(i);
        });


        voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Camposeletrostaticos.class));
            finish();
        });

    }

    /**
     * Linkando variaveis globais com teclado na tela de layout*/
    private void InicializateTeclado() {
        btn0 = findViewById(R.id.gc_36);
        btn1 = findViewById(R.id.gc_25);
        btn2 = findViewById(R.id.gc_26);
        btn3 = findViewById(R.id.gc_27);
        btn4 = findViewById(R.id.gc_28);
        btn5 = findViewById(R.id.gc_31);
        btn6 = findViewById(R.id.gc_32);
        btn7 = findViewById(R.id.gc_33);
        btn8 = findViewById(R.id.gc_34);
        btn9 = findViewById(R.id.gc_35);

        btnsom = findViewById(R.id.gc_22);
        btnsub = findViewById(R.id.gc_23);
        btnmul = findViewById(R.id.gc_24);
        btndiv = findViewById(R.id.gc_30);

        btnpl = findViewById(R.id.gc_07);
        btnpr = findViewById(R.id.gc_08);
        btnc = findViewById(R.id.gc_06);
        btnpi = findViewById(R.id.gc_04);
        btnvir = findViewById(R.id.gc_29);


        btnxn = findViewById(R.id.gc_10);
        btnbackspace = findViewById(R.id.gc_05);


    }

    private  void Teclado(){

        btnc.setOnClickListener(view -> {
            txtimputx.setText("");
            processx = null;

            if (calculoClick){info.setText("");}
        });

        btnpi.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "π";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });

        btn0.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "0";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn1.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "1";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn2.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "2";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn3.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "3";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn4.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "4";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn5.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "5";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn6.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "6";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn7.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "7";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn8.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "8";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn9.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "9";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btndiv.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "/";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnmul.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "*";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnsub.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "-";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnsom.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "+";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnvir.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + ".";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnpl.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btnpr.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + ")";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btnbackspace.setOnClickListener(view -> {
            processx = txtimputx.getText().toString();
            if (processx.length()>0){
                processx = processx.substring(0, processx.length() - 1);
                txtimputx.setText(processx);

                if (calculoClick){info.setText("");}

            }
            else {
                txtimputx.setText("");

                if (calculoClick){info.setText("");}
            }
        });
        btnxn.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() +"^(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });

    }

    /**
     * Código para executar os calculos*/
    @SuppressLint("SetTextI18n")
    private void Calcular(){

        calcular.setOnClickListener(view -> {

            progress.setVisibility(View.VISIBLE);
            info.setText("");

            new Handler().postDelayed(() -> {

                try {

                    info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                    info.setTextColor(getResources().getColor(R.color.black));

                    double raio = Double.parseDouble(raioesfera.getText().toString());
                    String e1 = "8.85418782*10^(-12)";



                    Expression edouble = new ExpressionBuilder(processx)
                            .variables("x")
                            .build()
                            .setVariable("x",1);
                    double processdouble = edouble.evaluate();

                    Expression edouble1 = new ExpressionBuilder(e1)
                            .variables("x")
                            .build()
                            .setVariable("x",1);
                    double e0 = edouble1.evaluate();


                        Expression ex = new ExpressionBuilder("2*π*("+Math.pow(processdouble,2)+")*("+Math.pow(raio,5)+")/(45*"+e0+")")
                                .variables("x")
                                .build()
                                .setVariable("x",1);
                        double resultado = ex.evaluate();




                        sfcoulomb = df3.format(resultado);


                        if (Math.abs(resultado) < 0 && Math.abs(resultado) > 0.1){
                            resultado= resultado*10;
                            sfcoulomb = df3.format(resultado) + "*10<sup>-1</sup>";
                        }

                        if (Math.abs(resultado) < 0.1 && Math.abs(resultado) > 0.01){
                            resultado= resultado*100;
                            sfcoulomb = df3.format(resultado) + "*10<sup>-2</sup>";
                        }

                        if (Math.abs(resultado) < 0.01 && Math.abs(resultado) > 0.001){
                            resultado= resultado*1000;
                            sfcoulomb = df3.format(resultado) + "*10<sup>-3</sup>";
                        }


                        if (Math.abs(resultado) < 10000 && Math.abs(resultado) > 1000){
                            resultado= resultado/1000;
                            sfcoulomb = df3.format(resultado) + "*10<sup>3</sup>";
                        }

                        if (Math.abs(resultado) < 100000 && Math.abs(resultado) > 10000){
                            resultado= resultado/10000;
                            sfcoulomb = df3.format(resultado) + "*10<sup>4</sup>";
                        }

                        if (Math.abs(resultado) < 1000000 && Math.abs(resultado) > 100000){
                            resultado= resultado/100000;
                            sfcoulomb = df3.format(resultado) + "*10<sup>5</sup>";
                        }

                        if (Math.abs(resultado) < 10000000 && Math.abs(resultado) > 1000000){
                            resultado= resultado/1000000;
                            sfcoulomb = df3.format(resultado) + "*10<sup>6</sup>";
                        }


                        String separar = String.valueOf(resultado);



                        if (separar.contains("E")){

                            String[] textoseparado = separar.split("E");
                            Double resfcoulomb = Double.parseDouble(textoseparado[0]);


                            info.setText(Html.fromHtml("W = "+String.valueOf(df2.format(resfcoulomb)).replace(",",".")+"*10<sup>"+textoseparado[1]+"</sup>  J" ));

                            infoM.setText(Html.fromHtml("Determinando a energia armazenda em volume com geometria esférica" +
                                    "<br>" +
                                    "<br>W = [2*π/(45*εo)]*(ᵨv)<sup>2</sup>*R<sup>5</sup>" +
                                    "<br>" +
                                    "<br> .. [2*π/(45*εo)] = 15,7695*10<sup>9</sup>" +
                                    "<br> .. ᵨv = "+processx+" C/m<sup>3</sup>" +
                                    "<br> .. R = "+raio+" m"+
                                    "<br>" +
                                    "<br>" +
                                    "<br> [2*π/(45*εo)]*(ᵨv)<sup>2</sup>*R<sup>5</sup> = "+String.valueOf(df2.format(resfcoulomb)).replace(",",".")+"*10<sup>"+textoseparado[1]+"</sup>"+
                                    "<br>" +
                                    "<br>" +
                                    "<br>W = "+String.valueOf(df2.format(resfcoulomb)).replace(",",".")+"*10^<sup>"+textoseparado[1]+"</sup>  J"));

                            Passos();

                        }
                        else {

                            info.setText(Html.fromHtml("W = " + sfcoulomb + " J" ));


                            infoM.setText(Html.fromHtml("Determinando a energia armazenda em volume com geometria esférica" +
                                    "<br>" +
                                    "<br>W = [2*π/(45*εo)]*(ᵨv)<sup>2</sup>*R<sup>5</sup>" +
                                    "<br>" +
                                    "<br> .. [2*π/(45*εo)] = 15,7695*10<sup>9</sup>" +
                                    "<br> .. ᵨv = "+processx+" C/m<sup>3</sup>" +
                                    "<br> .. R = "+raio+" m"+
                                    "<br>" +
                                    "<br>" +
                                    "<br>[2*π/(45*εo)]*(ᵨv)<sup>2</sup>*R<sup>5</sup> = " + sfcoulomb +
                                    "<br>" +
                                    "<br>" +
                                    "<br>W = " + sfcoulomb + " J"));

                            Passos();

                        }






                }
                catch (Exception e ){
                    info.setText(R.string.erro2);
                    info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                    info.setTextColor(getResources().getColor(R.color.black2));
                    infoM.setText("");

                    passos.setImageResource(R.drawable.ic_eye_lightblack);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                    layoutParams.height = 0;
                    layoutpassos.setLayoutParams(layoutParams);
                }

                progress.setVisibility(View.INVISIBLE);

            },1000);



        });
    }

    /**
     * Tela de passo a passo fica visivel/invisivel*/
    protected void Passos(){

        if (counter == 1){
            //passos visivel
            passos.setOnClickListener(view -> {
                passos.setImageResource(R.drawable.ic_eye_azul);
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
            df2 = new DecimalFormat("#0.00");
            df3 = new DecimalFormat("#0.00");
            df4 = new DecimalFormat("#0.00");
        }
        if (decimaisnum.equals("3")){
            df = new DecimalFormat("#0.000");
            df2 = new DecimalFormat("#0.000");
            df3 = new DecimalFormat("#0.000");
            df4 = new DecimalFormat("#0.000");
        }
        if (decimaisnum.equals("4")){
            df = new DecimalFormat("#0.0000");
            df2 = new DecimalFormat("#0.0000");
            df3 = new DecimalFormat("#0.0000");
            df4 = new DecimalFormat("#0.0000");
        }

    }
}