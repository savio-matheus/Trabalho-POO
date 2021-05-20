import java.util.ArrayList;

public class Livraria extends Empresa{
    
    protected String endereco;
    protected ArrayList <Produto> produtos = new ArrayList();
    
    Livraria(String cnpj, String nome, String telefone, String endereco){
    
        super(cnpj, nome, telefone);
        this.endereco = endereco;
    }
    
}
