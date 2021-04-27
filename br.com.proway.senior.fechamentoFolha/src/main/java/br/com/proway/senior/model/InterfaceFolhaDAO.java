package br.com.proway.senior.model;

import java.util.ArrayList;

public interface InterfaceFolhaDAO {
	
	public ArrayList<Folha> getAll();
	
	public Folha getFolhasPorId(int id);
	
	public Folha getFolhaPorDataEId(String data, int id);

	public void saveFolha(Folha folha);
	
	public boolean updateFolha(Folha folha, int id);
	
	public boolean removeFolha(int id);
	
	public Folha getFolhaIdColaborador(Integer idColaborador);
	
	
}