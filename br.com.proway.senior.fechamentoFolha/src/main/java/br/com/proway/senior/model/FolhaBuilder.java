package br.com.proway.senior.model;

import java.time.LocalDate;

public class FolhaBuilder implements InterfaceFolhaBuilder {

	private int id;
	private Integer idColaborador;
	private LocalDate dataEmissao;
	private double salarioLiquido;
	private double salarioBruto = 0;
	private double valorHoras;
	private double valorHoraComInsalubridade;
	private double horasTrabalhadas;
	private double horasExtra;
	private double valorHoraExtra;
	private double reflexoDSR;
	private double horasFalta;
	private double valorHorasFaltas;
	private double valorBonificacao;
	private double planoSaude;
	private double percentualInsalubridade;
	private double valorInsalubridade;
	private double inss;
	private double valorImpostoDeRenda;
	
	private InterfaceColaboradorFolha colaboradorFolha;
	private InterfacePontoFolha ponto;
	private InterfaceFeriasFolha ferias;
	private InterfaceCargoFolha cargo;

	private double mensalidadePlanoSaude;
	private double valorCooparticipacaoPlanoSaude;
	private double valorValeTransporte;
	private boolean valeTransporte;
	private double fator = 0.5; // 50% adicional hora extra
	private double salarioMinimo = 1100;
	private double salarioBase;
	private int numeroDependentes;
	private double valorPorDependente = 189.59;
	private int dias;
	private int abono;

	public Folha build() {
		return new Folha(this.colaboradorFolha, this.ponto, this.ferias, this.cargo);
	}

	public void setColaboradorFolha(InterfaceColaboradorFolha colaboradorFolha) {
		this.colaboradorFolha = colaboradorFolha;
	}

	public void setPonto(InterfacePontoFolha ponto) {
		this.ponto = ponto;
	}

	public void setFerias(InterfaceFeriasFolha ferias) {
		this.ferias = ferias;
	}


	public void setCargo(InterfaceCargoFolha cargo) {
		this.cargo = cargo;
	}	
	
	public int getId() {
		return id;
	}

	public void setId(InterfaceColaboradorFolha colaborador) {
		this.id = colaborador.getId();
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

	public double getValorHoras() {
		return valorHoras;
	}

	public void setValorHoras(double valorHoras) {
		this.valorHoras = valorHoras;
	}

	public double getValorHoraComInsalubridade() {
		return valorHoraComInsalubridade;
	}

	public void setValorHoraComInsalubridade(double valorHoraComInsalubridade) {
		this.valorHoraComInsalubridade = valorHoraComInsalubridade;
	}

	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(InterfacePontoFolha ponto) {
		this.horasTrabalhadas = ponto.getHorasTrabalhadas();
	}

	public double getHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(InterfacePontoFolha ponto) {
		this.horasExtra = ponto.getHorasExtra();
	}

	public double getValorHoraExtra() {
		return valorHoraExtra;
	}

	public void setValorHoraExtra(double valorHoraExtra) {
		this.valorHoraExtra = valorHoraExtra;
	}

	public double getReflexoDSR() {
		return reflexoDSR;
	}

	public void setReflexoDSR(double reflexoDSR) {
		this.reflexoDSR = reflexoDSR;
	}

	public double getHorasFalta() {
		return horasFalta;
	}

	public double getValorHorasFaltas() {
		return valorHorasFaltas;
	}

	public void setValorHorasFaltas(InterfacePontoFolha ponto) {
		this.valorHorasFaltas = ponto.getHorasFaltas();
	}

	public double getValorBonificacao() {
		return valorBonificacao;
	}

	public void setValorBonificacao(InterfaceCargoFolha cargo) {
		this.valorBonificacao = cargo.getValorBonificacao();
	}

	public double getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(double planoSaude) {
		this.planoSaude = planoSaude;
	}

	public double getPercentualInsalubridade() {
		return percentualInsalubridade;
	}

	public void setPercentualInsalubridade(InterfaceCargoFolha cargo) {
		this.percentualInsalubridade = cargo.getPercentualInsalubridade();
	}

	public double getValorInsalubridade() {
		return valorInsalubridade;
	}

	public void setValorInsalubridade(double valorInsalubridade) {
		this.valorInsalubridade = valorInsalubridade;
	}

	public double getInss() {
		return inss;
	}

	public void setInss(double inss) {
		this.inss = inss;
	}

	public double getValorImpostoDeRenda() {
		return valorImpostoDeRenda;
	}

	public void setValorImpostoDeRenda(double valorImpostoDeRenda) {
		this.valorImpostoDeRenda = valorImpostoDeRenda;
	}

	public double getMensalidadePlanoSaude() {
		return mensalidadePlanoSaude;
	}

	public void setMensalidadePlanoSaude(InterfaceColaboradorFolha colab) {
		this.mensalidadePlanoSaude = colab.getPlanoSaudeMensalidade();
	}

	public double getValorCooparticipacaoPlanoSaude() {
		return valorCooparticipacaoPlanoSaude;
	}

	public void setValorCooparticipacaoPlanoSaude(InterfaceColaboradorFolha colab) {
		this.valorCooparticipacaoPlanoSaude = colab.getPlanoSaudeCooparticipacao();
	}

	public double getValorValeTransporte() {
		return valorValeTransporte;
	}

	public void setValorValeTransporte(double valorValeTransporte) {
		this.valorValeTransporte = valorValeTransporte;
	}

	public boolean isValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(InterfaceColaboradorFolha colab) {
		this.valeTransporte = colab.getValeTransporte();
	}

	public double getFator() {
		return fator;
	}

	public void setFator(double fator) {
		this.fator = fator;
	}

	public double getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(InterfaceCargoFolha cargo) {
		this.salarioBase = cargo.getSalario();
	}

	public int getNumeroDependentes() {
		return numeroDependentes;
	}

	public void setNumeroDependentes(InterfaceColaboradorFolha colab) {
		this.numeroDependentes = colab.getDependentes().size();
	}

	public double getValorPorDependente() {
		return valorPorDependente;
	}

	public void setValorPorDependente(double valorPorDependente) {
		this.valorPorDependente = valorPorDependente;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(InterfaceFeriasFolha ferias) {
		this.dias = ferias.getDias();
	}

	public int getAbono() {
		return abono;
	}

	public void setAbono(InterfaceFeriasFolha ferias) {
		this.abono = ferias.getAbono();
	}

	public void setHorasFalta(InterfacePontoFolha ponto) {
		this.horasFalta = ponto.getHorasFaltas();
		
	}

	public void setValorHorasFaltas(double valor) {
		this.valorHorasFaltas = valor;
		
	}


}
