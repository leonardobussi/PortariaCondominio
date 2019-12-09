package br.com.portariacondominio.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Morador extends GenericDomain{
    @Column(length = 50, nullable = false)
    public String nome;
    @Column(length = 12, nullable = false)
    public String rg;
    @Column(length = 15, nullable = false)
    public String cpf;
    @Column(length = 11, nullable = false)
    public String dataAniversario;
    //relacionamentos
   /* @OneToOne
    @JoinColumn(nullable = true)
    public Senha senha;
    @OneToOne
    @JoinColumn(nullable = true)    
    public Contato contato;
*/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
    
}
