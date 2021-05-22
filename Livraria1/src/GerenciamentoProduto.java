
import javax.swing.JOptionPane;

public class GerenciamentoProduto {
    static Produto buscar(Livraria l) {
        int codigo = entradaInt("Codigo do produto");
        Produto p = l.buscarProduto(codigo);
        
        if (p == null) {
            mostrarMensagem("Produto não encontrado");
            return null;
        }
        
        return p;
    }
    
    static void alterar(Livraria l) {
        int codigo = entradaInt("Codigo do produto a ser alterado");
        Produto p = null;
        int op = -1;

        if (p == null) {
            return;
        }
        p = buscarProduto(l);
        op = entradaInt("O que você deseja alterar?"
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
                l.setCodigo(entradaInt("Codigo"));
                break;
            case 2:
                l.setNome(entradaString("Nome"));
                break;
            case 3:
                l.setPrecoDeCusto(entradaDouble("Preço de Custo"));
                break;
            case 4:
                l.setPrecoDeVenda(entradaDouble("Preço de Venda"));
                break;
            case 5:
                l.setQuantidade(entradaInt("Quantidade"));
                break;
            case 6:
                l.setFornecedor(); // adicionar função para selecionar fornecedor
                break;
            case 7:
                l.setAutor(entradaString("Autor"));
                break;
            case 8:
                l.setEditora(entradaString("Editora"));
            default:
        }
    }
    
    static void excluir(Livraria l) {
        int codigo = entradaInt("Codigo do produto a ser excluído");
        int quantidade = entradaInt("Quantidade a ser excluída");
        if (l.removerProduto(codigo) == 1) {
            mostrarMensagem("Produto não encontrado!");
        } else {
            mostrarMensagem("Produto removido com sucesso");
        }
    }
    
    static void adicionar(Livraria l) {
    Fornecedor f;
    String cnpjFornecedor = "";
        
    if (l.temFornecedor()) {
        mostrarMensagem("Não há fornecedores cadastrados");
        return;
    }

    mostrarMensagem("A seguir será mostrada uma lista de fornecedores");
    mostrarMensagem(l.listarFornecedores());
    cnpjFornecedor = entradaString("Digite o CNPJ de um fornecedor");
    f = l.buscarFornecedor(cnpjFornecedor);

    if (f == null) {
        mostrarMensagem("CNPJ não encontrado");
        return;
    }

    mostrarMensagem("Cadastre a seguir os dados do produto");
        Produto p = new Livro(
                entradaInt("Código"),
                entradaString("Nome"),
                entradaDouble("Preço de Custo"),
                entradaDouble("Preço de Venda"),
                entradaInt("Quantidade"),
                f,
                entradaString("Autor"),
                entradaString("Editora"),
                entradaString("Data da compra")
        );
    }
    
    static void listar(Livraria l) {
        return;
    }
    
    static int entradaInt(String msg) {
        String valor = JOptionPane.showInputDialog(msg);
        return Integer.parseInt(valor);
    }
    
    static double entradaDouble(String msg) {
        String valor = JOptionPane.showInputDialog(msg);
        return Double.parseDouble(valor);
    }
    
    static String entradaString(String msg) {
        return JOptionPane.showInputDialog(msg);
    }
    
    static void mostrarMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
