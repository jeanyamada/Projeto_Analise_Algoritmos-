/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenacao;

/**
 *
 * @author jean
 */
public class Heap {
    
    private static Integer [] heap;
    private static int quant;
    /**
     * @return the heap
     */
    public static Integer[] getHeap() {
        return heap;
    }

    /**
     * @param aHeap the heap to set
     */
    public static void setHeap(Integer[] aHeap) {
        heap = aHeap;
    }

    public Heap(Integer array[]){
        
        heap = new Integer[array.length];
        quant = 0;
        for (Integer array1 : array) 
            inserirHeap(array1);
        
    }
    
    
    /*subir recursivo*/
    private static void subir(int cont){	
        if(cont != 0 && getHeap()[(cont-1)/2] < getHeap()[cont]){
                troca(getHeap(),(cont-1)/2,cont);
                subir((cont-1)/2);
        }

    }
    
    /*decer recursivo*/
    private static void descer(int cont,int quant){
        cont = cont * 2;

        /*verifica se exitem filhos*/
        if(cont+2 < quant && cont+1 < quant){	

            if(getHeap()[cont+1] > getHeap()[cont+2]) ++cont;
            else cont +=2;

            if(getHeap()[(cont-1)/2] < getHeap()[cont]){ 
                            troca(getHeap(),(cont-1)/2,cont);
                            descer(cont,quant);
            }
        }
        else{/*caso tenha apenas um filho*/
            
            if(cont+1 < quant){
                    ++cont;

                if(getHeap()[(cont-1)/2] < getHeap()[cont]){ 
                    troca(getHeap(),(cont-1)/2,cont);
                    descer(cont,quant);
                }
            }
	}
    }
    
    public static Integer removerHeap(){
        
        int aux = getHeap()[0];

        if(quant > 0){
            /*colocando o ultimo elemento na primeira posição para desse-lo*/
            getHeap()[0] = getHeap()[quant-1];
            descer(0,quant-1);
            quant--;
        }
        
        return aux;
    }
    
    private static void inserirHeap(int elemento){

        /*inserindo na ultima posição*/
        getHeap()[quant] = elemento;
        subir(quant);
        quant++;
    }

    private static void troca(Integer heap[],int a,int b){
            int aux = heap[a];
            heap[a] = heap [b];
            heap[b] = aux;
    }
}
