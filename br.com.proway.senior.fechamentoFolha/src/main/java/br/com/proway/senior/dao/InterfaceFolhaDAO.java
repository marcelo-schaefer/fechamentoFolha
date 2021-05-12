package br.com.proway.senior.dao;

import java.util.List;

import br.com.proway.senior.model.Folha;

/**
 * Interface do CRUD
 * @author senior
 *
 */
public interface InterfaceFolhaDAO {
	
	public List<Folha> getAll();
	//public Folha getFolhasPorId(int id);
	public void insert(Folha folha);
	public void update(Folha folha);
	public void delete(Folha folha);
	//public ArrayList<Folha> getFolhasPorColaborador(int idColaborador);
}