package fila;

import util.NoLista;

public class FilaLista implements Fila {
	
	private NoLista ini;
	private NoLista fim;
	
	public FilaLista() {
		this.ini = null;
		this.fim = null;
	}

	@Override
	public void enqueue(int v) throws Exception {
		NoLista novo = new NoLista();
		novo.setInfo(v);
		novo.setProx(null);
		if (fim != null) {
			fim.setProx(novo);
		} else {
			ini = novo;
		}
		fim = novo;
	}

	@Override
	public float dequeue() throws Exception {
		int v;
		if (isEmpty()) {
			throw new Exception("ERRO: fila vazia!");
		} else {
			v = ini.getInfo();
			ini = ini.getProx();
			if (ini == null) {
				fim = null;
			}
			return v;
		}
	}

	@Override
	public boolean isEmpty() {
		return ini == null;
	}

	@Override
	public void reset() {
		this.ini = null;
		this.fim = null;
	}
	
	public String toString() {
		return isEmpty()? "Fila Vazia!" : toStringPrivate();
	}
	
	private String toStringPrivate() {
		StringBuilder sb = new StringBuilder().append("Fila Lista: ");
		NoLista p = ini;
		while (p != null) {
			sb.append(p.getInfo()).append(" ");
			p = p.getProx();
		}
		return sb.toString();
	}
	
}
