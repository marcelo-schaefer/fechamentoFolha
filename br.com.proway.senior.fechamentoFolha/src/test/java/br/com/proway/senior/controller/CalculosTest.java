package br.com.proway.senior.controller;
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.proway.senior.model.CargoFolha;
import br.com.proway.senior.model.ColaboradorFolha;

public class CalculosTest {

	@Test
	public void testCalcularValorHora() {
		CargoFolha cargo = new CargoFolha(1500, 20);
		CalculoHoras calculoHoras = new CalculoHoras();
		
		assertEquals( 7.818181818181818 ,calculoHoras.calculaValorHora(cargo), 0.01);
	}
	
	@Test
	public void testInsalubridadeNegativa() {
		CargoFolha cargo = new CargoFolha(1500, -20);
		CalculoHoras calculoHoras = new CalculoHoras();
		
		assertEquals( 6.818181818181818 ,calculoHoras.calculaValorHora(cargo), 0.01);
	}

}
