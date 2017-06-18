/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaOrdemServico.DAO;

import br.com.SistemaOrdemServico.Entidades.Funcionario;
import br.com.SistemaOrdemServico.Factory.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IAGO
 */
public class FuncionarioDAO {

    private Connection conexao;

    public FuncionarioDAO() {
        this.conexao = ConexaoBanco.conector();
    }

    public String salvar(Funcionario f1) throws SQLException {
        String sql = "INSERT INTO tb_Funcionario (nome,telefone,cpf,senha) VALUES (?,?,?,?)";
        String sqlEdita = "update tb_Funcionario set nome=?,telefone=?, cpf=?, "
                + "senha =? where idFuncionario=?";
        //Inserindo dados do banco 
        PreparedStatement stmt = null;
        try {

            if (f1.getIdFuncionario() == 0) {
                stmt = conexao.prepareStatement(sql);
            } else {
                stmt = conexao.prepareStatement(sqlEdita);
                stmt.setInt(5, f1.getIdFuncionario());
            }

            stmt.setString(1, f1.getNome());
            stmt.setString(2, f1.getTelefone());
            stmt.setString(3, f1.getCpf());
            stmt.setString(4, f1.getSenha());
            stmt.execute();
            return "Cadastro do funcionario realizado!";
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Aconteceu alguma coisa";
        } finally {
            conexao.close();
            stmt.close();
        }

    }

    public List<Funcionario> lista() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "select * from tb_Funcionario";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idFuncionario"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setCpf(rs.getString("cpf"));
                f.setSenha(rs.getString("senha"));

                funcionarios.add(f);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexao.close();
                rs.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return funcionarios;
    }

    public List<Funcionario> pesquisar(String campo, String campoPesquisa) {
        String sql = "select * from tb_Funcionario where " + campo + " like '%" + campoPesquisa + "%'";
        PreparedStatement stmt = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idFuncionario"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setCpf(rs.getString("cpf"));
                f.setSenha(rs.getString("senha"));

                funcionarios.add(f);

            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                conexao.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return funcionarios;
    }

    public Funcionario pesquisarCpf(String campo, String campoPesquisa) {
        String sql = "select * from tb_Funcionario where " + campo + " like '%" + campoPesquisa + "%'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario f = new Funcionario();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                f.setIdFuncionario(rs.getInt("idFuncionario"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setCpf(rs.getString("cpf"));
                f.setSenha(rs.getString("senha"));

            }

            return f;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                conexao.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public String deletar(Funcionario funcionario) {
        String sql = "DELETE FROM db_ordemservico.tb_Funcionario WHERE idFuncionario =?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.execute();
            return "Deletado";
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return "Aconteceu alguma coisa!";
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
