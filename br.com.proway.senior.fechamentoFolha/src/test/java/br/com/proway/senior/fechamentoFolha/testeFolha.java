package br.com.proway.senior.fechamentoFolha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class testeFolha {

	/*
	   1- ValorHora, 
	   2- horasTrabalhadas, 
	   3- horasExtra, 
	   4- horasFaltas, 
	   5- valorBonificacao, 
	   6- percentualInsalubridade, 
	   7- valorMensalidade
	   8- valorCooparticipacao, 
	   9- valeTransporte
    */
	Folha folha = new Folha(10, 220, 0, 0, 100, 20, 100, 25, 115);
	
	@Test
	public void testeValeTransporte() {		
		folha.setSalarioBase(2200);		
		assertEquals(folha.calculaValeTransporte(), 132, 0.01);
	}
	
	@Test
	public void testeValeTransporteMaximo() {		
		Folha folha = new Folha(10, 220, 0, 0, 100, 20, 100, 25, 115);
		folha.setSalarioBase(3300);		
		assertEquals(folha.calculaValeTransporte(), 180, 0.01);
	}
	
	@Test
	public void testePlanoSaude() {	
		Folha folha = new Folha(10, 220, 0, 0, 100, 20, 155, 45, 115);
		assertEquals(folha.descontaPlanoSaude(), 200, 0.01);
	}
	
	@Test
	public void testePlanoSaudeValorCooparticipacaoNegativo() {	
		Folha folha = new Folha(10, 220, 0, 0, 100, 20, 0, -20, 115);
		assertEquals(folha.descontaPlanoSaude(), 0, 0.01);
	}
	
	@Test
	public void testePlanoSaudeValorMensalidadeNegativo() {	
		Folha folha = new Folha(10, 220, 0, 0, 100, 20, -57, 100, 115);
		assertEquals(folha.descontaPlanoSaude(), 0, 0.01);
	}
	
	@Test
	public void testeAdicionaBonificacao() {
		Folha folha = new Folha(10, 220, 0, 0, 358, 20, 100, 25, 115);
		assertEquals(folha.adicionaBonificacao(), 358, 0.01);
	}
	
	@Test
	public void testeAdicionaBonificacaoNegativa() {
		Folha folha = new Folha(10, 220, 0, 0, -52, 20, 100, 25, 115);
		assertEquals(folha.adicionaBonificacao(), 0, 0.01);
	}
	
	@Test
	public void testeCalculoInss() {
		Folha folha = new Folha(10, 220, 0, 0, -52, 20, 100, 25, 115);
		folha.setSalarioBruto(2987);
		
		folha.descontoInss();
	}
	
	@Test
	public void testeCalculoImpostoRenda() {
		Folha folha = new Folha(10, 220, 0, 0, -52, 20, 100, 25, 115);
		folha.setSalarioBruto(3200);
		
		assertEquals(folha.calculaImpostoRenda(), 125.20, 0.01);
	}
	
	@Test
	public void testeCalculoImpostoRenda0() {
		Folha folha = new Folha(10, 220, 0, 0, -52, 20, 100, 25, 115);
		folha.setSalarioBruto(1903);
		
		assertEquals(folha.calculaImpostoRenda(), 0, 0.01);
	}
	
	@Test
	public void testaValorInsalubridade() {
		Folha folha1 = new Folha(0, 0, 0, 0, 0, 10, 0, 0, 0);
		assertEquals(folha1.calculaInsalubridade(), 110, 0.01);
		
		Folha folha2 = new Folha(10, 220, 0, 0, 52, 20, 100, 25, 115);
		assertEquals(folha2.calculaInsalubridade(), 220, 0.01);
		
		Folha folha3 = new Folha(0, 0, 0, 0, 0, 40, 0, 0, 0);
		assertEquals(folha3.calculaInsalubridade(), 440, 0.01);
		
		Folha folha4 = new Folha(0, 0, 0, 0, 0, 80, 0, 0, 0);
		assertEquals(folha4.calculaInsalubridade(), 0, 0.01);
	}
	
	@Test
	public void testaCalculaValorHoras() {
		Folha folha = new Folha(10, 220, 0, 0, 100, 20, 100, 25, 115);
		folha.setSalarioBase(2200);
		assertEquals(folha.calculaValorHora(), 11, 0.01);
	}
	
	@Test
	public void testaCalculaValorHoras2() {
		Folha folha = new Folha(10, 220, 0, 0, 100, 10, 100, 25, 115);
		folha.setSalarioBase(2200);
		assertEquals(folha.calculaValorHora(), 10.50, 0.01);
	}
	
	@Test
	public void testaCalculaValorHoras3() {
		Folha folha = new Folha(10, 220, 0, 0, 100, 0, 100, 25, 115);
		folha.setSalarioBase(2200);
		assertEquals(folha.calculaValorHora(), 10, 0.01);
	}
	
	@Test
	public void testaHoraExtra() {
		Folha folha = new Folha(10, 220, 10, 0, 100, 0, 100, 25, 115);
		assertEquals(folha.valorHorasExtras(), 150, 0.01);
	}
	
	@Test
	public void testaHoraExtra2() {
		Folha folha = new Folha(10, 220, 15.50, 0, 100, 0, 100, 25, 115);
		assertEquals(folha.valorHorasExtras(), 232.50, 0.01);
	}
	
	@Test
	public void testaHoraExtra3() {
		Folha folha = new Folha(10, 220, 15.50, 0, 100, 0, 100, 25, 115);
		assertNotEquals(folha.valorHorasExtras(), 232.55, 0.01);
	}
	
	@Test
	public void testeHoraFaltas() {
		Folha folha = new Folha(10, 220, 0, 10, 100, 0, 100, 25, 115);
		assertEquals(folha.valorHorasFaltas(), 100, 0.01 );
	}
	
	@Test
	public void testeHoraFaltasComHorasExtras() {
		Folha folha = new Folha(10, 220, 15, 10, 100, 0, 100, 25, 115);
		double valor = folha.valorHorasExtras() - folha.valorHorasFaltas();
		assertEquals(valor, 125, 0.01 );
	}
	
	@Test
	public void testeHoraFaltasComHorasExtrasEInsalubridade() {
		Folha folha = new Folha(10, 220, 15, 10, 100, 20, 100, 25, 115);
		
		folha.setSalarioBase(2200);
		folha.calculaValorHora();		
		double valor = folha.valorHorasExtras() - folha.valorHorasFaltas();
		assertEquals(valor, 137.50, 0.01 );
	}
	
	@Test
	public void testeCalculaFolha() {
		Folha folha = new Folha(10, 220, 15, 10, 100, 20, 100, 25, 100);
		folha.setSalarioBase(2200);
		double valor = folha.calcularFolha();
		assertEquals(valor, 2073.50, 0.01); //****
	}
	
	@Test
	public void testeCalculaFolha2() {
		Folha folha = new Folha(11.6818, 220, 0, 0, 0, 0, 109, 0, 0);	
		folha.setSalarioBase(2570);
		double valor = folha.calcularFolha();
		assertEquals(valor, 2149.55, 0.01);
	}
	
	
	

}
