package br.com.cursojsf.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.cursojsf.business.EstadoBusiness;
import br.com.cursojsf.business.PibInalidoException;
import br.com.cursojsf.model.Estado;

@ManagedBean
@RequestScoped
public class UfBean {
	/** Referencia para a camada de regras de negocio */
	@ManagedProperty("#{estadoBusiness}")
	private EstadoBusiness estadoBusiness;

	/** Usuario a serusado no form. */
	private Estado estados = new Estado();

	public EstadoBusiness getEstadoBusiness() {
		return estadoBusiness;
	}
	
	public void exibir() {
		estados = estadoBusiness.selecionar(estados);
	}

	public void setEstadoBusiness(EstadoBusiness usuarioBusiness) {
		this.estadoBusiness = usuarioBusiness;
	}

	public Estado getEstados() {
		return estados;
	}

	public void setEstados(Estado estado) {
		this.estados = estado;
	}

	public List<Estado> getListaEstados() {
		return estadoBusiness.selecionarTodos();
	}

	public String novo() {
		estados = new Estado();
		return "estadoEditar?faces-redirect=true";
	}

	public boolean salvar(Estado estados) throws PibInalidoException {
		estadoBusiness.salvarEstado(estados);
		//return "usuarios";
		return true;
	}
	public void gravar() throws PibInalidoException{
		if(salvar(estados)){
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"cadastradodo com sucesso!!",""));
			estados = new Estado();
		}
	}
	

	public String excluir() {
		estadoBusiness.excluirEstado(estados);
		return "estado?faces-redirect=true";
	}
}