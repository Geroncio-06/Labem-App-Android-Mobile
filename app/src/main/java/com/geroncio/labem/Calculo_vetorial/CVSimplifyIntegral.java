package com.geroncio.labem.Calculo_vetorial;


import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;

public class CVSimplifyIntegral {
    public String entrada, entradaintegral;
    public String saida, saidaintegral;


    public CVSimplifyIntegral() {
        //..
    }


    public void setFunctionSimplificar(String function) {
        this.entrada = function;

    }

    public String getFunctionSimplificada() {
        return this.saida;
    }

    public void simplificar() {

            
                EvalUtilities util = new EvalUtilities(true, true);
                this.saida = null;
                this.entrada = this.entrada.replace("[","(");
                this.entrada = this.entrada.replace("]",")");
                this.entrada = this.entrada.replace("√","sqrt");
                this.entrada = this.entrada.replace("t","x");
                this.entrada = this.entrada.replace("xanh","tanh");
                this.entrada = this.entrada.replace("xan","tan");
                this.entrada = this.entrada.replace("Sqrx","sqrt");
                this.entrada = this.entrada.replace("sqrx","sqrt");

                this.entrada = "Factor(" + this.entrada + ",x)";

                IExpr result = util.evaluate(this.entrada);

                this.saida = result.toString();
                this.saida = this.saida.replace("^2.0*", "^(2)*");
                this.saida = this.saida.replace("^3.0*", "^(3)*");
                this.saida = this.saida.replace("^4.0*", "^(4)*");
                this.saida = this.saida.replace("^2.0+", "^(2)+");
                this.saida = this.saida.replace("^3.0+", "^(3)+");
                this.saida = this.saida.replace("^4.0+", "^(4)+");
                this.saida = this.saida.replace("Sqrt", "√");
                this.saida = this.saida.replace("√(t^2)","t");
                this.saida = this.saida.replace("Factor(", "");
                this.saida = this.saida.replace(",x)", "");
                this.saida = this.saida.replace("x","t");
                this.saida = this.saida.replace("(t^2)^(3/2)","t^(3)");
                this.saida = this.saida.replace("(t^2)^(2/2)","t^(2)");
                this.saida = this.saida.replace("(t^2)^(1/2)","t");
                this.saida = this.saida.replace("Sin", "sin");
                this.saida = this.saida.replace("Cos", "cos");
                this.entrada = null;



    }



    public void setFunctionIntegrar(String function) {
        this.entradaintegral = function;

    }

    public String getFunctionIntegrar() {
        return this.saidaintegral;
    }

    public void integrar() {


            try {
                this.saidaintegral = null;
                this.entradaintegral = this.entradaintegral.replace("[","(");
                this.entradaintegral = this.entradaintegral.replace("]",")");
                this.entradaintegral = this.entradaintegral.replace("√","sqrt");
                this.entradaintegral = this.entradaintegral.replace("t","x");
                this.entradaintegral = this.entradaintegral.replace("xanh","tanh");
                this.entradaintegral = this.entradaintegral.replace("xan","tan");
                this.entradaintegral = this.entradaintegral.replace("Sqrx","sqrt");
                this.entradaintegral = this.entradaintegral.replace("sqrx","sqrt");

                EvalUtilities util = new EvalUtilities(true, true);


                this.entradaintegral = "Integrate("+this.entradaintegral+",x)";

                IExpr result =  util.evaluate(this.entradaintegral);

                this.saidaintegral = result.toString();
                this.saidaintegral = this.saidaintegral.replace("^2.0*", "^(2)*");
                this.saidaintegral = this.saidaintegral.replace("^3.0*", "^(3)*");
                this.saidaintegral = this.saidaintegral.replace("^4.0*", "^(4)*");
                this.saidaintegral = this.saidaintegral.replace("^2.0+", "^(2)+");
                this.saidaintegral = this.saidaintegral.replace("^3.0+", "^(3)+");
                this.saidaintegral = this.saidaintegral.replace("^4.0+", "^(4)+");
                this.saidaintegral = this.saidaintegral.replace("Sqrt", "√");
                this.saidaintegral = this.saidaintegral.replace(",x)", "");
                this.saidaintegral = this.saidaintegral.replace("x","t");
                this.saidaintegral = this.saidaintegral.replace("Sin", "sin");
                this.saidaintegral = this.saidaintegral.replace("Cos", "cos");
                this.entradaintegral = null;

            }catch (Exception e ){
                this.saidaintegral = "Não achou a integral";
            }






    }







}