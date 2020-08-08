package arvore;

public class NoArvore {
	
	private int info;
	private NoArvore prim;
	private NoArvore prox;
	
	public NoArvore(int info) {
		this.info = info;
		this.prim = null;
		this.prox = null;
	}
	
	public NoArvore(int info, NoArvore sa) { 
		this.info = info;
		prox = sa.prim;
		prim = sa;
	}
	
	public void setInfo(int info) {
		this.info = info;
	}
	
	public int getInfo() {
		return this.info;
	}
	
	public void setPrim(NoArvore prim) {
		this.prim = prim;
	}
	
	public NoArvore getPrim() {
		return this.prim;
	}
	
	public void setProx(NoArvore prox) {
		this.prox = prox;
	}
	
	public NoArvore getProx() {
		return this.prox;
	}
	
	public String toString() {
		return new StringBuilder().append(info).toString();
	}

}
