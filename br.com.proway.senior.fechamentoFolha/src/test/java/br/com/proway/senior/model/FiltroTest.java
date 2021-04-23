package br.com.proway.senior.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.proway.senior.controller.Filtro;
import br.com.proway.senior.model.ColaboradorFolha;
import br.com.proway.senior.model.Folha;

public class FiltroTest {	

	Folha folha0 = new Folha(0, "data1");
	Folha folha1 = new Folha(1, "data2");
	Folha folha2 = new Folha(2, "data3");
	ColaboradorFolha colaborador0 = new ColaboradorFolha("Jorge", 0, "email1", 500.0); 
	ColaboradorFolha colaborador1 = new ColaboradorFolha("Jorge2", 1, "email2", 500.0); 
	    
	@Test
	public void testFiltroFolhaId() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		Folha f = Filtro.filtro(colaborador0, 1);
		assertEquals(1, f.getId());		
	}
	
	@Test
	public void testFiltroFolhaInexistenteId() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		Folha f = Filtro.filtro(colaborador0, 6);
		assertEquals(null, f);		
	}
	
	
	@Test
	public void testFiltroFolhaData() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		Folha f = Filtro.filtro(colaborador0, "data2");
		assertEquals("data2", f.getDataEmissao());		
	}
	
	@Test
	public void testFiltroFolhaInexistenteData() {
		colaborador0.addTotalFolhas(folha0);
		colaborador0.addTotalFolhas(folha1);
		colaborador0.addTotalFolhas(folha2);
		Folha f = Filtro.filtro(colaborador0, "data4");
		assertEquals(null, f);		
	}
	
}