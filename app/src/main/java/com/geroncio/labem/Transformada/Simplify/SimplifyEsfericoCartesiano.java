package com.geroncio.labem.Transformada.Simplify;

public class SimplifyEsfericoCartesiano {

    public String entrada;
    public String saida, saidareduzida, saidarefinada;





    public SimplifyEsfericoCartesiano(){
        //..
    }


    public void setSimplificar( String function){
        this.entrada = function;

    }

    public String getSimplificarSaida(){
        return this.saida;
    }

    public  void  simplificar(){

        this.entrada = this.entrada.replace("sqrt(","sqgt(");
        this.entrada = this.entrada.replace("r","ᵨ");

        this.entrada = this.entrada.replace("ᵨ^(2)","x^(2)+y^(2)+z^(2)"); this.entrada = this.entrada.replace("sqgt(ᵨ^(2))","ᵨ");
        this.entrada = this.entrada.replace("2*ᵨ^(2)","2*x^(2)+2*y^(2)+2*z^(2)"); this.entrada = this.entrada.replace("sqgt(2*ᵨ^(2))","ᵨ*sqgt(2)");
        this.entrada = this.entrada.replace("ᵨ^(2)","x^(2)+y^(2)+z^(2)"); this.entrada = this.entrada.replace("sqgt(ᵨ^(2))","ᵨ");

        this.entrada = this.entrada.replace("ᵨ^(4)*sin(Ɵ)^(4)*cos(ᵩ)^(2)*sin(ᵩ)^(2)","x^(2)*y^(2)");
        this.entrada = this.entrada.replace("ᵨ^(4)*sin(Ɵ)^(2)*cos(Ɵ)^(2)*cos(ᵩ)^(2)","x^(2)*z^(2)");
        this.entrada = this.entrada.replace("ᵨ^(4)*sin(Ɵ)^(2)*cos(Ɵ)^(2)*sin(ᵩ)^(2)","y^(2)*z^(2)");

        this.entrada = this.entrada.replace("ᵨ^(2)*sin(Ɵ)^(2)*cos(ᵩ)*sin(ᵩ)","x*y"); this.entrada = this.entrada.replace("ᵨ^(2)*cos(ᵩ)*sin(Ɵ)^(2)","x*y");
        this.entrada = this.entrada.replace("ᵨ^(2)*sin(Ɵ)*cos(Ɵ)*cos(ᵩ)","x*z"); this.entrada = this.entrada.replace("ᵨ^(2)*cos(Ɵ)*sin(Ɵ)*cos(ᵩ)","x*z");
        this.entrada = this.entrada.replace("ᵨ^(2)*sin(Ɵ)*cos(Ɵ)*sin(ᵩ)","y*z"); this.entrada = this.entrada.replace("ᵨ^(2)*cos(Ɵ)*sin(ᵩ)*sin(Ɵ)","y*z");

        this.entrada = this.entrada.replace("ᵨ^(2)*sin(Ɵ)^(2)*cos(ᵩ)^(2)","x^(2)");
        this.entrada = this.entrada.replace("ᵨ^(2)*sin(Ɵ)^(2)*sin(ᵩ)^(2)","y^(2)");
        this.entrada = this.entrada.replace("ᵨ^(2)*cos(Ɵ)^(2)","z^(2)");

        this.entrada = this.entrada.replace("tan(ᵩ)^(2)","(y^(2)/x^(2))" );
        this.entrada = this.entrada.replace("tan(ᵩ)^(-2)","x^(2)/y^(2)" );

        this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*cos(ᵩ)/y^(2)", "(x/y^(2))");
        this.entrada = this.entrada.replace("tan(ᵩ)^(-1)","(x/y)");
        this.entrada = this.entrada.replace("tan(Ɵ)/cos(ᵩ)","(x/z)"); this.entrada = this.entrada.replace("cos(ᵩ)/tan(Ɵ)","(z/x)");
        this.entrada = this.entrada.replace("tan(Ɵ)*sin(ᵩ)","(y/z)"); this.entrada = this.entrada.replace("(tan(Ɵ)*sin(ᵩ))^(-1)","(z/y)");

        this.entrada = this.entrada.replace("y^(2)/ᵨ*sin(Ɵ)*cos(ᵩ)", "(y^(2)/x)"); this.entrada = this.entrada.replace("x^(2)/ᵨ*sin(Ɵ)*sin(ᵩ)", "(x^(2)/y)");


        this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*(cos(ᵩ)+sin(ᵩ))","(x+y)"); this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*cos(ᵩ)+ᵨ*sin(Ɵ)*sin(ᵩ)","(x+y)");
        this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*(cos(ᵩ)-sin(ᵩ))","(x-y)"); this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*cos(ᵩ)-ᵨ*sin(Ɵ)*sin(ᵩ)","(x-y)");

        this.entrada = this.entrada.replace("ᵨ*(sin(Ɵ)*cos(ᵩ)+cos(Ɵ))","(x+z)"); this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*cos(ᵩ)+ᵨ*cos(Ɵ)","(x+z)");
        this.entrada = this.entrada.replace("ᵨ*(sin(Ɵ)*cos(ᵩ)-cos(Ɵ))","(x-z)"); this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*cos(ᵩ)-ᵨ*cos(Ɵ)","(x-z)");

        this.entrada = this.entrada.replace("ᵨ*(sin(Ɵ)*sin(ᵩ)+cos(Ɵ))","(y+z)"); this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*sin(ᵩ)+ᵨ*cos(Ɵ)","(y+z)");
        this.entrada = this.entrada.replace("ᵨ*(sin(Ɵ)*sin(ᵩ)-cos(Ɵ))","(y-z)"); this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*sin(ᵩ)-ᵨ*cos(Ɵ)","(y-z)");

        this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*cos(ᵩ)","x");
        this.entrada = this.entrada.replace("ᵨ*sin(Ɵ)*sin(ᵩ)","y");
        this.entrada = this.entrada.replace("ᵨ*cos(Ɵ)","z");

        this.entrada = this.entrada.replace("ᵨ","sqrt(x^(2)+y^(2)+z^(2))");
        this.entrada = this.entrada.replace("tan(Ɵ)","(sqgt(x^(2)+y^(2))/z)");
        this.entrada = this.entrada.replace("tan(ᵩ)","(y/x)");
        this.entrada = this.entrada.replace("sin(Ɵ)","(sqgt(x^(2)+y^(2))/sqrt(x^(2)+y^(2)+z^(2)))");
        this.entrada = this.entrada.replace("cos(Ɵ)","(z/sqgt(x^(2)+y^(2)+z^(2)))");
        this.entrada = this.entrada.replace("sin(ᵩ)","(y/sqgt(x^(2)+y^(2)))");
        this.entrada = this.entrada.replace("cos(ᵩ)","(x/sqgt(x^(2)+y^(2)))");
        this.entrada = this.entrada.replace("Ɵ","arctan(sqgt(x^(2)+y^(2))/z)");
        this.entrada = this.entrada.replace("ᵩ","arctan(y/x)");

        this.entrada = this.entrada.replace("sqgt(","sqrt(");

        this.saida = this.entrada;


    }

    public void simplificarReduzida(){

        this.entrada = this.entrada.replace("sqrt(","sqgt(");
        this.entrada = this.entrada.replace("r","sqgt(x^(2)+y^(2)+z^(2))");
        this.entrada = this.entrada.replace("tan(Ɵ)","(sqgt(x^(2)+y^(2))/z)");
        this.entrada = this.entrada.replace("tan(ᵩ)","(y/x)");
        this.entrada = this.entrada.replace("Ɵ","arctan(sqgt(x^(2)+y^(2))/z)");
        this.entrada = this.entrada.replace("ᵩ","arctan(y/x)");

        this.entrada = this.entrada.replace("sqgt(","sqrt(");

        this.saidareduzida = this.entrada;
    }



    public String getSimplificarSaidaReduzida(){
        return this.saidareduzida;
    }


}



