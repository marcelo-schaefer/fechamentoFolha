package br.com.proway.senior.controller;

import br.com.proway.senior.model.CargoFolha;
import br.com.proway.senior.model.PontoFolha;

public interface ICalculoHoras {
	public double calcularValorDasHorasTrabalhadas(CargoFolha cargoFolha, PontoFolha pontoFolha);
	public double calcularFerias(int dias, int abono);
	public double calcularValorHorasFaltas(PontoFolha pontoFolha);
	public double calcularValorHorasExtras(PontoFolha pontoFolha, double valorHorasTrabalhadas);
	public double calcularDSR();
}
