package br.com.proway.senior.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FolhaDAOTest {

//	@Ignore
//	public void testGetInstance() {
//		Folha folha = new Folha(4);
//		FolhaDAO listaFolhas = FolhaDAO.getInstance();
//		listaFolhas.saveFolha(folha);
//		assertEquals(folha.getId(), listaFolhas.getAll().get(0).getId());
//	}
//
////	@Test
//	public void testGetFolhasPorId1() {
//		Folha folha = new Folha(4);
//		FolhaDAO listaFolhas = FolhaDAO.getInstance();
//		listaFolhas.saveFolha(folha);
//		assertEquals(folha, listaFolhas.getFolhasPorId(4));
//
//	}
//
//	@Test
//	public void testGetFolhaPorDataEId() {
//		Folha folha = new Folha(5);
//		folha.setDataEmissao("27/04/2021");
//		folha.setIdColaborador(9);
//		FolhaDAO listaFolha = FolhaDAO.getInstance();
//		listaFolha.saveFolha(folha);
//		assertEquals(folha, listaFolha.getFolhaPorDataEId("27/04/2021", 9));
//	}
//
//	@Ignore
//	public void testGetFolhaPorDataEIdNull() {
//		Folha folha = new Folha(5);
//		FolhaDAO listaFolha = FolhaDAO.getInstance();
//		listaFolha.saveFolha(folha);
//		assertNull(listaFolha.getFolhaPorDataEId("27/04/2021", 9));
//	}
//
//	@Ignore
//	public void testSaveFolha() {
//		Folha folha = new Folha();
//		FolhaDAO listaFolha = FolhaDAO.getInstance();
//		listaFolha.saveFolha(folha);
//		assertNull(listaFolha.getFolhaPorDataEId("27/04/2021", 9));
//		}
//	
//	@Test
//	public void testRemoveFolha() {
//		Folha folha = new Folha(7);
//		FolhaDAO listaFolha = FolhaDAO.getInstance();
//		Folha folha2 = new Folha(8);
//		listaFolha.saveFolha(folha);
//		listaFolha.saveFolha(folha2);
//		assertTrue(listaFolha.removeFolha(8));
//		
//	}
//	
//	@Test
//	public void testUpdateFolha() {
//		Folha folha = new Folha(7);
//		Folha folha3 = new Folha();
//		FolhaDAO listaFolha = FolhaDAO.getInstance();
//		Folha folha2 = new Folha(8);
//		listaFolha.saveFolha(folha);
//		listaFolha.saveFolha(folha2);
//		assertTrue(listaFolha.updateFolha(folha3, 7));
//	}

	
	@Test
	public void testASalvarFolhaBuilder() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 100, 43);
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
	
	@Test
	public void testBSalvarFolhaBuilder2() {
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
		
		assertEquals(2, folhaDAO.getAll().size());
	}
	
	@Test
	public void testCSalvarFolhaBuilder3() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 153, 27);
		PontoFolha ponto = new PontoFolha(0, 0, 0);
		CargoFolha cargo = new CargoFolha(1752, 20);
		FeriasFolha ferias = new FeriasFolha(30, 0);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		director.createFolhaFerias(colab, ferias, cargo);
		Folha folha = builder.build();
				
		FolhaDAO folhaDAO = FolhaDAO.getInstance();
		folhaDAO.saveFolha(folha);
		
		assertEquals(3, folhaDAO.getAll().size());
	}	
	
	@Test
	public void testDSalvarFolhaBuilder4() {
		ColaboradorFolha colab = new ColaboradorFolha(2, true, 127, 12);
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
	
	@Ignore
	public void testeReiniciarDB() {
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
