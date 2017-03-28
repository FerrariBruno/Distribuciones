package com.bruno.distribuciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.bruno.distribuciones.dominio.TStudent;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno
 */
public class TStudentTest {
    
    public TStudentTest() {
    }

    @Test
    public void testPorAbscisa_OK_1_0050() {
        TStudent t = new TStudent();
        
        String resEsperado = "-6.314";
        String resObtenido = t.porAbscisaTStudent(0.050, 1);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_1_0100() {
        TStudent t = new TStudent();
        
        String resEsperado = "-3.078";
        String resObtenido = t.porAbscisaTStudent(0.100, 1);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_1_0900() {
        TStudent t = new TStudent();
        
        String resEsperado = "3.078";
        String resObtenido = t.porAbscisaTStudent(0.900, 1);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_1_0995() {
        TStudent t = new TStudent();
        
        String resEsperado = "63.657";
        String resObtenido = t.porAbscisaTStudent(0.995, 1);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_20_0050() {
        TStudent t = new TStudent();
        
        String resEsperado = "-1.725";
        String resObtenido = t.porAbscisaTStudent(0.050, 20);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_20_0100() {
        TStudent t = new TStudent();
        
        String resEsperado = "-1.325";
        String resObtenido = t.porAbscisaTStudent(0.100, 20);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_20_0900() {
        TStudent t = new TStudent();
        
        String resEsperado = "1.325";
        String resObtenido = t.porAbscisaTStudent(0.900, 20);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_20_0995() {
        TStudent t = new TStudent();
        
        String resEsperado = "2.845";
        String resObtenido = t.porAbscisaTStudent(0.995, 20);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_6_0050() {
        TStudent t = new TStudent();
        
        String resEsperado = "-1.943";
        String resObtenido = t.porAbscisaTStudent(0.050, 6);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_6_0100() {
        TStudent t = new TStudent();
        
        String resEsperado = "-1.440";
        String resObtenido = t.porAbscisaTStudent(0.100, 6);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_6_0900() {
        TStudent t = new TStudent();
        
        String resEsperado = "1.440";
        String resObtenido = t.porAbscisaTStudent(0.900, 6);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_6_0995() {
        TStudent t = new TStudent();
        
        String resEsperado = "3.707";
        String resObtenido = t.porAbscisaTStudent(0.995, 6);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_100_0050() {
        TStudent t = new TStudent();
        
        String resEsperado = "-1.660";
        String resObtenido = t.porAbscisaTStudent(0.050, 100);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_100_0100() {
        TStudent t = new TStudent();
        
        String resEsperado = "-1.290";
        String resObtenido = t.porAbscisaTStudent(0.100, 100);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_100_0900() {
        TStudent t = new TStudent();
        
        String resEsperado = "1.290";
        String resObtenido = t.porAbscisaTStudent(0.900, 100);
        
        assertEquals(resEsperado, resObtenido);
    }

    @Test
    public void testPorAbscisa_OK_100_0995() {
        TStudent t = new TStudent();
        
        String resEsperado = "2.626";
        String resObtenido = t.porAbscisaTStudent(0.995, 100);
        
        assertEquals(resEsperado, resObtenido);
    }
    
}
