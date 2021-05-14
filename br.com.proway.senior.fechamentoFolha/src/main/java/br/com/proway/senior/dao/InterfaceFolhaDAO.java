package br.com.proway.senior.dao;

import java.util.List;

import br.com.proway.senior.model.Folha;

/**
 * Interface do CRUD
 * Metodos implementados pela classe {@link FolhaDAO}.
 * 
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
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