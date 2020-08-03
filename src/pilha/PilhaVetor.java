package pilha;


public class PilhaVetor implements Pilha{
	
	private int tam;
	private int n;
	private int [] vet;
	
	public PilhaVetor(int tamanho) {
		this.vet = new int[tamanho];
		this.tam = tamanho;
		this.n = 0;
	}

	@Override
	public String toString() {
		
		if (vazia()) {
			return "Pilha vazia!";
		}
		
		StringBuilder sb = new StringBuilder().append("Pilha: ");
		for (int i = 0; i < this.n; i++) {
			sb.append(this.vet[this.n - 1 - i]).append(" ");
		}
		return sb.toString();
	}

	@Override
	public void push(int v) throws Exception {
		if (n == tam) {
			throw new Exception("ERRO: a capacidade da pilha estourou!");
		} else {
		this.vet[n] = v;
		this.n++;
		}
	}

	@Override
	public int pop() throws Exception {
		int v;
		if (this.vazia()) {
			throw new Exception("ERRO: Pilha vazia!");
		} else {
			v = this.vet[n-1];
			this.n--;
		}
		return v;
	}

	@Override
	public int top() throws Exception {
		if (vazia()) {
			throw new Exception("ERRO: Pilha vazia!");
		}
		return this.vet[n-1];
	}

	@Override
	public boolean vazia() {
		return this.n == 0;
	}

	@Override
	public void reset() {
		this.n = 0;
	}

}
