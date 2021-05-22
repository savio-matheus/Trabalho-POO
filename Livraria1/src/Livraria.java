import java.util.ArrayList;

public class Livraria extends Empresa {
    
    protected ArrayList <Produto> produtos = new ArrayList();
    protected ArrayList <Funcionario> funcionarios = new ArrayList();
    protected ArrayList <Fornecedor> fornecedores = new ArrayList();
    
    Livraria(String cnpj, String nome, String telefone, Endereco endereco){
    
        super(cnpj, nome, telefone, endereco);
    }
    
    int removerProduto(int codigo) {
        return 0;
    }
    
    Produto buscarProduto(int codigo) {
        return null;
    }
    
    void cadastrarProduto() {
        return;
    }
    
    String listarProdutos() {
        return "";
    }
    
    void contratarFuncionario() {
        return;
    }
    
    void demitirFuncionario() {
        return;
    }
    
    void listarFuncionarios() {
        return;
    }
    
    void alterarFuncionarios() {
        return;
    }
    
    void cadastrarFornecedor() {
        return;
    }
    
    void excluirFornecedor() {
        return;
    }
    
    void alterarFornecedor() {
        return;
    }
    
    String listarFornecedores() {
        return "";
    }
    
    Fornecedor buscarFornecedor(String cnpj) {
        return null;
    }
    
    boolean temProduto() {
        return false;
    }
    
    boolean temFuncionario() {
        return false;
    }
    
    boolean temFornecedor() {
        return false;
    }
    
    Funcionario buscarFuncionarios() {
        return null;
    }
    
    String getEndereco() {
        return endereco.toString();
    }
}
