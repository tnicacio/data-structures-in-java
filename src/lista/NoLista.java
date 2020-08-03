package lista;

public class NoLista {
	
	private int info;
	private NoLista prox;
	
	public void setInfo(int info) {
		this.info = info;
	}
	public int getInfo() {
		return this.info;
	}
	
	public void setProx(NoLista prox) {
		this.prox = prox;
	}
	public NoLista getProx() {
		return this.prox;
	}
	
	public String toString() {
		return new StringBuilder().append(info).toString();
	}

}
