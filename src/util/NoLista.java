package util;

public class NoLista {
	
	private int info;
	private NoLista prox;

	public NoLista() {
		this.setInfo(0);
		this.setProx(null);
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public NoLista getProx() {
		return prox;
	}

	public void setProx(NoLista prox) {
		this.prox = prox;
	}
	
	public String toString() {
		return getInfo() + "";
	}

}
