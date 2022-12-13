package com.geroncio.labem.Transformada.Simplify;

public class SimplifyEsfericoCilindrico {

    public String entrada;
    public String saida, saidareduzida, saidarefinada;





    public SimplifyEsfericoCilindrico(){
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
        this.entrada = this.entrada.replace("r","ᵨw");

        this.entrada = this.entrada.replace("2*ᵨw^(2)*sin(Ɵ)^(2)","2*ᵨ^(2)");
        this.entrada = this.entrada.replace("ᵨw^(2)*sin(Ɵ)^(2)","ᵨ^(2)");

        this.entrada = this.entrada.replace("ᵨw^(2)*sin(Ɵ)^(2)*sin(ᵩ)^(2)","ᵨ^(2)*sin(ᵩ)^(2)");
        this.entrada = this.entrada.replace("ᵨw^(2)*sin(Ɵ)^(2)*cos(ᵩ)^(2)","ᵨ^(2)*cos(ᵩ)^(2)");


        this.entrada = this.entrada.replace("ᵨw^(2)*sin(Ɵ)^(2)*cos(ᵩ)","ᵨ^(2)*cos(ᵩ)");
        this.entrada = this.entrada.replace("ᵨw^(2)*sin(Ɵ)^(2)*sin(ᵩ)","ᵨ^(2)*sin(ᵩ)");


        this.entrada = this.entrada.replace("ᵨw*sin(Ɵ)*(cos(ᵩ)+sin(ᵩ))","ᵨ*(cos(ᵩ)+sin(ᵩ))");
        this.entrada = this.entrada.replace("ᵨw*sin(Ɵ)*(cos(ᵩ)-sin(ᵩ))","ᵨ*(cos(ᵩ)-sin(ᵩ))");
        this.entrada = this.entrada.replace("ᵨw*sin(Ɵ)*cos(ᵩ)","ᵨ*cos(ᵩ)");
        this.entrada = this.entrada.replace("ᵨw*sin(Ɵ)*sin(ᵩ)","ᵨ*sin(ᵩ)");
        this.entrada = this.entrada.replace("ᵨw^(2)","ᵨ^(2)+z^(2)");
        this.entrada = this.entrada.replace("sin(Ɵ)","ᵨ/sqgt(ᵨ^(2)+z^(2))");
        this.entrada = this.entrada.replace("cos(Ɵ)","z/sqgt(ᵨ^(2)+z^(2))");
        this.entrada = this.entrada.replace("tan(Ɵ)","ᵨ/z");
        this.entrada = this.entrada.replace("ᵨw^(2)*sin(Ɵ)","ᵨ*sqgt(ᵨ^(2)+z^(2))");
        this.entrada = this.entrada.replace("ᵨw^(2)*sin(Ɵ)^(2)","ᵨ^(2)");
        this.entrada = this.entrada.replace("ᵨw*sin(Ɵ)^(2)","ᵨ^(2)/sqgt(ᵨ^(2)+z^(2))");
        this.entrada = this.entrada.replace("ᵨw^(2)*cos(Ɵ)^(2)","z^(2)");
        this.entrada = this.entrada.replace("ᵨw*cos(Ɵ)","z");
        this.entrada = this.entrada.replace("ᵨw^(2)","ᵨ^(2)+z^(2)");
        this.entrada = this.entrada.replace("ᵨw","sqgt(ᵨ^(2)+z^(2))");
        this.entrada = this.entrada.replace("Ɵ","arctan(ᵨ/z)");

        this.entrada = this.entrada.replace("sqgt(","sqrt(");

        this.saida = this.entrada;


    }

    public void simplificarReduzida(){

        this.entrada = this.entrada.replace("r","ᵨw");
        this.entrada = this.entrada.replace("z","r*cos(Ɵ)");

        this.entrada = this.entrada.replace("ᵨw","ᵨ/sin(Ɵ)");
        this.entrada = this.entrada.replace("ᵨw*cos(Ɵ)","ᵨ*cos(Ɵ)");
        this.entrada = this.entrada.replace("ᵨw","ᵨ");

        this.saidareduzida = this.entrada;
    }



    public String getSimplificarSaidaReduzida(){
        return this.saidareduzida;
    }

}



