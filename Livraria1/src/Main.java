import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Livraria> livrarias = new ArrayList();
        
        switch(telaInicial()) {
            case 1:
                IULivraria.listar(livrarias);
                break;
            case 2:
                IULivraria.adicionar(livrarias);
                break;
            case 3:
                IULivraria.remover(livrarias);
            case 4:
                IULivraria.alterar(livrarias);
            case 5:
                IULivraria.acessar(livrarias);
            default:
        }
    }
    
    static int telaInicial() {
        ES.mostrarMensagem("Seja bem-vindo ao gerenciador de livrarias");
        return ES.entradaInt(
                "1. Listar livrarias\n" +
                "2. Adicionar livraria\n" +
                "3. Excluir livraria\n" +
                "4. Alterar livraria\n" +
                "5. Acessar livraria"
        );
    }
}
