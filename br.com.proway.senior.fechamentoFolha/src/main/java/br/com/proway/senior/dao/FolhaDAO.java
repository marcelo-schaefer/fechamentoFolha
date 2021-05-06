package br.com.proway.senior.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import br.com.proway.senior.model.Folha;

public final class FolhaDAO implements InterfaceFolhaDAO {

	private static FolhaDAO instance;

	private FolhaDAO() {
	}
	
	/**
	 * Metodo getInstance que retorna uma inst�ncia FolhaDAO
	 * @return instance
	 */
	public static FolhaDAO getInstance() {
		if (instance == null) {
			instance = new FolhaDAO();
		}
		return instance;
	}

	/**
	 * Busca todas as folhas cadastradas na tabela "folha" do banco de dados "FechamentoFolha"
	 * utilizando a classe PostgresConnector para a conexao com o banco e com query SELECT traz
	 * todas as linhas/colunas encontradas.
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
	 * Metodo de consulta de folhas por ID
	 * Busca todas as folhas cadastradas na tabela "folha" do banco de dados "FechamentoFolha"
	 * utilizando a classe PostgresConnector para a conexao com o banco e com query SELECT traz
	 * as informa��es de folha consultada por ID.
	 * 	 * 
	 * @param id da folha desejada
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

	/**
	 * Metodo de consulta de Folhas Por Colaborador
	 * Busca todas as folhas cadastradas na tabela "folha" do banco de dados "FechamentoFolha"
	 * utilizando a classe PostgresConnector para a conexao com o banco e com query SELECT traz
	 * as informa��es de folha de um determinado Colaborador com a pesquisa feita pelo ID.
	 * 	 * 
	 * @param id do colaborador desejado
	 * @return folhas
	 */
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
	 * Metodo de salvamento de Folha.
	 * Atraves deste metodo o codigo salva os parametros que o usu�rio passou atraves
	 * dos "gets" no Banco de dados. 
	 * Recebe um objeto e salva na lista do objeto
	 * 
	 * @param Folha folha, folha que sera adicionada
	 */
	public void saveFolha(Folha folha) {
		String insert = "INSERT INTO folha (idColaborador, dataEmissao,valorHorasTrabalhadas,valorHorasFaltas, valorHorasExtras,valorReflexoDSR,valorInss,valorImpostoDeRenda,valorPlanoSaude, valorValeTransporte,salarioBruto,salarioLiquido,valorFerias,valorInssFerias,valorImpostoDeRendaFerias,feriasLiquido) "
				+ "VALUES (" + folha.getIdColaborador() + ",'" + folha.getDataEmissao() + "' ,"
				+ folha.getValorHorasTrabalhadas() + "," + folha.getValorHorasFaltas() + ","
				+ folha.getValorHorasExtras() + " , " + folha.getValorReflexoDSR() + " , " + folha.getValorInss()
				+ " , " + folha.getValorImpostoDeRenda() + " , " + folha.getValorPlanoSaude() + " ,  "
				+ folha.getValorValeTransporte() + "," + folha.getSalarioBruto() + "," + folha.getSalarioLiquido() + ","
				+ folha.getValorFerias() + "," + folha.getValorInssFerias() + "," + folha.getValorImpostoDeRendaFerias()
				+ "," + folha.getFeriasLiquido() + " )";
		try {
			if (PostgresConnector.con == null) {
				PostgresConnector.connect();
			}
			PostgresConnector.executeUpdate(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo de Atualizacao das alteracoes de uma folha
	 * 
	 * Recebe uma folha nova e o id do objeto e substitui na lista do objeto 
	 * @param int   id, id da folha que ser� atualizada
	 *  
	 */
	public void updateFolha(Folha folha, int id) {
		try {
			if (PostgresConnector.con == null) {
				PostgresConnector.connect();
			}

			String update = "UPDATE folha SET idColaborador = " + folha.getIdColaborador() + ", dataEmissao = '"
					+ folha.getDataEmissao() + "', valorHorasTrabalhadas = " + folha.getValorHorasTrabalhadas()
					+ ", valorHorasFaltas = " + folha.getValorHorasFaltas() + ", valorHorasExtras = "
					+ folha.getValorHorasExtras() + ", valorReflexoDSR = " + folha.getValorReflexoDSR()
					+ ", valorInss = " + folha.getValorInss() + ", valorImpostoDeRenda = "
					+ folha.getValorImpostoDeRenda() + ", valorPlanoSaude = " + folha.getValorPlanoSaude()
					+ ", valorValeTransporte = " + folha.getValorValeTransporte() + ", salarioBruto = "
					+ folha.getSalarioBruto() + ", salarioLiquido = " + folha.getSalarioLiquido() + ", valorFerias = "
					+ folha.getValorFerias() + ", valorInssFerias = " + folha.getValorInssFerias()
					+ ", valorImpostoDeRendaFerias = " + folha.getValorImpostoDeRendaFerias() + ", feriasLiquido = "
					+ folha.getFeriasLiquido() + " WHERE id = " + id;

			PostgresConnector.executeUpdate(update);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo de remo��o de uma folha de pagamento.
	 * 
	 * Recebe um id e deleta do Banco de dados a linha.
	 * @param int id, folha que ser� deletada.
	 * 
	 */
	public void deleteFolha(int id) {
		try {
			if (PostgresConnector.con == null) {
				PostgresConnector.connect();
			}

			String delete = "DELETE FROM folha where id = " + id;
			PostgresConnector.executeUpdate(delete);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
