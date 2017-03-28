package com.bruno.distribuciones.dominio;

import java.text.DecimalFormat;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;

/**
 *
 * @author Bruno
 */
public class ChiCuadrada {

    private DecimalFormat df;
    private DecimalFormat dfProb;
    private double[] listaAbscisas = {0.005, 0.010, 0.025, 0.050,
            0.100, 0.900, 0.950, 0.975, 0.990, 0.995};
    private int[] grados = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
            , 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 35, 40, 45,
            50, 60, 70, 80, 90, 100};

    public ChiCuadrada() {

        df = new DecimalFormat("0.00");
        dfProb = new DecimalFormat("0.000");
    }

    public String porAbscisaChiCuadrada(double x, int gradosDeLibertad) {
        ChiSquaredDistribution chi = new ChiSquaredDistribution(gradosDeLibertad);
        double cuenta = chi.inverseCumulativeProbability(x);
        String aux = df.format(cuenta);
        String ret = aux.replace(',','.');
        return ret;
    }

    public String porProbabilidadChiCuadrada(double x){
        double resultado = -1;
        double difMinima = Double.MAX_VALUE;
        for(int i = 0; i < grados.length; i++){
            ChiSquaredDistribution chi = new ChiSquaredDistribution(grados[i]);
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
