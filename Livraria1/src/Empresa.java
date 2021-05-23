
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public String toString() {
    	
        return "CNPJ: " + this.cnpj 
                + "\nNome: " + this.nome
                + "\n Telefone: " + this.telefone
                + "\n Endereço: " + this.endereco.toString();
    }
}
