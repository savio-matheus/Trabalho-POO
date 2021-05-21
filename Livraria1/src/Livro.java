import java.util.Date;

public class Livro extends Produto{
    
    protected String isbn;
    protected String autor;
    protected String categoria;
    protected String editora;
    
    Livro(int codigo, String nome, double precoDeCusto, double precoDeVenda, int quantidade, Fornecedor fornecedor, Date dataUltimaCompra, String isbn, String autor, String categoria, String editora){
    
        super(codigo, nome, quantidade, precoDeVenda);
        this.isbn = isbn;
        this.autor = autor;
        this.categoria = categoria;
        this.editora = editora;
    }
    
    
}
