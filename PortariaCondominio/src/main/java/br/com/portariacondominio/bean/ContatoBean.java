package br.com.portariacondominio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.portariacondominio.dao.ContatoDAO;
import br.com.portariacondominio.domain.Contato;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ContatoBean implements Serializable {
	
	private Contato contato;
	private List<Contato> contatos;

        public Contato getContato() {
            return contato;
        }

        public void setContato(Contato contato) {
            this.contato = contato;
        }

        public List<Contato> getContatos() {
            return contatos;
        }

        public void setContatos(List<Contato> contatos) {
            this.contatos = contatos;
        }

	

	@PostConstruct
	public void listar() {
		try {
                        ContatoDAO contatoDAO = new ContatoDAO();
			contatos = contatoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os contato");
			erro.printStackTrace();
		}
	}
         public void novo() {
            contato = new Contato();
        }

         public void salvar() {
        try {
            ContatoDAO contatoDAO = new ContatoDAO();
            contatoDAO.merge(contato);

            contato = new Contato();
            contatos = contatoDAO.listar();

            Messages.addGlobalInfo("contato salvo com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar o contato");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            contato = (Contato) evento.getComponent().
                    getAttributes().get("contatoSelecionado");

            ContatoDAO contatoDAO = new ContatoDAO();
            contatoDAO.excluir(contato);

            contatos = contatoDAO.listar();

            Messages.addGlobalInfo("contato removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.
                    addFlashGlobalError("Ocorreu um erro ao tentar remover esse contato");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        contato = (Contato) evento.
                getComponent().
                getAttributes().get("contatoSelecionado");
    }

}
