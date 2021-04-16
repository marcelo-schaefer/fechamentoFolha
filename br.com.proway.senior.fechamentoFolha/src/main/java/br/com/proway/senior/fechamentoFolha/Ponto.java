package br.com.proway.senior.fechamentoFolha;

public class Ponto {
	
	private double horasTrabalhadas;
	private double horasExtra;
	private double horasFalta;
	private double valorBonificacao;
	private double porcentagemInsalubridade;
	private boolean valeTransporte;
	private double mensalidadePlanoSaude;
	private double co_participacaoEmConsultas;
	
	public Ponto(double horasTrabalhadas, double horasExtra, double horasFalta, double valorBonificacao,
			double porcentagemInsalubridade, boolean valeTransporte, double mensalidadePlanoSaude,
			double co_participacaoEmConsultas) {
		super();
		this.horasTrabalhadas = horasTrabalhadas;
		this.horasExtra = horasExtra;
		this.horasFalta = horasFalta;
		this.valorBonificacao = valorBonificacao;
		this.porcentagemInsalubridade = porcentagemInsalubridade;
		this.valeTransporte = valeTransporte;
		this.mensalidadePlanoSaude = mensalidadePlanoSaude;
		this.co_participacaoEmConsultas = co_participacaoEmConsultas;
	}

	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}	

	public double getHorasExtra() {
		return horasExtra;
	}	

	public double getHorasFalta() {
		return horasFalta;
	}

	public double getValorBonificacao() {
		return valorBonificacao;
	}	

	public double getPorcentagemInsalubridade() {
		return porcentagemInsalubridade;
	}	

	public boolean isValeTransporte() {
		return valeTransporte;
	}
	
	public double getMensalidadePlanoSaude() {
		return mensalidadePlanoSaude;
	}
	
	public double getCo_participacaoEmConsultas() {
		return co_participacaoEmConsultas;
	}	
	
}
