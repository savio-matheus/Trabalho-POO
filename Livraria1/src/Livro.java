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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    String dadosLivro() {
        return "";
    }
    
    public String toString() {
        return super.toString() 
               +"\nAutor: " + this.autor
               + "\nEditora: " + this.editora;
    }
}
