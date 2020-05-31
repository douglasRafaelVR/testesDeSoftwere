/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teste01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dougl
 */
public class MathUtilTest {
    
    /*
    Professor, infelizmente, eu não consegui rodar 
    os testes sem ser 'public'.
    */
    
    @Test
    public void testMdcAParP1() {
        final int a = 6;
        final int b = 3;
        final int esperado = b;
        final int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void testMdcAImparP1(){
        final int a = 9;
        final int b = 3;
        final int esperado = b;
        final int obtido = MathUtil.mdc(a, b);
        assertEquals(esperado, obtido);
    }
    
}
