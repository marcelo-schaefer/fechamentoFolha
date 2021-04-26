package br.com.proway.senior.model.Interfaces;

import java.util.ArrayList;

import br.com.proway.senior.model.Folha;

public interface InterfaceFolhaDAO {
	
	public ArrayList<Folha> getAll();
	
	public ArrayList<Folha> getFolhasPorId(int id);
	
	public ArrayList<Folha> getFolhaPorDataEId(String data, int id);

	public void setListaFolhas(ArrayList<Folha> listaFolhas);
	
	public void saveFolha(Folha folha);
	
}