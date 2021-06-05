/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author savio
 */
public class TesteGeral {
    @Test
    public void testeEndereco() {
        Endereco endereco = new Endereco(
                "endereço tal",
                "bairro tal",
                "cidade tal",
                "estado tal"
        );
        
        assertEquals("Logradouro: endereço tal\nBairro: bairro tal\nCidade: cidade tal\nEstado: estado tal",
                endereco.toString());
    }
    
    @Test
    public void testeEmpresa() {
        Endereco endereco = new Endereco(
                "endereço tal",
                "bairro tal",
                "cidade tal",
                "estado tal"
        );
        
        Fornecedor fornecedor = new Fornecedor(
                "76.760.784/0001-18",
                "Raimundo e Fabiana Telas ME",
                "(11) 2843-5881",
                endereco
        );
        
        assertEquals(
                "CNPJ: 76.760.784/0001-18\nNome: Raimundo e Fabiana Telas ME" +
                "\nTelefone: (11) 2843-5881\nEndereço: " + endereco.toString(),
                fornecedor.toString()
        );
    }
}
