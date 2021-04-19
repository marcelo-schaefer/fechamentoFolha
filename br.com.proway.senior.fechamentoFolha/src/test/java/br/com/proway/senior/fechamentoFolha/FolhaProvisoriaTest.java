package br.com.proway.senior.fechamentoFolha;

import static org.junit.Assert.*;

import org.junit.Test;

public class FolhaProvisoriaTest {

	FolhaProvisoria folha = new FolhaProvisoria(0, "20-01");	
	
	@Test
	public void testReflexoDSR() {
		folha.setHoraExtra(100.0);
		folha.calculoDSR();
		assertEquals(20.0, folha.getReflexoDSR(), 0.01);
	}

}
