
public class Vendedor extends Pessoa{
    protected double salario;
    
    Vendedor(String cpf, String nome, String telefone, double salario){
    
        super(cpf, nome, telefone);
        this.salario = salario;
        
    }
}
