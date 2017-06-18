/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaOrdemServico.Entidades;

import java.util.Objects;

/**
 *
 * @author IAGO
 */
public class Servico {

    private int idServico;
    private String nome;

    public Servico() {
    }

    public Servico(String nome) {
        this.nome = nome;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    
}
