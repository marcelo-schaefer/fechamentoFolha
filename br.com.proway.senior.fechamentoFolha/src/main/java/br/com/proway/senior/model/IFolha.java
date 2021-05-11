package br.com.proway.senior.model;

import java.time.LocalDate;

/**
 * Interface IFolha
 * 
 * Especifica uma folha para ser utilizada pelo builder.
 * 
 * @author Lucas Grij�
 * @author Lucas Walim
 * @author Marcelo Schaefer
 */
public interface IFolha {
	public int getId();

	public Integer getIdColaborador();

	public LocalDate getDataEmissao();

	public double getSalarioLiquido();

	public double getSalarioBruto();

	public double getValorHorasTrabalhadas();

	public double getValorHorasFaltas();

	public double getValorHorasExtras();

	public double getValorReflexoDSR();

	public double getValorInss();

	public double getValorImpostoDeRenda();

	public double getValorPlanoSaude();

	public double getValorValeTransporte();

	public double getValorFerias();

	public double getValorInssFerias();

	public double getValorImpostoDeRendaFerias();

	public double getFeriasLiquido();
	
	public double getValorFGTS();
}
