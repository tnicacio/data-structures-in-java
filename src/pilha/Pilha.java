package pilha;

public interface Pilha {
	
	void push(int v) throws Exception;
	int pop() throws Exception;
	int top() throws Exception;
	boolean vazia();
	void reset();

}
