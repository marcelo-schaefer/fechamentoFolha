package br.com.proway.senior.model;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.IFeriasFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * FolhaDirector
 * 
 * É uma classe que contém a lógica de direção da construção de uma Folha
 * seguindo o design pattern builder com director.
 * 
 * @author Lucas Grijó
 * @author Lucas Walim
 * @author Marcelo Schaefer
 */
public class FolhaDirector {

	private IFolhaBuilder builder;

	/**
	 * Método Construtor
	 * 
	 * @author Lucas Grijó
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public FolhaDirector(IFolhaBuilder builder) {
		this.builder = builder;
	};

	/**
	 * Criar folha normal
	 * 
	 * Constrói uma folha regular ou seja, sem qualquer contabilidade de férias.
	 * 
	 * @author Lucas Grijó
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */	
	public Folha createFolhaNormal(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo) {
		builder.iniciarCalculos(colaborador, cargo);
		builder.calcularHorasNormais(ponto, cargo);
		builder.calcularDescontoNormal(colaborador, cargo);
		return builder.build();
	}

	/**
	 * Criar folha férias
	 * 
	 * Constrói uma folha exclusiva de férias.
	 * 
	 * @author Lucas Grijó
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */	
	public Folha createFolhaFerias(IColaboradorFolha colaborador, ICargoFolha cargo, IFeriasFolha ferias) {
		builder.iniciarCalculos(colaborador, cargo);
		builder.calcularHorasFerias(ferias);
		builder.calcularDescontoFerias(colaborador);
		return builder.build();
	}

	/**
	 * Criar folha hibrida
	 * 
	 * Constrói uma folha que contabiliza tanto horas de trabalho normais quanto horas de férias.
	 * 
	 * @author Lucas Grijó
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */	
	public Folha createFolhaHibrida(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo,
			IFeriasFolha ferias) {
		builder.iniciarCalculos(colaborador, cargo);
		builder.calcularHorasNormais(ponto, cargo);
		builder.calcularDescontoNormal(colaborador, cargo);
		builder.calcularHorasFerias(ferias);
		builder.calcularDescontoFerias(colaborador);
		return builder.build();
	}

}
