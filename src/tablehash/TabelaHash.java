package tablehash;

public class TabelaHash {

	private Aluno[] tabela;

	public TabelaHash(int N) {
		this.tabela = new Aluno[N];
	}

	private int hash(int k) {
		return k % tabela.length;
	}

	public Aluno get(int k) {
		Aluno p = tabela[hash(k)];

		while (p != null) {
			if (p.getMatricula() == k) {
				break;
			}
			p = p.getProx();
		}
		return p;
	}

	public void set(String nome, int matricula, float mediaGeral) {
		int h = hash(matricula);
		Aluno p = tabela[h];

		while (p != null) {
			if (p.getMatricula() == matricula) {
				break;
			}
			p = p.getProx();
		}

		if (p == null) {
			p = new Aluno(nome, matricula, mediaGeral);
			p.setProx(tabela[h]);
			tabela[h] = p;
		} else {
			p.setNome(nome);
			p.setMediaGeral(mediaGeral);
		}
	}

	public void remove(int k) {
		int h = hash(k);
		Aluno p = tabela[h];
		Aluno anterior = null;

		while (p != null) {
			if (p.getMatricula() == k) {
				break;
			}
			anterior = p;
			p = p.getProx();
		}

		if (p == null) {
			return;
		}

		if (anterior != null) {
			anterior.setProx(p.getProx());
		} else {
			tabela[h] = p.getProx();
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int h = 0; h < tabela.length; h++) {
			Aluno p = tabela[h];
			while (p != null) {
				sb.append(p).append(", ");
				p = p.getProx();
			}
		}
		return sb.toString();
	}

}
