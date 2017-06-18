
package br.com.SistemaOrdemServico.Entidades;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;



public class OrdemServico {
    
    private int idOrdemServico;
    private Calendar Calendario = Calendar.getInstance();
    //Objeto para conseguir inserir
    java.sql.Timestamp ObjetoSQL = new java.sql.Timestamp(Calendario.getTime().getTime());
    private String oqueFoiRealizado;
    private double valorTotal;
    private String situacao;
    
    private Funcionario funcionario;
    private Cliente cliente;
    private Servico servico;

    public OrdemServico() {
    }

    public OrdemServico(String oqueFoiRealizado, double valorTotal,  Funcionario funcionario, Cliente cliente, Servico servico,String situacao) {
        this.oqueFoiRealizado = oqueFoiRealizado;
        this.valorTotal = valorTotal;
        this.situacao = situacao;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.servico = servico;
    }

    public OrdemServico(String acontecido, double valor, String situacao, Funcionario f, Cliente c, Servico s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public int getIdOrdemServico() {
        return idOrdemServico;
    }

    public void setIdOrdemServico(int idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }

    public Calendar getCalendario() {
        return Calendario;
    }

    public void setCalendario(Calendar Calendario) {
        this.Calendario = Calendario;
    }

    public Timestamp getObjetoSQL() {
        return ObjetoSQL;
    }

    public void setObjetoSQL(Timestamp ObjetoSQL) {
        this.ObjetoSQL = ObjetoSQL;
    }

    public String getOqueFoiRealizado() {
        return oqueFoiRealizado;
    }

    public void setOqueFoiRealizado(String oqueFoiRealizado) {
        this.oqueFoiRealizado = oqueFoiRealizado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "idOrdemServico=" + idOrdemServico + ", Calendario=" + Calendario + ", ObjetoSQL=" + ObjetoSQL + ", oqueFoiRealizado=" + oqueFoiRealizado + ", valorTotal=" + valorTotal + ", situacao=" + situacao + ", funcionario=" + funcionario + ", cliente=" + cliente + ", servico=" + servico + '}';
    }

   
    
}
