
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.IOException;

public class ES {
    
    private static class CampoVazioException extends Exception {

        public CampoVazioException() {
        }
    }

    /** salvarEstado
    * Salva o objeto diretamente em um arquivo binário.
    * @param ArrayList<Livraria> l - contém todos os dados do programa
    */
    static void salvarEstado(ArrayList<Livraria> l) throws IOException {
        FileOutputStream fos = new FileOutputStream("dados.livraria");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(l);
        
        oos.close();
        fos.close();
    }
    
    /** carregarEstado
    * Lê o arquivo binário contendo os objetos e carrega na memória.
    * 
    * @return l - representa todos os dados do programa
    */
    static ArrayList<Livraria> carregarEstado() throws IOException, ClassNotFoundException {
        ArrayList<Livraria> l;
        
        FileInputStream fos = new FileInputStream("dados.livraria");
        ObjectInputStream ois = new ObjectInputStream(fos);
        l = (ArrayList<Livraria>) ois.readObject();
        
        ois.close();
        fos.close();
        
        return l;
    }
    
    /** entradaInt
    * Chama o JOptionPane adicionando algumas facilidades, como tratamento de
    * exceções e conversão automática para int.
    * 
    * @param msg - mensagem para o usuário.
    * @return entrada - número inteiro válido digitado pelo usuário.
    */
    static int entradaInt(String msg) {
        int entrada = 0;
        boolean except = true;
        while (except) {
            try {
                except = false;
                String valor = JOptionPane.showInputDialog(msg);
                entrada = Integer.parseInt(valor);
            } catch (NumberFormatException  e) {
                mostrarMensagem("O valor digitado não é um número inteiro");
                except = true;
            }
        }
        return entrada;
    }
    
    /** entradaDouble
    * Chama o JOptionPane adicionando algumas facilidades, como tratamento de
    * exceções e conversão automática para double.
    * 
    * @param msg - mensagem para o usuário.
    * @return entrada - número real válido digitado pelo usuário.
    */
    static double entradaDouble(String msg) {
        double entrada = 0;
        boolean except = true;
        while (except) {
            try {
                except = false;
                String valor = JOptionPane.showInputDialog(msg);
                entrada = Integer.parseInt(valor);
            } catch (NumberFormatException  e) {
                mostrarMensagem("O valor digitado não é um número real");
                except = true;
            }
        }
        return entrada;
    }
    
    /** entradaString
    * Chama o JOptionPane adicionando algumas facilidades, como tratamento de
    * exceções.
    * 
    * @param msg - mensagem para o usuário.
    * @return entrada - String válida digitada pelo usuário.
    */
    static String entradaString(String msg) {
        String entrada = "";
        boolean except = true;
        while (except) {
            except = false;
            try {
                entrada = JOptionPane.showInputDialog(msg);
                if (entrada.equals("")) {
                    throw new CampoVazioException();
                }
            } catch (NullPointerException|CampoVazioException e) {
                except = true;
                mostrarMensagem("O campo não deve ficar vazio");
            }
        }
        return entrada;
    }
    
    /** mostrarMensagem
    * Envelopa a showMessageDialog().
    * 
    * @param msg - texto para exibição
    */
    static void mostrarMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    /** escreverEndereco()
    * Facilita a criação de um objeto Endereco.
    * 
    * @return new Endereco() - objeto Endereco recém-criado.
    */
    static Endereco escreverEndereco() {
        return new Endereco(
                entradaString("Rua: "),
                entradaString("Bairro: "),
                entradaString("Cidade: "),
                entradaString("Estado: ")
        );
    }
}
