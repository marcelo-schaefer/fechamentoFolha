package br.com.proway.senior.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;


import br.com.proway.senior.dao.FolhaDAO;
import br.com.proway.senior.dao.PostgresConnector;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.PontoFolha;

public class FolhaDAOTest {
 
	@Test
	public void testSalvarFolhaNormalBuilder() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 100, 43, 205);
		PontoFolha ponto = new PontoFolha(220, 2, 1);
		CargoFolha cargo = new CargoFolha(1752, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		Folha folha = director.createFolhaNormal(colab, ponto, cargo);
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		folhaDAO.insert(folha);
		
		assertEquals(5, folhaDAO.getAll().size());
	}
	
	@Test
	public void testDeletarFolhaNormalBuilder() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 100, 43, 205);
		PontoFolha ponto = new PontoFolha(220, 2, 1);
		CargoFolha cargo = new CargoFolha(1752, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		Folha folha = director.createFolhaNormal(colab, ponto, cargo);
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		folhaDAO.insert(folha);
		folhaDAO.delete(folha);
		
		assertEquals(4, folhaDAO.getAll().size());
	}
	
	@Test
	public void testAtualizarFolhaNormalBuilder() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		Folha primeiraFolha = folhaDAO.getAll().get(folhaDAO.getAll().size() - 1);
		LocalDate dataAntiga = primeiraFolha.getDataEmissao();
		primeiraFolha.setDataEmissao(LocalDate.of(1988, 02, 18));
		folhaDAO.update(primeiraFolha);
		Folha folhaAtualizada = folhaDAO.getAll().get(folhaDAO.getAll().size() - 1);
	
		assertNotEquals(dataAntiga, folhaAtualizada.getDataEmissao());
	}
	
	@Test
	public void testGetById() {
		
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		Folha folha = folhaDAO.getById(5);
		System.out.println(folha.toString());	
	}
	
	@Test
	public void testGetByDate() {
		
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		
		ArrayList<Folha> folhas =  (ArrayList<Folha>) folhaDAO.getByDate(LocalDate.now());
		
		System.out.println(folhas.toString());	
	}

	/**
	 * TDD que verifica se o metodo saveFolha esta inserindo novas folhas ao Banco de dados
	 * tabela "folha".
	 */	
	
	/*@Test
	public void testSalvarFolhaBuilderHibrida() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 153, 27, 205);
		PontoFolha ponto = new PontoFolha(220, 5.53, 3.67);
		CargoFolha cargo = new CargoFolha(1752, 20);
		FeriasFolha ferias = new FeriasFolha(20, 10);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		director.createFolhaHibrida(colab, ponto, cargo, ferias);
		Folha folha = builder.build();
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(1, folhaDAO.getAll().size());
		assertTrue((int) folhaDAO.getFolhasPorId(1).getIdColaborador() == 1);
	}
	
	@Test
	public void testSalvarFolhaBuilderFerias() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 153, 27, 205);
		CargoFolha cargo = new CargoFolha(1752, 20);
		FeriasFolha ferias = new FeriasFolha(30, 0);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		Folha folha = director.createFolhaFerias(colab, cargo, ferias);
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(1, folhaDAO.getAll().size());
		assertTrue(folhaDAO.getFolhasPorId(1).getFeriasLiquido() == 2307.3986666666665);
	}	
	
	@Test
	public void testSalvarFolhaBuilder4() {
		ColaboradorFolha colab = new ColaboradorFolha(666, true, 127, 12,205);
		PontoFolha ponto = new PontoFolha(220, 13.15, 3.37);
		CargoFolha cargo = new CargoFolha(2570, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		Folha folha = director.createFolhaNormal(colab, ponto, cargo);
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(1, folhaDAO.getAll().size());
		assertTrue(folhaDAO.getFolhasPorId(1).getIdColaborador() == 666);
	}
	
	@Test
	public void testSalvarFolhaBuilderFalse() {
		ColaboradorFolha colab = new ColaboradorFolha(667, true, 127, 12,205);
		PontoFolha ponto = new PontoFolha(220, 13.15, 3.37);
		CargoFolha cargo = new CargoFolha(2570, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		Folha folha = director.createFolhaNormal(colab, ponto, cargo);
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(1, folhaDAO.getAll().size());
		assertFalse(folhaDAO.getFolhasPorId(1).getIdColaborador() == 666);
	}	
	
	@Test
	public void testFolhaPorId() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		ColaboradorFolha colab = new ColaboradorFolha(666, true, 127, 12,205);
		PontoFolha ponto = new PontoFolha(220, 13.15, 3.37);
		CargoFolha cargo = new CargoFolha(2570, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		
		Folha folha = director.createFolhaNormal(colab, ponto, cargo);
				
		folhaDAO.saveFolha(folha);
		
		FolhaDAO.newInstance();
		
		colab = new ColaboradorFolha(667, true, 127, 12,205);
		ponto = new PontoFolha(220, 13.15, 3.37);
		cargo = new CargoFolha(2570, 20);
		
		folha = director.createFolhaNormal(colab, ponto, cargo);
		
		folhaDAO.saveFolha(folha);
		
		FolhaDAO.newInstance();
		
		colab = new ColaboradorFolha(668, true, 127, 12,205);
		ponto = new PontoFolha(220, 13.15, 3.37);
		cargo = new CargoFolha(2570, 20);
		
		folha = director.createFolhaNormal(colab, ponto, cargo);
		
		folhaDAO.saveFolha(folha);
		
		assertTrue(folhaDAO.getFolhasPorId(2).getIdColaborador() == 667);
		assertTrue(folhaDAO.getAll().size() == 3);
	}
	
	@Test
	public void testFolhaPorIdColaborador() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		ColaboradorFolha colab = new ColaboradorFolha(666, true, 127, 12,205);
		PontoFolha ponto = new PontoFolha(220, 13.15, 3.37);
		CargoFolha cargo = new CargoFolha(2570, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		
		Folha folha = director.createFolhaNormal(colab, ponto, cargo);
				
		folhaDAO.saveFolha(folha);
		
		FolhaDAO.newInstance();
		
		colab = new ColaboradorFolha(667, true, 127, 12,205);
		ponto = new PontoFolha(220, 13.15, 3.37);
		cargo = new CargoFolha(2570, 20);
		
		folha = director.createFolhaNormal(colab, ponto, cargo);
		
		folhaDAO.saveFolha(folha);
		
		FolhaDAO.newInstance();
		
		colab = new ColaboradorFolha(667, true, 127, 12,205);
		ponto = new PontoFolha(220, 13.15, 3.37);
		cargo = new CargoFolha(2570, 20);
		
		folha = director.createFolhaNormal(colab, ponto, cargo);
		
		folhaDAO.saveFolha(folha);
		
		assertTrue(folhaDAO.getFolhasPorColaborador(667).size() == 2);
	} 
	
	@Test
	public void testSelectAllBancoDeDados() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		ColaboradorFolha colab = new ColaboradorFolha(666, true, 127, 12,205);
		PontoFolha ponto = new PontoFolha(220, 13.15, 3.37);
		CargoFolha cargo = new CargoFolha(2570, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		
		Folha folha = director.createFolhaNormal(colab, ponto, cargo);
				
		folhaDAO.saveFolha(folha);
		ArrayList<ArrayList<String>> lista = folhaDAO.getAll();
		ArrayList<String> listaEsperada = lista.get(0);
		
		assertEquals("[1, 666, 2021-05-11,"
				+ " 2790.0, 42.73772727272728,"
				+ " 250.14886363636364, 50.02977272727273,"
				+ " 335.2185, 60.616680681818195,"
				+ " 139.0, 154.2,"
				+ " 3047.4409090909094, 2358.4057284090914,"
				+ " 0.0, 0.0, 0.0,"
				+ " 0.0, 243.79527272727276]", listaEsperada.toString());
	}
	
	@Test
	public void testIDeleteFolha() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		ColaboradorFolha colab = new ColaboradorFolha(666, true, 127, 12,205);
		PontoFolha ponto = new PontoFolha(220, 13.15, 3.37);
		CargoFolha cargo = new CargoFolha(2570, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		
		Folha folha = director.createFolhaNormal(colab, ponto, cargo);
				
		folhaDAO.saveFolha(folha);
		
		FolhaDAO.newInstance();
		
		colab = new ColaboradorFolha(667, true, 127, 12,205);
		ponto = new PontoFolha(220, 13.15, 3.37);
		cargo = new CargoFolha(2570, 20);
		
		folha = director.createFolhaNormal(colab, ponto, cargo);
		
		folhaDAO.saveFolha(folha);
		
		FolhaDAO.newInstance();
		
		colab = new ColaboradorFolha(667, true, 127, 12,205);
		ponto = new PontoFolha(220, 13.15, 3.37);
		cargo = new CargoFolha(2570, 20);
		
		folha = director.createFolhaNormal(colab, ponto, cargo);
		
		folhaDAO.saveFolha(folha);
		
		folhaDAO.deleteFolha(2);
		
		assertTrue(folhaDAO.getAll().size() == 2);
	}
	
	@Test
	public void testUpdateFolha() {
		ColaboradorFolha colab = new ColaboradorFolha(1, true, 98, 18,205);
		PontoFolha ponto = new PontoFolha(220, 11, 1.63);
		CargoFolha cargo = new CargoFolha(1750, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		Folha folhaAnterior = director.createFolhaNormal(colab, ponto, cargo);
		
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		
		folhaDAO.saveFolha(folhaAnterior);
		
		FolhaDAO.newInstance();
		
		colab = new ColaboradorFolha(1, true, 98, 18,205);
		ponto = new PontoFolha(210, 11, 5.63);
		cargo = new CargoFolha(1750, 20);
		
		Folha folhaAtualizada = director.createFolhaNormal(colab, ponto, cargo);
		
		folhaDAO.updateFolha(folhaAtualizada, 1);
		assertNotEquals(folhaDAO.getFolhasPorId(1).getSalarioLiquido(), folhaAnterior.getSalarioLiquido(), 0.01);
	}	
	
	@Test
	public void versaoIDB() {		
		assertEquals("PostgreSQL 13.2, compiled by Visual C++ build 1914, 64-bit", PostgresConnector.dbVersion());
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
	}*/
}
