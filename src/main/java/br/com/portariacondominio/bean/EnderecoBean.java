package br.com.portariacondominio.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.portariacondominio.dao.EnderecoDAO;
import br.com.portariacondominio.domain.Endereco;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EnderecoBean implements Serializable {
	
	private Endereco endereco;
	private List<Endereco> enderecos;

        public Endereco getEndereco() {
            return endereco;
        }

        public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
        }

        public List<Endereco> getEnderecos() {
            return enderecos;
        }

        public void setEnderecos(List<Endereco> enderecos) {
            this.enderecos = enderecos;
        }


	

	@PostConstruct
	public void listar() {
		try {
                        EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecos = enderecoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar o endereço");
			erro.printStackTrace();
		}
	}
         public void novo() {
            endereco = new Endereco();
        }

         public void salvar() {
        try {
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecoDAO.merge(endereco);

            endereco = new Endereco();
            enderecos = enderecoDAO.listar();

            Messages.addGlobalInfo("endereço salvo com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar o endereço");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            endereco = (Endereco) evento.getComponent().
                    getAttributes().get("enderecoSelecionado");

            EnderecoDAO enderecoDAO = new EnderecoDAO();
            enderecoDAO.excluir(endereco);

            enderecos = enderecoDAO.listar();

            Messages.addGlobalInfo("endereco removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.
                    addFlashGlobalError("Ocorreu um erro ao tentar remover esse endereco");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        endereco = (Endereco) evento.
                getComponent().
                getAttributes().get("enderecoSelecionado");
    }

}
