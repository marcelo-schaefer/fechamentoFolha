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
	
	
//	@Test
//	public void testaAdicionarBonificacao() {
//		Folha folha = new Folha(0, 0, 0, 0, 100, 0, 0, 0, 0);
//		assertEquals(folha.adicionaBonificacao(), 100, 0.01);
//	}
//	@Test
//	public void testaPlanoSaude() {
//		Folha folha = new Folha(0, 0, 0, 0, 200, 0, 50, 20, 10);
//		folha.setSalarioBase(1600);
//		double bonificacao = folha.adicionaBonificacao();
//		double planoSaude = folha.descontaPlanoSaude();
//		double valeTransp = folha.calculaValeTransporte();
//		double salario = (bonificacao-planoSaude)-valeTransp ;
//		assertEquals(salario, 34, 0.01);
//	}
//	@Test
//	public void testaImpostoRenda() {
//		Folha folha = new Folha(0, 0, 0, 0, 0, 0, 0, 0, 0);
//		folha.setSalarioBruto(2826.66);
//		assertEquals(folha.calculaImpostoRenda(), 69.19, 0.01);
//	}
//	@Test
//	public void testaHoraExtra() {
//		Folha folha = new Folha(0, 0, 30, 0, 0, 0, 0, 0, 0);
//		folha.setSalarioBase(2000);
//		folha.calcularFolha();		
//		assertEquals(folha.valorHorasExtras(), 409.09, 0.01);
//	}
//	@Test
//	public void testaInss() {
//		Folha folha = new Folha(0, 0, 30, 0, 0, 0, 0, 0, 0);
//		folha.setSalarioBruto(2300);
//		assertEquals(folha.descontoInss(), 253, 0.01);
//	}
//	@Test
//	public void testaHorasFaltas() {
//		Folha folha = new Folha(0, 0, 30, 20, 0, 0, 0, 0, 0);
//		folha.setSalarioBase(1000);
//		folha.calculaValorHora();
//		folha.valorHorasFaltas();
//		assertEquals(folha.valorHorasFaltas(), 90.90 , 0.01);
//	}
	
	@Test
	public void testaAdicionarBonificacao() {
		Folha folha = new Folha(0, 0, 0, 0, 100, 0, 0, 0, 0);
		assertEquals(folha.adicionaBonificacao(), 100, 0.01);
	}
	@Test
	public void testaPlanoSaude() {
		Folha folha = new Folha(0, 0, 0, 0, 200, 0, 50, 20, 10);
		folha.setSalarioBase(1600);
		double bonificacao = folha.adicionaBonificacao();
		double planoSaude = folha.descontaPlanoSaude();
		double valeTransp = folha.calculaValeTransporte();
		double salario = (bonificacao-planoSaude)-valeTransp ;
		assertEquals(salario, 34, 0.01);
	}
	@Test
	public void testaImpostoRenda() {
		Folha folha = new Folha(0, 0, 0, 0, 0, 0, 0, 0, 0);
		folha.setSalarioBruto(2826.66);
		assertEquals(folha.calculaImpostoRenda(), 69.19, 0.01);
	}
	@Test
	public void testaHoraExtra() {
		Folha folha = new Folha(0, 0, 30, 0, 0, 0, 0, 0, 0);
		folha.setSalarioBase(2000);
		folha.calcularFolha();		
		assertEquals(folha.valorHorasExtras(), 409.09, 0.01);
	}
	@Test
	public void testaInss() {
		Folha folha = new Folha(0, 0, 30, 0, 0, 0, 0, 0, 0);
		folha.setSalarioBruto(2300);
		assertEquals(folha.descontoInss(), 253, 0.01);
	}
	@Test
	public void testaHorasFaltas() {
		Folha folha = new Folha(0, 0, 30, 20, 0, 0, 0, 0, 0);
		folha.setSalarioBase(1000);
		folha.calculaValorHora();
		folha.valorHorasFaltas();
		assertEquals(folha.valorHorasFaltas(), 90.90 , 0.01);
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
		Folha folha = new Folha(10, 220, 15, 10, 0, 0, 100, 25, 100);
		folha.setSalarioBase(2200);
		double valor = folha.calcularFolha();
		assertEquals(valor, 1799.85, 0.01); //****
	}
	
	@Test
	public void testeCalculaFolha2() {
		Folha folha = new Folha(11.6818, 220, 0, 0, 0, 0, 109, 0, 0);	
		folha.setSalarioBase(2570);
		double valor = folha.calcularFolha();
		assertEquals(valor, 2149.55, 0.01);
	}
	
	@Test
	public void testeCalculaFolha3() {
		Folha folha = new Folha(0, 220, 22, 17, 100, 20, 100, 50, 145);	
		folha.setSalarioBase(3000);
		double valor = folha.calcularFolha();
		assertEquals(valor, 2713.53, 0.01);
	}
	
	@Test
	public void testeCalculaFolha4() {
		Folha folha = new Folha(0, 220, 13.50, 3.56, 350, 0, 100, 234, 0);	
		folha.setSalarioBase(5932);
		double valor = folha.calcularFolha();
		assertEquals(valor, 4879.19, 0.01);
	}
	
	@Test
	public void testeCalculaFolha5() {
		Folha folha = new Folha(0, 220, 17.10, 7.46, 122, 40, 100, 15, 100);	
		folha.setSalarioBase(1200);
		double valor = folha.calcularFolha();
		assertEquals(valor, 1501.86, 0.01);
	}
	
	@Test
	public void testeCalculoFolha6() {
		Folha folha = new Folha(0, 175, 6.33, 2.71, 120, 10, 100, 0, 80.7);	
		folha.setSalarioBase(1345);
		double valor = folha.calcularFolha();
		assertEquals(valor, 996.11, 0.01);
	}

