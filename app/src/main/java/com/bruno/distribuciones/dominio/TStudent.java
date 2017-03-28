package com.bruno.distribuciones.dominio;

import java.text.DecimalFormat;

import org.apache.commons.math3.distribution.TDistribution;

/**
 *
 * @author Bruno
 */
public class TStudent {

    private DecimalFormat df;
    private DecimalFormat dfProb;
    //Personalizado
    private double[] listaAbscisas = {0.001, 0.005, 0.010, 0.025, 0.050,
            0.100, 0.200, 0.800, 0.900, 0.950, 0.975, 0.990, 0.995, 0.999};
    private int[] grados = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
            , 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 35, 40, 45,
            50, 60, 70, 80, 90, 100, 200, 500, 1000};

    public TStudent() {
        df = new DecimalFormat("0.000");
        dfProb = new DecimalFormat("0.000");
    }

    public String porAbscisaTStudent(double x, int gradosDeLibertad) {
        TDistribution t = new TDistribution(gradosDeLibertad);
        double cuenta = t.inverseCumulativeProbability(x);
        String aux = df.format(cuenta);
        String ret = aux.replace(',','.');
        return ret;
    }

    public String porProbabilidadTStudent(double x) {
        double resultado = -1;
        double difMinima = Double.MAX_VALUE;
        for(int i = 0; i < grados.length; i++){
            TDistribution chi = new TDistribution(grados[i]);
            for(int j = 0; j < listaAbscisas.length; j++){
                if(Math.abs(chi.inverseCumulativeProbability(listaAbscisas[j]) - x) < difMinima){
                    resultado = listaAbscisas[j];
                    difMinima = Math.abs(chi.inverseCumulativeProbability(listaAbscisas[j]) - x);
                }
            }
        }
        String aux = dfProb.format(resultado);
        String ret = aux.replace(',','.');
        return ret;
    }
}