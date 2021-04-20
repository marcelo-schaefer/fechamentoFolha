package br.com.proway.senior.fechamentoFolha;

import java.util.ArrayList;

public final class CadastroColaborador {
	
	private ArrayList<ColaboradorFolha> colaboradores = new ArrayList<ColaboradorFolha>();

	public ArrayList<ColaboradorFolha> getColaboradores() {
		return colaboradores;
	}
	
	/**
	 * Cadastra Colaborador
	 * 
	 * Adiciona um Colaborador na lista de cadastros totais do sistema
	 * 
	 * @param c; Objeto da classe Colaborador
	 */
	public void addColaboradores(ColaboradorFolha c) {
		this.colaboradores.add(c);
	}	
	
}
