import java.io.Serializable;

public class IUFornecedor implements Serializable {
    
    /** buscar
    * Interface de usuário para buscar fornecedores.
    * 
    * @param l - livraria contendo uma ArrayList de fornecedores
    * @return indice
    */
    static int buscar(Livraria l) {
        while (true) {
            if (l.temFornecedor() == false) {
                ES.mostrarMensagem("Não há fornecedores cadastrados");
                return -2;
            }
            
            String cnpj = ES.entradaString("CNPJ do fornecedor [0 para sair]");
            
            if (cnpj.equals("0")) {
                return -2;
            }
            
            int indice = l.buscarFornecedor(cnpj);
            if (indice <= -1) {
                ES.mostrarMensagem("Fornecedor não encontrado");
                continue;
            }
            return indice;
        }
    }
    
    /** alterar
    * Interface de usuário para editar os dados de um fornecedor (encontrado na busca)
    * 
    * @param l - livraria contendo uma ArrayList de fornecedores
    */
    static void alterar(Livraria l) {
        int i = buscar(l);
        
        if (i <= -1) {
            return;
        }
        
        Fornecedor f = l.getFornecedor(i);
        
        while (true) {
            int op = ES.entradaInt("O que você deseja alterar?\n"
                    + "0. Voltar\n"
                    + "1. CNPJ\n"
                    + "2. Nome\n"
                    + "3. Telefone\n"
                    + "4. Endereço"
            );
            
            switch (op) {
                case 0:
                    l.alterarFornecedor(f.getCnpj() ,f);
                    return;
                case 1:
                    f.setCnpj(ES.entradaString("Novo CNPJ"));
                    break;
                case 2:
                    f.setNome(ES.entradaString("Novo nome"));
                    break;
                case 3:
                    f.setTelefone(ES.entradaString("Novo telefone"));
                    break;
                case 4:
                    f.setEndereco(ES.escreverEndereco());
                    break;
                default:
                    ES.mostrarMensagem("Opção inválida");
            }
        }
    }
    
    /** excluir
    * Interface para excluir um fornecedor.
    * 
    * @param l - livraria contendo uma ArrayList de fornecedores
    */
    static void excluir(Livraria l) {
        while (true) {
            String cnpj = ES.entradaString("CNPJ do fornecedor a ser excluído [0 para sair]");
            if (cnpj.equals("0")) {
                return;
            }else if (l.excluirFornecedor(cnpj) == 0) {
                ES.mostrarMensagem("Fornecedor não encontrado");
            } else {
                ES.mostrarMensagem("Fornecedor removido com sucesso");
                return;
            }
        }
    }
    
    /** adicionar
    * Interface para cadastrar um novo fornecedor.
    * 
    * @param l - livraria contendo uma ArrayList de fornecedores.
    * @return
    */
    static void adicionar(Livraria l) {
        Endereco e = ES.escreverEndereco();
        
        Fornecedor f = new Fornecedor(
                ES.entradaString("CNPJ"),
                ES.entradaString("Nome"),
                ES.entradaString("Telefone"),
                e
        );
        
        l.adicionarFornecedor(f);
    }
    
    /** listar
    * Exibe todos os fornecedores cadastrados.
    * 
    * @param l - livraria contendo uma ArrayList de fornecedores
    */
    static void listar(Livraria l) {
        if (false == l.temFornecedor()) {
            ES.mostrarMensagem("Não há fornecedores cadastrados");
            return;
        }
        
        for (int i = 0; i < l.getQuantidadeFornecedores(); i++) {
            ES.mostrarMensagem(l.getFornecedor(i).toString());
        }
    }
}
