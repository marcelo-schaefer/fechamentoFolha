package br.com.proway.senior.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.model.CargoFolha;
import br.com.proway.senior.model.ColaboradorFolha;
import br.com.proway.senior.model.FeriasFolha;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.PontoFolha;

public class CalculoFolhaTest {

	ArrayList<String> dependentes = new ArrayList<String>();
	FeriasFolha feriasVazias = new FeriasFolha();
	CalculoFolha calculo = new CalculoFolha();
	
	@Test
	public void testeCalculoFolha() {
		ColaboradorFolha colab = new ColaboradorFolha(0, true, 100, 25, dependentes);
		PontoFolha ponto = new PontoFolha(220, 0, 0);
		CargoFolha cargo = new CargoFolha(1500, 250, 0);		
		Folha folha = new Folha(colab, ponto, feriasVazias, cargo);
		calculo.calculoFolha(folha, null, null, null);
		
		assertEquals(1342.50, folha.getSalarioLiquido(), 0.01);
	}
	
	@Test
	public void testCalculoFolhaComDependente() {
		dependentes.add("dependente");
		ColaboradorFolha colab = new ColaboradorFolha(0, true, 100, 127, dependentes);
		PontoFolha ponto = new PontoFolha(220, 19.37, 12.89);
		CargoFolha cargo = new CargoFolha(2751.0, 153, 10);		
		Folha folha = new Folha(colab, ponto, feriasVazias, cargo);
		calculo.calculoFolha(folha);
	
		assertEquals(2481.50, folha.getSalarioLiquido(), 0.01);
	}
}
