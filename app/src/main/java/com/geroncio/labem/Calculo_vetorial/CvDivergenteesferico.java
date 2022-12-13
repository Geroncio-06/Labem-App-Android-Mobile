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

public class CvDivergenteesferico extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpi, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btne, btnlog2, btnraiz, btnx2, btnxn, btnlog10, btnln, btnsin, btncos, btntan, btnsinh, btncosh, btntanh, btnx, btny,btnz;
    TextView txtimputx, txtimputy, txtimputz, info, infoM;
    EditText p_1 = null, p_2 = null, p_3 = null;
    Double p1 = null, p2 = null, p3 = null;
    String processx = null;
    String processy = null, processz = null;
    ProgressBar progress;
    android.widget.Button calcular;
    ImageButton fxCalculator, fyCalculator, fzCalculator;
    LinearLayout fxCalculatorLayout;
    LinearLayout.LayoutParams params;
    boolean tecladox = false, tecladoy = false, tecladoz = false;
    boolean calculoClick = false;
    LinearLayout layoutpassos;
    ImageButton voltar, passos;
    SharedPreferences preferences;
    String decimaisnum = "3";
    DecimalFormat df = new DecimalFormat("#0.0");
    ImageView ajuda;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_divergenteesferico);

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
                },200);

                Tecladoz();
            }

        });

        Calcular();
    }

    /**
     * Linkando variaveis globais com objetos na tela de layout*/
    private void Inicializate() {
        calcular = findViewById(R.id.calcular);
        fxCalculator = findViewById(R.id.calculator_fxvisible); fyCalculator = findViewById(R.id.calculator_fyvisible); fzCalculator = findViewById(R.id.calculator_fzvisible);
        fxCalculatorLayout = findViewById(R.id.calculadora_fx);
        info = findViewById(R.id.infoM);
        infoM = findViewById(R.id.passosresult);
        txtimputx = findViewById(R.id.btnimputx);
        txtimputy = findViewById(R.id.btnimputy);
        txtimputz = findViewById(R.id.btnimputz);
        p_1 = findViewById(R.id.p_1);
        p_2 = findViewById(R.id.p_2);
        p_3 = findViewById(R.id.p_3);
        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        progress = findViewById(R.id.progress);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "CvDivergenteesferico.class";
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
        btnlog2 = findViewById(R.id.gc_03);
        btnraiz = findViewById(R.id.gc_11);
        btnx2 = findViewById(R.id.gc_09);
        btnxn = findViewById(R.id.gc_10);
        btnlog10 = findViewById(R.id.gc_12);
        btnln = findViewById(R.id.gc_04);
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

        txtimputx = findViewById(R.id.btnimputx);
        txtimputy = findViewById(R.id.btnimputy);
        txtimputz = findViewById(R.id.btnimputz);



        btnx2.setText(Html.fromHtml(" x&sup2"));
        btnpi.setText(Html.fromHtml("&pi"));
    }

    private  void Teclado(){

        btnc.setOnClickListener(view -> {
            txtimputx.setText("");
            processx = null;

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

            if (calculoClick == true){info.setText("");}
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
        btnpi.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "π";
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
        btne.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "e";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnlog2.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "log2(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnln.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() +"ln(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnlog10.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() +"log(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btnx2.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() +"^(2)";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btnxn.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() +"^(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btnraiz.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "√(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnsin.setOnClickListener(view -> {

            processx = txtimputx.getText().toString() + "sin(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btncos.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "cos(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}

        });
        btntan.setOnClickListener(view -> {

            processx = txtimputx.getText().toString() + "tan(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnsinh.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "sinh(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btncosh.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "cosh(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btntanh.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "tanh(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnx.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "r";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "Ɵ";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnz.setOnClickListener(view -> {
            processx = txtimputx.getText().toString()+"ᵩ";
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

            if (calculoClick == true){info.setText("");}
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

            }
            else {
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
        btnx.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "r";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "Ɵ";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnz.setOnClickListener(view -> {
            processy = txtimputy.getText().toString()+"ᵩ";
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

            if (calculoClick == true){info.setText("");}
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

            }
            else {
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
        btnx.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "r";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "Ɵ";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnz.setOnClickListener(view -> {
            processz = txtimputz.getText().toString()+"ᵩ";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}


        });


    }

    /**
     * Código para executar os calculos*/
    @SuppressLint("SetTextI18n")
    private void Calcular(){

        /**
         * Definindo uma variavel para a classe Derivar, que retorna as derivadas de uma equação tipo texto*/
        Derivative der = new Derivative();
        DerivativeY derY = new DerivativeY();
        DerivativeZ derZ = new DerivativeZ();


        /**
         * Evento clicar em calcular*/
        calcular.setOnClickListener(view -> {

            params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
            params.height = 0;
            fxCalculatorLayout.setLayoutParams(params);
            tecladox = false; tecladoy = false; tecladoz = false;


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

                    if (processx == null || processy == null || processz == null){

                        info.setText(R.string.erro);
                        passos.setImageResource(R.drawable.ic_eye_lightblack);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                        layoutParams.height = 0;
                        layoutpassos.setLayoutParams(layoutParams);

                    }
                    else{

                        if (p_1.getText().toString().isEmpty() || p_2.getText().toString().isEmpty()|| p_3.getText().toString().isEmpty()){

                            calculoClick = true;

                            /**
                             * Replace pode substituir caracteres especificos por outros dentro de um texto*/

                            processx = processx.replace("r","x");
                            processx = processx.replace("Ɵ","y");
                            processx = processx.replace("ᵩ","z");

                            processy = processy.replace("r","x");
                            processy = processy.replace("Ɵ","y");
                            processy = processy.replace("ᵩ","z");

                            processz = processz.replace("r","x");
                            processz = processz.replace("Ɵ","y");
                            processz = processz.replace("ᵩ","z");

                            processx = processx.replace("√","sqrt");
                            processy = processy.replace("√","sqrt");
                            processz = processz.replace("√","sqrt");

                            processx = processx.replace("π","3.14159265");
                            processy = processy.replace("π","3.14159265");
                            processz = processz.replace("π","3.14159265");


                            /**Chamando a classe Simplificar para processar as equações em formato de texto*/

                            CVSimplify cvProcess = new CVSimplify();
                            cvProcess.setFunctionSimplificar("(x^(2))*("+processx+")");
                            cvProcess.simplificar();
                            String nProcessx = cvProcess.getFunctionSimplificada();

                            CVSimplify cvProcessy = new CVSimplify();
                            cvProcessy.setFunctionSimplificar("sin(y)*("+processy+")");
                            cvProcessy.simplificar();
                            String nProcessy = cvProcessy.getFunctionSimplificada();

                            CVSimplify cvProcessz = new CVSimplify();
                            cvProcessz.setFunctionSimplificar("("+processz+")");
                            cvProcessz.simplificar();
                            String nProcessz = cvProcessz.getFunctionSimplificada();


                            der.setFunctionDerivar(nProcessx);
                            der.derivar();

                            derY.setFunctionDerivar(nProcessy);
                            derY.derivar();

                            derZ.setFunctionDerivar(nProcessz);
                            derZ.derivar();

                            String processarSaida = der.getFunctionDerivada();
                            String processarSaidaY = derY.getFunctionDerivada();
                            String processarSaidaZ = derZ.getFunctionDerivada();

                            if (processarSaida == null || processarSaidaY == null || processarSaidaZ == null){
                                info.setText(R.string.erro);
                                passos.setImageResource(R.drawable.ic_eye_lightblack);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                                layoutParams.height = 0;
                                layoutpassos.setLayoutParams(layoutParams);
                                return;
                            }

                            String processarSaidaDerivada = der.getFunctionDerivada();
                            String processarSaidaDerivadaY = derY.getFunctionDerivada();
                            String processarSaidaDerivadaZ = derZ.getFunctionDerivada();

                            CVSimplify cvSimplify = new CVSimplify();
                            cvSimplify.setFunctionSimplificar("(1/(x^(2)))*("+processarSaidaDerivada+")");
                            cvSimplify.simplificar();
                            processarSaidaDerivada = cvSimplify.getFunctionSimplificada();




                            cvSimplify.setFunctionSimplificar("(1/(x*sin(y)))*("+processarSaidaDerivadaY+")");
                            cvSimplify.simplificar();
                            processarSaidaDerivadaY = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar("(1/(x*sin(y)))*("+processarSaidaDerivadaZ+")");
                            cvSimplify.simplificar();
                            processarSaidaDerivadaZ = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivada+"+"+processarSaidaDerivadaY+"+"+processarSaidaDerivadaZ);
                            cvSimplify.simplificar();
                            String ResultadoFinalProcessado = cvSimplify.getFunctionSimplificada();



                            processarSaidaDerivada = processarSaidaDerivada.replace("sqrt","√");
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("sqrt","√");
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("sqrt","√");
                            ResultadoFinalProcessado = ResultadoFinalProcessado.replace("sqrt","√");


                            processx = processx.replace("sqrt","√");
                            processy = processy.replace("sqrt","√");
                            processz = processz.replace("sqrt","√");

                            processx = processx.replace("x","r");
                            processx = processx.replace("y","Ɵ");
                            processx = processx.replace("z","ᵩ");

                            processy = processy.replace("x","r");
                            processy = processy.replace("y","Ɵ");
                            processy = processy.replace("z","ᵩ");

                            processz = processz.replace("x","r");
                            processz = processz.replace("y","Ɵ");
                            processz = processz.replace("z","ᵩ");

                            processarSaida = processarSaida.replace("x","r");processarSaida = processarSaida.replace("y","Ɵ");processarSaida = processarSaida.replace("z","ᵩ");
                            processarSaidaY = processarSaidaY.replace("x","r");processarSaidaY = processarSaidaY.replace("y","Ɵ");processarSaidaY = processarSaidaY.replace("z","ᵩ");
                            processarSaidaZ = processarSaidaZ.replace("x","r");processarSaidaZ = processarSaidaZ.replace("y","Ɵ");processarSaidaZ = processarSaidaZ.replace("z","ᵩ");
                            processarSaida = processarSaida.replace("sqrt","√");
                            processarSaidaY = processarSaidaY.replace("sqrt","√");
                            processarSaidaZ = processarSaidaZ.replace("sqrt","√");

                            processarSaidaDerivada = processarSaidaDerivada.replace("x","r");processarSaidaDerivada = processarSaidaDerivada.replace("y","Ɵ");processarSaidaDerivada = processarSaidaDerivada.replace("z","ᵩ");
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("x","r");processarSaidaDerivadaY = processarSaidaDerivadaY.replace("y","Ɵ");processarSaidaDerivadaY = processarSaidaDerivadaY.replace("z","ᵩ");
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("x","r");processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("y","Ɵ");processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("z","ᵩ");
                            ResultadoFinalProcessado = ResultadoFinalProcessado.replace("x","r");ResultadoFinalProcessado = ResultadoFinalProcessado.replace("y","Ɵ");ResultadoFinalProcessado = ResultadoFinalProcessado.replace("z","ᵩ");



                            info.setText(Html.fromHtml("∇.<b>Ä</b> = "+ResultadoFinalProcessado));


                            infoM.setText(Html.fromHtml("<b>Ä(r,Ɵ,ᵩ)</b> = "+processx+"<b>âr</b> +" +
                                    "<br> .. "+processy+"<b>âƟ</b> + " +
                                    "<br> .. "+processz+"<b>âᵩ</b>"+
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇.<b>Ä</b> = (1/r<sup>2</sup>)*[∂(r<sup>2</sup>*Ä)/∂r] " +
                                    "<br> ......... + (1/r*sinƟ)*[∂(Ä*sinƟ)/∂Ɵ]" +
                                    "<br> ......... + (1/r*sinƟ)*[∂Ä/∂ᵩ]" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> ∇.<b>Ä</b> = " +
                                    "<br> .. (1/r<sup>2</sup>)*(∂/∂r)[("+processx+")*r<sup>2</sup>] + " +
                                    "<br>" +
                                    "<br> .. (1/r*sinƟ)*(∂/∂ᵩ)[("+processy+")*sinƟ] + " +
                                    "<br>" +
                                    "<br> .. (1/r*sinƟ)*(∂/∂ᵩ)["+processz+"] " +
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇.<b>Ä</b> = " +
                                    "<br> .. (1/r<sup>2</sup>)*["+processarSaida+"]" +
                                    "<br>+ " +
                                    "<br> .. (1/r*sinƟ)*["+ processarSaidaY+ "]" +
                                    "<br>+ " +
                                    "<br> .. (1/r*sinƟ)*["+processarSaidaZ+"]"+
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇.<b>Ä</b> = [ "+processarSaidaDerivada+" ] " +
                                    "<br>+ " +
                                    "<br> .. [ "+ processarSaidaDerivadaY+ " ] " +
                                    "<br>+ " +
                                    "<br> .. [ "+processarSaidaDerivadaZ+" ] "+
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇.<b>Ä</b> = [ "+ResultadoFinalProcessado+" ]"));


                            Passos();

                        }
                        else{

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p2 = Double.parseDouble(p_2.getText().toString());
                            p3 = Double.parseDouble(p_3.getText().toString());

                            calculoClick = true;

                            processx = processx.replace("r","x");
                            processx = processx.replace("Ɵ","y");
                            processx = processx.replace("ᵩ","z");

                            processy = processy.replace("r","x");
                            processy = processy.replace("Ɵ","y");
                            processy = processy.replace("ᵩ","z");

                            processz = processz.replace("r","x");
                            processz = processz.replace("Ɵ","y");
                            processz = processz.replace("ᵩ","z");

                            processx = processx.replace("√","sqrt");
                            processy = processy.replace("√","sqrt");
                            processz = processz.replace("√","sqrt");

                            processx = processx.replace("π","3.14159265");
                            processy = processy.replace("π","3.14159265");
                            processz = processz.replace("π","3.14159265");


                            CVSimplify cvProcess = new CVSimplify();
                            cvProcess.setFunctionSimplificar("(x^(2))*("+processx+")");
                            cvProcess.simplificar();
                            String nProcessx = cvProcess.getFunctionSimplificada();

                            CVSimplify cvProcessy = new CVSimplify();
                            cvProcessy.setFunctionSimplificar("sin(y)*("+processy+")");
                            cvProcessy.simplificar();
                            String nProcessy = cvProcessy.getFunctionSimplificada();

                            CVSimplify cvProcessz = new CVSimplify();
                            cvProcessz.setFunctionSimplificar("("+processz+")");
                            cvProcessz.simplificar();
                            String nProcessz = cvProcessz.getFunctionSimplificada();


                            der.setFunctionDerivar(nProcessx);
                            der.derivar();

                            derY.setFunctionDerivar(nProcessy);
                            derY.derivar();

                            derZ.setFunctionDerivar(nProcessz);
                            derZ.derivar();

                            String processarSaida = der.getFunctionDerivada();
                            String processarSaidaY = derY.getFunctionDerivada();
                            String processarSaidaZ = derZ.getFunctionDerivada();

                            if (processarSaida == null || processarSaidaY == null || processarSaidaZ == null){
                                info.setText(R.string.erro);
                                passos.setImageResource(R.drawable.ic_eye_lightblack);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                                layoutParams.height = 0;
                                layoutpassos.setLayoutParams(layoutParams);
                                return;
                            }

                            String processarSaidaDerivada = der.getFunctionDerivada();
                            String processarSaidaDerivadaY = derY.getFunctionDerivada();
                            String processarSaidaDerivadaZ = derZ.getFunctionDerivada();

                            CVSimplify cvSimplify = new CVSimplify();
                            cvSimplify.setFunctionSimplificar("(1/(x^(2)))*("+processarSaidaDerivada+")");
                            cvSimplify.simplificar();
                            processarSaidaDerivada = cvSimplify.getFunctionSimplificada();




                            cvSimplify.setFunctionSimplificar("(1/(x*sin(y)))*("+processarSaidaDerivadaY+")");
                            cvSimplify.simplificar();
                            processarSaidaDerivadaY = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar("(1/(x*sin(y)))*("+processarSaidaDerivadaZ+")");
                            cvSimplify.simplificar();
                            processarSaidaDerivadaZ = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivada+"+"+processarSaidaDerivadaY+"+"+processarSaidaDerivadaZ);
                            cvSimplify.simplificar();
                            String ResultadoFinalProcessado = cvSimplify.getFunctionSimplificada();
                            String saidaRFP = cvSimplify.getFunctionSimplificadaAlt();

                            ResultadoFinalProcessado = ResultadoFinalProcessado.replace("√","sqrt");

                            saidaRFP = saidaRFP.replace("√","sqrt");
                            saidaRFP = saidaRFP.replace("log(","log10(");

                            /**
                             * Expression é o avaliador de expressão, que retorna o valor da função f(x,y,z) para um
                             * ponto que definimos (x,y,z).*/

                            Expression ex = new ExpressionBuilder(saidaRFP)
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultadoprocessado = ex.evaluate();

                            String resultado = df.format(resultadoprocessado);
                            resultado = resultado.replace(",",".");

                            processarSaidaDerivada = processarSaidaDerivada.replace("sqrt","√");
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("sqrt","√");
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("sqrt","√");
                            ResultadoFinalProcessado = ResultadoFinalProcessado.replace("sqrt","√");


                            processx = processx.replace("sqrt","√");
                            processy = processy.replace("sqrt","√");
                            processz = processz.replace("sqrt","√");

                            processx = processx.replace("x","r");
                            processx = processx.replace("y","Ɵ");
                            processx = processx.replace("z","ᵩ");

                            processy = processy.replace("x","r");
                            processy = processy.replace("y","Ɵ");
                            processy = processy.replace("z","ᵩ");

                            processz = processz.replace("x","r");
                            processz = processz.replace("y","Ɵ");
                            processz = processz.replace("z","ᵩ");

                            processarSaida = processarSaida.replace("x","r");processarSaida = processarSaida.replace("y","Ɵ");processarSaida = processarSaida.replace("z","ᵩ");
                            processarSaidaY = processarSaidaY.replace("x","r");processarSaidaY = processarSaidaY.replace("y","Ɵ");processarSaidaY = processarSaidaY.replace("z","ᵩ");
                            processarSaidaZ = processarSaidaZ.replace("x","r");processarSaidaZ = processarSaidaZ.replace("y","Ɵ");processarSaidaZ = processarSaidaZ.replace("z","ᵩ");
                            processarSaida = processarSaida.replace("sqrt","√");
                            processarSaidaY = processarSaidaY.replace("sqrt","√");
                            processarSaidaZ = processarSaidaZ.replace("sqrt","√");

                            processarSaidaDerivada = processarSaidaDerivada.replace("x","r");processarSaidaDerivada = processarSaidaDerivada.replace("y","Ɵ");processarSaidaDerivada = processarSaidaDerivada.replace("z","ᵩ");
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("x","r");processarSaidaDerivadaY = processarSaidaDerivadaY.replace("y","Ɵ");processarSaidaDerivadaY = processarSaidaDerivadaY.replace("z","ᵩ");
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("x","r");processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("y","Ɵ");processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("z","ᵩ");
                            ResultadoFinalProcessado = ResultadoFinalProcessado.replace("x","r");ResultadoFinalProcessado = ResultadoFinalProcessado.replace("y","Ɵ");ResultadoFinalProcessado = ResultadoFinalProcessado.replace("z","ᵩ");





                            info.setText(Html.fromHtml("∇.<b>Ä</b> = "+resultado));


                            infoM.setText(Html.fromHtml("<b>Ä(r,Ɵ,ᵩ)</b> = "+processx+"<b>âr</b> +" +
                                    "<br> .. "+processy+"<b>âƟ</b> + " +
                                    "<br> .. "+processz+"<b>âᵩ</b>"+
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇.<b>Ä</b> = (1/r<sup>2</sup>)*[∂(r<sup>2</sup>*Ä)/∂r] " +
                                    "<br> ......... + (1/r*sinƟ)*[∂(Ä*sinƟ)/∂Ɵ]" +
                                    "<br> ......... + (1/r*sinƟ)*[∂Ä/∂ᵩ]" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> ∇.<b>Ä</b> = " +
                                    "<br> .. (1/r<sup>2</sup>)*(∂/∂r)[("+processx+")*r<sup>2</sup>] + " +
                                    "<br>" +
                                    "<br> .. (1/r*sinƟ)*(∂/∂ᵩ)[("+processy+")*sinƟ] + " +
                                    "<br>" +
                                    "<br> .. (1/r*sinƟ)*(∂/∂ᵩ)["+processz+"] " +
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇.<b>Ä</b> = " +
                                    "<br> .. (1/r<sup>2</sup>)*["+processarSaida+"]" +
                                    "<br>+ " +
                                    "<br> .. (1/r*sinƟ)*["+ processarSaidaY+ "]" +
                                    "<br>+ " +
                                    "<br> .. (1/r*sinƟ)*["+processarSaidaZ+"]"+
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇.<b>Ä</b> = [ "+processarSaidaDerivada+" ] " +
                                    "<br>+ " +
                                    "<br> .. [ "+ processarSaidaDerivadaY+ " ] " +
                                    "<br>+ " +
                                    "<br> .. [ "+processarSaidaDerivadaZ+" ] "+
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇.<b>Ä</b> = [ "+ResultadoFinalProcessado+" ]" +
                                    "<br>" +
                                    "<br> Substituimos os valores de r, Ɵ e ᵩ, com os  " +
                                    "<br> ângulos em rad, do ponto <b>P</b> na resposta do divergente ∇.<b>Ä</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇.<b>Ä</b> = "+resultado));

                            Passos();
                        }

                    }
                }
                catch (Exception e){

                    info.setText(R.string.erro2);
                    info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                    info.setTextColor(getResources().getColor(R.color.black2));
                    infoM.setText("");

                    passos.setImageResource(R.drawable.ic_eye_lightblack);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                    layoutParams.height = 0;
                    layoutpassos.setLayoutParams(layoutParams);
                }

                /**
                 * Objeto de carregamento fica invisivel na tela*/
                progress.setVisibility(View.INVISIBLE);

            },1000);



        });


    }

    /**
     * Objeto de carregamento fica invisivel*/
    protected void Passos(){


        if (counter == 1){
            //passos visivel
            passos.setOnClickListener(view -> {
                passos.setImageResource(R.drawable.ic_eye_azulestacao);
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