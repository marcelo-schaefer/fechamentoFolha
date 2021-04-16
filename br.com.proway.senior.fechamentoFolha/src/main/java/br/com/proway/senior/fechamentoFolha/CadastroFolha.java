package br.com.proway.senior.fechamentoFolha;

import java.util.ArrayList;

public class CadastroFolha {

	private ArrayList<Folha> folhas = new ArrayList<Folha>();		

	public ArrayList<Folha> getFolhas() {
		return folhas;
	}

	public void setFolhas(Folha f) {
		this.folhas.add(f);
	}	
	
}
