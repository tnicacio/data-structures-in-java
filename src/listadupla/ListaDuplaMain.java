package listadupla;

/**
*
* @author tnicacio
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
       l2.insereFim(5);
       l2.insereFim(8);
       System.out.println("l2: " + l2);
       
//       l.libera();
//       System.out.println(l);
       
       ListaDupla mergeada = l.merge(l2);
       System.out.println("mergeada: " + mergeada);
       mergeada.insereFim(12);
       System.out.println(mergeada);
       
       ListaDupla nova = mergeada.separa(3);
       System.out.println(mergeada);
       System.out.println(nova);
//       ListaDupla nova2 = nova.separa(8);
//       System.out.println(nova);
//       System.out.println(nova2);
       nova.inverte();
       System.out.println(nova);
       
       ListaDupla l3 = new ListaDupla();
       l3.insere(5);
       l3.insere(8);
       l3.insere(12);
       System.out.println(l3);
       System.out.println(nova.igual(l3));
   }
}
