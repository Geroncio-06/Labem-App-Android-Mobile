package com.geroncio.labem.Transformada.Simplify;

public class SimplifyCartesianoEsferico {

    public String entrada;
    public String saida, saidareduzida, saidarefinada;





    public SimplifyCartesianoEsferico(){
        //..
    }


    public void setSimplificar( String function){
        this.entrada = function;

    }

    public String getSimplificarSaida(){
        return this.saida;
    }

    public  void  simplificar(){

        this.entrada = this.entrada.replace("arctan(y/x)","ᵩ");
        this.entrada = this.entrada.replace("arctan(sqrt(x^(2)+y^(2))/z)","Ɵ");

        this.entrada = this.entrada.replace("2*x^(2)+2*y^(2)+2*z^(2)","2*r^(2)"); this.entrada = this.entrada.replace("sqrt(2*r^(2))","sqrt(2)*r");
        this.entrada = this.entrada.replace("x^(2)+y^(2)+z^(2)","r^(2)"); this.entrada = this.entrada.replace("sqrt(r^(2))","r");

        this.entrada = this.entrada.replace("x^(2)*y^(2)","r^(4)*sin(Ɵ)^(4)*cos(ᵩ)^(2)*sin(ᵩ)^(2)"); this.entrada = this.entrada.replace("y^(2)*x^(2)","r^(4)*sin(Ɵ)^(4)*cos(ᵩ)^(2)*sin(ᵩ)^(2)");
        this.entrada = this.entrada.replace("x^(2)*z^(2)","r^(4)*sin(Ɵ)^(2)*cos(Ɵ)^(2)*cos(ᵩ)^(2)"); this.entrada = this.entrada.replace("z^(2)*x^(2)","r^(4)*sin(Ɵ)^(2)*cos(Ɵ)^(2)*cos(ᵩ)^(2)");
        this.entrada = this.entrada.replace("y^(2)*z^(2)","r^(4)*sin(Ɵ)^(2)*cos(Ɵ)^(2)*sin(ᵩ)^(2)"); this.entrada = this.entrada.replace("z^(2)*y^(2)","r^(4)*sin(Ɵ)^(2)*cos(Ɵ)^(2)*sin(ᵩ)^(2)");

        this.entrada = this.entrada.replace("x*y","r^(2)*sin(Ɵ)^(2)*cos(ᵩ)*sin(ᵩ)"); this.entrada = this.entrada.replace("y*x","r^(2)*sin(Ɵ)^(2)*cos(ᵩ)");
        this.entrada = this.entrada.replace("x*z","r^(2)*sin(Ɵ)*cos(Ɵ)*cos(ᵩ)"); this.entrada = this.entrada.replace("z*x","r^(2)*sin(Ɵ)*cos(Ɵ)*cos(ᵩ)");
        this.entrada = this.entrada.replace("y*z","r^(2)*sin(Ɵ)*cos(Ɵ)*sin(ᵩ)"); this.entrada = this.entrada.replace("z*y","r^(2)*sin(Ɵ)*cos(Ɵ)*sin(ᵩ)");

        this.entrada = this.entrada.replace("x^(2)","r^(2)*sin(Ɵ)^(2)*cos(ᵩ)^(2)");
        this.entrada = this.entrada.replace("y^(2)","r^(2)*sin(Ɵ)^(2)*sin(ᵩ)^(2)");
        this.entrada = this.entrada.replace("z^(2)","r^(2)*cos(Ɵ)^(2)");

        this.entrada = this.entrada.replace("r*cos(Ɵ)^(2)+r*cos(ᵩ)^(2)*sin(Ɵ)^(2)+r*sin(Ɵ)^(2)*sin(ᵩ)^(2)","r");
        this.entrada = this.entrada.replace("r*cos(ᵩ)^(2)*sin(Ɵ)^(2)+r*sin(Ɵ)^(2)*sin(ᵩ)^(2)","r*sin(Ɵ)^(2)");
        this.entrada = this.entrada.replace("r*cos(ᵩ)^(2)*cos(Ɵ)^(2)+r*cos(Ɵ)^(2)*sin(ᵩ)^(2)","r*cos(Ɵ)^(2)");


        this.entrada = this.entrada.replace("r^(2)*sin(Ɵ)^(2)*sin(ᵩ)^(2)/r^(2)*sin(Ɵ)^(2)*cos(ᵩ)^(2)", "tan(ᵩ)^(2)" );
        this.entrada = this.entrada.replace("r^(2)*sin(Ɵ)^(2)*cos(ᵩ)^(2)/r^(2)*sin(Ɵ)^(2)*sin(ᵩ)^(2)", "tan(ᵩ)^(-2)" );

        this.entrada = this.entrada.replace("y/r^(2)*sin(Ɵ)^(2)*cos(ᵩ)^(2)", "tan(ᵩ)/r*cos(ᵩ)"); this.entrada = this.entrada.replace("x/r^(2)*sin(Ɵ)^(2)*sin(ᵩ)^(2)", "(r*sin(Ɵ)*sin(ᵩ)*tan(ᵩ))^(-1)");
        this.entrada = this.entrada.replace("y/x", "tan(ᵩ)"); this.entrada = this.entrada.replace("x/y", "tan(ᵩ)^(-1)");
        this.entrada = this.entrada.replace("x/z", "tan(Ɵ)/cos(ᵩ)"); this.entrada = this.entrada.replace("z/x", "cos(ᵩ)/tan(Ɵ)");
        this.entrada = this.entrada.replace("y/z", "tan(Ɵ)*sin(ᵩ)"); this.entrada = this.entrada.replace("z/y", "(tan(Ɵ)*sin(ᵩ))^(-1)");

        this.entrada = this.entrada.replace("r^(2)*sin(Ɵ)^(2)*sin(ᵩ)^(2)/x", "r*sin(Ɵ)*sin(ᵩ)*tan(ᵩ)"); this.entrada = this.entrada.replace("r^(2)*sin(Ɵ)^(2)*cos(ᵩ)^(2)/y", "[(r*sin(Ɵ)*cos(ᵩ)^(2))/sin(ᵩ)]");

        this.entrada = this.entrada.replace("x+y^(", "x+(y)^("); this.entrada = this.entrada.replace("y+x^(", "y+(x)^(");
        this.entrada = this.entrada.replace("x-y^(", "x-(y)^("); this.entrada = this.entrada.replace("y-x^(", "y-(x)^(");

        this.entrada = this.entrada.replace("x+y", "r*sin(Ɵ)*(cos(ᵩ)+sin(ᵩ))"); this.entrada = this.entrada.replace("y+x", "r*sin(Ɵ)*(cos(ᵩ)+sin(ᵩ))");
        this.entrada = this.entrada.replace("x-y", "r*sin(Ɵ)*(cos(ᵩ)-sin(ᵩ))"); this.entrada = this.entrada.replace("y-x", "r*sin(Ɵ)*(sin(ᵩ)-cos(ᵩ))");

        this.entrada = this.entrada.replace("x+z", "r*(sin(Ɵ)*cos(ᵩ)+cos(Ɵ))"); this.entrada = this.entrada.replace("z+x", "r*(sin(Ɵ)*cos(ᵩ)+cos(Ɵ))");
        this.entrada = this.entrada.replace("x-z", "r*(sin(Ɵ)*cos(ᵩ)-cos(Ɵ))"); this.entrada = this.entrada.replace("z-x", "r*(cos(Ɵ)-sin(Ɵ)*cos(ᵩ))");

        this.entrada = this.entrada.replace("y+z", "r*(sin(Ɵ)*sin(ᵩ)+cos(Ɵ))"); this.entrada = this.entrada.replace("z+y", "r*(sin(Ɵ)*sin(ᵩ)+cos(Ɵ))");
        this.entrada = this.entrada.replace("y-z", "r*(sin(Ɵ)*sin(ᵩ)-cos(Ɵ))"); this.entrada = this.entrada.replace("z-y", "r*(cos(Ɵ)-sin(Ɵ)*sin(ᵩ))");

        this.entrada = this.entrada.replace("x","r*sin(Ɵ)*cos(ᵩ)");
        this.entrada = this.entrada.replace("y","r*sin(Ɵ)*sin(ᵩ)");
        this.entrada = this.entrada.replace("z","r*cos(Ɵ)");

        this.entrada = this.entrada.replace("ᵨ","r");

        this.saida = this.entrada;


    }

