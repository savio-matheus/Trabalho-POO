
import java.util.ArrayList;

public class IULivraria {
    
    static int acessar(ArrayList<Livraria> lista) {
        String cnpj = ES.entradaString("Informe o CNPJ da livraria a ser acessada");
        int i = buscar(lista, cnpj);
        Livraria livraria = null;
        String cnpjFornecedor = "";
        
        if (i == -1) {
            ES.mostrarMensagem("Livraria não encontrada");
            return 1;
        }
        livraria = lista.get(i);
        
        int op = ES.entradaInt(
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
        
        return 0;
    }
    
    static int listar(ArrayList<Livraria> lista) {
        for (Livraria liv : lista) {
            ES.mostrarMensagem(liv.toString());
        }
        return 0;
    }
    
    static int adicionar(ArrayList<Livraria> lista) {
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
        
        return 0;
    }
    
    static int remover(ArrayList<Livraria> lista) {
        String cnpj = ES.entradaString("Informe o CNPJ da livraria a ser excluída");
        int i = buscar(lista, cnpj);
        if (i != -1)
            lista.remove(i);
        ES.mostrarMensagem("Livraria apagada com sucesso");
        
        return 0;
    }
    
    static int buscar(ArrayList<Livraria> lista, String cnpj) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCnpj().equals(cnpj)) {
                return i;
            }
        }
        
        ES.mostrarMensagem("CNPJ não encontrado");
        return -1;
    }
    
    static int alterar(ArrayList<Livraria> lista) {
        String cnpj = ES.entradaString("Informe o CNPJ da livraria a ser alterada");
        int i = buscar(lista, cnpj);
        String msg = "O que você deseja alterar\n"
                + "1. CNPJ\n"
                + "2. Nome\n"
                + "3. Telefone\n"
                + "4. Endereço";
        
        Livraria liv = null;
        
        if (i != -1)
            liv = lista.get(i);
        
        switch(ES.entradaInt(msg)) {
            case 1:
                liv.setCnpj(ES.entradaString("Novo CNPJ"));
                break;
            case 2:
                liv.setNome(ES.entradaString("Novo nome"));
                break;
            case 3:
                liv.setTelefone(ES.entradaString("Novo telefone"));
                break;
            case 4:
                ES.mostrarMensagem("Novo endereço");
                liv.setEndereco(ES.escreverEndereco());
                break;
            default:
        }
    }
    
    private static int gerenciarProdutos(Livraria l) {
        IUProduto produto = new IUProduto();
        int op = ES.entradaInt(
                "O que você deseja fazer?\n"
                + "1. Listar\n"
                + "2. Adicionar\n"
                + "3. Excluir\n"
                + "4. Alterar\n"
                + "5. Buscar"
        );
        
        switch(op) {
            case 1:
                ES.mostrarMensagem(l.listarProdutos());
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
                ES.mostrarMensagem(produto.buscar(l).toString());
        }
        
        return 0;
    }
    
    private static int gerenciarFornecedores(Livraria l) {
        IUFornecedor fornecedor = new IUFornecedor();
        int op = -1;
        
        op = ES.entradaInt(
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
        
        return 0;
    }
    
    private static int gerenciarFuncionarios(Livraria l) {
        IUFuncionario funcionario = new IUFuncionario();
        int op = -1;
        
        op = ES.entradaInt(
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
        
        return 0;
    }
}
