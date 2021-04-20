package br.com.proway.senior.fechamentoFolha;

public final class Ponto {
	
	private double horasTrabalhadas;
	private double horasExtra;
	private double horasFaltas;
	private double valorBonificacao;
	private double percentualInsalubridade;
	private boolean valeTransporte;
	private double mensalidadePlanoSaude;
	private double valorCooparticipacaoPlanoSaude;
	
	
	/**
	 * Metodo Construtor do Ponto
	 * 
	 * Passa os dados do ponto para o atributo ponto na classe colaborador
	 * 
	 * @param horasTrabalhadas
	 * @param horasExtra
	 * @param horasFaltas
	 * @param valorBonificacao
	 * @param percentualInsalubridade
	 * @param valeTransporte
	 * @param mensalidadePlanoSaude
	 * @param valorCooparticipacaoPlanoSaude
	 */
	public Ponto(double horasTrabalhadas, double horasExtra, double horasFaltas, double valorBonificacao,
	double percentualInsalubridade, boolean valeTransporte, double mensalidadePlanoSaude, 
	double valorCooparticipacaoPlanoSaude) {
		this.horasTrabalhadas = horasTrabalhadas;
		this.horasExtra = horasExtra;
		this.horasFaltas = horasFaltas;
		this.valorBonificacao = valorBonificacao;
		this.percentualInsalubridade = percentualInsalubridade;
		this.valeTransporte = valeTransporte;
		this.mensalidadePlanoSaude = mensalidadePlanoSaude;
		this.valorCooparticipacaoPlanoSaude = valorCooparticipacaoPlanoSaude;
	}

	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}	

	public double getHorasExtra() {
		return horasExtra;
	}	

	public double getHorasFaltas() {
		return horasFaltas;
	}
	
	public double getValorBonificacao() {
		return valorBonificacao;
	}	

	public double getpercentualInsalubridade() {
		return percentualInsalubridade;
	}	

	public boolean isValeTransporte() {
		return valeTransporte;
	}
	
	public double getMensalidadePlanoSaude() {
		return mensalidadePlanoSaude;
	}
	
	public double getvalorCooparticipacaoPlanoSaude() {
		return valorCooparticipacaoPlanoSaude;
	}	
	
}
