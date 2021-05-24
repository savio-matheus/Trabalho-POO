
public class Produto {
    protected String nome;
    protected int quantidade;
    protected double precoDeVenda;
    protected int codigo;
    protected double precoDeCusto;
    protected Fornecedor fornecedor;
    protected String dataUltimaCompra;

    Produto(int codigo, String nome, double precoDeCusto, double precoDeVenda,
            int quantidade, Fornecedor fornecedor, String dataUltimaCompra) {
    	this.nome = nome;
    	this.quantidade = quantidade;
    	this.precoDeVenda = precoDeVenda;
    	this.codigo = codigo;
        this.precoDeCusto = precoDeCusto;
        this.fornecedor = fornecedor;
        this.dataUltimaCompra = dataUltimaCompra;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            return;
        }
        
        this.quantidade = quantidade;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecoDeCusto() {
        return precoDeCusto;
    }

    public void setPrecoDeCusto(double precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDataUltimaCompra() {
        return dataUltimaCompra;
    }

    public void setDataUltimaCompra(String dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }
    
    boolean temEstoque() {
    	int disponivel = this.getQuantidade();
    	
        return (disponivel >= this.quantidade);
    }

    public String toString() {
        return "Código: " + this.codigo
            + "\nNome: " + this.nome
            + "\nPreço de custo: " + this.precoDeCusto
            + "\nPreço de venda: " + this.precoDeVenda
            + "\nQuantidade: " + this.quantidade
            + "\nFornecedor: " + this.fornecedor.toString()
            + "\nÚltima compra: " +  this.dataUltimaCompra;
    }
}
