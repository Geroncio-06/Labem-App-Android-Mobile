package com.geroncio.labem.Campos_magneticos;

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

public class CmSolenoide extends AppCompatActivity {

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btnxn, btnpi;
    TextView txtimputx, info, infoM;
    EditText p_1 = null,  raio = null, p_4 = null, p_5 = null, p_6 = null, numeroEspira = null, comprimento = null;
    Double p1 = (double) 0, raioD = (double) 0,  p4 = null, p5 = null, p6 = null, num = null, compr = null;
    String processx = null;
    RadioGroup radiofinitude, radiocomponentedl;
    String componentedl = null, componentedlvirtual = null;
    ProgressBar progress;
    android.widget.Button calcular;
    ImageButton fxCalculator;
    LinearLayout fxCalculatorLayout, anglayout;
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
    double resultxPV = 0, resultyPV = 0, resultzPV = 0;
    double compax = 0, compay = 0, compaz = 0;
    double teta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_solenoide);

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
        raio = findViewById(R.id.raio);
        numeroEspira = findViewById(R.id.numerodeespiras);
        comprimento = findViewById(R.id.comprimento);



        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        radiofinitude = findViewById(R.id.radiofinitude);
        radiocomponentedl = findViewById(R.id.radiocomponentedl);
        anglayout = findViewById(R.id.anglayout);
        progress = findViewById(R.id.progress);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "CmSolenoide.class";
            i.putExtra("STRING_ACTIVITY", main);
            startActivity(i);
        });

        voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Camposmagneticos.class));
            finish();
        });

    }

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

    @SuppressLint("NonConstantResourceId")
    private void CheckBoxComponente(){
        radiocomponentedl.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i){
                case R.id.radiocomponentedx:
                    componentedl = "dx";
                    Pontodalinha();
                    break;

                case R.id.radiocomponentedy:
                    componentedl = "dy";
                    Pontodalinha();
                    break;

                case R.id.radiocomponentedz:
                    componentedl = "dz";
                    Pontodalinha();
                    break;
            }
        });
    }

    private void Pontodalinha(){
        if (componentedl.equals("dx")){
            p_1.setHint("x");
            p_4.setHint("");p_4.setEnabled(true);
            p_5.setHint("0");p_5.setEnabled(false);p_5.setText("");
            p_6.setHint("0");p_6.setEnabled(false);p_6.setText("");
            CalcularFinito();
        }
        if (componentedl.equals("dy")){
            p_1.setHint("y");
            p_5.setHint("");p_5.setEnabled(true);
            p_4.setHint("0");p_4.setEnabled(false);p_4.setText("");
            p_6.setHint("0");p_6.setEnabled(false);p_6.setText("");
            CalcularFinito();
        }
        if (componentedl.equals("dz")){
            p_1.setHint("z");
            p_5.setHint("0");p_5.setEnabled(false);p_5.setText("");
            p_4.setHint("0");p_4.setEnabled(false);p_4.setText("");
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

    @SuppressLint("SetTextI18n")
    private void CalcularFinito(){

        calcular.setOnClickListener(view -> {

            progress.setVisibility(View.VISIBLE);
            info.setText("");

            new Handler().postDelayed(() -> {

                try {

                    if (componentedl == null ){


                        info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                        info.setTextColor(getResources().getColor(R.color.black));

                        passos.setImageResource(R.drawable.ic_eye_lightblack);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                        layoutParams.height = 0;
                        layoutpassos.setLayoutParams(layoutParams);

                    }
                    else{
                        if (componentedl.equals("dx")){

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p4 = Double.parseDouble(p_4.getText().toString());
                            p5 = 0.0;
                            p6 = 0.0;
                            num = Double.parseDouble(numeroEspira.getText().toString());
                            raioD = Double.parseDouble(raio.getText().toString());
                            compr = Double.parseDouble(comprimento.getText().toString());



                            Double h = p4 - p1;
                            Double costeta2 = (compr-h)/Math.pow((Math.pow(raioD,2)+Math.pow((compr-h),2)),0.5);
                            Double costeta1 = (-h)/Math.pow((Math.pow(raioD,2)+Math.pow(h,2)),0.5);


                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eprocess = processs.evaluate();




                            Expression ex = new ExpressionBuilder("("+Eprocess+")*("+num*(costeta2-costeta1)+")/(2*"+compr+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();


                            String eresult = df3.format(Eresult);



                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }




                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }


                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }



                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }




                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }




                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }




                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }




                            info.setText(Html.fromHtml("<b>H</b> = "+eresult+"<b>âx</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [N*I/2*L]*[cos(Ɵ2) - cos(Ɵ1)] <b>âx</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. dl = "+componentedl+" " +
                                    "<br>" +
                                    "<br> .. I = " +df.format(Eprocess)+" A"+
                                    "<br> " +
                                    "<br> .. L é o comprimento do solenóide"+
                                    "<br> .. N é o número de espiras do solenóide"+
                                    "<br> .. r é o raio da espira"+
                                    "<br> " +
                                    "<br> .. h é a diferença de comprimento do ponto de cálculo até a posição do solenóide.  "+
                                    "<br>"+
                                    "<br>" +
                                    "<br> .. L  = "+df.format(compr)+" m"+
                                    "<br>"+
                                    "<br> .. r  = "+df.format(raioD)+" m"+
                                    "<br>"+
                                    "<br> .. h  = Xc - Xs = "+df.format(h)+" m"+
                                    "<br> .. Xc (pos. no eixo x do ponto de cálculo)" +
                                    "<br> .. Xs (pos. do solenóide)"+
                                    "<br>"+
                                    "<br> .. N  = "+num+
                                    "<br>"+
                                    "<br>" +
                                    "<br> .. cos(Ɵ2) = (L-h)/[r^2 + (L-h)^2]^(0.5)"+
                                    "<br> .. cos(Ɵ2) = "+df.format(costeta2)+
                                    "<br>" +
                                    "<br> .. cos(Ɵ1) = (-h)/[r^2 + (h)^2]^(0.5)"+
                                    "<br> .. cos(Ɵ1) = "+df.format(costeta1)+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"<b>âx</b> A/m" ));



                            Passos();
                        }
                        if (componentedl.equals("dy")){

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p4 = 0.0;
                            p5 = Double.parseDouble(p_5.getText().toString());
                            p6 = 0.0;
                            num = Double.parseDouble(numeroEspira.getText().toString());
                            raioD = Double.parseDouble(raio.getText().toString());
                            compr = Double.parseDouble(comprimento.getText().toString());


                            Double h = p5 - p1;
                            Double costeta2 = (compr-h)/Math.pow((Math.pow(raioD,2)+Math.pow((compr-h),2)),0.5);
                            Double costeta1 = (-h)/Math.pow((Math.pow(raioD,2)+Math.pow(h,2)),0.5);


                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eprocess = processs.evaluate();




                            Expression ex = new ExpressionBuilder("("+Eprocess+")*("+num*(costeta2-costeta1)+")/(2*"+compr+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();



                            String eresult = df3.format(Eresult);



                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }



                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }

                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }


                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }



                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }


                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }



                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }


                            info.setText(Html.fromHtml("<b>H</b> = "+eresult+"<b>ây</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [N*I/2*L]*[cos(Ɵ2) - cos(Ɵ1)] <b>ây</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. dl = "+componentedl+" " +
                                    "<br>" +
                                    "<br> .. I = " +df.format(Eprocess)+" A"+
                                    "<br> " +
                                    "<br> .. L é o comprimento do solenóide"+
                                    "<br> .. N é o número de espiras do solenóide"+
                                    "<br> .. r é o raio da espira"+
                                    "<br> " +
                                    "<br> .. h é a diferença de comprimento do ponto de cálculo até a posição do solenóide.  "+
                                    "<br>"+
                                    "<br>" +
                                    "<br> .. L  = "+df.format(compr)+" m"+
                                    "<br>"+
                                    "<br> .. r  = "+df.format(raioD)+" m"+
                                    "<br>"+
                                    "<br> .. h  = Yc - Ys = "+df.format(h)+" m"+
                                    "<br> .. Yc (pos. no eixo y do ponto de cálculo)" +
                                    "<br> .. Ys (pos. do solenóide)"+
                                    "<br>"+
                                    "<br> .. N  = "+num+
                                    "<br>"+
                                    "<br>" +
                                    "<br> .. cos(Ɵ2) = (L-h)/[r^2 + (L-h)^2]^(0.5)"+
                                    "<br> .. cos(Ɵ2) = "+df.format(costeta2)+
                                    "<br>" +
                                    "<br> .. cos(Ɵ1) = (-h)/[r^2 + (h)^2]^(0.5)"+
                                    "<br> .. cos(Ɵ1) = "+df.format(costeta1)+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"<b>ây</b> A/m" ));

                            Passos();
                        }
                        if (componentedl.equals("dz")){

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p4 = 0.0;
                            p5 = 0.0;
                            p6 = Double.parseDouble(p_6.getText().toString());
                            num = Double.parseDouble(numeroEspira.getText().toString());
                            raioD = Double.parseDouble(raio.getText().toString());
                            compr = Double.parseDouble(comprimento.getText().toString());



                            Double h = p6 - p1;
                            Double costeta2 = (compr-h)/Math.pow((Math.pow(raioD,2)+Math.pow((compr-h),2)),0.5);
                            Double costeta1 = (-h)/Math.pow((Math.pow(raioD,2)+Math.pow(h,2)),0.5);


                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eprocess = processs.evaluate();




                            Expression ex = new ExpressionBuilder("("+Eprocess+")*("+num*(costeta2-costeta1)+")/(2*"+compr+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();



                            String eresult = df3.format(Eresult);


                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }



                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }


                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }



                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }



                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }




                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }



                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }




                            info.setText(Html.fromHtml("<b>H</b> = "+eresult+"<b>âz</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [N*I/2*L]*[cos(Ɵ2) - cos(Ɵ1)] <b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. dl = "+componentedl+" " +
                                    "<br>" +
                                    "<br> .. I = " +df.format(Eprocess)+" A"+
                                    "<br> " +
                                    "<br> .. L é o comprimento do solenóide"+
                                    "<br> .. N é o número de espiras do solenóide"+
                                    "<br> .. r é o raio da espira"+
                                    "<br> " +
                                    "<br> .. h é a diferença de comprimento do ponto de cálculo até a posição do solenóide.  "+
                                    "<br>"+
                                    "<br>" +
                                    "<br> .. L  = "+df.format(compr)+" m"+
                                    "<br>"+
                                    "<br> .. r  = "+df.format(raioD)+" m"+
                                    "<br>"+
                                    "<br> .. h  = Zc - Zs = "+df.format(h)+" m"+
                                    "<br> .. Zc (pos. no eixo z do ponto de cálculo)" +
                                    "<br> .. Zs (pos. do solenóide)"+
                                    "<br>"+
                                    "<br> .. N  = "+num+
                                    "<br>"+
                                    "<br>" +
                                    "<br> .. cos(Ɵ2) = (L-h)/[r^2 + (L-h)^2]^(0.5)"+
                                    "<br> .. cos(Ɵ2) = "+df.format(costeta2)+
                                    "<br>" +
                                    "<br> .. cos(Ɵ1) = (-h)/[r^2 + (h)^2]^(0.5)"+
                                    "<br> .. cos(Ɵ1) = "+df.format(costeta1)+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"<b>âz</b> A/m" ));

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


    protected void Passos(){


        if (counter == 1){
            //passos visivel
            passos.setOnClickListener(view -> {
                passos.setImageResource(R.drawable.ic_eye_purple);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                layoutParams.height = 1500;
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

    @Override
    protected void onResume(){
        super.onResume();

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