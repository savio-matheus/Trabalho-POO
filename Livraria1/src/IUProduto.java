
import javax.swing.JOptionPane;

public class IUProduto {
    static Produto buscar(Livraria l) {
        int codigo = ES.entradaInt("Codigo do produto");
        Produto p = l.buscarProduto(codigo);
        
        if (p == null) {
            return null;
        }
        
        return p;
    }
    
    static int alterar(Livraria l) {
        int codigo = ES.entradaInt("Codigo do produto a ser alterado");
        Produto p = null;
        int op = -1;

        if (p == null) {
            ES.mostrarMensagem("Produto não encontrado");
            return 0;
        }
        p = buscar(l);
        op = ES.entradaInt("O que você deseja alterar?"
                + "1. Código\n"
                + "2. Nome\n"
                + "3. Preço de Custo\n"
                + "4. Preço de Venda\n"
                + "5. Quantidade\n"
                + "6. Fornecedor\n"
                + "7. Autor\n"
                + "8. Editora"
        );

        switch (op) {
            case 1:
                l.setCodigo(ES.entradaInt("Codigo"));
                break;
            case 2:
                l.setNome(ES.entradaString("Nome"));
                break;
            case 3:
                l.setPrecoDeCusto(ES.entradaDouble("Preço de Custo"));
                break;
            case 4:
                l.setPrecoDeVenda(ES.entradaDouble("Preço de Venda"));
                break;
            case 5:
                l.setQuantidade(ES.entradaInt("Quantidade"));
                break;
            case 6:
                l.setFornecedor(); // adicionar função para selecionar fornecedor
                break;
            case 7:
                l.setAutor(ES.entradaString("Autor"));
                break;
            case 8:
                l.setEditora(ES.entradaString("Editora"));
            default:
        }
    }
    
    static int excluir(Livraria l) {
        int codigo = ES.entradaInt("Codigo do produto a ser excluído");
        int quantidade = ES.entradaInt("Quantidade a ser excluída");
        if (l.removerProduto(codigo) == 1) {
            ES.mostrarMensagem("Produto não encontrado!");
        } else {
            ES.mostrarMensagem("Produto removido com sucesso");
        }
        
        return 0;
    }
    
    static int adicionar(Livraria l) {
    Fornecedor f;
    String cnpjFornecedor = "";
        
    if (l.temFornecedor()) {
        ES.mostrarMensagem("Não há fornecedores cadastrados");
        return 0;
    }

    ES.mostrarMensagem("A seguir será mostrada uma lista de fornecedores");
    ES.mostrarMensagem(l.listarFornecedores());
    cnpjFornecedor = ES.entradaString("Digite o CNPJ de um fornecedor");
    f = l.buscarFornecedor(cnpjFornecedor);

    if (f == null) {
        ES.mostrarMensagem("CNPJ não encontrado");
        return 0;
    }

    ES.mostrarMensagem("Cadastre a seguir os dados do produto");
        Produto p = new Livro(
                ES.entradaInt("Código"),
                ES.entradaString("Nome"),
                ES.entradaDouble("Preço de Custo"),
                ES.entradaDouble("Preço de Venda"),
                ES.entradaInt("Quantidade"),
                f,
                ES.entradaString("Autor"),
                ES.entradaString("Editora"),
                ES.entradaString("Data da compra")
        );
        
        return 0;
    }
    
    static int listar(Livraria l) {
        return 0;
    }
}
