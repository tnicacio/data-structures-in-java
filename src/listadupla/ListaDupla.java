package listadupla;

/**
 *
 * @author tnica
 */
public class ListaDupla {
    
    private NoListaDupla prim;
    
    public ListaDupla(){
        this.prim = null;
    }
    
    public void insere(int v){
        NoListaDupla novo = new NoListaDupla();
        novo.setInfo(v);
        novo.setAnt(null);
        novo.setProx(prim);
        if (prim != null){
            prim.setAnt(novo);
        }
        prim = novo;
    }
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Lista Dupla: [");
        NoListaDupla p = prim;
        while(p != null){
            s.append(p.toString());
            p = p.getProx();
            if (p != null)
                s.append(", ");
        }
        s.append("]");
        return s.toString();
    }
    
    public boolean vazia(){
        return prim == null;
    }
    
    public NoListaDupla busca(int v){
        NoListaDupla p = prim;
        while(p != null){
            if (p.getInfo() == v){
                return p;
            }
            p = p.getProx();
        }
        return null;
    }
    
    public void retira(int v){
        NoListaDupla p = busca(v);
        if (p == null){
            return;
        }
        if (prim == p){
            prim = p.getProx();
        } else {
            p.getAnt().setProx(p.getProx());
        }
        if (p.getProx() != null){
            p.getProx().setAnt(p.getAnt());
        }
    }
    
    public void libera(){
        NoListaDupla p = prim;
        while(p != null){
            retira(p.getInfo());
            p = p.getProx();
        }
    }
    
    public boolean igual(ListaDupla l){
        NoListaDupla p1 = prim;
        NoListaDupla p2 = l.prim;
        while (p1 != null && p2 != null){
            if (p1.getInfo() != p2.getInfo()){
                return false;
            }
            p1 = p1.getProx();
            p2 = p2.getProx();
        }
        return p1 == p2;
    }
    
    public ListaDupla merge(ListaDupla l2){
        NoListaDupla p1 = prim;
        NoListaDupla p2 = l2.prim;
        ListaDupla l3 = new ListaDupla();
        
        while(p1 != null || p2 != null){
            if (p1 != null){
                l3.insereFim(p1.getInfo());
                p1 = p1.getProx();
            }
            if (p2 != null){
                l3.insereFim(p2.getInfo());
                p2 = p2.getProx();
            }
        }
        return l3;
    }
    
    public void insereFim(int v){
        NoListaDupla ultimo = ultimoNo();
        NoListaDupla novo = new NoListaDupla();
        novo.setInfo(v);
        if (ultimo != null){
            ultimo.setProx(novo);
        }else {
            prim = novo;
        }
        novo.setAnt(ultimo);
        novo.setProx(null);
    }
    
    public NoListaDupla ultimoNo(){
        NoListaDupla p = prim;
        NoListaDupla ultimo = null;
        while (p != null){
            ultimo = p;
            p = p.getProx();
        }
        return ultimo;
    }
    
    public ListaDupla copia(){
        ListaDupla copia = new ListaDupla();
        NoListaDupla p2 = prim;
        while(p2 != null){
            copia.insereFim(p2.getInfo());
            p2 = p2.getProx();
        }
        return copia;
    }
    
}
