package ordenacao;

import java.util.Random;

/**
 *
 * @author tnicacio
 */
public class OperacoesOrdenacao {

    public static int[] criaVetorEmbaralhado(int n) {
        int[] vetor = criaVetor(n);
        Random rando = new Random();
        for (int i = 0; i < n; i++) {
            int p = rando.nextInt(n);
            troca(vetor, i, p);
        }

        return vetor;
    }

    public static int[] criaVetor(int n) {
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = i;
        }
        return vetor;
    }

    protected static void troca(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    protected static void trocaRecursiva(int[] v, int j, int i) {
        if (j == i) {return;}
        if (v[j] > v[j+1]) {
            troca(v,j,j+1);
        }
        trocaRecursiva(v, j+1, i);
    }

    protected static int particiona(int[] v, int a, int b) {
        int x = v[a];
        while (a < b) {
            while (v[a] < x) {
                a++;
            }
            while (v[b] > x) {
                b--;
            }
            troca(v, a, b);
        }
        return a;
    }

    protected static void merge(int[] v, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        int infinite = Integer.MAX_VALUE;

        for (int i = 0; i < n1; i++) {
            left[i] = v[p + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = v[q + 1 + j];
        }

        left[left.length - 1] = infinite;
        right[right.length - 1] = infinite;

        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                v[k] = left[i++];
            } else {
                v[k] = right[j++];
            }
        }
    }
}
