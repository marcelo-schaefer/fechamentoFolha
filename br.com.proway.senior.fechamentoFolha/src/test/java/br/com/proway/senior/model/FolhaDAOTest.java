package br.com.proway.senior.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.dao.FolhaDAO;
import br.com.proway.senior.dao.PostgresConnector;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.FeriasFolha;
import br.com.proway.senior.model.externo.PontoFolha;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FolhaDAOTest {
	
	@BeforeClass
	public static void initializeDatabase() {
		Folha folha = new Folha(0, 2, LocalDate.now(), 300, 40, 0, 85, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30);
		
		String queryDropTable = "DROP TABLE folha";
		
		String queryCreateTable = "CREATE TABLE public.folha ("
				+ " id serial primary key NOT NULL,"
				+ " idcolaborador integer NOT NULL,"
				+ " dataemissao date NOT NULL,"
				+ " valorhorastrabalhadas numeric NOT NULL,"
				+ " valorhorasfaltas numeric NOT NULL,"
				+ " valorhorasextras numeric NOT NULL,"
				+ " valorreflexodsr numeric NOT NULL,"
				+ " valorinss numeric NOT NULL,"
				+ " valorimpostoderenda numeric NOT NULL,"
				+ " valorplanosaude numeric NOT NULL,"
				+ " valorvaletransporte numeric NOT NULL,"
				+ " salariobruto numeric NOT NULL,"
				+ " salarioliquido numeric NOT NULL,"
				+ " valorferias numeric NOT NULL,"
				+ " valorinssferias numeric NOT NULL,"
				+ " valorimpostoderendaferias numeric NOT NULL,"
				+ " feriasliquido numeric NOT NULL"
				+ ");";
		
		String insert = "INSERT INTO folha (idColaborador, dataEmissao,valorHorasTrabalhadas,valorHorasFaltas, valorHorasExtras,valorReflexoDSR,valorInss,valorImpostoDeRenda,valorPlanoSaude, valorValeTransporte,salarioBruto,salarioLiquido,valorFerias,valorInssFerias,valorImpostoDeRendaFerias,feriasLiquido) "
				+ "VALUES (" + folha.getIdColaborador() + ",'" + folha.getDataEmissao() + "' ,"
				+ folha.getValorHorasTrabalhadas() + "," + folha.getValorHorasFaltas() + ","
				+ folha.getValorHorasExtras() + " , " + folha.getValorReflexoDSR() + " , " + folha.getValorInss()
				+ " , " + folha.getValorImpostoDeRenda() + " , " + folha.getValorPlanoSaude() + " ,  "
				+ folha.getValorValeTransporte() + "," + folha.getSalarioBruto() + "," + folha.getSalarioLiquido() + ","
				+ folha.getValorFerias() + "," + folha.getValorInssFerias() + "," + folha.getValorImpostoDeRendaFerias()
				+ "," + folha.getFeriasLiquido() + " );";
		try {
			PostgresConnector.executeUpdate(queryDropTable);
			PostgresConnector.executeUpdate(queryCreateTable);
			PostgresConnector.executeUpdate(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void cleanDAO() {
		FolhaDAO.newInstance();
	}
 
	@Test
	public void testASalvarFolhaNormalBuilder() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 100, 43);
		PontoFolha ponto = new PontoFolha(220, 2, 1);
		CargoFolha cargo = new CargoFolha(1752, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		director.createFolhaNormal(colab, ponto, cargo);
		Folha folha = builder.build();
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(2, folhaDAO.getAll().size());
	}

	/**
	 * TDD que verifica se o metodo saveFolha esta inserindo novas folhas ao Banco de dados
	 * tabela "folha".
	 */	
	
	@Test
	public void testBSalvarFolhaBuilderHibrida() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 153, 27);
		PontoFolha ponto = new PontoFolha(220, 5.53, 3.67);
		CargoFolha cargo = new CargoFolha(1752, 20);
		FeriasFolha ferias = new FeriasFolha(20, 10);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		director.createFolhaHibrida(colab, ponto, cargo, ferias);
		Folha folha = builder.build();
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(3, folhaDAO.getAll().size());
	}
	
	@Test
	public void testCSalvarFolhaBuilderFerias() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 153, 27);
		PontoFolha ponto = new PontoFolha(0, 0, 0);
		CargoFolha cargo = new CargoFolha(1752, 20);
		FeriasFolha ferias = new FeriasFolha(30, 0);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		director.createFolhaFerias(colab, cargo, ferias);
		Folha folha = builder.build();
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(4, folhaDAO.getAll().size());
	}		
	
	@Test
	public void testEFolhaPorId() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		Folha folha = folhaDAO.getFolhasPorId(3);
		assertEquals(
				"Folha [id=3, idColaborador=1, dataEmissao=2021-05-11,"
				+ " valorHorasTrabalhadas=1972.0000000000002,"
				+ " valorHorasFaltas=32.89654545454546,"
				+ " valorHorasExtras=74.35336363636365,"
				+ " valorReflexoDSR=14.870672727272732,"
				+ " valorInss=223.116024, valorImpostoDeRenda=0.0,"
				+ " valorPlanoSaude=180.0, valorValeTransporte=0.0,"
				+ " salarioBruto=2028.327490909091, salarioLiquido=1625.211466909091,"
				+ " valorFerias=2629.3333333333335, valorInssFerias=289.2266666666667,"
				+ " valorImpostoDeRendaFerias=32.70799999999997,"
				+ " feriasLiquido=2307.3986666666665]",
				folha.toString());
	}
	
	@Test
	public void testFFolhaPorIdColaborador() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		ArrayList<Folha> folhas = folhaDAO.getFolhasPorColaborador(1);
		for (Folha folha : folhas) {
			System.out.println(folha.toString());
		}
		assertEquals(3, folhas.size());
	}
	
	@Test
	public void testGFolhaPorIdColaborador2() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		ArrayList<Folha> folhas = folhaDAO.getFolhasPorColaborador(2);
		for (Folha folha : folhas) {
			System.out.println(folha.toString());
		}
		assertEquals(1, folhas.size());
	}
	
	@Test
	public void testHSelectAllBancoDeDados() {
		FolhaDAO folha = FolhaDAO.getInstance();
		ArrayList<ArrayList<String>> lista = folha.getAll();
		// System.out.println(lista.toString());
		for (ArrayList<String> row : lista) {
			System.out.println(row.toString());
		}
	}
	
	@Test
	public void testIDeleteFolha() {
		FolhaDAO folha = FolhaDAO.getInstance();
		
		int tamanhoTabelaAntes = folha.getAll().size();
		folha.deleteFolha(1);
		int tamanhoTabelaDepois = folha.getAll().size();
		
		assertEquals((tamanhoTabelaAntes - 1), tamanhoTabelaDepois);
	}
	
	@Test
	public void testHUpdateFolha() {
		ColaboradorFolha colab = new ColaboradorFolha(1, true, 98, 18);
		PontoFolha ponto = new PontoFolha(220, 11, 1.63);
		CargoFolha cargo = new CargoFolha(1750, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		director.createFolhaNormal(colab, ponto, cargo);
		Folha folhaAtualizada = builder.build();
		
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		Folha folhaAnterior = folhaDAO.getFolhasPorId(3);
		
		
		folhaDAO.updateFolha(folhaAtualizada, 3);
		
		assertNotEquals(folhaAtualizada.getSalarioLiquido(), folhaAnterior.getSalarioLiquido(), 0.01);
	}	
	
	@Test
	public void versaoIDB() {		
		assertEquals("PostgreSQL 13.2, compiled by Visual C++ build 1914, 64-bit",PostgresConnector.dbVersion());
	}
	
	@Ignore
	public void testeJReiniciarDB() {
		String query = "TRUNCATE folha; ALTER SEQUENCE folha_id_seq RESTART 1;";
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		try {
			if (PostgresConnector.con == null) {
				PostgresConnector.connect();
			}
			PostgresConnector.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(0, folhaDAO.getAll().size());
	}
}
