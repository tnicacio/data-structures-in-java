package arvore;

public class ArvoreBinaria {

	private NoArvoreBinaria raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	public NoArvoreBinaria insere(int v, NoArvoreBinaria esq, NoArvoreBinaria dir) {
		NoArvoreBinaria no = new NoArvoreBinaria(v, esq, dir);
		this.raiz = no;
		return no;
	}

	public boolean vazia() {
		return this.raiz == null;
	}

	public String toString() {
		return toStringAux(this.raiz);
	}

	private String toStringAux(NoArvoreBinaria no) {
		StringBuilder sb = new StringBuilder().append("<");
		if (no != null) {
			sb.append(no.getInfo()).append(toStringAux(no.getSae())).append(toStringAux(no.getSad()));
		}
		return sb.append(">").toString();
	}

	public boolean pertence(int info) {
		return pertence(this.raiz, info);
	}

	private boolean pertence(NoArvoreBinaria no, int info) {
		if (no == null) {
			return false;
		}
		return (no.getInfo() == info || pertence(no.getSae(), info) || pertence(no.getSad(), info));
	}

	public int pares() {
		return pares(raiz, 0);
	}

	private int pares(NoArvoreBinaria no, int count) {
		if (no == null) {
			return count;
		}
		if (no.getInfo() % 2 == 0) {
			++count;
		}
		return pares(no.getSae(), pares(no.getSad(), count));
	}

	public int folhas() {
		return folhas(this.raiz, 0);
	}

	private int folhas(NoArvoreBinaria no, int count) {
		if (no == null) {
			return count;
		}
		if (no.getSae() == null && no.getSad() == null) {
			++count;
		}
		return folhas(no.getSae(), folhas(no.getSad(), count));
	}

	public String imprimePre() {
		return imprimePreAux(this.raiz);
	}

	private String imprimePreAux(NoArvoreBinaria no) {
		StringBuilder sb = new StringBuilder().append("<");
		if (no != null) {
			sb.append(no.getInfo()).append(toStringAux(no.getSae())).append(toStringAux(no.getSad()));
		}
		return sb.append(">").toString();
	}

	public String imprimeSim() {
		return imprimeSimAux(this.raiz);
	}

	private String imprimeSimAux(NoArvoreBinaria no) {
		StringBuilder sb = new StringBuilder().append("<");
		if (no != null) {
			sb.append(toStringAux(no.getSae())).append(no.getInfo()).append(toStringAux(no.getSad()));
		}
		return sb.append(">").toString();
	}

	public String imprimePos() {
		return imprimePosAux(this.raiz);
	}

	private String imprimePosAux(NoArvoreBinaria no) {
		StringBuilder sb = new StringBuilder().append("<");
		if (no != null) {
			sb.append(toStringAux(no.getSae())).append(toStringAux(no.getSad())).append(no.getInfo());
		}
		return sb.append(">").toString();
	}

	public int numNos() {
		return numNos(this.raiz, 0);
	}

	private int numNos(NoArvoreBinaria no, int count) {
		if (no == null) {
			return count;
		}
		return numNos(no.getSae(), numNos(no.getSad(), ++count));
	}

	public int altura() {
		return alturaAux(this.raiz);
	}

	private int alturaAux(NoArvoreBinaria no) {
		int altura = -1;
		if (no != null) {
			int h1 = alturaAux(no.getSae());
			int h2 = alturaAux(no.getSad());
			if (h1 > h2) {
				altura = 1 + h1;
			} else {
				altura = 1 + h2;
			}
		}
		return altura;
	}

	public boolean igual(ArvoreBinaria a) {
		return igual(a.raiz, this.raiz);
	}

	private boolean igual(NoArvoreBinaria noOther, NoArvoreBinaria noThis) {
		if (noOther != null && noThis != null) {

			if (noThis.getInfo() != noOther.getInfo()) {
				return false;
			}
			return igual(noOther.getSae(), noThis.getSae()) 
					== igual(noOther.getSad(), noThis.getSad());
		}
		return noOther == noThis;
	}

}
