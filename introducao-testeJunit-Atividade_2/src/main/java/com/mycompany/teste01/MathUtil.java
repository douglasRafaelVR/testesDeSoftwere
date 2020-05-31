/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teste01;

/**
 *
 * @author dougl
 */
public class MathUtil {
    
    public static int mdc(int ... a){
        //propriedade 7
        a[0]=Math.abs(a[0]);
        a[1]=Math.abs(a[1]);
        
        //propriedade 6
        final int maior = Math.max(a[0], a[1]);
        a[1] = Math.min(a[0], a[1]);
        a[0] = maior;
        
        //propriedade 1
        if(a[1]>0 && ((a[0]%a[1])==0)){
            return a[1];
        }
        
        //propriedade 3
        if(a[1]==0){
            return Math.abs(a[0]);
        }
        
        //propriedade 5
        if(a[0] % a[1] != 0){
            return 1;
        }
        return -1;
    }
}
