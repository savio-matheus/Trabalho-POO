import java.io.Serializable;

public abstract class Empresa implements Serializable {
    private String cnpj;
    private String nome;
    private String telefone;
    private Endereco endereco;
    
    /** Construtor de Empresa
    * @param cnpj
    * @param nome
    * @param telefone
    * @param endereco
    */
    Empresa(String cnpj, String nome, String telefone, Endereco endereco){
    
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    /**
    * @return string do objeto
    */
    @Override
    public String toString() {
    	
        return "CNPJ: " + this.getCnpj() 
                + "\nNome: " + this.getNome()
                + "\nTelefone: " + this.getTelefone()
                + "\nEndereço: " + this.getEndereco().toString();
    }

    /**
     * @return cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
