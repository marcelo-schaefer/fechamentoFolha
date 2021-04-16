package br.com.proway.senior.fechamentoFolha;

public class Pessoa { // Abstract
	
	protected int id;
	protected String nome;
		
	public Pessoa(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}
	
	//public abstract void interagir();

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
	
}
