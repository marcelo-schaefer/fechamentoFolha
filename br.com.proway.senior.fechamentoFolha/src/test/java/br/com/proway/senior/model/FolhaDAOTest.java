package br.com.proway.senior.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

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
 
	@Test
	public void testASalvarFolhaBuilder() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 100, 43,205);
		PontoFolha ponto = new PontoFolha(220, 2, 1);
		CargoFolha cargo = new CargoFolha(1752, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		director.createFolhaNormal(colab, ponto, cargo);
		Folha folha = builder.build();
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(1, folhaDAO.getAll().size());
	}

	/**
	 * TDD que verifica se o metodo saveFolha esta inserindo novas folhas ao Banco de dados
	 * tabela "folha".
	 */	
	
	@Test
	public void testBSalvarFolhaBuilder2() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 153, 27,205);
		PontoFolha ponto = new PontoFolha(220, 5.53, 3.67);
		CargoFolha cargo = new CargoFolha(1752, 20);
		FeriasFolha ferias = new FeriasFolha(20, 10);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		director.createFolhaHibrida(colab, ponto, cargo, ferias);
		Folha folha = builder.build();
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(2, folhaDAO.getAll().size());
	}
	
	@Test
	public void testCSalvarFolhaBuilder3() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 153, 27,205);
		PontoFolha ponto = new PontoFolha(0, 0, 0);
		CargoFolha cargo = new CargoFolha(1752, 20);
		FeriasFolha ferias = new FeriasFolha(30, 0);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		director.createFolhaFerias(colab, cargo, ferias);
		Folha folha = builder.build();
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(3, folhaDAO.getAll().size());
	}	
	
	@Test
	public void testDSalvarFolhaBuilder4() {
		ColaboradorFolha colab = new ColaboradorFolha(2, true, 127, 12,205);
		PontoFolha ponto = new PontoFolha(220, 13.15, 3.37);
		CargoFolha cargo = new CargoFolha(2570, 20);
		FeriasFolha ferias = new FeriasFolha(0, 0);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		director.createFolhaNormal(colab, ponto, cargo);
		Folha folha = builder.build();
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(4, folhaDAO.getAll().size());
	}	
	
	@Test
	public void testEFolhaPorId() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		Folha folha = folhaDAO.getFolhasPorId(3);
		System.out.println(folha.toString());
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
		ColaboradorFolha colab = new ColaboradorFolha(1, true, 98, 18,205);
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
	
	@Test
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
