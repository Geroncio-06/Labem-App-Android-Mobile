package com.geroncio.labem.Transformada.Simplify;







import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.interfaces.IExpr;

import java.sql.Time;
import java.text.ParseException;

public class JASimplify {
    public String entrada;
    public String saida, saida2;





    public JASimplify(){
        //..
    }


    public void setFunctionSimplificar( String function){
        this.entrada = function;

    }

    public String getFunctionSimplificada(){
        return this.saida;
    }

    public  void  jasimplificar(){
        try {
            EvalUtilities util = new EvalUtilities(true, true);
            this.entrada = this.entrada.replace("r", "x");
            this.entrada = this.entrada.replace("Ɵ","y");
            this.entrada = this.entrada.replace("ᵩ","z");

            this.entrada = "Factor("+this.entrada+",x)";

            IExpr result = util.evaluate(this.entrada);

            this.saida = result.toString();
            this.saida = this.saida.replace("^2.0*","^(2)*");
            this.saida = this.saida.replace("^3.0*","^(3)*");
            this.saida = this.saida.replace("^4.0*","^(4)*");
            this.saida = this.saida.replace("Sqrt","√");
            this.saida = this.saida.replace("Factor(","");
            this.saida = this.saida.replace(",x)","");
            this.saida = this.saida.replace("Sin","sin");
            this.saida = this.saida.replace("Cos","cos");
            this.saida = this.saida.replace("sqrt","√");
            this.saida = this.saida.replace("r","x");
            this.saida = this.saida.replace("Ɵ","y");
            this.saida = this.saida.replace("ᵩ","z");
        }catch (Exception e){
            this.saida = "Erro";
        }

    }




    public void setFunctionSimplificarCilindrico( String function){
        this.entrada = function;

    }

    public String getFunctionSimplificadaCilindrico(){
        return this.saida;
    }

    public  void  jasimplificarCilindrico(){
        try {
            EvalUtilities util = new EvalUtilities(true, true);
            this.entrada = this.entrada.replace("ᵨ", "x");
            this.entrada = this.entrada.replace("ᵩ","y");

            this.entrada = "Factor("+this.entrada+",x)";

            IExpr result = util.evaluate(this.entrada);

            this.saida = result.toString();
            this.saida = this.saida.replace("^2.0*","^(2)*");
            this.saida = this.saida.replace("^3.0*","^(3)*");
            this.saida = this.saida.replace("^4.0*","^(4)*");
            this.saida = this.saida.replace("Sqrt","√");
            this.saida = this.saida.replace("Factor(","");
            this.saida = this.saida.replace(",x)","");
            this.saida = this.saida.replace("Sin","sin");
            this.saida = this.saida.replace("Cos","cos");
            this.saida = this.saida.replace("sqrt","√");
            this.saida = this.saida.replace("x","ᵨ");
            this.saida = this.saida.replace("y","ᵩ");
            this.saida = this.saida.replace("^2","<sup>2</sup>");
            this.saida = this.saida.replace("^3","<sup>3</sup>");
            this.saida = this.saida.replace("^4","<sup>4</sup>");
        }catch (Exception e){
            this.saida = "Erro";
        }

    }




    public void setFunctionSimplificarCilindricoCart( String function){
        this.entrada = function;

    }

    public String getFunctionSimplificadaCilindricoCart(){
        return this.saida;
    }

    public  void  jasimplificarCilindricoCart(){

            try {
                EvalUtilities util = new EvalUtilities(true, true);


                this.entrada = "Factor("+this.entrada+",x)";

                IExpr result = util.evaluate(this.entrada);

                this.saida = result.toString();
                this.saida = this.saida.replace("^2.0*","^(2)*");
                this.saida = this.saida.replace("^3.0*","^(3)*");
                this.saida = this.saida.replace("^4.0*","^(4)*");
                this.saida = this.saida.replace("Sqrt","√");
                this.saida = this.saida.replace("sqrt","√");
                this.saida = this.saida.replace("Factor(","");
                this.saida = this.saida.replace(",x)","");
                this.saida = this.saida.replace("Sin","sin");
                this.saida = this.saida.replace("Cos","cos");
                this.saida = this.saida.replace("^2","<sup>2</sup>");
                this.saida = this.saida.replace("^3","<sup>3</sup>");
                this.saida = this.saida.replace("^4","<sup>4</sup>");
            }catch (Exception e ){
                this.saida = "Erro";
            }


    }




    public void setFunctionSimplificarCilindricoEsfer( String function){
        this.entrada = function;

    }

    public String getFunctionSimplificadaCilindricoEsfer(){
        return this.saida;
    }

