package br.com.proway.senior.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Folha {
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
	
	// Folha Férias
	private double valorFerias; // férias bruto.
	private double valorInssFerias;
	private double valorImpostoDeRendaFerias;
	private double feriasLiquido;

	/**
	 * 
	 * Alterar conforme esse modelo: this.horasTrabalhadas =
	 * this.ponto.getHorasTrabalhadas();
	 * 
	 * Construtor que inicializa os métodos
	 * 
	 * @param colaborador
	 * @param ponto
	 */
	public Folha(IColaboradorFolha colaborador) {
		this.idColaborador = colaborador.getId();
		// Talvez chamar método calculoFolha?
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getValorHorasTrabalhadas() {
		return valorHorasTrabalhadas;
	}

	public void setValorHorasTrabalhadas(double valorHorasTrabalhadas) {
		this.valorHorasTrabalhadas = valorHorasTrabalhadas;
	}

	public double getValorHorasFaltas() {
		return valorHorasFaltas;
	}

	public void setValorHorasFaltas(double valorHorasFaltas) {
		this.valorHorasFaltas = valorHorasFaltas;
	}

	public double getValorHorasExtras() {
		return valorHorasExtras;
	}

	public void setValorHorasExtras(double valorHorasExtras) {
		this.valorHorasExtras = valorHorasExtras;
	}

	public double getValorReflexoDSR() {
		return valorReflexoDSR;
	}

	public void setValorReflexoDSR(double valorReflexoDSR) {
		this.valorReflexoDSR = valorReflexoDSR;
	}

	public double getValorInss() {
		return valorInss;
	}

	public void setValorInss(double valorInss) {
		this.valorInss = valorInss;
	}

	public double getValorImpostoDeRenda() {
		return valorImpostoDeRenda;
	}

	public void setValorImpostoDeRenda(double valorImpostoDeRenda) {
		this.valorImpostoDeRenda = valorImpostoDeRenda;
	}

	public double getValorPlanoSaude() {
		return valorPlanoSaude;
	}

	public void setValorPlanoSaude(double valorPlanoSaude) {
		this.valorPlanoSaude = valorPlanoSaude;
	}

	public double getValorValeTransporte() {
		return valorValeTransporte;
	}

	public void setValorValeTransporte(double valorValeTransporte) {
		this.valorValeTransporte = valorValeTransporte;
	}

	public double getValorFerias() {
		return valorFerias;
	}

	public void setValorFerias(double valorFerias) {
		this.valorFerias = valorFerias;
	}

	public double getValorInssFerias() {
		return valorInssFerias;
	}

	public void setValorInssFerias(double valorInssFerias) {
		this.valorInssFerias = valorInssFerias;
	}

	public double getValorImpostoDeRendaFerias() {
		return valorImpostoDeRendaFerias;
	}

	public void setValorImpostoDeRendaFerias(double valorImpostoDeRendaFerias) {
		this.valorImpostoDeRendaFerias = valorImpostoDeRendaFerias;
	}

	public double getFeriasLiquido() {
		return feriasLiquido;
	}

	public void setFeriasLiquido(double feriasLiquido) {
		this.feriasLiquido = feriasLiquido;
	}

}
