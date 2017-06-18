package br.com.SistemaOrdemServico.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBanco {

    private static final String LOGIN = "root";
    private static final String SENHA = "admin";
    private static final String URL = "jdbc:mysql://localhost:3307/db_OrdemServico";
    private static Connection conexao;

    public static Connection conector()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando ao banco!");
            
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            return conexao;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
    }


}
