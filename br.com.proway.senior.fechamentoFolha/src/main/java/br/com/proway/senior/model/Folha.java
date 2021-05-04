package br.com.proway.senior.model;

import java.time.LocalDate;

/**
 * Folha.
 * 
 * Objeto central do sistema. Refere-se a uma folha de pagamento de um
 * colaborador. Implementado para utilizar o design pattern builder com
 * director.
 * 
 * @author Bruno Oliveira
 * @author Leonado Pereira
 * @author Lucas Grijó
 * @author Lucas Walim
 * @author Marcelo Schaefer
 */
public class Folha implements IFolha {
	private int id;
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
	// Folha Férias
	private double valorFerias;
	private double valorInssFerias;
	private double valorImpostoDeRendaFerias;
	private double feriasLiquido;

	/**
	 * Método Construtor da Folha.
	 * 
	 * @param id
	 * @param idColaborador
	 * @param dataEmissao
	 * @param valorHorasTrabalhadas
	 * @param valorHorasFaltas
	 * @param valorHorasExtras
	 * @param valorReflexoDSR
	 * @param valorInss
	 * @param valorImpostoDeRenda
	 * @param valorPlanoSaude
	 * @param valorValeTransporte
	 * @param salarioBruto
	 * @param salarioLiquido
	 * @param valorFerias
	 * @param valorInssFerias
	 * @param valorImpostoDeRendaFerias
	 * @param feriasLiquido
	 * @return Folha
	 * @author Lucas Grijó
	 * @author Lucas Walim
	 * @author Marcelo Schaefer
	 */
	public Folha(int id, Integer idColaborador, LocalDate dataEmissao, double valorHorasTrabalhadas,
			double valorHorasFaltas, double valorHorasExtras, double valorReflexoDSR, double valorInss,
			double valorImpostoDeRenda, double valorPlanoSaude, double valorValeTransporte, double salarioBruto,
			double salarioLiquido, double valorFerias, double valorInssFerias, double valorImpostoDeRendaFerias,
			double feriasLiquido) {
		this.id = id;
		this.idColaborador = idColaborador;
		this.dataEmissao = dataEmissao;
		this.valorHorasTrabalhadas = valorHorasTrabalhadas;
		this.valorHorasFaltas = valorHorasFaltas;
		this.valorHorasExtras = valorHorasExtras;
		this.valorReflexoDSR = valorReflexoDSR;
		this.valorInss = valorInss;
		this.valorImpostoDeRenda = valorImpostoDeRenda;
		this.valorPlanoSaude = valorPlanoSaude;
		this.valorValeTransporte = valorValeTransporte;
		this.salarioBruto = salarioBruto;
		this.salarioLiquido = salarioLiquido;
		this.valorFerias = valorFerias;
		this.valorInssFerias = valorInssFerias;
		this.valorImpostoDeRendaFerias = valorImpostoDeRendaFerias;
		this.feriasLiquido = feriasLiquido;
	}

	public int getId() {
		return id;
	}

	public Integer getIdColaborador() {
		return idColaborador;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public double getValorHorasTrabalhadas() {
		return valorHorasTrabalhadas;
	}

	public double getValorHorasFaltas() {
		return valorHorasFaltas;
	}

	public double getValorHorasExtras() {
		return valorHorasExtras;
	}

	public double getValorReflexoDSR() {
		return valorReflexoDSR;
	}

	public double getValorInss() {
		return valorInss;
	}

	public double getValorImpostoDeRenda() {
		return valorImpostoDeRenda;
	}

	public double getValorPlanoSaude() {
		return valorPlanoSaude;
	}

	public double getValorValeTransporte() {
		return valorValeTransporte;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public double getValorFerias() {
		return valorFerias;
	}

	public double getValorInssFerias() {
		return valorInssFerias;
	}

	public double getValorImpostoDeRendaFerias() {
		return valorImpostoDeRendaFerias;
	}

	public double getFeriasLiquido() {
		return feriasLiquido;
	}

	@Override
	public String toString() {
		return "Folha [id=" + id + ", idColaborador=" + idColaborador + ", dataEmissao=" + dataEmissao
				+ ", valorHorasTrabalhadas=" + valorHorasTrabalhadas + ", valorHorasFaltas=" + valorHorasFaltas
				+ ", valorHorasExtras=" + valorHorasExtras + ", valorReflexoDSR=" + valorReflexoDSR + ", valorInss="
				+ valorInss + ", valorImpostoDeRenda=" + valorImpostoDeRenda + ", valorPlanoSaude=" + valorPlanoSaude
				+ ", valorValeTransporte=" + valorValeTransporte + ", salarioBruto=" + salarioBruto
				+ ", salarioLiquido=" + salarioLiquido + ", valorFerias=" + valorFerias + ", valorInssFerias="
				+ valorInssFerias + ", valorImpostoDeRendaFerias=" + valorImpostoDeRendaFerias + ", feriasLiquido="
				+ feriasLiquido + "]";
	}

}
