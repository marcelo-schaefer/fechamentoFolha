package br.com.proway.senior.model;

import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.IFeriasFolha;
import br.com.proway.senior.model.externo.interfaces.IPlr;
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
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
 */
public class FolhaDirector {

	private IFolhaBuilder builder;

	/**
	 * M�todo Construtor
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public FolhaDirector(IFolhaBuilder builder) {
		this.builder = builder;
	};

	/**
	 * Criar folha normal
	 * 
	 * Constr�i uma folha regular ou seja, sem qualquer contabilidade de f�rias.
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */	
	public Folha createFolhaNormal(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo, IPlr plr) {
		builder.iniciarCalculos(colaborador, cargo);
		builder.calcularHorasNormais(ponto, cargo, plr);
		builder.calcularDescontoNormal(colaborador, cargo, plr	);
		return builder.build();
	}

	/**
	 * Criar folha ferias
	 * 
	 * Constroi uma folha exclusiva de {@link Ferias}
	 * 
	 * @author Lucas Grij�
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
	 * Constr�i uma folha que contabiliza tanto horas de trabalho normais quanto horas de f�rias.
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */	
	public Folha createFolhaHibrida(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo,
			IFeriasFolha ferias, IPlr plr) {
		builder.iniciarCalculos(colaborador, cargo);
		builder.calcularHorasNormais(ponto, cargo, plr);
		builder.calcularDescontoNormal(colaborador, cargo, plr);
		builder.calcularHorasFerias(ferias);
		builder.calcularDescontoFerias(colaborador);
		return builder.build();
	}
}