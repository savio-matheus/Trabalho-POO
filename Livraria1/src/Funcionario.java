
public class Funcionario {
    protected String cpf;
    protected String nome;
    protected String telefone;
    protected double salario;
    
    Funcionario(String cpf, String nome, String telefone, double salario){
    
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.salario = salario;
    }
    
    public String toString() {
    	return "CPF: " + this.cpf
    		+ " - Nome: " + this.nome
    		+ " - Telefone: " + this.telefone
                + " - Salario: " + this.salario;
    }
}
