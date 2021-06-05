import java.io.Serializable;

import java.util.ArrayList;

/**Classe que possui as listas de produtos e fornecedores e métodos relacionados a Livraria.
 * 
 * @param cnpj String - CNPJ da Livraria.
 * @param nome String - Nome da Livraria.
 * @param telefone String - Telefone da Livraria.
 * @param endereco Endereco - Endereço da Livraria.
 */
public class Livraria extends Empresa implements Serializable {
    
    protected ArrayList <Produto> produtos = new ArrayList();
    protected ArrayList <Fornecedor> fornecedores = new ArrayList();
    
    Livraria(String cnpj, String nome, String telefone, Endereco endereco){
    
        super(cnpj, nome, telefone, endereco);
    }
 
 /** Método que exclui da lista de produtos um determinado produto
  * 
  * @param codigo int.
  * @return int - -1 = Error ; 0 = Produto removido com sucesso.
  */
    public int excluirProduto(int codigo) {
        int indice = buscarProduto(codigo);
        
        if (indice == -1) {
            return 0;
        }
        
        this.produtos.remove(indice);
        return 1;
    }
    
/**Método que busca um determinado produto dentro da lista de produtos cadastrados.
 * 
 * @param codigo int.
 * @return int Indice do produto dentro da lista.
 */
    public int buscarProduto(int codigo) {
        for (int i = 0; i < this.produtos.size(); i++) {
            if (this.produtos.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        
        return -1;
    }
    
/**Método que adiciona um produto na lista de produtos de uma livraria.
 * 
 * @param p Produto.
 */    
    public void adicionarProduto(Produto p) {
        this.produtos.add(p);
    }

/**Método que altera um determinado produto dentro da lista de produtos cadastrados.
 * 
 * @param codigo int.
 * @param novo Produto.
 * @return int - 0 = Error; 1 = Produto alterado com sucesso.
 */    
    public int alterarProduto(int codigo, Produto novo) {
        int indice = this.buscarProduto(codigo);
        
        if (indice == -1)
            return 0;
        
        this.produtos.set(indice, novo);
        return 1;
    }

/**Método que retona um produto da lista de produtos cadastrados.
 * 
 * @param indice int.
 * @return Produto produto.
 */    
    Produto getProduto(int indice) {
        return this.produtos.get(indice);
    }

/**Método que adiciona um fornecedor a lista de fornecedores de uma determinada livraria
 * 
 * @param f Fornecedor.
 */    
    void adicionarFornecedor(Fornecedor f) {
        this.fornecedores.add(f);
    }

/**Método que exclui um fornecedor da lista de fornecedores.
 * 
 * @param cnpj String.
 * @return int - 0 = Error; 1 = Fornecedor excluído com sucesso.
 */    
    int excluirFornecedor(String cnpj) {
        int indice = this.buscarFornecedor(cnpj);
        
        if (indice == -1) {
            return 0;
        }
        
        this.fornecedores.remove(indice);
        return 1;
    }

/** Método que altera os dados de um determinado fornecedor
 * 
 * @param cnpj String
 * @param novo Fornecedor
 */    
    void alterarFornecedor(String cnpj, Fornecedor novo) {
        int indice = this.buscarFornecedor(cnpj);
        
        if (indice == -1)
            return;
        
        this.fornecedores.set(indice, novo);
        return;
    }

/** Método que busca um determinado fornecedor.
 * 
 * @param cnpj String
 * @return int  - Indice do fornecedor na lista de fornecedores.
 */    
    int buscarFornecedor(String cnpj) {
        for (int i = 0; i < this.fornecedores.size(); i++) {
            if (this.fornecedores.get(i).getCnpj().equals(cnpj)) {
                return i;
            }
        }
        
        return -1;
    }

/** Método que retorna um fornecedor
 * 
 * @param indice int.
 * @return fornecedor Fornecedor.
 */    
    Fornecedor getFornecedor(int indice) {
        return this.fornecedores.get(indice);
    }

/** Método que retorna a quantidade de fornecedores cadastrados na lista de fornecedores de uma Livraria.
 * 
 * @return int Quantidade de fornecedores na lista. 
 */    
    public int getQuantidadeFornecedores() {
        return this.fornecedores.size();
    }

/** Método que retorna a quantidade de produtos cadastrados na lista de produtos de uma Livraria.
 * 
 * @return int Quantidade de produtos na lista. 
 */    
    public int getQuantidadeProdutos() {
        return this.produtos.size();
    }

/** Método que verifica se existem produtos cadastrados na lista de produtos de uma Livraria.
 * 
 * @return boolean - True (existe produto cadastrado); False (não existe produto cadastrado). 
 */    
    boolean temProduto() {
        if (this.getQuantidadeProdutos() == 0) {
            return false;
        }
        
        return true;
    }

/** Método que verifica se existem fornecedores cadastrados na lista de fornecedores de uma Livraria.
 * 
 * @return boolean - True (existe fornecedor cadastrado); False (não existe fornecedor cadastrado). 
 */    
    boolean temFornecedor() {
        if (this.getQuantidadeFornecedores() == 0) {
            return false;
        }
        
        return true;
    }
}
