import java.io.Serializable;

/**
* Representa os dados cadastrais de um fornecedor.
*/
public class Fornecedor extends Empresa implements Serializable {

    Fornecedor(String cnpj, String nome, String telefone, Endereco endereco){
    
        super(cnpj, nome, telefone, endereco);
    }
}
