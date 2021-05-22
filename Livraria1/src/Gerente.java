public class Gerente extends Funcionario {
    private double bonificacao;
    
    Gerente(String cpf, String nome, String telefone, double salario, double bonificacao) {
        
        super(cpf, nome, telefone, salario);
        this.bonificacao = bonificacao;
    }
    
    double ganhoTotal() {
        return 0;
    }

    /**
     * @return the bonificacao
     */
    public double getBonificacao() {
        return bonificacao;
    }

    /**
     * @param bonificacao the bonificacao to set
     */
    public void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }
}