    public  void  jasimplificarCilindricoEsfer(){

        try {
            EvalUtilities util = new EvalUtilities(true, true);
            this.entrada = this.entrada.replace("r", "x");
            this.entrada = this.entrada.replace("Ɵ","y");
            this.entrada = this.entrada.replace("ᵩ","z");

            this.entrada = "Factor("+this.entrada+",x)";

            IExpr result = util.evaluate(this.entrada);

            this.saida = result.toString();
            this.saida = this.saida.replace("^2.0*","^(2)*");
            this.saida = this.saida.replace("^3.0*","^(3)*");
            this.saida = this.saida.replace("^4.0*","^(4)*");
            this.saida = this.saida.replace("Sqrt","√");
            this.saida = this.saida.replace("sqrt","√");
            this.saida = this.saida.replace("Factor(","");
            this.saida = this.saida.replace(",x)","");
            this.saida = this.saida.replace("Sin","sin");
            this.saida = this.saida.replace("Cos","cos");
            this.saida = this.saida.replace("x","r");
            this.saida = this.saida.replace("y","Ɵ");
            this.saida = this.saida.replace("z","ᵩ");

            this.saida = this.saida.replace("^2","<sup>2</sup>");
            this.saida = this.saida.replace("^3","<sup>3</sup>");
            this.saida = this.saida.replace("^4","<sup>4</sup>");
        }catch (Exception e){
            this.saida = "Erro";
        }


    }




    public void setFunctionSimplificarEsfericart( String function){
        this.entrada = function;

    }

    public String getFunctionSimplificadaEsfericart(){

        return this.saida;
    }
    public String getFunctionSimplificadaEsfericartSaidaAlt(){

        return this.saida2;
    }

    public  void  jasimplificarEsfericart(){

        try {
            EvalUtilities util = new EvalUtilities(true, true);
            this.entrada = this.entrada.replace("r", "x");
            this.entrada = this.entrada.replace("Ɵ","y");
            this.entrada = this.entrada.replace("ᵩ","z");

            this.entrada = "Factor("+this.entrada+",x)";

            IExpr result = util.evaluate(this.entrada);

            this.saida = result.toString();
            this.saida = this.saida.replace("^2.0*","^(2)*");
            this.saida = this.saida.replace("^3.0*","^(3)*");
            this.saida = this.saida.replace("^4.0*","^(4)*");
            this.saida = this.saida.replace("Sqrt","√");
            this.saida = this.saida.replace("sqrt","√");
            this.saida = this.saida.replace("Factor(","");
            this.saida = this.saida.replace(",x)","");
            this.saida = this.saida.replace("Sin","sin");
            this.saida = this.saida.replace("Cos","cos");
            this.saida = this.saida.replace("x","r");
            this.saida = this.saida.replace("y","Ɵ");
            this.saida = this.saida.replace("z","ᵩ");

            this.saida2 = this.saida;
            this.saida2 = this.saida2.replace("^2","<sup>2</sup>");
            this.saida2 = this.saida2.replace("^3","<sup>3</sup>");
            this.saida2 = this.saida2.replace("^4","<sup>4</sup>");

            this.saida = this.saida.replace("r*cos(Ɵ)^2+r*cos(ᵩ)^2*sin(Ɵ)^2+r*sin(Ɵ)^2*sin(ᵩ)^2","r");
            this.saida = this.saida.replace("r*cos(ᵩ)^2*sin(Ɵ)^2+r*sin(Ɵ)^2*sin(ᵩ)^2","r*sin(Ɵ)^2");
            this.saida = this.saida.replace("r*cos(ᵩ)^2*cos(Ɵ)^2+r*cos(Ɵ)^2*sin(ᵩ)^2","r*cos(Ɵ)^2");

            this.saida = this.saida.replace("^2","<sup>2</sup>");
            this.saida = this.saida.replace("^3","<sup>3</sup>");
            this.saida = this.saida.replace("^4","<sup>4</sup>");

        }catch (Exception e){
            this.saida = "Erro";
            this.saida2 = "Erro";
        }


    }




    public void setFunctionSimplificarEsfericilin( String function){
        this.entrada = function;

    }

    public String getFunctionSimplificadaEsfericilin(){
        return this.saida;
    }

    public  void  jasimplificarEsfericilin(){

        try {
            EvalUtilities util = new EvalUtilities(true, true);
            this.entrada = this.entrada.replace("ᵨ", "x");
            this.entrada = this.entrada.replace("ᵩ","y");


            this.entrada = "Factor("+this.entrada+",x)";

            IExpr result = util.evaluate(this.entrada);

            this.saida = result.toString();
            this.saida = this.saida.replace("^2.0*","^(2)*");
            this.saida = this.saida.replace("^3.0*","^(3)*");
            this.saida = this.saida.replace("^4.0*","^(4)*");
            this.saida = this.saida.replace("Sqrt","√");
            this.saida = this.saida.replace("sqrt","√");
            this.saida = this.saida.replace("Factor(","");
            this.saida = this.saida.replace(",x)","");
            this.saida = this.saida.replace("Sin","sin");
            this.saida = this.saida.replace("Cos","cos");
            this.saida = this.saida.replace("x","ᵨ");
            this.saida = this.saida.replace("y","ᵩ");

            this.saida = this.saida.replace("^2","<sup>2</sup>");
            this.saida = this.saida.replace("^3","<sup>3</sup>");
            this.saida = this.saida.replace("^4","<sup>4</sup>");

        }catch (Exception e){
            this.saida = "Erro";
        }


    }
}
