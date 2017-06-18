package br.com.SistemaOrdemServico.Controller;

import br.com.SistemaOrdemServico.DAO.FuncionarioDAO;
import br.com.SistemaOrdemServico.Entidades.Funcionario;
import br.com.SistemaOrdemServico.Validadores.CPF;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioController {

    Funcionario funcionario = new Funcionario();

    public List<Funcionario> pesquisar(String campo, String campoPesquisa) {
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        List<Funcionario> lista = new ArrayList<>();
        lista = funcionarioDao.pesquisar(campo, campoPesquisa);
        return lista;
    }

    public String deletar(int id) {
        Funcionario f = new Funcionario();
        f.setIdFuncionario(id);
        FuncionarioDAO clienteDao = new FuncionarioDAO();
        return clienteDao.deletar(f);
    }

    public String verificacao(String documento, String nome, String telefone, String senha) {
        if (verificaCampos(nome, telefone, senha) == null) {
            if (verificaCPF(documento) != null) {
                atribuiDadosFuncionario(documento, nome, telefone, senha);
                return "Salvo!";
            } else {
                return "Cpf invalido";
            }
        } else {
            return verificaCampos(nome, telefone, senha);
        }

    }

    public void atribuiDadosFuncionario(String documento, String nome, String telefone, String senha) {
        funcionario.setNome(nome);
        funcionario.setTelefone(telefone);
        funcionario.setCpf(documento);
        funcionario.setSenha(senha);
    }

    public String salvar(int id) {
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        /*Se a ID for e porque e um funcionario novo*/
        if (id == 0) {
            try {
                return funcionarioDao.salvar(funcionario);
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                funcionario.setIdFuncionario(id);
                return funcionarioDao.salvar(funcionario);
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return "Aconteceu alguma coisa";
    }

    public String verificaCampos(String nome, String telefone, String senha) {
        char tel = telefone.charAt(2);
        if (nome.equals("") || nome == null) {
            return ("Favor me informar o campo nome");

        } else if (tel == ' ') {

            return ("Favor me informar o campo telefone");

        } else if (senha.equals("")) {
            return ("Favor me informar o campo senha");

        } else if (senha.length() <= 5) {
            return ("Ops minimo de caracteres para a senha e 5");

        } else {
            return null;
        }

    }

    /*Validação de cpf*/
    public String verificaCPF(String documento) {
        CPF pf = new CPF(documento);

        if (pf.isCPF()) {
            return "CPF CORRETO";
        }
        return null;
    }
}
