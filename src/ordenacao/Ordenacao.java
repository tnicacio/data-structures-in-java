/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenacao;

/**
 *
 * @author tnica
 */
public class Ordenacao extends OperacoesOrdenacao{    
    
    public static void bubbleSort(int[] v) {
        for (int i = v.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (v[j] > v[j + 1]) {
                    troca(v, j, j + 1);
                }
            }
        }
    }
    
    public static void bubbleSortRecursive(int[] v) {
        bubbleSortRecursive(v,v.length-1);
    }
    
    public static void bubbleSortRecursive(int[] v, int n) {
        if (n > 0){
            trocaRecursiva(v,0,n);
            bubbleSortRecursive(v, n-1);
        }
    }
    
    public static void trocaRecursiva(int[] v, int j, int i) {
        if (j == i) {return;}
        if (v[j] > v[j+1]) {
            troca(v,j,j+1);
        }
        trocaRecursiva(v, j+1, i);
    }
   
    public static void quickSort(int[] v) {
        int a = 0;
        int b = v.length - 1;
        quickSort(v, a, b);
    }

    public static void quickSort(int[] v, int a, int b) {
        if (a >= b) {return;}
        int indicePivo = particiona(v, a, b);
        quickSort(v, a, indicePivo);
        quickSort(v, indicePivo + 1, b);
    }

    public static void mergeSort(int[] v) {
        int p = 0;
        int r = v.length - 1;
        mergeSort(v, p, r);
    }

    public static void mergeSort(int[] v, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(v, p, q);
            mergeSort(v, q + 1, r);
            merge(v, p, q, r);
        }
    }

}
