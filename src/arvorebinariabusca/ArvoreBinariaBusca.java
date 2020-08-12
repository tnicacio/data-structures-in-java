package arvorebinariabusca;

public class ArvoreBinariaBusca {

	private NoArvoreBinaria raiz;

	public ArvoreBinariaBusca() {
		this.raiz = null;
	}

	public NoArvoreBinaria busca(int v) {
		return busca(this.raiz, v);
	}

	private NoArvoreBinaria busca(NoArvoreBinaria a, int v) {
		if (a == null) {
			return null;
		}
		if (v < a.getInfo()) {
			return busca(a.getSae(), v);
		}
		if (v > a.getInfo()) {
			return busca(a.getSad(), v);
		}
		return a;
	}

	public void insere(int v) {
		this.raiz = insere(this.raiz, v);
	}

	private NoArvoreBinaria insere(NoArvoreBinaria a, int v) {
		if (a == null) {
			return new NoArvoreBinaria(v);
		}
		if (v < a.getInfo()) {
			a.setSae(insere(a.getSae(), v));
		} else {
			a.setSad(insere(a.getSad(), v));
		}
		return a;
	}

	public void retira(int v) {
		this.raiz = retira(this.raiz, v);
	}

	private NoArvoreBinaria retira(NoArvoreBinaria a, int v) {
		if (a == null) {
			return null;
		}
		if (v < a.getInfo()) {
			a.setSae(retira(a.getSae(), v));
			return a;
		}
		if (v > a.getInfo()) {
			a.setSad(retira(a.getSad(), v));
			return a;
		}
		if (a.getSae() == null && a.getSad() == null) {
			return a = null;
		}
		if (a.getSae() == null) {
			return a = a.getSad();
		}
		if (a.getSad() == null) {
			return a = a.getSae();
		}

		NoArvoreBinaria p = a.getSae();
		while (p.getSad() != null) {
			p = p.getSad();
		}
		a.setInfo(p.getInfo());
		p.setInfo(v);
		a.setSae(retira(a.getSae(), v));
		return a;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		return imprime(this.raiz, sb).toString();
	}

	private StringBuilder imprime(NoArvoreBinaria no, StringBuilder sb) {
		if (no != null) {
			imprime(no.getSae(), sb);
			sb.append(no.getInfo()).append(" ");
			imprime(no.getSad(), sb);
		}
		return sb;
	}

}
