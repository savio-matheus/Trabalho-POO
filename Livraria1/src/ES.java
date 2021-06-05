
import javax.swing.JOptionPane;

public class ES {
    
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
                    except = true;
                    mostrarMensagem("O campo não deve ficar vazio");
                }
            } catch (NullPointerException e) {
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
