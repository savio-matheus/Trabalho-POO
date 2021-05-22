
import javax.swing.JOptionPane;

public class GerenciamentoFuncionario {
    
    static Funcionario buscar(Livraria l) {
        return null;
    }
    
    static void alterar(Livraria l) {
        return;
    }
    
    static void excluir(Livraria l) {
        return;
    }
    
    static void adicionar(Livraria l) {
        return;
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
