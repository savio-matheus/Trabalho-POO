import java.io.Serializable;

/** Classe que contém atributos e métodos relacionados a um produto de determinada livraria.
*/

public class Produto implements Serializable {
    protected static int codigoGerado = 0;
    
    protected String nome;
    protected int quantidade;
    protected double precoDeVenda;
    protected int codigo;
    protected double precoDeCusto;
    protected Fornecedor fornecedor;
    protected String dataUltimaCompra;

    Produto(String nome, double precoDeCusto, double precoDeVenda,
            int quantidade, Fornecedor fornecedor, String dataUltimaCompra) {
    	this.nome = nome;
    	this.quantidade = quantidade;
    	this.precoDeVenda = precoDeVenda;
    	this.codigo = this.incrementaCodigo();
        this.precoDeCusto = precoDeCusto;
        this.fornecedor = fornecedor;
        this.dataUltimaCompra = dataUltimaCompra;
    }
    
/** Método que retorna o nome do produto.
*
* @return String - Nome do produto.
*/
    public String getNome() {
        return nome;
    }

/** Método que atribui um nome ao produto
 * 
 * @param nome String - Nome que irá ser dado ao produto.
 */
    public void setNome(String nome) {
        this.nome = nome;
    }

/** Método que retorna a quantidade em estoque do produto.
*
* @return int - Quantidade do produto.
*/
    public int getQuantidade() {
        return quantidade;
    }

/** Método que atribui uma quantidade em estoque do produto
 * 
 * @param quantidade int - Quantidade em estoque do produto.
 */
    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            return;
        }
        
        this.quantidade = quantidade;
    }

/** Método que retorna o preço de venda do produto.
*
* @return Double - Preço de venda do produto.
*/
    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

/** Método que atribui um preço de venda ao produto
 * 
 * @param precoDeVenda double - Preço de venda do produto.
 */
    public void setPrecoDeVenda(double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

/** Método que retorna o código do produto.
*
* @return int - Código do produto.
*/
    public int getCodigo() {
        return codigo;
    }

/** Método que atribui um código ao produto
 * 
 * @param codigo int - Código a ser atribuído ao produto.
 */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

/** Método que retorna o preço de custo do produto.
*
* @return Double - Preço de custo do produto.
*/
    public double getPrecoDeCusto() {
        return precoDeCusto;
    }

/** Método que atribui um preço de custo do produto
 * 
 * @param precoDeCusto Double - Preço de custo do produto.
 */
    public void setPrecoDeCusto(double precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

/** Método que retorna o fornecedor do produto.
*
* @return Fornecedor - Fornecedor do produto.
*/
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

/** Método que atribui um fornecedor ao produto
 * 
 * @param fornecedor Fornecedor - Fornecedor do produto.
 */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

 /** Método que retorna data em que o produto foi comprado pela última vez.
*
* @return String - Nome do produto.
*/
    public String getDataUltimaCompra() {
        return dataUltimaCompra;
    }

/** Método que atribui a data da última compra do produto.
 * 
 * @param dataUltimaCompra String - Data da última compra para o estoque do produto.
 */
    public void setDataUltimaCompra(String dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }

/** Método que verifica se existe produto em estoque
 * 
 * @return boolean - True (existe produto em estoque, False(não existe produto em estoque).
 */    
    boolean temEstoque() {
    	int disponivel = this.getQuantidade();
    	
        return (disponivel >= this.quantidade);
    }
 
/** Método que incrementa o código do produto automaticamente.
 */
    private int incrementaCodigo() {
        Produto.codigoGerado++;
        return Produto.codigoGerado;
    }
    
/**
 * Método estático auxiliar para atualizar o valor de codigoGerado.
 * A desserialização não armazena os valores atuais das variáveis estáticas,
 * de modo que, ao serializar os objetos, o valor de codigoGerado volta para
 * o que foi definido na inicialização: codigoGerado = 0. Isso faz com que os
 * produtos repitam códigos entre uma sessão e outra do programa.
 * @param cod 
 */
    static void setUltimoCodigoGerado(int cod) {
        Produto.codigoGerado = cod;
    }

 /** Método que atribui mostra todos os atributos de determinado produto.
 * 
 * @return String - Atributos do produto.
 */
    public String toString() {
        return "Código: " + this.codigo
            + "\nNome: " + this.nome
            + "\nPreço de custo: " + this.precoDeCusto
            + "\nPreço de venda: " + this.precoDeVenda
            + "\nQuantidade: " + this.quantidade
            + "\nFornecedor: " + this.fornecedor.getNome()
                + ", CNPJ: " + this.fornecedor.getCnpj()
            + "\nÚltima compra: " +  this.dataUltimaCompra;
    }
}
