package br.com.proway.senior.model;

import java.time.LocalDate;

import br.com.proway.senior.controller.calculos.CalculoDesconto;
import br.com.proway.senior.controller.calculos.CalculoHoras;
import br.com.proway.senior.controller.calculos.ICalculoDesconto;
import br.com.proway.senior.controller.calculos.ICalculoHoras;
import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.IFeriasFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

/**
 * FolhaBuilder
 * 
 * ï¿½ uma classe que contï¿½m a lï¿½gica de construï¿½ï¿½o de uma Folha
 * seguindo o design pattern builder.
 * 
 * @author Lucas Grijï¿½
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
	// Folha Fï¿½rias
	private double valorFerias;
	private double valorInssFerias;
	private double valorImpostoDeRendaFerias;
	private double feriasLiquido;
	// Dados para construï¿½ï¿½o/calculo.
	private ICalculoHoras calculoHoras;
	private ICalculoDesconto calculoDesconto;
	private double valorHora;
	Bonificacao bonificacao;
	
	/**
	 * build
	 * 
	 * Constrï¿½i a folha com os dados calculados. Tambï¿½m determina a data de
	 * emissï¿½o.
	 * 
	 * @author Lucas Grijï¿½
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public Folha build() {
		dataEmissao = LocalDate.now();
		double valorPLR = 0;
		return new Folha(id, idColaborador, dataEmissao, valorHorasTrabalhadas, valorHorasFaltas, valorHorasExtras,
				valorReflexoDSR, valorInss, valorImpostoDeRenda, valorPlanoSaude, valorValeTransporte, salarioBruto,
				salarioLiquido, valorFerias, valorInssFerias, valorImpostoDeRendaFerias, feriasLiquido, valorFGTS,valorPLR);
	}

	/**
	 * Inicializa Calculos
	 * 
	 * Realiza os calculos inicias e instancia os objetos necessï¿½rios para o
	 * calculos de qualquer tipo de folha.
	 * 
	 * @author Lucas Grijï¿½
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
	 * Realiza os calculo do valor recebido pertinente a horas trabalhadas, faltas,
	 * horas extras e reflexo DSR.
	 * 
	 * @author Lucas Grijï¿½
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public void calcularHorasNormais(IPontoFolha ponto, ICargoFolha cargo) {
		valorHorasTrabalhadas = (calculoHoras.calcularValorDasHorasTrabalhadas(ponto, valorHora));
		valorHorasFaltas = (calculoHoras.calcularValorHorasFaltas(ponto, valorHora));
		valorHorasExtras = (calculoHoras.calcularValorHorasExtras(ponto, valorHora));
		valorReflexoDSR = (calculoHoras.calcularDSR(valorHorasExtras));
		salarioBruto = (valorHorasTrabalhadas - valorHorasFaltas + valorHorasExtras + valorReflexoDSR);
		valorFGTS = (valorFGTS * salarioBruto);
	}

	/**
	 * Calculo de descontos em folha normal.
	 * 
	 * Atribui descontos no salario pertinente a inss, imposto de renda, plano de
	 * saude e vale transporte. Tambï¿½m determina o salï¿½rio liquido.
	 * 
	 * @author Lucas Grijï¿½
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public void calcularDescontoNormal(IColaboradorFolha colaborador, ICargoFolha cargo) {
		valorInss = (calculoDesconto.calcularDescontoInss(salarioBruto));
		salarioLiquido = ((salarioBruto) - valorInss);
		valorImpostoDeRenda = (calculoDesconto.calcularDescontoImpostoRenda(colaborador, salarioLiquido));
		valorPlanoSaude = (calculoDesconto.calcularDescontoPlanoSaude(colaborador));
		valorValeTransporte = (calculoDesconto.calcularDescontoValeTransporte(colaborador, cargo));
		salarioLiquido = (salarioLiquido - valorValeTransporte - valorImpostoDeRenda - valorPlanoSaude);
		valorFGTS = (calculoDesconto.calcularFGTS(salarioBruto));
	}

	/**
	 * Calculo das horas fï¿½rias
	 * 
	 * Realiza os calculo do valor recebido pertinente a horas de fï¿½rias.
	 * 
	 * @author Lucas Grijï¿½
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public void calcularHorasFerias(IFeriasFolha feriasFolha) {
		this.valorFerias = (calculoHoras.calcularFerias(feriasFolha.getDias(), feriasFolha.getAbono(), valorHora));
	}

	/**
	 * Calculo de descontos em folha fï¿½rias.
	 * 
	 * Atribui descontos no valor das fï¿½rias pertinente a inss e imposto de renda.
	 * Tambï¿½m determina a fï¿½rias liquido.
	 * 
	 * @author Lucas Grijï¿½
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public void calcularDescontoFerias(IColaboradorFolha colaborador) {
		valorInssFerias = (calculoDesconto.calcularDescontoInss(valorFerias));
		feriasLiquido = (valorFerias - valorInssFerias);
		valorImpostoDeRendaFerias = (calculoDesconto.calcularDescontoImpostoRenda(colaborador, feriasLiquido));
		feriasLiquido = (feriasLiquido - valorImpostoDeRendaFerias);
	}

	/**
	 * Altera a bonificação por colaborador atribuindo ao salarioBruto o valor atribuido
	 * @param colaborador 
	 */
	public double atribuiBonificacaoColaborador(IColaboradorFolha colaborador) {
		return (salarioBruto * bonificacao.getPorcentagemBonificacaoColaborador());
	}
	
	/**
	 * Altera a bonificação por Cargo atribuindo ao salarioBruto o valor atribuido 
	 * variavel cargo do Cargo se refere ao ICargo, e as variaveis que devereão ser implementadas
	 * a variavel b recebe o cargo e com o percentual da bonificação resulta o novo valor Bruto
	 * @param cargo
	 */
	public double atribuiBonificacaoCargo(ICargoFolha cargo) {
		double b = cargo.getSalarioBase();
		b += (b * cargo.getPorcentagemBonificacaoCargo());
		return b;
	}
	
	/**
	 * Altera a bonificação por Cargo atribuindo ao salarioBruto o valor atribuido 
	 * variavel cargo do Cargo se refere ao ICargo, e as variaveis que devereão ser implementadas
	 * @param colaborador
	
	public double pegatribuiBonificacaoSetor(ISetor setor,double valor) {
		return (setor.getSalarioBase() * b.getPorcentagemBonificacaoCargo());
	*/
	/**
	 * Altera a bonificação por Empresa atribuindo ao salarioBruto o valor atribuido 
	 * variavel cargo do Empresa se refere ao IEmpresa, e as variaveis que devereão ser implementadas
	 * @param empresa
	
	public double pegatribuiBonificacaoEmpresa(IEmpresa empresa) {
		return (empresa.getSalarioBase() * b.getPorcentagemBonificacaoCargo());
	}	 */
}