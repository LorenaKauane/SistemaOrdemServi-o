package br.com.SistemaOrdemServico.DAO;

import br.com.SistemaOrdemServico.Entidades.Funcionario;
import br.com.SistemaOrdemServico.Factory.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO {

    private Connection conexao;

    public LoginDAO() {
        this.conexao = ConexaoBanco.conector();
    }

    public boolean verificaUsuario(Funcionario funcionario) throws SQLException{
        String sql = "select * from tb_Funcionario f where f.cpf=? and f.senha=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getSenha());
           
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.close();
            stmt.close();
            rs.close();
        }
        return false;
    }


}
