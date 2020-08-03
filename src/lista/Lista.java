package lista;

/**
*
* @author tnicacio
*/
public class Lista {

   private NoLista prim;

   public Lista() {}
	
   public void insere(int v) {
       NoLista novo = new NoLista();
       novo.setInfo(v);
       novo.setProx(prim);
       this.prim = novo;
   }

   public void imprime() {
       NoLista p = prim;
       while (p != null) {
           System.out.print(p);
           p = p.getProx();
       }
   }

   @Override
   public String toString() {
       StringBuilder info = new StringBuilder();
       NoLista p = prim;
       if (p != null) {
           info.append("[");
       }
       while (p != null) {
           info.append(p.getInfo());
           if (p.getProx() != null) {
               info.append(", ");
           } else {
               info.append("]");
           }
           p = p.getProx();
       }
       return info.toString();
   }

   public boolean vazia() {
       return (prim == null);
   }

   public NoLista busca(int v) {
       NoLista p = prim;
       while (p != null) {
           if (p.getInfo() == v) {
               return p;
           }
           p = p.getProx();
       }
       return null;
   }

   public int comprimento() {
       NoLista p = prim;
       int count = 0;
       while (p != null) {
           count++;
           p = p.getProx();
       }
       return count;
   }

   public NoLista ultimo() {
       NoLista p = prim;
       NoLista ant = null;
       while (p != null) {
           ant = p;
           p = p.getProx();
       }
       return ant;
   }

   public void retira(int v) {

       NoLista[] nos = buscaComAnterior(v);

       if (nos == null) {
           System.out.println("Elemento não pertence à lista");
       } else if (nos[0] == null) {
           this.prim = nos[1].getProx();
       } else {
           nos[0].setProx(nos[1].getProx());
       }
   }

   public void libera() {
       this.prim = null;
   }

   public void insereOrdenado(int v) {
       NoLista ant = null;
       NoLista novo;
       NoLista p = prim;

       while (p != null && (int) p.getInfo() < (int) v) {
           ant = p;
           p = p.getProx();
       }

       novo = new NoLista();
       novo.setInfo(v);

       if (ant == null) {
           novo.setProx(prim);
           prim = novo;
       } else {
           novo.setProx(ant.getProx());
           ant.setProx(novo);
       }
   }

   public boolean igual(Lista l) {
       NoLista p1 = this.prim;
       NoLista p2 = l.prim;

       while (p1 != null && p2 != null) {
           if (p1.getInfo() != p2.getInfo()) {
               return false;
           }
           p1 = p1.getProx();
           p2 = p2.getProx();
       }
       return p1 == p2;
   }

   public void imprimeRecursivo() {
       imprimeRecursivoAux(prim);
   }

   private void imprimeRecursivoAux(NoLista p) {
       if (p != null) {
           System.out.print(p);
           imprimeRecursivoAux(p.getProx());
       }
   }

   public void retiraRecursivo(int v) {
       prim = retiraRecursivoAux(prim, v);
   }

   private NoLista retiraRecursivoAux(NoLista l, int v) {
       if (l != null) {
           if (l.getInfo() == v) {
               l = l.getProx();
           } else {
               l.setProx(retiraRecursivoAux(l.getProx(), v));
           }
       }
       return l;
   }

   public boolean igualRecursivo(Lista l) {
       return igualRecursivoAux(this.prim, l.prim);
   }

   private boolean igualRecursivoAux(NoLista p1, NoLista p2) {

       if (p1 == null && p2 == null) {
           return true;
       }
       if (p1 == null || p2 == null) {
           return false;
       }
       return (p1.getInfo() == p2.getInfo()
               && igualRecursivoAux(p1.getProx(), p2.getProx()));

   }

   public NoLista buscaRecursiva(int v) {
       return buscaRecursivaAux(prim, v);
   }

   public NoLista buscaRecursivaAux(NoLista p, int v) {
       if (p == null) {
           return null;
       }
       if (p.getInfo() == v) {
           return p;
       }
       return buscaRecursivaAux(p.getProx(), v);
   }

   public int comprimentoRecursivo() {
       NoLista p = prim;
       return comprimentoRecAux(p, 0);
   }

   private int comprimentoRecAux(NoLista p, int count) {
       if (p == null) {
           return count;
       }
       count++;
       return comprimentoRecAux(p.getProx(), count);
   }

   public NoLista ultimoRecursivo() {
       return ultimoRecursivoAux(prim, null);
   }

   private NoLista ultimoRecursivoAux(NoLista p, NoLista ant) {
       if (p == null) {
           return ant;
       }
       return ultimoRecursivoAux(p.getProx(), p);
   }

   public NoLista[] buscaComAnterior(int v) {
       NoLista ant = new NoLista();
       NoLista p = prim;
       NoLista[] nos = {ant, p};

       while (p != null) {
           if (p.getInfo() == v) {
               return nos;
           }
           nos[0] = p;
           nos[1] = p.getProx();
           p = nos[1];
       }
       return null;
   }

   public NoLista buscaPorPosicao(int i) {
       if (i >= comprimento()) {
           return null;
       }
       return buscaPorPosicaoAux(i, 0, prim, null);
   }

   public NoLista buscaPorPosicaoAux(int i, int k, NoLista p, NoLista ant) {
       if (k > i) {
           return null;
       }
       if (k == i) {
           return p;
       }
       return buscaPorPosicaoAux(i, ++k, p.getProx(), p);

   }

   public boolean insereEm(int posicao, int v) {
       NoLista novo = new NoLista();
       novo.setInfo(v);
       NoLista ult;
       int tam = comprimento();

       if (tam > 0 && posicao >= tam) {
           ult = ultimoRecursivo();
           for (int i = tam; i < posicao; i++) {
               ult.setProx(new NoLista());
               ult = ult.getProx();
           }
           novo.setProx(null);
           if(ult != null){
           ult.setProx(novo);
           }
           return true;
       }

       if (posicao >= 0 && posicao <= tam) {
           NoLista ant;
           NoLista no;
           if (posicao == 0) {
               novo.setProx(prim);
               prim = novo;
               return true;
           }
           if (posicao > 0) {
               ant = buscaPorPosicao(posicao - 1);
               no = ant.getProx();
               if (no.getInfo() == 0) {
                   no.setInfo(v);
                   return true;
               }
               ant.setProx(novo);
               novo.setProx(no);
               return true;
           }
           return false;
       }
       return false;
   }

   public void insereFim(int valor) {
       NoLista novo = new NoLista();
       novo.setInfo(valor);
       novo.setProx(null);
       NoLista ult = ultimoRecursivo();
       if (ult != null && ult.getProx() == null) {
           ult.setProx(novo);
       }
   }
   
   public int soma(){
       NoLista p = prim;
       int soma = 0;
       while (p != null){
               soma += p.getInfo();
           p = p.getProx();
       }
       return soma;
   }
   
   public NoLista ultimoNoV (int v){
       NoLista p = prim;
       NoLista ultimoValor = null;
       while (p != null){
           if(v ==  p.getInfo()){
               ultimoValor = p;     
           }
           p = p.getProx();
       }
       return ultimoValor;
   }
   
   public void concatenaArray(int v[]){
       int tam = comprimento();
       for(int valor : v){
           insereEm(tam, valor);
           ++tam;
       }
   }

}
