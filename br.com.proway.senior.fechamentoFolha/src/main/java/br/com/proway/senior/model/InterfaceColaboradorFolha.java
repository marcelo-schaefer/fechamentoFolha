package br.com.proway.senior.model;

import java.util.ArrayList;

public interface InterfaceColaboradorFolha {

	public int getId();
	
	public String getNome();
	
	public String getEmail();
	
	public <Pessoa> ArrayList<Pessoa> getDependentes();
	
	public boolean getValeTransporte();
	
	public double getPlanoSaudeMensalidade();
	
	public double getPlanoSaudeCooparticipacao();
	
}
