package br.com.proway.senior.fechamentoFolha;

import java.util.ArrayList;

public final class CadastroColaborador {
	
	private ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();

	public ArrayList<Colaborador> getColaboradores() {
		return colaboradores;
	}
	
	/**
	 * Cadastra Colaborador
	 * 
	 * Adiciona um Colaborador na lista de cadastros totais do sistema
	 * 
	 * @param c; Objeto da classe Colaborador
	 */
	public void addColaboradores(Colaborador c) {
		this.colaboradores.add(c);
	}	
	
}
