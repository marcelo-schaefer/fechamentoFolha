package br.com.proway.senior.controller;

import br.com.proway.senior.dao.FolhaDAO;
import br.com.proway.senior.dao.PostgresConnector;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.IPlr;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.IFeriasFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;


/**
 * Cria Folha.
 * 
 * Recebe dados atraves do builder{@link FolhaBuilder}, trata estes dados
 * e cria um objeto especifico de folha{@link Folha}, no fim, o envia para banco de dados.
 * 
 * @author Bruno Oliveira
 * @author Lucas Grijo
 * 
 * Sprint 5:
 * @author Leonardo Felipe Silva <felipeleao217@gmail.com>;
 * @author Bruna Carvalho <sh4323202@gmail.com>;
 * @author Leonardo Pereira <leonardopereirajr@gmail.com>;
 * @author Sabrina Schmidt <sabrinaschmidt335@gmail.com>;
 * @author Lucas Nunes <lucasnunes.ln365@gmail.com>.
 *
 */
public class FolhaController {

	private FolhaDAO folhaDao;
	
	/**
	 * Retorna uma ins�ncia de {@link CargoFolha} com base no salario do
	 * colaborador{@link IColaboradorFolha} e percentual de 
	 * insalubridade.
	 * 
	 * @param salarioBase
	 * @param percentualInsalubridade
	 * @return
	 */
	public CargoFolha construirCargoFolha(double salarioBase, double percentualInsalubridade,double porcentagemBonificacaoCargo) {
		return new CargoFolha(salarioBase, percentualInsalubridade, porcentagemBonificacaoCargo);
	}
	
	/** Constroi uma FolhaNormal.
	 * 
	 * Recebe um objeto {@link IColaboradorFolha}, um objeto {@link IPontoFolha}, 
	 * um objeto {@link ICargoFolha}, um objeto {@link IFeriasFolha} e 
	 * um objeto {@link IPlr} E cria um novo objeto {@link Folha}.
	 * 
	 * @param colaborador {@link IColaboradorFolha};
	 * @param ponto {@link IPontoFolha};
	 * @param cargo {@link ICargoFolha};
	 * @param plr {@link IPlr}.
	 * 
	 * @return folha {@link Folha}.
	*/
	public Folha construirFolhaNormal(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo, IPlr plr) {
		FolhaBuilder folhaBuilder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaNormal(colaborador, ponto, cargo, plr);
		return folhaBuilder.build();
	}

	/**
	 * Constroi uma FolhaFerias.
	 * 
	 * Recebe um objeto {@link IColaboradorFolha}, um objeto {@link IPontoFolha}, 
	 * um objeto {@link ICargoFolha} E cria um novo objeto {@link Folha}.
	 * 
	 * @param colaborador {@link IColaboradorFolha};
	 * @param ponto {@link IPontoFolha};
	 * @param cargo {@link ICargoFolha};
	 * @param ferias {@link IFeriasFolha};
	 * 
	 * @return folha {@link Folha}.
	 */
	public Folha construirFolhaFerias(IColaboradorFolha colaborador, IFeriasFolha ferias, ICargoFolha cargo) {
		FolhaBuilder folhaBuilder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaFerias(colaborador, cargo, ferias);
		return folhaBuilder.build();
	}
	
	/**
	 * Constroi uma FolhaHibrida.
	 * 
	 * Recebe um objeto {@link IColaboradorFolha}, um objeto {@link IPontoFolha}, 
	 * um objeto {@link ICargoFolha}, um objeto {@link IFeriasFolha} e 
	 * um objeto {@link IPlr} E cria um novo objeto {@link Folha}.
	 * 
	 * @param colaborador {@link IColaboradorFolha};
	 * @param ponto {@link IPontoFolha};
	 * @param cargo {@link ICargoFolha};
	 * @param ferias {@link IFeriasFolha};
	 * @param plr {@link IPlr}.
	 * 
	 * @return folha {@link Folha}.
	 */
	public Folha construirFolhaHibrida(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo, IFeriasFolha ferias, IPlr plr) {
		FolhaBuilder folhaBuilder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaHibrida(colaborador, ponto, cargo, ferias, plr);
		return folhaBuilder.build();
	}
	
	/**
	 * Salva uma folha no banco de dados.
	 * 
	 * Recebe um objeto {@link Folha}, chama a instancia do {@link FolhaDAO}
	 * e insere o objeto no banco de dados.
	 * 
	 * @param objeto {@link Folha}
	 */
	public void salvarFolha(Folha folha) {
		folhaDao = FolhaDAO.getInstance(PostgresConnector.getSession());
		folhaDao.insert(folha);
	}
	
	/**
	 * Atualiza uma Folha no banco.
	 * 
	 *Realiza a atualizacao de um objeto {@link Folha} ja existente no banco.
	 *
	 * @param objeto {@link Folha}
	 */
	public void editarFolha(Folha folha) {
		folhaDao = FolhaDAO.getInstance(PostgresConnector.getSession());
		folhaDao.update(folha);
	}

	/**
	 * Deletar folha do banco.
	 * 
	 * O metodo recebe um objeto {@link Folha} existente no banco de dados,
	 * e deleta o mesmo.
	 * 
	 * @param objeto {@link Folha}. 
	 */
	public void deletarFolha(Folha folha) {
		folhaDao = FolhaDAO.getInstance(PostgresConnector.getSession());
		folhaDao.delete(folha);
	}
}