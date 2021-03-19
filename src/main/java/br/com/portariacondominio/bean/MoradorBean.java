package br.com.portariacondominio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.portariacondominio.dao.MoradorDAO;
import br.com.portariacondominio.domain.Morador;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MoradorBean implements Serializable {
	
	private Morador morador;
	private List<Morador> moradores;

        public Morador getMorador() {
            return morador;
        }

        public void setMorador(Morador morador) {
            this.morador = morador;
        }

        public List<Morador> getMoradores() {
            return moradores;
        }

        public void setMoradores(List<Morador> moradores) {
            this.moradores = moradores;
        }

       

	@PostConstruct
	public void listar() {
		try {
                        MoradorDAO moradorDAO = new MoradorDAO();
			moradores = moradorDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os moradores");
			erro.printStackTrace();
		}
	}
         public void novo() {
            morador = new Morador();
        }

         public void salvar() {
        try {
            MoradorDAO moradorDAO = new MoradorDAO();
            moradorDAO.merge(morador);

            morador = new Morador();
            moradores = moradorDAO.listar();

            Messages.addGlobalInfo("morador salvo com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar o morador");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            morador = (Morador) evento.getComponent().
                    getAttributes().get("moradorSelecionado");

            MoradorDAO moradorDAO = new MoradorDAO();
            moradorDAO.excluir(morador);

            moradores = moradorDAO.listar();

            Messages.addGlobalInfo("morador removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.
                    addFlashGlobalError("erro ao tentar remover esse Morador");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        morador = (Morador) evento.
                getComponent().
                getAttributes().get("moradorSelecionado");
    }

}

