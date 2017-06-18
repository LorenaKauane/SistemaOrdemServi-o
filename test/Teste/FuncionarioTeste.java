/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import br.com.SistemaOrdemServico.DAO.FuncionarioDAO;
import br.com.SistemaOrdemServico.Entidades.Funcionario;
import java.sql.SQLException;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author IAGO
 */
public class FuncionarioTeste {

    @Test
    @Ignore
    public void salvar() throws SQLException {
        //cpf, senha, nome, telefone
        Funcionario f1 = new Funcionario("CPF", "123", "Luiz", "445");

        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        funcionarioDao.salvar(f1);

    }

    @Test
    @Ignore
    public void lista() {
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        int i = 0;
        for (Funcionario f : funcionarioDao.lista()) {
            System.out.println(f.getSenha());
            i++;
        }

    }

    @Test
    public void pesquisa() {
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        int i = 0;
        String pesquisa = "orena";

        for (Funcionario f : funcionarioDao.pesquisar("nome", "uiz")) {
            System.out.println(f.getIdFuncionario());
            i++;
        }
    }

    @Test
    @Ignore
    public void deletar() {
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        Funcionario lol = new Funcionario();
        lol.setIdFuncionario(3);
        String resultado = funcionarioDao.deletar(lol);
        System.out.println(resultado);

    }

}
