
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public String toString() {
    	return "CPF: " + this.cpf
    		+ " - Nome: " + this.nome
    		+ " - Telefone: " + this.telefone
                + " - Salario: " + this.salario;
    }
}
