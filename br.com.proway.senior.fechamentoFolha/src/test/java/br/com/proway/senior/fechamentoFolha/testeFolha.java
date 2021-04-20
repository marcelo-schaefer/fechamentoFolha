package br.com.proway.senior.fechamentoFolha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

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
		
		folha.calcularHorasTrabalhadas();
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
		assertEquals(inss, 304.75, 0.01);
	}
	
	@Test
	public void testeCalculoInss2() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 2500.0);
		Ponto pontoJorge = new Ponto(220, 9.67, 3.51, 358, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		folha.calcularFolha();
		
		assertEquals(folha.getValorInss(), 353.53, 0.01);
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
		assertEquals(folha.getvalorImpostoDeRenda(), 45.12, 0.01);
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
		CadastroColaborador cadastro = new CadastroColaborador();
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1500.0);
		cadastro.addColaboradores(jorge);
		Ponto pontoJorge = new Ponto(220, 15, 10, 250, 20, true, 100, 25);
		jorge.setPonto(pontoJorge);		
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		assertEquals(folha.calcularDescontoValeTransporte(), 90, 0.01);
	}
	
	@Test
	public void testeValeTransporteFalse() {
		CadastroColaborador cadastro = new CadastroColaborador();
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1900.0);
		cadastro.addColaboradores(jorge);
		Ponto pontoJorge = new Ponto(220, 15, 10, 250, 20, false, 100, 25);
		jorge.setPonto(pontoJorge);		
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		assertEquals(folha.calcularDescontoValeTransporte(), 0, 0.01);
	}
	
	@Test
	public void testeCalculaFolha() {
		CadastroColaborador cadastro = new CadastroColaborador();
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1500.0);
		cadastro.addColaboradores(jorge);
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
		
		assertEquals(folha.calcularFolha(), 2440.08, 0.01);		
	}
	
	@Test
	public void testeCalculaFolha3() {

		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1200.0);
		Ponto pontoJorge = new Ponto(220, 17.10, 7.46, 122, 40, true, 100, 15);
		jorge.setPonto(pontoJorge);
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		double valor = folha.calcularFolha();
		assertEquals(valor, 1501.86, 0.01);
	}
	
	@Test
	public void testeCalculoFolha4() {
		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1345.0);
		Ponto pontoJorge = new Ponto(175, 6.33, 2.71, 120, 10, true, 100, 0);
		jorge.setPonto(pontoJorge);		
		Folha folha = new Folha(jorge);
		jorge.addTotalFolhas(folha);
		
		double valor = folha.calcularFolha();
		assertEquals(valor, 996.11, 0.01);
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
		
		
		//System.out.println(folha.getNumeroDependentes());
		
		double valor = folha.calcularFerias(30, 0);
		//double valor = folha.calcularValorDeduzirDependente();
		assertEquals(valor, 3437.67, 0.01);
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
	
//	@Test
//	public void testeReflexoDSRHoraExtra() {
//		ColaboradorFolha jorge = new ColaboradorFolha("Jorge", 0, "jorge@gmail.com", 1000.0);
//		Ponto pontoJorge = new Ponto(220, 10, 0, 0, 0, false, 0, 0);
//		jorge.setPonto(pontoJorge);	
//		Folha folha = new Folha(jorge);
//		
//		folha.calcularFolha();
//		
//		assertEquals(folha.getReflexoDSR(), 13.63, 0.01);
//	}
	
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
