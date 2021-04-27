package br.com.proway.senior.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.proway.senior.model.ColaboradorFolha;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.Ponto;

public class CalcularFeriasTest {

	@Test
	public void testCalcularFerias() {
		fail("Not yet implemented");
	}

	@Test
	public void testeCalculoDeFeriasComVenda() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1500.0);
		Ponto pontoJorge = new Ponto(220, 6.33, 2.71, 120, 10, true, 100, 0);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);

		double valor = folha.calcularFerias(20, 10);
		assertEquals(valor, 1910.04, 0.01);
	}

	@Test
	public void testeCalculoDeFeriasComVenda2() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 3200.0);
		Ponto pontoJorge = new Ponto(220, 6.33, 2.71, 120, 10, true, 100, 0);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);

		double valor = folha.calcularFerias(20, 10);
		assertEquals(valor, 3680.22, 0.01);
	}

	@Test
	public void testeCalculoDeFeriasSemVenda() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1500.0);
		Ponto pontoJorge = new Ponto(220, 6.33, 2.71, 120, 0, true, 100, 0);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);

		double valor = folha.calcularFerias(30, 0);
		assertEquals(valor, 1780, 0.01);
	}

	@Test
	public void testeCalculoIRFeriasComDependente() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 3000.0);
		Ponto pontoJorge = new Ponto(220, 0, 0, 0, 0, true, 100, 50);
		jorge.setPonto(pontoJorge);
		jorge.addDependentes("Filho 1");
		jorge.addDependentes("Filho 2");
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);

		double valor = folha.calcularFerias(20, 10);
		assertEquals(valor, 3437.67, 0.01);
	}

}