    public void simplificarReduzida(){

        this.entrada = this.entrada.replace("x","(x)");
        this.entrada = this.entrada.replace("y","(y)");
        this.entrada = this.entrada.replace("z","(z)");

        this.entrada = this.entrada.replace("x","r*sin(Ɵ)*cos(ᵩ)");
        this.entrada = this.entrada.replace("y","r*sin(Ɵ)*sin(ᵩ)");
        this.entrada = this.entrada.replace("z", "r*cos(Ɵ)");

        this.saidareduzida = this.entrada;
    }

    public void simplificarRefinada(){

        this.entrada = this.entrada.replace("(ᵨ*cos(ᵩ))*cos(ᵩ)","ᵨ*cos(ᵩ)^(2)");
        this.entrada = this.entrada.replace("(ᵨ*sin(ᵩ))*sin(ᵩ)","ᵨ*sin(ᵩ)^(2)");

        this.entrada = this.entrada.replace("(ᵨ^(2)*cos(ᵩ)^(2))*cos(ᵩ)","ᵨ^(2)*cos(ᵩ)^(3)");
        this.entrada = this.entrada.replace("(ᵨ^(2)*sin(ᵩ)^(2))*sin(ᵩ)","ᵨ^(2)*sin(ᵩ)^(3)");

        this.entrada = this.entrada.replace("ᵨ^(2)*sin(ᵩ)^(3) - ᵨ^(2)*cos(ᵩ)^(3)","ᵨ^(2)*[sin(ᵩ)^(3) - cos(ᵩ)^(3)]");
        this.entrada = this.entrada.replace("ᵨ^(2)*cos(ᵩ)^(3) - ᵨ^(2)*sin(ᵩ)^(3)","ᵨ^(2)*[cos(ᵩ)^(3) - sin(ᵩ)^(3)]");

        this.entrada = this.entrada.replace("ᵨ^(2)*sin(ᵩ)^(3) + ᵨ^(2)*cos(ᵩ)^(3)","ᵨ^(2)*[sin(ᵩ)^(3) + cos(ᵩ)^(3)]");
        this.entrada = this.entrada.replace("ᵨ^(2)*cos(ᵩ)^(3) + ᵨ^(2)*sin(ᵩ)^(3)","ᵨ^(2)*[sin(ᵩ)^(3) + cos(ᵩ)^(3)]");

        this.entrada = this.entrada.replace("(ᵨ*sin(ᵩ))*cos(ᵩ)","ᵨ*sin(ᵩ)*cos(ᵩ)");
        this.entrada = this.entrada.replace("(ᵨ*cos(ᵩ))*sin(ᵩ)","ᵨ*sin(ᵩ)*cos(ᵩ)");

        this.entrada = this.entrada.replace("ᵨ*sin(ᵩ)*cos(ᵩ) + ᵨ*sin(ᵩ)*cos(ᵩ)","2*ᵨ*sin(ᵩ)*cos(ᵩ)");
        this.entrada = this.entrada.replace("ᵨ*sin(ᵩ)*cos(ᵩ) - ᵨ*sin(ᵩ)*cos(ᵩ)","0");

        this.entrada = this.entrada.replace("ᵨ*cos(ᵩ)^(2) - ᵨ*sin(ᵩ)^(2)","ᵨ*[cos(ᵩ)^(2) - sin(ᵩ)^(2)]");
        this.entrada = this.entrada.replace("ᵨ*sin(ᵩ)^(2) - ᵨ*cos(ᵩ)^(2)","ᵨ*[sin(ᵩ)^(2) - cos(ᵩ)^(2)]");

        this.entrada = this.entrada.replace("ᵨ*cos(ᵩ)^(2) + ᵨ*sin(ᵩ)^(2)","ᵨ");
        this.entrada = this.entrada.replace("ᵨ*sin(ᵩ)^(2) + ᵨ*cos(ᵩ)^(2)","ᵨ");

        this.entrada = this.entrada.replace("(0)*cos(ᵩ)","0");
        this.entrada = this.entrada.replace("(0)*sin(ᵩ)","0");

        this.entrada = this.entrada.replace("ᵨ","r");

        this.saidarefinada = this.entrada;
    }

    public String getSimplificarSaidaReduzida(){
        return this.saidareduzida;
    }

    public String getSimplificarSaidaRefinada(){
        return this.saidarefinada;
    }
}



