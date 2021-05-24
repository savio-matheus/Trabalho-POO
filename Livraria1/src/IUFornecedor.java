
public class IUFornecedor {
    
    static int buscar(Livraria l) {
        String cnpj = ES.entradaString("CNPJ do fornecedor a ser buscado [0 para sair]");
        
        if (cnpj.equals("0")) {
            return -1;
        }
        
        return l.buscarFornecedor(cnpj);
    }
    
    static void alterar(Livraria l) {
        int i;
        
        while (true) {
            String cnpj = ES.entradaString("CNPJ do fornecedor a ser alterado [0 para voltar]");
            
            if (cnpj.equals("0")) {
                return;
            }
            
            i = buscar(l);
            
            if (i == -1) {
                ES.mostrarMensagem("Não há fornecedores cadastrados");
                continue;
            }
            break;
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
