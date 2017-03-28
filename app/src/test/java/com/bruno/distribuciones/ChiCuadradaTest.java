/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bruno.distribuciones;

import com.bruno.distribuciones.dominio.ChiCuadrada;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno
 */
public class ChiCuadradaTest {

    public ChiCuadradaTest() {
    }

    @Test
    public void testPorAbscisa_OK_1_0050() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "0.00";
        String resObtenido = chi.porAbscisaChiCuadrada(0.050, 1);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_1_0100() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "0.02";
        String resObtenido = chi.porAbscisaChiCuadrada(0.100, 1);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_1_0900() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "2.71";
        String resObtenido = chi.porAbscisaChiCuadrada(0.900, 1);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_1_0995() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "7.88";
        String resObtenido = chi.porAbscisaChiCuadrada(0.995, 1);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_20_0050() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "10.85";
        String resObtenido = chi.porAbscisaChiCuadrada(0.050, 20);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_20_0100() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "12.44";
        String resObtenido = chi.porAbscisaChiCuadrada(0.100, 20);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_20_0900() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "28.41";
        String resObtenido = chi.porAbscisaChiCuadrada(0.900, 20);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_20_0995() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "40.00";
        String resObtenido = chi.porAbscisaChiCuadrada(0.995, 20);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_6_0050() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "1.64";
        String resObtenido = chi.porAbscisaChiCuadrada(0.050, 6);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_6_0100() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "2.20";
        String resObtenido = chi.porAbscisaChiCuadrada(0.100, 6);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_6_0900() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "10.64";
        String resObtenido = chi.porAbscisaChiCuadrada(0.900, 6);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_6_0995() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "18.55";
        String resObtenido = chi.porAbscisaChiCuadrada(0.995, 6);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_100_0050() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "77.93";
        String resObtenido = chi.porAbscisaChiCuadrada(0.050, 100);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_100_0100() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "82.36";
        String resObtenido = chi.porAbscisaChiCuadrada(0.100, 100);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_100_0900() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "118.50";
        String resObtenido = chi.porAbscisaChiCuadrada(0.900, 100);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_100_0995() {
        ChiCuadrada chi = new ChiCuadrada();
        
        String resEsperado = "140.17";
        String resObtenido = chi.porAbscisaChiCuadrada(0.995, 100);
        
        assertEquals(resEsperado, resObtenido);
    }

}
