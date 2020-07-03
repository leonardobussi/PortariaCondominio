package br.com.portariacondominio.bean;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.portariacondominio.dao.SenhaDAO;
import br.com.portariacondominio.domain.Senha;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class SenhaBean implements Serializable{
    
	
	private Senha senha;
	private List<Senha> senhas;

        public Senha getSenha() {
            return senha;
        }

        public void setSenha(Senha senha) {
            this.senha = senha;
        }

        public List<Senha> getSenhas() {
            return senhas;
        }

        public void setSenhas(List<Senha> senhas) {
            this.senhas = senhas;
        }

        
	

	@PostConstruct
	public void listar() {
		try {
                        SenhaDAO senhaDAO = new SenhaDAO();
			senhas = senhaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar");
			erro.printStackTrace();
		}
	}
         public void novo() {
            senha = new Senha();
        }

         public void salvar() {
        try {
            SenhaDAO senhaDAO = new SenhaDAO();
            senhaDAO.merge(senha);

            senha = new Senha();
            senhas = senhaDAO.listar();

            Messages.addGlobalInfo("Salvo com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            senha = (Senha) evento.getComponent().
                    getAttributes().get("senhaSelecionado");

            SenhaDAO senhaDAO = new SenhaDAO();
            senhaDAO.excluir(senha);

            senhas = senhaDAO.listar();

            Messages.addGlobalInfo("removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.
                    addFlashGlobalError("Ocorreu um erro ao tentar remover");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        senha = (Senha) evento.
                getComponent().
                getAttributes().get("senhaSelecionado");
    }

}

