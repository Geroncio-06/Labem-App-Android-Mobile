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

import com.geroncio.labem.Calculo_vetorial.Calculo_vetorial;
import com.geroncio.labem.MainActivity2;
import com.geroncio.labem.Others.Calculator;
import com.geroncio.labem.Others.Info;
import com.geroncio.labem.Others.Settings;
import com.geroncio.labem.R;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.text.DecimalFormat;

public class CeForcacoulomb extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btnxn, btnpi;
    TextView txtimputx, txtimputy, info, infoM;
    EditText p_1 = null, p_2 = null, p_3 = null, p_4 = null, p_5 = null, p_6 = null;
    Double p1 = null, p2 = null, p3 = null, p4 = null, p5 = null, p6 = null;
    String processx = null;
    String processy = null;
    String sfcoulombx, sfcoulomby, sfcoulombz, sfcoulomb;
    ProgressBar progress;
    android.widget.Button calcular;
    ImageButton fxCalculator, fyCalculator;
    LinearLayout fxCalculatorLayout;
    LinearLayout.LayoutParams params;
    boolean tecladox = false, tecladoy = false;
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
        setContentView(R.layout.activity_ce_forcacoulomb);



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
                    params.height = 300;
                    fxCalculatorLayout.setLayoutParams(params);
                    tecladox = true;
                    tecladoy = false;

                },200);

                Teclado();

            }

        });

        fyCalculator.setOnClickListener(view -> {

            if (tecladoy){
                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 0;
                fxCalculatorLayout.setLayoutParams(params);
                tecladoy = false;

            }
            else {
                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 0;
                fxCalculatorLayout.setLayoutParams(params);

                new Handler().postDelayed(() -> {
                    params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                    params.height = 300;
                    fxCalculatorLayout.setLayoutParams(params);
                    tecladox = false;
                    tecladoy = true;
                },200);

                Tecladoy();
            }

        });


        Calcular();
    }

    /**
     * Linkando variaveis globais com objetos na tela de layout*/
    private void Inicializate() {

        calcular = findViewById(R.id.calcular);
        fxCalculator = findViewById(R.id.calculator_fxvisible); fyCalculator = findViewById(R.id.calculator_fyvisible);
        fxCalculatorLayout = findViewById(R.id.calculadora_fx);
        info = findViewById(R.id.infoM);
        infoM = findViewById(R.id.passosresult);
        txtimputx = findViewById(R.id.btnimputx);
        txtimputy = findViewById(R.id.btnimputy);
        p_1 = findViewById(R.id.p_1);
        p_2 = findViewById(R.id.p_2);
        p_3 = findViewById(R.id.p_3);
        p_4 = findViewById(R.id.p_4);
        p_5 = findViewById(R.id.p_5);
        p_6 = findViewById(R.id.p_6);
        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        progress = findViewById(R.id.progress);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "CeForcacoulomb.class";
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

    private  void Tecladoy(){

        btnc.setOnClickListener(view -> {
            txtimputy.setText("");
            processy = null;

            if (calculoClick){info.setText("");}
        });

        btnpi.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "π";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });

        btn0.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "0";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btn1.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "1";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btn2.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "2";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btn3.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "3";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btn4.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "4";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btn5.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "5";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btn6.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "6";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btn7.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "7";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btn8.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "8";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btn9.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "9";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btndiv.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "/";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnmul.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "*";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnsub.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "-";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnsom.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "+";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnvir.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + ".";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnpl.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}

        });
        btnpr.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + ")";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}

        });
        btnbackspace.setOnClickListener(view -> {
            processy = txtimputy.getText().toString();
            if (processy.length()>0){
                processy = processy.substring(0, processy.length() - 1);
                txtimputy.setText(processy);

                if (calculoClick){info.setText("");}

            }
            else {
                txtimputy.setText("");

                if (calculoClick){info.setText("");}
            }
        });
        btnxn.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() +"^(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}

        });


    }

    /**
     * Código para executar os calculos*/
    @SuppressLint("SetTextI18n")
    private void Calcular(){

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

                    /** Esse código define o tamanho do texto*/
                    info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));

                    /** Esse código define a cor do texto*/
                    info.setTextColor(getResources().getColor(R.color.black));

                    if (processx == null || processy == null || p_1.getText().toString() == null || p_2.getText().toString() == null
                            || p_3.getText().toString() == null || p_4.getText().toString() == null || p_5.getText().toString() == null
                            || p_6.getText().toString() == null){

                        info.setText(R.string.erro);
                        passos.setImageResource(R.drawable.ic_eye_lightblack);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                        layoutParams.height = 0;
                        layoutpassos.setLayoutParams(layoutParams);

                    }
                    else{



                        /**Repassando o valor das variaveis da caixa de texto para as
                         * variaveis do programa*/
                        p1 = Double.parseDouble(p_1.getText().toString());
                        p2 = Double.parseDouble(p_2.getText().toString());
                        p3 = Double.parseDouble(p_3.getText().toString());
                        p4 = Double.parseDouble(p_4.getText().toString());
                        p5 = Double.parseDouble(p_5.getText().toString());
                        p6 = Double.parseDouble(p_6.getText().toString());

                        Double R12x = p1 - p4;
                        Double R12y = p2 - p5;
                        Double R12z = p3 - p6;

                        /**
                         * Expression é o avaliador de expressão, que retorna o valor da função f(x,y,z) para um
                         * ponto que definimos (x,y,z).*/

                        Expression ex = new ExpressionBuilder(processx)
                                .variables("x")
                                .build()
                                .setVariable("x",1);
                        double Q1 = ex.evaluate();

                        Expression ey = new ExpressionBuilder(processy)
                                .variables("x")
                                .build()
                                .setVariable("x",1);
                        double Q2 = ey.evaluate();

                        Double normar12 = Math.sqrt(Math.pow(R12x, 2)+Math.pow(R12y,2)+Math.pow(R12z,2));

                        /**Inserindo variavel local do tipo double*/
                        Double fcoulomb = (9*Math.pow(10,9)*Q1*Q2)/(Math.pow(normar12,3));
                        Double fcoulombx = fcoulomb*R12x;
                        Double fcoulomby = fcoulomb*R12y;
                        Double fcoulombz = fcoulomb*R12z;



                        sfcoulombx = String.valueOf(df.format(fcoulombx)).replace(",",".");
                        sfcoulomby = String.valueOf(df.format(fcoulomby)).replace(",",".");
                        sfcoulombz = String.valueOf(df.format(fcoulombz)).replace(",",".");
                        sfcoulomb = String.valueOf(df.format(fcoulomb)).replace(",",".");

                        if (Math.abs(fcoulombx) < 0.01){
                            fcoulombx = fcoulombx*1000;
                            sfcoulombx = (df3.format(fcoulombx) + "*10<sup>-3</sup>").replace(",",".");
                        }

                        if (Math.abs(fcoulomby) < 0.01){
                            fcoulomby = fcoulomby*1000;
                            sfcoulomby = (df3.format(fcoulomby) + "*10<sup>-3</sup>").replace(",",".");
                        }

                        if (Math.abs(fcoulombz) < 0.01){
                            fcoulombz = fcoulombz*1000;
                            sfcoulombz = (df3.format(fcoulombz) + "*10<sup>-3</sup>").replace(",",".");
                        }

                        if (Math.abs(fcoulomb) < 0.01 && Math.abs(fcoulomb) > 0.001){
                            fcoulomb= fcoulomb*1000;
                            sfcoulomb = (df3.format(fcoulomb) + "*10<sup>-3</sup>").replace(",",".");
                        }


                        String separar = String.valueOf(fcoulomb);

                        if (separar.contains("E")){



                            String[] textoseparado = separar.split("E");
                            Double resfcoulomb = Double.parseDouble(textoseparado[0]);
                            Double resultado1x = Double.parseDouble(textoseparado[0])*R12x;
                            Double resultado1y = Double.parseDouble(textoseparado[0])*R12y;
                            Double resultado1z = Double.parseDouble(textoseparado[0])*R12z;



                            info.setText(Html.fromHtml("<b>F</b> = "+ (df2.format(resultado1x) + "*10<sup>" + textoseparado[1] + "</sup>").replace(",",".")+"<b>âx</b> + "+
                                    (df2.format(resultado1y) + "*10<sup>" + textoseparado[1] + "</sup>").replace(",",".")+"<b>ây</b> + "+
                                    (df2.format(resultado1z) + "*10<sup>" + textoseparado[1] + "</sup>").replace(",",".")+"<b>âz</b> N"));

                            infoM.setText(Html.fromHtml("F = k*Q<sub>1</sub>*Q<sub>2</sub>*(R<sub>12</sub>)/|R<sub>12</sub>|<sup>3</sup>" +
                                    "<br>" +
                                    "<br> .. k = 9*10<sup>9</sup> N.m<sup>2</sup>/C<sup>2</sup>" +
                                    "<br> .. Q<sub>1</sub> = "+processx+" C" +
                                    "<br> .. Q<sub>2</sub> = "+processy+" C" +
                                    "<br>" +
                                    "<br> .. R<sub>1</sub> = "+p_1.getText().toString()+"<b>âx</b> + "+p_2.getText().toString()+"ây + "+p_3.getText().toString()+"<b>âz</b>" +
                                    "<br> .. R<sub>2</sub> = "+p_4.getText().toString()+"<b>âx</b> + "+p_5.getText().toString()+"ây + "+p_6.getText().toString()+"<b>âz</b>" +
                                    "<br> " +
                                    "<br>" +
                                    "<br> .. R<sub>12</sub> = ("+p_1.getText().toString()+"-"+p_4.getText().toString()+")<b>âx</b> + ("+p_2.getText().toString()+"-"+p_5.getText().toString()+")ây + " +
                                    "<br> ........ ("+p_3.getText().toString()+"-"+p_6.getText().toString()+")<b>âz</b>" +
                                    "<br>" +
                                    "<br> .. R<sub>12</sub> = "+String.valueOf(df4.format(R12x)).replace(",",".")+"<b>âx</b> + "+String.valueOf(df4.format(R12y)).replace(",",".")+"ây + "+String.valueOf(df4.format(R12z)).replace(",",".")+"<b>âz</b> " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. |R<sub>12</sub>| = √[("+String.valueOf(df4.format(R12x)).replace(",",".")+")<sup>2</sup> + ("+String.valueOf(df4.format(R12y)).replace(",",".")+")<sup>2</sup> + ("+String.valueOf(df4.format(R12z)).replace(",",".")+")<sup>2</sup>]" +
                                    "<br> .. |R<sub>12</sub>| = √("+ df4.format(Math.pow(normar12, 2)).replace(",",".")+")" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. k*Q<sub>1</sub>*Q<sub>2</sub>/|R<sub>12</sub>|<sup>3</sup> = "+String.valueOf(df2.format(resfcoulomb)).replace(",",".")+"*10<sup>"+textoseparado[1]+"</sup>"+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>F</b> = "+String.valueOf(df4.format(resfcoulomb)).replace(",",".")+"*10<sup>"+textoseparado[1]+"</sup>"+"*(R<sub>12</sub>)" +
                                    "<br><b>F</b> = "+String.valueOf(df4.format(resfcoulomb)).replace(",",".")+"*10<sup>"+textoseparado[1]+"</sup>"+"*["+String.valueOf(df4.format(R12x)).replace(",",".")+"<b>âx</b> + "+String.valueOf(df4.format(R12y)).replace(",",".")+"ây + "+String.valueOf(df4.format(R12z)).replace(",",".")+"<b>âz</b>]" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>F</b> = "+ (df2.format(resultado1x) + "*10<sup>" + textoseparado[1] + "</sup>").replace(",",".")+"<b>âx</b> + "+
                                    (df2.format(resultado1y) + "*10<sup>" + textoseparado[1] + "</sup>").replace(",",".")+"<b>ây</b> + "+
                                    (df2.format(resultado1z) + "*10<sup>" + textoseparado[1] + "</sup>").replace(",",".")+"<b>âz</b> N"));

                            Passos();

                        }
                        else {



                            info.setText(Html.fromHtml("<b>F</b> = "+sfcoulombx+"<b>âx</b> + "+sfcoulomby+"<b>ây</b> + "+sfcoulombz+"<b>âz</b> N"));

                            infoM.setText(Html.fromHtml("F = k*Q<sub>1</sub>*Q<sub>2</sub>*(R<sub>12</sub>)/|R<sub>12</sub>|<sup>3</sup>" +
                                    "<br>" +
                                    "<br> .. k = 9*10<sup>9</sup> N.m<sup>2</sup>/C<sup>2</sup>" +
                                    "<br> .. Q<sub>1</sub> = "+processx+" C" +
                                    "<br> .. Q<sub>2</sub> = "+processy+" C" +
                                    "<br>" +
                                    "<br> .. R<sub>1</sub> = "+p_1.getText().toString()+"<b>âx</b> + "+p_2.getText().toString()+"<b>ây</b> + "+p_3.getText().toString()+"<b>âz</b>" +
                                    "<br> .. R<sub>2</sub> = "+p_4.getText().toString()+"<b>âx</b> + "+p_5.getText().toString()+"<b>ây</b> + "+p_6.getText().toString()+"<b>âz</b>" +
                                    "<br> " +
                                    "<br>" +
                                    "<br> .. R<sub>12</sub> = ("+p_1.getText().toString()+"-"+p_4.getText().toString()+")<b>âx</b> + ("+p_2.getText().toString()+"-"+p_5.getText().toString()+")<b>ây</b> + " +
                                    "<br> ........ ("+p_3.getText().toString()+"-"+p_6.getText().toString()+")<b>âz</b>" +
                                    "<br>" +
                                    "<br> .. R<sub>12</sub> = "+String.valueOf(df4.format(R12x)).replace(",",".")+"<b>âx</b> + "+String.valueOf(df4.format(R12y)).replace(",",".")+"<b>ây</b> + "+String.valueOf(df4.format(R12z)).replace(",",".")+"<b>âz</b> " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. |R<sub>12</sub>| = √[("+String.valueOf(df4.format(R12x)).replace(",",".")+")<sup>2</sup> + ("+String.valueOf(df4.format(R12y)).replace(",",".")+")<sup>2</sup> + ("+String.valueOf(df4.format(R12z)).replace(",",".")+")<sup>2</sup>]" +
                                    "<br> .. |R<sub>12</sub>| = √("+ df4.format(Math.pow(normar12, 2)).replace(",",".")+")" +
                                    "<br> .. |R<sub>12</sub>| = "+String.valueOf(df4.format(normar12)).replace(",",".")+
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. k*Q<sub>1</sub>*Q<sub>2</sub>/|R<sub>12</sub>|<sup>3</sup> = "+sfcoulomb+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>F</b> = "+sfcoulomb+"*(R<sub>12</sub>)" +
                                    "<br><b>F</b> = "+sfcoulomb+"*["+String.valueOf(df4.format(R12x)).replace(",",".")+"<b>âx</b> + "+String.valueOf(df4.format(R12y)).replace(",",".")+"<b>ây</b> + "+String.valueOf(df4.format(R12z)).replace(",",".")+"<b>âz</b>]" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>F</b> = "+sfcoulombx+"<b>âx</b> + "+sfcoulomby+"<b>ây</b> + "+sfcoulombz+"<b>âz</b> N"));

                            Passos();
                        }

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
                layoutParams.height = 1800;
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