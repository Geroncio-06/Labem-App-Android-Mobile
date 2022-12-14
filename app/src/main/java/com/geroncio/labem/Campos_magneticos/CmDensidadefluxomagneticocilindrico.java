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
import android.widget.TextView;

import com.geroncio.labem.Calculo_vetorial.CVSimplify;
import com.geroncio.labem.Calculo_vetorial.Calculo_vetorial;
import com.geroncio.labem.Derivadas.Derivative;
import com.geroncio.labem.Derivadas.DerivativeY;
import com.geroncio.labem.Derivadas.DerivativeZ;
import com.geroncio.labem.Others.Info;
import com.geroncio.labem.R;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class CmDensidadefluxomagneticocilindrico extends AppCompatActivity {

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
        setContentView(R.layout.activity_cm_densidadefluxomagneticocilindrico);

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
            String main = "CmDensidadefluxomagneticocilindrico.class";
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
        btnpi.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "??";
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
            processx = txtimputx.getText().toString() + "???(";
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
            processx = txtimputx.getText().toString() + "???";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "???";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnz.setOnClickListener(view -> {
            processx = txtimputx.getText().toString()+"z";
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
            processy = txtimputy.getText().toString() + "??";
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
            processy = txtimputy.getText().toString() + "???(";
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
            processy = txtimputy.getText().toString() + "???";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "???";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnz.setOnClickListener(view -> {
            processy = txtimputy.getText().toString()+"z";
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
            processz = txtimputz.getText().toString() + "??";
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
            processz = txtimputz.getText().toString() + "???(";
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
            processz = txtimputz.getText().toString() + "???";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "???";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnz.setOnClickListener(view -> {
            processz = txtimputz.getText().toString()+"z";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}


        });






    }

    @SuppressLint("SetTextI18n")
    private void Calcular(){

        DerivativeY derXY = new DerivativeY();
        DerivativeZ derXZ = new DerivativeZ();
        Derivative derYX = new Derivative();
        DerivativeZ derYZ = new DerivativeZ();
        Derivative derZX = new Derivative();
        DerivativeY derZY = new DerivativeY();



        calcular.setOnClickListener(view -> {

            progress.setVisibility(View.VISIBLE);
            info.setText("");

            new Handler().postDelayed(() -> {

                try {
                    params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                    params.height = 0;
                    fxCalculatorLayout.setLayoutParams(params);
                    tecladox = false; tecladoy = false; tecladoz = false;
                    info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                    info.setTextColor(getResources().getColor(R.color.black));


                    if (processx == null || processy == null || processz == null){
                        if (p_1.getText().toString().isEmpty() || p_2.getText().toString().isEmpty()|| p_3.getText().toString().isEmpty()){

                            info.setText(R.string.erro);
                            passos.setImageResource(R.drawable.ic_eye_lightblack);
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                            layoutParams.height = 0;
                            layoutpassos.setLayoutParams(layoutParams);

                        }
                        else{
                            info.setText(R.string.erro);
                            passos.setImageResource(R.drawable.ic_eye_lightblack);
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                            layoutParams.height = 0;
                            layoutpassos.setLayoutParams(layoutParams);
                        }

                    }
                    else{

                        if (p_1.getText().toString().isEmpty() || p_2.getText().toString().isEmpty()|| p_3.getText().toString().isEmpty()){

                            processx = processx.replace("???","sqrt");
                            processy = processy.replace("???","sqrt");
                            processz = processz.replace("???","sqrt");
                            processx = processx.replace("??","3.14159265");
                            processy = processy.replace("??","3.14159265");
                            processz = processz.replace("??","3.14159265");

                            processx = processx.replace("???","x");processx = processx.replace("???","y");
                            processy = processy.replace("???","x");processy = processy.replace("???","y");
                            processz = processz.replace("???","x");processz = processz.replace("???","y");

                            CVSimplify cvProcess = new CVSimplify();
                            cvProcess.setFunctionSimplificar(processx);
                            cvProcess.simplificar();
                            String nProcessx = cvProcess.getFunctionSimplificada();

                            CVSimplify cvProcessy = new CVSimplify();
                            cvProcessy.setFunctionSimplificar(processy);
                            cvProcessy.simplificar();
                            String nProcessy = cvProcessy.getFunctionSimplificada();

                            CVSimplify cvProcessy2 = new CVSimplify();
                            cvProcessy2.setFunctionSimplificar("x*("+processy+")");
                            cvProcessy2.simplificar();
                            String nProcessy2 = cvProcessy2.getFunctionSimplificada();

                            CVSimplify cvProcessz = new CVSimplify();
                            cvProcessz.setFunctionSimplificar(processz);
                            cvProcessz.simplificar();
                            String nProcessz = cvProcessz.getFunctionSimplificada();


                            derZY.setFunctionDerivar(nProcessz);
                            derZY.derivar();

                            derYZ.setFunctionDerivar(nProcessy);
                            derYZ.derivar();

                            derXZ.setFunctionDerivar(nProcessx);
                            derXZ.derivar();

                            derZX.setFunctionDerivar(nProcessz);
                            derZX.derivar();

                            derYX.setFunctionDerivar(nProcessy2);
                            derYX.derivar();

                            derXY.setFunctionDerivar(nProcessx);
                            derXY.derivar();

                            String processarSaidaZY = derZY.getFunctionDerivada();
                            String processarSaidaYZ = derYZ.getFunctionDerivada();
                            String processarSaidaXZ = derXZ.getFunctionDerivada();
                            String processarSaidaZX = derZX.getFunctionDerivada();
                            String processarSaidaYX = derYX.getFunctionDerivada();
                            String processarSaidaXY = derXY.getFunctionDerivada();

                            if (processarSaidaZY == null || processarSaidaYZ == null || processarSaidaXZ == null
                                    ||processarSaidaZX == null || processarSaidaYX == null || processarSaidaXY == null ){
                                info.setText(R.string.erro);
                                passos.setImageResource(R.drawable.ic_eye_lightblack);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                                layoutParams.height = 0;
                                layoutpassos.setLayoutParams(layoutParams);
                                return;
                            }

                            String processarSaidaDerivadaZY = derZY.getFunctionDerivada();
                            String processarSaidaDerivadaYZ = derYZ.getFunctionDerivada();
                            String processarSaidaDerivadaXZ = derXZ.getFunctionDerivada();
                            String processarSaidaDerivadaZX = derZX.getFunctionDerivada();
                            String processarSaidaDerivadaYX = derYX.getFunctionDerivada();
                            String processarSaidaDerivadaXY = derXY.getFunctionDerivada();

                            CVSimplify cvSimplify = new CVSimplify();
                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaZY);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaZY = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaYZ);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaYZ = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaXZ);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaXZ = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaZX);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaZX = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaYX);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaYX = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaXY);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaXY = cvSimplify.getFunctionSimplificada();

                            processarSaidaDerivadaZY = processarSaidaDerivadaZY.replace("???","sqrt");
                            processarSaidaDerivadaYZ = processarSaidaDerivadaYZ.replace("???","sqrt");
                            processarSaidaDerivadaXZ = processarSaidaDerivadaXZ.replace("???","sqrt");
                            processarSaidaDerivadaZX = processarSaidaDerivadaZX.replace("???","sqrt");
                            processarSaidaDerivadaYX = processarSaidaDerivadaYX.replace("???","sqrt");
                            processarSaidaDerivadaXY = processarSaidaDerivadaXY.replace("???","sqrt");


                            cvSimplify.setFunctionSimplificar("(1/x)*("+processarSaidaDerivadaZY+")-("+processarSaidaDerivadaYZ+")");
                            cvSimplify.simplificar();
                            String ResultadoAX = cvSimplify.getFunctionSimplificada();

                            cvSimplify.setFunctionSimplificar("("+processarSaidaDerivadaXZ+")-("+processarSaidaDerivadaZX+")");
                            cvSimplify.simplificar();
                            String ResultadoAY = cvSimplify.getFunctionSimplificada();

                            cvSimplify.setFunctionSimplificar("(1/x)*[("+processarSaidaDerivadaYX+")-("+processarSaidaDerivadaXY+")]");
                            cvSimplify.simplificar();
                            String ResultadoAZ = cvSimplify.getFunctionSimplificada();

                            processarSaidaDerivadaZY = processarSaidaDerivadaZY.replace("sqrt","???");
                            processarSaidaDerivadaYZ = processarSaidaDerivadaYZ.replace("sqrt","???");
                            processarSaidaDerivadaXZ = processarSaidaDerivadaXZ.replace("sqrt","???");
                            processarSaidaDerivadaZX = processarSaidaDerivadaZX.replace("sqrt","???");
                            processarSaidaDerivadaYX = processarSaidaDerivadaYX.replace("sqrt","???");
                            processarSaidaDerivadaXY = processarSaidaDerivadaXY.replace("sqrt","???");
                            ResultadoAX = ResultadoAX.replace("sqrt","???");
                            ResultadoAY = ResultadoAY.replace("sqrt","???");
                            ResultadoAZ = ResultadoAZ.replace("sqrt","???");


                            processarSaidaZY = processarSaidaZY.replace("sqrt","???");
                            processarSaidaYZ = processarSaidaYZ.replace("sqrt","???");
                            processarSaidaXZ = processarSaidaXZ.replace("sqrt","???");
                            processarSaidaZX = processarSaidaZX.replace("sqrt","???");
                            processarSaidaYX = processarSaidaYX.replace("sqrt","???");
                            processarSaidaXY = processarSaidaXY.replace("sqrt","???");


                            processx = processx.replace("sqrt","???");
                            processy = processy.replace("sqrt","???");
                            processz = processz.replace("sqrt","???");

                            processx = processx.replace("x","???");processx = processx.replace("y","???");
                            processy = processy.replace("x","???");processy = processy.replace("y","???");
                            processz = processz.replace("x","???");processz = processz.replace("y","???");

                            processarSaidaDerivadaZY = processarSaidaDerivadaZY.replace("x","???");processarSaidaDerivadaZY = processarSaidaDerivadaZY.replace("y","???");
                            processarSaidaDerivadaYZ = processarSaidaDerivadaYZ.replace("x","???");processarSaidaDerivadaYZ = processarSaidaDerivadaYZ.replace("y","???");
                            processarSaidaDerivadaXZ = processarSaidaDerivadaXZ.replace("x","???");processarSaidaDerivadaXZ = processarSaidaDerivadaXZ.replace("y","???");
                            processarSaidaDerivadaZX = processarSaidaDerivadaZX.replace("x","???");processarSaidaDerivadaZX = processarSaidaDerivadaZX.replace("y","???");
                            processarSaidaDerivadaYX = processarSaidaDerivadaYX.replace("x","???");processarSaidaDerivadaYX = processarSaidaDerivadaYX.replace("y","???");
                            processarSaidaDerivadaXY = processarSaidaDerivadaXY.replace("x","???");processarSaidaDerivadaXY = processarSaidaDerivadaXY.replace("y","???");

                            ResultadoAX = ResultadoAX.replace("x","???");ResultadoAX = ResultadoAX.replace("y","???");
                            ResultadoAY = ResultadoAY.replace("x","???");ResultadoAY = ResultadoAY.replace("y","???");
                            ResultadoAZ = ResultadoAZ.replace("x","???");ResultadoAZ = ResultadoAZ.replace("y","???");

                            processarSaidaZY = processarSaidaZY.replace("x","???");processarSaidaZY = processarSaidaZY.replace("y","???");
                            processarSaidaYZ = processarSaidaYZ.replace("x","???");processarSaidaYZ = processarSaidaYZ.replace("y","???");
                            processarSaidaXZ = processarSaidaXZ.replace("x","???");processarSaidaXZ = processarSaidaXZ.replace("y","???");
                            processarSaidaZX = processarSaidaZX.replace("x","???");processarSaidaZX = processarSaidaZX.replace("y","???");
                            processarSaidaYX = processarSaidaYX.replace("x","???");processarSaidaYX = processarSaidaYX.replace("y","???");
                            processarSaidaXY = processarSaidaXY.replace("x","???");processarSaidaXY = processarSaidaXY.replace("y","???");



                            info.setText(Html.fromHtml("<b>B</b> = ???x<b>??</b>" +
                                    "<br>" +
                                    "???x<b>??</b> = ["+ResultadoAX+"]<b>?????</b> " +
                                    "<br> + " +
                                    "<br> .. ["+ResultadoAY+"]<b>?????</b> " +
                                    "<br> + " +
                                    "<br> .. ["+ResultadoAZ+"]<b>??z</b> "));


                            infoM.setText(Html.fromHtml("<b>??(???,???,z)</b> = "+processx+"<b>?????</b> +" +
                                    "<br> .. "+processy+"<b>?????</b> + " +
                                    "<br> .. "+processz+"<b>??z</b>"+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>B</b> = ???x<b>??</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>???x<b>??</b> = [(1/???)*(?????z/??????) - (????????/???z)]<b>?????</b> +" +
                                    "<br> ..... [(????????/???z) - (?????z/??????)]<b>?????</b> +" +
                                    "<br> ..... (1/???)*[(???(???*?????)/??????) - (????????/??????)]<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> ???x<b>??</b> = " +
                                    "<br> .. {(1/???)*(???/??????)["+processz+"] - " +
                                    "<br> ..... (???/???z)["+processy+"]}<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. {(???/???z)["+processx+"] - " +
                                    "<br> ..... (???/??????)["+processz+"]}<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. (1/???)*{(???/??????)[???*("+processy+")] - " +
                                    "<br> ..... (???/??????)["+processx+"]}<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>B</b> = " +
                                    "<br> .. { (1/???)*["+processarSaidaZY+"] - " +
                                    "<br> ..... ["+processarSaidaYZ+"] }<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. { ["+ processarSaidaXZ+"] - " +
                                    "<br> ..... ["+processarSaidaZX+"] }<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. (1/???)*{ ["+processarSaidaYX+"] - " +
                                    "<br> ..... ["+processarSaidaXY+"] }<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>B</b> =  " +
                                    "<br> .. { ["+processarSaidaDerivadaZY+"] - " +
                                    "<br> ..... ["+processarSaidaDerivadaYZ+"] }<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. { ["+ processarSaidaDerivadaXZ+"] - " +
                                    "<br> ..... ["+processarSaidaDerivadaZX+"] }<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. { ["+processarSaidaDerivadaYX+"] - " +
                                    "<br> ..... ["+processarSaidaDerivadaXY+"] }<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>B</b> = ["+ResultadoAX+"]<b>?????</b> " +
                                    "<br> + " +
                                    "<br> .. ["+ResultadoAY+"]<b>?????</b> " +
                                    "<br> + " +
                                    "<br> .. ["+ResultadoAZ+"]<b>??z</b> "));


                            Passos();

                        }
                        else{

                            p1 = Double.parseDouble(p_1.getText().toString());
                            p2 = Double.parseDouble(p_2.getText().toString());
                            p3 = Double.parseDouble(p_3.getText().toString());
                            processx = processx.replace("??","3.14159265");
                            processy = processy.replace("??","3.14159265");
                            processz = processz.replace("??","3.14159265");

                            calculoClick = true;

                            processx = processx.replace("???","sqrt");
                            processy = processy.replace("???","sqrt");
                            processz = processz.replace("???","sqrt");

                            processx = processx.replace("???","x");processx = processx.replace("???","y");
                            processy = processy.replace("???","x");processy = processy.replace("???","y");
                            processz = processz.replace("???","x");processz = processz.replace("???","y");


                            CVSimplify cvProcess = new CVSimplify();
                            cvProcess.setFunctionSimplificar(processx);
                            cvProcess.simplificar();
                            String nProcessx = cvProcess.getFunctionSimplificada();

                            CVSimplify cvProcessy = new CVSimplify();
                            cvProcessy.setFunctionSimplificar(processy);
                            cvProcessy.simplificar();
                            String nProcessy = cvProcessy.getFunctionSimplificada();

                            CVSimplify cvProcessy2 = new CVSimplify();
                            cvProcessy2.setFunctionSimplificar("x*("+processy+")");
                            cvProcessy2.simplificar();
                            String nProcessy2 = cvProcessy2.getFunctionSimplificada();

                            CVSimplify cvProcessz = new CVSimplify();
                            cvProcessz.setFunctionSimplificar(processz);
                            cvProcessz.simplificar();
                            String nProcessz = cvProcessz.getFunctionSimplificada();


                            derZY.setFunctionDerivar(nProcessz);
                            derZY.derivar();

                            derYZ.setFunctionDerivar(nProcessy);
                            derYZ.derivar();

                            derXZ.setFunctionDerivar(nProcessx);
                            derXZ.derivar();

                            derZX.setFunctionDerivar(nProcessz);
                            derZX.derivar();

                            derYX.setFunctionDerivar(nProcessy2);
                            derYX.derivar();

                            derXY.setFunctionDerivar(nProcessx);
                            derXY.derivar();

                            String processarSaidaZY = derZY.getFunctionDerivada();
                            String processarSaidaYZ = derYZ.getFunctionDerivada();
                            String processarSaidaXZ = derXZ.getFunctionDerivada();
                            String processarSaidaZX = derZX.getFunctionDerivada();
                            String processarSaidaYX = derYX.getFunctionDerivada();
                            String processarSaidaXY = derXY.getFunctionDerivada();

                            if (processarSaidaZY == null || processarSaidaYZ == null || processarSaidaXZ == null
                                    ||processarSaidaZX == null || processarSaidaYX == null || processarSaidaXY == null ){
                                info.setText(R.string.erro);
                                passos.setImageResource(R.drawable.ic_eye_lightblack);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                                layoutParams.height = 0;
                                layoutpassos.setLayoutParams(layoutParams);
                                return;
                            }

                            String processarSaidaDerivadaZY = derZY.getFunctionDerivada();
                            String processarSaidaDerivadaYZ = derYZ.getFunctionDerivada();
                            String processarSaidaDerivadaXZ = derXZ.getFunctionDerivada();
                            String processarSaidaDerivadaZX = derZX.getFunctionDerivada();
                            String processarSaidaDerivadaYX = derYX.getFunctionDerivada();
                            String processarSaidaDerivadaXY = derXY.getFunctionDerivada();

                            CVSimplify cvSimplify = new CVSimplify();
                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaZY);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaZY = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaYZ);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaYZ = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaXZ);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaXZ = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaZX);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaZX = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaYX);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaYX = cvSimplify.getFunctionSimplificada();


                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaXY);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaXY = cvSimplify.getFunctionSimplificada();

                            processarSaidaDerivadaZY = processarSaidaDerivadaZY.replace("???","sqrt");
                            processarSaidaDerivadaYZ = processarSaidaDerivadaYZ.replace("???","sqrt");
                            processarSaidaDerivadaXZ = processarSaidaDerivadaXZ.replace("???","sqrt");
                            processarSaidaDerivadaZX = processarSaidaDerivadaZX.replace("???","sqrt");
                            processarSaidaDerivadaYX = processarSaidaDerivadaYX.replace("???","sqrt");
                            processarSaidaDerivadaXY = processarSaidaDerivadaXY.replace("???","sqrt");


                            cvSimplify.setFunctionSimplificar("(1/x)*("+processarSaidaDerivadaZY+")-("+processarSaidaDerivadaYZ+")");
                            cvSimplify.simplificar();
                            String ResultadoAX = cvSimplify.getFunctionSimplificada();

                            cvSimplify.setFunctionSimplificar("("+processarSaidaDerivadaXZ+")-("+processarSaidaDerivadaZX+")");
                            cvSimplify.simplificar();
                            String ResultadoAY = cvSimplify.getFunctionSimplificada();

                            cvSimplify.setFunctionSimplificar("(1/x)*[("+processarSaidaDerivadaYX+")-("+processarSaidaDerivadaXY+")]");
                            cvSimplify.simplificar();
                            String ResultadoAZ = cvSimplify.getFunctionSimplificada();

                            ResultadoAX = ResultadoAX.replace("???","sqrt");
                            ResultadoAY = ResultadoAY.replace("???","sqrt");
                            ResultadoAZ = ResultadoAZ.replace("???","sqrt");

                            ResultadoAX = ResultadoAX.replace("log(","log10(");
                            ResultadoAY = ResultadoAY.replace("log(","log10(");
                            ResultadoAZ = ResultadoAZ.replace("log(","log10(");

                            Expression ex = new ExpressionBuilder(ResultadoAX)
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultadoprocessadoAX = ex.evaluate();

                            Expression ey = new ExpressionBuilder(ResultadoAY)
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultadoprocessadoAY = ey.evaluate();

                            Expression ez = new ExpressionBuilder(ResultadoAZ)
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultadoprocessadoAZ = ez.evaluate();



                            String resultadoAX = df.format(resultadoprocessadoAX);
                            resultadoAX = resultadoAX.replace(",",".");
                            String resultadoAY = df.format(resultadoprocessadoAY);
                            resultadoAY = resultadoAY.replace(",",".");
                            String resultadoAZ = df.format(resultadoprocessadoAZ);
                            resultadoAZ = resultadoAZ.replace(",",".");

                            resultadoAX = resultadoAX.replace("x","???");resultadoAX = resultadoAX.replace("y","???");
                            resultadoAY = resultadoAY.replace("x","???");resultadoAY = resultadoAY.replace("y","???");
                            resultadoAZ = resultadoAZ.replace("x","???");resultadoAZ = resultadoAZ.replace("y","???");

                            processarSaidaDerivadaZY = processarSaidaDerivadaZY.replace("sqrt","???");
                            processarSaidaDerivadaYZ = processarSaidaDerivadaYZ.replace("sqrt","???");
                            processarSaidaDerivadaXZ = processarSaidaDerivadaXZ.replace("sqrt","???");
                            processarSaidaDerivadaZX = processarSaidaDerivadaZX.replace("sqrt","???");
                            processarSaidaDerivadaYX = processarSaidaDerivadaYX.replace("sqrt","???");
                            processarSaidaDerivadaXY = processarSaidaDerivadaXY.replace("sqrt","???");
                            ResultadoAX = ResultadoAX.replace("sqrt","???");
                            ResultadoAY = ResultadoAY.replace("sqrt","???");
                            ResultadoAZ = ResultadoAZ.replace("sqrt","???");


                            processarSaidaZY = processarSaidaZY.replace("sqrt","???");
                            processarSaidaYZ = processarSaidaYZ.replace("sqrt","???");
                            processarSaidaXZ = processarSaidaXZ.replace("sqrt","???");
                            processarSaidaZX = processarSaidaZX.replace("sqrt","???");
                            processarSaidaYX = processarSaidaYX.replace("sqrt","???");
                            processarSaidaXY = processarSaidaXY.replace("sqrt","???");


                            processx = processx.replace("sqrt","???");
                            processy = processy.replace("sqrt","???");
                            processz = processz.replace("sqrt","???");

                            processx = processx.replace("x","???");processx = processx.replace("y","???");
                            processy = processy.replace("x","???");processy = processy.replace("y","???");
                            processz = processz.replace("x","???");processz = processz.replace("y","???");

                            processarSaidaDerivadaZY = processarSaidaDerivadaZY.replace("x","???");processarSaidaDerivadaZY = processarSaidaDerivadaZY.replace("y","???");
                            processarSaidaDerivadaYZ = processarSaidaDerivadaYZ.replace("x","???");processarSaidaDerivadaYZ = processarSaidaDerivadaYZ.replace("y","???");
                            processarSaidaDerivadaXZ = processarSaidaDerivadaXZ.replace("x","???");processarSaidaDerivadaXZ = processarSaidaDerivadaXZ.replace("y","???");
                            processarSaidaDerivadaZX = processarSaidaDerivadaZX.replace("x","???");processarSaidaDerivadaZX = processarSaidaDerivadaZX.replace("y","???");
                            processarSaidaDerivadaYX = processarSaidaDerivadaYX.replace("x","???");processarSaidaDerivadaYX = processarSaidaDerivadaYX.replace("y","???");
                            processarSaidaDerivadaXY = processarSaidaDerivadaXY.replace("x","???");processarSaidaDerivadaXY = processarSaidaDerivadaXY.replace("y","???");

                            ResultadoAX = ResultadoAX.replace("x","???");ResultadoAX = ResultadoAX.replace("y","???");
                            ResultadoAY = ResultadoAY.replace("x","???");ResultadoAY = ResultadoAY.replace("y","???");
                            ResultadoAZ = ResultadoAZ.replace("x","???");ResultadoAZ = ResultadoAZ.replace("y","???");

                            processarSaidaZY = processarSaidaZY.replace("x","???");processarSaidaZY = processarSaidaZY.replace("y","???");
                            processarSaidaYZ = processarSaidaYZ.replace("x","???");processarSaidaYZ = processarSaidaYZ.replace("y","???");
                            processarSaidaXZ = processarSaidaXZ.replace("x","???");processarSaidaXZ = processarSaidaXZ.replace("y","???");
                            processarSaidaZX = processarSaidaZX.replace("x","???");processarSaidaZX = processarSaidaZX.replace("y","???");
                            processarSaidaYX = processarSaidaYX.replace("x","???");processarSaidaYX = processarSaidaYX.replace("y","???");
                            processarSaidaXY = processarSaidaXY.replace("x","???");processarSaidaXY = processarSaidaXY.replace("y","???");


                            info.setText(Html.fromHtml("<b>B</b> = ???x<b>??</b>" +
                                    "<br>" +
                                    "???x<b>??</b> = ["+resultadoAX+"]<b>?????</b> + ["+resultadoAY+"]<b>?????</b> + ["+resultadoAZ+"]<b>??z</b>"));


                            infoM.setText(Html.fromHtml("<b>??(???,???,z)</b> = "+processx+"<b>?????</b> +" +
                                    "<br> .. "+processy+"<b>?????</b> + " +
                                    "<br> .. "+processz+"<b>??z</b>"+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>B</b> = ???x<b>??</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>???x<b>??</b> = [(1/???)*(?????z/??????) - (????????/???z)]<b>?????</b> +" +
                                    "<br> ..... [(????????/???z) - (?????z/??????)]<b>?????</b> +" +
                                    "<br> ..... (1/???)*[(???(???*?????)/??????) - (????????/??????)]<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> ???x<b>??</b> = " +
                                    "<br> .. {(1/???)*(???/??????)["+processz+"] - " +
                                    "<br> ..... (???/???z)["+processy+"]}<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. {(???/???z)["+processx+"] - " +
                                    "<br> ..... (???/??????)["+processz+"]}<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. (1/???)*{(???/??????)[???*("+processy+")] - " +
                                    "<br> ..... (???/??????)["+processx+"]}<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>B</b> = " +
                                    "<br> .. { (1/???)*["+processarSaidaZY+"] - " +
                                    "<br> ..... ["+processarSaidaYZ+"] }<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. { ["+ processarSaidaXZ+"] - " +
                                    "<br> ..... ["+processarSaidaZX+"] }<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. (1/???)*{ ["+processarSaidaYX+"] - " +
                                    "<br> ..... ["+processarSaidaXY+"] }<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>B</b> =  " +
                                    "<br> .. { ["+processarSaidaDerivadaZY+"] - " +
                                    "<br> ..... ["+processarSaidaDerivadaYZ+"] }<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. { ["+ processarSaidaDerivadaXZ+"] - " +
                                    "<br> ..... ["+processarSaidaDerivadaZX+"] }<b>?????</b>" +
                                    "<br> + " +
                                    "<br> .. { ["+processarSaidaDerivadaYX+"] - " +
                                    "<br> ..... ["+processarSaidaDerivadaXY+"] }<b>??z</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>B</b> = ["+ResultadoAX+"]<b>?????</b> " +
                                    "<br> + " +
                                    "<br> .. ["+ResultadoAY+"]<b>?????</b> " +
                                    "<br> + " +
                                    "<br> .. ["+ResultadoAZ+"]<b>??z</b> " +
                                    "<br>" +
                                    "<br> Substituimos os valores de ???, ??? em rad, e z " +
                                    "<br> do ponto <b>B</b> na resposta do rotacional ???x<b>??</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>B</b> = ["+resultadoAX+"]<b>?????</b> + ["+resultadoAY+"]<b>?????</b> + ["+resultadoAZ+"]<b>??z</b>"));

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
                layoutParams.height = 2200;
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
        }
        if (decimaisnum.equals("3")){
            df = new DecimalFormat("#0.000");
        }
        if (decimaisnum.equals("4")){
            df = new DecimalFormat("#0.0000");
        }

    }
}