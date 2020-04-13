package lista;

/**
 *
 * @author tnicacio
 */
public class NoLista {
    
    private Object info;
    private NoLista prox;
    
    public void setInfo(Object info){
        this.info = info;
    }
    
    public Object getInfo() {
        return info;
    }
    
    public void setProx(NoLista prox){
        this.prox = prox;
    }
    
    public NoLista getProx(){
        return prox;
    }
    
    public String toString(){
        return getInfo() + " ";
    }
    
}
