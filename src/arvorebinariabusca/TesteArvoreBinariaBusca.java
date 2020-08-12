package arvorebinariabusca;

public class TesteArvoreBinariaBusca {

	public static void main(String[] args) {
		
		ArvoreBinariaBusca ab = new ArvoreBinariaBusca();
		ab.insere(1);
		ab.insere(2);
		ab.insere(4);
		ab.insere(3);
		System.out.println(ab);
		
		System.out.println(ab.busca(2));
		System.out.println(ab.busca(5));
		ab.retira(5);
		System.out.println(ab);
		ab.retira(3);
		ab.retira(1);
		System.out.println(ab);

	}

}
