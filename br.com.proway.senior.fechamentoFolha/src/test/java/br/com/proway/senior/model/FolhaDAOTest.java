package br.com.proway.senior.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

public class FolhaDAOTest {
	
	@Test
	public void testGetInstance() {
		ArrayList<Folha> folhas = new ArrayList<Folha>();
		Folha folha = new Folha(1);
		folhas.add(folha);
		FolhaDAO listaFolhas = FolhaDAO.getInstance(folhas);
		assertArrayEquals(folhas, listaFolhas.getAll());
	}

	@Test
	public void testGetFolhasPorId() {
		ArrayList<Folha> folhas = new ArrayList<Folha>();
		Folha folha = new Folha(0);
		folhas.add(folha);
		FolhaDAO listaFolhas = FolhaDAO.getInstance(folhas);
		assertNotNull(listaFolhas.getFolhasPorId(0));
		
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
