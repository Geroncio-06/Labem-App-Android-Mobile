package com.geroncio.labem.Derivadas;

import android.provider.Settings;
import android.widget.TextView;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class DerivativeY {

    public String entrada;
    public String saida;

    DJep dJep;
    Node nodoFunction;
    Node nodoDerivada;

    public DerivativeY(){
        //..
    }


    public void setFunctionDerivar( String function){
        this.entrada = function;
        this.entrada = entrada.replace("√","sqrt");
        this.entrada = entrada.replace("--","+");
        this.entrada = entrada.replace("-+","-");
        this.entrada = entrada.replace("+-","-");

        this.entrada = entrada.replace("<sup>2</sup>","^2");
        this.entrada = entrada.replace("<sup>3</sup>","^3");
        this.entrada = entrada.replace("<sup>4</sup>","^4");

    }

    public String getFunctionDerivada(){
        return this.saida;
    }

    public  void  derivar(){
        try {


            this.dJep = new DJep();

            this.dJep.addStandardFunctions();
            this.dJep.addStandardConstants();
            this.dJep.addComplex();
            this.dJep.setAllowUndeclared(true);
            this.dJep.setAllowAssignment(true);
            this.dJep.setImplicitMul(true);
            this.dJep.addStandardDiffRules();

            this.nodoFunction = this.dJep.parse(this.entrada);

            Node diff = this.dJep.differentiate(nodoFunction, "y");

            this.nodoDerivada = this.dJep.simplify(diff);

            this.saida = this.dJep.toString(this.nodoDerivada);
            this.saida = saida.replace("--","+");
            this.saida = saida.replace("-+","-");
            this.saida = saida.replace("+-","-");
            this.saida = saida.replace("3.14159265","π");
            this.saida = this.saida.replace("^x^2.0","^(x^2)");
            this.saida = this.saida.replace("^y^2.0","^(y^2)");
            this.saida = this.saida.replace("^z^2.0","^(z^2)");
            this.saida = this.saida.replace("^x^3.0","^(x^3)");
            this.saida = this.saida.replace("^y^3.0","^(y^3)");
            this.saida = this.saida.replace("^z^3.0","^(z^3)");

            this.saida = this.saida.replace("^2.0", "<sup>2</sup>");
            this.saida = this.saida.replace("^3.0", "<sup>3</sup>");
            this.saida = this.saida.replace("^4.0", "<sup>4</sup>");

            this.saida = this.saida.replace("^2", "<sup>2</sup>");
            this.saida = this.saida.replace("^3", "<sup>3</sup>");
            this.saida = this.saida.replace("^4", "<sup>4</sup>");

            this.saida = this.saida.replace("*ln(e)*","*");
            this.saida = this.saida.replace("ln(e)*","");
            this.saida = this.saida.replace("*ln(e)","");
            this.saida = this.saida.replace("ln(e)","1");
            this.saida = this.saida.replace("0.43429448190325176","log(e)");
            this.saida = this.saida.replace("0.8685889638065035","2*log(e)");
            this.saida = this.saida.replace("1.3028834457097553","3*log(e)");
            this.saida = this.saida.replace("1.737177927613007","4*log(e)");
            this.saida = this.saida.replace("2.1714724095162588","5*log(e)");
            this.saida = this.saida.replace("2.6057668914195107","6*log(e)");
            this.saida = this.saida.replace("3.040061373322762","7*log(e)");
            this.saida = this.saida.replace("3.474355855226014","8*log(e)");
            this.saida = this.saida.replace("3.908650337129266","9*log(e)");
            this.saida = this.saida.replace("4.3429448190325175","10*log(e)");


        }catch (ParseException e){
            System.out.println("Error" + e.getErrorInfo());
        }
    }
}

