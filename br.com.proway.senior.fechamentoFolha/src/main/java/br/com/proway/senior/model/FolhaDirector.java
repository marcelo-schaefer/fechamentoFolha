package br.com.proway.senior.model;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.IFeriasFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * FolhaDirector
 * 
 * E uma classe que contem a logica de direcao da construcao de uma {@link Folha}
 * seguindo o design pattern builder com director. 
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
public class FolhaDirector {

	private IFolhaBuilder builder;

	/**
	 * Metodo Construtor.
	 * 
	 * @param builder {@link IFolhaBuilder}.
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public FolhaDirector(IFolhaBuilder builder) {
		this.builder = builder;
	};

	/**
	 * Criar folha normal.
	 * 
	 * Constroi uma folha regular, sem qualquer contabilidade de ferias.
	 * 
	 * @return builder {@link FolhaDirector#builder}.
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */	
	public Folha createFolhaNormal(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo, Bonificacao bonificacao) {
		builder.setDataEmissaoFolha();
		builder.calcularPlr();
		builder.iniciarCalculos(colaborador, cargo);
		builder.calcularHorasNormais(ponto, cargo);
		builder.atribuiBonificacaoColaboradorCargo(cargo, bonificacao);
		builder.calcularDescontoNormal(colaborador, cargo);
		return builder.build();
	}

	/**
	 * Criar folha ferias.
	 * 
	 * Constroi uma folha exclusiva de {@link Ferias}
	 * 
	 * @return builder {@link FolhaDirector#builder}.
	 * 
	 * @author Lucas Grijo
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */	
	public Folha createFolhaFerias(IColaboradorFolha colaborador, ICargoFolha cargo, IFeriasFolha ferias) {
		builder.setDataEmissaoFolha();
		builder.iniciarCalculos(colaborador, cargo);
		builder.calcularHorasFerias(ferias);
		builder.calcularDescontoFerias(colaborador);
		return builder.build();
	}

	/**
	 * Criar folha hibrida
	 * 
	 * Constroi uma folha que contabiliza tanto horas de trabalho normais
	 * quanto horas de ferias.
	 * 
	 * @return builder {@link FolhaDirector#builder}.
	 * 
	 * @author Lucas Grijo
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */	
	public Folha createFolhaHibrida(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo,
			IFeriasFolha ferias) {
		builder.setDataEmissaoFolha();
		builder.iniciarCalculos(colaborador, cargo);
		builder.calcularPlr();
		builder.calcularHorasNormais(ponto, cargo);
		builder.calcularDescontoNormal(colaborador, cargo);
		builder.calcularHorasFerias(ferias);
		builder.calcularDescontoFerias(colaborador);
		return builder.build();
	}
}