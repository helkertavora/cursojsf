package br.com.cursojsf.model;

import java.io.Serializable;

public class Cep extends BaseModel implements Serializable{

	private static final long serialVersionUID = -6678136348788883976L;

	private String regiao;
	private String sufixo;
	
	public Cep(){	
	}
	public Cep(String regiao, String sufixo) {
		this.regiao = regiao;
		this.sufixo = sufixo;
	}
	
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public String getSufixo() {
		return sufixo;
	}
	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}

	@Override
	public String toString() {
		return regiao + "-" + sufixo;
	}
	
	
	
}
