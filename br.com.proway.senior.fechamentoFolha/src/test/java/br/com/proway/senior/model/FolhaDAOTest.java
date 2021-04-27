package br.com.proway.senior.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class FolhaDAOTest {

	@Ignore
	public void testGetInstance() {
		Folha folha = new Folha(4);
		FolhaDAO listaFolhas = FolhaDAO.getInstance();
		listaFolhas.saveFolha(folha);
		assertEquals(folha.getId(), listaFolhas.getAll().get(0).getId());
	}

	@Ignore
	public void testGetFolhasPorId1() {
		Folha folha = new Folha(4);
		FolhaDAO listaFolhas = FolhaDAO.getInstance();
		listaFolhas.saveFolha(folha);
		assertEquals(folha, listaFolhas.getFolhasPorId(4));

	}

	@Ignore
	public void testGetFolhaPorDataEId() {
		Folha folha = new Folha(5);
		folha.setDataEmissao("27/04/2021");
		folha.setIdColaborador(9);
		FolhaDAO listaFolha = FolhaDAO.getInstance();
		listaFolha.saveFolha(folha);
		assertEquals(folha, listaFolha.getFolhaPorDataEId("27/04/2021", 9));
	}

	@Ignore
	public void testGetFolhaPorDataEIdNull() {
		Folha folha = new Folha(5);
		FolhaDAO listaFolha = FolhaDAO.getInstance();
		listaFolha.saveFolha(folha);
		assertNull(listaFolha.getFolhaPorDataEId("27/04/2021", 9));
	}

	@Ignore
	public void testSaveFolha() {
		Folha folha = new Folha();
		FolhaDAO listaFolha = FolhaDAO.getInstance();
		listaFolha.saveFolha(folha);
		assertNull(listaFolha.getFolhaPorDataEId("27/04/2021", 9));
		}
	
	@Ignore
	public void testRemoveFolha() {
		Folha folha = new Folha(7);
		FolhaDAO listaFolha = FolhaDAO.getInstance();
		Folha folha2 = new Folha(8);
		listaFolha.saveFolha(folha);
		listaFolha.saveFolha(folha2);
		assertTrue(listaFolha.removeFolha(8));
		
	}
	
	@Ignore
	public void testUpdateFolha() {
		Folha folha = new Folha(7);
		Folha folha3 = new Folha();
		FolhaDAO listaFolha = FolhaDAO.getInstance();
		Folha folha2 = new Folha(8);
		listaFolha.saveFolha(folha);
		listaFolha.saveFolha(folha2);
		assertTrue(listaFolha.updateFolha(folha3, 7));
	}
	
	@Ignore
	public void getFolhaIdColaborador() {
		Folha folha = new Folha();
		FolhaDAO listaFolha = FolhaDAO.getInstance();
		listaFolha.saveFolha(folha);
		folha.setIdColaborador(10);
		assertEquals(folha, listaFolha.getFolhaIdColaborador(10));
	}
	
}



