import java.util.Date;

public class Livro extends Produto{

    protected String autor;
    protected String editora;
    
    Livro(int codigo, String nome, double precoDeCusto, double precoDeVenda,
            int quantidade, Fornecedor fornecedor, String autor, String editora, String dataUltimaCompra){
        
        super(codigo, nome, precoDeCusto, precoDeVenda, quantidade, fornecedor, dataUltimaCompra);
        this.autor = autor;
        this.editora = editora;
    }
    
    String dadosLivro() {
        return "";
    }
    
    public String toString() {
        return "";
    }
}
