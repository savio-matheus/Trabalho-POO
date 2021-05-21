public class Produto {
    protected String nome;
    protected int quantidade;
    protected double precoDeVenda;
    protected int codigo;

    Produto(String nome, int quantidade, double precoDeVenda, int codigo) {
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
}
