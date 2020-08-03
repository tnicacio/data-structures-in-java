package fila;

public class filaMain {

	public static void main(String[] args) {

		
		FilaLista fv = new FilaLista();
		try {
			fv.enqueue(1);
			fv.enqueue(2);
			fv.enqueue(3);
			fv.enqueue(4);
			fv.enqueue(5);
			fv.enqueue(6);
			fv.enqueue(7);
			fv.enqueue(8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(fv);
		
		try {
			fv.dequeue();
			fv.dequeue();
			fv.dequeue();
			fv.dequeue();
			fv.dequeue();
			fv.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fv);

		try {
			fv.enqueue(9);
			fv.enqueue(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(fv);
	}

}
