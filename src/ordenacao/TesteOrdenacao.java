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
public class TesteOrdenacao {
    
    /**
     * @param tamanhoVetor Tamanho do vetor a ser ordenado
     * @param repeticoes Repeticoes para cálculo da média do tempo de execução dos métodos
     */
    public static void init(int tamanhoVetor, int repeticoes){
        
        int BUBBLE = 0;
        int QUICK = 1;
        int MERGE = 2;

        //long [][] result = new long [3][100];
        long[] somaTempos = new long[3];
        long[] mediaTempos = new long[3];

        int[][] vetor = new int[3][tamanhoVetor];

        for (int i = 0; i < repeticoes; i++) {

            for (int j = BUBBLE; j <= MERGE; j++) {
                vetor[j] = OperacoesOrdenacao.criaVetorEmbaralhado(tamanhoVetor);
            }

            long antes_bubble = System.nanoTime();
            Ordenacao.bubbleSort(vetor[BUBBLE]);
            long depois_bubble = System.nanoTime();
            long tempo_bubble = depois_bubble - antes_bubble;

            //result[TEMPO_BUBBLE][i] = tempo_bubble;
            somaTempos[BUBBLE] += tempo_bubble;

            long antes_quick = System.nanoTime();
            Ordenacao.quickSort(vetor[QUICK]);
            long depois_quick = System.nanoTime();
            long tempo_quick = depois_quick - antes_quick;

            //result[QUICK][i] = tempo_quick;
            somaTempos[QUICK] += tempo_quick;

            long antes_merge = System.nanoTime();
            Ordenacao.mergeSort(vetor[MERGE]);
            long depois_merge = System.nanoTime();
            long tempo_merge = depois_merge - antes_merge;

            //result[MERGE][i] = tempo_merge;
            somaTempos[MERGE] += tempo_merge;
        }

        for (int k = BUBBLE; k <= MERGE; k++) {
            mediaTempos[k] = somaTempos[k] / repeticoes;
        }

        System.out.println("------Método-----|--------Tempo--------");
        System.out.println("    Bubble Sort         " + mediaTempos[BUBBLE]);
        System.out.println("    Quick Sort          " + mediaTempos[QUICK]);
        System.out.println("    Merge Sort          " + mediaTempos[MERGE]);

    }
}
