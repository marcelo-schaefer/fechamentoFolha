package br.com.proway.senior.model;

import java.time.LocalDate;

public class Folha implements InterfaceFolha{
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
	public Folha(InterfaceColaboradorFolha colaborador, InterfacePontoFolha ponto, 
				InterfaceFeriasFolha ferias, InterfaceCargoFolha cargo) {
		this.horasTrabalhadas = ponto.getHorasTrabalhadas();
		this.horasExtra = ponto.getHorasExtra();
		this.horasFalta = ponto.getHorasFaltas();
		this.valorBonificacao = cargo.getValorBonificacao();
		this.percentualInsalubridade = cargo.getPercentualInsalubridade();
		this.mensalidadePlanoSaude = colaborador.getPlanoSaudeMensalidade();
		this.valorCooparticipacaoPlanoSaude = colaborador.getPlanoSaudeCooparticipacao();
		this.salarioBase = cargo.getSalario();
		this.valeTransporte = colaborador.getValeTransporte();
		this.numeroDependentes = colaborador.getDependentes().size();
		this.dias = ferias.getDias();
		this.abono = ferias.getAbono();
		//setDataEmissao();
	}



	// Set criado somente para debugar
	public void setSalarioBruto(double valor) {
		this.salarioBruto = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao() {
		LocalDate dataEmissaoTime = LocalDate.now();
		this.dataEmissao = dataEmissaoTime;
	}

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
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

	public double getHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(double horasExtra) {
		this.horasExtra = horasExtra;
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

	public void setHorasFalta(double horasFalta) {
		this.horasFalta = horasFalta;
	}

	public double getValorHorasFaltas() {
		return valorHorasFaltas;
	}

	public void setValorHorasFaltas(double valorHorasFaltas) {
		this.valorHorasFaltas = valorHorasFaltas;
	}

	public double getValorBonificacao() {
		return valorBonificacao;
	}

	public void setValorBonificacao(double valorBonificacao) {
		this.valorBonificacao = valorBonificacao;
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

	public void setMensalidadePlanoSaude(double mensalidadePlanoSaude) {
		this.mensalidadePlanoSaude = mensalidadePlanoSaude;
	}

	public double getValorCooparticipacaoPlanoSaude() {
		return valorCooparticipacaoPlanoSaude;
	}

	public void setValorCooparticipacaoPlanoSaude(double valorCooparticipacaoPlanoSaude) {
		this.valorCooparticipacaoPlanoSaude = valorCooparticipacaoPlanoSaude;
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

	public void setValeTransporte(boolean valeTransporte) {
		this.valeTransporte = valeTransporte;
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

	public int getNumeroDependentes() {
		return numeroDependentes;
	}

	public double getValorPorDependente() {
		return valorPorDependente;
	}

	public void setValorPorDependente(double valorPorDependente) {
		this.valorPorDependente = valorPorDependente;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public double getSalarioBase() {
		return salarioBase;
	}
	public Integer getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}
	
	public int getDias() {
		return dias;
	}

	public int getAbono() {
		return abono;
	}

// ------------------------------------------------------------------//
	
	public void setId(InterfaceColaboradorFolha colaborador) {
		// TODO
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		// TODO Auto-generated method stub
	}

	public void setHorasTrabalhadas(InterfacePontoFolha ponto) {
		this.horasTrabalhadas = ponto.getHorasTrabalhadas();
		
	}

	public void setHorasExtra(InterfacePontoFolha ponto) {
		this.horasExtra = ponto.getHorasExtra();
	}

	public void setValorHorasFaltas(InterfacePontoFolha ponto) {
		// TODO Auto-generated method stub
	}

	public void setValorBonificacao(InterfaceCargoFolha cargo) {
		this.valorBonificacao = cargo.getValorBonificacao();
	}

	public void setPercentualInsalubridade(InterfaceCargoFolha cargo) {
		this.percentualInsalubridade = cargo.getPercentualInsalubridade();
	}

	public void setMensalidadePlanoSaude(InterfaceColaboradorFolha colab) {
		this.mensalidadePlanoSaude = colab.getPlanoSaudeMensalidade();
	}

	public void setValorCooparticipacaoPlanoSaude(InterfaceColaboradorFolha colab) {
		this.valorCooparticipacaoPlanoSaude = colab.getPlanoSaudeCooparticipacao();
	}

	public void setValeTransporte(InterfaceColaboradorFolha colab) {
		this.valeTransporte = colab.getValeTransporte();
	}

	public void setSalarioBase(InterfaceCargoFolha cargo) {
		this.salarioBase = cargo.getSalario();
	}

	public void setNumeroDependentes(InterfaceColaboradorFolha colab) {
		this.numeroDependentes = colab.getDependentes().size();
	}

	public void setDias(InterfaceFeriasFolha ferias) {
		this.dias = ferias.getDias();
	}

	public void setAbono(InterfaceFeriasFolha ferias) {
		this.abono = ferias.getAbono();
	}

}
