package lista;

/**
 *
 * @author tnica
 */
public class ListaMain {
    
    public static void main (String[] args) {
//    
//        Lista lista = new Lista();
//        
////        System.out.println("A lista está vazia? " +lista.vazia());
////        System.out.println("Comprimento da lista: " + lista.comprimento());
////        System.out.println("lista.ultimo(): " + lista.ultimo());
////        
//        lista.insere(10);
//        lista.insere(3);
////        System.out.println("Comprimento após inserir 2 nós: " + lista.comprimento());
////        
//        lista.insere(5);
//        lista.insere(6);
//        lista.insere(2);
//        System.out.println("Comprimento após inserir mais 3 nós: " + lista.comprimento());
//        
//        System.out.println("lista.impime(): ");
//        lista.imprime();
//        System.out.println();
//        
//        System.out.println("lista.toString(): ");
//        System.out.println(lista);
//        System.out.println("A lista está vazia agora? " + lista.vazia());
//        
//        System.out.println("lista.busca(1):");
//        System.out.println(lista.busca(1));
//        
//        System.out.println("lista.busca(5): " + lista.busca(5));
//        System.out.println("lista.busca(5).getProx(): " + lista.busca(5).getProx());
//        
//        System.out.println("lista.ultimo(): " + lista.ultimo());
//        
////        lista.libera();
////        System.out.println(lista.vazia());
//        lista.imprime();
////        System.out.println(lista.toString());
////        System.out.println(lista.ultimo());
////        System.out.println(lista.busca(5));
////        System.out.println(lista.comprimento());
//        
//        Lista l2 = new Lista();
//        l2.insere(4);
//        l2.insere(3);
//        l2.insere(5);
//        l2.insere(6);
//        l2.insere(2);
////        
//        System.out.println(lista.igual(l2));
//
//        System.out.println(l2.buscaRecursiva(1));
//        
        
        Lista l3 = new Lista();
        l3.insereOrdenado(2);
        l3.insereOrdenado(1);
        l3.insereOrdenado(4);
        l3.insereOrdenado(4);
        l3.insereOrdenado(3);
        l3.insere(9);
        System.out.println(l3);
        
        l3.insereEm(10,0);
        //l3.insereEm(6, l3);
        
        
        System.out.println(l3);
        
        l3.insereEm(6, 1);
        //l3.buscaPorPosicao(6).setInfo(-1);
        
        System.out.println(l3);
        
        l3.insereFim(100);
        System.out.println(l3);
        
        //System.out.println(l3.soma());
        System.out.println(l3.ultimoNoV(4));
        System.out.println(l3.comprimento());
        
        int [] v = {2,3,4,5,6,1};
        l3.concatenaArray(v);
        System.out.println(l3);
        
        Lista l4 = new Lista();
        l4.concatenaArray(v);
        System.out.println(l4);
        
    }
    
}
