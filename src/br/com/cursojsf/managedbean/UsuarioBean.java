package br.com.cursojsf.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.cursojsf.business.UsuarioBusiness;
import br.com.cursojsf.model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioBean {
	/** Referencia para a camada de regras de negocio */
	@ManagedProperty("#{usuarioBusiness}")
	private UsuarioBusiness usuarioBusiness;

	/** Usuario a serusado no form. */
	private Usuario usuario = new Usuario();

	public UsuarioBusiness getUsuarioBusiness() {
		return usuarioBusiness;
	}
	
	public void exibir() {
		usuario = usuarioBusiness.selecionar(usuario);
	}

	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return usuarioBusiness.selecionarTodos();
	}

	public String novo() {
		usuario = new Usuario();
		return "usuariosEditar";
	}

	public boolean salvar(Usuario usuario) {
		usuarioBusiness.salvarUsuario(usuario);
		//return "usuarios";
		return true;
	}
	public void gravar(){
		if(salvar(usuario)){
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"cadastradodo com sucesso!!",""));
			usuario = new Usuario();
		}
	}
	

	public String excluir() {
		usuarioBusiness.excluirUsuario(usuario);
		return "usuarios";
	}
}