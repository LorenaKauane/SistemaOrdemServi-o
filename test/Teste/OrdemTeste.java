/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import br.com.SistemaOrdemServico.DAO.OrdemDAO;
import br.com.SistemaOrdemServico.Entidades.Cliente;
import br.com.SistemaOrdemServico.Entidades.Funcionario;
import br.com.SistemaOrdemServico.Entidades.OrdemServico;
import br.com.SistemaOrdemServico.Entidades.Servico;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author IAGO
 */
public class OrdemTeste {
    
    public OrdemTeste() {
    }
    
    @Test
    @Ignore
    public void salvar(){
        Cliente c = new Cliente();
        Funcionario f = new Funcionario();
        Servico s = new Servico();
        
        c.setIdCliente(4);
        f.setIdFuncionario(1);
        s.setIdServico(1);
        double valor = 20.90;
        String situacao = " resolvido!";
        
        String acontecido ="Teste";
        
        OrdemServico ordem = new OrdemServico(acontecido, valor, situacao, f, c, s);
        OrdemDAO ordemDao = new OrdemDAO();
        String resultado = ordemDao.salvar(ordem);
        
        System.out.println(resultado);
    }

    @Test
    public void listar(){
        OrdemDAO ordemDao = new OrdemDAO();
        
        for(OrdemServico o : ordemDao.listar()){
            System.out.println("Nome do cliente: "+o.getCliente().getNome());
            System.out.println("CPF do cliente: "+o.getCliente().getCpf());
            System.out.println("ENDERECL do cliente: "+o.getCliente().getEndereco());
            
            System.out.println("Nome do funcionario: "+o.getFuncionario().getNome());
            
            System.out.println("Servico realizado: "+o.getServico().getNome());
            
            System.out.println("O que foi realizado: "+o.getOqueFoiRealizado());
            System.out.println("Situacao: "+o.getSituacao());
            System.out.println("Data: "+o.getObjetoSQL());
            System.out.println("ID OS: "+o.getIdOrdemServico());
            System.out.println("Valor total: "+o.getValorTotal());

            
            
        }     
    }
    
    @Test
    @Ignore
    public void deletar(){
        OrdemDAO ordemDao = new OrdemDAO();
        OrdemServico ordem = new OrdemServico();
        ordem.setIdOrdemServico(2);

        String resultado = ordemDao.deletar(ordem);
        System.out.println(resultado);
        
    }
}
