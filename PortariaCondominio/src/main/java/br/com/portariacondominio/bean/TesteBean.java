package br.com.portariacondominio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.portariacondominio.dao.TesteDAO;
import br.com.portariacondominio.domain.Teste;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TesteBean implements Serializable {
	
	private Teste teste;
	private List<Teste >testes;

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }

    public List<Teste> getTestes() {
        return testes;
    }

    public void setTestes(List<Teste> testes) {
        this.testes = testes;
    }

   
	

	@PostConstruct
	public void listar() {
		try {
                        TesteDAO testeDAO = new TesteDAO();
			testes = testeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar");
			erro.printStackTrace();
		}
	}
         public void novo() {
            teste = new Teste();
        }

         public void salvar() {
        try {
            TesteDAO testeDAO = new TesteDAO();
            testeDAO.merge(teste);

            teste = new Teste();
            testes = testeDAO.listar();

            Messages.addGlobalInfo("salvo com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            teste = (Teste) evento.getComponent().
                    getAttributes().get("classtesteSelecionado");

            TesteDAO testeDAO = new TesteDAO();
            testeDAO.excluir(teste);

            testes = testeDAO.listar();

            Messages.addGlobalInfo("removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.
                    addFlashGlobalError("Ocorreu um erro ao tentar remover");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento) {
        teste = (Teste) evento.
                getComponent().
                getAttributes().get("classtesteSelecionado");
    }

}
