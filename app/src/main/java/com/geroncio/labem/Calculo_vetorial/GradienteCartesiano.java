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

public class GradienteCartesiano extends AppCompatActivity {

    /**
     * Definindo variaveis globais*/

    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnsom, btnsub, btnmul, btndiv, btnpi, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btne, btnlog2, btnraiz, btnx2, btnxn, btnlog10, btnln, btnsin, btncos, btntan, btnsinh, btncosh, btntanh, btnx, btny,btnz;
    TextView txtimput, info, infoM;
    String process = null;
    EditText p_1 = null, p_2 = null, p_3 = null;
    Double p1 = null, p2 = null, p3 = null;
    ProgressBar progress;
    android.widget.Button calcular;
    ImageButton fxCalculator;
    LinearLayout fxCalculatorLayout;
    LinearLayout.LayoutParams params;
    boolean teclado = false;
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
        setContentView(R.layout.activity_gradiente_cartesiano);

        Inicializate();
        InicializateTeclado();

        fxCalculator.setOnClickListener(view -> {

            if (teclado){
                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 0;
                fxCalculatorLayout.setLayoutParams(params);
                teclado = false;

            }
            else {
                params = (LinearLayout.LayoutParams) fxCalculatorLayout.getLayoutParams();
                params.height = 450;
                fxCalculatorLayout.setLayoutParams(params);
                teclado = true;}

        });

