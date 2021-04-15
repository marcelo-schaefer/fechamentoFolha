package br.com.proway.senior.fechamentoFolha;

import java.util.ArrayList;

public class CadastroColaborador {
	
	private ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();

	public ArrayList<Colaborador> getColaboradores() {
		return colaboradores;
	}

	//TODO colocar add no lugar do set
	public void setColaboradores(Colaborador c) {
		this.colaboradores.add(c);
	}	
	
}
