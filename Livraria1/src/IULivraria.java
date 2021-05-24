
import java.util.ArrayList;

public class IULivraria {
    
    static void acessar(ArrayList<Livraria> lista) {
        String cnpj;
        int i;
        Livraria livraria;
        
        while (true) {
            cnpj = ES.entradaString("Informe o CNPJ da livraria a ser acessada [0 para cancelar]");
            if (cnpj.equals("0")) {
                return;
            }
            i = buscar(lista, cnpj);
            if (i == -1) {
                ES.mostrarMensagem("Livraria não encontrada");
                continue;
            }
            break;
        }
        livraria = lista.get(i);
        
        while (true) {
            int op = ES.entradaInt(
                    "O que você deseja fazer?\n"
                    + "1. Gerenciar produtos\n"
                    + "2. Gerenciar fornecedores\n"
                    + "3. Voltar"
            );

            switch(op) {
                case 1:
                    gerenciarProdutos(livraria);
                    break;
                case 2:
                    gerenciarFornecedores(livraria);
                    break;
                case 3:
                    return;
                default:
                    ES.mostrarMensagem("Opção inválida");
            }
        }
    }
    
    static void listar(ArrayList<Livraria> lista) {
        for (int i = 0; i < lista.size(); i++) {
            ES.mostrarMensagem(lista.get(i).toString());
        }
        return;
    }
    
    static void adicionar(ArrayList<Livraria> lista) {
        ES.mostrarMensagem("Informe a seguir o endereço da livraria");
        Endereco e = ES.escreverEndereco();
        ES.mostrarMensagem("Informe a seguir os dados da livraria");
        Livraria l = new Livraria(
                ES.entradaString("CNPJ"),
                ES.entradaString("Nome"),
                ES.entradaString("Telefone"),
                e
        );
        lista.add(l);
        
        return;
    }
    
    static void remover(ArrayList<Livraria> lista) {
        String cnpj;
        int i;
        
        while (true) {
            cnpj = ES.entradaString("Informe o CNPJ da livraria a ser excluída [0 para cancelar]");
            if (cnpj.equals("0")) {
                return;
            }
            i = buscar(lista, cnpj);
            if (i == -1) {
                ES.mostrarMensagem("Livraria não encontrada");
                continue;
            }
            break;
        }
        
        lista.remove(i);
        ES.mostrarMensagem("Livraria excluída com sucesso");
    }
    
    static int buscar(ArrayList<Livraria> lista, String cnpj) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCnpj().equals(cnpj)) {
                return i;
            }
        }
        
        return -1;
    }
    
    static void alterar(ArrayList<Livraria> lista) {
        String cnpj;
        int i;
        Livraria livraria = null;
        int op;
        
        while (true) {
            cnpj = ES.entradaString("Informe o CNPJ da livraria a ser alterada [0 para cancelar]");
            if (cnpj.equals("0")) {
                return;
            }
            i = buscar(lista, cnpj);
            if (i == -1) {
                ES.mostrarMensagem("Livraria não encontrada");
                continue;
            }
            break;
        }
        livraria = lista.get(i);
        
        while (true) {
            op = ES.entradaInt("O que você deseja alterar?\n"
                + "1. CNPJ\n"
                + "2. Nome\n"
                + "3. Telefone\n"
                + "4. Endereço\n"
                + "5. Voltar"
            );
            
            switch(op) {
                case 1:
                    livraria.setCnpj(ES.entradaString("Novo CNPJ"));
                    break;
                case 2:
                    livraria.setNome(ES.entradaString("Novo nome"));
                    break;
                case 3:
                    livraria.setTelefone(ES.entradaString("Novo telefone"));
                    break;
                case 4:
                    ES.mostrarMensagem("Novo endereço");
                    livraria.setEndereco(ES.escreverEndereco());
                    break;
                case 5:
                    lista.set(i, livraria);
                    return;
                default:
                    ES.mostrarMensagem("Opção inválida");
            }
        }
    }
    
    private static void gerenciarProdutos(Livraria l) {
        int op = ES.entradaInt(
                "O que você deseja fazer?\n"
                + "1. Listar\n"
                + "2. Adicionar\n"
                + "3. Excluir\n"
                + "4. Alterar\n"
                + "5. Buscar\n"
                + "6. Voltar"
        );
        
        switch(op) {
            case 1:
                IUProduto.listar(l);
                break;
            case 2:
                IUProduto.adicionar(l);
                break;
                
            case 3:
                IUProduto.excluir(l);
                break;
            
            case 4:
                IUProduto.alterar(l);
                break;
            
            case 5:
                ES.mostrarMensagem(l.getProduto(IUProduto.buscar(l)).toString());
                
            case 6:
                return;
                
            default:
                ES.mostrarMensagem("Opção inválida");
        }
    }
    
    private static void gerenciarFornecedores(Livraria l) {
        while (true) {
            IUFornecedor fornecedor = new IUFornecedor();
            int op = -1;

            op = ES.entradaInt(
                    "O que você quer fazer?\n"
                    + "0. Voltar"
                    + "1. Listar\n"
                    + "2. Adicionar\n"
                    + "3. Excluir\n"
                    + "4. Alterar\n"
                    + "5. Buscar"
            );

            switch (op) {
                case 0:
                    return;
                case 1:
                    fornecedor.listar(l);
                    break;
                case 2:
                    fornecedor.adicionar(l);
                    break;
                case 3:
                    fornecedor.excluir(l);
                    break;
                case 4:
                    fornecedor.alterar(l);
                    break;
                case 5:
                    fornecedor.buscar(l);
                    break;
                default:
                    ES.mostrarMensagem("Opção inválida");
            }

            return;
        }
    }
}
