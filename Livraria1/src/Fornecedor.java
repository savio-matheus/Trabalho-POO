import java.io.Serializable;

public class Fornecedor extends Empresa implements Serializable {
    
    /** Construtor de Fornecedor
    * @param cnpj
    * @param nome
    * @param telefone
    * @param endereco
    */
    Fornecedor(String cnpj, String nome, String telefone, Endereco endereco){
    
        super(cnpj, nome, telefone, endereco);
    }
}
