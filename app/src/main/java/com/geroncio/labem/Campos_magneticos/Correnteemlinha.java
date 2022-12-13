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

import com.geroncio.labem.Campos_eletrostaticos.Camposeletrostaticos;
import com.geroncio.labem.Others.Info;
import com.geroncio.labem.R;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class Correnteemlinha extends AppCompatActivity {

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btnxn,btnpi;
    TextView txtimputx, info, infoM;
    EditText p_1 = null, p_2 = null, p_4 = null, p_5 = null, p_6 = null, p_7 = null, p_8 = null;
    Double p1 = (double) 0, p2 = (double) 0, p3 = null, p4 = null, p5 = null, p6 = null, p7 = null, p8 = null;
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
        setContentView(R.layout.activity_correnteemlinha);

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

        CheckBox();
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
        p_2 = findViewById(R.id.p_2);
        p_4 = findViewById(R.id.p_4);
        p_5 = findViewById(R.id.p_5);
        p_6 = findViewById(R.id.p_6);
        p_7 = findViewById(R.id.p_7);
        p_8 = findViewById(R.id.p_8);
        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        radiofinitude = findViewById(R.id.radiofinitude);
        radiocomponentedl = findViewById(R.id.radiocomponentedl);
        anglayout = findViewById(R.id.anglayout);
        progress = findViewById(R.id.progress);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "Correnteemlinha.class";
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


        btnpi = findViewById(R.id.gc_04);

        btnxn = findViewById(R.id.gc_10);
        btnbackspace = findViewById(R.id.gc_05);


    }

    @SuppressLint("NonConstantResourceId")
    private void CheckBox(){
        radiofinitude.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i){
                case R.id.radiofinitude1:
                    CalcularFinito();
                    params = (LinearLayout.LayoutParams) anglayout.getLayoutParams();
                    params.height = 150;
                    anglayout.setLayoutParams(params);
                    p_7.setHint("α1");p_8.setHint("α2");
                    break;

                case R.id.radiofinitude2:
                    CalcularInfinito();
                    params = (LinearLayout.LayoutParams) anglayout.getLayoutParams();
                    params.height = 0;
                    anglayout.setLayoutParams(params);
                    break;
            }
        });
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
            p_1.setHint("y");p_2.setHint("z");

        }
        if (componentedl.equals("dy")){
            p_1.setHint("x");p_2.setHint("z");

        }
        if (componentedl.equals("dz")){
            p_1.setHint("x");p_2.setHint("y");

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

                    info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                    info.setTextColor(getResources().getColor(R.color.black));

                    if (componentedl == null || p_7.getText().toString().isEmpty() || p_8.getText().toString().isEmpty()){


                        info.setText(R.string.erro);
                        passos.setImageResource(R.drawable.ic_eye_lightblack);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                        layoutParams.height = 0;
                        layoutpassos.setLayoutParams(layoutParams);

                    }
                    else{
                        if (componentedl.equals("dx")){



                            p1 = Double.parseDouble(p_1.getText().toString());
                            p2 = Double.parseDouble(p_2.getText().toString());
                            p4 = Double.parseDouble(p_4.getText().toString());
                            p5 = Double.parseDouble(p_5.getText().toString());
                            p6 = Double.parseDouble(p_6.getText().toString());
                            p7 = Double.parseDouble(p_7.getText().toString());
                            p8 = Double.parseDouble(p_8.getText().toString());

                            Double Ry = p5 - p1;
                            Double Rz = p6 - p2;

                            Double norma = Math.sqrt(Math.pow(Ry, 2)+Math.pow(Rz,2));
                            Double mathcomponentedl = (Math.cos(p8) - Math.cos(p7));


                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eprocess = processs.evaluate();



                            if (Eprocess >= 0){
                                resultxPV = ( 0 * (Rz/norma)) - (0 * (Ry/norma));
                                resultyPV = (0 * p4) - (1*(Rz/norma));
                                resultzPV = (1 * (Ry/norma)) - (p4 * 0);
                                componentedlvirtual = "<b>âx</b>";
                            }
                            else{
                                resultxPV = ( 0 * (Rz/norma)) - (0 * (Ry/norma));
                                resultyPV = (0 * p4) - ((-1)*(Rz/norma));
                                resultzPV = ((-1) * (Ry/norma)) - (p4 * 0);
                                componentedlvirtual = "-<b>âx</b>";
                            }

                            Eprocess = Math.abs(Eprocess);


                            Expression ex = new ExpressionBuilder("("+Eprocess+")*("+mathcomponentedl+")/(4*"+Math.PI+"*"+norma+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();

                            Expression ey = new ExpressionBuilder("("+resultyPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinaly = ey.evaluate();

                            Expression ez = new ExpressionBuilder("("+resultzPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinalz = ez.evaluate();

                            String eresult = df3.format(Eresult);
                            String eresulty = df3.format(Eresultfinaly);
                            String eresultz = df3.format(Eresultfinalz);


                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.01 && Math.abs(Eresultfinaly) > 0.001){
                                Eresultfinaly= Eresultfinaly*1000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.01 && Math.abs(Eresultfinalz) > 0.001){
                                Eresultfinalz= Eresultfinalz*1000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-3</sup>";
                            }



                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.001 && Math.abs(Eresultfinaly) > 0.0001){
                                Eresultfinaly= Eresultfinaly*10000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.001 && Math.abs(Eresultfinalz) > 0.0001){
                                Eresultfinalz= Eresultfinalz*10000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-4</sup>";
                            }

                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.0001 && Math.abs(Eresultfinaly) > 0.00001){
                                Eresultfinaly= Eresultfinaly*100000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.0001 && Math.abs(Eresultfinalz) > 0.00001){
                                Eresultfinalz= Eresultfinalz*100000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-5</sup>";
                            }


                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.00001 && Math.abs(Eresultfinaly) > 0.000001){
                                Eresultfinaly= Eresultfinaly*1000000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.00001 && Math.abs(Eresultfinalz) > 0.000001){
                                Eresultfinalz= Eresultfinalz*1000000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-6</sup>";
                            }



                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 100000 && Math.abs(Eresultfinaly) > 10000){
                                Eresultfinaly= Eresultfinaly/10000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 100000 && Math.abs(Eresultfinalz) > 10000){
                                Eresultfinalz= Eresultfinalz/10000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>4</sup>";
                            }



                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 1000000 && Math.abs(Eresultfinaly) > 100000){
                                Eresultfinaly= Eresultfinaly/100000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 1000000 && Math.abs(Eresultfinalz) > 100000){
                                Eresultfinalz= Eresultfinalz/100000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>5</sup>";
                            }



                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinaly) > 1000000){
                                Eresultfinaly= Eresultfinaly/1000000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinalz) > 1000000){
                                Eresultfinalz= Eresultfinalz/1000000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>6</sup>";
                            }



                            info.setText(Html.fromHtml("<b>H</b> = "+eresulty+"<b>ây</b> + "+eresultz+"<b>âz</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [I/(4π*r)]*[cos(α2) - cos(α1)]<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. Se dl = "+componentedl+" , Então : " +
                                    "<br>" +
                                    "<br> I = " +Eprocess+" A"+
                                    "<br> Valores de corrente negativo são intendidos como uma corrente que anda no sentido contrario da linha, exemplo: -<b>âx</b>,-<b>ây</b> -<b>âz</b> . " +
                                    "<br>"+
                                    "<br> .. <b>R</b> = (Yp-Yl)<b>ây</b> + (Zp-Zl)<b>âz</b>" +
                                    "<br> .. r = |<b>R</b>| = √((Yp-Yl)^2 + (Zp-Zl)^2)" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>Obs: <b>R</b> e r, são o vetor e a distância, respectiva-" +
                                    "<br> mente, perpendicular do ponto de cálculo " +
                                    "<br> (x,y,z) a linha L (x',y',z')." +
                                    "<br>" +
                                    "<br> <b>H</b> está sempre ao longo do vetor unitário <b>âᵩ</b>, isto é ao longo de trajetórias circulares concêntricas. " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>R</b> = ("+p_5.getText().toString()+"-"+p_1.getText().toString()+")<b>ây</b> + ("+p_6.getText().toString()+"-"+p_2.getText().toString()+")<b>âz</b> " +
                                    "<br>" +
                                    "<br> .. <b>R</b> = "+String.valueOf(df2.format(Ry)).replace(",",".").replace(",",".")+"<b>ây</b> + "+String.valueOf(df2.format(Rz)).replace(",",".")+"<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. r = √[("+String.valueOf(df2.format(Ry)).replace(",",".")+")^2 + ("+String.valueOf(df2.format(Rz)).replace(",",".")+")^2]" +
                                    "<br> .. r = √("+ df2.format(Math.pow(norma, 2)).replace(",",".")+")" +
                                    "<br> .. r = "+ df2.format(norma).replace(",",".")+
                                    "<br>" +
                                    "<br>"+
                                    "<br><b>H</b> = "+eresult+"*<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>"+
                                    "<br> .. <b>âᵩ</b> = " +componentedlvirtual+" x (<b>R</b>/r)"+
                                    "<br> .. <b>âᵩ</b> = "+componentedlvirtual+" x ("+df.format(Ry/norma)+"<b>ây</b> + "+df.format(Rz/norma)+"<b>âz</b>)"+
                                    "<br> .. <b>âᵩ</b> = " +df.format(resultyPV)+"<b>ây</b> + "+df.format(resultzPV)+"<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"*("+df.format(resultyPV).replace("+-","-")+"<b>ây</b> + "+df.format(resultzPV).replace("+-","-")+"<b>âz</b>)" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresulty+"<b>ây</b> + "+eresultz+"<b>âz</b> A/m"));



                            Passos();
                        }
                        if (componentedl.equals("dy")){


                            p1 = Double.parseDouble(p_1.getText().toString());
                            p2 = Double.parseDouble(p_2.getText().toString());
                            p4 = Double.parseDouble(p_4.getText().toString());
                            p5 = Double.parseDouble(p_5.getText().toString());
                            p6 = Double.parseDouble(p_6.getText().toString());
                            p7 = Double.parseDouble(p_7.getText().toString());
                            p8 = Double.parseDouble(p_8.getText().toString());

                            Double Rx = p4 - p1;
                            Double Rz = p6 - p2;

                            Double norma = Math.sqrt(Math.pow(Rx, 2)+Math.pow(Rz,2));
                            Double mathcomponentedl = (Math.cos(p8) - Math.cos(p7));

                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eprocess = processs.evaluate();


                            if (Eprocess >= 0){
                                resultxPV = ( 1 * (Rz/norma)) - (0 * p5);
                                resultyPV = (0 * (Rx/norma)) - (0*(Rz/norma));
                                resultzPV = (0 * p5) - ((Rx/norma) * 1);
                                componentedlvirtual = "<b>ây</b>";
                            }
                            else{
                                resultxPV = ( (-1) * (Rz/norma)) - (0 * p5);
                                resultyPV = (0 * (Rx/norma)) - (0*(Rz/norma));
                                resultzPV = (0 * p5) - ((Rx/norma) * (-1));
                                componentedlvirtual = "-<b>ây</b>";
                            }

                            Eprocess = Math.abs(Eprocess);


                            Expression ex = new ExpressionBuilder("("+Eprocess+")*("+mathcomponentedl+")/(4*"+Math.PI+"*"+norma+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();

                            Expression ey = new ExpressionBuilder("("+resultxPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinalx = ey.evaluate();

                            Expression ez = new ExpressionBuilder("("+resultzPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinalz = ez.evaluate();

                            String eresult = df3.format(Eresult);
                            String eresultx = df3.format(Eresultfinalx);
                            String eresultz = df3.format(Eresultfinalz);


                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.01 && Math.abs(Eresultfinalx) > 0.001){
                                Eresultfinalx= Eresultfinalx*1000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.01 && Math.abs(Eresultfinalz) > 0.001){
                                Eresultfinalz= Eresultfinalz*1000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-3</sup>";
                            }



                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.001 && Math.abs(Eresultfinalx) > 0.0001){
                                Eresultfinalx= Eresultfinalx*10000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.001 && Math.abs(Eresultfinalz) > 0.0001){
                                Eresultfinalz= Eresultfinalz*10000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-4</sup>";
                            }

                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.0001 && Math.abs(Eresultfinalx) > 0.00001){
                                Eresultfinalx= Eresultfinalx*100000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.0001 && Math.abs(Eresultfinalz) > 0.00001){
                                Eresultfinalz= Eresultfinalz*100000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-5</sup>";
                            }


                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.00001 && Math.abs(Eresultfinalx) > 0.000001){
                                Eresultfinalx= Eresultfinalx*1000000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.00001 && Math.abs(Eresultfinalz) > 0.000001){
                                Eresultfinalz= Eresultfinalz*1000000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-6</sup>";
                            }



                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 100000 && Math.abs(Eresultfinalx) > 10000){
                                Eresultfinalx= Eresultfinalx/10000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 100000 && Math.abs(Eresultfinalz) > 10000){
                                Eresultfinalz= Eresultfinalz/10000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>4</sup>";
                            }



                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 1000000 && Math.abs(Eresultfinalx) > 100000){
                                Eresultfinalx= Eresultfinalx/100000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 1000000 && Math.abs(Eresultfinalz) > 100000){
                                Eresultfinalz= Eresultfinalz/100000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>5</sup>";
                            }



                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinalx) > 1000000){
                                Eresultfinalx= Eresultfinalx/1000000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinalz) > 1000000){
                                Eresultfinalz= Eresultfinalz/1000000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>6</sup>";
                            }



                            info.setText(Html.fromHtml("<b>H</b> = "+eresultx+"<b>âx</b> + "+eresultz+"<b>âz</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [I/(4π*r)]*[cos(α2) - cos(α1)]<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. Se dl = "+componentedl+" , Então : " +
                                    "<br>" +
                                    "<br> I = " +df.format(Eprocess)+" A"+
                                    "<br> Valores de corrente negativo são intendidos como uma corrente que anda no sentido contrario da linha, exemplo: -<b>âx</b>,-<b>ây</b> -<b>âz</b> . " +
                                    "<br>"+
                                    "<br> .. <b>R</b> = (Xp-Xl)<b>âx</b> + (Zp-Zl)<b>âz</b>" +
                                    "<br> .. r = |<b>R</b>| = √((Xp-Xl)^2 + (Zp-Zl)^2)" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>Obs: <b>R</b> e r, são o vetor e a distância, respectiva-" +
                                    "<br> mente, perpendicular do ponto de cálculo " +
                                    "<br> (x,y,z) a linha L (x',y',z')." +
                                    "<br>" +
                                    "<br> <b>H</b> está sempre ao longo do vetor unitário <b>âᵩ</b>, isto é ao longo de trajetórias circulares concêntricas. " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>R</b> = ("+p_4.getText().toString()+"-"+p_1.getText().toString()+")<b>âx</b> + ("+p_6.getText().toString()+"-"+p_2.getText().toString()+")<b>âz</b> " +
                                    "<br>" +
                                    "<br> .. <b>R</b> = "+String.valueOf(df2.format(Rx)).replace(",",".").replace(",",".")+"<b>âx</b> + "+String.valueOf(df2.format(Rz)).replace(",",".")+"<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. r = √[("+String.valueOf(df2.format(Rx)).replace(",",".")+")^2 + ("+String.valueOf(df2.format(Rz)).replace(",",".")+")^2]" +
                                    "<br> .. r = √("+ df2.format(Math.pow(norma, 2)).replace(",",".")+")" +
                                    "<br> .. r = "+ df2.format(norma).replace(",",".")+
                                    "<br>" +
                                    "<br>"+
                                    "<br><b>H</b> = "+eresult+"*<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>"+
                                    "<br> .. <b>âᵩ</b> = " +componentedlvirtual+" x (<b>R</b>/r)"+
                                    "<br> .. <b>âᵩ</b> = "+componentedlvirtual+" x ("+df.format(Rx/norma)+"<b>âx</b> + "+df.format(Rz/norma)+"<b>âz</b>)"+
                                    "<br> .. <b>âᵩ</b> = " +df.format(resultxPV)+"<b>âx</b> + "+df.format(resultzPV)+"<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"*("+df.format(resultxPV).replace("+-","-")+"<b>âx</b> + "+df.format(resultzPV).replace("+-","-")+"<b>âz</b>)" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresultx+"<b>âx</b> + "+eresultz+"<b>âz</b> A/m"));

                            Passos();
                        }
                        if (componentedl.equals("dz")){

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p2 = Double.parseDouble(p_2.getText().toString());
                            p4 = Double.parseDouble(p_4.getText().toString());
                            p5 = Double.parseDouble(p_5.getText().toString());
                            p6 = Double.parseDouble(p_6.getText().toString());
                            p7 = Double.parseDouble(p_7.getText().toString());
                            p8 = Double.parseDouble(p_8.getText().toString());

                            Double Rx = p4 - p1;
                            Double Ry = p5 - p2;

                            Double norma = Math.sqrt(Math.pow(Rx, 2)+Math.pow(Ry,2));
                            Double mathcomponentedl = (Math.cos(p8) - Math.cos(p7));

                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eprocess = processs.evaluate();


                            if (Eprocess >= 0){
                                resultxPV = ( 0 * p6) - (1 * (Ry/norma));
                                resultyPV = (1 * (Rx/norma)) - (0*p6);
                                resultzPV = (0 * (Ry/norma)) - ((Rx/norma) * 0);
                                componentedlvirtual = "<b>âz</b>";
                            }
                            else{
                                resultxPV = ( 0 * p6) - ((-1) * (Ry/norma));
                                resultyPV = ((-1) * (Rx/norma)) - (0*p6);
                                resultzPV = (0 * (Ry/norma)) - ((Rx/norma) * 0);
                                componentedlvirtual = "-<b>âz</b>";
                            }

                            Eprocess = Math.abs(Eprocess);


                            Expression ex = new ExpressionBuilder("("+Eprocess+")*("+mathcomponentedl+")/(4*"+Math.PI+"*"+norma+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();

                            Expression ey = new ExpressionBuilder("("+resultxPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinalx = ey.evaluate();

                            Expression ez = new ExpressionBuilder("("+resultyPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinaly = ez.evaluate();

                            String eresult = df3.format(Eresult);
                            String eresultx = df3.format(Eresultfinalx);
                            String eresulty = df3.format(Eresultfinaly);


                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.01 && Math.abs(Eresultfinalx) > 0.001){
                                Eresultfinalx= Eresultfinalx*1000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.01 && Math.abs(Eresultfinaly) > 0.001){
                                Eresultfinaly= Eresultfinaly*1000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-3</sup>";
                            }



                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.001 && Math.abs(Eresultfinalx) > 0.0001){
                                Eresultfinalx= Eresultfinalx*10000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.001 && Math.abs(Eresultfinaly) > 0.0001){
                                Eresultfinaly= Eresultfinaly*10000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-4</sup>";
                            }

                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.0001 && Math.abs(Eresultfinalx) > 0.00001){
                                Eresultfinalx= Eresultfinalx*100000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.0001 && Math.abs(Eresultfinaly) > 0.00001){
                                Eresultfinaly= Eresultfinaly*100000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-5</sup>";
                            }


                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.00001 && Math.abs(Eresultfinalx) > 0.000001){
                                Eresultfinalx= Eresultfinalx*1000000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.00001 && Math.abs(Eresultfinaly) > 0.000001){
                                Eresultfinaly= Eresultfinaly*1000000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-6</sup>";
                            }


                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 100000 && Math.abs(Eresultfinaly) > 10000){
                                Eresultfinaly= Eresultfinaly/10000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 100000 && Math.abs(Eresultfinalx) > 10000){
                                Eresultfinalx= Eresultfinalx/10000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>4</sup>";
                            }



                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 1000000 && Math.abs(Eresultfinaly) > 100000){
                                Eresultfinaly= Eresultfinaly/100000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 1000000 && Math.abs(Eresultfinalx) > 100000){
                                Eresultfinalx= Eresultfinalx/100000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>5</sup>";
                            }



                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinaly) > 1000000){
                                Eresultfinaly= Eresultfinaly/1000000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinalx) > 1000000){
                                Eresultfinalx= Eresultfinalx/1000000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>6</sup>";
                            }



                            info.setText(Html.fromHtml("<b>H</b> = "+eresultx+"<b>âx</b> + "+eresulty+"<b>ây</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [I/(4π*r)]*[cos(α2) - cos(α1)]<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. Se dl = "+componentedl+" , Então : " +
                                    "<br>" +
                                    "<br> I = " +df.format(Eprocess)+" A"+
                                    "<br> Valores de corrente negativo são intendidos como uma corrente que anda no sentido contrario da linha, exemplo: -<b>âx</b>,-<b>ây</b> -<b>âz</b> . " +
                                    "<br>"+
                                    "<br> .. <b>R</b> = (Xp-Xl)<b>âx</b> + (Yp-Yl)<b>ây</b>" +
                                    "<br> .. r = |<b>R</b>| = √((Xp-Xl)^2 + (Yp-Yl)^2)" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>Obs: <b>R</b> e r, são o vetor e a distância, respectiva-" +
                                    "<br> mente, perpendicular do ponto de cálculo " +
                                    "<br> (x,y,z) a linha L (x',y',z')." +
                                    "<br>" +
                                    "<br> <b>H</b> está sempre ao longo do vetor unitário <b>âᵩ</b>, isto é ao longo de trajetórias circulares concêntricas. " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>R</b> = ("+p_4.getText().toString()+"-"+p_1.getText().toString()+")<b>âx</b> + ("+p_5.getText().toString()+"-"+p_2.getText().toString()+")<b>âY</b> " +
                                    "<br>" +
                                    "<br> .. <b>R</b> = "+String.valueOf(df2.format(Rx)).replace(",",".").replace(",",".")+"<b>âx</b> + "+String.valueOf(df2.format(Ry)).replace(",",".")+"<b>ây</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. r = √[("+String.valueOf(df2.format(Rx)).replace(",",".")+")^2 + ("+String.valueOf(df2.format(Ry)).replace(",",".")+")^2]" +
                                    "<br> .. r = √("+ df2.format(Math.pow(norma, 2)).replace(",",".")+")" +
                                    "<br> .. r = "+ df2.format(norma).replace(",",".")+
                                    "<br>" +
                                    "<br>"+
                                    "<br><b>H</b> = "+eresult+"*<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>"+
                                    "<br> .. <b>âᵩ</b> = " +componentedlvirtual+" x (<b>R</b>/r)"+
                                    "<br> .. <b>âᵩ</b> = "+componentedlvirtual+" x ("+df.format(Rx/norma)+"<b>âx</b> + "+df.format(Ry/norma)+"<b>ây</b>)"+
                                    "<br> .. <b>âᵩ</b> = " +df.format(resultxPV)+"<b>âx</b> + "+df.format(resultyPV)+"<b>ây</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"*("+df.format(resultxPV).replace("+-","-")+"<b>âx</b> + "+df.format(resultyPV).replace("+-","-")+"<b>ây</b>)" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresultx+"<b>âx</b> + "+eresulty+"<b>ây</b> A/m"));

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

    @SuppressLint("SetTextI18n")
    private void CalcularInfinito(){
        calcular.setOnClickListener(view -> {

            progress.setVisibility(View.VISIBLE);
            info.setText("");

            new Handler().postDelayed(() -> {

                try {


                    if (componentedl == null){


                        info.setText("Escolha uma direção para a componente dL");
                        passos.setImageResource(R.drawable.ic_eye_lightblack);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                        layoutParams.height = 0;
                        layoutpassos.setLayoutParams(layoutParams);
                    }
                    else{
                        if (componentedl.equals("dx")){

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p2 = Double.parseDouble(p_2.getText().toString());
                            p4 = Double.parseDouble(p_4.getText().toString());
                            p5 = Double.parseDouble(p_5.getText().toString());
                            p6 = Double.parseDouble(p_6.getText().toString());

                            Double Ry = p5 - p1;
                            Double Rz = p6 - p2;

                            Double norma = Math.sqrt(Math.pow(Ry, 2)+Math.pow(Rz,2));



                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eprocess = processs.evaluate();



                            if (Eprocess >= 0){
                                resultxPV = ( 0 * (Rz/norma)) - (0 * (Ry/norma));
                                resultyPV = (0 * p4) - (1*(Rz/norma));
                                resultzPV = (1 * (Ry/norma)) - (p4 * 0);
                                componentedlvirtual = "<b>âx</b>";
                            }
                            else{
                                resultxPV = ( 0 * (Rz/norma)) - (0 * (Ry/norma));
                                resultyPV = (0 * p4) - ((-1)*(Rz/norma));
                                resultzPV = ((-1) * (Ry/norma)) - (p4 * 0);
                                componentedlvirtual = "-<b>âx</b>";
                            }

                            Eprocess = Math.abs(Eprocess);


                            Expression ex = new ExpressionBuilder("("+Eprocess+")/(2*"+Math.PI+"*"+norma+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();

                            Expression ey = new ExpressionBuilder("("+resultyPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinaly = ey.evaluate();

                            Expression ez = new ExpressionBuilder("("+resultzPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinalz = ez.evaluate();

                            String eresult = df3.format(Eresult);
                            String eresulty = df3.format(Eresultfinaly);
                            String eresultz = df3.format(Eresultfinalz);


                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.01 && Math.abs(Eresultfinaly) > 0.001){
                                Eresultfinaly= Eresultfinaly*1000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.01 && Math.abs(Eresultfinalz) > 0.001){
                                Eresultfinalz= Eresultfinalz*1000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-3</sup>";
                            }



                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.001 && Math.abs(Eresultfinaly) > 0.0001){
                                Eresultfinaly= Eresultfinaly*10000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.001 && Math.abs(Eresultfinalz) > 0.0001){
                                Eresultfinalz= Eresultfinalz*10000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-4</sup>";
                            }

                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.0001 && Math.abs(Eresultfinaly) > 0.00001){
                                Eresultfinaly= Eresultfinaly*100000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.0001 && Math.abs(Eresultfinalz) > 0.00001){
                                Eresultfinalz= Eresultfinalz*100000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-5</sup>";
                            }


                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.00001 && Math.abs(Eresultfinaly) > 0.000001){
                                Eresultfinaly= Eresultfinaly*1000000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.00001 && Math.abs(Eresultfinalz) > 0.000001){
                                Eresultfinalz= Eresultfinalz*1000000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-6</sup>";
                            }



                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 100000 && Math.abs(Eresultfinaly) > 10000){
                                Eresultfinaly= Eresultfinaly/10000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 100000 && Math.abs(Eresultfinalz) > 10000){
                                Eresultfinalz= Eresultfinalz/10000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>4</sup>";
                            }



                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 1000000 && Math.abs(Eresultfinaly) > 100000){
                                Eresultfinaly= Eresultfinaly/100000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 1000000 && Math.abs(Eresultfinalz) > 100000){
                                Eresultfinalz= Eresultfinalz/100000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>5</sup>";
                            }



                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinaly) > 1000000){
                                Eresultfinaly= Eresultfinaly/1000000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinalz) > 1000000){
                                Eresultfinalz= Eresultfinalz/1000000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>6</sup>";
                            }



                            info.setText(Html.fromHtml("<b>H</b> = "+eresulty+"<b>ây</b> + "+eresultz+"<b>âz</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [I/(2π*r)]<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. Se dl = "+componentedl+" , Então : " +
                                    "<br>" +
                                    "<br> I = " +df.format(Eprocess)+" A"+
                                    "<br> Valores de corrente negativo são intendidos como uma corrente que anda no sentido contrario da linha, exemplo: -<b>âx</b>,-<b>ây</b> -<b>âz</b> . " +
                                    "<br>"+
                                    "<br> .. <b>R</b> = (Yp-Yl)<b>ây</b> + (Zp-Zl)<b>âz</b>" +
                                    "<br> .. r = |<b>R</b>| = √((Yp-Yl)^2 + (Zp-Zl)^2)" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>Obs: <b>R</b> e r, são o vetor e a distância, respectiva-" +
                                    "<br> mente, perpendicular do ponto de cálculo " +
                                    "<br> (x,y,z) a linha L (x',y',z')." +
                                    "<br>" +
                                    "<br> <b>H</b> está sempre ao longo do vetor unitário <b>âᵩ</b>, isto é ao longo de trajetórias circulares concêntricas. " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>R</b> = ("+p_5.getText().toString()+"-"+p_1.getText().toString()+")<b>ây</b> + ("+p_6.getText().toString()+"-"+p_2.getText().toString()+")<b>âz</b> " +
                                    "<br>" +
                                    "<br> .. <b>R</b> = "+String.valueOf(df2.format(Ry)).replace(",",".").replace(",",".")+"<b>ây</b> + "+String.valueOf(df2.format(Rz)).replace(",",".")+"<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. r = √[("+String.valueOf(df2.format(Ry)).replace(",",".")+")^2 + ("+String.valueOf(df2.format(Rz)).replace(",",".")+")^2]" +
                                    "<br> .. r = √("+ df2.format(Math.pow(norma, 2)).replace(",",".")+")" +
                                    "<br> .. r = "+ df2.format(norma).replace(",",".")+
                                    "<br>" +
                                    "<br>"+
                                    "<br><b>H</b> = "+eresult+"*<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>"+
                                    "<br> .. <b>âᵩ</b> = " +componentedlvirtual+" x (<b>R</b>/r)"+
                                    "<br> .. <b>âᵩ</b> = "+componentedlvirtual+" x ("+df.format(Ry/norma)+"<b>ây</b> + "+df.format(Rz/norma)+"<b>âz</b>)"+
                                    "<br> .. <b>âᵩ</b> = " +df.format(resultyPV)+"<b>ây</b> + "+df.format(resultzPV)+"<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"*("+df.format(resultyPV).replace("+-","-")+"<b>ây</b> + "+df.format(resultzPV).replace("+-","-")+"<b>âz</b>)" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresulty+"<b>ây</b> + "+eresultz+"<b>âz</b> A/m"));



                            Passos();
                        }
                        if (componentedl.equals("dy")){

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p2 = Double.parseDouble(p_2.getText().toString());
                            p4 = Double.parseDouble(p_4.getText().toString());
                            p5 = Double.parseDouble(p_5.getText().toString());
                            p6 = Double.parseDouble(p_6.getText().toString());

                            Double Rx = p4 - p1;
                            Double Rz = p6 - p2;

                            Double norma = Math.sqrt(Math.pow(Rx, 2)+Math.pow(Rz,2));

                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eprocess = processs.evaluate();


                            if (Eprocess >= 0){
                                resultxPV = ( 1 * (Rz/norma)) - (0 * p5);
                                resultyPV = (0 * (Rx/norma)) - (0*(Rz/norma));
                                resultzPV = (0 * p5) - ((Rx/norma) * 1);
                                componentedlvirtual = "<b>ây</b>";
                            }
                            else{
                                resultxPV = ( (-1) * (Rz/norma)) - (0 * p5);
                                resultyPV = (0 * (Rx/norma)) - (0*(Rz/norma));
                                resultzPV = (0 * p5) - ((Rx/norma) * (-1));
                                componentedlvirtual = "-<b>ây</b>";
                            }

                            Eprocess = Math.abs(Eprocess);


                            Expression ex = new ExpressionBuilder("("+Eprocess+")/(2*"+Math.PI+"*"+norma+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();

                            Expression ey = new ExpressionBuilder("("+resultxPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinalx = ey.evaluate();

                            Expression ez = new ExpressionBuilder("("+resultzPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinalz = ez.evaluate();

                            String eresult = df3.format(Eresult);
                            String eresultx = df3.format(Eresultfinalx);
                            String eresultz = df3.format(Eresultfinalz);


                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.01 && Math.abs(Eresultfinalx) > 0.001){
                                Eresultfinalx= Eresultfinalx*1000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.01 && Math.abs(Eresultfinalz) > 0.001){
                                Eresultfinalz= Eresultfinalz*1000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-3</sup>";
                            }



                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.001 && Math.abs(Eresultfinalx) > 0.0001){
                                Eresultfinalx= Eresultfinalx*10000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.001 && Math.abs(Eresultfinalz) > 0.0001){
                                Eresultfinalz= Eresultfinalz*10000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-4</sup>";
                            }

                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.0001 && Math.abs(Eresultfinalx) > 0.00001){
                                Eresultfinalx= Eresultfinalx*100000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.0001 && Math.abs(Eresultfinalz) > 0.00001){
                                Eresultfinalz= Eresultfinalz*100000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-5</sup>";
                            }


                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.00001 && Math.abs(Eresultfinalx) > 0.000001){
                                Eresultfinalx= Eresultfinalx*1000000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 0.00001 && Math.abs(Eresultfinalz) > 0.000001){
                                Eresultfinalz= Eresultfinalz*1000000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>-6</sup>";
                            }



                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 100000 && Math.abs(Eresultfinalx) > 10000){
                                Eresultfinalx= Eresultfinalx/10000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 100000 && Math.abs(Eresultfinalz) > 10000){
                                Eresultfinalz= Eresultfinalz/10000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>4</sup>";
                            }



                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 1000000 && Math.abs(Eresultfinalx) > 100000){
                                Eresultfinalx= Eresultfinalx/100000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinalz) < 1000000 && Math.abs(Eresultfinalz) > 100000){
                                Eresultfinalz= Eresultfinalz/100000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>5</sup>";
                            }



                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinalx) > 1000000){
                                Eresultfinalx= Eresultfinalx/1000000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinalz) > 1000000){
                                Eresultfinalz= Eresultfinalz/1000000;
                                eresultz = df3.format(Eresultfinalz) + "*10<sup>6</sup>";
                            }



                            info.setText(Html.fromHtml("<b>H</b> = "+eresultx+"<b>âx</b> + "+eresultz+"<b>âz</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [I/(2π*r)]<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. Se dl = "+componentedl+" , Então : " +
                                    "<br>" +
                                    "<br> I = " +df.format(Eprocess)+" A"+
                                    "<br> Valores de corrente negativo são intendidos como uma corrente que anda no sentido contrario da linha, exemplo: -<b>âx</b>,-<b>ây</b> -<b>âz</b> . " +
                                    "<br>"+
                                    "<br> .. <b>R</b> = (Xp-Xl)<b>âx</b> + (Zp-Zl)<b>âz</b>" +
                                    "<br> .. r = |<b>R</b>| = √((Xp-Xl)^2 + (Zp-Zl)^2)" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>Obs: <b>R</b> e r, são o vetor e a distância, respectiva-" +
                                    "<br> mente, perpendicular do ponto de cálculo " +
                                    "<br> (x,y,z) a linha L (x',y',z')." +
                                    "<br>" +
                                    "<br> <b>H</b> está sempre ao longo do vetor unitário <b>âᵩ</b>, isto é ao longo de trajetórias circulares concêntricas. " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>R</b> = ("+p_4.getText().toString()+"-"+p_1.getText().toString()+")<b>âx</b> + ("+p_6.getText().toString()+"-"+p_2.getText().toString()+")<b>âz</b> " +
                                    "<br>" +
                                    "<br> .. <b>R</b> = "+String.valueOf(df2.format(Rx)).replace(",",".").replace(",",".")+"<b>âx</b> + "+String.valueOf(df2.format(Rz)).replace(",",".")+"<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. r = √[("+String.valueOf(df2.format(Rx)).replace(",",".")+")^2 + ("+String.valueOf(df2.format(Rz)).replace(",",".")+")^2]" +
                                    "<br> .. r = √("+ df2.format(Math.pow(norma, 2)).replace(",",".")+")" +
                                    "<br> .. r = "+ df2.format(norma).replace(",",".")+
                                    "<br>" +
                                    "<br>"+
                                    "<br><b>H</b> = "+eresult+"*<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>"+
                                    "<br> .. <b>âᵩ</b> = " +componentedlvirtual+" x (<b>R</b>/r)"+
                                    "<br> .. <b>âᵩ</b> = "+componentedlvirtual+" x ("+df.format(Rx/norma)+"<b>âx</b> + "+df.format(Rz/norma)+"<b>âz</b>)"+
                                    "<br> .. <b>âᵩ</b> = " +df.format(resultxPV)+"<b>âx</b> + "+df.format(resultzPV)+"<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"*("+df.format(resultxPV).replace("+-","-")+"<b>âx</b> + "+df.format(resultzPV).replace("+-","-")+"<b>âz</b>)" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresultx+"<b>âx</b> + "+eresultz+"<b>âz</b> A/m"));

                            Passos();
                        }
                        if (componentedl.equals("dz")){

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p2 = Double.parseDouble(p_2.getText().toString());
                            p4 = Double.parseDouble(p_4.getText().toString());
                            p5 = Double.parseDouble(p_5.getText().toString());
                            p6 = Double.parseDouble(p_6.getText().toString());

                            Double Rx = p4 - p1;
                            Double Ry = p5 - p2;

                            Double norma = Math.sqrt(Math.pow(Rx, 2)+Math.pow(Ry,2));

                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eprocess = processs.evaluate();


                            if (Eprocess >= 0){
                                resultxPV = ( 0 * p6) - (1 * (Ry/norma));
                                resultyPV = (1 * (Rx/norma)) - (0*p6);
                                resultzPV = (0 * (Ry/norma)) - ((Rx/norma) * 0);
                                componentedlvirtual = "<b>âz</b>";
                            }
                            else{
                                resultxPV = ( 0 * p6) - ((-1) * (Ry/norma));
                                resultyPV = ((-1) * (Rx/norma)) - (0*p6);
                                resultzPV = (0 * (Ry/norma)) - ((Rx/norma) * 0);
                                componentedlvirtual = "-<b>âz</b>";
                            }

                            Eprocess = Math.abs(Eprocess);


                            Expression ex = new ExpressionBuilder("("+Eprocess+")/(2*"+Math.PI+"*"+norma+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();

                            Expression ey = new ExpressionBuilder("("+resultxPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinalx = ey.evaluate();

                            Expression ez = new ExpressionBuilder("("+resultyPV+")*("+Eresult+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresultfinaly = ez.evaluate();

                            String eresult = df3.format(Eresult);
                            String eresultx = df3.format(Eresultfinalx);
                            String eresulty = df3.format(Eresultfinaly);


                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.01 && Math.abs(Eresultfinalx) > 0.001){
                                Eresultfinalx= Eresultfinalx*1000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-3</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.01 && Math.abs(Eresultfinaly) > 0.001){
                                Eresultfinaly= Eresultfinaly*1000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-3</sup>";
                            }



                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.001 && Math.abs(Eresultfinalx) > 0.0001){
                                Eresultfinalx= Eresultfinalx*10000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.001 && Math.abs(Eresultfinaly) > 0.0001){
                                Eresultfinaly= Eresultfinaly*10000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-4</sup>";
                            }

                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.0001 && Math.abs(Eresultfinalx) > 0.00001){
                                Eresultfinalx= Eresultfinalx*100000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.0001 && Math.abs(Eresultfinaly) > 0.00001){
                                Eresultfinaly= Eresultfinaly*100000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-5</sup>";
                            }


                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 0.00001 && Math.abs(Eresultfinalx) > 0.000001){
                                Eresultfinalx= Eresultfinalx*1000000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>-6</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 0.00001 && Math.abs(Eresultfinaly) > 0.000001){
                                Eresultfinaly= Eresultfinaly*1000000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>-6</sup>";
                            }


                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 100000 && Math.abs(Eresultfinaly) > 10000){
                                Eresultfinaly= Eresultfinaly/10000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>4</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 100000 && Math.abs(Eresultfinalx) > 10000){
                                Eresultfinalx= Eresultfinalx/10000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>4</sup>";
                            }



                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinaly) < 1000000 && Math.abs(Eresultfinaly) > 100000){
                                Eresultfinaly= Eresultfinaly/100000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresultfinalx) < 1000000 && Math.abs(Eresultfinalx) > 100000){
                                Eresultfinalx= Eresultfinalx/100000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>5</sup>";
                            }



                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinaly) > 1000000){
                                Eresultfinaly= Eresultfinaly/1000000;
                                eresulty = df3.format(Eresultfinaly) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresultfinalx) > 1000000){
                                Eresultfinalx= Eresultfinalx/1000000;
                                eresultx = df3.format(Eresultfinalx) + "*10<sup>6</sup>";
                            }



                            info.setText(Html.fromHtml("<b>H</b> = "+eresultx+"<b>âx</b> + "+eresulty+"<b>ây</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [I/(2π*r)]<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. Se dl = "+componentedl+" , Então : " +
                                    "<br>" +
                                    "<br> I = " +df.format(Eprocess)+" A"+
                                    "<br> Valores de corrente negativo são intendidos como uma corrente que anda no sentido contrario da linha, exemplo: -<b>âx</b>,-<b>ây</b> -<b>âz</b> . " +
                                    "<br>"+
                                    "<br> .. <b>R</b> = (Xp-Xl)<b>âx</b> + (Yp-Yl)<b>ây</b>" +
                                    "<br> .. r = |<b>R</b>| = √((Xp-Xl)^2 + (Yp-Yl)^2)" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>Obs: <b>R</b> e r, são o vetor e a distância, respectiva-" +
                                    "<br> mente, perpendicular do ponto de cálculo " +
                                    "<br> (x,y,z) a linha L (x',y',z')." +
                                    "<br>" +
                                    "<br> <b>H</b> está sempre ao longo do vetor unitário <b>âᵩ</b>, isto é ao longo de trajetórias circulares concêntricas. " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. <b>R</b> = ("+p_4.getText().toString()+"-"+p_1.getText().toString()+")<b>âx</b> + ("+p_5.getText().toString()+"-"+p_2.getText().toString()+")<b>âY</b> " +
                                    "<br>" +
                                    "<br> .. <b>R</b> = "+String.valueOf(df2.format(Rx)).replace(",",".").replace(",",".")+"<b>âx</b> + "+String.valueOf(df2.format(Ry)).replace(",",".")+"<b>ây</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. r = √[("+String.valueOf(df2.format(Rx)).replace(",",".")+")^2 + ("+String.valueOf(df2.format(Ry)).replace(",",".")+")^2]" +
                                    "<br> .. r = √("+ df2.format(Math.pow(norma, 2)).replace(",",".")+")" +
                                    "<br> .. r = "+ df2.format(norma).replace(",",".")+
                                    "<br>" +
                                    "<br>"+
                                    "<br><b>H</b> = "+eresult+"*<b>âᵩ</b>" +
                                    "<br>" +
                                    "<br>"+
                                    "<br> .. <b>âᵩ</b> = " +componentedlvirtual+" x (<b>R</b>/r)"+
                                    "<br> .. <b>âᵩ</b> = "+componentedlvirtual+" x ("+df.format(Rx/norma)+"<b>âx</b> + "+df.format(Ry/norma)+"<b>ây</b>)"+
                                    "<br> .. <b>âᵩ</b> = " +df.format(resultxPV)+"<b>âx</b> + "+df.format(resultyPV)+"<b>ây</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"*("+df.format(resultxPV).replace("+-","-")+"<b>âx</b> + "+df.format(resultyPV).replace("+-","-")+"<b>ây</b>)" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresultx+"<b>âx</b> + "+eresulty+"<b>ây</b> A/m"));

                            Passos();

                        }

                    }
                }
                catch (Exception e ){

                    progress.setVisibility(View.INVISIBLE);
                    info.setText(R.string.erro2);
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
                layoutParams.height = 2000;
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