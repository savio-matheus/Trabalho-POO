import java.io.IOException;
import java.util.ArrayList;

/**Trabalho POO - Professora: Ana Cláudia Bastos
 * @author Sávio Matheus de Sousa
 * @author Talles Eduardo de Amaral Salles
 */

public class Main {

    public static void main(String[] args) {
        ArrayList<Livraria> livrarias = new ArrayList();
        
        try {
            livrarias = ES.carregarEstado();
        } catch(IOException|ClassNotFoundException e) {}
        
        ES.mostrarMensagem("Seja bem-vindo(a) ao gerenciador de livrarias");
        while (true) {
            int op = ES.entradaInt(
                "1. Listar livrarias\n" +
                "2. Adicionar livraria\n" +
                "3. Excluir livraria\n" +
                "4. Alterar livraria\n" +
                "5. Acessar livraria\n" +
                "6. Buscar livraria\n" +
                "7. Salvar e sair"
            );

            switch(op) {
                case 1:
                    IULivraria.listar(livrarias);
                    break;
                case 2:
                    IULivraria.adicionar(livrarias);
                    break;
                case 3:
                    IULivraria.remover(livrarias);
                    break;
                case 4:
                    IULivraria.alterar(livrarias);
                    break;
                case 5:
                    IULivraria.acessar(livrarias);
                    break;
                case 6:
                    IULivraria.buscarPorEndereco(livrarias);
                    break;
                case 7:
                    try {
                        ES.salvarEstado(livrarias);
                    } catch (IOException e) {
                        ES.mostrarMensagem("Não foi possível salvar");
                        continue;
                    }
                    return;
                default:
                    ES.mostrarMensagem("Opção inválida");
            }
        }
    }
}
