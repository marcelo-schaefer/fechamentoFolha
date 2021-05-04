package br.com.proway.senior.model;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class FolhaDAOTest {

	/**
	 * TDD que testa a conexao ao Banco dados considerando seus metadados.
	 */
	@Test
	public void testDbVersion() {
		String version = PostgresConnector.dbVersion();
		assertEquals("PostgreSQL 13.2, compiled by Visual C++ build 1914, 64-bit", version);
	}

	/**
	 * TDD que verifica a inserção de dados em folha
	 */

	@Ignore
	public void testInsert() {
		String insert = "INSERT INTO folha (idColaborador, dataEmissao,valorHorasTrabalhadas,valorHorasFaltas, doublevalorHorasExtras,valorReflexoDSR,valorInss,valorImpostoDeRenda,valorPlanoSaude, valorValeTransporte,salarioBruto,salarioLiquido,valorFerias,valorInssFerias,valorImpostoDeRendaFerias,feriasLiquido) VALUES (2,'2021-05-04',10.00,20.00,30.00,40.00,500.00,600.00,200.00,100.00,2020.00,1200.53,1170.00,225.00,250.00,1500.00)";
		try {
			if (PostgresConnector.con == null) {
				PostgresConnector.connect();
			}
			PostgresConnector.executeUpdate(insert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * TDD que verifica se o metodo getAll esta trazendo todas as linhas/colunas da
	 * tabela "folha".
	 */

	@Test
	public void testeSelectAllBancoDeDados() {
		FolhaDAO folha = FolhaDAO.getInstance();
		ArrayList<ArrayList<String>> lista = folha.getAll();
		// System.out.println(lista.toString());
		for (ArrayList<String> row : lista) {
			System.out.println(row.toString());
		}

	}

	/**
	 * TDD que verifica se o metodo saveFolha esta inserindo novas folhas ao Banco de dados
	 * tabela "folha".
	 */	
	
	@Test
	public void testeInserirFolhaBancoDeDados() {
		FolhaDAO folha = FolhaDAO.getInstance();
		Folha folhaTeste = new Folha(0, 2, LocalDate.of(2021, 5, 4), 10.00, 20.00, 30.00, 40.00, 500.00, 600.00, 200.00,
				100.00, 2020.00, 1200.53, 1170.00, 225.00, 250.00, 1500.00);
		folha.saveFolha(folhaTeste);
	}
	
	/**
	 * TDD que verifica se o metodo updateFolha esta alterando informações quando se passa um ID
	 * de colaborador.
	 */

	@Test
	public void testeUpdateFolha() {
		FolhaDAO folha = FolhaDAO.getInstance();
		Folha folhaTeste = new Folha(0, 2, LocalDate.of(2021, 6, 5), 80.00, 90.00, 50.00, 40.00, 5800.00, 600.00,
				700.00, 100.00, 2020.00, 1200.53, 1170.00, 225.00, 250.00, 1500.00);
		folha.updateFolha(folhaTeste, 30);
	}

	/**
	 * TDD que verifica se o metodo deletefolha esta apagando as informações quando se passa um ID
	 * de colaborador.
	 */
	@Test
	public void testeDeleteFolha() {
		FolhaDAO folha = FolhaDAO.getInstance();
		folha.deleteFolha(30);
	}

	@Test
	public void testeFolhaPorId() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		Folha folha = folhaDAO.getFolhasPorId(31);
		System.out.println(folha.toString());

	}

	@Test
	public void testeFolhaPorIdColaborador() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		ArrayList<Folha> folhas = folhaDAO.getFolhasPorColaborador(10);
		for (Folha folha : folhas) {
			System.out.println(folha.toString());
		}

	}

	@Ignore
	public void cleanDb() {
		String delete = "DELETE FROM folha";

		try {
			PostgresConnector.executeUpdate(delete);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
