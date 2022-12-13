package com.geroncio.labem.Calculo_vetorial;


import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.interfaces.IExpr;

public class CVSimplify {
    public String entrada;
    public String saida;

    public String saida2;


    public CVSimplify() {
        //..
    }


    public void setFunctionSimplificar(String function) {
        this.entrada = function;

    }

    public String getFunctionSimplificada() {
        return this.saida;
    }

    public String getFunctionSimplificadaAlt() {
        return this.saida2;
    }

    public void simplificar() {

            try{
                EvalUtilities util = new EvalUtilities(true, true);
                this.entrada = this.entrada.replace("[","(");
                this.entrada = this.entrada.replace("]",")");
                this.entrada = this.entrada.replace("√","sqrt");
                this.entrada = this.entrada.replace("ln(","(1/log(e))*log(");

                this.entrada = entrada.replace("<sup>2</sup>","^2");
                this.entrada = entrada.replace("<sup>3</sup>","^3");
                this.entrada = entrada.replace("<sup>4</sup>","^4");

                this.entrada = "Factor(" + this.entrada + ",x)";

                IExpr result = util.evaluate(this.entrada);

                this.saida = result.toString();

                this.saida = this.saida.replace("^2.0", "<sup>2</sup>");
                this.saida = this.saida.replace("^3.0", "<sup>3</sup>");
                this.saida = this.saida.replace("^4.0", "<sup>4</sup>");

                this.saida = this.saida.replace("^2", "<sup>2</sup>");
                this.saida = this.saida.replace("^3", "<sup>3</sup>");
                this.saida = this.saida.replace("^4", "<sup>4</sup>");

                this.saida = this.saida.replace("^2.0*", "^(2)*");
                this.saida = this.saida.replace("^3.0*", "^(3)*");
                this.saida = this.saida.replace("^4.0*", "^(4)*");
                this.saida = this.saida.replace("^2.0+", "^(2)+");
                this.saida = this.saida.replace("^3.0+", "^(3)+");
                this.saida = this.saida.replace("^4.0+", "^(4)+");
                this.saida = this.saida.replace("Sqrt", "√");
                this.saida = this.saida.replace("Factor(", "");
                this.saida = this.saida.replace(",x)", "");
                this.saida = this.saida.replace("Sin", "sin");
                this.saida = this.saida.replace("Cos", "cos");
                this.saida = this.saida.replace("Tan", "tan");
                this.saida = this.saida.replace("Sec", "1/cos");
                this.saida = this.saida.replace("Csc", "1/sin");
                this.saida = this.saida.replace("Log", "log");

                this.saida2 = this.saida;
                this.saida2 = saida2.replace("<sup>2</sup>","^2");
                this.saida2 = saida2.replace("<sup>3</sup>","^3");
                this.saida2 = saida2.replace("<sup>4</sup>","^4");

            }catch (Exception e){
                this.saida = "Erro";
            }



    }





}