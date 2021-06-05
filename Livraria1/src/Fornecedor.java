import java.io.Serializable;

/**
* Representa os dados cadastrais de um fornecedor.
*/
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
