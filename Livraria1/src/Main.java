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
    
    static void gerenciarProdutos(Livraria l) {
        GerenciamentoProduto produto = new GerenciamentoProduto();
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
                produto.adicionar(l);
                break;
                
            case 3:
                produto.excluir(l);
                break;
            
            case 4:
                produto.alterar(l);
                break;
            
            case 5:
                mostrarMensagem(produto.buscar(l).toString());
        }
    }
    
    static void gerenciarFornecedores(Livraria l) {
        GerenciamentoFornecedores fornecedor = new GerenciamentoFornecedores();
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
                fornecedor.listar(l);
            case 2:
                fornecedor.adicionar(l);
            case 3:
                fornecedor.excluir(l);
            case 4:
                fornecedor.alterar(l);
            case 5:
                fornecedor.buscar(l);
            default:
        }
    }
    
    static void gerenciarFuncionarios(Livraria l) {
        GerenciamentoFuncionario funcionario = new GerenciamentoFuncionario();
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
                funcionario.listar(l);
            case 2:
                funcionario.adicionar(l);
            case 3:
                funcionario.excluir(l);
            case 4:
                funcionario.alterar(l);
            case 5:
                funcionario.buscar(l);
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
