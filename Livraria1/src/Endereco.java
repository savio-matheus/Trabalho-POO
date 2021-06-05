import java.io.Serializable;

/**
* Representação de um endereço.
*/
public class Endereco implements Serializable {
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    
    /** Construtor de Endereco
    * @param endereco
    * @param bairro
    * @param cidade
    * @param estado
    */
    public Endereco(String endereco, String bairro, String cidade, String estado) {
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    /**
    * @return string do objeto
    */
    @Override
    public String toString() {
        return "Logradouro: " + this.getEndereco()
                + "\nBairro: " + this.getBairro()
                + "\nCidade: " + this.getCidade()
                + "\nEstado: " + this.getEstado();
    }

    /**
     * @return endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
