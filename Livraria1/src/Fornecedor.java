import java.io.Serializable;

public class Fornecedor extends Empresa implements Serializable {
    
    Fornecedor(String cnpj, String nome, String telefone, Endereco endereco){
    
        super(cnpj, nome, telefone, endereco);
    }
}
