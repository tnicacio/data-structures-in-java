package ordenacao;

import java.util.Arrays;

/**
 *
 * @author tnicacio
 */
public class OrdenacaoMain {

    public static void main(String[] args) {

        int[][] vetor = new int[4][];
        long[] bubbleTempos = new long[4];
        long[] quickTempos = new long[4];
        long[] mergeTempos = new long[4];
        long antes = 0;
        long depois = 0;
        long tempo = 0;

        for (int i = 0; i < 4; i++) {
            vetor[i] = OperacoesOrdenacao.criaVetorEmbaralhado((int) Math.pow(10, (i + 1)));
        }

        int[][] bSort = Arrays.stream(vetor)
                .map(a -> Arrays.copyOf(a, a.length))
                .toArray(int[][]::new);

        int[][] qSort = Arrays.stream(vetor)
                .map(a -> Arrays.copyOf(a, a.length))
                .toArray(int[][]::new);

        int[][] mSort = Arrays.stream(vetor)
                .map(a -> Arrays.copyOf(a, a.length))
                .toArray(int[][]::new);

        //Roda o algoritmo uma vez para os tempos serem mais coerentes
        Ordenacao.mergeSort(vetor[0]);
        Ordenacao.bubbleSort(vetor[1]);
        Ordenacao.quickSort(vetor[2]);
        
        for (int i = 0; i < 4; i++) {

            antes = System.nanoTime();
            Ordenacao.bubbleSort(bSort[i]);
            depois = System.nanoTime();
            tempo = depois - antes;
            bubbleTempos[i] = tempo;

            antes = System.nanoTime();
            Ordenacao.quickSort(qSort[i]);
            depois = System.nanoTime();
            tempo = depois - antes;
            quickTempos[i] = tempo;

            antes = System.nanoTime();
            Ordenacao.mergeSort(mSort[i]);
            depois = System.nanoTime();
            tempo = depois - antes;
            mergeTempos[i] += tempo;
            
        }
        
        long [][] resultados = {bubbleTempos, quickTempos, mergeTempos};

        System.out.println("                ---------------------------Tempos (ns)-----------------------");
        System.out.println("Num elementos\t-BubbleSort-\t-QuickSort-\t-MergeSort-\t-Mais Rápido-");
        for (int i = 0; i < 3; i++) {
            System.out.println("    10^" + (i+1) + "\t" 
                    + bubbleTempos[i] + "\t\t" 
                    + quickTempos[i] + "\t\t" 
                    + mergeTempos[i] + "\t\t" 
                    + getFastest(resultados)[i]);
        }
        System.out.println("    10^" + (4) + "\t" 
                + bubbleTempos[3] + "\t" 
                + quickTempos[3] + "\t\t" 
                + mergeTempos[3] + "\t\t" 
                + getFastest(resultados)[3]);

    }
    
    public static String [] getFastest(long[][] resultados){
        long[] min = new long [4];
        String[] pos = new String [4];
        for (int i = 0; i < min.length; i++){
            min[i] = Long.MAX_VALUE;
        }

        for (int linha = 0; linha < resultados[0].length; linha++ ){            
            for (int coluna = 0; coluna < resultados.length; coluna++){
                if (resultados[coluna][linha] < min[linha]){
                    min[linha] = resultados[coluna][linha];
                    pos[linha] = coluna  == 0? "Bubble Sort" : 
                                 coluna == 1 ? "Quick Sort" :
                                               "Merge Sort";
                }
            }
            
        }
        return pos;
    }

}
