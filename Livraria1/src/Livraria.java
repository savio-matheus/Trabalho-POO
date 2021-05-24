import java.util.ArrayList;

public class Livraria extends Empresa {
    
    protected ArrayList <Produto> produtos = new ArrayList();
    protected ArrayList <Fornecedor> fornecedores = new ArrayList();
    
    Livraria(String cnpj, String nome, String telefone, Endereco endereco){
    
        super(cnpj, nome, telefone, endereco);
    }
    
    public int excluirProduto(int codigo) {
        int indice = buscarProduto(codigo);
        
        if (indice == -1) {
            return 0;
        }
        
        this.produtos.remove(indice);
        return 1;
    }
    
    public int buscarProduto(int codigo) {
        for (int i = 0; i < this.produtos.size(); i++) {
            if (this.produtos.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        
        return -1;
    }
    
    public void adicionarProduto(Produto p) {
        this.produtos.add(p);
    }
    
    public int alterarProduto(int codigo, Produto novo) {
        int indice = this.buscarProduto(codigo);
        
        if (indice == -1)
            return 0;
        
        this.produtos.set(indice, novo);
        return 1;
    }
    
    Produto getProduto(int indice) {
        return this.produtos.get(indice);
    }
    
    void adicionarFornecedor(Fornecedor f) {
        this.fornecedores.add(f);
    }
    
    int excluirFornecedor(String cnpj) {
        int indice = this.buscarFornecedor(cnpj);
        
        if (indice == -1) {
            return 0;
        }
        
        this.fornecedores.remove(indice);
        return 1;
    }
    
    void alterarFornecedor(String cnpj, Fornecedor novo) {
        int indice = this.buscarFornecedor(cnpj);
        
        if (indice == -1)
            return;
        
        this.fornecedores.set(indice, novo);
        return;
    }
    
    int buscarFornecedor(String cnpj) {
        for (int i = 0; i < this.fornecedores.size(); i++) {
            if (this.fornecedores.get(i).getCnpj().equals(cnpj)) {
                return i;
            }
        }
        
        return -1;
    }
    
    Fornecedor getFornecedor(int indice) {
        return this.fornecedores.get(indice);
    }
    
    public int getQuantidadeFornecedores() {
        return this.fornecedores.size();
    }
    
    public int getQuantidadeProdutos() {
        return this.produtos.size();
    }
    
    boolean temProduto() {
        if (this.getQuantidadeProdutos() == 0) {
            return false;
        }
        
        return true;
    }
    
    boolean temFornecedor() {
        if (this.getQuantidadeFornecedores() == 0) {
            return false;
        }
        
        return true;
    }
}
