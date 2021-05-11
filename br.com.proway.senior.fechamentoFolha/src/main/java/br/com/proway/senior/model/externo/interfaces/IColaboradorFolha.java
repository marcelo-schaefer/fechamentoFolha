package br.com.proway.senior.model.externo.interfaces;

import java.util.ArrayList;

public interface IColaboradorFolha {

	public int getId();
	
	public String getNome();
	
	public String getEmail();
	
	public ArrayList<String> getDependentes();
	
	public boolean getValeTransporte();
	
	public double getPlanoSaudeMensalidade();
	
	public double getPlanoSaudeCooparticipacao();
	
	public boolean isValeTransporte();
	
	public int getNumeroDeDependentes();
	
}
