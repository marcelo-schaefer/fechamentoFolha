package br.com.proway.senior.controller;

import br.com.proway.senior.dao.FolhaDAO;
import br.com.proway.senior.dao.PostgresConnector;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.FeriasFolha;
import br.com.proway.senior.model.externo.PontoFolha;


/**
 * Controller criado pensado em receber dados e atrav�s do builder
 * tratar esses dados para criar um tipo espec�fico de folha para enviar para
 * o DAO e atualizar o banco de dados. 
 * 
 * 
 * @author Bruno Oliveira
 * @author Lucas Grij�
 *
 */
public class FolhaController {

	private FolhaDAO folhaDao;
	
	public CargoFolha construirCargoFolha(double salarioBase, double percentualInsalubridade) {
		return new CargoFolha(salarioBase, percentualInsalubridade);
	}
	
	public Folha construirFolhaNormal(ColaboradorFolha colaborador, PontoFolha ponto, CargoFolha cargo) {
		FolhaBuilder folhaBuilder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaNormal(colaborador, ponto, cargo);
		return folhaBuilder.build();
	}

	public Folha construirFolhaFerias(ColaboradorFolha colaborador, FeriasFolha ferias, CargoFolha cargo) {
		FolhaBuilder folhaBuilder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaFerias(colaborador, cargo, ferias);
		return folhaBuilder.build();
	}
	
	public Folha construirFolhaHibrida(ColaboradorFolha colaborador, PontoFolha ponto, CargoFolha cargo, FeriasFolha ferias) {
		FolhaBuilder folhaBuilder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaHibrida(colaborador, ponto, cargo, ferias);
		return folhaBuilder.build();
	}
	
	/**
	 * CREATE
	 * Metodo que recebe um tipo de folha e envia para o DAO, 
	 * para a cria��o de uma nova Folha do Banco de dados.
	 * 
	 * @param folha gerada pelo builder
	 */
	public void salvarFolha(Folha folha) {
		folhaDao = FolhaDAO.getInstance(PostgresConnector.getSession());
		folhaDao.insert(folha);
	}
	

	/**
	 * UPDATE
	 * Metodo que recebe uma nova folha e um id de uma folha existente no Banco de dados,
	 * e envia para o DAO, para a atualiza��o das informa��es da folha existente no Banco de dados.
	 *  
	 * @param folha nova gerada pelo builder
	 * @param id de folha ja existente no Banco de dados.
	 */
	public void editarFolha(Folha folha) {
		folhaDao = FolhaDAO.getInstance(PostgresConnector.getSession());
		folhaDao.update(folha);
	}

	/**
	 * DELETE
	 * Metodo que recebe um id de uma folha existente no Banco de dados,
	 * para enviar para o Dao e deletar tal folha.
	 * 
	 * @param id de folha existente no Banco de dados
	 */
	public void deletarFolha(Folha folha) {
		folhaDao = FolhaDAO.getInstance(PostgresConnector.getSession());
		folhaDao.delete(folha);
	}

	/**
	 * SELECT POR ID FOLHA
	 * Metodo que recebe um id de uma folha existente no Banco de dados,
	 * envia para o DAO, para receber a Folha e retorna-la.
	 * 
	 * @param id de uma folha existente do Banco de dados
	 * @return Folha recebida do respectivo id
	 */
	/*public Folha selecionarFolhaPorId(int id) {
		folhaDao = FolhaDAO.getInstance(FolhaDAO.session);
		return folhaDao.getFolhasPorId(id);

	}*/

	/**
	 * SELECT POR ID DO COLABORADOR
	 * Metodo que recebe um id de um colaborador,
	 * envia para o DAO, para receber as folhas do mesmo.
	 * 
	 * @param id de um colaborador
	 * @return ArrayList de folhas de um colaborador
	 */
	/*public ArrayList<Folha> selecionarFolhaPorColaborador(int id) {
		folhaDao = FolhaDAO.getInstance();
		ArrayList<Folha> folhas = folhaDao.getFolhasPorColaborador(10);
		return folhas;

	}*/

}
