package br.com.proway.senior.model;

public abstract class Pessoa { // Abstract
	
	protected int id;
	protected String nome;
	protected String email;
		
	public Pessoa(String nome, int id, String email) {
		this.nome = nome;
		this.id = id;
		this.email = email;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
