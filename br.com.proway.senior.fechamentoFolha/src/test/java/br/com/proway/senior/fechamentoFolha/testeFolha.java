package br.com.proway.senior.fechamentoFolha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class testeFolha {



	@Test
	public void testaAdicionarBonificacao() {
		Colaborador maria = new Colaborador("Maria", 0, "maria@gmail.com", 2500.0);
		Ponto pontoMaria = new Ponto(220, 15, 10, 250, 20, true, 100, 25);
		maria.setPonto(pontoMaria);
		
		Folha folha1 = new Folha(maria);
		maria.addTotalFolhas(folha1);
		
		assertEquals(folha1.adicionaBonificacao(), 250, 0.01);
	}
	@Test
	public void testaPlanoSaude() {
		Colaborador maria = new Colaborador("Maria", 0, "maria@gmail.com", 1600);
		Ponto pontoMaria = new Ponto(220, 15, 10, 250, 20, true, 100, 25);
		maria.setPonto(pontoMaria);
		Folha folha1 = new Folha(maria);
		maria.addTotalFolhas(folha1);
		
		double descontoPlanoSaude = folha1.descontaPlanoSaude();
		
		assertEquals(descontoPlanoSaude, 125, 0.01);
	}
	@Test
	public void testaImpostoRenda() {
		Colaborador maria = new Colaborador("Maria", 0, "maria@gmail.com", 2826.66);
		Ponto pontoMaria = new Ponto(220, 15, 10, 250, 20, true, 100, 25);
		maria.setPonto(pontoMaria);
		Folha folha1 = new Folha(maria);
		maria.addTotalFolhas(folha1);
		
		folha1.setSalarioBruto(2826.66);
		assertEquals(folha1.calculaImpostoRenda(), 69.19, 0.01);
	}
	@Test
	public void testaHoraExtra() {
		Colaborador maria = new Colaborador("Maria", 0, "maria@gmail.com", 2000);
		Ponto pontoMaria = new Ponto(220, 30, 0, 0, 0, true, 0, 0);
		maria.setPonto(pontoMaria);
		Folha folha1 = new Folha(maria);
		maria.addTotalFolhas(folha1);

		folha1.calcularFolha();		
		assertEquals(folha1.valorHorasExtras(), 409.09, 0.01);
	}
	@Test
	public void testaInss() {
		Colaborador maria = new Colaborador("Maria", 0, "maria@gmail.com", 2300);
		Ponto pontoMaria = new Ponto(220, 30, 0, 0, 0, false, 0, 0);
		maria.setPonto(pontoMaria);
		Folha folha1 = new Folha(maria);
		maria.addTotalFolhas(folha1);
		folha1.calcularFolha();
		double inss = folha1.getValorInss();

		assertEquals(inss, 304.75, 0.01);
	}
	@Test
	public void testaHorasFaltas() {

		Colaborador maria = new Colaborador("Maria", 0, "maria@gmail.com", 1000);
		Ponto pontoMaria = new Ponto(220, 30, 20, 0, 0, false, 0, 0);
		maria.setPonto(pontoMaria);
		Folha folha1 = new Folha(maria);
		maria.addTotalFolhas(folha1);		
		folha1.calculaValorHora();
		folha1.valorHorasFaltas();
		assertEquals(folha1.valorHorasFaltas(), 90.90 , 0.01);
	}

	
	@Test
	public void testeHoraFaltas() {
	
		Colaborador maria = new Colaborador("Maria", 0, "maria@gmail.com", 2300);
		Ponto pontoMaria = new Ponto(220, 0, 10, 100, 0, true, 100, 25);
		maria.setPonto(pontoMaria);
		Folha folha1 = new Folha(maria);
		maria.addTotalFolhas(folha1);
		folha1.calcularFolha();
		
		assertEquals(folha1.valorHorasFaltas(), 104.54, 0.01 );
	}
	
	@Test
	public void testeHoraFaltasComHorasExtras() {
		
		Colaborador maria = new Colaborador("Maria", 0, "maria@gmail.com", 2300);
		Ponto pontoMaria = new Ponto(220, 15, 10, 100, 0, true, 100, 25);
		maria.setPonto(pontoMaria);
		Folha folha1 = new Folha(maria);
		maria.addTotalFolhas(folha1);
		
		folha1.calculaHorasTrabalhadas();
		
		double valor = folha1.valorHorasExtras() - folha1.valorHorasFaltas();
		assertEquals(valor, 130.68, 0.01 );
	}
	
	@Test
	public void testeHoraFaltasComHorasExtrasEInsalubridade() {
	
		Colaborador maria = new Colaborador("Maria", 0, "maria@gmail.com", 2200);
		Ponto pontoMaria = new Ponto(220, 15, 10, 100, 20, true, 100, 25);
		maria.setPonto(pontoMaria);
		Folha folha1 = new Folha(maria);
		maria.addTotalFolhas(folha1);
		
		folha1.calculaValorHora();		
		double valor = folha1.valorHorasExtras() - folha1.valorHorasFaltas();
		assertEquals(valor, 137.50, 0.01 );
	}
	
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
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, 250, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);
		
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		
		assertEquals(folha1.calcularFolha(), 2440.08, 0.01);
		
	}
	
	
	@Test
	public void testeCalculaFolha3() {

		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 1200.0);
		Ponto pontoJorge = new Ponto(220, 17.10, 7.46, 122, 40, true, 100, 15);
		jorge.setPonto(pontoJorge);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		
		double valor = folha1.calcularFolha();
		assertEquals(valor, 1501.86, 0.01);
	}
	
	@Test
	public void testeCalculoFolha4() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 1345.0);
		Ponto pontoJorge = new Ponto(175, 6.33, 2.71, 120, 10, true, 100, 0);
		jorge.setPonto(pontoJorge);		
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		
		double valor = folha1.calcularFolha();
		assertEquals(valor, 996.11, 0.01);
	}

	
	@Test
	public void testePlanoSaudeValorMensalidadeNegativo() {	
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, 250, 20, true, -100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		assertEquals(folha1.descontaPlanoSaude(), 0, 0.01);
	}
	
	@Test
	public void testeAdicionaBonificacao() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, 358, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		assertEquals(folha1.adicionaBonificacao(), 358, 0.01);
	}


	
	@Test
	public void testeAdicionaBonificacaoNegativa() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, -358, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		assertEquals(folha1.adicionaBonificacao(), 0, 0.01);
	}
	
	@Test
	public void testeCalculoInss() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, 358, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		folha1.setSalarioBruto(2987);
		assertEquals(folha1.descontoInss(), 328.57, 0.01);
	}
	
	@Test
	public void testeCalculoImpostoRenda() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 0, 0, -52, 20, true, 25, 115);
		jorge.setPonto(pontoJorge);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		folha1.setSalarioBruto(3200);
		assertEquals(folha1.calculaImpostoRenda(), 125.20, 0.01);
	}
	
	@Test
	public void testeCalculoImpostoRenda0() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 0, 0, -52, 20, true, 25, 115);
		jorge.setPonto(pontoJorge);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		folha1.setSalarioBruto(1903);
		
		assertEquals(folha1.calculaImpostoRenda(), 0, 0.01);
	}
	
	@Test
	public void testaValorInsalubridade() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2500.0);
		
		Ponto ponto1 = new Ponto(0, 0, 0, 0, 10, true, 0, 0);
		jorge.setPonto(ponto1);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		assertEquals(folha1.calculaInsalubridade(), 110, 0.01);
		
		Ponto ponto2 = new Ponto(0, 0, 0, 0, 20, true, 0, 0);
		jorge.setPonto(ponto2);
		Folha folha2 = new Folha(jorge);
		jorge.addTotalFolhas(folha2);
		assertEquals(folha2.calculaInsalubridade(), 220, 0.01);
		
		Ponto ponto3 = new Ponto(0, 0, 0, 0, 40, true, 0, 0);
		jorge.setPonto(ponto3);
		Folha folha3 = new Folha(jorge);
		jorge.addTotalFolhas(folha3);
		assertEquals(folha3.calculaInsalubridade(), 440, 0.01);
		
		Ponto ponto4 = new Ponto(0, 0, 0, 0, 80, true, 0, 0);
		jorge.setPonto(ponto4);
		Folha folha4 = new Folha(jorge);
		jorge.addTotalFolhas(folha4);
		assertEquals(folha4.calculaInsalubridade(), 0, 0.01);
	}
	
	@Test
	public void testaCalculaValorHoras() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto ponto1 = new Ponto(220, 0, 0, 100, 20, true, 25, 115);
		jorge.setPonto(ponto1);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		folha1.setSalarioBase(2200);
		assertEquals(folha1.calculaValorHora(), 11, 0.01);
	}
	
	@Test
	public void testaCalculaValorHoras2() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2200.0);
		Ponto ponto1 = new Ponto(220, 0, 0, 100, 10, true, 25, 115);
		jorge.setPonto(ponto1);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		assertEquals(folha1.calculaValorHora(), 10.50, 0.01);
	}
	
	@Test
	public void testaCalculaValorHoras3() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2200.0);
		Ponto ponto1 = new Ponto(220, 0, 0, 100, 0, true, 25, 115);
		jorge.setPonto(ponto1);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		assertEquals(folha1.calculaValorHora(), 10, 0.01);
	}
	
	@Test
	public void testaHoraExtra2() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2200.0);
		Ponto ponto1 = new Ponto(220, 15.50, 0, 100, 0, true, 25, 115);
		jorge.setPonto(ponto1);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		assertNotEquals(folha1.valorHorasExtras(), 232.55, 0.01);
	}
	
	@Test
	public void testeHoraFaltas2() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2200.0);
		Ponto ponto1 = new Ponto(220, 0, 10, 100, 0, true, 25, 115);
		jorge.setPonto(ponto1);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);
		folha1.calculaValorHora();
		assertEquals(folha1.valorHorasFaltas(), 100, 0.01 );
	}
	@Test
	public void testeHoraFaltasComHorasExtras2() {
		Colaborador jorge = new Colaborador("Jorge", 0, "jorge@gmail.com", 2200.0);
		Ponto ponto1 = new Ponto(220, 15, 10, 100, 0, true, 25, 115);
		jorge.setPonto(ponto1);
		Folha folha1 = new Folha(jorge);
		jorge.addTotalFolhas(folha1);	
		folha1.calculaValorHora();
		double valor = folha1.valorHorasExtras() - folha1.valorHorasFaltas();
		assertEquals(valor, 125, 0.01 );
	}
	
	
	

	
}
