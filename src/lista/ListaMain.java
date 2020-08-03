package lista;

public class ListaMain {
	
	public static void main(String[] args) {
		
		ListaCircular lc = new ListaCircular();
		System.out.println(lc.comprimento());
		lc.insereInicio(1);
		System.out.println(lc.comprimento());
		lc.insereInicio(2);
		lc.insereFim(10);
		lc.insereFim(4);
		lc.insereInicio(3);
//		System.out.println(lc);
		lc.imprime();
		System.out.println(lc.busca(5));
		System.out.println(lc.comprimento());
		
		ListaCircular l2 = new ListaCircular();
		l2.insereFim(3);
		l2.insereFim(2);
		l2.insereFim(1);
		l2.insereFim(10);
		l2.insereFim(4);
		System.out.println(lc);
		System.out.println(l2);
		System.out.println(lc.igual(l2));
		
		l2.retira(11);
		l2.retira(1);
		l2.retira(3);
//		l2.retira(2);
//		l2.retira(10);
//		l2.libera();
		System.out.println(l2);
		System.out.println(l2.comprimento());
		System.out.println(lc.comprimento());
		System.out.println(l2.igual(lc));
	}

}
