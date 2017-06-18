
package br.com.SistemaOrdemServico.Controller;

import br.com.SistemaOrdemServico.DAO.OrdemDAO;
import br.com.SistemaOrdemServico.Entidades.Cliente;
import br.com.SistemaOrdemServico.Entidades.Funcionario;
import br.com.SistemaOrdemServico.Entidades.OrdemServico;
import br.com.SistemaOrdemServico.Entidades.Servico;


public class cadastroOrdem {
   
    public String salvar(String oqueFoiRealizado, double valorTotal,
            int idFuncionario, int idCliente, int idServico,
            String situacao){
            
        Funcionario f = new Funcionario();
        f.setIdFuncionario(idFuncionario);
        Cliente c = new Cliente();
        c.setIdCliente(idCliente);
        Servico s = new Servico();
        s.setIdServico(idServico);
        
        OrdemDAO ordemDao = new OrdemDAO();
        OrdemServico ordem = new OrdemServico(oqueFoiRealizado, valorTotal, f, c, s, situacao);
        
        return ordemDao.salvar(ordem);
        
        
    }
    
    public String deletar(int id){
        OrdemServico ordem = new OrdemServico();
        OrdemDAO ordemDao = new OrdemDAO();
        ordem.setIdOrdemServico(id);
        
        
        return ordemDao.deletar(ordem);
    }
    
    
}
