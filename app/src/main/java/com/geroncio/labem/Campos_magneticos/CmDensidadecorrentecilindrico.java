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

public class CmDensidadecorrentecilindrico extends AppCompatActivity {

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
        setContentView(R.layout.activity_cm_densidadecorrentecilindrico);

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
            String main = "CmDensidadecorrentecilindrico.class";
            i.putExtra("STRING_ACTIVITY", main);
            startActivity(i);
        });

        voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Camposmagneticos.class));
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
            processx = txtimputx.getText().toString() + "ᵨ";
            txtimputx.setText(processx);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processx = txtimputx.getText().toString() + "ᵩ";
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
            processy = txtimputy.getText().toString() + "ᵨ";
            txtimputy.setText(processy);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processy = txtimputy.getText().toString() + "ᵩ";
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
            processz = txtimputz.getText().toString() + "ᵨ";
            txtimputz.setText(processz);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            processz = txtimputz.getText().toString() + "ᵩ";
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

        Derivative der = new Derivative();
        DerivativeY derY = new DerivativeY();
        DerivativeZ derZ = new DerivativeZ();

        Derivative der2 = new Derivative();
        DerivativeY derY2 = new DerivativeY();
        DerivativeZ derZ2 = new DerivativeZ();

        Derivative der3 = new Derivative();
        DerivativeY derY3 = new DerivativeY();
        DerivativeZ derZ3 = new DerivativeZ();



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

                        info.setText(R.string.erro);
                        passos.setImageResource(R.drawable.ic_eye_lightblack);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                        layoutParams.height = 0;
                        layoutpassos.setLayoutParams(layoutParams);

                    }
                    else{

                        if (p_1.getText().toString().isEmpty() || p_2.getText().toString().isEmpty()|| p_3.getText().toString().isEmpty()){

                            calculoClick = true;
                            processx = processx.replace("√","sqrt");
                            processy = processy.replace("√","sqrt");
                            processz = processz.replace("√","sqrt");
                            processx = processx.replace("π","3.14159265");
                            processy = processy.replace("π","3.14159265");
                            processz = processz.replace("π","3.14159265");
                            processx = processx.replace("ᵨ","x");
                            processx = processx.replace("ᵩ","y");
                            processy = processy.replace("ᵨ","x");
                            processy = processy.replace("ᵩ","y");
                            processz = processz.replace("ᵨ","x");
                            processz = processz.replace("ᵩ","y");



                            der.setFunctionDerivar(processx);
                            der.derivar();
                            derY.setFunctionDerivar(processx);
                            derY.derivar();
                            derZ.setFunctionDerivar(processx);
                            derZ.derivar();

                            String processarSaida = der.getFunctionDerivada();
                            String processarSaidaY = derY.getFunctionDerivada();
                            String processarSaidaZ = derZ.getFunctionDerivada();


                            der.setFunctionDerivar(processarSaida);
                            der.derivar();
                            derY.setFunctionDerivar(processarSaidaY);
                            derY.derivar();
                            derZ.setFunctionDerivar(processarSaidaZ);
                            derZ.derivar();


                            processarSaida = der.getFunctionDerivada();
                            processarSaidaY = derY.getFunctionDerivada();
                            processarSaidaZ = derZ.getFunctionDerivada();


                            processy = processy.replace("√","sqrt");
                            der2.setFunctionDerivar(processy);
                            der2.derivar();
                            derY2.setFunctionDerivar(processy);
                            derY2.derivar();
                            derZ2.setFunctionDerivar(processy);
                            derZ2.derivar();

                            String processarSaida2 = der2.getFunctionDerivada();
                            String processarSaidaY2 = derY2.getFunctionDerivada();
                            String processarSaidaZ2 = derZ2.getFunctionDerivada();


                            der2.setFunctionDerivar(processarSaida2);
                            der2.derivar();
                            derY2.setFunctionDerivar(processarSaidaY2);
                            derY2.derivar();
                            derZ2.setFunctionDerivar(processarSaidaZ2);
                            derZ2.derivar();


                            processarSaida2 = der2.getFunctionDerivada();
                            processarSaidaY2 = derY2.getFunctionDerivada();
                            processarSaidaZ2 = derZ2.getFunctionDerivada();



                            processz = processz.replace("√","sqrt");
                            der3.setFunctionDerivar(processz);
                            der3.derivar();
                            derY3.setFunctionDerivar(processz);
                            derY3.derivar();
                            derZ3.setFunctionDerivar(processz);
                            derZ3.derivar();

                            String processarSaida3 = der3.getFunctionDerivada();
                            String processarSaidaY3 = derY3.getFunctionDerivada();
                            String processarSaidaZ3 = derZ3.getFunctionDerivada();


                            der3.setFunctionDerivar(processarSaida3);
                            der3.derivar();
                            derY3.setFunctionDerivar(processarSaidaY3);
                            derY3.derivar();
                            derZ3.setFunctionDerivar(processarSaidaZ3);
                            derZ3.derivar();

                            processarSaida3 = der3.getFunctionDerivada();
                            processarSaidaY3 = derY3.getFunctionDerivada();
                            processarSaidaZ3 = derZ3.getFunctionDerivada();



                            if (processarSaida == null || processarSaidaY == null || processarSaidaZ == null){
                                info.setText(R.string.erro);
                                passos.setImageResource(R.drawable.ic_eye_lightblack);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                                layoutParams.height = 0;
                                layoutpassos.setLayoutParams(layoutParams);
                                return;
                            }


                            if (processarSaida2 == null || processarSaidaY2 == null || processarSaidaZ2 == null){
                                info.setText(R.string.erro);
                                passos.setImageResource(R.drawable.ic_eye_lightblack);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                                layoutParams.height = 0;
                                layoutpassos.setLayoutParams(layoutParams);
                                return;
                            }


                            if (processarSaida3 == null || processarSaidaY3 == null || processarSaidaZ3 == null){
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


                            String processarSaidaDerivada2 = der2.getFunctionDerivada();
                            String processarSaidaDerivadaY2 = derY2.getFunctionDerivada();
                            String processarSaidaDerivadaZ2 = derZ2.getFunctionDerivada();


                            String processarSaidaDerivada3 = der3.getFunctionDerivada();
                            String processarSaidaDerivadaY3 = derY3.getFunctionDerivada();
                            String processarSaidaDerivadaZ3 = derZ3.getFunctionDerivada();


                            CVSimplify cvSimplify = new CVSimplify();
                            cvSimplify.setFunctionSimplificar(processarSaidaDerivada);
                            cvSimplify.simplificar();
                            processarSaidaDerivada = cvSimplify.getFunctionSimplificada();

                            processarSaidaDerivada = processarSaidaDerivada.replace("sqrt","√");



                            CVSimplify cvSimplify2 = new CVSimplify();
                            cvSimplify2.setFunctionSimplificar(processarSaidaDerivada2);
                            cvSimplify2.simplificar();
                            processarSaidaDerivada2 = cvSimplify2.getFunctionSimplificada();

                            processarSaidaDerivada2 = processarSaidaDerivada2.replace("sqrt","√");




                            CVSimplify cvSimplify3 = new CVSimplify();
                            cvSimplify3.setFunctionSimplificar(processarSaidaDerivada3);
                            cvSimplify3.simplificar();
                            processarSaidaDerivada3 = cvSimplify3.getFunctionSimplificada();

                            processarSaidaDerivada3 = processarSaidaDerivada3.replace("sqrt","√");




                            cvSimplify.setFunctionSimplificar("("+processarSaidaDerivadaY+")*(1/x)");
                            cvSimplify.simplificar();
                            processarSaidaDerivadaY = cvSimplify.getFunctionSimplificada();
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("sqrt","√");



                            cvSimplify2.setFunctionSimplificar("("+processarSaidaDerivadaY2+")*(1/x)");
                            cvSimplify2.simplificar();
                            processarSaidaDerivadaY2 = cvSimplify2.getFunctionSimplificada();
                            processarSaidaDerivadaY2 = processarSaidaDerivadaY2.replace("sqrt","√");



                            cvSimplify3.setFunctionSimplificar("("+processarSaidaDerivadaY3+")*(1/x)");
                            cvSimplify3.simplificar();
                            processarSaidaDerivadaY3 = cvSimplify3.getFunctionSimplificada();
                            processarSaidaDerivadaY3 = processarSaidaDerivadaY3.replace("sqrt","√");




                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaZ);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaZ = cvSimplify.getFunctionSimplificada();
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("sqrt","√");



                            cvSimplify2.setFunctionSimplificar(processarSaidaDerivadaZ2);
                            cvSimplify2.simplificar();
                            processarSaidaDerivadaZ2 = cvSimplify2.getFunctionSimplificada();
                            processarSaidaDerivadaZ2 = processarSaidaDerivadaZ2.replace("sqrt","√");



                            cvSimplify3.setFunctionSimplificar(processarSaidaDerivadaZ3);
                            cvSimplify3.simplificar();
                            processarSaidaDerivadaZ3 = cvSimplify3.getFunctionSimplificada();
                            processarSaidaDerivadaZ3 = processarSaidaDerivadaZ3.replace("sqrt","√");


                            processx = processx.replace("sqrt","√");
                            processy = processy.replace("sqrt","√");
                            processz = processz.replace("sqrt","√");

                            processarSaida = processarSaida.replace("sqrt","√");
                            processarSaidaY = processarSaidaY.replace("sqrt","√");
                            processarSaidaZ = processarSaidaZ.replace("sqrt","√");

                            processarSaida2 = processarSaida2.replace("sqrt","√");
                            processarSaidaY2 = processarSaidaY2.replace("sqrt","√");
                            processarSaidaZ2 = processarSaidaZ2.replace("sqrt","√");


                            processarSaida3 = processarSaida3.replace("sqrt","√");
                            processarSaidaY3 = processarSaidaY3.replace("sqrt","√");
                            processarSaidaZ3 = processarSaidaZ3.replace("sqrt","√");


                            info.setText(Html.fromHtml("<b>J</b> = -[1/m0]*(∇<sup>2</sup>Aᵨ, ∇<sup>2</sup>Aᵩ, ∇<sup>2</sup>Az) " +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>J</b> = -[1/m0]*("+processarSaidaDerivada+" ; "+processarSaidaDerivadaY+" ; "+processarSaidaDerivadaZ+")<b>âᵨ</b> +"+
                                    "<br> -[1/m0]*("+processarSaidaDerivada2+" ; "+processarSaidaDerivadaY2+" ;, "+processarSaidaDerivadaZ2+")<b>âᵩ</b> +"+
                                    "<br> -[1/m0]*("+processarSaidaDerivada3+" ; "+processarSaidaDerivadaY3+" ; "+processarSaidaDerivadaZ3+")<b>âz</b> A/m<sup>2</sup>"));


                            infoM.setText(Html.fromHtml("<b>Ä(ᵨ,ᵩ,z)</b> = "+processx+"<b>âᵨ</b> +" +
                                    "<br> .. "+processy+"<b>âᵩ</b> + " +
                                    "<br> .. "+processz+"<b>âz</b>"+
                                    "<br>" +
                                    "<br>" +
                                    "<b>J</b> = -[1/m0]*∇<sup>2</sup><b>Ä</b>" +
                                    "<b>J</b> = -[1/m0]*(∇<sup>2</sup>Aᵨ, ∇<sup>2</sup>Aᵩ, ∇<sup>2</sup>Az)" +
                                    "<br>" +
                                    "<br> m0 é a constante de permeabidade que, no vácuo vale: 4π*10<sup>-7</sup> H/m" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇<sup>2</sup>Aᵨ = [∂<sup>2</sup>Äᵨ/∂<sup>2</sup>x]<b>âᵨ</b>  +" +
                                    "<br> ..... (1/ᵨ)*[∂<sup>2</sup>Äᵨ/∂<sup>2</sup>y]<b>âᵩ</b>  +" +
                                    "<br> ..... [∂<sup>2</sup>Äᵨ/∂<sup>2</sup>z]<b>âz</b>  " +
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇<sup>2</sup>Aᵩ = [∂<sup>2</sup>Äᵩ/∂<sup>2</sup>x]<b>âᵨ</b>  +" +
                                    "<br> ..... (1/ᵨ)*[∂<sup>2</sup>Äᵩ/∂<sup>2</sup>y]<b>âᵩ</b>  +" +
                                    "<br> ..... [∂<sup>2</sup>Äᵩ/∂<sup>2</sup>z]<b>âz</b>  " +
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇<sup>2</sup>Az = [∂<sup>2</sup>Äz/∂<sup>2</sup>x]<b>âᵨ</b>  +" +
                                    "<br> ..... (1/ᵨ)*[∂<sup>2</sup>Äz/∂<sup>2</sup>y]<b>âᵩ</b>  +" +
                                    "<br> ..... [∂<sup>2</sup>Äz/∂<sup>2</sup>z]<b>âz</b>  " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> ∇<sup>2</sup>Aᵨ = " +
                                    "<br> .. ["+processarSaida+"]<b>âᵨ</b>" +
                                    "<br> .. ["+processarSaidaY+"]<b>âᵩ</b>" +
                                    "<br> .. ["+processarSaidaZ+"]<b>âz</b>" +
                                    "<br> + " +
                                    "<br> ∇<sup>2</sup>Aᵩ = " +
                                    "<br> .. ["+processarSaida2+"]<b>âᵨ</b>" +
                                    "<br> .. ["+processarSaidaY2+"]<b>âᵩ</b>" +
                                    "<br> .. ["+processarSaidaZ2+"]<b>âz</b>" +
                                    "<br> + " +
                                    "<br> ∇<sup>2</sup>Az = " +
                                    "<br> .. ["+processarSaida3+"]<b>âᵨ</b>" +
                                    "<br> .. ["+processarSaidaY3+"]<b>âᵩ</b>" +
                                    "<br> .. ["+processarSaidaZ3+"]<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>" +
                                    "<b>J</b> = " +
                                    "<br> -[1/m0]*("+processarSaidaDerivada+" ; "+processarSaidaDerivadaY+" ; "+processarSaidaDerivadaZ+")<b>âᵨ</b> +"+
                                    "<br> -[1/m0]*("+processarSaidaDerivada2+" ; "+processarSaidaDerivadaY2+" ; "+processarSaidaDerivadaZ2+")<b>âᵩ/b> +"+
                                    "<br> -[1/m0]*("+processarSaidaDerivada3+" ; "+processarSaidaDerivadaY3+" ; "+processarSaidaDerivadaZ3+")<b>âz</b> A/m<sup>2</sup>"
                            ));

                            Passos();

                        }
                        else{

                            calculoClick = true;
                            processx = processx.replace("√","sqrt");
                            processy = processy.replace("√","sqrt");
                            processz = processz.replace("√","sqrt");
                            processx = processx.replace("π","3.14159265");
                            processy = processy.replace("π","3.14159265");
                            processz = processz.replace("π","3.14159265");
                            processx = processx.replace("ᵨ","x");
                            processx = processx.replace("ᵩ","y");
                            processy = processy.replace("ᵨ","x");
                            processy = processy.replace("ᵩ","y");
                            processz = processz.replace("ᵨ","x");
                            processz = processz.replace("ᵩ","y");


                            der.setFunctionDerivar(processx);
                            der.derivar();
                            derY.setFunctionDerivar(processx);
                            derY.derivar();
                            derZ.setFunctionDerivar(processx);
                            derZ.derivar();

                            String processarSaida = der.getFunctionDerivada();
                            String processarSaidaY = derY.getFunctionDerivada();
                            String processarSaidaZ = derZ.getFunctionDerivada();


                            der.setFunctionDerivar(processarSaida);
                            der.derivar();
                            derY.setFunctionDerivar(processarSaidaY);
                            derY.derivar();
                            derZ.setFunctionDerivar(processarSaidaZ);
                            derZ.derivar();


                            processarSaida = der.getFunctionDerivada();
                            processarSaidaY = derY.getFunctionDerivada();
                            processarSaidaZ = derZ.getFunctionDerivada();


                            processy = processy.replace("√","sqrt");
                            der2.setFunctionDerivar(processy);
                            der2.derivar();
                            derY2.setFunctionDerivar(processy);
                            derY2.derivar();
                            derZ2.setFunctionDerivar(processy);
                            derZ2.derivar();

                            String processarSaida2 = der2.getFunctionDerivada();
                            String processarSaidaY2 = derY2.getFunctionDerivada();
                            String processarSaidaZ2 = derZ2.getFunctionDerivada();


                            der2.setFunctionDerivar(processarSaida2);
                            der2.derivar();
                            derY2.setFunctionDerivar(processarSaidaY2);
                            derY2.derivar();
                            derZ2.setFunctionDerivar(processarSaidaZ2);
                            derZ2.derivar();


                            processarSaida2 = der2.getFunctionDerivada();
                            processarSaidaY2 = derY2.getFunctionDerivada();
                            processarSaidaZ2 = derZ2.getFunctionDerivada();



                            processz = processz.replace("√","sqrt");
                            der3.setFunctionDerivar(processz);
                            der3.derivar();
                            derY3.setFunctionDerivar(processz);
                            derY3.derivar();
                            derZ3.setFunctionDerivar(processz);
                            derZ3.derivar();

                            String processarSaida3 = der3.getFunctionDerivada();
                            String processarSaidaY3 = derY3.getFunctionDerivada();
                            String processarSaidaZ3 = derZ3.getFunctionDerivada();


                            der3.setFunctionDerivar(processarSaida3);
                            der3.derivar();
                            derY3.setFunctionDerivar(processarSaidaY3);
                            derY3.derivar();
                            derZ3.setFunctionDerivar(processarSaidaZ3);
                            derZ3.derivar();

                            processarSaida3 = der3.getFunctionDerivada();
                            processarSaidaY3 = derY3.getFunctionDerivada();
                            processarSaidaZ3 = derZ3.getFunctionDerivada();



                            if (processarSaida == null || processarSaidaY == null || processarSaidaZ == null){
                                info.setText(R.string.erro);
                                passos.setImageResource(R.drawable.ic_eye_lightblack);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                                layoutParams.height = 0;
                                layoutpassos.setLayoutParams(layoutParams);
                                return;
                            }


                            if (processarSaida2 == null || processarSaidaY2 == null || processarSaidaZ2 == null){
                                info.setText(R.string.erro);
                                passos.setImageResource(R.drawable.ic_eye_lightblack);
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layoutpassos.getLayoutParams();
                                layoutParams.height = 0;
                                layoutpassos.setLayoutParams(layoutParams);
                                return;
                            }


                            if (processarSaida3 == null || processarSaidaY3 == null || processarSaidaZ3 == null){
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


                            String processarSaidaDerivada2 = der2.getFunctionDerivada();
                            String processarSaidaDerivadaY2 = derY2.getFunctionDerivada();
                            String processarSaidaDerivadaZ2 = derZ2.getFunctionDerivada();


                            String processarSaidaDerivada3 = der3.getFunctionDerivada();
                            String processarSaidaDerivadaY3 = derY3.getFunctionDerivada();
                            String processarSaidaDerivadaZ3 = derZ3.getFunctionDerivada();


                            CVSimplify cvSimplify = new CVSimplify();
                            cvSimplify.setFunctionSimplificar(processarSaidaDerivada);
                            cvSimplify.simplificar();
                            processarSaidaDerivada = cvSimplify.getFunctionSimplificada();

                            processarSaidaDerivada = processarSaidaDerivada.replace("sqrt","√");



                            CVSimplify cvSimplify2 = new CVSimplify();
                            cvSimplify2.setFunctionSimplificar(processarSaidaDerivada2);
                            cvSimplify2.simplificar();
                            processarSaidaDerivada2 = cvSimplify2.getFunctionSimplificada();

                            processarSaidaDerivada2 = processarSaidaDerivada2.replace("sqrt","√");




                            CVSimplify cvSimplify3 = new CVSimplify();
                            cvSimplify3.setFunctionSimplificar(processarSaidaDerivada3);
                            cvSimplify3.simplificar();
                            processarSaidaDerivada3 = cvSimplify3.getFunctionSimplificada();

                            processarSaidaDerivada3 = processarSaidaDerivada3.replace("sqrt","√");




                            cvSimplify.setFunctionSimplificar("("+processarSaidaDerivadaY+")*(1/x)");
                            cvSimplify.simplificar();
                            processarSaidaDerivadaY = cvSimplify.getFunctionSimplificada();
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("sqrt","√");



                            cvSimplify2.setFunctionSimplificar("("+processarSaidaDerivadaY2+")*(1/x)");
                            cvSimplify2.simplificar();
                            processarSaidaDerivadaY2 = cvSimplify2.getFunctionSimplificada();
                            processarSaidaDerivadaY2 = processarSaidaDerivadaY2.replace("sqrt","√");



                            cvSimplify3.setFunctionSimplificar("("+processarSaidaDerivadaY3+")*(1/x)");
                            cvSimplify3.simplificar();
                            processarSaidaDerivadaY3 = cvSimplify3.getFunctionSimplificada();
                            processarSaidaDerivadaY3 = processarSaidaDerivadaY3.replace("sqrt","√");




                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaZ);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaZ = cvSimplify.getFunctionSimplificada();
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("sqrt","√");



                            cvSimplify2.setFunctionSimplificar(processarSaidaDerivadaZ2);
                            cvSimplify2.simplificar();
                            processarSaidaDerivadaZ2 = cvSimplify2.getFunctionSimplificada();
                            processarSaidaDerivadaZ2 = processarSaidaDerivadaZ2.replace("sqrt","√");



                            cvSimplify3.setFunctionSimplificar(processarSaidaDerivadaZ3);
                            cvSimplify3.simplificar();
                            processarSaidaDerivadaZ3 = cvSimplify3.getFunctionSimplificada();
                            processarSaidaDerivadaZ3 = processarSaidaDerivadaZ3.replace("sqrt","√");




                            p1 = Double.parseDouble(p_1.getText().toString());
                            p2 = Double.parseDouble(p_2.getText().toString());
                            p3 = Double.parseDouble(p_3.getText().toString());

                            processarSaidaDerivada = processarSaidaDerivada.replace("√","sqrt");
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("√","sqrt");
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("√","sqrt");

                            processarSaidaDerivada2 = processarSaidaDerivada2.replace("√","sqrt");
                            processarSaidaDerivadaY2 = processarSaidaDerivadaY2.replace("√","sqrt");
                            processarSaidaDerivadaZ2 = processarSaidaDerivadaZ2.replace("√","sqrt");

                            processarSaidaDerivada3 = processarSaidaDerivada3.replace("√","sqrt");
                            processarSaidaDerivadaY3 = processarSaidaDerivadaY3.replace("√","sqrt");
                            processarSaidaDerivadaZ3 = processarSaidaDerivadaZ3.replace("√","sqrt");

                            String saidaX = processarSaidaDerivada.replace("log(","log10(");
                            String saidaY = processarSaidaDerivadaY.replace("log(","log10(");
                            String saidaZ = processarSaidaDerivadaZ.replace("log(","log10(");

                            String saidaX2 = processarSaidaDerivada2.replace("log(","log10(");
                            String saidaY2 = processarSaidaDerivadaY2.replace("log(","log10(");
                            String saidaZ2 = processarSaidaDerivadaZ2.replace("log(","log10(");

                            String saidaX3 = processarSaidaDerivada3.replace("log(","log10(");
                            String saidaY3 = processarSaidaDerivadaY3.replace("log(","log10(");
                            String saidaZ3 = processarSaidaDerivadaZ3.replace("log(","log10(");


                            Expression ex = new ExpressionBuilder("("+saidaX+")*((10^7)/(-4*pi))")
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultx = ex.evaluate();

                            Expression ey = new ExpressionBuilder("("+saidaY+")*((10^7)/(-4*pi))")
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resulty = ey.evaluate();

                            Expression ez = new ExpressionBuilder("("+saidaZ+")*((10^7)/(-4*pi))")
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultz = ez.evaluate();


                            Expression ex2 = new ExpressionBuilder("("+saidaX2+")*((10^7)/(-4*pi))")
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultx2 = ex2.evaluate();

                            Expression ey2 = new ExpressionBuilder("("+saidaY2+")*((10^7)/(-4*pi))")
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resulty2 = ey2.evaluate();

                            Expression ez2 = new ExpressionBuilder("("+saidaZ2+")*((10^7)/(-4*pi))")
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultz2 = ez2.evaluate();


                            Expression ex3 = new ExpressionBuilder("("+saidaX3+")*((10^7)/(-4*pi))")
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultx3 = ex3.evaluate();

                            Expression ey3 = new ExpressionBuilder("("+saidaY3+")*((10^7)/(-4*pi))")
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resulty3 = ey3.evaluate();

                            Expression ez3 = new ExpressionBuilder("("+saidaZ3+")*((10^7)/(-4*pi))")
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultz3 = ez3.evaluate();

                            processx = processx.replace("sqrt","√");
                            processy = processy.replace("sqrt","√");
                            processz = processz.replace("sqrt","√");

                            processarSaida = processarSaida.replace("sqrt","√");
                            processarSaidaY = processarSaidaY.replace("sqrt","√");
                            processarSaidaZ = processarSaidaZ.replace("sqrt","√");


                            processarSaida2 = processarSaida2.replace("sqrt","√");
                            processarSaidaY2 = processarSaidaY2.replace("sqrt","√");
                            processarSaidaZ2 = processarSaidaZ2.replace("sqrt","√");


                            processarSaida3 = processarSaida3.replace("sqrt","√");
                            processarSaidaY3 = processarSaidaY3.replace("sqrt","√");
                            processarSaidaZ3 = processarSaidaZ3.replace("sqrt","√");


                            processarSaidaDerivada = processarSaidaDerivada.replace("sqrt","√");
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("sqrt","√");
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("sqrt","√");


                            processarSaidaDerivada2 = processarSaidaDerivada2.replace("sqrt","√");
                            processarSaidaDerivadaY2 = processarSaidaDerivadaY2.replace("sqrt","√");
                            processarSaidaDerivadaZ2 = processarSaidaDerivadaZ2.replace("sqrt","√");


                            processarSaidaDerivada3 = processarSaidaDerivada3.replace("sqrt","√");
                            processarSaidaDerivadaY3 = processarSaidaDerivadaY3.replace("sqrt","√");
                            processarSaidaDerivadaZ3 = processarSaidaDerivadaZ3.replace("sqrt","√");




                            info.setText(Html.fromHtml("<b>J</b> = -[1/m0]*(∇<sup>2</sup>Aᵨ, ∇<sup>2</sup>Aᵩ, ∇<sup>2</sup>Az) " +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>J</b> = -[1/m0]*("+processarSaidaDerivada+" ; "+processarSaidaDerivadaY+" ; "+processarSaidaDerivadaZ+")<b>âᵨ</b> +"+
                                    "<br> -[1/m0]*("+processarSaidaDerivada2+" ; "+processarSaidaDerivadaY2+" ;, "+processarSaidaDerivadaZ2+")<b>âᵩ</b> +"+
                                    "<br> -[1/m0]*("+processarSaidaDerivada3+" ; "+processarSaidaDerivadaY3+" ; "+processarSaidaDerivadaZ3+")<b>âz</b> A/m<sup>2</sup>"));


                            infoM.setText(Html.fromHtml("<b>Ä(ᵨ,ᵩ,z)</b> = "+processx+"<b>âᵨ</b> +" +
                                    "<br> .. "+processy+"<b>âᵩ</b> + " +
                                    "<br> .. "+processz+"<b>âz</b>"+
                                    "<br>" +
                                    "<br>" +
                                    "<b>J</b> = -[1/m0]*∇<sup>2</sup><b>Ä</b>" +
                                    "<b>J</b> = -[1/m0]*(∇<sup>2</sup>Aᵨ, ∇<sup>2</sup>Aᵩ, ∇<sup>2</sup>Az)" +
                                    "<br>" +
                                    "<br> m0 é a constante de permeabidade que, no vácuo vale: 4π*10<sup>-7</sup> H/m" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇<sup>2</sup>Aᵨ = [∂<sup>2</sup>Äᵨ/∂<sup>2</sup>x]<b>âᵨ</b>  +" +
                                    "<br> ..... (1/ᵨ)*[∂<sup>2</sup>Äᵨ/∂<sup>2</sup>y]<b>âᵩ</b>  +" +
                                    "<br> ..... [∂<sup>2</sup>Äᵨ/∂<sup>2</sup>z]<b>âz</b>  " +
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇<sup>2</sup>Aᵩ = [∂<sup>2</sup>Äᵩ/∂<sup>2</sup>x]<b>âᵨ</b>  +" +
                                    "<br> ..... (1/ᵨ)*[∂<sup>2</sup>Äᵩ/∂<sup>2</sup>y]<b>âᵩ</b>  +" +
                                    "<br> ..... [∂<sup>2</sup>Äᵩ/∂<sup>2</sup>z]<b>âz</b>  " +
                                    "<br>" +
                                    "<br>" +
                                    "<br>∇<sup>2</sup>Az = [∂<sup>2</sup>Äz/∂<sup>2</sup>x]<b>âᵨ</b>  +" +
                                    "<br> ..... (1/ᵨ)*[∂<sup>2</sup>Äz/∂<sup>2</sup>y]<b>âᵩ</b>  +" +
                                    "<br> ..... [∂<sup>2</sup>Äz/∂<sup>2</sup>z]<b>âz</b>  " +
                                    "<br>" +
                                    "<br>" +
                                    "<br> ∇<sup>2</sup>Aᵨ = " +
                                    "<br> .. ["+processarSaida+"]<b>âᵨ</b>" +
                                    "<br> .. ["+processarSaidaY+"]<b>âᵩ</b>" +
                                    "<br> .. ["+processarSaidaZ+"]<b>âz</b>" +
                                    "<br> + " +
                                    "<br> ∇<sup>2</sup>Aᵩ = " +
                                    "<br> .. ["+processarSaida2+"]<b>âᵨ</b>" +
                                    "<br> .. ["+processarSaidaY2+"]<b>âᵩ</b>" +
                                    "<br> .. ["+processarSaidaZ2+"]<b>âz</b>" +
                                    "<br> + " +
                                    "<br> ∇<sup>2</sup>Az = " +
                                    "<br> .. ["+processarSaida3+"]<b>âᵨ</b>" +
                                    "<br> .. ["+processarSaidaY3+"]<b>âᵩ</b>" +
                                    "<br> .. ["+processarSaidaZ3+"]<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br>" +
                                    "<b>J</b> = " +
                                    "<br> -[1/m0]*("+processarSaidaDerivada+" ; "+processarSaidaDerivadaY+" ; "+processarSaidaDerivadaZ+")<b>âᵨ</b> +"+
                                    "<br> -[1/m0]*("+processarSaidaDerivada2+" ; "+processarSaidaDerivadaY2+" ; "+processarSaidaDerivadaZ2+")<b>âᵩ/b> +"+
                                    "<br> -[1/m0]*("+processarSaidaDerivada3+" ; "+processarSaidaDerivadaY3+" ; "+processarSaidaDerivadaZ3+")<b>âz</b>"+
                                    "<br>" +
                                    "<br>" +
                                    "<b>J</b> = " +
                                    "<br> ("+df.format(resultx)+" ; "+df.format(resulty)+" ; "+df.format(resultz)+")<b>âᵨ</b> +"+
                                    "<br> ("+df.format(resultx2)+" ; "+df.format(resulty2)+" ; "+df.format(resultz2)+")<b>âᵩ</b> +"+
                                    "<br> ("+df.format(resultx3)+" ; "+df.format(resulty3)+" ; "+df.format(resultz3)+")<b>âz</b A/m<sup>2</sup>"
                            ));

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

    /**
     * Tela de passo a passo fica visivel/invisivel*/
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