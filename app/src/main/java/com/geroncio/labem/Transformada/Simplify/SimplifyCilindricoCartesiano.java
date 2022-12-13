package com.geroncio.labem.Transformada.Simplify;

public class SimplifyCilindricoCartesiano {

    public String entrada;
    public String saida, saidareduzida, saidarefinada;





    public SimplifyCilindricoCartesiano(){
        //..
    }


    public void setSimplificar( String function){
        this.entrada = function;

    }

    public String getSimplificarSaida(){
        return this.saida;
    }

    public  void  simplificar(){



        this.entrada = this.entrada.replace("2*ᵨ^(2)","2*x^(2)+2*y^(2)"); this.entrada = this.entrada.replace("sqrt(2*ᵨ^(2))","ᵨ*sqrt(2)");
        this.entrada = this.entrada.replace("ᵨ^(2)","x^(2)+y^(2)"); this.entrada = this.entrada.replace("sqrt(ᵨ^(2))","ᵨ");

        this.entrada = this.entrada.replace("ᵨ^(4)*sin(ᵩ)^(2)*cos(ᵩ)^(2)","x^(2)*y^(2)");
        this.entrada = this.entrada.replace("ᵨ^(4)*cos(ᵩ)^(2)*sin(ᵩ)^(2)","x^(2)*y^(2)");


        this.entrada = this.entrada.replace("ᵨ^(2)*cos(ᵩ)^(2)","x^(2)");
        this.entrada = this.entrada.replace("ᵨ^(2)*sin(ᵩ)^(2)","y^(2)");

        this.entrada = this.entrada.replace("cos(ᵩ)^(2)*ᵨ^(2)","x^(2)");
        this.entrada = this.entrada.replace("sin(ᵩ)^(2)*ᵨ^(2)","y^(2)");

        this.entrada = this.entrada.replace("tan(ᵩ)/ᵨ*cos(ᵩ)","(y/x^(2))"); this.entrada = this.entrada.replace("(ᵨ*sin(ᵩ)*tan(ᵩ))^(-1)","(x/y^(2))");
        this.entrada = this.entrada.replace("tan(ᵩ)","(y/x)"); this.entrada = this.entrada.replace("tan(ᵩ)^(-1)","(x/y)");

        this.entrada = this.entrada.replace("ᵨ*sin(ᵩ)*tan(ᵩ)","(y^(2)/x)"); this.entrada = this.entrada.replace("ᵨ*cos(ᵩ)*tan(ᵩ)^(-1)","(x^(2)/y)");
        this.entrada = this.entrada.replace("tan(ᵩ)ᵨ*sin(ᵩ)","(y^(2)/x)"); this.entrada = this.entrada.replace("tan(ᵩ)^(-1)*ᵨ*cos(ᵩ)","(x^(2)/y)");

        this.entrada = this.entrada.replace("ᵨ^(2)*(1+2*cos(ᵩ)*sin(ᵩ))","(x+y)^(2)");

        this.entrada = this.entrada.replace("ᵨ+ᵩ^(", "ᵨ+(ᵩ)^("); this.entrada = this.entrada.replace("ᵩ+ᵨ^(", "ᵩ+(ᵨ)^(");
        this.entrada = this.entrada.replace("ᵨ-ᵩ^(", "ᵨ-(ᵩ)^("); this.entrada = this.entrada.replace("ᵩ-ᵨ^(", "ᵩ-(ᵨ)^(");

        this.entrada = this.entrada.replace("ᵨ*(cos(ᵩ)+sin(ᵩ))","(x+y)"); this.entrada = this.entrada.replace("ᵨ*(sin(ᵩ)+cos(ᵩ))","(x+y)");
        this.entrada = this.entrada.replace("ᵨ*(cos(ᵩ)-sin(ᵩ))","(x-y)"); this.entrada = this.entrada.replace("ᵨ*(-cos(ᵩ)+sin(ᵩ))","(x-y)");
        this.entrada = this.entrada.replace("ᵨ*cos(ᵩ)","x");
        this.entrada = this.entrada.replace("ᵨ*sin(ᵩ)","y");
        this.entrada = this.entrada.replace("ᵩ","atan(y/x)");
        this.entrada = this.entrada.replace("ᵨ","sqrt(x^(2)+y^(2))");

        this.saida = this.entrada;


    }

    public void simplificarReduzida(){

        this.entrada = this.entrada.replace("ᵨ*cos(ᵩ)","x");
        this.entrada = this.entrada.replace("ᵨ*sin(ᵩ)","y");

        this.saidareduzida = this.entrada;
    }

    public String getSimplificarSaidaReduzida(){
        return this.saidareduzida;
    }


}



