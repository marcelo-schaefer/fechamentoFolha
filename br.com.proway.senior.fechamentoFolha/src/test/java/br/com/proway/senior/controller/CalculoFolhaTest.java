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
	public void testeCalculoFolha4() {
		ColaboradorFolha colab = new ColaboradorFolha(0, true, 100, 15, dependentes);
		PontoFolha ponto = new PontoFolha(220, 17.10, 7.46);
		CargoFolha cargo = new CargoFolha(1200, 122, 40);		
		Folha folha = new Folha(colab, ponto, feriasVazias, cargo);
		
		calculo.calculoFolha(folha);

		assertEquals(1535.89, folha.getSalarioLiquido(), 0.01);
		
	}

}
