package tablehash;

public class TestHashTable {
	
	public static void main(String [] args) {
	
	TabelaHash th = new TabelaHash(13);
	
	th.set("Pedro", 2222, 8.5f);
	th.set("Tiago", 1234, 9.9f);
	th.set("João", 5678, 7.8f);
	th.set("Maria", 6546, 9.5f);
	th.set("Creuza", 1002, 8.7f);
	th.set("Line", 2938, 10);
	
	System.out.println(th);
	
	Aluno found = th.get(6546);
	System.out.println(found);

	Aluno notFound = th.get(22221);
	System.out.println(notFound);
	
	th.remove(6546);
	System.out.println(th);
	
	System.out.println(th.get(6546));
	
	}
}
