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

public class CeVolumedecargas extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btnxn, btnpi;
    TextView txtimputx, info, infoM;
    EditText p_1 = null, p_2 = null, p_3 = null, p_4 = null, p_5 = null, p_6 = null, raioesfera = null;
    Double p1 = null, p2 = null, p3 = null, p4 = null, p5 = null, p6 = null;
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
        setContentView(R.layout.activity_ce_volumedecargas);


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
        p_1 = findViewById(R.id.p_1);
        p_2 = findViewById(R.id.p_2);
        p_3 = findViewById(R.id.p_3);
        p_4 = findViewById(R.id.p_4);
        p_5 = findViewById(R.id.p_5);
        p_6 = findViewById(R.id.p_6);
        progress = findViewById(R.id.progress);
        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        raioesfera = findViewById(R.id.raio);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "CeVolumedecargas.class";
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
            processx = txtimputx.getText().toString() + "??";
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
     * C??digo para executar os calculos*/
    @SuppressLint("SetTextI18n")
    private void Calcular(){

        calcular.setOnClickListener(view -> {

            progress.setVisibility(View.VISIBLE);
            info.setText("");

            new Handler().postDelayed(() -> {

                try {

                    info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                    info.setTextColor(getResources().getColor(R.color.black));

                    p1 = Double.parseDouble(p_1.getText().toString());
                    p2 = Double.parseDouble(p_2.getText().toString());
                    p3 = Double.parseDouble(p_3.getText().toString());
                    p4 = Double.parseDouble(p_4.getText().toString());
                    p5 = Double.parseDouble(p_5.getText().toString());
                    p6 = Double.parseDouble(p_6.getText().toString());


                    Double R12x = p4 - p1;
                    Double R12y = p5 - p2;
                    Double R12z = p6 - p3;
                    Double sinteta = (Math.sqrt(Math.pow(R12x,2)+Math.pow(R12y,2)))/(Math.sqrt(Math.pow(R12x,2)+Math.pow(R12y,2)+Math.pow(R12z,2)));
                    Double costeta = R12z/(Math.sqrt(Math.pow(R12x,2)+Math.pow(R12y,2)+Math.pow(R12z,2)));
                    Double sinphi = R12y/(Math.sqrt(Math.pow(R12x,2)+Math.pow(R12y,2)));
                    Double cosphi = R12x/(Math.sqrt(Math.pow(R12x,2)+Math.pow(R12y,2)));
                    double raio = Double.parseDouble(raioesfera.getText().toString());
                    Double normar12 = Math.sqrt(Math.pow(R12x, 2)+Math.pow(R12y,2)+Math.pow(R12z,2));


                    if (normar12 <= Double.parseDouble(raioesfera.getText().toString())){

                        Expression ex = new ExpressionBuilder(processx)
                                .variables("x")
                                .build()
                                .setVariable("x",1);
                        double pv = ex.evaluate();


                        Double fcoulomb = (12*Math.PI*Math.pow(10,9)*pv*normar12);
                        Double fcoulombx = (12*Math.PI*Math.pow(10,9)*pv*normar12);


                        sfcoulomb = String.valueOf(df3.format(fcoulomb));


                        if (Math.abs(fcoulomb) < 0 && Math.abs(fcoulomb) > 0.1){
                            fcoulomb= fcoulomb*10;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>-1</sup>";
                        }

                        if (Math.abs(fcoulomb) < 0.1 && Math.abs(fcoulomb) > 0.01){
                            fcoulomb= fcoulomb*100;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>-2</sup>";
                        }

                        if (Math.abs(fcoulomb) < 0.01 && Math.abs(fcoulomb) > 0.001){
                            fcoulomb= fcoulomb*1000;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>-3</sup>";
                        }


                        if (Math.abs(fcoulomb) < 10000 && Math.abs(fcoulomb) > 1000){
                            fcoulomb= fcoulomb/1000;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>3</sup>";
                        }

                        if (Math.abs(fcoulomb) < 100000 && Math.abs(fcoulomb) > 10000){
                            fcoulomb= fcoulomb/10000;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>4</sup>";
                        }

                        if (Math.abs(fcoulomb) < 1000000 && Math.abs(fcoulomb) > 100000){
                            fcoulomb= fcoulomb/100000;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>5</sup>";
                        }

                        if (Math.abs(fcoulomb) < 10000000 && Math.abs(fcoulomb) > 1000000){
                            fcoulomb= fcoulomb/1000000;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>6</sup>";
                        }


                        String separar = String.valueOf(fcoulomb);


                        if (separar.contains("E")){


                            String[] textoseparado = separar.split("E");
                            Double resfcoulomb = Double.parseDouble(textoseparado[0]);


                            info.setText(Html.fromHtml("<b>??</b> = " + String.valueOf(df2.format(resfcoulomb)).replace(",", ".") + "*10<sup>" + textoseparado[1] + "</sup>??r Vm" +
                                    "<br>" +
                                    "<br><b>??</b> = " + df3.format(resfcoulomb * sinteta * cosphi) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??x</b> + " +
                                    df3.format(resfcoulomb * sinteta * sinphi) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??y</b> + " +
                                    df3.format(resfcoulomb * costeta) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??z</b> V/m"));

                            infoM.setText(Html.fromHtml("Campo el??trico de uma geometria esf??rica com o ponto de c??lculo dentro do volume de carga" +
                                    "<br>" +
                                    "<br><b>??</b>  = [1/(3*??o)]*(???v)*|<b>r</b>| <b>??r</b>" +
                                    "<br>" +
                                    "<br> .. [1/(3*??o)] = 12??*10<sup>9</sup> N.m<sup>2</sup>/C<sup>2</sup>" +
                                    "<br> .. ???v = " + processx + " C/m<sup>3</sup>" +
                                    "<br> .. R = " + raio + " m" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>r1</b> = " + p_1.getText().toString() + "<b>??x</b> + " + p_2.getText().toString() + "<b>??y</b> + " + p_3.getText().toString() + "<b>??z</b>" +
                                    "<br> .. <b>r2</b> = " + p_4.getText().toString() + "<b>??x</b> + " + p_5.getText().toString() + "<b>??y</b> + " + p_6.getText().toString() + "<b>??z</b>" +
                                    "<br> " +
                                    "<br>" +
                                    "<br> .. <b>r</b> = (" + p_4.getText().toString() + "-" + p_1.getText().toString() + ")<b>??x</b> + (" + p_5.getText().toString() + "-" + p_2.getText().toString() + ")<b>??y</b> + " +
                                    "<br> ........ (" + p_6.getText().toString() + "-" + p_3.getText().toString() + ")<b>??z</b>" +
                                    "<br>" +
                                    "<br> .. <b>r</b> = " + String.valueOf(df2.format(R12x)).replace(",", ".") + "<b>??x</b> + " + String.valueOf(df2.format(R12y)).replace(",", ".") + "<b>??y</b> + " + String.valueOf(df2.format(R12z)).replace(",", ".") + "<b>??z</b> " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. |<b>r</b>| = ???[(" + String.valueOf(df2.format(R12x)).replace(",", ".") + ")<sup>2</sup> + (" + String.valueOf(df2.format(R12y)).replace(",", ".") + ")<sup>2</sup> + (" + String.valueOf(df2.format(R12z)).replace(",", ".") + ")<sup>2</sup>]" +
                                    "<br> .. |<b>r</b>| = ???(" + df3.format(Math.pow(normar12, 2)) + ")" +
                                    "<br> .. |<b>r</b>| = " + df3.format(Math.pow(normar12, 2)) +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. [1/(3*??o)]*(???v)*|<b>r</b>| =  = " + String.valueOf(df2.format(resfcoulomb)).replace(",", ".") + "*10^(" + textoseparado[1] + ")" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>??</b> = " + String.valueOf(df2.format(resfcoulomb)).replace(",", ".") + "*10<sup>" + textoseparado[1] + "</sup> <b>??r</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>??r</b> = sin(??)*cos(???)<b>??x</b> + sin(??)*sin(???)<b>??y</b> " +
                                    "<br> ....... + cos(??)<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> . sin(??) = ???((Xc-Xv)<sup>2</sup>+(Yc-Yv)<sup>2</sup>)/| <b>r</b> |" +
                                    "<br>" +
                                    "<br> . cos(??) = z/|<b>r</b> |" +
                                    "<br>" +
                                    "<br> . sin(???) = y/???((Xc-Xv)<sup>2</sup>+(Yc-Yv)<sup>2</sup>)" +
                                    "<br>" +
                                    "<br> . cos(???) = x/???((Xc-Xv)<sup>2</sup>+(Yc-Yv)<sup>2</sup>)" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>.. <b>??r</b> = " + df2.format(sinteta * cosphi) + "<b>??x</b> + " + df2.format(sinteta * sinphi) + "<b>??y</b> + " + df2.format(costeta) + "<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>??</b> = " + df3.format(resfcoulomb * sinteta * cosphi) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??x</b> + " +
                                    df3.format(resfcoulomb * sinteta * sinphi) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??y</b> + " +
                                    df3.format(resfcoulomb * costeta) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??z</b> V/m"));

                            Passos();

                        }
                        else {



                            info.setText(Html.fromHtml("<b>??</b> = " + sfcoulomb + "<b>??r</b> V/m" +
                                    "<br>" +
                                    "<br><b>??</b> = " + df3.format(fcoulombx * sinteta * cosphi) + "<b>??x</b> + " + df3.format(fcoulombx * sinteta * sinphi) + "<b>??y</b> + " + df3.format(fcoulombx * costeta) + "<b>??z</b> V/m"));


                            infoM.setText(Html.fromHtml("Campo el??trico de uma geometria esf??rica com o ponto de c??lculo dentro do volume de carga" +
                                    "<br>" +
                                    "<br><b>??</b> = [1/(3*??o)]*(???v)*|<b>r</b>| <b>??r</b>" +
                                    "<br>" +
                                    "<br> .. [1/(3*??o)] = 12??*10<sup>9</sup> N.m<sup>2</sup>/C<sup>2</sup>" +
                                    "<br> .. ???v = " + processx + " C/m<sup>3</sup>" +
                                    "<br> .. R = " + raio + " m" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>r<sub>1</sub></b> = " + p_1.getText().toString() + "<b>??x</b> + " + p_2.getText().toString() + "<b>??y</b> + " + p_3.getText().toString() + "<b>??z</b>" +
                                    "<br> .. <b>r<sub>2</sub></b> = " + p_4.getText().toString() + "<b>??x</b> + " + p_5.getText().toString() + "<b>??y</b> + " + p_6.getText().toString() + "<b>??z</b>" +
                                    "<br> " +
                                    "<br>" +
                                    "<br> .. <b>r</b> = (" + p_4.getText().toString() + "-" + p_1.getText().toString() + ")<b>??x</b> + (" + p_5.getText().toString() + "-" + p_2.getText().toString() + ")<b>??y</b> + " +
                                    "<br> ........ (" + p_6.getText().toString() + "-" + p_3.getText().toString() + ")<b>??z</b>" +
                                    "<br>" +
                                    "<br> .. <b>r</b> = " + String.valueOf(df2.format(R12x)).replace(",", ".") + "<b>??x</b> + " + String.valueOf(df2.format(R12y)).replace(",", ".") + "<b>??y</b> + " + String.valueOf(df2.format(R12z)).replace(",", ".") + "<b>??z</b> " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. |<b>r</b>| = ???[(" + String.valueOf(df2.format(R12x)).replace(",", ".") + ")<sup>2</sup> + (" + String.valueOf(df2.format(R12y)).replace(",", ".") + ")<sup>2</sup> + (" + String.valueOf(df2.format(R12z)).replace(",", ".") + ")<sup>2</sup>]" +
                                    "<br> .. |<b>r</b>| = ???(" + df3.format(Math.pow(normar12, 2)) + ")" +
                                    "<br> .. |<b>r</b>| = " + df3.format(normar12) +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. [1/(3*??o)]*(???v)*|<b>r</b>| = " + sfcoulomb +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>??</b> = " + sfcoulomb + "<b>??r</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>??r</b> = sin(??)*cos(???)<b>??x</b> + sin(??)*sin(???)<b>??y</b> " +
                                    "<br> ....... + cos(??)<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> . sin(??) = ???((Xc-Xv)<sup>2</sup>+(Yc-Yv)<sup>2</sup>)/|<b>r</b>|" +
                                    "<br>" +
                                    "<br> . cos(??) = z/|<b>r</b>|" +
                                    "<br>" +
                                    "<br> . sin(???) = y/???((Xc-Xv)<sup>2</sup>+(Yc-Yv)<sup>2</sup>)" +
                                    "<br>" +
                                    "<br> . cos(???) = x/???((Xc-Xv)<sup>2</sup>+(Yc-Yv)<sup>2</sup>)" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>.. <b>??r</b> = " + df2.format(sinteta * cosphi) + "<b>??x</b> + " + df2.format(sinteta * sinphi) + "<b>??y</b> + " + df2.format(costeta) + "<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>??</b> = " + df3.format(fcoulombx * sinteta * cosphi) + "<b>??x</b> + " + df3.format(fcoulombx * sinteta * sinphi) + "<b>??y</b> + " + df3.format(fcoulombx * costeta) + "<b>??z</b> V/m"));

                            Passos();

                        }

                    }
                    if (normar12 > Double.parseDouble(raioesfera.getText().toString())){

                        Expression ex = new ExpressionBuilder(processx)
                                .variables("x")
                                .build()
                                .setVariable("x",1);
                        double pv = ex.evaluate();


                        Double fcoulomb = (12*Math.PI*Math.pow(10,9)*pv*Math.pow(raio,3))/(Math.pow(normar12,2));
                        Double fcoulomb2 = (12*Math.PI*Math.pow(10,9)*pv*Math.pow(raio,3))/(Math.pow(normar12,2));


                        sfcoulomb = String.valueOf(df3.format(fcoulomb));


                        if (Math.abs(fcoulomb) < 0 && Math.abs(fcoulomb) > 0.1){
                            fcoulomb= fcoulomb*10;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>-1</sup>";
                        }

                        if (Math.abs(fcoulomb) < 0.1 && Math.abs(fcoulomb) > 0.01){
                            fcoulomb= fcoulomb*100;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>-2</sup>";
                        }

                        if (Math.abs(fcoulomb) < 0.01 && Math.abs(fcoulomb) > 0.001){
                            fcoulomb= fcoulomb*1000;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>-3</sup>";
                        }


                        if (Math.abs(fcoulomb) < 10000 && Math.abs(fcoulomb) > 1000){
                            DecimalFormat df3 = new DecimalFormat("#0.00");
                            fcoulomb= fcoulomb/1000;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>3</sup>";
                        }

                        if (Math.abs(fcoulomb) < 100000 && Math.abs(fcoulomb) > 10000){
                            fcoulomb= fcoulomb/10000;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>4</sup>";
                        }

                        if (Math.abs(fcoulomb) < 1000000 && Math.abs(fcoulomb) > 100000){
                            fcoulomb= fcoulomb/100000;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>5</sup>";
                        }

                        if (Math.abs(fcoulomb) < 10000000 && Math.abs(fcoulomb) > 1000000){
                            fcoulomb= fcoulomb/1000000;
                            sfcoulomb = df3.format(fcoulomb) + "*10<sup>6</sup>";
                        }


                        String separar = String.valueOf(fcoulomb);


                        if (separar.contains("E")){


                            String[] textoseparado = separar.split("E");
                            Double resfcoulomb = Double.parseDouble(textoseparado[0]);
                            Double resultado1x = Double.parseDouble(textoseparado[0])*sinteta*cosphi;
                            Double resultado1y = Double.parseDouble(textoseparado[0])*sinteta*sinphi;
                            Double resultado1z = Double.parseDouble(textoseparado[0])*costeta;

                            info.setText(Html.fromHtml("<b>??</b> = " + String.valueOf(df2.format(resfcoulomb)).replace(",", ".") + "*10<sup>" + textoseparado[1] + "</sup> <b>??r</b> V/m" +
                                    "<br>" +
                                    "<br><b>??</b> = " + df3.format(resultado1x) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??x</b> + " +
                                    df3.format(resultado1y) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??y</b> + " +
                                    df3.format(resultado1z) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??z</b> V/m"));

                            infoM.setText(Html.fromHtml("Campo el??trico de uma geometria esf??rica com o ponto de c??lculo fora do volume de carga" +
                                    "<br>" +
                                    "<br><b>??</b> = [1/(3*??o)]*???v*(R<sup>3</sup>)/|<b>r</b>|<sup>2</sup> <b>??r</b>" +
                                    "<br>" +
                                    "<br> .. [1/(3*??o)] = 12??*10<sup>9</sup> N.m<sup>2</sup>/C<sup>2</sup>" +
                                    "<br> .. ???v = " + processx + " C/m<sup>3</sup>" +
                                    "<br> .. R = " + raioesfera.getText().toString() + " m" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>r<sub>1</sub></b> = " + p_1.getText().toString() + "<b>??x</b> + " + p_2.getText().toString() + "<b>??y</b> + " + p_3.getText().toString() + "<b>??z</b>" +
                                    "<br> .. <b>r<sub>2</sub></b> = " + p_4.getText().toString() + "<b>??x</b> + " + p_5.getText().toString() + "<b>??y</b> + " + p_6.getText().toString() + "<b>??z</b>" +
                                    "<br> " +
                                    "<br>" +
                                    "<br> .. <b>r</b> = (" + p_4.getText().toString() + "-" + p_1.getText().toString() + ")<b>??x</b> + (" + p_5.getText().toString() + "-" + p_2.getText().toString() + ")<b>??y</b> + " +
                                    "<br> ........ (" + p_6.getText().toString() + "-" + p_3.getText().toString() + ")<b>??z</b>" +
                                    "<br>" +
                                    "<br> .. <b>r</b> = " + String.valueOf(df2.format(R12x)).replace(",", ".") + "<b>??x</b> + " + String.valueOf(df2.format(R12y)).replace(",", ".") + "<b>??y</b> + " + String.valueOf(df2.format(R12z)).replace(",", ".") + "<b>??z</b> " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. |<b>r</b>| = ???[(" + String.valueOf(df2.format(R12x)).replace(",", ".") + ")<sup>2</sup> + (" + String.valueOf(df2.format(R12y)).replace(",", ".") + ")<sup>2</sup> + (" + String.valueOf(df2.format(R12z)).replace(",", ".") + ")<sup>2</sup>]" +
                                    "<br> .. |<b>r</b>| = ???(" + df3.format(Math.pow(normar12, 2)) + ")" +
                                    "<br> .. |<b>r</b> | = "+ df3.format(normar12) +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. [1/(3*??o)]*???v*(R<sup>3</sup>)/|r|<sup>2</sup> =  = " + String.valueOf(df2.format(resfcoulomb)).replace(",", ".") + "*10^(" + textoseparado[1] + ")" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>??</b> = " + String.valueOf(df2.format(resfcoulomb)).replace(",", ".") + "*10<sup>" + textoseparado[1] + "</sup> <b>??r</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>??r</b> = sin(??)*cos(???)<b>??x</b> + sin(??)*sin(???)<b>??y</b> " +
                                    "<br> ....... + cos(??)<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> . sin(??) = ???((Xc-Xv)<sup>2</sup>+(Yc-Yv)<sup>2</sup>)/|<b>r</b>|" +
                                    "<br>" +
                                    "<br> . cos(??) = z/|<b>r</b>|" +
                                    "<br>" +
                                    "<br> . sin(???) = y/???((Xc-Xv)<sup>2</sup>+(Yc-Yv)<sup>2</sup>)" +
                                    "<br>" +
                                    "<br> . cos(???) = x/???((Xc-Xv)<sup>2</sup>+(Yc-Yv)<sup>2</sup>)" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>.. <b>??r</b> = " + df2.format(sinteta * cosphi) + "<b>??x</b> + " + df2.format(sinteta * sinphi) + "<b>??y</b> + " + df2.format(costeta) + "<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>??</b> = " + df3.format(resultado1x) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??x</b> + " +
                                    df3.format(resultado1y) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??y</b> + " +
                                    df3.format(resultado1z) + "*10<sup>" + textoseparado[1] + "</sup>" + "<b>??z</b> V/m"));

                            Passos();

                        }
                        else {



                            info.setText(Html.fromHtml("<b>??</b> = "+sfcoulomb+"<b>??r</b> V/m" +
                                    "<br>" +
                                    "<br><b>??</b> = "+ df3.format(fcoulomb2 * sinteta * cosphi) +"<b>??x</b> + "+ df3.format(fcoulomb2 * sinteta * sinphi) +"<b>??y</b> + "+ df3.format(fcoulomb2 * costeta) +"<b>??z</b> V/m"));


                            infoM.setText(Html.fromHtml("Campo el??trico de uma geometria esf??rica com o ponto de c??lculo fora do volume de carga" +
                                    "<br>" +
                                    "<br><b>??</b>  = [1/(3*??o)]*???v*(R<sup>3</sup>)/|<b>r</b> |<sup>2</sup> <b>??r</b>" +
                                    "<br>" +
                                    "<br> .. [1/(3*??o)] = 12??*10<sup>9</sup> N.m<sup>2</sup>/C<sup>2</sup>" +
                                    "<br> .. ???v = "+processx+" C/m<sup>3</sup>" +
                                    "<br> .. R = "+raioesfera.getText().toString()+ " m" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>r1</b>  = "+p_1.getText().toString()+"<b>??x</b> + "+p_2.getText().toString()+"<b>??y</b> + "+p_3.getText().toString()+"<b>??z</b>" +
                                    "<br> .. <b>r2</b>  = "+p_4.getText().toString()+"<b>??x</b> + "+p_5.getText().toString()+"<b>??y</b> + "+p_6.getText().toString()+"<b>??z</b>" +
                                    "<br> " +
                                    "<br>" +
                                    "<br> .. <b>r</b>  = ("+p_4.getText().toString()+"-"+p_1.getText().toString()+")<b>??x</b> + ("+p_5.getText().toString()+"-"+p_2.getText().toString()+")<b>??y</b> + " +
                                    "<br> ........ ("+p_6.getText().toString()+"-"+p_3.getText().toString()+")<b>??z</b>" +
                                    "<br>" +
                                    "<br> .. <b>r</b>  = "+String.valueOf(df2.format(R12x)).replace(",",".")+"<b>??x</b> + "+String.valueOf(df2.format(R12y)).replace(",",".")+"<b>??y</b> + "+String.valueOf(df2.format(R12z)).replace(",",".")+"<b>??z</b> " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. |<b>r</b> | = ???[("+String.valueOf(df2.format(R12x)).replace(",",".")+")^2 + ("+String.valueOf(df2.format(R12y)).replace(",",".")+")^2 + ("+String.valueOf(df2.format(R12z)).replace(",",".")+")^2]" +
                                    "<br> .. |<b>r</b> | = ???("+ df3.format(Math.pow(normar12, 2)) +")" +
                                    "<br> .. |<b>r</b> | = "+ df3.format(normar12) +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. [1/(3*??o)]*???v*(R<sup>3</sup>)/| |<b>r</b> |<sup>]2</sup> = "+sfcoulomb+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>??</b>  = "+sfcoulomb+"<b>??r</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>??r</b> = sin(??)*cos(???)<b>??x</b> + sin(??)*sin(???)<b>??y</b> " +
                                    "<br> ....... + cos(??)<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> . sin(??) = ???((Xc-Xv)^(2)+(Yc-Yv)^(2))/|<b>r</b>|"+
                                    "<br>" +
                                    "<br> . cos(??) = z/|<b>r</b>|" +
                                    "<br>" +
                                    "<br> . sin(???) = y/???((Xc-Xv)^(2)+(Yc-Yv)^(2))" +
                                    "<br>" +
                                    "<br> . cos(???) = x/???((Xc-Xv)^(2)+(Yc-Yv)^(2))" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>.. <b>??r</b> = "+ df2.format(sinteta * cosphi) +"<b>??x</b> + "+ df2.format(sinteta * sinphi) +"<b>??y</b> + "+ df2.format(costeta) +"<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>??</b> = "+ df3.format(fcoulomb2 * sinteta * cosphi) +"<b>??x</b> + "+ df3.format(fcoulomb2 * sinteta * sinphi) +"<b>??y</b> + "+ df3.format(fcoulomb2 * costeta) +"<b>??z</b> V/m"
                            ));

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
     * Verificando se houve atualizal????es nas variaveis universais do aplicativo */
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