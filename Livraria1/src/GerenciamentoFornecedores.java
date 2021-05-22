import javax.swing.JOptionPane;

public class GerenciamentoFornecedores {
    private Livraria l;
    
    static Fornecedor buscar() {
        return null;
    }
    
    static void alterar() {
        return;
    }
    
    static void excluir() {
        return;
    }
    
    static void adicionar() {
        return;
    }
    
    static void listar() {
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
    
    static Endereco escreverEndereco() {
        return new Endereco(
                entradaString("Rua: "),
                entradaString("Bairro: "),
                entradaString("Cidade: "),
                entradaString("Estado: ")
        );
    }
}
