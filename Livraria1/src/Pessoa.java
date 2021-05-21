
public abstract class Pessoa {
    protected String cpf;
    protected String nome;
    protected String telefone;
    
    Pessoa(String cpf, String nome, String telefone){
    
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public String toString() {
    	return "CPF: " + this.cpf
    		+ " - Nome: " + this.nome
    		+ " - Telefone: " + this.telefone;
    }
}
