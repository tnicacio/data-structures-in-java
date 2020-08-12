package arvorebinariabusca;

public class ArvoreBinariaBusca {

	private NoArvoreBinaria raiz;

	public ArvoreBinariaBusca() {
		this.raiz = null;
	}

	public NoArvoreBinaria busca(int v) {
		return raiz;
	}

	private NoArvoreBinaria busca(NoArvoreBinaria a, int v) {
		return a;
	}

	public void insere(int v) {
		this.raiz = insereAux(this.raiz, v);
	}
	
	private NoArvoreBinaria insereAux(NoArvoreBinaria no, int valor) {
		if (no == null) {
			no = new NoArvoreBinaria(valor);
		} else {
			if (valor < no.getInfo()) {
				no.setSae(insereAux(no.getSae(), valor));
			} else {
				no.setSad(insereAux(no.getSad(),valor));
			}
		}
		return no;
	}

	private NoArvoreBinaria insere(NoArvoreBinaria a, int v) {
		return a;
	}

	public void retira(int v) {
	}

	private NoArvoreBinaria retira(NoArvoreBinaria a, int v) {
		return a;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		return imprime(this.raiz, sb).toString();
	}
	
	
	private StringBuilder imprime(NoArvoreBinaria no, StringBuilder sb) {
		if (no != null) {
			imprime(no.getSae(),sb);
			sb.append(no.getInfo()).append(" ");
			imprime(no.getSad(),sb);
		}
		return sb;
	}

}
