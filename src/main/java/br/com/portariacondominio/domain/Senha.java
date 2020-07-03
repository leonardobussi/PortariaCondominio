package br.com.portariacondominio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
@SuppressWarnings("serial")
@Entity
public class Senha extends GenericDomain{
    @Column(length = 6, nullable = false)
    public String Senha;

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    
}