        Teclado();
        Calcular();

    }

    /**
     * Linkando variaveis globais com objetos na tela de layout*/
    private void Inicializate() {

        calcular = findViewById(R.id.calcular);
        fxCalculator = findViewById(R.id.calculator_fxvisible);
        fxCalculatorLayout = findViewById(R.id.calculadora_fx);
        info = findViewById(R.id.infoM);
        infoM = findViewById(R.id.passosresult);
        p_1 = findViewById(R.id.p_1);
        p_2 = findViewById(R.id.p_2);
        p_3 = findViewById(R.id.p_3);
        passos =findViewById(R.id.passos); layoutpassos = findViewById(R.id.layoutpassos);
        progress = findViewById(R.id.progress);
        ajuda = findViewById(R.id.info);

        ajuda.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), Info.class);
            String main = "GradienteCartesiano.class";
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
        txtimput = findViewById(R.id.btnimput);



        btnx2.setText(Html.fromHtml(" x&sup2"));
        btnpi.setText(Html.fromHtml("&pi"));
    }

    private  void Teclado(){

        btnc.setOnClickListener(view -> {
            txtimput.setText("");
            process = null;

            if (calculoClick){info.setText("");}
        });
        btn0.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "0";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btn1.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "1";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btn2.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "2";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btn3.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "3";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btn4.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "4";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btn5.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "5";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btn6.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "6";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btn7.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "7";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btn8.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "8";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btn9.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "9";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btndiv.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "/";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnmul.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "*";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnsub.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "-";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnsom.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "+";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnvir.setOnClickListener(view -> {
            process = txtimput.getText().toString() + ".";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnpi.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "π";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnpl.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}

        });
        btnpr.setOnClickListener(view -> {
            process = txtimput.getText().toString() + ")";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}

        });
        btnbackspace.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            if (process.length()>0){
                process = process.substring(0, process.length() - 1);
                txtimput.setText(process);

                if (calculoClick){info.setText("");}

            }
            else {
                txtimput.setText("");

                if (calculoClick){info.setText("");}
            }
        });
        btne.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "e";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnlog2.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "log2(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnln.setOnClickListener(view -> {
            process = txtimput.getText().toString() +"ln(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnlog10.setOnClickListener(view -> {
            process = txtimput.getText().toString() +"log(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}

        });
        btnx2.setOnClickListener(view -> {
            process = txtimput.getText().toString() +"^(2)";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}

        });
        btnxn.setOnClickListener(view -> {
            process = txtimput.getText().toString() +"^(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}

        });
        btnraiz.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "√(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnsin.setOnClickListener(view -> {

            process = txtimput.getText().toString() + "sin(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}

        });
        btncos.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "cos(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}

        });
        btntan.setOnClickListener(view -> {

            process = txtimput.getText().toString() + "tan(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnsinh.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "sinh(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btncosh.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "cosh(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btntanh.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "tanh(";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnx.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "x";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btny.setOnClickListener(view -> {
            process = txtimput.getText().toString() + "y";
            txtimput.setText(process);

            if (calculoClick){info.setText("");}
        });
        btnz.setOnClickListener(view -> {
            process = txtimput.getText().toString()+"z";
            txtimput.setText(process);

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

                    if (process == null){

                        progress.setVisibility(View.INVISIBLE);
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
                            process = process.replace("√","sqrt");
                            process = process.replace("π","3.14159265");
                            der.setFunctionDerivar(process);
                            der.derivar();
                            derY.setFunctionDerivar(process);
                            derY.derivar();
                            derZ.setFunctionDerivar(process);
                            derZ.derivar();

                            /**
                             * Inserindo variavel local tipo string*/

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
                            cvSimplify.setFunctionSimplificar(processarSaidaDerivada);
                            cvSimplify.simplificar();
                            processarSaidaDerivada = cvSimplify.getFunctionSimplificada();

                            processarSaidaDerivada = processarSaidaDerivada.replace("sqrt","√");


                            /**Chamando a classe Simplificar para processar as equações em formato de texto*/

                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaY);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaY = cvSimplify.getFunctionSimplificada();
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("sqrt","√");

                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaZ);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaZ = cvSimplify.getFunctionSimplificada();
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("sqrt","√");

                            process = process.replace("sqrt","√");

                            processarSaida = processarSaida.replace("sqrt","√");
                            processarSaidaY = processarSaidaY.replace("sqrt","√");
                            processarSaidaZ = processarSaidaZ.replace("sqrt","√");


                            info.setText(Html.fromHtml("<b>∇V</b> = [ "+processarSaidaDerivada+" ]<b>âx</b>" +
                                    "<br>+ " +
                                    "<br> .. [ "+ processarSaidaDerivadaY+ " ]<b>ây</b>" +
                                    "<br>+ " +
                                    "<br> .. [ "+processarSaidaDerivadaZ+" ]<b>âz</b>"
                            ));


                            infoM.setText(Html.fromHtml("V(x,y,z) = "+process+"" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>∇V</b> = (∂V/∂x)<b>âx</b> + (∂V/∂y)<b>ây</b> + (∂V/∂z)<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> <b>∇V</b> = " +
                                    "<br> .. (∂/∂x)["+process+"]<b>âx</b> + " +
                                    "<br>" +
                                    "<br> .. (∂/∂y)["+process+"]<b>ây</b> + " +
                                    "<br>" +
                                    "<br> .. (∂/∂z)["+process+"]<b>âz</b> " +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>∇V</b> = " +
                                    "<br> .. [ "+processarSaida+" ]<b>âx</b>" +
                                    "<br>+ " +
                                    "<br> .. [ "+ processarSaidaY+ " ]<b>ây</b>" +
                                    "<br>+ " +
                                    "<br> .. [ "+processarSaidaZ+" ]<b>âz</b>"+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>∇V</b> = [ "+processarSaidaDerivada+" ]<b>âx</b>" +
                                    "<br>+ " +
                                    "<br> .. [ "+ processarSaidaDerivadaY+ " ]<b>ây</b>" +
                                    "<br>+ " +
                                    "<br> .. [ "+processarSaidaDerivadaZ+" ]<b>âz</b>"
                            ));


                            Passos();

                        }
                        else{

                            calculoClick = true;
                            process = process.replace("√","sqrt");
                            process = process.replace("π","3.14159265");
                            der.setFunctionDerivar(process);
                            der.derivar();
                            derY.setFunctionDerivar(process);
                            derY.derivar();
                            derZ.setFunctionDerivar(process);
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
                            cvSimplify.setFunctionSimplificar(processarSaidaDerivada);
                            cvSimplify.simplificar();
                            processarSaidaDerivada = cvSimplify.getFunctionSimplificada();
                            String saidaX = cvSimplify.getFunctionSimplificadaAlt();

                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaY);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaY = cvSimplify.getFunctionSimplificada();
                            String saidaY = cvSimplify.getFunctionSimplificadaAlt();

                            cvSimplify.setFunctionSimplificar(processarSaidaDerivadaZ);
                            cvSimplify.simplificar();
                            processarSaidaDerivadaZ = cvSimplify.getFunctionSimplificada();
                            String saidaZ = cvSimplify.getFunctionSimplificadaAlt();



                            p1 = Double.parseDouble(p_1.getText().toString());
                            p2 = Double.parseDouble(p_2.getText().toString());
                            p3 = Double.parseDouble(p_3.getText().toString());

                            processarSaidaDerivada = processarSaidaDerivada.replace("√","sqrt");
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("√","sqrt");
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("√","sqrt");

                            saidaX = saidaX.replace("√","sqrt");
                            saidaY = saidaY.replace("√","sqrt");
                            saidaZ = saidaZ.replace("√","sqrt");

                            saidaX = saidaX.replace("log(","log10(");
                            saidaY = saidaY.replace("log(","log10(");
                            saidaZ = saidaZ.replace("log(","log10(");


                            /**
                             * Expression é o avaliador de expressão, que retorna o valor da função f(x,y,z) para um
                             * ponto que definimos (x,y,z).*/

                            Expression ex = new ExpressionBuilder(saidaX)
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultx = ex.evaluate();

                            Expression ey = new ExpressionBuilder(saidaY)
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resulty = ey.evaluate();

                            Expression ez = new ExpressionBuilder(saidaZ)
                                    .variables("x","y","z")
                                    .build()
                                    .setVariable("x",p1)
                                    .setVariable("y",p2)
                                    .setVariable("z",p3);
                            double resultz = ez.evaluate();

                            process = process.replace("sqrt","√");

                            processarSaida = processarSaida.replace("sqrt","√");
                            processarSaidaY = processarSaidaY.replace("sqrt","√");
                            processarSaidaZ = processarSaidaZ.replace("sqrt","√");


                            processarSaidaDerivada = processarSaidaDerivada.replace("sqrt","√");
                            processarSaidaDerivadaY = processarSaidaDerivadaY.replace("sqrt","√");
                            processarSaidaDerivadaZ = processarSaidaDerivadaZ.replace("sqrt","√");


                            String inforesult = "<b>∇V</b> = "+ df.format(resultx) +"<b>âx</b> + "
                                    + df.format(resulty) + "<b>ây</b> + "+ df.format(resultz) +"<b>âz</b>";

                            inforesult = inforesult.replace("+-","-");


                            info.setText(Html.fromHtml(inforesult));


                            infoM.setText(Html.fromHtml("V(x,y,z) = "+process+"" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>∇V</b> = (∂V/∂x)<b>âx</b> + (∂V/∂y)<b>ây</b> + (∂V/∂z)<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br> <b>∇V</b> = " +
                                    "<br> .. (∂/∂x)["+process+"]<b>âx</b> + " +
                                    "<br>" +
                                    "<br> .. (∂/∂y)["+process+"]<b>ây</b> + " +
                                    "<br>" +
                                    "<br> .. (∂/∂z)["+process+"]<b>âz</b> " +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>∇V</b> = " +
                                    "<br> .. [ "+processarSaida+" ]<b>âx</b>" +
                                    "<br>+ " +
                                    "<br> .. [ "+ processarSaidaY+ " ]<b>ây</b>" +
                                    "<br>+ " +
                                    "<br> .. [ "+processarSaidaZ+" ]<b>âz</b>"+
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>∇V</b> = [ "+processarSaidaDerivada+" ]<b>âx</b>" +
                                    "<br>+ " +
                                    "<br> .. [ "+ processarSaidaDerivadaY+ " ]<b>ây</b>" +
                                    "<br>+ " +
                                    "<br> .. [ "+processarSaidaDerivadaZ+" ]<b>âz</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>P</b> = "+ df.format(p1) +"<b>âx</b> + "+ df.format(p2) +"<b>ây</b> + "+ df.format(p3) +"<b>âz</b>" +
                                    "<br>" +
                                    "<br> Substituimos os valores de x, y e z do ponto <b>P</b> " +
                                    "<br> na resposta do gradiente <b>∇V</b>" +
                                    "<br>" +
                                    "<br>" +
                                    "<br><b>∇V</b> = "+ df.format(resultx) +"<b>âx</b> + "+ df.format(resulty) + "<b>ây</b> + "+ df.format(resultz) +"<b>âz</b>"
                            ));


                            Passos();

                        }
                    }
                }
                catch (Exception e) {
                    info.setText(R.string.erro2);
                    info.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.textdisesseis));
                    info.setTextColor(getResources().getColor(R.color.black2));
                    infoM.setText("");

                    progress.setVisibility(View.INVISIBLE);
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