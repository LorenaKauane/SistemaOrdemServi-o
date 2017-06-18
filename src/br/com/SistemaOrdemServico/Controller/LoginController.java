/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaOrdemServico.Controller;

import br.com.SistemaOrdemServico.DAO.LoginDAO;
import br.com.SistemaOrdemServico.Entidades.Funcionario;
import br.com.SistemaOrdemServico.View.TelaPrincipal;
import static br.com.SistemaOrdemServico.View.LoginTela.cpf;
import static br.com.SistemaOrdemServico.View.LoginTela.senha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController {

    /*Variavel responsavel pela verificação de tentativas de quantas vezes a pessoa tentou logar
     */
    int verificacaoTentativas = 0;

    public boolean verificaCampos(String cpf, String senha){
        if (cpf.equals("") || senha.equals("")) {
            JOptionPane.showMessageDialog(null, "Os campos estão vazios");
            return false;
        }else{
            return true;
        }
    }
    public boolean verificaUsuario(String cpf, String senha) {

        if (!verificaCampos(cpf, senha)) {
            return false;
        } else {
            if (verificacaoTentativas <= 1) {
                try {
                    /*Criando o funcionario para depois realizar a verificação*/
                    Funcionario funcionario = new Funcionario(cpf, senha);
                    LoginDAO loginDAO = new LoginDAO();
                    /*Se retornar verdadeiro e porque foi encontrado!*/
                    if (loginDAO.verificaUsuario(funcionario)) {
                        JOptionPane.showMessageDialog(null, "Bem vindo!");

                        /*Limpando as variaveis*/
                        cpf = null;
                        senha = null;
                        verificacaoTentativas = 0;

                        new TelaPrincipal().setVisible(true);
                        /*Colocar na label o cpf do funcionario*/
                        TelaPrincipal.logado.setText(funcionario.getCpf());
                        return true;
                    } else {
                        /*Acrimento a variavel verificacaoTentativas*/
                        verificacaoTentativas++;
                        if (verificacaoTentativas == 1) {
                            JOptionPane.showMessageDialog(null, "Senha ou CPF incorretos\n Você tem só mais uma chance"
                                    + "para acessar o sistema!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ops... Usuario inabilitado, favor verificar CPF ou senha com superior");

                            /*Limpando as variaveis*/
                            cpf = null;
                            senha = null;
                            verificacaoTentativas = 0;

                            /*Retorna true para fechar o programa*/
                            return true;
                        }

                    }
                } catch (Throwable e) {
                    System.out.println(e);
                }
            }
        }

        return false;
    }

}
