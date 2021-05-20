import java.util.ArrayList;

public class Cliente extends Pessoa{
    protected ArrayList <Produto> sacola = new ArrayList();
    
    Cliente(String cpf, String nome, String telefone){
    
        super(cpf, nome, telefone);
    }
    
}
