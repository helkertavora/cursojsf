package br.com.cursojsf.business;

/**
 * Execao de validacao de PIB.
 */
public class PibInalidoException extends Exception {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 8513843675676480854L;

	public PibInalidoException() {
		super("Valor do PIB nao pode ser menor que a populacao!");
	}
}
