package br.com.portariacondominio.domain;
import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Contato extends GenericDomain{
    @Column(length = 30, nullable = false)
    public String email;
    @Column(length = 11, nullable = false)
    public String telefone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
