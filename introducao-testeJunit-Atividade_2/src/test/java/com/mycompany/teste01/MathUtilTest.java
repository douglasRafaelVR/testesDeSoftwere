/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teste01;

import static com.mycompany.teste01.MathUtil.mdc;
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
    
    @Test
    public void TestMdcParesP2(){
        final int a=16;
        final int b=8;
        final int divisor=4;
        //final int esperado = 0;
        final int obtido = MathUtil.mdc(a, b);
        //assertEquals(esperado,obtido % divisor);
        assertTrue((obtido % divisor) == 0);
    }
    
    @Test 
    public void TestMdcAPositivoP3(){
        final int a=15;
        final int b=0;
        final int esperado = 15;
        final int obtido = MathUtil.mdc(a,b);
        assertEquals(esperado, obtido);
    }
    
    @Test 
    public void TestMdcANegativoP3(){
        final int a=-30;
        final int b=0;
        final int esperado = 30;
        final int obtido = MathUtil.mdc(a,b);
        assertEquals(esperado, obtido);
    }
    
    @Test 
    public void TestMdcMparP4(){
        final int a=9;
        final int b=3;
        final int m=2;
        final int esperado = MathUtil.mdc(m*a,m*b);
        final int obtido = m*MathUtil.mdc(a,b);
        assertEquals(esperado, obtido);
    }
    
    @Test 
    public void TestMdcP5(){
        final int a=7;
        final int b=3;
        final int c=5;
        final int esperado = mdc(b*a,c);
        final int obtido = mdc(b,c);
        assertEquals(esperado, obtido);
    }
    
    @Test 
    public void TestMdcP5Resultado1(){
        final int a=7;
        final int b=3;
        final int c=5;
        final int esperado = mdc(b*a,c);
        final int obtido = mdc(b,c);
        //assertEquals(esperado, obtido);
        assertEquals(esperado, 1);
    }
    
    @Test 
    public void TestMdcP6(){
        final int a=8;
        final int b=2;
        final int esperado = mdc(a,b);
        final int obtido = mdc(b,a);
        //assertEquals(esperado, obtido);
        assertEquals(esperado,obtido);
    }
    
    @Test 
    public void TestMdcP7TudoNegativo(){
        final int a=-12;
        final int b=-6;
        final int esperado = 6;
        final int obtido = mdc(a,b);
        //assertEquals(esperado, obtido);
        assertEquals(esperado,obtido);
    }
    
    @Test
    public void TestMdcAInteiroPositivoP8(){
        final int a=5;
        final int esperado = 5;
        final int obtido = mdc(a,a);
        //assertEquals(esperado, obtido);
        assertEquals(esperado,obtido);
    }
    
    @Test
    public void TestMdcAssociativoP9(){
        final int a=5;
        final int b=10;
        final int c=15;
        final int esperado = mdc(a,mdc(b,c));
        final int obtido = mdc(mdc(a,b),c);
        //assertEquals(esperado, obtido);
        assertEquals(esperado,obtido);
        
    }
    
    @Test
    public void TestMdcAssociativoComTresArgumentosP9(){
        final int a=5;
        final int b=10;
        final int c=15;
        final int esperado = mdc(a,mdc(b,c));
        final int obtido = mdc(a,b,c);
        //assertEquals(esperado, obtido);
        assertEquals(esperado,obtido);
        
    }
    
    @Test
    public void TestMdcP12(){
        final int p=5;
        final int a=10;
        final int esperado = 5;
        final int obtido = mdc(p,a);
        //assertEquals(esperado, obtido);
        assertEquals(esperado,obtido);
        
    }
    
    
    
}
