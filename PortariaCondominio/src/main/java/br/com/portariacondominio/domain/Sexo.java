package br.com.portariacondominio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import br.com.portariacondominio.domain.Morador;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Entity
public class Sexo extends GenericDomain{
    @Column(length = 10, nullable = true)
    public String typeSexo;
     
   /* @ManyToOne
    @JoinColumn(nullable = true)
    public Morador morador; 
*/
    public String getTypeSexo() {
        return typeSexo;
    }

    public void setTypeSexo(String typeSexo) {
        this.typeSexo = typeSexo;
    }


    
    
   
   
}