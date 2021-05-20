
public abstract class Empresa {
    protected String cnpj;
    protected String nome;
    protected String telefone;
    
    Empresa(String cnpj, String nome, String telefone){
    
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
    }
}
