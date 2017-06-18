/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import br.com.SistemaOrdemServico.DAO.ClienteDAO;
import br.com.SistemaOrdemServico.Entidades.Cliente;
import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author IAGO
 */
public class ClienteTeste {

    public ClienteTeste() {
    }

    @Test
    @Ignore
    public void salvar() throws SQLException {
        //endereco, email, cpf, nome, telefone
        //Update
        Cliente c1 = new Cliente(1,"Endereço1", "email1", "106.582.859-47", "Update", "33283645");
        //Seta no banco
        Cliente c2 = new Cliente("Endereço12","email2","106.582.859-47","Sem update","9999999");
        ClienteDAO clienteDao = new ClienteDAO();
        clienteDao.salvar(c2);
    }
    
    /*@Test
    @Ignore
    public void deletar() throws SQLException{
        Cliente c = new Cliente();
        ClienteDAO clienteDao = new ClienteDAO();
        c = clienteDao.pesquisar("nome","te6");
        System.out.println(c);
        String teste = clienteDao.deletar(c);
        System.out.println(teste);
    }**/
    
    @Test
    public void pesquisar(){

        ClienteDAO clienteDao = new ClienteDAO();
        int i =0;
        for(Cliente c : clienteDao.pesquisar("nome", "Teste")){
            System.out.println("ID:"+c.getIdCliente());
            System.out.println("Nome"+c.getNome());
            i++;
            System.out.println(i);
            
        }
    }
    @Test
    @Ignore
    public void lista() throws SQLException{
        ClienteDAO clienteDao = new ClienteDAO();
        //Cliente c = new Cliente();
        //c = clienteDao.pesquisar(campo,nome);
        int i =0;
        for(Cliente c : clienteDao.lista()){
            System.out.println(c.getNome());
            i++;
            System.out.println(i);
            
        }
    }

}