//	@Test
//	public void testeValeTransporte() {		
//		folha.setSalarioBase(2200);		
//		assertEquals(folha.calculaValeTransporte(), 132, 0.01);
//	}
//	
//	@Test
//	public void testeValeTransporteMaximo() {		
//		Folha folha = new Folha(10, 220, 0, 0, 100, 20, 100, 25, 115);
//		folha.setSalarioBase(3300);		
//		assertEquals(folha.calculaValeTransporte(), 180, 0.01);
//	}
//	
//	@Test
//	public void testePlanoSaude() {	
//		Folha folha = new Folha(10, 220, 0, 0, 100, 20, 155, 45, 115);
//		assertEquals(folha.descontaPlanoSaude(), 200, 0.01);
//	}
//	
//	@Test
//	public void testePlanoSaudeValorCooparticipacaoNegativo() {	
//		Folha folha = new Folha(10, 220, 0, 0, 100, 20, 0, -20, 115);
//		assertEquals(folha.descontaPlanoSaude(), 0, 0.01);
//	}
//	
//	@Test
//	public void testePlanoSaudeValorMensalidadeNegativo() {	
//		Folha folha = new Folha(10, 220, 0, 0, 100, 20, -57, 100, 115);
//		assertEquals(folha.descontaPlanoSaude(), 0, 0.01);
//	}
//	
//	@Test
//	public void testeAdicionaBonificacao() {
//		Folha folha = new Folha(10, 220, 0, 0, 358, 20, 100, 25, 115);
//		assertEquals(folha.adicionaBonificacao(), 358, 0.01);
//	}
//	
//	@Test
//	public void testeAdicionaBonificacaoNegativa() {
//		Folha folha = new Folha(10, 220, 0, 0, -52, 20, 100, 25, 115);
//		assertEquals(folha.adicionaBonificacao(), 0, 0.01);
//	}
//	
//	@Test
//	public void testeCalculoInss() {
//		Folha folha = new Folha(10, 220, 0, 0, -52, 20, 100, 25, 115);
//		folha.setSalarioBruto(2987);
//		
//		folha.descontoInss();
//	}
//	
//	@Test
//	public void testeCalculoImpostoRenda() {
//		Folha folha = new Folha(10, 220, 0, 0, -52, 20, 100, 25, 115);
//		folha.setSalarioBruto(3200);
//		
//		assertEquals(folha.calculaImpostoRenda(), 125.20, 0.01);
//	}
//	
//	@Test
//	public void testeCalculoImpostoRenda0() {
//		Folha folha = new Folha(10, 220, 0, 0, -52, 20, 100, 25, 115);
//		folha.setSalarioBruto(1903);
//		
//		assertEquals(folha.calculaImpostoRenda(), 0, 0.01);
//	}
//	
//	@Test
//	public void testaValorInsalubridade() {
//		Folha folha1 = new Folha(0, 0, 0, 0, 0, 10, 0, 0, 0);
//		assertEquals(folha1.calculaInsalubridade(), 110, 0.01);
//		
//		Folha folha2 = new Folha(10, 220, 0, 0, 52, 20, 100, 25, 115);
//		assertEquals(folha2.calculaInsalubridade(), 220, 0.01);
//		
//		Folha folha3 = new Folha(0, 0, 0, 0, 0, 40, 0, 0, 0);
//		assertEquals(folha3.calculaInsalubridade(), 440, 0.01);
//		
//		Folha folha4 = new Folha(0, 0, 0, 0, 0, 80, 0, 0, 0);
//		assertEquals(folha4.calculaInsalubridade(), 0, 0.01);
//	}
//	
//	@Test
//	public void testaCalculaValorHoras() {
//		Folha folha = new Folha(10, 220, 0, 0, 100, 20, 100, 25, 115);
//		folha.setSalarioBase(2200);
//		assertEquals(folha.calculaValorHora(), 11, 0.01);
//	}
//	
//	@Test
//	public void testaCalculaValorHoras2() {
//		Folha folha = new Folha(10, 220, 0, 0, 100, 10, 100, 25, 115);
//		folha.setSalarioBase(2200);
//		assertEquals(folha.calculaValorHora(), 10.50, 0.01);
//	}
//	
//	@Test
//	public void testaCalculaValorHoras3() {
//		Folha folha = new Folha(10, 220, 0, 0, 100, 0, 100, 25, 115);
//		folha.setSalarioBase(2200);
//		assertEquals(folha.calculaValorHora(), 10, 0.01);
//	}
//	
//	@Test
//	public void testaHoraExtra() {
//		Folha folha = new Folha(10, 220, 10, 0, 100, 0, 100, 25, 115);
//		assertEquals(folha.valorHorasExtras(), 150, 0.01);
//	}
//	
//	@Test
//	public void testaHoraExtra2() {
//		Folha folha = new Folha(10, 220, 15.50, 0, 100, 0, 100, 25, 115);
//		assertEquals(folha.valorHorasExtras(), 232.50, 0.01);
//	}
//	
//	@Test
//	public void testaHoraExtra3() {
//		Folha folha = new Folha(10, 220, 15.50, 0, 100, 0, 100, 25, 115);
//		assertNotEquals(folha.valorHorasExtras(), 232.55, 0.01);
//	}
//	
//	@Test
//	public void testeHoraFaltas() {
//		Folha folha = new Folha(10, 220, 0, 10, 100, 0, 100, 25, 115);
//		assertEquals(folha.valorHorasFaltas(), 100, 0.01 );
//	}
//	
//	@Test
//	public void testeHoraFaltasComHorasExtras() {
//		Folha folha = new Folha(10, 220, 15, 10, 100, 0, 100, 25, 115);
//		double valor = folha.valorHorasExtras() - folha.valorHorasFaltas();
//		assertEquals(valor, 125, 0.01 );
//	}
//	
//	@Test
//	public void testeHoraFaltasComHorasExtrasEInsalubridade() {
//		Folha folha = new Folha(10, 220, 15, 10, 100, 20, 100, 25, 115);
//		
//		folha.setSalarioBase(2200);
//		folha.calculaValorHora();		
//		double valor = folha.valorHorasExtras() - folha.valorHorasFaltas();
//		assertEquals(valor, 137.50, 0.01 );
//	}
//	
//	@Test
//	public void testeCalculaFolha() {
//		Folha folha = new Folha(10, 220, 15, 10, 0, 0, 100, 25, 100);
//		folha.setSalarioBase(2200);
//		double valor = folha.calcularFolha();
//		assertEquals(valor, 1799.85, 0.01); //****
//	}
//	
//	@Test
//	public void testeCalculaFolha2() {
//		Folha folha = new Folha(11.6818, 220, 0, 0, 0, 0, 109, 0, 0);	
//		folha.setSalarioBase(2570);
//		double valor = folha.calcularFolha();
//		assertEquals(valor, 2149.55, 0.01);
//	}
//	
//	@Test
//	public void testeCalculaFolha3() {
//		Folha folha = new Folha(0, 220, 22, 17, 100, 20, 100, 50, 145);	
//		folha.setSalarioBase(3000);
//		double valor = folha.calcularFolha();
//		assertEquals(valor, 2713.53, 0.01);
//	}
//	
//	@Test
//	public void testeCalculaFolha4() {
//		Folha folha = new Folha(0, 220, 13.50, 3.56, 350, 0, 100, 234, 0);	
//		folha.setSalarioBase(5932);
//		double valor = folha.calcularFolha();
//		assertEquals(valor, 4879.19, 0.01);
//	}
//	
//	@Test
//	public void testeCalculaFolha5() {
//		Folha folha = new Folha(0, 220, 17.10, 7.46, 122, 40, 100, 15, 100);	
//		folha.setSalarioBase(1200);
//		double valor = folha.calcularFolha();
//		assertEquals(valor, 1501.86, 0.01);
//	}
//	
//	@Test
//	public void testeCalculoFolha6() {
//		Folha folha = new Folha(0, 175, 6.33, 2.71, 120, 10, 100, 0, 80.7);	
//		folha.setSalarioBase(1345);
//		double valor = folha.calcularFolha();
//		assertEquals(valor, 996.11, 0.01);
//	}
	
