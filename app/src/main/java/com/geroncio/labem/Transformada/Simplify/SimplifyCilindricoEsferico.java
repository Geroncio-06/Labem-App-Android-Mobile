package com.geroncio.labem.Transformada.Simplify;

public class SimplifyCilindricoEsferico {

    public String entrada;
    public String saida, saidareduzida, saidarefinada;





    public SimplifyCilindricoEsferico(){
        //..
    }


    public void setSimplificar( String function){
        this.entrada = function;

    }

    public String getSimplificarSaida(){
        return this.saida;
    }

    public  void  simplificar(){


        this.entrada = this.entrada.replace("ᵩc","ᵩ");
        this.entrada = this.entrada.replace("ᵨ","ᵨc");
        this.entrada = this.entrada.replace("z","ᵨe*cos(Ɵ)");

        this.entrada = this.entrada.replace("arcsin(ᵨc/sqrt(ᵨc^(2)+ᵨe*cos(Ɵ)^(2)))","Ɵ");
        this.entrada = this.entrada.replace("arccos(ᵨe*cos(Ɵ)/sqrt(ᵨc^(2)+ᵨe*cos(Ɵ)^(2)))","Ɵ");

        this.entrada = this.entrada.replace("2*ᵨc^(2)","2*ᵨe^(2)*sin(Ɵ)^(2)"); this.entrada = this.entrada.replace("sqrt(2*ᵨc^(2))","ᵨe*sin(Ɵ)*sqrt(2)");
        this.entrada = this.entrada.replace("ᵨc^(2)","ᵨe^(2)*sin(Ɵ)^(2)"); this.entrada = this.entrada.replace("sqrt(ᵨc^(2))","ᵨe*sin(Ɵ)");

        this.entrada = this.entrada.replace("ᵨc^(2)*sin(ᵩ)^(2)","ᵨe^(2)*sin(Ɵ)^(2)*sin(ᵩ)^(2)");
        this.entrada = this.entrada.replace("ᵨc^(2)*cos(ᵩ)^(2)","ᵨe^(2)*sin(Ɵ)^(2)*cos(ᵩ)^(2)");


        this.entrada = this.entrada.replace("ᵨc^(2)*cos(ᵩ)","ᵨe^(2)*sin(Ɵ)^(2)*cos(ᵩ)");
        this.entrada = this.entrada.replace("ᵨc^(2)*sin(ᵩ)","ᵨe^(2)*sin(Ɵ)^(2)*sin(ᵩ)");

        this.entrada = this.entrada.replace("cos(ᵩ)^(2)*ᵨc^(2)","ᵨe^(2)*sin(Ɵ)^(2)*cos(ᵩ)^(2)");
        this.entrada = this.entrada.replace("sin(ᵩ)^(2)*ᵨc^(2)","ᵨe^(2)*sin(Ɵ)^(2)*sin(ᵩ)^(2)");

        this.entrada = this.entrada.replace("tan(ᵩ)/ᵨc*cos(ᵩ)","(tan(ᵩ)/ᵨe*sin(Ɵ)*cos(ᵩ))");


        this.entrada = this.entrada.replace("ᵨc+ᵩ^(", "ᵨc+(ᵩ)^("); this.entrada = this.entrada.replace("ᵩ+ᵨc^(", "ᵩ+(ᵨc)^(");
        this.entrada = this.entrada.replace("ᵨc-ᵩ^(", "ᵨc-(ᵩ)^("); this.entrada = this.entrada.replace("ᵩ-ᵨc^(", "ᵩ-(ᵨc)^(");

        this.entrada = this.entrada.replace("ᵨc*(cos(ᵩ)+sin(ᵩ))","ᵨe*sin(Ɵ)*(cos(ᵩ)+sin(ᵩ))"); this.entrada = this.entrada.replace("ᵨc*(sin(ᵩ)+cos(ᵩ))","ᵨe*sin(Ɵ)*(cos(ᵩ)+sin(ᵩ))");
        this.entrada = this.entrada.replace("ᵨc*(cos(ᵩ)-sin(ᵩ))","ᵨe*sin(Ɵ)*(cos(ᵩ)-sin(ᵩ))"); this.entrada = this.entrada.replace("ᵨc*(-cos(ᵩ)+sin(ᵩ))","ᵨe*sin(Ɵ)*(cos(ᵩ)-sin(ᵩ))");
        this.entrada = this.entrada.replace("ᵨc*cos(ᵩ)","ᵨe*sin(Ɵ)*cos(ᵩ)");
        this.entrada = this.entrada.replace("ᵨc*sin(ᵩ)","ᵨe*sin(Ɵ)*sin(ᵩ)");
        this.entrada = this.entrada.replace("ᵨc","ᵨe*sin(Ɵ)");
        this.entrada = this.entrada.replace("ᵨe","r");
        this.entrada = this.entrada.replace("z","r*cos(Ɵ)");

        this.saida = this.entrada;


    }

    public void simplificarReduzida(){

        this.entrada = this.entrada.replace("ᵨ","r*sin(Ɵ)");
        this.entrada = this.entrada.replace("z","r*cos(Ɵ)");

        this.saidareduzida = this.entrada;
    }



    public String getSimplificarSaidaReduzida(){
        return this.saidareduzida;
    }

}



