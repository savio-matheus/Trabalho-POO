import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Livraria> livrarias = new ArrayList();
        
        ES.mostrarMensagem("Seja bem-vindo(a) ao gerenciador de livrarias");
        while (true) {
            switch(telaInicial()) {
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
                    // acionar função de salvamento antes de sair.
                    return;
                default:
                    ES.mostrarMensagem("Opção inválida");
            }
        }
    }
    
    static int telaInicial() {
        int op = ES.entradaInt(
                "1. Listar livrarias\n" +
                "2. Adicionar livraria\n" +
                "3. Excluir livraria\n" +
                "4. Alterar livraria\n" +
                "5. Acessar livraria\n" +
                "6. Salvar e sair"
        );
        
        return op;
    }
}
