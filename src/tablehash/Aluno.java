package tablehash;

public class Aluno {

	private String nome;
	private int matricula;
	private float mediaGeral;
	private Aluno prox;

	public Aluno(String nome, int matricula, float mediaGeral) {
		setNome(nome);
		setMatricula(matricula);
		setMediaGeral(mediaGeral);
	}

	public String toString() {
		String virgula = ", ";
		return new StringBuilder()
				.append("[")
				.append("nome: ").append(getNome()).append(virgula)
				.append("matricula: ").append(getMatricula()).append(virgula)
				.append("mediaGeral: ").append(getMediaGeral())
				.append("]")
				.toString();
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMatricula() {
		return this.matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public float getMediaGeral() {
		return this.mediaGeral;
	}
	
	public void setMediaGeral(float mediaGeral) {
		this.mediaGeral = mediaGeral;
	}
	
	public Aluno getProx() {
		return this.prox;
	}
	
	public void setProx(Aluno prox) {
		this.prox = prox;
	}

}
