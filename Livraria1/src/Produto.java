import java.util.Date;

public abstract class Produto {
    protected String nome;
    protected int quantidade;
    protected double precoDeVenda;
    protected int codigo;
    protected double precoDeCusto;
    protected Fornecedor fornecedor;
    protected Date dataUltimaCompra;

    Produto(int codigo, String nome, double precoDeCusto, double precoDeVenda,
            int quantidade, Fornecedor fornecedor, Date dataUltimaCompra) {
    	this.nome = nome;
    	this.quantidade = quantidade;
    	this.precoDeVenda = precoDeVenda;
    	this.codigo = codigo;
        this.precoDeCusto = precoDeCusto;
        this.fornecedor = fornecedor;
        this.dataUltimaCompra = dataUltimaCompra;
    }

    int getQuantidade() {
    	return this.quantidade;
    }
/*
    boolean temEstoque() {
    	int disponivel = l.getQuantidade();
    	if (disponivel >= this.quantidade) {
    		return true;
    	}

    	return false;
    }
*/
    public String toString() {
        return "Código: " + this.codigo
            + "\nNome: " + this.nome
            + "\nPreço de custo: " + this.precoDeCusto
            + "\nPreço de venda: " + this.precoDeVenda
            + "\nQuantidade: " + this.quantidade
            + "\nFornecedor: " + this.fornecedor.toString()
            + "\nÚltima compra: " +  this.dataUltimaCompra.toString();
    }
}
