import java.util.Date;

public abstract class Produto {
    protected int codigo;
    protected String nome;
    protected double precoDeCusto;
    protected double precoDeVenda;
    protected int quantidade;
    protected Fornecedor fornecedor;
    protected Date dataUltimaCompra; 
    
    Produto(int codigo, String nome, double precoDeCusto, double precoDeVenda, int quantidade, Fornecedor fornecedor, Date dataUltimaCompra){
    
        this.codigo = codigo;
        this.nome = nome;
        this.precoDeCusto = precoDeCusto;
        this.precoDeVenda = precoDeVenda;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.dataUltimaCompra = dataUltimaCompra;
    }
    
    
}
