package br.com.proway.senior.fechamentoFolha;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// TODO implementar setdataEmissaoEmissaoEmissao que a folha está sendo emitida
//import java.time.LocalDateTime;

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

	public Folha(int id, String dataEmissao) {
		this.id = id;
		this.dataEmissao = dataEmissao;
	}

	public Folha(ColaboradorFolha colaborador) {
		this.horasTrabalhadas = colaborador.getPonto().getHorasTrabalhadas();
		this.horasExtra = colaborador.getPonto().getHorasExtra();
		this.horasFalta = colaborador.getPonto().getHorasFaltas();
		this.valorBonificacao = colaborador.getPonto().getValorBonificacao();
		this.percentualInsalubridade = colaborador.getPonto().getpercentualInsalubridade();
		this.mensalidadePlanoSaude = colaborador.getPonto().getMensalidadePlanoSaude();
		this.valorCooparticipacaoPlanoSaude = colaborador.getPonto().getvalorCooparticipacaoPlanoSaude();
		this.salarioBase = colaborador.getSalario();
		this.valeTransporte = colaborador.getPonto().isValeTransporte();
		this.numeroDependentes = colaborador.getDependentes().size();
	}

	// Set criado somente para debugar
	public void setSalarioBruto(double valor) {
		this.salarioBruto = valor;
	}

	public void setSalarioBase(double valor) {
		this.salarioBase = valor;
	}

	/*
	 * public static double calculaFolhaFinal(int colabId) { double
	 * horaComInsalubridade = calculaHoraComInsalubridade(valorHoraColab,
	 * quantidadeHorasTrabalhadas, percentualInsalubridadeColab); double
	 * valorSalarioBruto = calcularHorasTrabalhadas(quantidadeHorasTrabalhadas,
	 * horaComInsalubridade); valorSalarioBruto +=
	 * calcularValorHorasExtras(quantidadeHorasExtrasColab, horaComInsalubridade,
	 * 0.5); valorSalarioBruto += calcularBonificacao(valorBonificacaoColab); double
	 * salarioDescontos = calcularValorHorasFaltas(horaComInsalubridade,
	 * quantidadeHorasFaltas) +
	 * calcularDescontoPlanoSaude(mensalidadePlanoSaudePlanoSaude,
	 * valorCoparticipacaoPlano) + calcularDescontoImpostoRenda(valorSalarioBruto) +
	 * calcularDescontoInss(valorSalarioBruto); double salarioFinal =
	 * valorSalarioBruto - salarioDescontos; return salarioFinal; }
	 */

	/**
	 * Calcula a folha final
	 * 
	 * Método responsável por chamar todos os outros métodos que calculam o
	 * fechamento da folha do mes.
	 * 
	 * @return Salário liquido do coaborador
	 */
	public double calcularFolha() {

		this.salarioBruto += this.calcularHorasTrabalhadas();
		this.salarioBruto -= this.calcularValorHorasFaltas();
		this.salarioBruto += this.calcularValorHorasExtras();
		this.salarioBruto += this.calcularDSR();
		this.salarioBruto += this.calcularBonificacao();
		this.salarioBruto -= this.calcularDescontoInss();
		this.salarioBruto -= this.calcularDescontoImpostoRenda();
		this.salarioBruto -= this.calcularDescontoPlanoSaude();
		this.salarioBruto -= this.calcularDescontoValeTransporte();
		this.salarioLiquido = this.salarioBruto;
		this.setDataEmissao();
		
		return this.salarioLiquido;
	}

	/**
	 * Calcula o valor de vale transporte a ser descontado do colaborador
	 * 
	 * Chamada do metodo de Vale transporte que calcula o desconto, se o percentual
	 * aplicado de 6% (0,06) for maior ou igual que R$ 180,00 o desconto será este, se
	 * for menor retorna este valor calculado, e se for informado um valor igual ou
	 * menor que 0 retorna 0.
	 * 
	 * @return valeTransporte = valor do vale transporte a ser descontado do salário
	 *         base.
	 */
	public double calcularDescontoValeTransporte() {
		if (valeTransporte) {
			this.valorValeTransporte = this.salarioBase * 0.06;
			if (this.valorValeTransporte > 180) {
				this.valorValeTransporte = 180;
			}
		} else {
			this.valorValeTransporte = 0;
		}
		return this.valorValeTransporte;

	}

	/**
	 * Calcula o valor a ser pago em folha referente as horas extras
	 * 
	 * O valor retornado da multiplicação de valorHoras e fator, vai somar com o
	 * valorHoras e depois multiplica pelas horasExtra
	 * 
	 * @return valor = Retorna o valor a ser pago de horas extras.
	 */
	public double calcularValorHorasExtras() { // Testado
		double valorHora50Porcento;
		return this.valorHoraExtra = this.horasExtra
				* (valorHora50Porcento = this.valorHoras + (this.valorHoras * this.fator));
	}

	/**
	 * Desconto de Plano de Saude.
	 * 
	 * Realiza o desconto de plano de saúde, somando o valor da mensalidade com o
	 * valor de cooparticipação caso exista. A variável planoSaude retornará a soma
	 * das variáveis mensalidadePlanoSaude e valorCooparticipacaoPlanoSaude.
	 * 
	 * @return planoSaude = retorna valor a ser descontado em folha, referente ao
	 *         Plano de Saude.
	 */
	public double calcularDescontoPlanoSaude() { // Tratar mensalidade Zerada

		if (this.mensalidadePlanoSaude >= 0) {
			if (this.valorCooparticipacaoPlanoSaude >= 0) {
				this.planoSaude = this.mensalidadePlanoSaude + this.valorCooparticipacaoPlanoSaude;
			} else {
				this.valorCooparticipacaoPlanoSaude = 0;
				this.planoSaude = this.mensalidadePlanoSaude + this.valorCooparticipacaoPlanoSaude;
			}
		} else {
			this.mensalidadePlanoSaude = 0;
			this.valorCooparticipacaoPlanoSaude = 0;
			this.planoSaude = this.mensalidadePlanoSaude + this.valorCooparticipacaoPlanoSaude;
		}

		return this.planoSaude;
	}

	/**
	 * Recebe o valor de bonificação a ser acrescido na folha do colaborador
	 * 
	 * Recebe o valor da bonificação que será aplicado posteriormente nos proventos
	 * do colaborador.
	 * 
	 * @return valorBonificacao = Retorna o valor de bonificação que será somado aos
	 *         demais proventos na folha do colaborador
	 */
	public double calcularBonificacao() {

		if (valorBonificacao > 0) {
			return this.valorBonificacao;
		} else {
			return this.valorBonificacao = 0;
		}
	}

	/**
	 * Calcula o valor de INSS a ser descontado
	 * 
	 * Realiza o cálculo do valor de INSS a ser descontado em folha a partir do
	 * salário informado. Pega a variável salarioBruto e multiplica pelo valor de
	 * desconto fixado em 11%. Retorna o valor a ser descontado.
	 * 
	 * @return inss = Retorna o valor a ser descontado em folha.
	 */
	public double calcularDescontoInss() {
		return this.inss = this.salarioBruto * 0.11;

	}

	public double calcularDescontoInss(double valorFerias) {
		return this.inss = valorFerias * 0.11;

	}

	/**
	 * Calcula o valor de Imposto de Renda a ser descontado em folha
	 * 
	 * Realiza o cálculo do valor a ser descontado referente ao Imposto de Renda na
	 * folha do colaborador, seleciona o salárioBruto e multiplica pela sua faixa
	 * salarial e subtrai o valor a deduzir(exe:142,80).
	 * 
	 * @return valorImpostoDeRenda = Retorna o valor que a ser descontado em folha
	 *         referente ao Imposto de Renda.
	 */
	public double calcularDescontoImpostoRenda() { // **********************
		double baseCalculoimpostoRenda = this.salarioBruto - this.calcularValorDeduzirDependente();
		if (baseCalculoimpostoRenda <= 1903.98) {
			this.valorImpostoDeRenda = 0;
		} else if (baseCalculoimpostoRenda >= 1903.99 && baseCalculoimpostoRenda <= 2826.65) {
			this.valorImpostoDeRenda = (baseCalculoimpostoRenda * 0.075) - 142.80;
		} else if (baseCalculoimpostoRenda >= 2826.66 && baseCalculoimpostoRenda <= 3751.05) {
			this.valorImpostoDeRenda = (baseCalculoimpostoRenda * 0.15) - 354.80;
		} else if (baseCalculoimpostoRenda >= 3751.06 && baseCalculoimpostoRenda <= 4664.68) {
			this.valorImpostoDeRenda = (baseCalculoimpostoRenda * 0.225) - 636.13;
		} else {
			this.valorImpostoDeRenda = (baseCalculoimpostoRenda * 0.275) - 869.36;
		}

		return this.valorImpostoDeRenda;
	}

	public double calcularDescontoImpostoRenda(double valorFerias) { // **********************
		double baseCalculoImpostoRendaFerias = valorFerias - this.calcularValorDeduzirDependente();
		if (baseCalculoImpostoRendaFerias <= 1903.98) {
			this.valorImpostoDeRenda = 0;
		} else if (baseCalculoImpostoRendaFerias >= 1903.99 && baseCalculoImpostoRendaFerias <= 2826.65) {
			this.valorImpostoDeRenda = (baseCalculoImpostoRendaFerias * 0.075) - 142.80;
		} else if (baseCalculoImpostoRendaFerias >= 2826.66 && baseCalculoImpostoRendaFerias <= 3751.05) {
			this.valorImpostoDeRenda = (baseCalculoImpostoRendaFerias * 0.15) - 354.80;
		} else if (baseCalculoImpostoRendaFerias >= 3751.06 && valorFerias <= 4664.68) {
			this.valorImpostoDeRenda = (baseCalculoImpostoRendaFerias * 0.225) - 636.13;
		} else {
			this.valorImpostoDeRenda = (baseCalculoImpostoRendaFerias * 0.275) - 869.36;
		}

		return this.valorImpostoDeRenda;
	}

	/**
	 * Calcula o valor da insalubridade
	 * 
	 * Realiza o cálculo do valor a ser implementado no salário mínimo, vai pegar a
	 * variável salarioMinimo e multiplicar pela sua faixa de insalubridade.
	 * 
	 * @return valorInsalubridade = Retorna o valor a ser somado ao salário mínimo.
	 */
	public double calculaInsalubridade() {
		if (this.percentualInsalubridade == 10) {
			return this.valorInsalubridade = this.salarioMinimo * 0.10;
		} else if (this.percentualInsalubridade == 20) {
			return this.valorInsalubridade = this.salarioMinimo * 0.20;
		} else if (this.percentualInsalubridade == 40) {
			return this.valorInsalubridade = this.salarioMinimo * 0.40;
		} else {
			return this.valorInsalubridade = 0;
		}
	}

	/**
	 * Calcula hora normal somando insalubridade.
	 * 
	 * Pega o valor do método calculaInsalubridade e divide pela variável
	 * horasTrabalhadas
	 *
	 * @return valorHoras = vai retornar o valor ganho de insalubridade por hora
	 */
	// Correção a métodos redundantes de calculo de hora insalubre
	public double calculaValorHora() { // Testado
		double valorHoraInsalubridade = (this.calculaInsalubridade() / 220);
		if (valorHoraInsalubridade < 0) {
			return this.valorHoras = this.salarioBase / 220; // 11,68181818181818
		} else {
			return this.valorHoras = (this.salarioBase / 220) + valorHoraInsalubridade;
		}
	}

	/**
	 * Calcula o valor inicial do salário
	 * 
	 * Pega o valor do método calculaValorHora passa para a variável valorHoras,
	 * após isso a variável valor recebe a multiplição de horasTrabalhas e
	 * valorHoras
	 * 
	 * @return valor = Retorna o valor do salário inicial, considerando apenas a
	 *         quantidade horas trabalhadas e o valor da hora com insalubridade.
	 */
	public double calcularHorasTrabalhadas() {

		double valorHoras = this.calculaValorHora();
		double valor = this.horasTrabalhadas * valorHoras;

		return valor;
	}

	/**
	 * Calcula o valor a ser descontado de horas faltas
	 * 
	 * Realiza o cálculo das horas faltas a serem descontadas na folha do
	 * colaborador, recebe o valor de horasFalta e multiplica valorInsalubridade
	 * 
	 * @return valorFaltas = Retorna o valor a ser descontado na folha do
	 *         colaborador referente as horas faltas.
	 */
	public double calcularValorHorasFaltas() { // Testado
		this.valorHorasFaltas = this.horasFalta * this.valorHoras;
		return this.valorHorasFaltas;
	}

	/**
	 * Calcula férias
	 * 
	 * 
	 */
	public double calcularFerias(int dias, int abono) {
		double valorHorasDias = (double) 220 / 30; // 7,333333333
		double valorDia = this.calculaValorHora() * valorHorasDias;
		double valorFerias = dias * valorDia;
		double valorFeriasUmTerco = valorFerias / 3;
		double valorTotalFerias = 0;
		if (abono <= 0) {
			valorTotalFerias = valorFerias + valorFeriasUmTerco;
			valorTotalFerias -= this.calcularDescontoInss(valorTotalFerias);
			valorTotalFerias -= this.calcularDescontoImpostoRenda(valorTotalFerias);
		} else {
			double valorAbono = abono * valorDia;
			double valorAbonoUmTerco = valorAbono / 3;
			valorTotalFerias = (valorFerias + valorFeriasUmTerco) + (valorAbono + valorAbonoUmTerco);
			valorTotalFerias -= this.calcularDescontoInss(valorTotalFerias);
			valorTotalFerias -= this.calcularDescontoImpostoRenda(valorTotalFerias);
		}
		return valorTotalFerias;

	}

	public double calcularValorDeduzirDependente() {
		double valor = this.numeroDependentes * this.valorPorDependente;
		return valor;
	}

	/**
	 * Calcula o DSR
	 * 
	 * Define o valor do Reflexo DSR por meio de alguns parâmetros passados
	 */
	public double calcularDSR() {
		double diasUteis = 25.0;
		double domigosFeriados = 5.0;
		this.reflexoDSR = (this.getValorHoraExtra() / diasUteis) * domigosFeriados;
		return this.reflexoDSR;
	}

	/**
	 * Pega a dataEmissao atual
	 * 
	 * Seta o atributo dataEmissao com a dataEmissao atual no formato DD/MM/AAAA
	 */
	public void setDataEmissao() {
		LocalDateTime dataEmissaoTime = LocalDateTime.now();
		DateTimeFormatter dataEmissaoFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.dataEmissao = dataEmissaoTime.format(dataEmissaoFormatada);
	}

	public int getId() {
		return id;
	}

	public String getDataEmissao() {
		return this.dataEmissao;
	}

	public double getReflexoDSR() {
		return this.reflexoDSR;
	}

	public double getHoraExtra() {
		return this.valorHoraExtra;
	}

	public double getSalarioLiquido() {
		return this.salarioLiquido;
	}

	public double getValorHoras() {
		return this.valorHoras;
	}

	public double getValorHoraComInsalubridade() {
		return this.valorHoraComInsalubridade;
	}

	public double getHorasTrabalhadas() {
		return this.horasTrabalhadas;
	}

	public double getHorasExtra() {
		return this.horasExtra;
	}

	public double getValorHoraExtra() {
		return this.valorHoraExtra;
	}

	public double getHorasFalta() {
		return this.horasFalta;
	}

	public double getValorHorasFaltas() {
		return this.valorHorasFaltas;
	}

	public double getValorBonificacao() {
		return this.valorBonificacao;
	}

	public double getPlanoSaude() {
		return this.planoSaude;
	}

	public double getPercentualInsalubridade() {
		return this.percentualInsalubridade;
	}

	public double getValorInsalubridade() {
		return this.valorInsalubridade;
	}

	public double getInss() {
		return this.inss;
	}

	public double getvalorImpostoDeRenda() {
		return this.valorImpostoDeRenda;
	}

	public double getMensalidadePlanoSaude() {
		return this.mensalidadePlanoSaude;
	}

	public double getValorCooparticipacaoPlanoSaude() {
		return this.valorCooparticipacaoPlanoSaude;
	}

	public double getValorValeTransporte() {
		return this.valorValeTransporte;
	}

	public double getFator() {
		return this.fator;
	}

	public void setFator(double fator) {
		this.fator = fator;
	}

	public double getSalarioMinimo() {
		return this.salarioMinimo;
	}

	public void setSalarioMinimo(double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public double getSalarioBruto() {
		return this.salarioBruto;
	}

	public double getSalarioBase() {
		return this.salarioBase;
	}

	public double getValorInss() {
		return this.inss;
	}

	public int getNumeroDependentes() {
		return this.numeroDependentes;
	}

}
