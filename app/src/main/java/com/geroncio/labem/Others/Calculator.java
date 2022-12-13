package com.geroncio.labem.Others;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.text.Html;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.text.DecimalFormat;

import com.geroncio.labem.MainActivity2;
import com.geroncio.labem.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Calculator extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    android.widget.Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnigu, btnsom, btnsub, btnmul, btndiv, btnpor, btnpl,btnpr, btnc, btnvir, btnbackspace;
    android.widget.Button btnshift, btndeg, btnabs, btnlog2, btnraiz, btnx2, btnx, btnlog10, btnln, btnsin, btncos, btntan, btnsinh, btncosh, btntanh, btn10x, btnans;
    TextView txtoutput;
    EditText txtimput;
    ImageButton voltar;
    String process, corretor;
    String finalResult = "";
    boolean checkshift = false;
    boolean checkdeg = false;

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);



        Inicializate();




        voltar.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            String main = "nomain";
            i.putExtra("STRING_I_FIELD", main);
            startActivity(i);
            finish();
        });

        btnc.setOnClickListener(view -> {
            txtimput.setText("");
            txtoutput.setText("");
        });
        btn0.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "0");
        });
        btn1.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "1");
        });
        btn2.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "2");
        });
        btn3.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "3");
        });
        btn4.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "4");
        });
        btn5.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "5");
        });
        btn6.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "6");
        });
        btn7.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "7");
        });
        btn8.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "8");
        });
        btn9.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "9");
        });
        btndiv.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "/");
        });
        btnmul.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "×");
        });
        btnsub.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "-");
        });
        btnsom.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "+");
        });
        btnvir.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + ".");
        });
        btnpor.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "%");
        });
        btnpl.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "(");

        });
        btnpr.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + ")");

        });
        btnbackspace.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtoutput.setText("");
            if (process.length()>1){
                process = process.substring(0, process.length() - 1);
                txtimput.setText(process);
            }
            else {
                txtimput.setText("");
            }
        });
        btnigu.setOnClickListener(view -> {
            final DecimalFormat df = new DecimalFormat("0.#####");
            float res=0;



            process = txtimput.getText().toString();
            process = process.replaceAll("×", "*");
            process = process.replaceAll("÷", "/");
            process = process.replaceAll("%", "/100");
            process = process.replaceAll("√", "sqrt");
            process = process.replaceAll("log", "log10");
            process = process.replaceAll("ln", "log");





            try {
                Expression e0 = new ExpressionBuilder(process)
                        .build();
                double result = e0.evaluate();

                finalResult = df.format(result);
                corretor = finalResult.replaceAll(",", ".");
                corretor = corretor.replaceAll("1.5708","π/2");
                corretor = corretor.replaceAll("3.14159","π");
                corretor = corretor.replaceAll("2.35619","3π/4");
                corretor = corretor.replaceAll("0.7854","π/4");
                corretor = corretor.replaceAll("3.92699","5π/4");
                corretor = corretor.replaceAll("4.71239","3π/2");
                corretor = corretor.replaceAll("5.49779","7π/4");
                corretor = corretor.replaceAll("6.28319","2π");
                corretor = corretor.replaceAll("1.0472","π/3");



                txtoutput.setText(corretor);




            }catch (Exception e){
                finalResult="Error";
                txtoutput.setText(finalResult);

            }

            btnans.setEnabled(true);


        });
        btnans.setOnClickListener(view -> {
            final DecimalFormat df = new DecimalFormat("0.#####");
            double res = 0;

            if (!finalResult.equals("Error")){
                process = txtimput.getText().toString();
                txtimput.setText(process+corretor);
                txtoutput.setText("");
            }
        });
        btn10x.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            if (checkshift) {
                txtimput.setText(process + "π");
            }
            else {
                txtimput.setText(process + "×10^");
            }
        });
        btnabs.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "abs(");
        });
        btnlog2.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "log2(");
        });
        btnln.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            if (checkshift) {
                txtimput.setText(process + "e^");
            }
            else {
                txtimput.setText(process+"ln(");
            }
        });
        btnlog10.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            if (checkshift) {
                txtimput.setText(process + "10^");
            }
            else {
                txtimput.setText(process+"log(");
            }
        });
        btnx2.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            if (checkshift) {
                txtimput.setText(process + "^3");
            }
            else {
                txtimput.setText(process+"^2");
            }
        });
        btnx.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            if (checkshift) {
                txtimput.setText(process + "^(1/");
            }
            else {
                txtimput.setText(process+"^");
            }
        });
        btnraiz.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "√(");
        });
        btnsin.setOnClickListener(view -> {

            if (checkdeg) {
                process = txtimput.getText().toString();
                if (checkshift) {
                    txtimput.setText(process + "(180/π)asin(");
                }
                else {
                    txtimput.setText(process+"sin((π/180)");
                }

            }
            else {

                process = txtimput.getText().toString();
                if (checkshift) {
                    txtimput.setText(process + "asin(");
                }
                else {
                    txtimput.setText(process+"sin(");
                }
            }


        });
        btncos.setOnClickListener(view -> {
            if (checkdeg) {
                process = txtimput.getText().toString();
                if (checkshift) {
                    txtimput.setText(process + "(180/π)acos(");
                }
                else {
                    txtimput.setText(process+"cos((π/180)");
                }
            }
            else {

                process = txtimput.getText().toString();
                if (checkshift) {
                    txtimput.setText(process + "acos(");
                }else {
                    txtimput.setText(process+"cos(");
                }
            }
        });
        btntan.setOnClickListener(view -> {

            if (checkdeg) {
                process = txtimput.getText().toString();
                if (checkshift) {
                    txtimput.setText(process + "(180/π)atan(");
                }
                else {
                    txtimput.setText(process+"tan((π/180)");
                }
            }
            else {

                process = txtimput.getText().toString();
                if (checkshift) {
                    txtimput.setText(process + "atan(");
                }
                else {
                    txtimput.setText(process+"tan(");
                }
            }
        });
        btnsinh.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "sinh(");
        });
        btncosh.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "cosh(");
        });
        btntanh.setOnClickListener(view -> {
            process = txtimput.getText().toString();
            txtimput.setText(process + "tanh(");
        });
        btnshift.setOnClickListener(view -> {
            if (checkshift){
                btnshift.setBackgroundResource(R.drawable.buttom_calculator);
                btnshift.setTextColor(Color.rgb(255,204,0));

                btnx2.setText(Html.fromHtml(" x&sup2"));
                btnx2.setTextColor(Color.rgb(118,118,118));

                btnx.setText(Html.fromHtml("x^"));
                btnx.setTextColor(Color.rgb(118,118,118));

                btnlog10.setText(Html.fromHtml("log()"));
                btnlog10.setTextColor(Color.rgb(118,118,118));

                btnln.setText(Html.fromHtml("ln"));
                btnln.setTextColor(Color.rgb(118,118,118));

                btnsin.setText(Html.fromHtml(" sin"));
                btnsin.setTextColor(Color.rgb(118,118,118));

                btncos.setText(Html.fromHtml(" cos"));
                btncos.setTextColor(Color.rgb(118,118,118));

                btntan.setText(Html.fromHtml(" tan"));
                btntan.setTextColor(Color.rgb(118,118,118));

                btn10x.setText(Html.fromHtml("×10^"));
                btn10x.setTextColor(Color.rgb(118,118,118));



                checkshift = false;
            }
            else {
                btnshift.setBackgroundResource(R.drawable.buttom_shift);
                btnshift.setTextColor(Color.WHITE);

                btnx2.setText(Html.fromHtml(" x&sup3"));
                btnx2.setTextColor(Color.rgb(255,204,0));

                btnx.setText(Html.fromHtml(" ^√"));
                btnx.setTextColor(Color.rgb(255,204,0));

                btnlog10.setText(Html.fromHtml(" 10^"));
                btnlog10.setTextColor(Color.rgb(255,204,0));

                btnln.setText(Html.fromHtml(" e^"));
                btnln.setTextColor(Color.rgb(255,204,0));


                btnsin.setText(Html.fromHtml(" sin-&sup1"));
                btnsin.setTextColor(Color.rgb(255,204,0));

                btncos.setText(Html.fromHtml(" cos-&sup1"));
                btncos.setTextColor(Color.rgb(255,204,0));

                btntan.setText(Html.fromHtml(" tan-&sup1"));
                btntan.setTextColor(Color.rgb(255,204,0));

                btn10x.setText(Html.fromHtml("π"));
                btn10x.setTextColor(Color.rgb(255,204,0));




                checkshift = true;
            }
        });
        btndeg.setOnClickListener(view -> {
            if (checkdeg){
                btndeg.setText("DEG");
                checkdeg = false;}
            else {
                btndeg.setText("RAD");
                checkdeg = true;}
        });

    }

    private void Inicializate() {
        bottomNavigationView = findViewById(R.id.bottom_navigation3);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnigu = findViewById(R.id.btnigu);
        btnsom = findViewById(R.id.btnsom);
        btnsub = findViewById(R.id.btnsub);
        btnmul = findViewById(R.id.btnmul);
        btndiv = findViewById(R.id.btndiv);
        btnpor = findViewById(R.id.btnpor);
        btnpl = findViewById(R.id.btnpl);
        btnpr = findViewById(R.id.btnpr);
        btnc = findViewById(R.id.btnc);
        btnvir = findViewById(R.id.btnvir);
        btnshift = findViewById(R.id.btnshift);
        btndeg = findViewById(R.id.btndeg);
        btnans = findViewById(R.id.btnans);
        btn10x = findViewById(R.id.btn10x);
        btnabs = findViewById(R.id.btnabs);
        btnlog2 = findViewById(R.id.btnlog);
        btnraiz = findViewById(R.id.btnraiz);
        btnx2 = findViewById(R.id.btnx2);
        btnx = findViewById(R.id.btnx);
        btnlog10 = findViewById(R.id.btnlog10);
        btnln = findViewById(R.id.btnln);
        btnsin = findViewById(R.id.btnsin);
        btncos = findViewById(R.id.btncos);
        btntan = findViewById(R.id.btntan);
        btnsinh = findViewById(R.id.btnsinh);
        btncosh = findViewById(R.id.btncosh);
        btntanh = findViewById(R.id.btntanh);
        btnbackspace = findViewById(R.id.btnbackspace);
        txtimput = findViewById(R.id.txtimput);
        txtoutput = findViewById(R.id.txtoutput);
        voltar = findViewById(R.id.voltar);


        btnx2.setText(Html.fromHtml(" x&sup2"));
    }


    @Override
    protected void onResume(){
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.calculator);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.home:
                    startActivity(new Intent(getApplicationContext()
                            , MainActivity2.class));
                    overridePendingTransition(0, 0);
                    return true;

                case R.id.calculator:
                    return true;


                case R.id.settings:
                    startActivity(new Intent(getApplicationContext()
                            ,Settings.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });
    }

}