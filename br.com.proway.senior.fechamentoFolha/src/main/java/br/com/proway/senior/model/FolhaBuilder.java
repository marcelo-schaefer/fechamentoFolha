package br.com.proway.senior.model;

import java.time.LocalDate;

import br.com.proway.senior.controller.calculos.CalculoDesconto;
import br.com.proway.senior.controller.calculos.CalculoHoras;
import br.com.proway.senior.controller.calculos.ICalculoDesconto;
import br.com.proway.senior.controller.calculos.ICalculoHoras;
import br.com.proway.senior.model.externo.ICargoFolha;
import br.com.proway.senior.model.externo.IColaboradorFolha;
import br.com.proway.senior.model.externo.IFeriasFolha;
import br.com.proway.senior.model.externo.IPontoFolha;

/**
 * FolhaBuilder
 * 
 * � uma classe que cont�m a l�gica de constru��o de uma Folha seguindo o design
 * pattern builder.
 * 
 * @author Lucas Grij�
 * @author Lucas Walim
 * @author Marcelo Schaefer
 * @author Leonardo Pereira
 */
public class FolhaBuilder implements IFolhaBuilder {

	private int id; //
	private Integer idColaborador;
	private LocalDate dataEmissao;
	// Folha Normal
	private double valorHorasTrabalhadas;
	private double valorHorasFaltas;
	private double valorHorasExtras;
	private double valorReflexoDSR;
	private double valorInss;
	private double valorImpostoDeRenda;
	private double valorPlanoSaude;
	private double valorValeTransporte;
	private double salarioBruto = 0;
	private double salarioLiquido;
	private double valorFGTS;
	// Folha F�rias
	private double valorFerias;
	private double valorInssFerias;
	private double valorImpostoDeRendaFerias;
	private double feriasLiquido;
	// Dados para constru��o/calculo.
	private ICalculoHoras calculoHoras;
	private ICalculoDesconto calculoDesconto;
	private double valorHora;

	/**
	 * build
	 * 
	 * Constr�i a folha com os dados calculados. Tamb�m determina a data de emiss�o.
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public Folha build() {
		dataEmissao = LocalDate.now();
		return new Folha(id, idColaborador, dataEmissao, valorHorasTrabalhadas, valorHorasFaltas, valorHorasExtras,
				valorReflexoDSR, valorInss, valorImpostoDeRenda, valorPlanoSaude, valorValeTransporte, salarioBruto,
				salarioLiquido, valorFerias, valorInssFerias, valorImpostoDeRendaFerias, feriasLiquido,valorFGTS);
	}

	/**
	 * Inicializa Calculos
	 * 
	 * Realiza os calculos inicias e instancia os objetos necess�rios para o calculos de qualquer tipo de folha.
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public void iniciarCalculos(IColaboradorFolha colaborador, ICargoFolha cargo) {
		idColaborador = colaborador.getId();
		this.calculoHoras = new CalculoHoras();
		this.calculoDesconto = new CalculoDesconto();
		valorHora = (calculoHoras.calcularValorHora(cargo));

	}

	/**
	 * Calculo das Horas Normais
	 * 
	 * Realiza os calculo do valor recebido pertinente a horas trabalhadas, faltas, horas extras e reflexo DSR.
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public void calcularHorasNormais(IPontoFolha ponto, ICargoFolha cargo) {
		valorHorasTrabalhadas = (calculoHoras.calcularValorDasHorasTrabalhadas(ponto, valorHora));
		valorHorasFaltas = (calculoHoras.calcularValorHorasFaltas(ponto, valorHora));
		valorHorasExtras = (calculoHoras.calcularValorHorasExtras(ponto, valorHora));
		valorReflexoDSR = (calculoHoras.calcularDSR(valorHorasExtras));
		salarioBruto = (valorHorasTrabalhadas - valorHorasFaltas + valorHorasExtras + valorReflexoDSR);
		valorFGTS = (valorFGTS*salarioBruto);
	}

	/**
	 * Calculo de descontos em folha normal.
	 * 
	 * Atribui descontos no salario pertinente a inss, imposto de renda, plano de saude e vale transporte. Tamb�m determina o sal�rio liquido.
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public void calcularDescontoNormal(IColaboradorFolha colaborador, ICargoFolha cargo) {
		valorInss = (calculoDesconto.calcularDescontoInss(salarioBruto));
		salarioLiquido = (salarioBruto - valorInss);
		valorImpostoDeRenda = (calculoDesconto.calcularDescontoImpostoRenda(colaborador, salarioLiquido));
		valorPlanoSaude = (calculoDesconto.calcularDescontoPlanoSaude(colaborador));
		valorValeTransporte = (calculoDesconto.calcularDescontoValeTransporte(colaborador, cargo));
		salarioLiquido = (salarioLiquido - valorValeTransporte - valorImpostoDeRenda - valorPlanoSaude);
		valorFGTS = (calculoDesconto.calcularFGTS(salarioBruto));
	}
	
	

	/**
	 * Calculo das horas f�rias
	 * 
	 * Realiza os calculo do valor recebido pertinente a horas de f�rias.
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public void calcularHorasFerias(IFeriasFolha feriasFolha) {
		valorFerias = (calculoHoras.calcularFerias(feriasFolha.getDias(), feriasFolha.getAbono(), valorHora));
	}

	/**
	 * Calculo de descontos em folha f�rias.
	 * 
	 * Atribui descontos no valor das f�rias pertinente a inss e imposto de renda. Tamb�m determina a f�rias liquido.
	 * 
	 * @author Lucas Grij�
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public void calcularDescontoFerias(IColaboradorFolha colaborador) {
		valorInssFerias = (calculoDesconto.calcularDescontoInss(valorFerias));
		feriasLiquido = (valorFerias - valorInssFerias);
		valorImpostoDeRendaFerias = (calculoDesconto.calcularDescontoImpostoRenda(colaborador, feriasLiquido));
		feriasLiquido = (feriasLiquido - valorImpostoDeRendaFerias);
	}

}
