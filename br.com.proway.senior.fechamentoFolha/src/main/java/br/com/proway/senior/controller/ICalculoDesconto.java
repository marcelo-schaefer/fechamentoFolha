package br.com.proway.senior.controller;

import br.com.proway.senior.model.CargoFolha;
import br.com.proway.senior.model.ColaboradorFolha;

public interface ICalculoDesconto {
	public double calcularDescontoInss(double salarioBrutoAcumulado);
	public double calcularDescontoImpostoRenda(ColaboradorFolha colaboradorFolha, double salarioBrutoAcumulado);
	public double calcularDescontoPlanoSaude(ColaboradorFolha colaboradorFolha);	
	public double calcularDescontoValeTransporte(ColaboradorFolha colaboradorFolha, CargoFolha cargoFolha);
}
