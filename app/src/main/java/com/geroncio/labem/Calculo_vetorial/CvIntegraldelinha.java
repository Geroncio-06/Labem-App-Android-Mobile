package com.geroncio.labem.Calculo_vetorial;

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

import com.geroncio.labem.Derivadas.Derivative;
import com.geroncio.labem.Derivadas.DerivativeY;
import com.geroncio.labem.Derivadas.DerivativeZ;
import com.geroncio.labem.Others.Info;
import com.geroncio.labem.R;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class CvIntegraldelinha extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpi, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btne, btnlog2, btnraiz, btnx2, btnxn, btnlog10, btnln, btnsin, btncos, btntan, btnsinh, btncosh, btntanh, btnx, btny,btnz;
    TextView txtimputx, txtimputy, txtimputz, txtimputw, info, infoM;
    EditText p_1 = null, p_2 = null;
    Double p1 = null, p2 = null;
    String processx = null, processx2 = null;
    String processy = null, processz = null, processw = null;
    android.widget.Button calcular;
    ImageButton fxCalculator, fyCalculator, fzCalculator, fwCalculator;
    LinearLayout fxCalculatorLayout;
    LinearLayout.LayoutParams params;
    boolean tecladox = false, tecladoy = false, tecladoz = false, tecladow = false;
    boolean calculoClick = false;
    LinearLayout layoutpassos;
    ImageButton voltar, passos;
    ProgressBar progressBar;
    SharedPreferences preferences;
    String decimaisnum = "3";
    DecimalFormat df = new DecimalFormat("#0.0");
    ImageView ajuda;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_integraldelinha);


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
                    params.height = 450;
                    fxCalculatorLayout.setLayoutParams(params);
                    tecladox = true;
                    tecladoy = false;
                    tecladoz = false;
                    tecladow = false;
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
                    params.height = 450;
                    fxCalculatorLayout.setLayoutParams(params);
                    tecladox = false;
                    tecladoy = true;
                    tecladoz = false;
                    tecladow = false;
                },200);

                Tecladoy();
            }

        });

        fzCalculator.setOnClickListener(view -> {

            if (tecladoz){
                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 0;
                fxCalculatorLayout.setLayoutParams(params);
                tecladoz = false;

            }
            else {
                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 0;
                fxCalculatorLayout.setLayoutParams(params);

                new Handler().postDelayed(() -> {
                    params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                    params.height = 450;
                    fxCalculatorLayout.setLayoutParams(params);
                    tecladox = false;
                    tecladoy = false;
                    tecladoz = true;
                    tecladow = false;
                },200);

                Tecladoz();
            }

        });

        fwCalculator.setOnClickListener(view -> {

            if (tecladow){
                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 0;
                fxCalculatorLayout.setLayoutParams(params);
                tecladow = false;

            }
            else {
                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 0;
                fxCalculatorLayout.setLayoutParams(params);

                new Handler().postDelayed(() -> {
                    params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                    params.height = 450;
                    fxCalculatorLayout.setLayoutParams(params);
                    tecladox = false;
                    tecladoy = false;
                    tecladoz = false;
                    tecladow = true;
                },200);

                Tecladow();
            }

        });

        Calcular();
    }

    /**
     * Linkando variaveis globais com objetos na tela de layout*/
    private void Inicializate() {
        calcular = findViewById(R.id.calcular);
        fxCalculator = findViewById(R.id.calculator_fxvisible); fyCalculator = findViewById(R.id.calculator_fyvisible);
        fzCalculator = findViewById(R.id.calculator_fzvisible); fwCalculator = findViewById(R.id.calculator_fwvisible);
        fxCalculatorLayout = findViewById(R.id.calculadora_fx);
        info = findViewById(R.id.infoM);
        infoM = findViewById(R.id.passosresult);
        txtimputx = findViewById(R.id.btnimputx);
        txtimputy = findViewById(R.id.btnimputy);
        txtimputz = findViewById(R.id.btnimputz);
        txtimputw = findViewById(R.id.btnimputw);
        p_1 = findViewById(R.id.p_1);
        p_2 = findViewById(R.id.p_2);
        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        progressBar = findViewById(R.id.progress);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "CvIntegraldelinha.class";
            i.putExtra("STRING_ACTIVITY", main);
            startActivity(i);
        });


        voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Calculo_vetorial.class));
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
        btnpi = findViewById(R.id.gc_02);
        btnpl = findViewById(R.id.gc_07);
        btnpr = findViewById(R.id.gc_08);
        btnc = findViewById(R.id.gc_06);
        btnvir = findViewById(R.id.gc_29);

        btne = findViewById(R.id.gc_01);
        btnlog2 = findViewById(R.id.gc_04);
        btnraiz = findViewById(R.id.gc_11);
        btnx2 = findViewById(R.id.gc_09);
        btnxn = findViewById(R.id.gc_10);
        btnlog10 = findViewById(R.id.gc_03);
        btnln = findViewById(R.id.gc_12);
        btnsin = findViewById(R.id.gc_13);
        btncos = findViewById(R.id.gc_14);
        btntan = findViewById(R.id.gc_15);
        btnsinh = findViewById(R.id.gc_16);
        btncosh = findViewById(R.id.gc_17);
        btntanh = findViewById(R.id.gc_18);
        btnbackspace = findViewById(R.id.gc_05);
        btnx = findViewById(R.id.gc_19);
        btny = findViewById(R.id.gc_20);
        btnz = findViewById(R.id.gc_21);



        btnx2.setText(Html.fromHtml(" x&sup2"));
        btnpi.setText(Html.fromHtml("&pi"));
    }

    private  void Teclado(){

        btnc.setOnClickListener(view -> {
            txtimputx.setText("");
            processx = null; processx2 = null;

            if (calculoClick){info.setText("");}
        });
        btn0.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "0";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn1.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "1";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn2.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "2";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn3.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "3";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn4.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "4";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn5.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "5";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn6.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "6";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn7.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "7";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn8.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "8";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btn9.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "9";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btndiv.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "/";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnmul.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "*";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnsub.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "-";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnsom.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "+";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnvir.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + ".";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnpi.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "π";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnpl.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btnpr.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + ")";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btnbackspace.setOnClickListener(view -> {
            processx = txtimputx.getText().toString();
            if (processx.length()>0){
                processx = processx.substring(0, processx.length() - 1);
                processx2 = processx;
                txtimputx.setText(processx);

                if (calculoClick){info.setText("");}

            }else if (processx.length()<=0){
                txtimputx.setText("");

                if (calculoClick){info.setText("");}
            }
        });

        btne.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "e";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnlog2.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "log2(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnln.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() +"ln(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnlog10.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() +"log(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btnx2.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() +"^(2)";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btnxn.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() +"^(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btnraiz.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "√(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnsin.setOnClickListener(view -> {

            processx = txtimputx.getText().toString() + "sin(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btncos.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "cos(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btntan.setOnClickListener(view -> {

            processx = txtimputx.getText().toString() + "tan(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnsinh.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "sinh(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btncosh.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "cosh(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btntanh.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "tanh(";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnx.setText("x");
        btnx.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "x";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btny.setText("y");btny.setEnabled(true);
        btny.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "y";
            processx2 = processx;
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnz.setText("z");btnz.setEnabled(true);
        btnz.setOnClickListener(view -> {
            processx = txtimputx.getText().toString()+"z";
            processx2 = processx;
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
        btnpi.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "π";
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

            }else if (processy.length()<=0){
                txtimputy.setText("");

                if (calculoClick){info.setText("");}
            }
        });

        btne.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "e";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnlog2.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "log2(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnln.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() +"ln(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnlog10.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() +"log(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}

        });
        btnx2.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() +"^(2)";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}

        });
        btnxn.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() +"^(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}

        });
        btnraiz.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "√(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnsin.setOnClickListener(view -> {

            processy = txtimputy.getText().toString() + "sin(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}

        });
        btncos.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "cos(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}

        });
        btntan.setOnClickListener(view -> {

            processy = txtimputy.getText().toString() + "tan(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnsinh.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "sinh(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btncosh.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "cosh(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btntanh.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "tanh(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnx.setText("t");
        btnx.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "t";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btny.setText("");btny.setEnabled(false);
        btny.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnz.setText("");btnz.setEnabled(false);
        btnz.setOnClickListener(view -> {
            processy = txtimputy.getText().toString()+"";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}


        });






    }

    private  void Tecladoz(){

        btnc.setOnClickListener(view -> {
            txtimputz.setText("");
            processz = null;

            if (calculoClick){info.setText("");}
        });
        btn0.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "0";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btn1.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "1";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btn2.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "2";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btn3.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "3";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btn4.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "4";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btn5.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "5";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btn6.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "6";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btn7.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "7";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btn8.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "8";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btn9.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "9";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btndiv.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "/";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnmul.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "*";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnsub.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "-";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnsom.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "+";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnvir.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + ".";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnpi.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "π";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnpl.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}

        });
        btnpr.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + ")";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}

        });
        btnbackspace.setOnClickListener(view -> {
            processz = txtimputz.getText().toString();
            if (processz.length()>0){
                processz = processz.substring(0, processz.length() - 1);
                txtimputz.setText(processz);

                if (calculoClick){info.setText("");}

            }else if (processz.length()<=0){
                txtimputz.setText("");

                if (calculoClick){info.setText("");}
            }
        });

        btne.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "e";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnlog2.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "log2(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnln.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() +"ln(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnlog10.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() +"log(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}

        });
        btnx2.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() +"^(2)";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}

        });
        btnxn.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() +"^(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}

        });
        btnraiz.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "√(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnsin.setOnClickListener(view -> {

            processz = txtimputz.getText().toString() + "sin(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}

        });
        btncos.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "cos(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}

        });
        btntan.setOnClickListener(view -> {

            processz = txtimputz.getText().toString() + "tan(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnsinh.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "sinh(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btncosh.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "cosh(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btntanh.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "tanh(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnx.setText("t");
        btnx.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "t";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btny.setText("");btny.setEnabled(false);
        btny.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnz.setText("");btnz.setEnabled(false);
        btnz.setOnClickListener(view -> {
            processz = txtimputz.getText().toString()+"";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}


        });






    }

    private  void Tecladow(){

        btnc.setOnClickListener(view -> {
            txtimputw.setText("");
            processw = null;

            if (calculoClick){info.setText("");}
        });
        btn0.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "0";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btn1.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "1";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btn2.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "2";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btn3.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "3";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btn4.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "4";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btn5.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "5";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btn6.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "6";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btn7.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "7";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btn8.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "8";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btn9.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "9";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btndiv.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "/";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnmul.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "*";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnsub.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "-";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnsom.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "+";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnvir.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + ".";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnpi.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "π";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnpl.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}

        });
        btnpr.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + ")";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}

        });
        btnbackspace.setOnClickListener(view -> {
            processw = txtimputw.getText().toString();
            if (processw.length()>0){
                processw = processw.substring(0, processw.length() - 1);
                txtimputw.setText(processw);

                if (calculoClick){info.setText("");}

            }else if (processw.length()<=0){
                txtimputw.setText("");

                if (calculoClick){info.setText("");}
            }
        });

        btne.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "e";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnlog2.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "log2(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnln.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() +"ln(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnlog10.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() +"log(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}

        });
        btnx2.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() +"^(2)";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}

        });
        btnxn.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() +"^(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}

        });
        btnraiz.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "√(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnsin.setOnClickListener(view -> {

            processw = txtimputw.getText().toString() + "sin(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}

        });
        btncos.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "cos(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}

        });
        btntan.setOnClickListener(view -> {

            processw = txtimputw.getText().toString() + "tan(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnsinh.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "sinh(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btncosh.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "cosh(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btntanh.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "tanh(";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnx.setText("t");
        btnx.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "t";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btny.setText("");btny.setEnabled(false);
        btny.setOnClickListener(view -> {
            processw = txtimputw.getText().toString() + "";
            txtimputw.setText(processw);

            if (calculoClick){info.setText("");}
        });
        btnz.setText("");btnz.setEnabled(false);
        btnz.setOnClickListener(view -> {
            processw = txtimputw.getText().toString()+"";
            txtimputw.setText(processw);

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
             * SetVisibility serve para ocultar ou deixar visivel um objeto*/
            progressBar.setVisibility(View.VISIBLE);
            info.setVisibility(View.INVISIBLE);
            infoM.setVisibility(View.INVISIBLE);

            processx = processx2;

            /**
             * try executa o código normalmente caso não hja erro
             * catch é um código de fuga caso haja erro dentro de try*/
            try {
                /** Esse código define o tamanho do texto*/
                info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));

                /** Esse código define a cor do texto*/
                info.setTextColor(getResources().getColor(R.color.black));

                /**
                 * O código dentro do Handler sofre um delay programado, só será executado
                 * depois de um tempo desejado*/
                new Handler().postDelayed(() -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    info.setVisibility(View.VISIBLE);
                    infoM.setVisibility(View.VISIBLE);
                },2000);

                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 0;
                fxCalculatorLayout.setLayoutParams(params);
                tecladox = false; tecladoy = false; tecladoz = false; tecladow = false;


                if (processx == null || processy == null || processz == null || processw == null){

                    info.setText(R.string.erro);
                    passos.setImageResource(R.drawable.ic_eye_lightblack);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                    layoutParams.height = 0;
                    layoutpassos.setLayoutParams(layoutParams);


                }else{

                    if (p_1.getText().toString().isEmpty() || p_2.getText().toString().isEmpty()){


                        calculoClick = true;

                        /**
                         * Replace pode substituir caracteres especificos por outros dentro de um texto*/

                        processx = processx.replace("√","sqrt");
                        processy = processy.replace("√","sqrt");
                        processz = processz.replace("√","sqrt");
                        processw = processw.replace("√","sqrt");


                        /**
                         * Inserindo nova variavel local tipo texto*/
                        String Entrada = processx;


                        processx = processx.replace("x","("+processy+")");
                        processx = processx.replace("y","("+processz+")");
                        processx = processx.replace("z","("+processw+")");


                        /**Chamando a classe Simplificar para processar as equações em formato de texto*/

                        CVSimplifyIntegral cvSimplifyIntegral = new CVSimplifyIntegral();
                        CVSimplifyIntegral cvIntegral = new CVSimplifyIntegral();

                        cvSimplifyIntegral.setFunctionSimplificar(processx);
                        cvSimplifyIntegral.simplificar();
                        String Integralprimeirasimplificacao = cvSimplifyIntegral.getFunctionSimplificada();

                        Integralprimeirasimplificacao = Integralprimeirasimplificacao.replace("√","sqrt");

                        cvSimplifyIntegral.setFunctionSimplificar("sqrt(("+processy+")^(2) + ("+processz+")^(2) + ("+processw+")^(2))");
                        cvSimplifyIntegral.simplificar();
                        String normadert = cvSimplifyIntegral.getFunctionSimplificada();

                        normadert = normadert.replace("√","sqrt");

                        cvIntegral.setFunctionIntegrar("("+Integralprimeirasimplificacao+")*("+normadert+")");
                        cvIntegral.integrar();
                        String resultadointegracao = cvIntegral.getFunctionIntegrar();


                        cvSimplifyIntegral.setFunctionSimplificar(resultadointegracao);
                        cvSimplifyIntegral.simplificar();
                        resultadointegracao = cvSimplifyIntegral.getFunctionSimplificada();

                        resultadointegracao = resultadointegracao.replace("sqrt","√");
                        normadert = normadert.replace("sqrt","√");





                        info.setText("∮ V(r(t)).|r(t)|.dt = "+resultadointegracao);

                        infoM.setText("V(x,y,z) = "+Entrada+"" +
                                "\n" +
                                "\n" +
                                "\n.. ∫ V(x,y,z).dS  = ∮ V(r(t)).|r(t)|.dt" +
                                "\n" +
                                "\n" +
                                "\n .. r(t) é a equação de parametrização " +
                                "\n" +
                                "\n .. r(t) = x(t)âx + y(t)ây + z(t)âz " +
                                "\n" +
                                "\n .. |r(t)| = √[x(t)^2 + y(t)^2 +z(t)^2]" +
                                "\n " +
                                "\n" +
                                "\n .. x(t) = "+processy+"" +
                                "\n .. y(t) = "+processz+"" +
                                "\n .. z(t) = "+processw+"" +
                                "\n " +
                                "\n .. V(r(t)) = "+processx+"" +
                                "\n" +
                                "\n .. V(r(t)) = "+Integralprimeirasimplificacao+"" +
                                "\n " +
                                "\n .. |r(t)| = "+normadert +"" +
                                "\n" +
                                "\n" +
                                "\n ∮ V(r(t)).|r(t)|.dt = "+resultadointegracao);





                        Passos();

                    }else{
                        calculoClick = true;


                        p1 = Double.parseDouble(p_1.getText().toString());
                        p2 = Double.parseDouble(p_2.getText().toString());

                        processx = processx.replace("√","sqrt");
                        processy = processy.replace("√","sqrt");
                        processz = processz.replace("√","sqrt");
                        processw = processw.replace("√","sqrt");



                        String Entrada = processx;


                        processx = processx.replace("x","("+processy+")");
                        processx = processx.replace("y","("+processz+")");
                        processx = processx.replace("z","("+processw+")");



                        CVSimplifyIntegral cvSimplifyIntegral = new CVSimplifyIntegral();
                        CVSimplifyIntegral cvIntegral = new CVSimplifyIntegral();

                        cvSimplifyIntegral.setFunctionSimplificar(processx);
                        cvSimplifyIntegral.simplificar();
                        String Integralprimeirasimplificacao = cvSimplifyIntegral.getFunctionSimplificada();

                        Integralprimeirasimplificacao = Integralprimeirasimplificacao.replace("√","sqrt");

                        cvSimplifyIntegral.setFunctionSimplificar("sqrt(("+processy+")^(2) + ("+processz+")^(2) + ("+processw+")^(2))");
                        cvSimplifyIntegral.simplificar();
                        String normadert = cvSimplifyIntegral.getFunctionSimplificada();

                        normadert = normadert.replace("√","sqrt");

                        cvIntegral.setFunctionIntegrar("("+Integralprimeirasimplificacao+")*("+normadert+")");
                        cvIntegral.integrar();
                        String resultadointegracao = cvIntegral.getFunctionIntegrar();




                        resultadointegracao = resultadointegracao.replace("√","sqrt");
                        resultadointegracao = resultadointegracao.replace("log(","log10(");

                        /**
                         * Expression é o avaliador de expressão, que retorna o valor da função f(x,y,z) para um
                         * ponto que definimos (x,y,z).*/

                        Expression ex = new ExpressionBuilder(resultadointegracao)
                                .variables("t")
                                .build()
                                .setVariable("t",p1);
                        double resultadop1 = ex.evaluate();

                        Expression ey = new ExpressionBuilder(resultadointegracao)
                                .variables("t")
                                .build()
                                .setVariable("t",p2);
                        double resultadop2 = ey.evaluate();

                        String mathresult = df.format(resultadop2 - resultadop1);

                        resultadointegracao = resultadointegracao.replace("sqrt","√");
                        normadert = normadert.replace("sqrt","√");





                        info.setText("∮ V(r(t)).|r(t)|.dt = "+mathresult);

                        infoM.setText("V(x,y,z) = "+Entrada+"" +
                                "\n" +
                                "\n" +
                                "\n.. ∫ V(x,y,z).dS  = ∮ V(r(t)).|r(t)|.dt" +
                                "\n" +
                                "\n" +
                                "\n .. r(t) é a equação de parametrização " +
                                "\n" +
                                "\n .. r(t) = x(t)âx + y(t)ây + z(t)âz " +
                                "\n" +
                                "\n .. |r(t)| = √[x(t)^2 + y(t)^2 +z(t)^2]" +
                                "\n " +
                                "\n" +
                                "\n .. x(t) = "+processy+"" +
                                "\n .. y(t) = "+processz+"" +
                                "\n .. z(t) = "+processw+"" +
                                "\n " +
                                "\n .. V(r(t)) = "+processx+"" +
                                "\n" +
                                "\n .. V(r(t)) = "+Integralprimeirasimplificacao+"" +
                                "\n " +
                                "\n .. |r(t)| = "+normadert +"" +
                                "\n" +
                                "\n" +
                                "\n ∮ V(r(t)).|r(t)|.dt = "+resultadointegracao+"" +
                                "\n" +
                                "\n" +
                                "\n Substituimos os valores dos limite de  " +
                                "\n integração do ponto P1, limite inferior, ao " +
                                "\n ponto P2, limite superior." +
                                "\n" +
                                "\n .. P2 = "+df.format(p2)+" e P1 = "+df.format(p1)+""+
                                "\n" +
                                "\n" +
                                "\n ∮ V(r(t)).|r(t)|.dt = "+mathresult);



                        Passos();



                    }



                }
            }
            catch (Exception e){
                new Handler().postDelayed(() -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    info.setVisibility(View.VISIBLE);
                    infoM.setVisibility(View.VISIBLE);
                },2000);

                info.setText(R.string.erro2);
                info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                info.setTextColor(getResources().getColor(R.color.black2));
                infoM.setText("");

                passos.setImageResource(R.drawable.ic_eye_lightblack);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                layoutParams.height = 0;
                layoutpassos.setLayoutParams(layoutParams);
            }
        });


    }

    /**
     * Tela de passo a passo fica visivel/invisivel*/
    protected void Passos(){


        if (counter == 1){
            //passos visivel
            passos.setOnClickListener(view -> {
                passos.setImageResource(R.drawable.ic_eye_azulestacao);
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