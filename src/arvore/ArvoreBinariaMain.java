package arvore;

public class ArvoreBinariaMain {

	public static void main(String[] args) {

		ArvoreBinaria a = new ArvoreBinaria();
		a.insere(10, null, a.insere(2, null, null));
		System.out.println(a.numNos());
		System.out.println(a.vazia());
		a.insere(1, 
					a.insere(2, 
							null, 
							a.insere(4, null, null)
							),
					a.insere(3, 
							a.insere(5, 
									null, 
									null
									), 
							a.insere(6, 
									a.insere(8, null, null)
									,a.insere(10, null, null))));

		System.out.println(a);
		System.out.println(a.vazia());
		System.out.println(a.pertence(2));
		System.out.println(a.pertence(21));
		System.out.println(a.pares());
		System.out.println(a.folhas());
		
		System.out.println(a.imprimePre());
		System.out.println(a.imprimeSim());
		System.out.println(a.imprimePos());
		System.out.println(a.numNos());
		System.out.println(a.altura());
		
		ArvoreBinaria b = new ArvoreBinaria();
				b.insere(1, 
					b.insere(2, 
							null, 
							b.insere(4, null, null)
							),
					b.insere(3, 
							b.insere(5, 
									null, 
									null
									), 
							b.insere(6, 
									b.insere(8, null, null)
									,b.insere(10, null, null))));
									
	System.out.println(b);
	System.out.println(a.igual(b));

	}

}
