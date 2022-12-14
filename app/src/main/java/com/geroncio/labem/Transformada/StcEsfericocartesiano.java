package com.geroncio.labem.Transformada;

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
import com.geroncio.labem.Transformada.Simplify.JASimplify;
import com.geroncio.labem.Transformada.Simplify.SimplifyEsfericoCartesiano;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class StcEsfericocartesiano extends AppCompatActivity {

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
        setContentView(R.layout.activity_stc_esfericocartesiano);


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
            String main = "StcEsfericocartesiano.class";
            i.putExtra("STRING_ACTIVITY", main);
            startActivity(i);
        });

        voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), SistemaTransformada.class));
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

            }else if (processx.length()<=0){
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
            processx = txtimputx.getText().toString() + "arcsin(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btncosh.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "arccos(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btntanh.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "arctan(";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnx.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "r";
            txtimputx.setText(processx);


            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "??";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btnz.setOnClickListener(view -> {
            processx = txtimputx.getText().toString()+"???";
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
            processy = txtimputy.getText().toString() + "arcsin(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btncosh.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "arccos(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btntanh.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "arctan(";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btnx.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "r";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "??";
            txtimputy.setText(processy);


            if (calculoClick){info.setText("");}
        });
        btnz.setOnClickListener(view -> {
            processy = txtimputy.getText().toString()+"???";
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
            processz = txtimputz.getText().toString() + "arcsin(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btncosh.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "arccos(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btntanh.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "arctan(";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnx.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "r";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "??";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btnz.setOnClickListener(view -> {
            processz = txtimputz.getText().toString()+"???";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}


        });






    }


    @SuppressLint("SetTextI18n")
    private void Calcular(){


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
                                p1 = Double.parseDouble(p_1.getText().toString());
                                p2 = Double.parseDouble(p_2.getText().toString());
                                p3 = Double.parseDouble(p_3.getText().toString());


                                String inforesult = "<b>??(x,y,z)</b> = "+ df.format(p1 * Math.sin(p2) * Math.cos(p3))
                                        +"<b>??x</b> + "+ df.format(p1 * Math.sin(p2) * Math.sin(p3))+"<b>??y</b> + "
                                        + df.format(p1 * Math.cos(p2))+"<b>??z</b>";


                                inforesult = inforesult.replace("+-","-");

                                info.setText(Html.fromHtml(inforesult));


                                infoM.setText(Html.fromHtml("<b>U(r,??,???)</b> = ("+String.valueOf(df.format(p1)).replace(",",".")+" , " +String.valueOf(df.format(p2)).replace(",",".")+" , " +String.valueOf(df.format(p3)).replace(",",".")+")" +
                                        "<br>" +
                                        "<br> .. x = r*sin(??)*cos(???)" +
                                        "<br>" +
                                        "<br> .. y = r*sin(??)*sin(???)" +
                                        "<br>" +
                                        "<br> .. z = r*cos(??)" +
                                        "<br>" +
                                        "<br>" +
                                        "<br><b>U(x,y,z)</b> = (x, y, z)" +
                                        "<br>" +
                                        "<br> .. x = "+ df.format(p1 * Math.sin(p2) * Math.cos(p3)) +
                                        "<br>" +
                                        "<br> .. y = "+ df.format((p1 * Math.sin(p2) * Math.sin(p3))) +")]/("+ df.format(p3) +"))" +
                                        "<br>" +
                                        "<br> .. z= "+ df.format(p1 * Math.cos(p2)) +
                                        "<br>" +
                                        "<br>"+
                                        "<br><b>U(x,y,z)</b> = "+ df.format(p1 * Math.sin(p2) * Math.cos(p3))
                                        +"<b>??x</b> + "+ df.format(p1 * Math.sin(p2) * Math.sin(p3))+"<b>??y</b> + "
                                        + df.format(p1 * Math.cos(p2))+"<b>??z</b>"));

                                Passos();
                            }

                        }
                        else{

                            if (p_1.getText().toString().isEmpty() || p_2.getText().toString().isEmpty()|| p_3.getText().toString().isEmpty()){




                                SimplifyEsfericoCartesiano simplifyx = new SimplifyEsfericoCartesiano();
                                SimplifyEsfericoCartesiano simplifyy = new SimplifyEsfericoCartesiano();
                                SimplifyEsfericoCartesiano simplifyz = new SimplifyEsfericoCartesiano();

                                SimplifyEsfericoCartesiano simplifyreduzidax = new SimplifyEsfericoCartesiano();
                                SimplifyEsfericoCartesiano simplifyreduziday = new SimplifyEsfericoCartesiano();
                                SimplifyEsfericoCartesiano simplifyreduzidaz = new SimplifyEsfericoCartesiano();


                                calculoClick = true;


                                processx = processx.replace("???","sqrt");
                                processy = processy.replace("???","sqrt");
                                processz = processz.replace("???","sqrt");





                                simplifyx.setSimplificar(processx); simplifyx.simplificar();
                                simplifyy.setSimplificar(processy); simplifyy.simplificar();
                                simplifyz.setSimplificar(processz); simplifyz.simplificar();

                                String resultx = simplifyx.getSimplificarSaida();
                                String resulty = simplifyy.getSimplificarSaida();
                                String resultz = simplifyz.getSimplificarSaida();




                                simplifyreduzidax.setSimplificar(processx); simplifyreduzidax.simplificarReduzida();
                                simplifyreduziday.setSimplificar(processy); simplifyreduziday.simplificarReduzida();
                                simplifyreduzidaz.setSimplificar(processz); simplifyreduzidaz.simplificarReduzida();

                                String resultreduzidax = simplifyreduzidax.getSimplificarSaidaReduzida();resultreduzidax = resultreduzidax.replace("sqrt","???");
                                String resultreduziday = simplifyreduziday.getSimplificarSaidaReduzida();resultreduziday = resultreduziday.replace("sqrt","???");
                                String resultreduzidaz = simplifyreduzidaz.getSimplificarSaidaReduzida();resultreduzidaz = resultreduzidaz.replace("sqrt","???");

                                JASimplify jaSimplify = new JASimplify();
                                jaSimplify.setFunctionSimplificar("("+resultx+")*(x/sqrt(x^(2)+y^(2)+z^(2))) + ("+resulty+")*((x*z)/((sqrt(x^(2)+y^(2)))*(sqrt(x^(2)+y^(2)+z^(2))))) - ("+resultz+")*(y/sqrt(x^(2)+y^(2)))");
                                jaSimplify.jasimplificar();

                                String resultrefinadax = jaSimplify.getFunctionSimplificada();

                                jaSimplify.setFunctionSimplificar("("+resultx+")*(y/sqrt(x^(2)+y^(2)+z^(2))) + ("+resulty+")*((y*z)/((sqrt(x^(2)+y^(2)))*(sqrt(x^(2)+y^(2)+z^(2))))) + ("+resultz+")*(x/sqrt(x^(2)+y^(2)))");
                                jaSimplify.jasimplificar();

                                String resultrefinaday = jaSimplify.getFunctionSimplificada();

                                jaSimplify.setFunctionSimplificar("("+resultx+")*(z/sqrt(x^(2)+y^(2)+z^(2))) - ("+resulty+")*(sqrt(x^(2)+y^(2))/sqrt(x^(2)+y^(2)+z^(2)))");
                                jaSimplify.jasimplificar();

                                String resultrefinadaz = jaSimplify.getFunctionSimplificada();


                                resultx = resultx.replace("sqrt","???");
                                resulty = resulty.replace("sqrt","???");
                                resultz = resultz.replace("sqrt","???");

                                resultreduzidax = resultreduzidax.replace("sqrt","???");
                                resultreduziday = resultreduziday.replace("sqrt","???");
                                resultreduzidaz = resultreduzidaz.replace("sqrt","???");

                                resultrefinadax = resultrefinadax.replace("sqrt","???");
                                resultrefinaday = resultrefinaday.replace("sqrt","???");
                                resultrefinadaz = resultrefinadaz.replace("sqrt","???");


                                processx = processx.replace("sqrt","???");
                                processy = processy.replace("sqrt","???");
                                processz = processz.replace("sqrt","???");


                                info.setText(Html.fromHtml("<b>U(x,y,z)</b> = ["+resultrefinadax+"]<b>??x</b>" +
                                        "<br> +" +
                                        "<br>" +
                                        "<br> .. ["+resultrefinaday+"]<b>??y</b>" +
                                        "<br> + " +
                                        "<br>" +
                                        "<br> .. ["+resultrefinadaz+"]<b>??z</b>"));

                                infoM.setText(Html.fromHtml("<b>U(r,??,???)</b> = " +
                                        "<br> .. ["+processx+"]<b>??r</b> +" +
                                        "<br> .. ["+processy+"]<b>????</b> +" +
                                        "<br> .. ["+processz+"]<b>?????</b>" +
                                        "<br>" +
                                        "<br> .. r = ???(x^(2)+y^(2)+z^(2)) " +
                                        "<br> .. ?? = atan(???(x^(2)+y^(2))/z)" +
                                        "<br> .. ??? = atan(y/x)" +
                                        "<br>" +
                                        "<br><b>U(r,??,???)</b> = "+
                                        "<br> .. ["+resultreduzidax+"]<b>??r</b> +" +
                                        "<br>" +
                                        "<br> .. ["+resultreduziday+"]<b>????</b> +" +
                                        "<br>" +
                                        "<br> .. ["+resultreduzidaz+"]<b>?????</b>" +
                                        "<br>" +
                                        "<br>"+
                                        "<br><b>U(r,??,???)</b> = "+
                                        "<br> .. ["+resultx+"]<b>??r</b> +" +
                                        "<br>" +
                                        "<br> .. ["+resulty+"]<b>????</b> +" +
                                        "<br>" +
                                        "<br> .. ["+resultz+"]<b>?????</b>" +
                                        "<br>" +
                                        "<br>" +
                                        "<br> . <b>??r</b> = sin(??)*cos(???)<b>??x</b> + sin(??)*sin(???)<b>??y</b> " +
                                        "<br> ....... + cos(??)<b>??z</b>" +
                                        "<br>"  +
                                        "<br> . <b>????</b> = cos(??)*cos(???)<b>??x</b> + cos(??)*sin(???)<b>??y</b> " +
                                        "<br> ....... - sin(??)<b>??z</b>" +
                                        "<br>"+
                                        "<br> . <b>?????</b> = -sin(???)<b>??x</b> + cos(???)<b>??y</b>"+
                                        "<br>" +
                                        "<br>" +
                                        "<br> .. sin(??) = ???(x<sup>2</sup>+y<sup>2</sup>)/???(x<sup>2</sup>+y<sup>2</sup>+" +
                                        "<br> ......... z<sup>2</sup>) " +
                                        "<br>" +
                                        "<br> .. cos(??) = z/???(x<sup>2</sup>+y<sup>2</sup>+z<sup>2</sup>)" +
                                        "<br>" +
                                        "<br> .. sin(???) = y/???(x<sup>2</sup>+y<sup>2</sup>)" +
                                        "<br>" +
                                        "<br> .. cos(???) = x/???(x<sup>2</sup>+y<sup>2</sup>)" +
                                        "<br> " +
                                        "<br>" +
                                        "<br><b>??(x,y,z)</b> = " +
                                        "<br>"+
                                        "<br> .. ["+resultrefinadax+"]<b>??x</b> +" +
                                        "<br>" +
                                        "<br> .. ["+resultrefinaday+"]<b>??y</b> +" +
                                        "<br>" +
                                        "<br> .. ["+resultrefinadaz+"]<b>??z</b>"));


                                Passos();

                            }
                            else{
                                p1 = Double.parseDouble(p_1.getText().toString());
                                p2 = Double.parseDouble(p_2.getText().toString());
                                p3 = Double.parseDouble(p_3.getText().toString());

                                processx = processx.replace("???","sqrt");
                                processy = processy.replace("???","sqrt");
                                processz = processz.replace("???","sqrt");

                                Expression ex = new ExpressionBuilder(processx)
                                        .variables("r","??","???")
                                        .build()
                                        .setVariable("r",p1)
                                        .setVariable("??",p2)
                                        .setVariable("???",p3);
                                double resultx = ex.evaluate();

                                Expression ey = new ExpressionBuilder(processy)
                                        .variables("r","??","???")
                                        .build()
                                        .setVariable("r",p1)
                                        .setVariable("??",p2)
                                        .setVariable("???",p3);
                                double resulty = ey.evaluate();

                                Expression ez = new ExpressionBuilder(processz)
                                        .variables("r","??","???")
                                        .build()
                                        .setVariable("r",p1)
                                        .setVariable("??",p2)
                                        .setVariable("???",p3);
                                double resultz = ez.evaluate();

                                p1 = resultx; p2 = resulty; p3 = resultz;


                                info.setText(Html.fromHtml("<b>??(x,y,z)</b> = ("+ df.format(p1 * Math.sin(p2) * Math.cos(p3)).replace(",",".")
                                        +" , "+ df.format(p1 * Math.sin(p2) * Math.sin(p3)).replace(",",".")+" , "
                                        + df.format(p1 * Math.cos(p2)).replace(",",".")+")"));


                                infoM.setText(Html.fromHtml("<b>??(r,??,???)</b> = ("+String.valueOf(df.format(p1)).replace(",",".")+" , " +String.valueOf(df.format(p2)).replace(",",".")+" , " +String.valueOf(df.format(p3)).replace(",",".")+")" +
                                        "<br>" +
                                        "<br> .. x = r*sin(??)*cos(???)" +
                                        "<br>" +
                                        "<br> .. y = r*sin(??)*sin(???)" +
                                        "<br>" +
                                        "<br> .. z = r*cos(??)" +
                                        "<br>" +
                                        "<br>" +
                                        "<br><b>??(x,y,z)</b> = (x, y, z)" +
                                        "<br>" +
                                        "<br> .. x = "+ df.format(p1 * Math.sin(p2) * Math.cos(p3)) +
                                        "<br>" +
                                        "<br> .. y = "+ df.format((p1 * Math.sin(p2) * Math.sin(p3))) +")]/("+ df.format(p3) +"))" +
                                        "<br>" +
                                        "<br> .. z= "+ df.format(p1 * Math.cos(p2)) +
                                        "<br>" +
                                        "<br>"+
                                        "<br><b>??(x,y,z)</b> = ("+ df.format(p1 * Math.sin(p2) * Math.cos(p3)).replace(",",".")
                                        +" , "+ df.format(p1 * Math.sin(p2) * Math.sin(p3)).replace(",",".")+" , "
                                        + df.format(p1 * Math.cos(p2)).replace(",",".")+")"));

                                Passos();
                            }



                        }
                    }
                    catch (Exception e){
                        info.setText(R.string.erro);
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
                passos.setImageResource(R.drawable.ic_eye_verdeestacao);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                layoutParams.height = 3000;
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