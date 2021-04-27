package br.com.proway.senior.model;

public class Folha {
	private int id;
	private String dataEmissao;
	private double salarioLiquido;
	private double salarioBruto;
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
	 * Construtor
	 * 
	 */
	
	public Folha() {}

	
	/**
	 * 
	 * Construtor
	 * 
	 * @param id
	 * @param dataEmissao
	 */
	public Folha(int id, String dataEmissao) {
		this.id = id;
		this.dataEmissao = dataEmissao;
	}
	
	public Folha(int id) {
		this.id = id;
	}
	
	
	/**
	 * Alterar conforme esse modelo: this.horasTrabalhadas = this.ponto.getHorasTrabalhadas();
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
	}

	// Set criado somente para debugar
	public void setSalarioBruto(double valor) {
		this.salarioBruto = valor;
	}

	public void setSalarioBase(double valor) {
		this.salarioBase = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
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

	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
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

	public void setPercentualInsalubridade(double percentualInsalubridade) {
		this.percentualInsalubridade = percentualInsalubridade;
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

	public void setNumeroDependentes(int numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
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

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getAbono() {
		return abono;
	}

	public void setAbono(int abono) {
		this.abono = abono;
	}

}
