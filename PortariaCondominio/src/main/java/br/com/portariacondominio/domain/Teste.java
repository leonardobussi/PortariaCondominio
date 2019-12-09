package br.com.portariacondominio.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
/**
 *
 * @author bussi
 */
@SuppressWarnings("serial")
@Entity
public class Teste extends GenericDomain{
     @Column(length = 50, nullable = true)
    public String nome;
    @Column(length = 12, nullable = true)
    public String rg;
    @Column(length = 15, nullable = true)
    public String cpf;
    @Column(length = 11, nullable = true)
    public String dataAniversario;
    @Column(length = 30, nullable = true)
    public String email;
    @Column(length = 11, nullable = true)
    public String telefone;
    @Column(length = 4, nullable = true)
    public String bloco;
    @Column(length = 4, nullable = true)
    public String numero;
    @Column(length = 6, nullable = true)
    public String Senha;
    @Column(length = 10, nullable = true)
    public String typeSexo;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

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

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getTypeSexo() {
        return typeSexo;
    }

    public void setTypeSexo(String typeSexo) {
        this.typeSexo = typeSexo;
    }
}
