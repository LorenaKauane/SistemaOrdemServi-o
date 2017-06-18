package br.com.SistemaOrdemServico.DAO;

import br.com.SistemaOrdemServico.Entidades.Servico;
import br.com.SistemaOrdemServico.Factory.ConexaoBanco;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoDAO {

    private Connection conexao;

    public ServicoDAO() {
        this.conexao = ConexaoBanco.conector();
    }

    public String salvar(Servico equipamento) throws SQLException {
        String sql = "INSERT INTO tb_Servico (nome) values (?)";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, equipamento.getNome());
            stmt.execute();
            return "Salvo!";
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            stmt.close();
            conexao.close();
        }
        return "Aconteceu alguma coisa!";
    }

    public String deletar(Servico servico) {
        String sql = "DELETE FROM db_ordemservico.tb_Servico WHERE idServico =?";
        PreparedStatement stmt = null;
        try {

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, servico.getIdServico());
            stmt.execute();
            return "Deletado!!";
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexao.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "Aconteceu alguma coisa";
    }

    public List<Servico> lista() {
        String sql = "select * from tb_Servico";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Servico> servicos = new ArrayList<>();
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Servico s = new Servico();
                s.setIdServico(rs.getInt("idServico"));
                s.setNome(rs.getString("nome"));
                servicos.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return servicos;
    }

    public List<Servico> pesquisa(String campoPesquisa) {
        String sql = "select * from tb_Servico where nome like '%" + campoPesquisa + "%'";
        List<Servico> servicos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Servico s = new Servico();
                s.setIdServico(rs.getInt("idServico"));
                s.setNome(rs.getString("nome"));
                servicos.add(s);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return servicos;
    }

}
