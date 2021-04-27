package br.com.proway.senior.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import br.com.proway.senior.model.Folha;

public class CalculosDescontoTest {

	@Test
	public void testCalcularDescontoPlanoSaude() {
		CalculosDesconto descontos = new CalculosDesconto();
		Folha folha = new Folha();
		folha.setMensalidadePlanoSaude(100);
		folha.setValorCooparticipacaoPlanoSaude(25);
		double descontoPlanoSaude = descontos.calcularDescontoPlanoSaude(folha);
		assertEquals(125, descontoPlanoSaude, 0.01);
	}

	@Test
	public void testCalcularDescontoInssFolha() {
		CalculosDesconto descontos = new CalculosDesconto();
		Folha folha = new Folha();
		folha.setSalarioBruto(2864.54);
		folha.setInss(0);
		double inss = descontos.calcularDescontoInss(folha);
		assertEquals(315.10, inss, 0.01);
	}

	@Test
	public void testCalcularDescontoInssDoubleFolha() {
		CalculosDesconto descontos = new CalculosDesconto();
		Folha folha = new Folha();
		folha.setSalarioBruto(2500.0);
		double inss = descontos.calcularDescontoInss(833.33, folha);
		assertEquals(91.66, inss, 0.01);
	}

	@Test
	public void testCalcularDescontoImpostoRendaFolha() {
		CalculosDesconto descontos = new CalculosDesconto();
		Folha folha = new Folha();
		folha.setSalarioBruto(3200);
		folha.setNumeroDependentes(3);
		
		double IR = descontos.calcularDescontoImpostoRenda(folha);
		assertEquals(54.54, IR, 0.01);
	}

	@Ignore
	public void testCalcularDescontoImpostoRendaDoubleFolha() {
		// Método não funciona pois necessita do método de calculo do valor de férias
		CalculosDesconto descontos = new CalculosDesconto();
		Folha folha = new Folha();
		folha.setNumeroDependentes(3);
		
		double IR = descontos.calcularDescontoImpostoRenda(2333.33, folha);
		assertEquals(0, IR, 0.01);
	}

	@Test
	public void testCalcularDescontoValeTransporte() {
		CalculosDesconto descontos = new CalculosDesconto();
		Folha folha = new Folha();
		
		folha.setValeTransporte(true);
		folha.setSalarioBase(3200);
		
		double transporte = descontos.calcularDescontoValeTransporte(folha);
		assertEquals(180D, transporte, 0.01);
	}

}
