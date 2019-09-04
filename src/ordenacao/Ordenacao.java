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
public class Ordenacao {

    public static void bublleSort(Integer[] array) {

        int lenght = array.length;

        for (int i = 0; i < lenght - 1; i++) {
            for (int j = 0; j < lenght - 1 - i; j++) {

                if (array[j] > array[j + 1]) {

                    troca(array, j, j + 1);
                }
            }
        }

    }

    public static void bublleSortMelhorado(Integer[] array) {

        int lenght = array.length;
        boolean flag = true;

        for (int i = 0; (i < lenght - 1) && flag; i++) {
            flag = false;
            for (int j = 0; j < lenght - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    troca(array, j, j + 1);
                }
            }
        }
    }

    public static void quickSort(Integer[] array, int inicio, int fim) {

        int i, j, pivo;

        i = inicio;
        j = fim;

        pivo = array[(inicio + fim) / 2];

        while (i < j) {

            while (array[i] < pivo) {
                ++i;
            }
            while (array[j] > pivo) {
                --j;
            }

            if (i <= j) {
                troca(array, i, j);
                ++i;
                --j;
            }
        }
        if (i < fim) {
            quickSort(array, i, fim);
        }
        if (j > inicio) {
            quickSort(array, inicio, j);
        }
    }

    public static void quickSort2(Integer[] array, int inicio, int fim) {

        int i, j, pivo;

        i = inicio + 1;
        j = fim;

        pivo = array[inicio];

        while (i < j) {

            while (array[i] < pivo && i < fim) {
                ++i;
            }
            while (array[j] > pivo && j > inicio) {
                --j;
            }

            if (i < j) {
                troca(array, i, j);
                ++i;
                --j;
            }
        }

        troca(array, inicio, i);

        if (i < fim) {
            quickSort(array, i, fim);
        }
        if (j > inicio) {
            quickSort(array, inicio, j);
        }
    }

    public static void insertionSort(Integer array[]) {
        Integer eleito;
        for (int i = 0; i < array.length; i++) {
            eleito = array[i];
            int j;
            for (j = i - 1; j >= 0 && eleito < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = eleito;

        }
    }

    /*
    * Define o salto inicial da função ShellSort
     */
    private static int shellStartJump(int dimensao) {
        int ret, aux;
        aux = (dimensao / 3) + 1;
        for (ret = 1; ret <= aux; ret = 3 * ret + 1);
        /* Intencional */
        if (ret > aux) {
            ret /= 3;
        }
        return ret;
    }

    /*
     * Ordena um arranjo pelo método de Shell. Método de ordenação padrão.
     */
    public static void shellSort(Integer array[]) {

        int jump, i, j, aux;

        jump = shellStartJump(array.length);
        while (jump > 0) {
            for (i = jump; i < array.length; i++) {
                aux = array[i];
                for (j = i; j >= jump && aux < array[j - jump]; j -= jump) {
                    array[j] = array[j - jump];
                }
                array[j] = aux;
            }
            jump /= 3;
        }
    }

    public static void selectionSort(Integer array[]) {
        int menor;
        for (int i = 0; i < array.length - 1; i++) {
            menor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }

            troca(array, menor, i);

        }
    }

    public static void troca(Integer[] array, int a, int b) {

        if (a != b) {
            array[a] = array[a] + array[b];
            array[b] = array[a] - array[b];
            array[a] = array[a] - array[b];
        }

    }

    public static void heapSort(Integer array[]) {
        for (int i = array.length - 1; i > -1; i--) {
            array[i] = Heap.removerHeap();
        }
    }

    public static void mergeSort(Integer[] array, int inicio, int fim) {

        if (inicio < fim) {

            int meio = (inicio + fim) / 2;

            mergeSort(array, inicio, meio);
            mergeSort(array, meio + 1, fim);
            merge(array, inicio, meio, fim);
        }
    }

    public static void merge(Integer[] array, int inicio, int meio, int fim) {

        int i, j, k;
        Integer[] auxiliar;

        i = inicio;
        j = meio + 1;
        k = inicio; 
        //auxiliar = array.clone();
        
        auxiliar = new Integer [array.length];
        
        for (int l = i ; l <= fim; l++) 
                auxiliar[l] = array[l];
        
        
        while (i <= meio && j <= fim) {

            if (auxiliar[i] < auxiliar[j]) {

                array[k] = auxiliar[i];
                i++;
            } else {
                array[k] = auxiliar[j];
                j++;
            }
            k++;
        }

        while (i <= meio) {

            array[k] = auxiliar[i];
            i++;
            k++;
        }

        while (j <= fim) {
            array[k] = auxiliar[j];
            j++;
            k++;
        }
    }

}
