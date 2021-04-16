package br.com.proway.senior.fechamentoFolha;

import java.util.ArrayList;

public class CadastroColaborador {
	
	private ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();

	public ArrayList<Colaborador> getColaboradores() {
		return colaboradores;
	}
	
	public void addColaboradores(Colaborador c) {
		this.colaboradores.add(c);
	}	
	
}
