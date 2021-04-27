package br.com.proway.senior.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class FolhaDAOTest {

	@Test
	public void testGetInstance() {
		Folha folha = new Folha(4);
		FolhaDAO listaFolhas = FolhaDAO.getInstance();
		listaFolhas.saveFolha(folha);
		assertEquals(folha.getId(), listaFolhas.getAll().get(0).getId());
	}

	@Ignore
	public void testGetFolhasPorId() {
		Folha folha = new Folha(4);
		FolhaDAO listaFolhas = FolhaDAO.getInstance();
		assertEquals(4, listaFolhas.getFolhasPorId(0));	
				
	}

	@Ignore
	public void testGetFolhaPorDataEId() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testSetListaFolhas() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testSaveFolha() {
		fail("Not yet implemented");
	}

}
