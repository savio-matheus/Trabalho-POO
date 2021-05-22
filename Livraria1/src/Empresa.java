
public abstract class Empresa {
    protected String cnpj;
    protected String nome;
    protected String telefone;
    protected Endereco endereco;
    
    Empresa(String cnpj, String nome, String telefone, Endereco endereco){
    
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String toString() {
    	
        return "CNPJ: " + this.cnpj 
                + "\nNome: " + this.nome
                + "\n Telefone: " + this.telefone
                + "\n Endereço: " + this.endereco.toString();
    }
}
