package fila;

public class FilaVetor implements Fila{

	private int n;
	private int ini;
	private int tam;
	private int [] vet;
	
	public FilaVetor(int tam) {
		this.vet = new int[tam];
		this.tam = tam;
		this.ini = 0;
		this.ini = 0;
	}
	
	public String toString() {
		if (n == 0) {
			return "Fila Vazia!";
		}
		StringBuilder sb = new StringBuilder().append("FilaVetor: ");
		for (int i = ini; i < ini + n; i++) {
			sb.append(vet[i%tam]).append(" ");
		}
		return sb.toString();
	}
	
	@Override
	public void enqueue(int v) throws Exception {
		int fim;
		if (n == tam) {
			throw new Exception("ERRO: a capacidade da fila estourou!");
		} else {
			fim = (ini + n)%tam;
			this.vet[fim] = v;
			this.n++;
		}
	}

	@Override
	public float dequeue() throws Exception {
		int v;
		if (n == 0) {
			throw new Exception("ERRO: fila vazia!");
		} else {
			v = this.vet[ini];
			ini = (ini + 1)%tam;
			this.n--;
		}
		return v;
	}

	@Override
	public boolean isEmpty() {
		return this.n == 0;
	}

	@Override
	public void reset() {
		this.n = 0;
		this.ini = 0;
	}

}
