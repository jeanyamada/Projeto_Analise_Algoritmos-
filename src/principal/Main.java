/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import gui.PrincipalGui;

/**
 *
 * @author jean
 */
public class Main {
    
    private static Integer [] Array;
    public static PrincipalGui principalGui;
    

    public static void main(String [] args){
        principalGui = new PrincipalGui();
        
        principalGui.setVisible(true);
    }

    /**
     * @return the Array
     */
    public static Integer[] getArray() {
        return Array;
    }

    /**
     * @param aArray the Array to set
     */
    public static void setArray(Integer[] aArray) {
        Array = aArray;
    }
    
}
