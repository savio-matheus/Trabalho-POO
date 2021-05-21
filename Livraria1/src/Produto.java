public class Produto {
    protected String nome;
    protected int quantidade;
    protected double precoDeVenda;
    protected int codigo;

    Produto(int codigo, String nome, int quantidade, double precoDeVenda) {
    	this.nome = nome;
    	this.quantidade = quantidade;
    	this.precoDeVenda = precoDeVenda;
    	this.codigo = codigo;
    }

    int getQuantidade() {
    	return this.quantidade;
    }

    boolean temEstoque(Lote l) {
    	int disponivel = l.getQuantidade();
    	if (disponivel >= this.quantidade) {
    		return true;
    	}

    	return false;
    }
    
    public String toString(){
    
        return "Código: " + this.codigo
                +"\nNome: " + this.nome
                +"\nQuantidade: " + this.quantidade
                +"\nPreço de venda: " + this.precoDeVenda;
           
    }
}
