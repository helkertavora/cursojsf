package br.com.cursojsf.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.cursojsf.business.EstadoBusiness;
import br.com.cursojsf.business.PibInalidoException;
import br.com.cursojsf.model.Cidade;

@ManagedBean
@SessionScoped
public class CidadeBean {
	/** Referencia para a camada de regras de negocio */
	@ManagedProperty("#{estadoBusiness}")
	private EstadoBusiness estadoBusiness;

	/** Cidade a serusado no form. */
	private Cidade cidade = new Cidade();

	public EstadoBusiness getEstadoBusiness() {
		return estadoBusiness;
	}
	
	public void exibir() {
		cidade = estadoBusiness.selecionar(cidade);
	}

	public void setEstadoBusiness(EstadoBusiness cidadeBusiness) {
		this.estadoBusiness = cidadeBusiness;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String novo() {
		cidade = new Cidade();
		return "cidadeEditar?faces-redirect=true";
	}

	public boolean salvar(Cidade cidade) throws PibInalidoException {
		estadoBusiness.gravarCidade(cidade);
		//return "usuarios";
		return true;
	}
	public void gravar() throws PibInalidoException{
		if(salvar(cidade)){
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"cadastradodo com sucesso!!",""));
			cidade = new Cidade();
		}
	}
	public String excluir() {
		estadoBusiness.excluirCidade(cidade);
		return "estadoEditar?faces-redirect=true";
	}
}