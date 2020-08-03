package lista;

public class ListaCircular {

	private NoLista prim;

	public ListaCircular() {
		this.prim = null;
	}

	public void insereInicio(int v) {
		this.prim = insereFimAux(v);
	}

	public void insereFim(int v) {
		insereFimAux(v);
	}

	private NoLista insereFimAux(int v) {
		NoLista novo = new NoLista();
		novo.setInfo(v);
		if (vazia()) {
			novo.setProx(novo);
			this.prim = novo;
			return novo;
		}
		NoLista ultimo = ultimo();
		ultimo.setProx(novo);
		novo.setProx(prim);
		return novo;
	}

	public void imprime() {
		if (vazia()) {
			return;
		}
		NoLista p = prim;
		do {
			System.out.print(p.toString() + " ");
			p = p.getProx();
		} while (p != prim);
		System.out.println();
	}

	public String toString() {
		if (vazia()) {
			return "Lista Vazia";
		}
		NoLista p = prim;
		StringBuilder sb = new StringBuilder().append("[");
		do {
			sb.append(p.toString());
			p = p.getProx();
			if (p != prim) {
				sb.append(", ");
			}
		} while (p != prim);

		return sb.append("]").toString();
	}

	public boolean vazia() {
		return this.prim == null;
	}

	public NoLista busca(int v) {
		if (vazia()) {
			return null;
		}
		
		NoLista p = prim;
		do {
			if (p.getInfo() == v) {
				return p;
			}
			p = p.getProx();
		} while(p != prim);
		
		return null;
	}

	public int comprimento() {
		if (vazia()) {
			return 0;
		}
		NoLista p = prim;
		int counter = 0;
		do {
			++counter;
			p = p.getProx();
		} while (p != prim);
		return counter;
	}

	public NoLista ultimo() {
		if (vazia()) {
			return null;
		}
		NoLista p = prim;
		NoLista ultimo = null;
		do {
			ultimo = p;
			p = p.getProx();
		} while (p != prim);

		return ultimo;
	}

	public void retira(int v) {
		if (vazia()) {
			return;
		}
		
		if (prim.getInfo() == v) {			
			if (comprimento() == 1) {
				libera();
				return;
			}
			ultimo().setProx(prim.getProx());
			this.prim = prim.getProx();
			return;
		}
		
		NoLista anterior = prim;
		NoLista p = prim.getProx();
		do {
			if (p.getInfo() == v) {
				anterior.setProx(p.getProx());
				return;
			}
			anterior = p;
			p = p.getProx();
		} while (p != prim);

	}

	public void libera() {
		this.prim = null;
	}

	public boolean igual(ListaCircular l) {
		NoLista p1 = prim;
		NoLista p2 = l.prim;
		if (p1 == null && p2 == null) {
			return true;
		}
		if ((p1 == null && p2 != null) || (p1 != null && p2 == null)) {
			return false;
		}
		
		do {
			if (p1.getInfo() != p2.getInfo()) {
				return false;
			}
			p1 = p1.getProx();
			p2 = p2.getProx();
		} while (p1 != prim && p2 != prim);
		return p1.getInfo() == p2.getInfo();
	}

}