//	@Test
//	public void testeCalculoDeFeriasComVenda() {
//		Folha folha = new Folha(0, 220, 0, 0, 0, 0, 0, 0, 0);
//		folha.setSalarioBase(1500);
//		double valor = folha.calcularFerias(20, 10);
//		assertEquals(valor, 1780, 0.01);
//	}
//
//	@Test
//	public void testeCalculoDeFeriasSemVenda() {
//		Folha folha = new Folha(0, 220, 0, 0, 0, 0, 0, 0, 0);
//		folha.setSalarioBase(1500);
//		double valor = folha.calcularFerias(30, 0);
//		assertEquals(valor, 1780, 0.01);
//	}
//	
//	@Test
//	public void testeCalculoDeFeriasComVenda2() {
//		Folha folha = new Folha(0, 220, 0, 0, 0, 0, 0, 0, 0);
//		folha.setSalarioBase(3200);
//		double valor = folha.calcularFerias(20, 10);
//		assertEquals(valor, 3579.06, 0.01);
//	}
	
	
	
	@Test
	public void testeCalculoIntegrado() {
		CadastroColaborador cadastro = new CadastroColaborador();
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 1500.0);
		cadastro.addColaboradores(jorge);
		Ponto pontoJorge = new Ponto(220, 0, 0, 250, 0, true, 100, 25);
		jorge.setPonto(pontoJorge);
		
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		
		
		assertEquals(folha1.calcularFolha(), 1342.50, 0.01);
		
	}
	
	@Test
	public void testeCalculoIntegrado2() {
		CadastroColaborador cadastro = new CadastroColaborador();
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2500.0);
		cadastro.addColaboradores(jorge);
		Ponto pontoJorge = new Ponto(220, 15, 10, 250, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);
		
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		
		assertEquals(folha1.calcularFolha(), 2440.08, 0.01);
		
	}
	
}
