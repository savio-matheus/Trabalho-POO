import java.util.ArrayList;

public class Cliente extends Pessoa{
    protected ArrayList <Produto> sacola = new ArrayList();
    
    Cliente(String cpf, String nome, String telefone){
    
        super(cpf, nome, telefone);
    }
    
    void addProduto(Produto p, int quantidade){
    
        if(p.temEstoque(l)){
           sacola.add(p);
        
        }
    }
    
    boolean comprar(Produto p, int quantidade){
    
        if(p)
    
    }

    public String toString() {
        String tmp = super.toString() + "\n";

        for (Produto i : sacola) {
            tmp += i.toString();
            
        }
        
        return tmp;
    }
}
