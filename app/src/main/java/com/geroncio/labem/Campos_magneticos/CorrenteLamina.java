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

public class CorrenteLamina extends AppCompatActivity {

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btnxn, btnpi;
    TextView txtimputx,txtimputy, info, infoM;
    EditText p_1 = null, p_4 = null, p_5 = null, p_6 = null,k_x = null, k_y = null;
    Double p1 = (double) 0, p4 = null, p5 = null, p6 = null, kx = (double) 0, ky = (double) 0;
    String processx = null;
    String processy = null;
    RadioGroup radiofinitude, radiocomponentedl;
    String componentedl = null, componentedlvirtual = null;
    ProgressBar progress;
    android.widget.Button calcular;
    ImageButton fxCalculator,fyCalculator;
    LinearLayout fxCalculatorLayout, anglayout;
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
    double resultxPV = 0, resultyPV = 0, resultzPV = 0;
    double compax = 0, compay = 0, compaz = 0;
    double teta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corrente_lamina);

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
                    params.height = 280;
                    fxCalculatorLayout.setLayoutParams(params);
                    tecladoy = true;


                },200);

                Tecladoy();

            }

        });

        CheckBoxComponente();

    }

    private void Inicializate() {

        calcular = findViewById(R.id.calcular);
        fxCalculator = findViewById(R.id.calculator_fxvisible);
        fxCalculatorLayout = findViewById(R.id.calculadora_fx);
        fyCalculator = findViewById(R.id.calculator_fyvisible);
        info = findViewById(R.id.infoM);
        infoM = findViewById(R.id.passosresult);
        txtimputx = findViewById(R.id.btnimputx);
        txtimputy = findViewById(R.id.btnimputy);
        p_1 = findViewById(R.id.p_1);

        p_4 = findViewById(R.id.p_4);
        p_5 = findViewById(R.id.p_5);
        p_6 = findViewById(R.id.p_6);




        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        radiofinitude = findViewById(R.id.radiofinitude);
        radiocomponentedl = findViewById(R.id.radiocomponentedl);
        anglayout = findViewById(R.id.anglayout);
        progress = findViewById(R.id.progress);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "CorrenteLamina.class";
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
                    componentedl = "dydz";
                    txtimputx.setHint("Ky");
                    txtimputy.setHint("Kz");
                    Pontodalinha();
                    break;

                case R.id.radiocomponentedy:
                    componentedl = "dxdz";
                    txtimputx.setHint("Kx");
                    txtimputy.setHint("Kz");
                    Pontodalinha();
                    break;

                case R.id.radiocomponentedz:
                    componentedl = "dxdy";
                    txtimputx.setHint("Kx");
                    txtimputy.setHint("Ky");
                    Pontodalinha();
                    break;
            }
        });
    }

    private void Pontodalinha(){
        if (componentedl.equals("dydz")){
            p_1.setHint("x");
            CalcularFinito();
        }
        if (componentedl.equals("dxdz")){
            p_1.setHint("y");
            CalcularFinito();
        }
        if (componentedl.equals("dxdy")){
            p_1.setHint("z");
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

    @SuppressLint("SetTextI18n")
    private void CalcularFinito(){

        calcular.setOnClickListener(view -> {

            progress.setVisibility(View.VISIBLE);
            info.setText("");

            new Handler().postDelayed(() -> {

                try {
                    info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                    info.setTextColor(getResources().getColor(R.color.black));

                    if (componentedl == null ){


                        info.setText(R.string.erro);
                        passos.setImageResource(R.drawable.ic_eye_lightblack);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                        layoutParams.height = 0;
                        layoutpassos.setLayoutParams(layoutParams);

                    }
                    else{
                        if (componentedl.equals("dydz")){

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p4 = Double.parseDouble(p_4.getText().toString());
                            p5 = Double.parseDouble(p_5.getText().toString());
                            p6 = Double.parseDouble(p_6.getText().toString());



                            Double h = p4 - p1;




                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double K1 = processs.evaluate();

                            Expression processsy = new ExpressionBuilder("("+processy+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double K2 = processsy.evaluate();


                            resultxPV = ( 0 * K2) - (0 * K1);
                            resultyPV = (0 * p4) - (1*K2);
                            resultzPV = (1 *K1) - (p4 * 0);


                            if (h >= 0){
                                componentedlvirtual = "<b>âx</b>";
                            }
                            else{
                                componentedlvirtual = "<b>âx</b>";
                                resultyPV = - resultyPV;
                                resultzPV = -resultzPV;
                            }



                            Expression ex = new ExpressionBuilder("("+resultyPV+")/2")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();

                            Expression ey = new ExpressionBuilder("("+resultzPV+")/2")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult2 = ey.evaluate();


                            String eresult = df3.format(Eresult);
                            String eresult2 = df3.format(Eresult2);



                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }

                            if (Math.abs(Eresult2) < 0.01 && Math.abs(Eresult2) > 0.001){
                                Eresult2= Eresult2*1000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-3</sup>";
                            }




                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresult2) < 0.001 && Math.abs(Eresult2) > 0.0001){
                                Eresult2= Eresult2*10000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-4</sup>";
                            }


                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresult2) < 0.0001 && Math.abs(Eresult2) > 0.00001){
                                Eresult2= Eresult2*100000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-5</sup>";
                            }



                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }

                            if (Math.abs(Eresult2) < 0.00001 && Math.abs(Eresult2) > 0.000001){
                                Eresult2= Eresult2*1000000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-6</sup>";
                            }




                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }

                            if (Math.abs(Eresult2) < 100000 && Math.abs(Eresult2) > 10000){
                                Eresult2= Eresult2/10000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>4</sup>";
                            }




                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresult2) < 1000000 && Math.abs(Eresult2) > 100000){
                                Eresult2= Eresult2/100000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>5</sup>";
                            }




                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresult2) > 1000000){
                                Eresult2= Eresult2/1000000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>6</sup>";
                            }




                            info.setText(Html.fromHtml("<b>H</b> = "+eresult+"<b>ây</b> +"+eresult2+"<b>âz</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [1/2]*<b>K</b> x <b>ân</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. dl = "+componentedl+" " +
                                    "<br>" +
                                    "<br> .. K = " +df.format(K1)+"<b>ây</b> + "+df.format(K2)+"<b>âz</b> A/m"+
                                    "<br> " +
                                    "<br> .. K é a densidade de corrente uniforme"+
                                    "<br> .. <b>ân</b> é a componente do vetor unitário da superfície"+
                                    "<br> " +
                                    "<br> .. <b>ân</b> = "+componentedlvirtual+
                                    "<br>"+
                                    "<br>" +
                                    "<br><b>H</b> = (1/2)*("+df.format(K1)+"<b>ây</b> + "+df.format(K2)+"<b>âz</b>) x (1"+componentedlvirtual+")"+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"<b>ây</b> +"+eresult2+"<b>âz</b> A/m"));



                            Passos();
                        }
                        if (componentedl.equals("dxdz")){

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p4 = Double.parseDouble(p_4.getText().toString());
                            p5 = Double.parseDouble(p_5.getText().toString());
                            p6 = Double.parseDouble(p_6.getText().toString());



                            Double h = p5 - p1;




                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double K1 = processs.evaluate();

                            Expression processsy = new ExpressionBuilder("("+processy+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double K2 = processsy.evaluate();


                            resultxPV = ( 1 * K2) - (0 * p5);
                            resultyPV = (0 * K1) - (0*K2);
                            resultzPV = (0 * p5) - (K1 * 1);


                            if (h >= 0){
                                componentedlvirtual = "<b>ây</b>";
                            }
                            else{
                                componentedlvirtual = "<b>ây</b>";
                                resultxPV = - resultxPV;
                                resultzPV = -resultzPV;
                            }



                            Expression ex = new ExpressionBuilder("("+resultxPV+")/2")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();

                            Expression ey = new ExpressionBuilder("("+resultzPV+")/2")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult2 = ey.evaluate();


                            String eresult = df3.format(Eresult);
                            String eresult2 = df3.format(Eresult2);



                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }

                            if (Math.abs(Eresult2) < 0.01 && Math.abs(Eresult2) > 0.001){
                                Eresult2= Eresult2*1000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-3</sup>";
                            }




                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresult2) < 0.001 && Math.abs(Eresult2) > 0.0001){
                                Eresult2= Eresult2*10000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-4</sup>";
                            }


                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresult2) < 0.0001 && Math.abs(Eresult2) > 0.00001){
                                Eresult2= Eresult2*100000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-5</sup>";
                            }



                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }

                            if (Math.abs(Eresult2) < 0.00001 && Math.abs(Eresult2) > 0.000001){
                                Eresult2= Eresult2*1000000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-6</sup>";
                            }




                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }

                            if (Math.abs(Eresult2) < 100000 && Math.abs(Eresult2) > 10000){
                                Eresult2= Eresult2/10000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>4</sup>";
                            }




                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresult2) < 1000000 && Math.abs(Eresult2) > 100000){
                                Eresult2= Eresult2/100000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>5</sup>";
                            }




                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresult2) > 1000000){
                                Eresult2= Eresult2/1000000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>6</sup>";
                            }




                            info.setText(Html.fromHtml("<b>H</b> = "+eresult+"<b>âx</b> +"+eresult2+"<b>âz</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [1/2]*<b>K</b> x <b>ân</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. dl = "+componentedl+" " +
                                    "<br>" +
                                    "<br> .. K = " +df.format(K1)+"<b>âx</b> + "+df.format(K2)+"<b>âz</b> A/m"+
                                    "<br> " +
                                    "<br> .. K é a densidade de corrente uniforme"+
                                    "<br> .. <b>ân</b> é a componente do vetor unitário da superfície"+
                                    "<br> " +
                                    "<br> .. <b>ân</b> = "+componentedlvirtual+
                                    "<br>"+
                                    "<br>" +
                                    "<br><b>H</b> = (1/2)*("+df.format(K1)+"<b>âx</b> + "+df.format(K2)+"<b>âz</b>) x (1"+componentedlvirtual+")"+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"<b>âx</b> +"+eresult2+"<b>âz</b> A/m"));



                            Passos();
                        }
                        if (componentedl.equals("dxdy")){

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p4 = Double.parseDouble(p_4.getText().toString());
                            p5 = Double.parseDouble(p_5.getText().toString());
                            p6 = Double.parseDouble(p_6.getText().toString());



                            Double h = p6 - p1;




                            Expression processs = new ExpressionBuilder("("+processx+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double K1 = processs.evaluate();

                            Expression processsy = new ExpressionBuilder("("+processy+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double K2 = processsy.evaluate();


                            resultxPV = ( 0 * p6) - (1 * K2);
                            resultyPV = (1 * K1) - (0*p6);
                            resultzPV = (0 * K2) - (K1 * 0);


                            if (h >= 0){
                                componentedlvirtual = "<b>âz</b>";
                            }
                            else{
                                componentedlvirtual = "<b>âz</b>";
                                resultxPV = - resultxPV;
                                resultzPV = -resultzPV;
                            }



                            Expression ex = new ExpressionBuilder("("+resultxPV+")/2")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult = ex.evaluate();

                            Expression ey = new ExpressionBuilder("("+resultzPV+")/2")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            double Eresult2 = ey.evaluate();


                            String eresult = df3.format(Eresult);
                            String eresult2 = df3.format(Eresult2);



                            if (Math.abs(Eresult) < 0.01 && Math.abs(Eresult) > 0.001){
                                Eresult= Eresult*1000;
                                eresult = df3.format(Eresult) + "*10<sup>-3</sup>";
                            }

                            if (Math.abs(Eresult2) < 0.01 && Math.abs(Eresult2) > 0.001){
                                Eresult2= Eresult2*1000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-3</sup>";
                            }




                            if (Math.abs(Eresult) < 0.001 && Math.abs(Eresult) > 0.0001){
                                Eresult= Eresult*10000;
                                eresult = df3.format(Eresult) + "*10<sup>-4</sup>";
                            }
                            if (Math.abs(Eresult2) < 0.001 && Math.abs(Eresult2) > 0.0001){
                                Eresult2= Eresult2*10000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-4</sup>";
                            }


                            if (Math.abs(Eresult) < 0.0001 && Math.abs(Eresult) > 0.00001){
                                Eresult= Eresult*100000;
                                eresult = df3.format(Eresult) + "*10<sup>-5</sup>";
                            }
                            if (Math.abs(Eresult2) < 0.0001 && Math.abs(Eresult2) > 0.00001){
                                Eresult2= Eresult2*100000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-5</sup>";
                            }



                            if (Math.abs(Eresult) < 0.00001 && Math.abs(Eresult) > 0.000001){
                                Eresult= Eresult*1000000;
                                eresult = df3.format(Eresult) + "*10<sup>-6</sup>";
                            }

                            if (Math.abs(Eresult2) < 0.00001 && Math.abs(Eresult2) > 0.000001){
                                Eresult2= Eresult2*1000000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>-6</sup>";
                            }




                            if (Math.abs(Eresult) < 100000 && Math.abs(Eresult) > 10000){
                                Eresult= Eresult/10000;
                                eresult = df3.format(Eresult) + "*10<sup>4</sup>";
                            }

                            if (Math.abs(Eresult2) < 100000 && Math.abs(Eresult2) > 10000){
                                Eresult2= Eresult2/10000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>4</sup>";
                            }




                            if (Math.abs(Eresult) < 1000000 && Math.abs(Eresult) > 100000){
                                Eresult= Eresult/100000;
                                eresult = df3.format(Eresult) + "*10<sup>5</sup>";
                            }
                            if (Math.abs(Eresult2) < 1000000 && Math.abs(Eresult2) > 100000){
                                Eresult2= Eresult2/100000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>5</sup>";
                            }




                            if (Math.abs(Eresult) > 1000000){
                                Eresult= Eresult/1000000;
                                eresult = df3.format(Eresult) + "*10<sup>6</sup>";
                            }
                            if (Math.abs(Eresult2) > 1000000){
                                Eresult2= Eresult2/1000000;
                                eresult2 = df3.format(Eresult2) + "*10<sup>6</sup>";
                            }




                            info.setText(Html.fromHtml("<b>H</b> = "+eresult+"<b>âx</b> +"+eresult2+"<b>ây</b> A/m"));

                            infoM.setText(Html.fromHtml("<b>H</b> = [1/2]*<b>K</b> x <b>ân</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> .. dl = "+componentedl+" " +
                                    "<br>" +
                                    "<br> .. K = " +df.format(K1)+"<b>âx</b> + "+df.format(K2)+"<b>ây</b> A/m"+
                                    "<br> " +
                                    "<br> .. K é a densidade de corrente uniforme"+
                                    "<br> .. <b>ân</b> é a componente do vetor unitário da superfície"+
                                    "<br> " +
                                    "<br> .. <b>ân</b> = "+componentedlvirtual+
                                    "<br>"+
                                    "<br>" +
                                    "<br><b>H</b> = (1/2)*("+df.format(K1)+"<b>âx</b> + "+df.format(K2)+"<b>ây</b>) x (1"+componentedlvirtual+")"+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>H</b> = "+eresult+"<b>âx</b> +"+eresult2+"<b>ây</b> A/m"));



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