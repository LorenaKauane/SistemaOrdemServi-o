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
public class Cliente extends Pessoa{

    private int idCliente;
    private String endereco;
    private String email;
    private String cpf; 
    
    public Cliente() {
        super();
    }

    public Cliente(String endereco, String email, String cpf, String nome, String telefone) {
        super(nome, telefone);
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
    }

    public Cliente(String endereco, String email, String cpf) {
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
    }

    public Cliente(int idCliente, String endereco, String email, String cpf, String nome, String telefone) {
        super(nome, telefone);
        this.idCliente = idCliente;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
    }

    public Cliente(int idCliente, String endereco, String email, String cpf) {
        this.idCliente = idCliente;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
    }

    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idCliente;
        hash = 67 * hash + Objects.hashCode(this.endereco);
        hash = 67 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

   

}
