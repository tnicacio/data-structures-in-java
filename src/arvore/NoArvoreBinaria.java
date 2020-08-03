package arvore;

public class NoArvoreBinaria {
	
	private int info;
	private NoArvoreBinaria sae;
	private NoArvoreBinaria sad;
	
	public NoArvoreBinaria(int info) {
		this.info = info;
		this.sae = null;
		this.sad = null;
	}
	
	public NoArvoreBinaria(int info, NoArvoreBinaria esq, NoArvoreBinaria dir) {
		this.info = info;
		this.sae = esq;
		this.sad = dir;
	}
	
	public void setInfo(int info) {
		this.info = info;
	}
	public int getInfo() {
		return this.info;
	}
	
	public void setSae(NoArvoreBinaria esq) {
		this.sae = esq;
	}
	public NoArvoreBinaria getSae() {
		return this.sae;
	}
	
	public void setSad(NoArvoreBinaria dir) {
		this.sad = dir;
	}
	public NoArvoreBinaria getSad() {
		return this.sad;
	}
	
	public String toString() {
		return new StringBuilder().append(this.info).toString();
	}
	
}
