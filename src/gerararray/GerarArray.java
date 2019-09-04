/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerararray;

import java.util.Random;

/**
 *
 * @author jean
 */
public class GerarArray {
    
    static public String aleatorio(Integer size){
        
        Random random = new Random();
        String array = new String();
        
        for(int i = 0;i < size;i++)
             array += Integer.toString(random.nextInt()) + "\n";
        
        return array;
    }
    
    static public String crescente(Integer size){
        
        String array = new String();
        
        for(int i = 0;i < size;i++)
            array += Integer.toString(i)+"\n";
        
        return array;
    }
    
    static public String decrescente(Integer size){
        
        String array = new String();
        
        for(int i = 0;i < size;i++)
            array += Integer.toString(size-i-1)+"\n";
        
        return array;
    }
}
