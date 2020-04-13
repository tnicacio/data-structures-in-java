package listadupla;

/**
 *
 * @author tnica
 */
public class ListaDuplaMain {
    
    public static void main (String[] args){
        
        ListaDupla l = new ListaDupla();
        l.insere(2);
        l.insere(3);
        l.insere(1);
        System.out.println(l);
        l.retira(2);
        System.out.println("l : " + l);
        
        ListaDupla l2 = new ListaDupla();
        l2.insereFim(4);
//        l2.insereFim(5);
//        l2.insere(0);
        System.out.println("l2: " + l2);
        
//        l.libera();
//        ListaDupla copia = l.copia();
//        copia.insere(4);
//        System.out.println(l);
//        System.out.println(copia);
        
//        copia.insereFim(5);
//        System.out.println(copia);
        ListaDupla mergeada = l.merge(l2);
        System.out.println("mergeada: " + mergeada);
        
        ListaDupla l3 = mergeada.copia();
        System.out.println("l3: "+l3);
        
        mergeada.insereFim(12);
        
        System.out.println(mergeada);
        System.out.println(l3);
        
        l3.libera();
        System.out.println(l3);
        
        
    }
}
