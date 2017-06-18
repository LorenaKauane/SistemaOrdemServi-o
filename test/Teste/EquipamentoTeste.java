/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import br.com.SistemaOrdemServico.DAO.ServicoDAO;
import br.com.SistemaOrdemServico.Entidades.Servico;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author IAGO
 */
public class EquipamentoTeste {
    
    @Test
    @Ignore
    public void salvar(){
        try {
            Servico e1 = new Servico("Celular iphone 7");
            ServicoDAO equipamento = new ServicoDAO();
            String result = equipamento.salvar(e1);
            System.out.println(result);
        } catch (SQLException ex) {
            Logger.getLogger(EquipamentoTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
