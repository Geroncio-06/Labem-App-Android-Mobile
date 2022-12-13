package com.geroncio.labem.Integrais;




public class Integral {

    public String entrada;
    public String saida;

    public Integral(){}


    public void setFunctionIntegrar(String function) {
        this.entrada = function;

    }

    public String getFunctionIntegrar() {
        return this.saida;
    }

    public void integrar() {


        try {


            this.entrada = "Integrate(y^2 + y*x,y)";




        }catch (Exception e ){
            this.saida = "Não achou a integral";
        }






    }


}
