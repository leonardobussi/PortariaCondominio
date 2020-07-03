package br.com.portariacondominio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.portariacondominio.dao.SexoDAO;
import br.com.portariacondominio.domain.Sexo;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class SexoBean implements Serializable {
	
	private Sexo sexo;
	private List<Sexo> sexos;

        public Sexo getSexo() {
            return sexo;
        }

        public void setSexo(Sexo sexo) {
            this.sexo = sexo;
        }

        public List<Sexo> getSexos() {
            return sexos;
        }

        public void setSexos(List<Sexo> sexos) {
            this.sexos = sexos;
        }

            
	

	@PostConstruct
	public void listar() {
		try {
                        SexoDAO sexoDAO = new SexoDAO();
			sexos = sexoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar o sexo");
			erro.printStackTrace();
		}
	}
         public void novo() {
            sexo = new Sexo();
        }

         public void salvar() {
        try {
            SexoDAO sexoDAO = new SexoDAO();
            sexoDAO.merge(sexo);

            sexo = new Sexo();
            sexos = sexoDAO.listar();

            Messages.addGlobalInfo("salvo com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            sexo = (Sexo) evento.getComponent().
                    getAttributes().get("sexoSelecionado");

            SexoDAO sexoDAO = new SexoDAO();
            sexoDAO.excluir(sexo);

            sexos = sexoDAO.listar();

            Messages.addGlobalInfo("removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.
                    addFlashGlobalError("Ocorreu um erro ao tentar remover");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        sexo = (Sexo) evento.
                getComponent().
                getAttributes().get("sexoSelecionado");
    }

}

