package pilha;

import util.NoLista;

public class PilhaLista implements Pilha{
	
	private NoLista topo;
	
	public PilhaLista() {
		this.topo = null;
	}
	
	public String toString() {
		NoLista p = topo;
		if (p == null) {
			return "Lista Vazia!";
		}
		StringBuilder sb = new StringBuilder().append("Pilha: ");
		while (p != null) {
			sb.append(p.getInfo()).append(" ");
			p = p.getProx();
		}
		return sb.toString();
	}

	@Override
	public void push(int v) throws Exception {
		NoLista novo = new NoLista();
		novo.setInfo(v);
		novo.setProx(topo);
		topo = novo;
	}

	@Override
	public int pop() throws Exception {
		if (vazia()) {
			throw new Exception("ERRO: Pilha Vazia!");
		} else {
			int temp = topo.getInfo();
			topo = topo.getProx();
			return temp;
		}
	}

	@Override
	public int top() throws Exception {
		return this.topo.getInfo();
	}

	@Override
	public boolean vazia() {
		return topo == null;
	}

	@Override
	public void reset() {
		this.topo = null;	
	}
}
