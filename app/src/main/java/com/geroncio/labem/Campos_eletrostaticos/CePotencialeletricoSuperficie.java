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
import android.widget.RadioGroup;
import android.widget.TextView;

import com.geroncio.labem.Others.Info;
import com.geroncio.labem.R;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.text.DecimalFormat;

public class CePotencialeletricoSuperficie extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btnxn, btnpi;
    TextView txtimputx, info, infoM;
    EditText p_1 = null, p_4 = null, p_5 = null, p_6 = null, raiosuperficievalor = null;
    Double p1 = (double) 0, p4 = (double) 0, p5 = (double) 0, p6 = (double) 0, raio = (double) 0;
    String processx = null;
    RadioGroup radiofinitude, radiocomponenteds;
    String componenteds = null, componentenormal = null, componentenormal2 = null;
    ProgressBar progress;

    android.widget.Button calcular;
    ImageButton fxCalculator;
    LinearLayout fxCalculatorLayout, raiosuperficie;
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
        setContentView(R.layout.activity_ce_potencialeletrico_superficie);


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

        CheckBoxComponente();


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
        p_4 = findViewById(R.id.p_4);
        p_5 = findViewById(R.id.p_5);
        p_6 = findViewById(R.id.p_6);
        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        radiofinitude = findViewById(R.id.radiofinitude);
        radiocomponenteds = findViewById(R.id.radiocomponenteds);
        raiosuperficie = findViewById(R.id.raiosuperficie);
        raiosuperficievalor = findViewById(R.id.raio);
        progress = findViewById(R.id.progress);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "CePotencialeletricoSuperficie.class";
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

    /**
     * Checando valor escolhido em Radio Button*/
    @SuppressLint("NonConstantResourceId")
    private void CheckBoxComponente(){
        radiocomponenteds.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i){
                case R.id.radiocomponentedydz:
                    componenteds = "dydz";
                    p_1.setHint("x");
                    Pontadacarga();
                    break;

                case R.id.radiocomponentedxdz:
                    componenteds = "dxdz";
                    p_1.setHint("y");
                    Pontadacarga();
                    break;

                case R.id.radiocomponentedxdy:
                    componenteds = "dxdy";
                    p_1.setHint("z");
                    Pontadacarga();
                    break;
            }
        });
    }

    private void Pontadacarga(){

        if (componenteds.equals("dydz")){
            p_4.setHint("");p_4.setEnabled(true);
            p_5.setHint("0");p_5.setEnabled(false);p_5.setText("");
            p_6.setHint("0");p_6.setEnabled(false);p_6.setText("");
            CalcularFinito();
        }
        if (componenteds.equals("dxdz")){
            p_4.setHint("0");p_4.setText("");p_4.setEnabled(false);
            p_5.setHint("");p_5.setEnabled(true);
            p_6.setHint("0");p_6.setText("");p_6.setEnabled(false);
            CalcularFinito();
        }
        if (componenteds.equals("dxdy")){
            p_4.setHint("0");p_4.setEnabled(false);p_4.setText("");
            p_5.setHint("0");p_5.setEnabled(false);p_5.setText("");
            p_6.setHint("");p_6.setEnabled(true);
            CalcularFinito();

        }
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
    private void CalcularFinito(){

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

                    /**Inserindo variaveis locais*/
                    Double Rs = null;
                    String Resultado = null;
                    String h = null;

                    raio = Double.parseDouble(raiosuperficievalor.getText().toString());

                    if (componenteds.equals("dydz")){

                        /**Repassando o valor das variaveis da caixa de texto para as
                         * variaveis do programa*/

                        p1 = Double.parseDouble(p_1.getText().toString());
                        p4 = Double.parseDouble(p_4.getText().toString());
                        p5 = Double.parseDouble(String.valueOf(0));
                        p6 = Double.parseDouble(String.valueOf(0));

                        Rs  = p4 - p1;

                        h = "h é na direção do eixo x. Sendo " +
                                "<br> .. h = Xc - Xs" +
                                "<br> .. h = ("+df2.format(p4)+")-("+df2.format(p1)+")" +
                                "<br> .. h = "+df2.format(Rs);

                        double fracao = Math.sqrt(Math.pow(Rs,2)+Math.pow(raio,2)) - Rs;

                        /**
                         * Expression é o avaliador de expressão, que retorna o valor da função f(x,y,z) para um
                         * ponto que definimos (x,y,z).*/

                        Expression ex = new ExpressionBuilder("("+processx+")*(18*π*10^9)*("+fracao+")")
                                .variables("x")
                                .build()
                                .setVariable("x",1);
                        double Eresult = ex.evaluate();


                        if (Rs >= 0){

                            componentenormal2 = "<b>âx</b>";
                            componentenormal = "<b>âx</b>";

                            Resultado = df3.format(Eresult) + " <b>âx</b>";


                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                Resultado = df3.format(Eresult) + "*10<sup>4</sup>" + " <b>âx</b>";
                            }

                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                Resultado = df3.format(Eresult) + "*10<sup>5</sup>" + " <b>âx</b>";
                            }

                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                Resultado = df3.format(Eresult) + "*10<sup>6</sup>" + " <b>âx</b>";
                            }


                        }
                        if (Rs < 0){

                            componentenormal2 = "(-<b>âx</b>)";
                            componentenormal = "(-<b>âx</b>)" +
                                    "<br>" +
                                    "<br> A componente normal do campo elétrico possui o sinal negativo devido" +
                                    " a posição da carga ser situada abaixo da superfície de carga.";

                            Resultado = df3.format(Eresult) + "(-<b>âx</b>)";


                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                Resultado = df3.format(Eresult) + "*10<sup>4</sup>" + "(-<b>âx</b>)";
                            }

                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                Resultado = df3.format(Eresult) + "*10<sup>5</sup>" + "(-<b>âx</b>)";
                            }

                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                Resultado = df3.format(Eresult) + "*10<sup>6</sup>" + "(-<b>âx</b>)";
                            }

                        }

                    }
                    if (componenteds.equals("dxdz")){

                        p1 = Double.parseDouble(p_1.getText().toString());
                        p4 = Double.parseDouble(String.valueOf(0));
                        p5 = Double.parseDouble(p_5.getText().toString());
                        p6 = Double.parseDouble(String.valueOf(0));

                        Rs  = p5 - p1;

                        h = "h é na direção do eixo y. Sendo " +
                                "<br> .. h = Yc - Ys" +
                                "<br> .. h = ("+df2.format(p5)+")-("+df2.format(p1)+")" +
                                "<br> .. h = "+df2.format(Rs);

                        double fracao = Math.sqrt(Math.pow(Rs,2)+Math.pow(raio,2)) - Rs;

                        Expression ex = new ExpressionBuilder("("+processx+")*(18*π*10^9)*("+fracao+")")
                                .variables("x")
                                .build()
                                .setVariable("x",1);
                        double Eresult = ex.evaluate();


                        if (Rs >= 0){

                            componentenormal = "<b>ây</b>";
                            componentenormal2 = "<b>ây</b>";

                            Resultado = df3.format(Eresult) + " <b>ây</b>";


                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                Resultado = df3.format(Eresult) + "*10<sup>4</sup>" + " <b>ây</b>";
                            }

                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                Resultado = df3.format(Eresult) + "*10<sup>5</sup>" + " <b>ây</b>";
                            }

                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                Resultado = df3.format(Eresult) + "*10<sup>6</sup>" + " <b>ây</b>";
                            }

                        }
                        if (Rs < 0){

                            componentenormal2 = "(-<b>ây</b>)";
                            componentenormal = "(-<b>ây</b>)" +
                                    "<br>" +
                                    "<br> A componente normal do campo elétrico possui o sinal negativo devido" +
                                    " a posição da carga ser situada abaixo da superfície de carga.";

                            Resultado = df3.format(Eresult) + "(-<b>ây</b>)";


                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                Resultado = df3.format(Eresult) + "*10<sup>4</sup>" + "(-<b>ây</b>)";
                            }

                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                Resultado = df3.format(Eresult) + "*10<sup>5</sup>" + "(-<b>ây</b>)";
                            }

                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                Resultado = df3.format(Eresult) + "*10<sup>6</sup>" + "(-<b>ây</b>)";
                            }

                        }
                    }
                    if (componenteds.equals("dxdy")){

                        p1 = Double.parseDouble(p_1.getText().toString());
                        p4 = Double.parseDouble(String.valueOf(0));
                        p5 = Double.parseDouble(String.valueOf(0));
                        p6 = Double.parseDouble(p_6.getText().toString());

                        Rs  = p6 - p1;

                        h = "h é na direção do eixo z. Sendo " +
                                "<br> .. h = Zc - Zs" +
                                "<br> .. h = ("+df2.format(p6)+")-("+df2.format(p1)+")" +
                                "<br> .. h = "+df2.format(Rs);

                        double fracao = Math.sqrt(Math.pow(Rs,2)+Math.pow(raio,2)) - Rs;

                        Expression ex = new ExpressionBuilder("("+processx+")*(18*π*10^9)*("+fracao+")")
                                .variables("x")
                                .build()
                                .setVariable("x",1);
                        double Eresult = ex.evaluate();


                        if (Rs >= 0){

                            componentenormal = "<b>âz</b>";
                            componentenormal2 = "<b>âz</b>";

                            Resultado = df3.format(Eresult) + " <b>âz</b>";

                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                Resultado = df3.format(Eresult) + "*10<sup>4</sup>" + " <b>âz</b>";
                            }

                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                Resultado = df3.format(Eresult) + "*10<sup>5</sup>" + " <b>âz</b>";
                            }

                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                Resultado = df3.format(Eresult) + "*10<sup>6</sup>" + " <b>âz</b>";
                            }

                        }
                        if (Rs < 0){

                            componentenormal2= "(-<b>âz</b>)";
                            componentenormal = "(-<b>âz</b>)" +
                                    "<br>" +
                                    "<br> A componente normal do campo elétrico possui o sinal negativo devido" +
                                    " a posição da carga ser situada abaixo da superfície de carga.";

                            Resultado = df3.format(Eresult) + "(-<b>âz</b>)";


                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                Resultado = df3.format(Eresult) + "*10<sup>4</sup>" + "(-<b>âz</b>)";
                            }

                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                Resultado = df3.format(Eresult) + "*10<sup>5</sup>" + "(-<b>âz</b>)";
                            }

                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                Resultado = df3.format(Eresult) + "*10<sup>6</sup>" + "(-<b>âz</b>)";
                            }


                        }
                    }



                    info.setText(Html.fromHtml("<b>Ve</b> = "+Resultado+" V"));

                    infoM.setText(Html.fromHtml("Está é a solução para uma superfície finita no formato de um disco com a carga centralizada no eixo normal a superfície." +
                            "<br>" +
                            "<br>" +
                            "<br><b>Ve</b> = [1/(2*εo)]*ᵨs*{[ √(h<sup>2</sup> + r<sup>2</sup>) - h ]}ân" +
                            "<br>" +
                            "<br> .. 1/(2*εo) = 18π*10<sup>9</sup> N.m<sup>2</sup>/C<sup>2</sup>" +
                            "<br>" +
                            "<br> .. ᵨs = "+processx+" C/m<sup>2</sup>" +
                            "<br>" +
                            "<br> .. r é o valor do raio da superfície de carga." +
                            "<br> .. r = "+raiosuperficievalor.getText().toString()+" m" +
                            "<br>" +
                            "<br>" +
                            "<br> .. Se dS = "+componenteds+" , Então : " +
                            "<br>" +
                            "<br> .. ân é o vetor unitário na direção normal a superfície de carga. "+
                            "<br> .. ân = " +componentenormal+
                            "<br>" +
                            "<br> .. "+h+ " m"+
                            "<br>" +
                            "<br>" +
                            "<br><b>Ve</b> = 18π*10^9*"+processx+"*{ [ √("+df2.format(Math.pow(Rs,2))+" + "+df2.format(Math.pow(raio,2))+") - "+df2.format(Rs)+" ] }"+componentenormal2+
                            "<br>" +
                            "<br>" +
                            "<br><b>Ve</b>= 18π*10^9*"+processx+"*{ ["+df3.format(Math.sqrt(Math.pow(Rs,2)+Math.pow(raio,2)))+"] - "+df2.format(Rs)+" }" +componentenormal2+
                            "<br>" +
                            "<br><b>Ve</b> = "+Resultado+" V"));


                    Passos();

                }
                catch (Exception e) {

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