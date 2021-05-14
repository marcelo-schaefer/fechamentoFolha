package br.com.proway.senior.model.externo.interfaces;

import java.util.ArrayList;
/**
 * Interface IColaboradorFolha
 * 
 * Metodos implementados pela classe {@link ColaboradorFolha}.
 * 
 * @author Lucas Grij�
 * @author Lucas Walim
 * @author Marcelo Schaefer
 * 
 * Sprint 5:
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
 *
 */
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
	
	public double getValorFGTS();
	
}
