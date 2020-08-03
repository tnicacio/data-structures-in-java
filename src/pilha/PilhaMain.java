package pilha;

public class PilhaMain {

	public static void main(String[] args) {
		PilhaLista p = new PilhaLista();
//		topTeste(p);
		System.out.println(p.vazia());
		pushTeste(p);
		System.out.println(p.vazia());
		popTeste(p);
//		pushTeste2(p);
		topTeste(p);
		p.reset();
		System.out.println(p);

	}
	
	public static void topTeste(PilhaLista p) {
		try {
			System.out.println(p.top());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pushTeste(PilhaLista p) {
		try {
			p.push(1);
			p.push(2);
			p.push(4);
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void pushTeste2(PilhaLista p) {
		try {
			p.push(4);
			p.push(6);
			p.push(5);
			p.push(2);
			p.push(9);
			p.push(10);
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void popTeste(PilhaLista p) {
		try {
			int result = p.pop();
			System.out.println(result);
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
