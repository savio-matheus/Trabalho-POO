
public class IUProduto {
    static int buscar(Livraria l) {
        int codigo = ES.entradaInt("Codigo do produto [0 para sair]");
        int p = l.buscarProduto(codigo);
        
        if (codigo == 0) {
            return -1;
        }
        
        return p;
    }
    
    static void alterar(Livraria l) {
        int i = -1;
        int op = -1;
        Produto p;

        i = buscar(l);
        if (i == -1) {
            ES.mostrarMensagem("Produto não encontrado");
            return;
        }
        
        p = l.getProduto(i);
        
        op = ES.entradaInt("O que você deseja alterar?"
                + "0. Voltar\n"
                + "1. Código\n"
                + "2. Nome\n"
                + "3. Preço de Custo\n"
                + "4. Preço de Venda\n"
                + "5. Quantidade\n"
                + "6. Fornecedor"
        );

        switch (op) {
            case 0:
                return;
            case 1:
                p.setCodigo(ES.entradaInt("Codigo"));
                break;
            case 2:
                p.setNome(ES.entradaString("Nome"));
                break;
            case 3:
                p.setPrecoDeCusto(ES.entradaDouble("Preço de Custo"));
                break;
            case 4:
                p.setPrecoDeVenda(ES.entradaDouble("Preço de Venda"));
                break;
            case 5:
                p.setQuantidade(ES.entradaInt("Quantidade"));
                break;
            case 6:
                //p.setFornecedor(); adicionar função para selecionar fornecedor
                break;
            default:
        }
        
        return;
    }
    
    static void excluir(Livraria l) {
        while (true) {
            int codigo = ES.entradaInt("Codigo do produto a ser excluído");
            if (l.excluirProduto(codigo) == 0) {
                ES.mostrarMensagem("Produto não encontrado!");
            } else {
                ES.mostrarMensagem("Produto removido com sucesso");
                break;
            }
        }
    }
    
    static void adicionar(Livraria l) {
        int i = -1;
        String cnpjFornecedor = "";

        if (l.temFornecedor()) {
            ES.mostrarMensagem("Não há fornecedores cadastrados");
            return;
        }

        while (true) {
            ES.mostrarMensagem("A seguir será mostrada uma lista de fornecedores");
            listar(l);
            cnpjFornecedor = ES.entradaString("Digite o CNPJ de um fornecedor [0 para sair]");

            if (cnpjFornecedor.equals("0")) {
                return;
            }

            i = l.buscarFornecedor(cnpjFornecedor);

            if (i == -1) {
                ES.mostrarMensagem("CNPJ não encontrado");
                continue;
            }
            
            break;
        }

        ES.mostrarMensagem("Cadastre a seguir os dados do produto");
            Produto p = new Produto(
                    ES.entradaInt("Código"),
                    ES.entradaString("Nome"),
                    ES.entradaDouble("Preço de Custo"),
                    ES.entradaDouble("Preço de Venda"),
                    ES.entradaInt("Quantidade"),
                    l.getFornecedor(i),
                    ES.entradaString("Data da compra")
            );
        
        return;
    }
    
    static void listar(Livraria l) {
        for (int i = 0; i < l.getQuantidadeProdutos(); i++) {
            ES.mostrarMensagem(l.getProduto(i).toString());
        }
    }
}
