package br.com.cursojsf.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.cursojsf.model.Cidade;
import br.com.cursojsf.model.Estado;

/**
 * DAO da entidade Estado.
 * 
 */
@ApplicationScoped
@ManagedBean(name = "estadoDao")
public class EstadoDao extends SimpleDaoGenerico<Estado> {

	

	public EstadoDao() {
		for (int i = 1; i <= 5; i++) {
			List<Cidade> cidades = new ArrayList<Cidade>();
			Estado estado = new Estado();
			estado.setNome("Nome do estado " + i);
			estado.setSigla("ESTADO: " + i);
		for (int j = 1; j <= 5; j++) {
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.set(1798 + (j * 3), 9 - j, 12 + j);
			String cidAtual = ""; 
			if(j == 1){ cidAtual = "Fortaleza";}else if(j == 2){cidAtual = "Salavador";}else if(j == 3){ cidAtual = "Recife";}else if(j == 4){cidAtual = "Salavador";}
			else{ cidAtual = "Rio de Janeiro"; };
			Cidade cid = new Cidade(1L + j , cidAtual , 12876654L * j, dataNascimento.getTime(), 123.00 *(2 * j), estado);
			cidades.add(cid);
		}
		estado.setCidades(cidades);
		salvarEntidade(estado);
	  }		
	}
	
	/**
	 * Insere o estado na base de dados.
	 * 
	 * @param estado
	 *            Estado a ser persistida.
	 */
	public void salvarEstado(Estado estado) {
		super.salvarEntidade(estado);
	}

	/**
	 * Exclui o estado na base de dados.
	 * 
	 * @param estado
	 *            estado a ser excluido
	 */
	public void excluirEstado(Estado estado) {
		super.excluirEntidade(estado);
	}

	/**
	 * Seleciona todos os registros aramzenados de um estado {@link Estado}.
	 * 
	 * @return lista de {@link Estado}
	 */
	@Override
	public Estado selecionar(Estado estado) {
		return super.selecionar(estado);
	}

	/**
	 * Seleciona as estados que possuem atributos que correspondam aos atributos
	 * setados no estado exemplo.
	 * 
	 * @param estado
	 *            Estado contendo os parametros da consulta.
	 * @return a estado que corresponde ao parametro da consulta.
	 */
	@Override
	public List<Estado> selecionarTodos() {
		return super.selecionarTodos();
	}

}
