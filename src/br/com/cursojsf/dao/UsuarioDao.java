package br.com.cursojsf.dao;

import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.cursojsf.model.Cep;
import br.com.cursojsf.model.Usuario;

/**
 * DAO da entidade Usuario.
 * 
 */
@ApplicationScoped
@ManagedBean(name = "usuarioDao")
public class UsuarioDao extends SimpleDaoGenerico<Usuario> {

	public UsuarioDao() {
		Calendar dataNascimento = Calendar.getInstance();

		Usuario usuario = new Usuario();
		Cep cep = new Cep();
		cep.setRegiao("33333");
		cep.setSufixo("999");
		usuario.setNomeReduzido("Pedro de Alcantara");
		usuario.setNomeCompleto("Pedro de Alcantara Francisco Antanio "
				+ "Joao Carlos Xavier de Paula Miguel Rafael Joaquim Jose "
				+ "Gonzaga Pascoal Cipriano Serafim de Braganca e Bourbon");
		usuario.setEmail("pedro.alcantara@gmail.com");
		usuario.setCep(cep);
		usuario.setSenha("teste");
		usuario.setCpf("11111111111");
		dataNascimento.set(1798, 9, 12);
		usuario.setDataNascimento(dataNascimento.getTime());
		super.salvarEntidade(usuario);

		usuario = new Usuario();
		Cep cep1 = new Cep();
		cep1.setRegiao("33333");
		cep1.setSufixo("999");
		usuario.setNomeReduzido("Santos Dumont");
		usuario.setNomeCompleto("Alberto Santos Dumont");
		usuario.setEmail("santos.dumont@gmail.com");
		usuario.setCep(cep1);
		usuario.setSenha("teste");
		usuario.setCpf("22222222222");
		dataNascimento.set(1873, 6, 20);
		usuario.setDataNascimento(dataNascimento.getTime());
		super.salvarEntidade(usuario);

		usuario = new Usuario();
		Cep cep2 = new Cep();
		cep2.setRegiao("87654");
		cep2.setSufixo("009");
		usuario.setNomeReduzido("Isabel de Braganca");
		usuario.setNomeCompleto("Isabel Cristina Leopoldina Augusta "
				+ "Micaela Gabriela Rafaela Gonzaga de Braganca e Bourbon");
		usuario.setEmail("maria@gmail.com");
		usuario.setCep(cep2);
		usuario.setSenha("teste");
		usuario.setCpf("33333333333");
		dataNascimento.set(1846, 6, 29);
		usuario.setDataNascimento(dataNascimento.getTime());
		super.salvarEntidade(usuario);
	}

	/**
	 * Insere o usuario na base de dados.
	 * 
	 * @param usuario
	 *            Usuario a ser persistida.
	 */
	public void salvarUsuario(Usuario usuario) {
		super.salvarEntidade(usuario);
	}

	/**
	 * Exclui o usuario na base de dados.
	 * 
	 * @param usuario
	 *            usuario a ser excluido
	 */
	public void excluirUsuario(Usuario usuario) {
		super.excluirEntidade(usuario);
	}

	/**
	 * Seleciona todos os registros aramzenados de um usuario {@link Usuario}.
	 * 
	 * @return lista de {@link Usuario}
	 */
	@Override
	public Usuario selecionar(Usuario usuario) {
		return super.selecionar(usuario);
	}

	/**
	 * Seleciona os usuarios que possuem atributos que correspondam aos
	 * atributos setados no usuario exemplo.
	 * 
	 * @param usuario
	 *            Usuario contendo os parametros da consulta.
	 * @return a usuario que corresponde ao parametro da consulta.
	 */
	@Override
	public List<Usuario> selecionarTodos() {
		return super.selecionarTodos();
	}

	/**
	 * Seleciona o usuario que possue o CPF que corresponda ao parametro.
	 * 
	 * @param cpf
	 *            CPF do usuario desejado
	 * @return {@link Usuario} correspondente ou null caso nao seja encontrado.
	 */
	public Usuario selecionar(String cpf) {
		List<Usuario> usuarios = selecionarTodos();
		for (Usuario usuarioLista : usuarios) {
			if (usuarioLista.getCpf().equals(cpf)) {
				return usuarioLista;
			}
		}

		return null;
	}
}
