import java.util.Date;

public class Lote extends Produto {
    protected double precoDeCusto;
    protected Fornecedor fornecedor;
    protected Date dataUltimaCompra;
    
    Lote(int codigo, String nome, double precoDeCusto, double precoDeVenda, int quantidade, Fornecedor fornecedor, Date dataUltimaCompra){
    
        this.codigo = codigo;
        this.nome = nome;
        this.precoDeCusto = precoDeCusto;
        this.precoDeVenda = precoDeVenda;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.dataUltimaCompra = dataUltimaCompra;
    }
    
    public String toString() {
        return "Código: " + this.codigo
            + "\nNome: " + this.nome
            + "\nPreço de custo: " + this.precoDeCusto
            + "\nPreço de venda: " + this.precoDeVenda
            + "\nQuantidade: " + this.quantidade
            + "\nFornecedor: " + this.fornecedor.toString()
            + "\nÚltima compra: " this.dataUltimaCompra.toString();
    }
}
