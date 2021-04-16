package br.com.proway.senior.fechamentoFolha;

public class Folha {

	int id;
	String data;
	
	public Folha(int id, String data) {
		this.id = id;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
		
}
