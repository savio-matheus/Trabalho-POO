import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        ArrayList<Livraria> livrarias = new ArrayList();
        
        switch(telaInicial()) {
            case 1:
                listarLivrarias(livrarias);
                break;
            case 2:
                adicionarLivraria(livrarias);
                break;
            case 3:
                removerLivraria(livrarias);
            case 4:
                alterarLivraria(livrarias);
            case 5:
                acessarLivraria(livrarias);
            default:
        }
    }
    
    static int telaInicial() {
        mostrarMensagem("Seja bem-vindo ao gerenciador de livrarias");
        return entradaInt(
                "1. Listar livrarias\n" +
                "2. Adicionar livraria\n" +
                "3. Excluir livraria\n" +
                "4. Alterar livraria\n" +
                "5. Acessar livraria"
        );
    }
    
    static void acessarLivraria(ArrayList<Livraria> lista) {
        String cnpj = entradaString("Informe o CNPJ da livraria a ser acessada");
        int i = buscarLivraria(lista, cnpj);
        Livraria livraria = null;
        String cnpjFornecedor = "";
        
        if (i == -1) {
            return;
        }
        livraria = lista.get(i);
        
        int op = entradaInt(
                "O que você deseja fazer?\n"
                + "1. Gerenciar produtos\n"
                + "2. Gerenciar funcionários\n"
                + "3. Gerenciar fornecedores"
        );
        
        switch(op) {
            case 1:
                gerenciarProdutos(livraria);
            case 2:
                
            case 3:
                gerenciarFornecedores(livraria);
            default:
        }
    }
    
    static void gerenciarProdutos(Livraria l) {
        int op = entradaInt(
                "O que você deseja fazer?\n"
                + "1. Listar\n"
                + "2. Adicionar\n"
                + "3. Excluir\n"
                + "4. Alterar\n"
                + "5. Buscar"
        );
        
        switch(op) {
            case 1:
                mostrarMensagem(l.listarProdutos());
                break;
            case 2:
                adicionarProduto(l);
                break;
                
            case 3:
                excluirProduto(l);
                break;
            
            case 4:
                alterarProduto(l);
                break;
            
            case 5:
                mostrarMensagem(buscarProduto(l).toString());
        }
    }
    
    static void gerenciarFornecedores(Livraria l) {
        int op = -1;
        
        op = entradaInt(
                "O que você quer fazer?\n"
                + "1. Listar\n"
                + "2. Adicionar\n"
                + "3. Excluir\n"
                + "4. Alterar\n"
                + "5. Buscar"
        );
        
        switch (op) {
            case 1:
                listarFornecedores(l);
            case 2:
                adicionarFornecedor(l);
            case 3:
                excluirFornecedor(l);
            case 4:
                alterarFornecedor(l);
            case 5:
                buscarFornecedor(l);
            default:
        }
    }
    
    static void gerenciarFuncionarios(Livraria l) {
        int op = -1;
        
        op = entradaInt(
                "O que você quer fazer?\n"
                + "1. Listar\n"
                + "2. Adicionar\n"
                + "3. Excluir\n"
                + "4. Alterar\n"
                + "5. Buscar"
        );
        
        switch (op) {
            case 1:
                listarFuncionarios(l);
            case 2:
                adicionarFuncionario(l);
            case 3:
                excluirFuncionario(l);
            case 4:
                alterarFuncionario(l);
            case 5:
                buscarFuncionario(l);
            default:
        }
    }
    
    static Produto buscarProduto(Livraria l) {
        int codigo = entradaInt("Codigo do produto");
        Produto p = l.buscarProduto(codigo);
        
        if (p == null) {
            mostrarMensagem("Produto não encontrado");
            return null;
        }
        
        return p;
    }
    
    static void alterarProduto(Livraria l) {
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
    
    static void excluirProduto(Livraria l) {
        int codigo = entradaInt("Codigo do produto a ser excluído");
        int quantidade = entradaInt("Quantidade a ser excluída");
        if (l.removerProduto(codigo) == 1) {
            mostrarMensagem("Produto não encontrado!");
        } else {
            mostrarMensagem("Produto removido com sucesso");
        }
    }
    
    static void adicionarProduto(Livraria l) {
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
    
    static void listarLivrarias(ArrayList<Livraria> lista) {
        for (Livraria liv : lista) {
            mostrarMensagem(liv.toString());
        }
    }
    
    static void adicionarLivraria(ArrayList<Livraria> lista) {
        mostrarMensagem("Informe a seguir o endereço da livraria");
        Endereco e = escreverEndereco();
        mostrarMensagem("Informe a seguir os dados da livraria");
        Livraria l = new Livraria(
                entradaString("CNPJ"),
                entradaString("Nome"),
                entradaString("Telefone"),
                e
        );
        lista.add(l);
    }
    
    static void removerLivraria(ArrayList<Livraria> lista) {
        String cnpj = entradaString("Informe o CNPJ da livraria a ser excluída");
        int i = buscarLivraria(lista, cnpj);
        if (i != -1)
            lista.remove(i);
        mostrarMensagem("Livraria apagada com sucesso");
    }
    
    static int buscarLivraria(ArrayList<Livraria> lista, String cnpj) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCnpj().equals(cnpj)) {
                return i;
            }
        }
        
        mostrarMensagem("CNPJ não encontrado");
        return -1;
    }
    
    static void alterarLivraria(ArrayList<Livraria> lista) {
        String cnpj = entradaString("Informe o CNPJ da livraria a ser alterada");
        int i = buscarLivraria(lista, cnpj);
        String msg = "O que você deseja alterar\n"
                + "1. CNPJ\n"
                + "2. Nome\n"
                + "3. Telefone\n"
                + "4. Endereço";
        
        Livraria liv = null;
        
        if (i != -1)
            liv = lista.get(i);
        
        switch(entradaInt(msg)) {
            case 1:
                liv.setCnpj(entradaString("Novo CNPJ"));
                break;
            case 2:
                liv.setNome(entradaString("Novo nome"));
                break;
            case 3:
                liv.setTelefone(entradaString("Novo telefone"));
                break;
            case 4:
                mostrarMensagem("Novo endereço");
                liv.setEndereco(escreverEndereco());
                break;
            default:
        }
    }
    
    static Endereco escreverEndereco() {
        return new Endereco(
                entradaString("Rua: "),
                entradaString("Bairro: "),
                entradaString("Cidade: "),
                entradaString("Estado: ")
        );
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
