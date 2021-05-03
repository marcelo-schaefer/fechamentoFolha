package br.com.proway.senior.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public final class FolhaDAO implements InterfaceFolhaDAO {

	private static FolhaDAO instance;
//	private ArrayList<Folha> listaFolhas = new ArrayList<Folha>();

	private FolhaDAO() {
	}

	public static FolhaDAO getInstance() {
		if (instance == null) {
			instance = new FolhaDAO();
		}
		return instance;
	}

	/**
	 * Busca todas as folhas cadastradas na tabela folha do banco de dados
	 * 
	 * @return ArrayList<ResultSet>
	 */
	public ArrayList<ArrayList<String>> getAll() {

		ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
		String select = "SELECT * FROM folha";
		ResultSet rs;
		try {
			if (PostgresConnector.con == null){
				PostgresConnector.connect();
			}
			rs = PostgresConnector.executeQuery(select);
			ResultSetMetaData rsmd = rs.getMetaData();
			int todasAsColunas = rsmd.getColumnCount();
			while (rs.next()) {
				ArrayList<String> linha = new ArrayList<>();
				for (int i = 1; i <= todasAsColunas; i++) {
					linha.add(rs.getString(i));
				}
				lista.add(linha);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;

	}

	/**
	 * Busca todas as folhas do usuário com determinado id
	 * 
	 * @param id do usuário desejado
	 * 
	 * @return folhas
	 */
	public Folha getFolhasPorId(int id) {
		for (Folha folha : listaFolhas) {
			if (folha.getId() == id) {
				return folha;
			}
		}
		return null;
	}

	// TODO
	public ArrayList<Folha> getFolhasPorColaborador(int idColaborador) {
		return null;
	}

	/**
	 * Busca todas a folha de um determinado usuário e determinada data
	 * 
	 * @param data da folha desejada
	 * @param id   do usuário desejado
	 * @return folhas
	 */
	public Folha getFolhaPorDataEId(String data, int idColaborador) {
		for (Folha folha : listaFolhas) {
			String dataEmissao = folha.getDataEmissao();
			if (dataEmissao != null && dataEmissao.equals(data) && folha.getIdColaborador() == idColaborador) {
				return folha;
			}
		}
		return null;
	}

	/**
	 * Salva nova folha
	 * 
	 * Recebe um objeto e salva na lista do objeto
	 * 
	 * @param Folha folha, folha que sera adicionada
	 */
	public void saveFolha(Folha folha) {
		this.listaFolhas.add(folha);
	}

	/**
	 * Atualiza folha
	 * 
	 * Recebe uma folha nova e o id do objeto e substitui na lista do objeto
	 * 
	 * @param Folha folha, objeto atualizado
	 * @param int   id, id da folha que será atualizada
	 * 
	 * @return boolean, retorna se foi atualizado, ou não.
	 * 
	 */
	public boolean updateFolha(Folha folha, int id) {
		for (Folha up : listaFolhas) {
			if (up.getId() == id) {
				int i = listaFolhas.indexOf(up);
				listaFolhas.remove(i);
				listaFolhas.add(i, folha);
				return true;
			}
		}
		return false;

	}

	/**
	 * Remove folha.
	 * 
	 * Recebe um id e deleta da lista.
	 * 
	 * @param int id, folha que será deletada.
	 * 
	 * @return boolean, retorna se foi deletado, ou nao.
	 * 
	 */

	public boolean removeFolha(int id) {
		for (Folha folha : listaFolhas) {
			if (folha.getId() == id) {
				listaFolhas.remove(folha);
				return true;
			}
		}
		return false;

	}

	/**
	 * Busca por IdColaborador
	 * 
	 * Busca a folha na listaFolhas através do idColaborador
	 * 
	 * @param Integer idColaborador, id de busca
	 * 
	 * @retorn Folha, objeto inteiro da folha
	 * 
	 */

	public Folha getFolhaIdColaborador(Integer idColaborador) {
		for (Folha folha : listaFolhas) {
			if (folha.getIdColaborador() == idColaborador) {
				return folha;
			}
		}
		return null;
	}

}
