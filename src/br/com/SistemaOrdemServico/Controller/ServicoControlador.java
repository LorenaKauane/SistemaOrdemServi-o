package br.com.SistemaOrdemServico.Controller;

import br.com.SistemaOrdemServico.DAO.ServicoDAO;
import br.com.SistemaOrdemServico.Entidades.Servico;
import br.com.SistemaOrdemServico.View.TelaPrincipal;
import br.com.SistemaOrdemServico.View.TelaServico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ServicoControlador {
    Servico servico = new Servico();
    /*Verificação do campos*/
    public String verifica(String nome) {
        if (nome.equals("") && nome.length() < 5 || nome == null) {
            return "Impossivel salvar! Nome do equipamento necessario.";
        } else {
            servico.setNome(nome);
            nome = null;
            return null;
        }

    }
    /*Metodo responsavel por salvar*/
    public String salvar() {
        try {
            ServicoDAO servicoDao = new ServicoDAO();            
            return servicoDao.salvar(servico);
        } catch (SQLException ex) {
            Logger.getLogger(ServicoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Ocorreu algo";
    }


    /*Metodo responsavel para deletar*/
    public String deletar(int id) {
        ServicoDAO servicoDao = new ServicoDAO();
        servico.setIdServico(id);
        return servicoDao.deletar(servico);

    }

}
