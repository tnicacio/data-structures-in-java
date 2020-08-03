package fila;

public interface Fila {

	void enqueue(int v) throws Exception;
	float dequeue() throws Exception;
	boolean isEmpty();
	void reset();
	
}
