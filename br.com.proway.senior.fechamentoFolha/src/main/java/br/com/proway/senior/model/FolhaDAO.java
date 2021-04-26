package br.com.proway.senior.model;

import java.util.ArrayList;

import br.com.proway.senior.model.Interfaces.InterfaceFolhaDAO;

public final class FolhaDAO implements InterfaceFolhaDAO{

	private static FolhaDAO instance;
	private ArrayList<Folha> listaFolhas; 
	
	private FolhaDAO(ArrayList<Folha> listaFolhas) {
		setListaFolhas(listaFolhas);
	}
	
	public static FolhaDAO getInstance(ArrayList<Folha> listaFolhas) {
		if(instance == null) {
			instance = new FolhaDAO(listaFolhas);
		}
		return instance;
	}
	
	/**
	 * Busca todas as folhas cadastradas
	 * 
	 * @return folhas
	 */
	public ArrayList<Folha> getAll(){
		return listaFolhas;
	}
	
	/**
	 * Busca todas as folhas do usuário com determinado id
	 * 
	 * @param id do usuário desejado
	 * 
	 * @return folhas
	 */
	public ArrayList<Folha> getFolhasPorId(int id){
		ArrayList<Folha> folhas = new ArrayList<Folha>();
		return folhas;
	}
	
	/**
	 * Busca todas a folha de um determinado usuário e determinada data
	 * 
	 * @param data da folha desejada
	 * @param id do usuário desejado
	 * @return folhas
	 */
	public ArrayList<Folha> getFolhaPorDataEId(String data, int id){
		ArrayList<Folha> folhas = new ArrayList<Folha>();
		return folhas;
	}

	public void setListaFolhas(ArrayList<Folha> listaFolhas) {
		this.listaFolhas = listaFolhas;
	}
	
	public void saveFolha(Folha folha) {
		this.listaFolhas.add(folha);
	}
	
	
	
}
