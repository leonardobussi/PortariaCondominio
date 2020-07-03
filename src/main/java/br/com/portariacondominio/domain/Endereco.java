package br.com.portariacondominio.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import br.com.portariacondominio.domain.Morador;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Endereco extends GenericDomain{
    @Column(length = 4, nullable = false)
    public String bloco;
    @Column(length = 4, nullable = false)
    public String numero;
    
    /*@ManyToOne
    @JoinColumn(nullable = true)
    public Morador morador;
*/
    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

        
}
