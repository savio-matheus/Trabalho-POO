import java.util.ArrayList;

public class Livraria extends Empresa {
    
    protected ArrayList <Produto> produtos = new ArrayList();
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
    
    void adicionarProduto() {
        return;
    }
    
    String listarProdutos() {
        return "";
    }
    
    int alterarProduto() {
        return 0;
    }
    
    void adicionarFornecedor() {
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
}
