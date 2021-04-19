package br.com.proway.senior.fechamentoFolha;

import java.util.ArrayList;

public final class CadastroColaborador {
	
	private ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();

	public ArrayList<Colaborador> getColaboradores() {
		return colaboradores;
	}
	
	/**
	 * Cadastra um novo Colaborador
	 * 
	 * Adiciona um Colaborador ao ArrayList de Cadastro de colaboradores
	 * do sistema
	 * 
	 * @param c; Objeto da classe colaborador
	 */
	public void addColaboradores(Colaborador c) {
		this.colaboradores.add(c);
	}	
	
}
