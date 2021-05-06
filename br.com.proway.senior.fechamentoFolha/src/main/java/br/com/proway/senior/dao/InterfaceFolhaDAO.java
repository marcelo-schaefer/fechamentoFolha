package br.com.proway.senior.dao;

import java.util.ArrayList;

import br.com.proway.senior.model.Folha;

/**
 * Interface do CRUD
 * @author senior
 *
 */
public interface InterfaceFolhaDAO {
	
	public ArrayList<ArrayList<String>> getAll();
	public Folha getFolhasPorId(int id);
	public void saveFolha(Folha folha);
	public void updateFolha(Folha folha, int id);
	public void deleteFolha(int id);
	public ArrayList<Folha> getFolhasPorColaborador(int idColaborador);
}