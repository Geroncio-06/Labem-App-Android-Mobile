package com.geroncio.labem.Transformada.Simplify;

import android.provider.Settings;
import android.widget.TextView;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class SimplifyCartesianoCilindrico {

    public String entrada;
    public String saida, saidareduzida, saidarefinada;





    public SimplifyCartesianoCilindrico(){
        //..
    }


    public void setSimplificar( String function){
        this.entrada = function;

    }

    public String getSimplificarSaida(){
        return this.saida;
    }

    public  void  simplificar(){



        this.entrada = this.entrada.replace("2*x^(2)+2*y^(2)","2*ᵨ^(2)"); this.entrada = this.entrada.replace("sqrt(2*ᵨ^(2))","ᵨ*sqrt(2)");
        this.entrada = this.entrada.replace("x^(2)+y^(2)","ᵨ^(2)"); this.entrada = this.entrada.replace("sqrt(ᵨ^(2))","ᵨ");

        this.entrada = this.entrada.replace("x^(2)*y^(2)","ᵨ^(4)*sin(ᵩ)^(2)*cos(ᵩ)^(2)"); this.entrada = this.entrada.replace("y^(2)*x^(2)","ᵨ^(4)*sin(ᵩ)^(2)*cos(ᵩ)^(2)");

        this.entrada = this.entrada.replace("x^(2)","ᵨ^(2)*cos(ᵩ)^(2)");
        this.entrada = this.entrada.replace("y^(2)","ᵨ^(2)*sin(ᵩ)^(2)");

        this.entrada = this.entrada.replace("arctan(y/x)","ᵩ");

        this.entrada = this.entrada.replace("ᵨ^(2)*sin(ᵩ)^(2)/ᵨ^(2)*cos(ᵩ)^(2)", "tan(ᵩ)^(2)" );
        this.entrada = this.entrada.replace("ᵨ^(2)*cos(ᵩ)^(2)/ᵨ^(2)*sin(ᵩ)^(2)", "tan(ᵩ)^(-2)" );

        this.entrada = this.entrada.replace("y/ᵨ^(2)*cos(ᵩ)^(2)", "tan(ᵩ)/ᵨ*cos(ᵩ)"); this.entrada = this.entrada.replace("x/ᵨ^(2)*sin(ᵩ)^(2)", "(ᵨ*sin(ᵩ)*tan(ᵩ))^(-1)");
        this.entrada = this.entrada.replace("y/x", "tan(ᵩ)"); this.entrada = this.entrada.replace("x/y", "tan(ᵩ)^(-1)");

        this.entrada = this.entrada.replace("ᵨ^(2)*sin(ᵩ)^(2)/x", "ᵨ*sin(ᵩ)*tan(ᵩ)"); this.entrada = this.entrada.replace("ᵨ^(2)*cos(ᵩ)^(2)/y", "ᵨ*cos(ᵩ)*tan(ᵩ)^(-1)");
        this.entrada = this.entrada.replace("(x+y)^(2)", "ᵨ^(2)*(1+2*cos(ᵩ)*sin(ᵩ))"); this.entrada = this.entrada.replace("(y+x)^(2)", "ᵨ^(2)*(1+2*cos(ᵩ)*sin(ᵩ))");

        this.entrada = this.entrada.replace("x+y^(", "x+(y)^("); this.entrada = this.entrada.replace("y+x^(", "y+(x)^(");
        this.entrada = this.entrada.replace("x-y^(", "x-(y)^("); this.entrada = this.entrada.replace("y-x^(", "y-(x)^(");

        this.entrada = this.entrada.replace("x+y", "ᵨ*(cos(ᵩ)+sin(ᵩ))"); this.entrada = this.entrada.replace("y+x", "ᵨ*(cos(ᵩ)+sin(ᵩ))");
        this.entrada = this.entrada.replace("x-y", "ᵨ*(cos(ᵩ)-sin(ᵩ))"); this.entrada = this.entrada.replace("y-x", "ᵨ*(sin(ᵩ)-cos(ᵩ))");
        this.entrada = this.entrada.replace("x","ᵨ*cos(ᵩ)");
        this.entrada = this.entrada.replace("y","ᵨ*sin(ᵩ)");
        this.entrada = this.entrada.replace("ᵨ*cos(ᵩ)*ᵨ*sin(ᵩ)","ᵨ^(2)*sin(ᵩ)*cos(ᵩ)"); this.entrada = this.entrada.replace("ᵨ*sin(ᵩ)*ᵨ*cos(ᵩ)","ᵨ^(2)*sin(ᵩ)*cos(ᵩ)");
        this.entrada = this.entrada.replace("ᵨ*sin(ᵩ)*ᵨ^(2)","ᵨ^(3)*sin(ᵩ)");this.entrada = this.entrada.replace("ᵨ*cos(ᵩ)*ᵨ^(2)","ᵨ^(3)*cos(ᵩ)");

        this.saida = this.entrada;


    }

    public void simplificarReduzida(){

        this.entrada = this.entrada.replace("x","(x)");
        this.entrada = this.entrada.replace("y","(y)");

        this.entrada = this.entrada.replace("x","ᵨ*cos(ᵩ)");
        this.entrada = this.entrada.replace("y","ᵨ*sin(ᵩ)");

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


        this.saidarefinada = this.entrada;
    }

    public String getSimplificarSaidaReduzida(){
        return this.saidareduzida;
    }

    public String getSimplificarSaidaRefinada(){
        return this.saidarefinada;
    }
}



