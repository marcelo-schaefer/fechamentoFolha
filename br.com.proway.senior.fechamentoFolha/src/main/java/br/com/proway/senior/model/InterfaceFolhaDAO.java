package br.com.proway.senior.model;

import java.util.ArrayList;

public interface InterfaceFolhaDAO {
	
	public ArrayList<Folha> getAll();
	
	public ArrayList<Folha> getFolhasPorId(int id);
	
	public ArrayList<Folha> getFolhaPorDataEId(String data, int id);

	public void saveFolha(Folha folha);
	
}