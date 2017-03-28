/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruno.distribuciones;

import com.bruno.distribuciones.dominio.Normal;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno
 */
public class NormalTest {

    public NormalTest() {
    }

    @Test
    public void testPorAbscisa_OK_359_Neg() {
        Normal norm = new Normal();

        String resEsperado = "0.0002";
        String resObtenido = norm.porAbscisaNormal(-3.59);

        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_359() {
        Normal norm = new Normal();

        String resEsperado = "0.9998";
        String resObtenido = norm.porAbscisaNormal(3.59);

        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_105_Neg() {
        Normal norm = new Normal();

        String resEsperado = "0.1469";
        String resObtenido = norm.porAbscisaNormal(-1.05);

        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_105() {
        Normal norm = new Normal();

        String resEsperado = "0.8531";
        String resObtenido = norm.porAbscisaNormal(1.05);

        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_279_Neg() {
        Normal norm = new Normal();

        String resEsperado = "0.0026";
        String resObtenido = norm.porAbscisaNormal(-2.79);

        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_279() {
        Normal norm = new Normal();

        String resEsperado = "0.9974";
        String resObtenido = norm.porAbscisaNormal(2.79);

        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorProbabilidad_OK_09974() {
        Normal norm = new Normal();

        String resObtenido = norm.porProbabilidadNormal(0.9974);

        assertEquals(norm.porAbscisaNormal(Double.parseDouble(resObtenido)), "0.9974");
    }

    @Test
    public void testPorProbabilidad_OK_00026() {
        Normal norm = new Normal();

        String resObtenido = norm.porProbabilidadNormal(0.0026);

        assertEquals(norm.porAbscisaNormal(Double.parseDouble(resObtenido)), "0.0026");
    }

    @Test
    public void testPorProbabilidad_OK_08531() {
        Normal norm = new Normal();

        String resObtenido = norm.porProbabilidadNormal(0.8531);

        assertEquals(norm.porAbscisaNormal(Double.parseDouble(resObtenido)), "0.8531");
    }

    @Test
    public void testPorProbabilidad_OK_01469() {
        Normal norm = new Normal();

        String resObtenido = norm.porProbabilidadNormal(0.1469);

        assertEquals(norm.porAbscisaNormal(Double.parseDouble(resObtenido)), "0.1469");
    }

    @Test
    public void testPorProbabilidad_OK_09998() {
        Normal norm = new Normal();

        String resObtenido = norm.porProbabilidadNormal(0.9998);

        assertEquals(norm.porAbscisaNormal(Double.parseDouble(resObtenido)), "0.9998");
    }

    @Test
    public void testPorProbabilidad_OK_00002() {
        Normal norm = new Normal();

        String resObtenido = norm.porProbabilidadNormal(0.0002);

        assertEquals(norm.porAbscisaNormal(Double.parseDouble(resObtenido)), "0.0002");
    }

    @Test
    public void testPorProbabilidad_OK_09999() {
        Normal norm = new Normal();

        String resObtenido = norm.porProbabilidadNormal(0.9999);

        assertEquals(norm.porAbscisaNormal(Double.parseDouble(resObtenido)), "0.9999");
    }
}
