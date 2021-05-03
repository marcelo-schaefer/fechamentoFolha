package br.com.proway.senior.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
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
	 * @return ArrayList<ArrayList<String>
	 */
	public ArrayList<ArrayList<String>> getAll() {

		ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
		String select = "SELECT * FROM folha";
		ResultSet rs;
		try {
			if (PostgresConnector.con == null) {
				PostgresConnector.connect();
			}
			rs = PostgresConnector.executeQuery(select);
			ResultSetMetaData rsmd = rs.getMetaData();
			int todasAsColunas = rsmd.getColumnCount();
			while (rs.next()) {
				ArrayList<String> linha = new ArrayList<String>();
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
		try {
			if (PostgresConnector.con == null) {
				PostgresConnector.connect();
			}
			String select = "SELECT * FROM folha WHERE id =" + id;
			ResultSet rs;
			rs = PostgresConnector.executeQuery(select);
			ResultSetMetaData rsmd = rs.getMetaData();
			if (rs.next()) {
				Integer idColaborador = Integer.parseInt(rs.getString(2));
				LocalDate dataEmissao = LocalDate.parse(rs.getString(3));
				double valorHorasTrabalhadas = Double.parseDouble(rs.getString(4));
				double valorHorasFaltas = Double.parseDouble(rs.getString(5));
				double valorHorasExtras = Double.parseDouble(rs.getString(6));
				double valorReflexoDSR = Double.parseDouble(rs.getString(7));
				double valorInss = Double.parseDouble(rs.getString(8));
				double valorImpostoDeRenda = Double.parseDouble(rs.getString(9));
				double valorPlanoSaude = Double.parseDouble(rs.getString(10));
				double valorValeTransporte = Double.parseDouble(rs.getString(11));
				double salarioBruto = Double.parseDouble(rs.getString(12));
				double salarioLiquido = Double.parseDouble(rs.getString(13));
				double valorFerias = Double.parseDouble(rs.getString(14));
				double valorInssFerias = Double.parseDouble(rs.getString(15));
				double valorImpostoDeRendaFerias = Double.parseDouble(rs.getString(16));
				double feriasLiquido = Double.parseDouble(rs.getString(17));
				return new Folha(id, idColaborador, dataEmissao, valorHorasTrabalhadas, valorHorasFaltas,
						valorHorasExtras, valorReflexoDSR, valorInss, valorImpostoDeRenda, valorPlanoSaude,
						valorValeTransporte, salarioBruto, salarioLiquido, valorFerias, valorInssFerias,
						valorImpostoDeRendaFerias, feriasLiquido);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Folha> getFolhasPorColaborador(int idColaborador) {
		try {
			if (PostgresConnector.con == null) {
				PostgresConnector.connect();
			}
			ArrayList<Folha> listaFolhas = new ArrayList<Folha>();
			String select = "SELECT * FROM folha WHERE idColaborador =" + idColaborador;
			ResultSet rs;
			rs = PostgresConnector.executeQuery(select);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numeroDeFolhas = rsmd.getColumnCount() / 17;
			while (rs.next()) {
				Integer id = rs.getInt("id");
				LocalDate dataEmissao = rs.getDate("dataemissao").toLocalDate();
				double valorHorasTrabalhadas = rs.getDouble("valorhorastrabalhadas");
				double valorHorasFaltas = rs.getDouble("valorhorasfaltas");
				double valorHorasExtras = rs.getDouble("valorhorastrabalhadas");
				double valorReflexoDSR = rs.getDouble("valorreflexodsr");
				double valorInss = rs.getDouble("valorinss");
				double valorImpostoDeRenda = rs.getDouble("valorimpostoderenda");
				double valorPlanoSaude = rs.getDouble("valorplanosaude");
				double valorValeTransporte = rs.getDouble("valorvaletransporte");
				double salarioBruto = rs.getDouble("salariobruto");
				double salarioLiquido = rs.getDouble("salarioliquido");
				double valorFerias = rs.getDouble("valorferias");
				double valorInssFerias = rs.getDouble("valorinssferias");
				double valorImpostoDeRendaFerias = rs.getDouble("valorimpostoderendaferias");
				double feriasLiquido = rs.getDouble("feriasliquido");
				Folha temp = new Folha(id, idColaborador, dataEmissao, valorHorasTrabalhadas, valorHorasFaltas,
						valorHorasExtras, valorReflexoDSR, valorInss, valorImpostoDeRenda, valorPlanoSaude,
						valorValeTransporte, salarioBruto, salarioLiquido, valorFerias, valorInssFerias,
						valorImpostoDeRendaFerias, feriasLiquido);
				listaFolhas.add(temp);

			}
			return listaFolhas;

		} catch (Exception e) {
			e.printStackTrace();
		}
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
