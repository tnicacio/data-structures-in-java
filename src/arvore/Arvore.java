package arvore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arvore {

	private NoArvore raiz;

	public Arvore() {
		this.raiz = null;
	}

	public NoArvore criaNo(int info) {
		NoArvore novo = new NoArvore(info);
		this.raiz = novo;
		return novo;
	}

	// Desse jeito o último nó inserido como 'pai' será a raiz da árvore
	public void insereFilho(NoArvore pai, NoArvore filho) {
		filho.setProx(pai.getPrim());
		pai.setPrim(filho);
		this.raiz = pai;
	}

	public String toString() {

		if (this.raiz == null) {
			throw new Error("Árvore N-ária não pode ser vazia");
		}

		return imprime(this.raiz);
	}

	private String imprime(NoArvore no) {
		String s = "";
		s = s + "<" + no.getInfo();
		NoArvore p = no.getPrim();
		while (p != null) {
			s = s + imprime(p);
			p = p.getProx();
		}

		s = s + ">";
		return s;
	}

	public boolean pertence(int info) {
		return pertence(this.raiz, info);
	}

	private boolean pertence(NoArvore no, int info) {

		if (no.getInfo() == info) {
			return true;
		}

		NoArvore p = no.getPrim();
		while (p != null) {
			if (pertence(p, info)) {
				return true;
			}
			p = p.getProx();
		}

		return false;
	}

	public int altura() {
		return altura(this.raiz);
	}

	private int altura(NoArvore no) {
		int hmax = -1;
		NoArvore p = no.getPrim();

		while (p != null) {
			int h = altura(p);
			if (h > hmax) {
				hmax = h;
			}
			p = p.getProx();
		}

		return hmax + 1;
	}

	public int pares() {
		return pares(this.raiz);
	}

	private int pares(NoArvore no) {

		int counter = 0;
		NoArvore p = no.getPrim();

		while (p != null) {
			counter += pares(p);
			if (p.getInfo() % 2 == 0) {
				++counter;
			}
			p = p.getProx();
		}

		return counter;
	}

	public int folhas() {
		return folhas(this.raiz);
	}

	private int folhas(NoArvore no) {

		int counter = 0;
		NoArvore p = no.getPrim();

		while (p != null) {
			counter += folhas(p);
			if (p.getPrim() == null) {
				++counter;
			}
			p = p.getProx();
		}
		return counter;
	}

	// Estritamente igual
	public boolean igual(Arvore a) {
		return igual(a.raiz, this.raiz);
	}

	private boolean igual(NoArvore outra, NoArvore essa) {

		NoArvore noOutra = outra.getPrim();
		NoArvore noEssa = essa.getPrim();

		while (noOutra != null && noEssa != null) {

			igual(noOutra, noEssa);

			if (noOutra.getInfo() != noEssa.getInfo()) {
				return false;
			}
			noOutra = noOutra.getProx();
			noEssa = noEssa.getProx();

		}

		return noOutra == noEssa;
	}

	/*
	 * Esse método não faz parte da lista. Foi criado apenas por diversão.
	 * O método similar checa se duas árvores podem virar estritamente iguais caso
	 * os nós de um mesmo nível sejam trocados de posição.
	 * 
	 */
	public boolean similar(Arvore a) {
		if (a.raiz.getInfo() != this.raiz.getInfo()) {
			return false;
		}
		int hA = altura(a.raiz);
		int hB = altura(this.raiz);

		if (hA != hB) {
			return false;
		}

//		if (!igual(a)) {
//			return false;
//		}

		List<NoArvore>[] vetorA = getValoresPorNivel(a, hA);
		List<NoArvore>[] vetorB = getValoresPorNivel(this, hB);

		for (int i = 0; i <= hA; i++) {

			int tamanhoNivel = vetorA[i].size();

			if (tamanhoNivel != vetorB[i].size()) {
				return false;
			}

			for (int j = 0; j < tamanhoNivel; j++) {
				if (vetorA[i].get(j).getInfo() != vetorB[i].get(j).getInfo()) {
					return false;
				}
			}
		}

		return true;
	}

	private List<NoArvore>[] getValoresPorNivel(Arvore a, int altura) {

		List<NoArvore>[] vetor = createArrays(altura);
		vetor[0].add(a.raiz);
		getNiveis(a.raiz, vetor, 0);

		for (int i = 0; i < vetor.length; i++) {
			Collections.sort(vetor[i], (v1, v2) -> {
				return v1.getInfo() - v2.getInfo();
			});
		}

		return vetor;
	}

	private List<NoArvore>[] createArrays(int hA) {

		@SuppressWarnings("unchecked")
		List<NoArvore>[] vetor = new ArrayList[hA + 1];

		for (int i = 0; i <= hA; i++) {
			vetor[i] = new ArrayList<NoArvore>();
		}
		return vetor;
	}

	private List<NoArvore>[] getNiveis(NoArvore no, List<NoArvore>[] vetor, int h) {

		NoArvore p = no.getPrim();
		++h;
		while (p != null) {
			getNiveis(p, vetor, h);
			vetor[h].add(p);
			p = p.getProx();
		}
		return vetor;
	}

}
