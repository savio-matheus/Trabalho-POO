
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
    
    static void salvarEstado(ArrayList<Livraria> l) throws IOException {
        FileOutputStream fos = new FileOutputStream("dados.livraria");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(l);
        
        oos.close();
        fos.close();
    }
    
    static ArrayList<Livraria> carregarEstado() throws IOException, ClassNotFoundException {
        ArrayList<Livraria> l;
        
        FileInputStream fos = new FileInputStream("dados.livraria");
        ObjectInputStream ois = new ObjectInputStream(fos);
        l = (ArrayList<Livraria>) ois.readObject();
        
        ois.close();
        fos.close();
        
        return l;
    }
    
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
