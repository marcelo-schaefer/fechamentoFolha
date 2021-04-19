package br.com.proway.senior.fechamentoFolha;

public final class FolhaProvisoria {

	private int id;
	private String data;
	private double horaExtra;
	private double reflexoDSR;
	
	public FolhaProvisoria(int id, String data) {
		this.id = id;
		this.data = data;
	}
	
	/**
	 * Calcula o DSR 
	 * 
	 * Define o valor do Reflexo DSR por meio de alguns parâmetros passados    
	 */
	public void calculoDSR() {
		double diasUteis = 25.0;
		double domigosFeriados = 5.0;
		double result = (getHoraExtra() / diasUteis) * domigosFeriados;
		setReflexoDSR(result);
	}
	
	public double getReflexoDSR() {
		return this.reflexoDSR;
	}
	
	public void setReflexoDSR(double reflexoDSR) {
		this.reflexoDSR = reflexoDSR;
	}
	
	public double getHoraExtra() {
		return this.horaExtra;
	}
	
	public void setHoraExtra(double horaExtra) {
		this.horaExtra = horaExtra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
		
}
