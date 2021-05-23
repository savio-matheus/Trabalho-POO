public class Gerente extends Funcionario {
    private double bonificacao;
    
    Gerente(String cpf, String nome, String telefone, double salario, double bonificacao) {
        
        super(cpf, nome, telefone, salario);
        this.bonificacao = bonificacao;
    }
    
    double ganhoTotal() {
        return 0;
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }
}
