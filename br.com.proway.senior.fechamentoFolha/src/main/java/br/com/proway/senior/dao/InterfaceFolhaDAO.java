package br.com.proway.senior.dao;

import java.util.List;

import br.com.proway.senior.model.Folha;

/**
 * <h1>Interface do CRUD</h1>
 * 
 * <p>Metodos implementados pela classe {@link FolhaDAO}.</p>
 * 
 * @author Sprint 5: Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Sprint 5: Bruna Carvalho <sh4323202@gmail.com>;
 * @author Sprint 5: Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sprint 5: Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Sprint 5: Lucas Nunes <lucasnunes.ln365@gmail.com>.
 *
 * @see FolhaDAO
 */
public interface InterfaceFolhaDAO {
	
	public List<Folha> getAll();
	//public Folha getFolhasPorId(int id);
	public void insert(Folha folha);
	public void update(Folha folha);
	public void delete(Folha folha);
	//public ArrayList<Folha> getFolhasPorColaborador(int idColaborador);
}