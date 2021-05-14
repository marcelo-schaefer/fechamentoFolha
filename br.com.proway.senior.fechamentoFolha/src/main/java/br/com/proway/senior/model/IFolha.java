package br.com.proway.senior.model;

import java.time.LocalDate;

/**
 * Interface IFolha
 * 
 * Metodos getters implementados pela classe {@link Folha}.
 * 
 * @author Lucas Grij�
 * @author Lucas Walim
 * @author Marcelo Schaefer
 * 
 * Sprint 5:
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
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
	
	public double getValorPlr();
	
	public double getValorFGTS();
}
