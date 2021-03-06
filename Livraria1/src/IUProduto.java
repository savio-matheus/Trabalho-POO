import java.io.Serializable;

/** Classe que acessa funções para gerenciamento de produtos.
 * 
 */
public class IUProduto {
    
/** Método que busca um determinado produto em uma lista dentro de Livraria.
* Interface de usuário para buscar produtos.
* 
* @param l Livraria.
* @return indice int - indice do produto na lista de produtos.
 */
    static int buscar(Livraria l) {
        while (true) {
            if (l.temProduto() == false) {
                ES.mostrarMensagem("Não há produtos cadastrados");
                return -2;
            }
            
            int codigo = ES.entradaInt("Codigo do produto [0 para sair]");
            
            if (codigo == 0) {
                return -2;
            }
            
            int indice = l.buscarProduto(codigo);
            if (indice == -1) {
                ES.mostrarMensagem("Produto não encontrado");
                continue;
            }
            return indice;
        }
    }
 
/** Método que altera um determinado produto em uma lista dentro de Livraria.
* Interface de usuário para alterar produtos.
* 
* @param l Livraria.
 */
    static void alterar(Livraria l) {
        int i;
        int op;
        Produto p;
        
        i = buscar(l);
        
        if (i <= -1)
            return;
        
        p = l.getProduto(i);
        
        op = ES.entradaInt("O que você deseja alterar?\n"
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
                alterarFornecedor(p, l);
                break;
            default:
        }
    }
    
/** Método que altera um determinado fornecedor em uma lista dentro de Livraria.
* Interface de usuário para alterar fornecedores.
* 
* @param p Produto.
* @param l Livraria.
 */
    static void alterarFornecedor(Produto p, Livraria l) {
        while (true) {
            IUFornecedor.listar(l);
            String cnpj = ES.entradaString("Digite o CNPJ do novo fornecedor para o produto [0 para sair]");

            if (cnpj.equals("0")) {
                return;
            }
            
            int indice = l.buscarFornecedor(cnpj);
            
            if (indice == -1) {
                ES.mostrarMensagem("CNPJ não encontrado");
                continue;
            }
            
            p.setFornecedor(l.getFornecedor(indice));
        }
    }

/** Método que exclui um determinado produto da lista de produtos de uma livraria.
 * 
 * @param l Livraria.
 */    
    static void excluir(Livraria l) {
        while (true) {
            int codigo = ES.entradaInt("Codigo do produto a ser excluído [0 para sair]");
            
            if (codigo == 0) {
                return;
            } else if (l.excluirProduto(codigo) == 0) {
                ES.mostrarMensagem("Produto não encontrado!");
            } else {
                ES.mostrarMensagem("Produto removido com sucesso");
                break;
            }
        }
    }
 
/** Método que cadastra um produto na lista de produtos de uma determinada livraria.
 * 
 * @param l Livraria.
 */
    static void adicionar(Livraria l) {
        int i = -1;
        String cnpjFornecedor;

        if (l.temFornecedor() == false) {
            ES.mostrarMensagem("Não há fornecedores cadastrados");
            return;
        }

        while (true) {
            ES.mostrarMensagem("A seguir será mostrada uma lista de fornecedores");
            IUFornecedor.listar(l);
            i = IUFornecedor.buscar(l);
            
            if (i == -2) {
                return;
            } else if (i == -1) {
                continue;
            }
            break;
        }

        ES.mostrarMensagem("Cadastre a seguir os dados do produto");
            Produto p = new Produto(
                    ES.entradaString("Nome"),
                    ES.entradaDouble("Preço de Custo"),
                    ES.entradaDouble("Preço de Venda"),
                    ES.entradaInt("Quantidade"),
                    l.getFornecedor(i),
                    ES.entradaString("Data da compra")
            );
            
            l.adicionarProduto(p);
    }
 
/** Método que lista todos os produtos existentes em uma determinada Livraria.
 * 
 * @param l Livraria.
 */
    static void listar(Livraria l) {
        if (false == l.temProduto()) {
            ES.mostrarMensagem("Não há produtos cadastrados");
            return;
        }
        
        for (int i = 0; i < l.getQuantidadeProdutos(); i++) {
            ES.mostrarMensagem(l.getProduto(i).toString());
        }
    }
}
