package br.com.proway.senior.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import br.com.proway.senior.model.ColaboradorFolha;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.Ponto;

public class testeFolha {
	
	@Test
	public void testePlanoSaude() {
		ColaboradorFolha maria = new ColaboradorFolha("Maria", 0, "maria@gmail.com", 1600);
		Ponto pontoMaria = new Ponto(220, 15, 10, 250, 20, true, 100, 25);
		maria.setPonto(pontoMaria);		
		Folha folha = new Folha(maria);
		maria.addTotalFolhas(folha);
		
		double descontoPlanoSaude = folha.calcularDescontoPlanoSaude();		
		assertEquals(descontoPlanoSaude, 125, 0.01);
	}
	
	@Test
	public void testeHoraExtra() {
		ColaboradorFolha maria = new ColaboradorFolha("Maria", 0, "maria@gmail.com", 2000);
		Ponto pontoMaria = new Ponto(220, 30, 0, 0, 0, true, 0, 0);
		maria.setPonto(pontoMaria);
		Folha folha = new Folha(maria);
		maria.addTotalFolhas(folha);
		
		folha.calcularFolha();		
		assertEquals(folha.getValorHoraExtra(), 409.09, 0.01);
	}
	
	@Test
	public void testeHoraExtra2() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2200.0);
		Ponto ponto1 = new Ponto(220, 15.50, 0, 100, 0, true, 25, 115);
		jorge.setPonto(ponto1);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		folha.calcularValorDasHorasTrabalhadas();
		assertNotEquals(folha.calcularValorHorasExtras(), 232.55, 0.01);
	}
	
	@Test
	public void testeCalculoInss() {
		ColaboradorFolha maria = new ColaboradorFolha("Maria", 0, "maria@gmail.com", 2300);
		Ponto pontoMaria = new Ponto(220, 30, 0, 0, 0, false, 0, 0);
		maria.setPonto(pontoMaria);
		Folha folha = new Folha(maria);
		maria.addTotalFolhas(folha);
		
		folha.calcularFolha();
		double inss = folha.getValorInss();
		assertEquals(inss, 315.10, 0.01);
	}
	
	@Test
	public void testeCalculoInss2() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 9.67, 3.51, 358, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		folha.calcularFolha();
		
		assertEquals(folha.getValorInss(), 357.47, 0.01);
	}
	
	@Test
	public void testeHorasFaltas() {

		ColaboradorFolha maria = new ColaboradorFolha("Maria", 0, "maria@gmail.com", 1598);
		Ponto pontoMaria = new Ponto(220, 30, 20, 0, 0, false, 0, 0);
		maria.setPonto(pontoMaria);
		Folha folha = new Folha(maria);
		maria.addTotalFolhas(folha);
		
		folha.calculaValorHora();
		assertEquals(folha.calcularValorHorasFaltas(), 145.27 , 0.01);
	}
	
	@Test
	public void testeHoraFaltas2() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2200.0);
		Ponto ponto1 = new Ponto(220, 0, 16.59, 100, 0, true, 25, 115);
		jorge.setPonto(ponto1);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		folha.calculaValorHora();
		
		assertEquals(folha.calcularValorHorasFaltas(), 165.90, 0.01 );
	}

	@Test
	public void testeHorasFaltasComInsaLubridade() {
	
		ColaboradorFolha maria = new ColaboradorFolha("Maria", 0, "maria@gmail.com", 2300);
		Ponto pontoMaria = new Ponto(220, 0, 7.73, 100, 40, true, 100, 25);
		maria.setPonto(pontoMaria);
		Folha folha = new Folha(maria);
		maria.addTotalFolhas(folha);
		
		folha.calcularFolha();		
		assertEquals(folha.getValorHorasFaltas(), 96.27, 0.01 );
	}	
	
	@Test
	public void testePlanoSaudeValorMensalidadeNegativo() {	
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, 250, 20, true, -100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		assertEquals(folha.calcularDescontoPlanoSaude(), 0, 0.01);
	}
	
	@Test
	public void testecalcularBonificacao() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, 358, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		assertEquals(folha.calcularBonificacao(), 358, 0.01);
	}
	
	@Test
	public void testeAdicionaBonificacaoNegativa() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, -358, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		assertEquals(folha.calcularBonificacao(), 0, 0.01);
	}
		
	@Test
	public void testeCalculoImpostoRenda() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 0, 0, -52, 20, true, 25, 115);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		folha.setSalarioBruto(3200);
		assertEquals(folha.calcularDescontoImpostoRenda(), 125.20, 0.01);
	}
	
	@Test
	public void testeCalculoImpostoRenda0() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 0, 0, -52, 20, true, 25, 115);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		folha.setSalarioBruto(1903);		
		assertEquals(folha.calcularDescontoImpostoRenda(), 0, 0.01);
	}
	
	@Test
	public void testeCalculoImpostoRendaDependente() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 9.17, 1.59, 158, 20, true, 25, 115);
		jorge.setPonto(pontoJorge);
		jorge.addDependentes("Craudio");
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		folha.calcularFolha();	
		assertEquals(folha.getvalorImpostoDeRenda(), 47.39, 0.01);
	}
	
	@Test
	public void testeValorInsalubridade() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2500.0);
		
		Ponto ponto1 = new Ponto(0, 0, 0, 0, 10, true, 0, 0);
		jorge.setPonto(ponto1);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		assertEquals(folha.calculaInsalubridade(), 110, 0.01);
		
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
	public void testeCalculaValorHoras() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2200.0);
		Ponto ponto1 = new Ponto(220, 0, 0, 100, 20, true, 25, 115);
		jorge.setPonto(ponto1);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		assertEquals(folha.calculaValorHora(), 11, 0.01);
	}
	
	@Test
	public void testeValeTransporteTrue() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1500.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, 250, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);		
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		assertEquals(folha.calcularDescontoValeTransporte(), 90, 0.01);
	}
	
	@Test
	public void testeValeTransporteFalse() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1900.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, 250, 20, false, 100, 25);
		jorge.setPonto(pontoJorge);		
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		assertEquals(folha.calcularDescontoValeTransporte(), 0, 0.01);
	}
	
	@Test
	public void testeCalculaFolha() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1500.0);
		Ponto pontoJorge = new Ponto(220, 0, 0, 250, 0, true, 100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);		
		
		assertEquals(folha.calcularFolha(), 1342.50, 0.01);		
	}
	
	@Test
	public void testeCalculaFolha2() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 15, 10, 250, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		assertEquals(folha.calcularFolha(), 2485.60, 0.01);		
	}
	
	@Test
	public void testeCalculaFolha3() {

		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1200.0);
		Ponto pontoJorge = new Ponto(220, 17.10, 7.46, 122, 40, true, 100, 15);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		double valor = folha.calcularFolha();
		assertEquals(valor, 1535.89, 0.01);
	}
	
	@Test
	public void testeCalculaFolhaComDependente() {

		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2751.0);
		Ponto pontoJorge = new Ponto(220, 19.37, 12.89, 153, 10, true, 100, 127);
		jorge.setPonto(pontoJorge);
		jorge.addDependentes("Tiburcio");
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		double valor = folha.calcularFolha();
		assertEquals(valor, 2481.50, 0.01);
	}
	
	@Test
	public void testeCalculoFolha4() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1345.0);
		Ponto pontoJorge = new Ponto(175, 6.33, 2.71, 120, 10, true, 100, 0);
		jorge.setPonto(pontoJorge);		
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		double valor = folha.calcularFolha();
		assertEquals(valor, 1007.28, 0.01);
	}
	
	@Test
	public void testeDataAtual() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 3000.0);
		Ponto pontoJorge = new Ponto(220, 0, 0, 0, 0, true, 100, 50);
		jorge.setPonto(pontoJorge);	
		Folha folha = new Folha(jorge);
		
		LocalDateTime dataTime = LocalDateTime.now();    
	    DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String data = dataTime.format(dataFormatada);
	    folha.setDataEmissao();
	    String dataResult = folha.getDataEmissao(); 
	    assertEquals(data, dataResult);	    
	}
	
	@Test
	public void testeReflexoDSRHoraExtra() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1000.0);
		Ponto pontoJorge = new Ponto(220, 10, 0, 0, 0, false, 0, 0);
		jorge.setPonto(pontoJorge);	
		Folha folha = new Folha(jorge);
		
		folha.calcularFolha();		
		assertEquals(folha.getReflexoDSR(), 13.63, 0.01);
	}
	
	@Test
	public void testeImpostoDeRendaComDependente() {
		ColaboradorFolha bruno = new ColaboradorFolha("Bruno", 0, "bruno@gmail.com", 2570);
		Ponto pontoBruno = new Ponto(220, 0, 0, 0, 0, false, 109, 0);
		bruno.setPonto(pontoBruno);
		bruno.addDependentes("Maya");
		Folha folha = new Folha(bruno);
		
		folha.calcularFolha();
		assertEquals(folha.getSalarioLiquido(), 2163.77, 0.01);
	}
	
}
