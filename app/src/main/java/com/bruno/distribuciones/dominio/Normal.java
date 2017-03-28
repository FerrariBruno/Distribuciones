package com.bruno.distribuciones.dominio;

import java.text.DecimalFormat;
import org.apache.commons.math3.distribution.NormalDistribution;

/**
 *
 * @author Bruno
 */
public class Normal {

    private DecimalFormat df;
    private DecimalFormat dfProbabilidad;

    public Normal() {
        df = new DecimalFormat("0.0000");
        dfProbabilidad = new DecimalFormat("0.00");
    }

    public String porAbscisaNormal(double x) {
        NormalDistribution normal = new NormalDistribution(0, 1);
        double cuenta = normal.cumulativeProbability(x);
        String aux = df.format(cuenta);
        String ret = aux.replace(',', '.');
        return ret;
    }

    public String porProbabilidadNormal(double x) {
        NormalDistribution normal = new NormalDistribution(0, 1);
        double res = normal.inverseCumulativeProbability(x);
        String aux = dfProbabilidad.format(res);
        String ret = aux.replace(',', '.');
        return ret;
    }
}
