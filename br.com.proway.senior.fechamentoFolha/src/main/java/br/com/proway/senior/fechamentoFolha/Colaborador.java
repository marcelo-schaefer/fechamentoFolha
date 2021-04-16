package br.com.proway.senior.fechamentoFolha;

import java.util.ArrayList;

public class Colaborador {
	private String nome;
	private int id;
	private double salario;
	private ArrayList<Folha> totalFolhas = new ArrayList<Folha>();
	private ArrayList<String> dependentes = new ArrayList<String>();
	private double horasTrabalhadas;
	private double horasExtra;
	private double horasFalta;
	private double valorBonificacao;
	private double porcentagemInsalubridade;
	private boolean valeTransporte;
	private double mensalidadePlanoSaude;
	private double co_participacaoEmConsultas;
	
	public Colaborador(/*String nome, */int id/*, double salario, ArrayList<Folha> totalFolhas,
//			double horasTrabalhadas, double horasExtra, double horasFalta, double bonificacao, double insalubridade,
//			boolean valeTransporte, double mensalidadePlanoSaude, double co_participacaoEmConsultas*/) {
//		super();
//		this.nome = nome;
		this.id = id;
//		this.salario = salario;
//		this.horasTrabalhadas = horasTrabalhadas;
//		this.horasExtra = horasExtra;
//		this.horasFalta = horasFalta;
//		this.valorBonificacao = bonificacao;
//		this.porcentagemInsalubridade = insalubridade;
//		this.valeTransporte = valeTransporte;
//		this.mensalidadePlanoSaude = mensalidadePlanoSaude;
//		this.co_participacaoEmConsultas = co_participacaoEmConsultas;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public ArrayList<Folha> getTotalFolhas() {
		return totalFolhas;
	}

	public void setTotalFolhas(Folha f) {
		this.totalFolhas.add(f);
	}

	public ArrayList<String> getDependentes() {
		return dependentes;
	}

	public void setDependentes(ArrayList<String> dependentes) {
		this.dependentes = dependentes;
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

	public double getHorasFalta() {
		return horasFalta;
	}

	public void setHorasFalta(double horasFalta) {
		this.horasFalta = horasFalta;
	}

	public double getValorBonificacao() {
		return valorBonificacao;
	}

	public void setValorBonificacao(double valorBonificacao) {
		this.valorBonificacao = valorBonificacao;
	}

	public double getPorcentagemInsalubridade() {
		return porcentagemInsalubridade;
	}

	public void setPorcentagemInsalubridade(double porcentagemInsalubridade) {
		this.porcentagemInsalubridade = porcentagemInsalubridade;
	}

	public boolean isValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(boolean valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	public double getMensalidadePlanoSaude() {
		return mensalidadePlanoSaude;
	}

	public void setMensalidadePlanoSaude(double mensalidadePlanoSaude) {
		this.mensalidadePlanoSaude = mensalidadePlanoSaude;
	}

	public double getCo_participacaoEmConsultas() {
		return co_participacaoEmConsultas;
	}

	public void setCo_participacaoEmConsultas(double co_participacaoEmConsultas) {
		this.co_participacaoEmConsultas = co_participacaoEmConsultas;
	}
		
	
}
