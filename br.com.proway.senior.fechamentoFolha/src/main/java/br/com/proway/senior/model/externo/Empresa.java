package br.com.proway.senior.model.externo;

import java.util.ArrayList;

public class Empresa {
	private String nome;
	private ArrayList<ColaboradorFolha> colaboradores;
	private ArrayList<SetorFolha> setores;
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the colaboradores
	 */
	public ArrayList<ColaboradorFolha> getColaboradores() {
		return colaboradores;
	}
	/**
	 * @param colaboradores the colaboradores to set
	 */
	public void setColaboradores(ArrayList<ColaboradorFolha> colaboradores) {
		this.colaboradores = colaboradores;
	}
	/**
	 * @return the setores
	 */
	public ArrayList<SetorFolha> getSetores() {
		return setores;
	}
	/**
	 * @param setores the setores to set
	 */
	public void setSetores(ArrayList<SetorFolha> setores) {
		this.setores = setores;
	}
	
	
}
