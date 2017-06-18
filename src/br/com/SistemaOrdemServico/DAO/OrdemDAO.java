/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaOrdemServico.DAO;

import br.com.SistemaOrdemServico.Entidades.Cliente;
import br.com.SistemaOrdemServico.Entidades.Funcionario;
import br.com.SistemaOrdemServico.Entidades.OrdemServico;
import br.com.SistemaOrdemServico.Entidades.Servico;
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
public class OrdemDAO {

    private Connection conexao;

    public OrdemDAO() {

        this.conexao = ConexaoBanco.conector();
    }

    public String salvar(OrdemServico ordem) {
        String sql = "INSERT INTO tb_ordemServico (servico,valorTotal,idFuncionario,idCliente,idServico,situacao)"
                + "VALUES (?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, ordem.getOqueFoiRealizado());//Texto do que foi feito
            stmt.setDouble(2, ordem.getValorTotal());
            //FK
            stmt.setInt(3, ordem.getFuncionario().getIdFuncionario());
            stmt.setInt(4, ordem.getCliente().getIdCliente());
            stmt.setInt(5, ordem.getServico().getIdServico());//comboBox 

            stmt.setString(6, ordem.getSituacao());//Resolvido ou não resolvido

            stmt.execute();
            return "Inserido!";
        } catch (SQLException ex) {
            Logger.getLogger(OrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexao.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Ops aconteceu alguma coisa!";
    }

    public List<OrdemServico> listar() {

        String sql = "	SELECT "
                + "			os.idOrdemServico,"
                + "                  os.data_ordem,"
                + "                  os.servico,"
                + "                  os.valorTotal,"
                + "                  os.situacao,"
                + "                  fun.nome,"
                + "                  serv.nome,"
                + "                 cli.nome,"
                + "                 cli.cpf_cnpj,"
                + "                 cli.telefone, "
                + "                 cli.endereco "
                + "FROM tb_cliente cli "
                + "	INNER JOIN tb_ordemservico os ON "
                + "	cli.idCliente = os.idCliente "
                + "	INNER JOIN tb_servico serv ON "
                + "	serv.idServico = os.idServico "
                + "	INNER JOIN tb_funcionario fun ON "
                + "	fun.idFuncionario = os.idFuncionario;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<OrdemServico> ordens = new ArrayList<>();
        try {

            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                OrdemServico o = new OrdemServico();
                Cliente cliente = new Cliente();
                Funcionario funcionario = new Funcionario();
                Servico servico = new Servico();

                o.setIdOrdemServico(rs.getInt("os.idOrdemServico"));
                o.setObjetoSQL(rs.getTimestamp("os.data_ordem"));
                o.setOqueFoiRealizado(rs.getString("os.servico"));
                o.setSituacao(rs.getString("os.situacao"));
                o.setValorTotal(rs.getDouble("os.valorTotal"));

                funcionario.setNome(rs.getString("fun.nome"));

                servico.setNome(rs.getString("serv.nome"));

                cliente.setNome(rs.getString("cli.nome"));
                cliente.setCpf(rs.getString("cli.cpf_cnpj"));
                cliente.setEndereco(rs.getString("cli.endereco"));

                o.setCliente(cliente);
                o.setFuncionario(funcionario);
                o.setServico(servico);

                ordens.add(o);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                conexao.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ordens;
    }

    public List<OrdemServico> pesquisa(String campo, String campoPesquisa) {

        String sql = "	SELECT "
                + "			os.idOrdemServico,"
                + "                  os.data_ordem,"
                + "                  os.servico,"
                + "                  os.valorTotal,"
                + "                  os.situacao,"
                + "                  fun.nome,"
                + "                  serv.nome,"
                + "                 cli.nome,"
                + "                 cli.cpf_cnpj,"
                + "                 cli.telefone, "
                + "                 cli.endereco "
                + "FROM tb_cliente cli "
                + "	INNER JOIN tb_ordemservico os ON "
                + "	cli.idCliente = os.idCliente "
                + "	INNER JOIN tb_servico serv ON "
                + "	serv.idServico = os.idServico "
                + "	INNER JOIN tb_funcionario fun ON "
                + "	fun.idFuncionario = os.idFuncionario"
                + " WHERE "+campo+" like '%"+campoPesquisa+"%'";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<OrdemServico> ordens = new ArrayList<>();
        try {

            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                OrdemServico o = new OrdemServico();
                Cliente cliente = new Cliente();
                Funcionario funcionario = new Funcionario();
                Servico servico = new Servico();

                o.setIdOrdemServico(rs.getInt("os.idOrdemServico"));
                o.setObjetoSQL(rs.getTimestamp("os.data_ordem"));
                o.setOqueFoiRealizado(rs.getString("os.servico"));
                o.setSituacao(rs.getString("os.situacao"));
                o.setValorTotal(rs.getDouble("os.valorTotal"));

                funcionario.setNome(rs.getString("fun.nome"));

                servico.setNome(rs.getString("serv.nome"));

                cliente.setNome(rs.getString("cli.nome"));
                cliente.setCpf(rs.getString("cli.cpf_cnpj"));
                cliente.setEndereco(rs.getString("cli.endereco"));

                o.setCliente(cliente);
                o.setFuncionario(funcionario);
                o.setServico(servico);


                ordens.add(o);

            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordens;
    }

    public String deletar(OrdemServico ordem) {
        String sql = "DELETE FROM db_ordemservico.tb_ordemservico WHERE idOrdemServico = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, ordem.getIdOrdemServico());

            stmt.execute();
            return "Deletado!";
        } catch (SQLException ex) {
            Logger.getLogger(OrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Aconteceu alguma coisa!";
    }

}
