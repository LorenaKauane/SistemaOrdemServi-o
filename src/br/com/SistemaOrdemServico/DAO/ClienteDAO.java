/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaOrdemServico.DAO;

import br.com.SistemaOrdemServico.Entidades.Cliente;
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
public class ClienteDAO {

    private Connection conexao;

    public ClienteDAO() {
        this.conexao = ConexaoBanco.conector();
    }

    public String salvar(Cliente cliente) throws SQLException {

        //String sql = "INSERT INTO tb_cliente (nome,cpf_cnpj,endereco,telefone,email) VALUES (?,?,?,?,?);";
        PreparedStatement stmt = null;

        try {
            if (cliente.getIdCliente() == 0) {
                stmt = conexao.prepareStatement("INSERT INTO tb_cliente (nome,cpf_cnpj,endereco,telefone,email) VALUES (?,?,?,?,?)");
            } else {
                stmt = conexao.prepareStatement("update tb_cliente set nome=?,cpf_cnpj=?, endereco=?, "
                        + "telefone=?,email =? where idCliente=?");
                stmt.setInt(6, cliente.getIdCliente());
            }
  
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());

            stmt.execute();
            return "Salvo!";

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
            stmt.close();
            System.out.println("FECHANDO A COONEXAO CLIENTE ");
        }
        return ("Aconteceu algum problema na hr de salvar");
    }

    public List<Cliente> lista() throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from tb_cliente";
        List<Cliente> clientes = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c1 = new Cliente();
                c1.setIdCliente(rs.getInt("idCliente"));
                c1.setNome(rs.getString("nome"));
                c1.setCpf(rs.getString("cpf_cnpj"));
                c1.setEndereco(rs.getString("endereco"));
                c1.setTelefone(rs.getString("telefone"));
                c1.setEmail(rs.getString("email"));

                clientes.add(c1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
            rs.close();
            stmt.close();
        }
        return clientes;
    }
    //http://pt.stackoverflow.com/questions/134546/pesquisa-usando-jtextfield-e-jtable

    public String deletar(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM db_ordemservico.tb_cliente WHERE idCliente =?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cliente.getIdCliente());
            stmt.execute();
            return "Deletado";
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            stmt.close();
            conexao.close();
        }
        return "Aconteceu alguma coisa!";
    }

    public List<Cliente> pesquisar(String campo,String campoPesquisa) {
        String sql = "select * from tb_cliente where "+campo+" like '%"+campoPesquisa+"%'";
        PreparedStatement stmt = null;
        
        List<Cliente> clientes = new ArrayList<>();
        ResultSet rs = null;
        try {

            stmt = conexao.prepareStatement(sql);
            //stmt.setString(1, "%"+campoPesquisa+"%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c1 = new Cliente();
                c1.setIdCliente(rs.getInt("idCliente"));
                c1.setNome(rs.getString("nome"));
                c1.setCpf(rs.getString("cpf_cnpj"));
                c1.setEndereco(rs.getString("endereco"));
                c1.setTelefone(rs.getString("telefone"));
                c1.setEmail(rs.getString("email"));
                clientes.add(c1);
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientes;
    }

}
