package br.com.proway.senior.model;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface InterfaceFolhaDAO {
	
	public ArrayList<ArrayList<String>> getAll();
	
	public Folha getFolhasPorId(int id);
	
	public Folha getFolhaPorDataEId(String data, int id);

	public void saveFolha(Folha folha);
	
	public boolean updateFolha(Folha folha, int id);
	
	public boolean removeFolha(int id);
	
	public ArrayList<Folha> getFolhaIdColaborador(Integer idColaborador);
	
	
}