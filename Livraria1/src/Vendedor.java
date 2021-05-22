
public class Vendedor extends Funcionario{
    private double porcentagemComissao;
    private double vendas;
    
    Vendedor(String cpf, String nome, String telefone, double salario,
            double porcentagemComissao, double vendas){
    
        super(cpf, nome, telefone, salario);
        this.porcentagemComissao = porcentagemComissao;
        this.vendas = vendas;
        
    }
    
    double ganhoTotal() {
        return 0;
    }
    
    public String toString() {
        return "";
    }
}
