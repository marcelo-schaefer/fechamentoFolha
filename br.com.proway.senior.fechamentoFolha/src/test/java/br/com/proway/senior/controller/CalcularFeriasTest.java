package br.com.proway.senior.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import br.com.proway.senior.model.CargoFolha;
import br.com.proway.senior.model.ColaboradorFolha;
import br.com.proway.senior.model.FeriasFolha;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.PontoFolha;

public class CalcularFeriasTest {
	
	/*
	 * "Jorge", 0, "jorge@gmail.com", 1500.0
	 * "Jorge", 0, "jorge@gmail.com", 3200.0
	 * "Jorge", 0, "jorge@gmail.com", 1500.0
	 * "Jorge", 0, "jorge@gmail.com", 3000.0
	 * 
	 * PontoTest
	 * 220, 6.33, 2.71, 120, 10, true, 100, 0
	 * 220, 6.33, 2.71, 120, 10, true, 100, 0
	 * 
	 * 220, 0, 0, 0, 0, true, 100, 50
	 */

	@Ignore
	public void testeCalculoDeFeriasComVenda() {
		ColaboradorFolha jorge = new ColaboradorFolha(0, true, 100, 0);
		PontoFolha ponto = new PontoFolha(220, 6.33, 2.71);
		FeriasFolha ferias = new FeriasFolha(20,10);
		CargoFolha cargo = new CargoFolha(1500.0, 0, 0);
		Folha folhaJorge = new Folha(jorge, ponto, ferias, cargo);
		CalcularFerias calcularFerias = new CalcularFerias();
		double valor = calcularFerias.calcularFerias(folhaJorge);
		assertEquals(1910.04, valor, 0.01);
	}

	@Ignore
	public void testeCalculoDeFeriasComVenda2() {
//		ColaboradorFolha jorge = new ColaboradorFolha();
//		PontoFolha pontoJorge = new PontoFolha(220, 6.33, 2.71);
//		jorge.setPonto(pontoJorge);
//		Folha folha = new Folha(jorge);
//		jorge.addTotalFolhas(folha);
//
//		double valor = folha.calcularFerias(20, 10);
//		assertEquals(valor, 3680.22, 0.01);
	}

	@Ignore
	public void testeCalculoDeFeriasSemVenda() {
//		ColaboradorFolha jorge = new ColaboradorFolha();
//		PontoFolha pontoJorge = new PontoFolha(220, 6.33, 2.71);
//		jorge.setPonto(pontoJorge);
//		Folha folha = new Folha(jorge);
//		jorge.addTotalFolhas(folha);
//
//		double valor = folha.calcularFerias(30, 0);
//		assertEquals(valor, 1780, 0.01);
	}

	@Ignore
	public void testeCalculoIRFeriasComDependente() {
//		ColaboradorFolha jorge = new ColaboradorFolha();
//		PontoFolha pontoJorge = new PontoFolha(220, 0, 0);
//		jorge.setPonto(pontoJorge);
//		jorge.addDependentes("Filho 1");
//		jorge.addDependentes("Filho 2");
//		Folha folha = new Folha(jorge);
//		jorge.addTotalFolhas(folha);
//
//		double valor = folha.calcularFerias(20, 10);
//		assertEquals(valor, 3437.67, 0.01);
	}

}
