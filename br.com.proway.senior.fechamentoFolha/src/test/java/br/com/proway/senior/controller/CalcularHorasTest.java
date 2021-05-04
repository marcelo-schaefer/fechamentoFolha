package br.com.proway.senior.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.controller.calculos.CalculoHoras;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.FeriasFolha;
import br.com.proway.senior.model.externo.PontoFolha;

public class CalcularHorasTest {
	
	ArrayList<String> dependentes = new ArrayList<String>();
	FeriasFolha feriasVazias = new FeriasFolha();
	CalculoHoras horas = new CalculoHoras();
	
	@Test
	public void testeHorasFaltas() {
		ColaboradorFolha colab = new ColaboradorFolha(0, false, 0, 0, dependentes);
		PontoFolha ponto = new PontoFolha(220, 30, 20);
		CargoFolha cargo = new CargoFolha(1598, 0, 0);		
		Folha folha = new Folha(colab, ponto, feriasVazias, cargo);
		horas.calcularValorHora(folha);
		assertEquals(145.27 , horas.calcularValorHorasFaltas(folha), 0.01);
	}
	
	@Test
	public void testeHoraFaltas2() {
		ColaboradorFolha colab = new ColaboradorFolha(0, true, 25, 115, dependentes);
		PontoFolha ponto = new PontoFolha(220, 0, 16.59);
		CargoFolha cargo = new CargoFolha(2200, 100, 0);		
		Folha folha = new Folha(colab, ponto, feriasVazias, cargo);
		
		horas.calcularValorHora(folha);
		assertEquals(165.90, horas.calcularValorHorasFaltas(folha), 0.01 );
	}
	
	@Test
	public void testeHorasFaltas3() {
		Folha folha = new Folha();
		folha.setSalarioBase(1598);
		folha.setHorasTrabalhadas(220);
		folha.setHorasExtra(30);
		folha.setHorasFalta(20);
		horas.calcularValorHora(folha);
		horas.calcularValorHorasFaltas(folha);
		assertEquals(145.27, folha.getValorHorasFaltas(), 0.01);
	}
	
	@Test
	public void testeHoraFaltas4() {
		Folha folha = new Folha();
		folha.setSalarioBase(2200);
		folha.setHorasTrabalhadas(220);
		folha.setHorasExtra(0);
		folha.setHorasFalta(16.59);
		horas.calcularValorHora(folha);
		horas.calcularValorHorasFaltas(folha);
		
		assertEquals(165.90, folha.getValorHorasFaltas(), 0.01 );
	}

	@Test
	public void testeHoraExtra() {
		Folha folha = new Folha();
		folha.setSalarioBase(2000);
		folha.setHorasTrabalhadas(220);
		folha.setHorasExtra(30);
		horas.calcularValorDasHorasTrabalhadas(folha);
		horas.calcularValorHorasExtras(folha);
		assertEquals(409.09, folha.getValorHoraExtra(), 0.01);
	}
	
	@Test
	public void testeHoraExtra2() {
		Folha folha = new Folha();
		folha.setSalarioBase(2200);
		folha.setHorasTrabalhadas(220);
		folha.setHorasExtra(15.5);
		
		horas.calcularValorDasHorasTrabalhadas(folha);
		horas.calcularValorHorasExtras(folha);
		
		assertNotEquals(232.55, folha.getValorHoraExtra(), 0.01);
	}
	
	@Test
	public void testeHorasFaltasComInsaLubridade() {
		ColaboradorFolha colab = new ColaboradorFolha(0, true, 25, 100, dependentes);
		PontoFolha ponto = new PontoFolha(220, 0, 7.73);
		CargoFolha cargo = new CargoFolha(2300, 100, 40);		
		Folha folha = new Folha(colab, ponto, feriasVazias, cargo);
		
		horas.calcularValorDasHorasTrabalhadas(folha);
		horas.calcularValorHorasFaltas(folha);
		
		assertEquals(96.27, folha.getValorHorasFaltas(), 0.01);
	}
	
	@Test
	public void testeCalculaValorHoras() {
		Folha folha = new Folha();
		folha.setSalarioBase(2200);
		folha.setHorasTrabalhadas(220);
		
		horas.calcularValorHora(folha);
		assertEquals(10, folha.getValorHoras(), 0.01);
	}
}
