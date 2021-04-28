/**
* @ Author - Vitor André Gehrke - vitor.gehrke@gmail.com
*/
package br.com.proway.senior.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.proway.senior.model.Folha;


public class CalculosDeExtrasTest {

	@Test
	public void testCalcularDSR() {
		Folha folha = new Folha();
		folha.setValorHoraExtra(30.01);
		CalculosDeExtras extras = new CalculosDeExtras();
		assertEquals(6.002 , extras.calcularDSR(folha), 0.01);
	}

	@Test
	public void testCalculaInsalubridade0() {
		Folha folha = new Folha();
		folha.setPercentualInsalubridade(0);
		CalculosDeExtras extras = new CalculosDeExtras();
		assertEquals(0, extras.calculaInsalubridade(folha), 0.01);
		
	}
	
	@Test
	public void testCalculaInsalubridade10() {
		Folha folha = new Folha();
		folha.setPercentualInsalubridade(10.0);
		CalculosDeExtras extras = new CalculosDeExtras();
		assertEquals(110.0, extras.calculaInsalubridade(folha), 0.01);
		
	}
	
	@Test
	public void testCalculaInsalubridade20() {
		Folha folha = new Folha();
		folha.setPercentualInsalubridade(20.0);
		CalculosDeExtras extras = new CalculosDeExtras();
		assertEquals(220.0, extras.calculaInsalubridade(folha), 0.01);
		
	}
	
	@Test
	public void testCalculaInsalubridade40() {
		Folha folha = new Folha();
		folha.setPercentualInsalubridade(40.0);
		CalculosDeExtras extras = new CalculosDeExtras();
		assertEquals(440.0, extras.calculaInsalubridade(folha), 0.01);
		
	}


	@Test
	public void testCalcularBonificacaoZero() {
		Folha folha = new Folha();
		folha.setValorBonificacao(0);
		CalculosDeExtras extras = new CalculosDeExtras();
		assertEquals(0, extras.calcularBonificacao(folha), 0.01);
	}
	
	@Test
	public void testCalcularBonificacaoNotZero() {
		Folha folha = new Folha();
		folha.setValorBonificacao(107.39);
		CalculosDeExtras extras = new CalculosDeExtras();
		assertEquals(107.39, extras.calcularBonificacao(folha), 0.01);
	}

}
