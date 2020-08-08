package arvore;

public class ArvoreMain {
	
	public static void main(String[] args) {
	
		Arvore a = new Arvore();
		
//		NoArvore no1 = new NoArvore(1);
//		a.criaNo(3);
//		a.criaNo(4);
//		NoArvore no2 = new NoArvore(2);
//		a.insereFilho(no1, no2);

//		System.out.println(no1);
//		System.out.println(a);
		
		NoArvore no1 = a.criaNo(1);
		NoArvore no2 = a.criaNo(2);
		NoArvore no3 = a.criaNo(3);
//		NoArvore no4 = a.criaNo(4);
		NoArvore no5 = a.criaNo(5);
		NoArvore no6 = a.criaNo(6);
//		NoArvore no7 = a.criaNo(7);
//		NoArvore no8 = a.criaNo(8);
//		NoArvore no9 = a.criaNo(9);
//		NoArvore no10 = a.criaNo(10);
		

//		a.insereFilho(no3, no4);
		a.insereFilho(no2, no5);
		a.insereFilho(no2, no3);
//		a.insereFilho(no9, no10);
//		a.insereFilho(no7, no9);
//		a.insereFilho(no7, no8);
//		a.insereFilho(no1, no7);
		a.insereFilho(no1, no6);
		a.insereFilho(no1, no2);
		
		Arvore b = new Arvore();
		
		NoArvore no1b = b.criaNo(1);
		NoArvore no2b = b.criaNo(2);
		NoArvore no3b = b.criaNo(3);
		NoArvore no6b = b.criaNo(6);
		NoArvore no5b = b.criaNo(5);
		
		b.insereFilho(no2b, no3b);
		b.insereFilho(no1b, no2b);
		b.insereFilho(no2b, no5b);
		b.insereFilho(no1b, no6b);
//		b.insereFilho(no2b, no3b);
		//O último nó inserido como 'pai' em insereFilho(pai,filho) definirá a raiz da árvore.
		
		Arvore c = new Arvore();
		
		NoArvore no1c = c.criaNo(1);
		NoArvore no2c = c.criaNo(2);
		NoArvore no3c = c.criaNo(3);
		NoArvore no6c = c.criaNo(6);
		NoArvore no5c = c.criaNo(5);
		

		c.insereFilho(no2c, no5c);
		c.insereFilho(no1c, no6c);
		c.insereFilho(no1c, no2c);
		c.insereFilho(no2c, no3c);
		
		System.out.println(a);
//		System.out.println(a.altura());
//		System.out.println(a.pares());
		System.out.println(a.folhas());
		
		System.out.println(b);
//		System.out.println(b.altura());
		
		System.out.println(a.igual(b));
		System.out.println(a.similar(b));
		
//		System.out.println(c);
	}
}
