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

import com.geroncio.labem.Others.Info;
import com.geroncio.labem.R;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class CmLinhacoaxiallonga extends AppCompatActivity {

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btnxn, btnpi;
    TextView txtimputx, info, infoM;
    EditText raio_A = null, raio_B = null,  raio_P = null, espessura_T = null;
    Double raioA = (double) 0, raioB = (double) 0,  raioP = (double) 0, espessuraT = (double) 0;
    String processx = null;
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
    String formula, situacao;
    Expression resolver;
    double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_linhacoaxiallonga);

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

        CalcularFinito();
    }

    private void Inicializate() {

        calcular = findViewById(R.id.calcular);
        fxCalculator = findViewById(R.id.calculator_fxvisible);
        fxCalculatorLayout = findViewById(R.id.calculadora_fx);
        info = findViewById(R.id.infoM);
        infoM = findViewById(R.id.passosresult);
        txtimputx = findViewById(R.id.btnimputx);
        raio_A = findViewById(R.id.raioA);
        raio_B = findViewById(R.id.raioB);
        raio_P = findViewById(R.id.p_4);
        espessura_T = findViewById(R.id.espessura);


        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        anglayout = findViewById(R.id.anglayout);
        progress = findViewById(R.id.progress);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "CmLinhacoaxiallonga.class";
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



                try{

                    info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                    info.setTextColor(getResources().getColor(R.color.black));

                    raioA = Double.parseDouble(raio_A.getText().toString());
                    raioB = Double.parseDouble(raio_B.getText().toString());
                    raioP = Double.parseDouble(raio_P.getText().toString());
                    espessuraT = Double.parseDouble(espessura_T.getText().toString());

                    if (raioP>(raioB + espessuraT)){

                        info.setText(Html.fromHtml("<b>H</b> = 0 A/m " ));


                        infoM.setText(Html.fromHtml("" +
                                "O ponto que calculamos o campo magnético éstá do lado de fora do cabo coaxial, e para essa configuração o valor do campo é nulo."));

                        Passos();

                    }
                    else{

                        Expression processs = new ExpressionBuilder("("+processx+")")
                                .variables("x")
                                .build()
                                .setVariable("x",1);
                        double Densidadecorrente = processs.evaluate();


                        if (raioP >= 0 && raioP<=raioA){

                            formula = "I*ᵨ/[2*π*a<sup>2</sup>] <b>aᵩ</b>";
                            situacao = "0 ≤ ᵨ ≤ a";

                            resolver = new ExpressionBuilder("("+Densidadecorrente+")*("+raioP+")/(2*π*"+Math.pow(raioA,2)+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            resultado = resolver.evaluate();

                        }
                        if (raioP > raioA && raioP<=raioB){

                            formula = "I/[2*π*ᵨ] <b>aᵩ</b>";
                            situacao = "a ≤ ᵨ ≤ b";

                            resolver = new ExpressionBuilder("("+Densidadecorrente+")/(2*π*"+raioP+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            resultado = resolver.evaluate();

                        }

                        if (raioP > raioB && raioP<=(raioB + espessuraT)){

                            formula = "[I/(2*π*ᵨ)]*[1 - (ᵨ<sup>2</sup> - b<sup>2</sup>)/(t<sup>2</sup> + 2*b*t)] <b>aᵩ</b>";
                            situacao = "b ≤ ᵨ ≤ b+t";

                            resolver = new ExpressionBuilder("("+Densidadecorrente+")*(1 - (("+Math.pow(raioP,2)+"-"+Math.pow(raioB,2)+")/("+Math.pow(espessuraT,2)+"+ 2*"+raioB+"*"+espessuraT+")))/(2*π*"+raioP+")")
                                    .variables("x")
                                    .build()
                                    .setVariable("x",1);
                            resultado = resolver.evaluate();

                        }


                        info.setText(Html.fromHtml("<b>H</b> = "+df.format(resultado) +"<b>aᵩ</b> A/m"));


                        infoM.setText(Html.fromHtml("<b>H</b> = "+formula+
                                "<br>"+
                                "<br>Para uma situação onde: " +situacao+
                                "<br>"+
                                "<br>" +
                                "<br> .. I = " +df.format(Densidadecorrente)+" A"+
                                "<br>" +
                                "<br> .. a = "+df.format(raioA)+" m"+
                                "<br> .. b = "+df.format(raioB)+" m"+
                                "<br> .. t = "+df.format(espessuraT)+" m"+
                                "<br>" +
                                "<br> Substituindo os valores na fórmula, temos que:" +
                                "<br>"+
                                "<br>" +
                                "<b>H</b> = "+df.format(resultado) +"<b>aᵩ</b> A/m"));

                        Passos();



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
                layoutParams.height = 1000;
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