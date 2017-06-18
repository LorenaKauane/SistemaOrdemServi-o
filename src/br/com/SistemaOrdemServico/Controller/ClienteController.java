package br.com.SistemaOrdemServico.Controller;

import br.com.SistemaOrdemServico.DAO.ClienteDAO;
import br.com.SistemaOrdemServico.Entidades.Cliente;
import br.com.SistemaOrdemServico.Entidades.Funcionario;
import br.com.SistemaOrdemServico.Validadores.CNPJ;
import br.com.SistemaOrdemServico.Validadores.CPF;
import br.com.SistemaOrdemServico.View.TelaCadastroClientes;
import br.com.SistemaOrdemServico.View.TelaPrincipal;
import br.com.SistemaOrdemServico.View.TelaServico;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;


public class ClienteController {

    Cliente cliente = new Cliente();

    /*Metodo de pesquisar por campo*/
    public List<Cliente> pesquisar(String campo, String campoPesquisa) {
        ClienteDAO clienteDao = new ClienteDAO();
        List<Cliente> lista = new ArrayList<>();

        lista = clienteDao.pesquisar(campo, campoPesquisa);

        return lista;
    }

    /*Metodo de deletar!*/
    public String deletar(int id) {
        Cliente c = new Cliente();
        c.setIdCliente(id);
        try {
            ClienteDAO clienteDao = new ClienteDAO();
            String resultado = clienteDao.deletar(c);
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*Metodo de verificação dos campos*/
    public String verificacao(String documento, String nome, String endereco, String email, String telefone) {
        /*Verifica se os campos estão escritos*/
        if (verificaCampos(nome, endereco, telefone) == null) {
            /* Verifico se a opção CPF esta ativada*/
            if (verificadorCPF(documento) != null) {
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setEndereco(endereco);
                cliente.setCpf(documento);
                cliente.setTelefone(telefone);
                return "Salvo!";
                /*Ainda não esta implementado!*/
            } else {
                return "CPF INVALIDO";
            }
        } else {
            return verificaCampos(nome, endereco, telefone);
        }
    }

    /*Verificando os campos*/
    public String verificaCampos(String nome, String endereco, String telefone) {
        char tel = telefone.charAt(5);
        if (nome.equals("")) {
            return "Favor Insira o nome";
        } else if (endereco.equals("")) {
            return "Favor Insira o campo endereço ";
        } else if (tel == ' ') {
            return "Favor Insisra o campo telefone";
        } else {
            /*Limpando as variaveis*/
            nome = null;
            endereco = null;
            tel = 0;
            return null;
        }

    }

    public String salvar(int id) {
        ClienteDAO clienteDao = new ClienteDAO();
        /*Se a ID for e porque e um cliente novo*/
        if (id == 0) {
            try {
                String resultado = clienteDao.salvar(cliente);
                return "Salvo!!!!!";
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*Se não e por que estou editando um cliente*/
        } else {
            try {
                cliente.setIdCliente(id);
                String resultado = clienteDao.salvar(cliente);
                return "EDITADO";
            } catch (SQLException ex) {
                Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        id = 0;
        return "LOL";
    }

    /*Verificação dos documentos*/
    public String verificadorCPF(String documento) {
        /* Instancio minha classe CPF do pacote validadores, onde passo
        por parametro minha variavel texto onde foi criado um construtor que 
        receba uma String*/
        CPF verificadorCPF = new CPF(documento);

        /*A função booleana se o resultado for true e por que e valido
        caso ao contrario entraria no else*/
        if (verificadorCPF.isCPF()) {
            return "Valido";
        } else {
            return null;
        }
    }
}
