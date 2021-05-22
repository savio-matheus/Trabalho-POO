import java.util.ArrayList;

public class Livraria extends Empresa {
    
    protected ArrayList <Produto> produtos = new ArrayList();
    protected ArrayList <Funcionario> funcionarios = new ArrayList<Funcionario>();
    
    Livraria(String cnpj, String nome, String telefone, Endereco endereco){
    
        super(cnpj, nome, telefone, endereco);
    }
    
    void vender() {
        return;
    }
    
    void comprarDoFornecedor() {
        return;
    }
    
    void contratarFuncionario() {
        return;
    }
    
    void demitirFuncionario() {
        return;
    }
    
    void listarProdutos() {
        return;
    }
    
    void listarFuncionarios() {
        return;
    }
    
    String getEndereco() {
        return endereco.toString();
    }
}
