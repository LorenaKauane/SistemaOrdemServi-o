/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import br.com.SistemaOrdemServico.DAO.ServicoDAO;
import br.com.SistemaOrdemServico.Entidades.Servico;
import java.sql.SQLException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author IAGO
 */
public class ServicoTeste {
    
    public ServicoTeste() {
    }
    
    @Test
    @Ignore
    public void salvar() throws SQLException{
        ServicoDAO servico = new ServicoDAO();
        Servico s = new Servico("Manutenção no chip!");
        String resultado = servico.salvar(s);
        System.out.println(resultado);
    }
    
    
    @Test
    @Ignore
    public void listar(){
        ServicoDAO servico = new ServicoDAO();
        
        
        for(Servico s : servico.lista()){
            System.out.println(s.getNome());
            System.out.println(s.getIdServico());
        }
    }
    
    @Test
    @Ignore
    public void deletar(){
        ServicoDAO servico = new ServicoDAO();
        Servico s = new Servico();
        s.setIdServico(3);
        String resultado = servico.deletar(s);
        System.out.println(resultado);
        
    }
    
    @Test
    @Ignore
    public void pesquisa(){
        ServicoDAO servico = new ServicoDAO();
        String campo = "Manutenção";
        for(Servico s : servico.pesquisa(campo)){
            System.out.println(s.getIdServico());
            
        }
        
        
    }
 
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
