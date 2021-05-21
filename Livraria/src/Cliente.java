import java.util.ArrayList;

public class Cliente extends Pessoa{
    protected ArrayList <Produto> sacola = new ArrayList();
    
    Cliente(String cpf, String nome, String telefone){
    
        super(cpf, nome, telefone);
    }
    
    boolean comprar(Produto p, int quantidade);

    public String toString() {
        String tmp = super.toString() + "\n";

        for (Produto i : sacola) {
            tmp += i.toString();
        }
    }
}
