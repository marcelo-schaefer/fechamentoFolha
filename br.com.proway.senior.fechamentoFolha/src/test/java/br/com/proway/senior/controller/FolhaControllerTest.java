package br.com.proway.senior.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.proway.senior.dao.FolhaDAO;
import br.com.proway.senior.dao.PostgresConnector;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.FeriasFolha;
import br.com.proway.senior.model.externo.Plr;
import br.com.proway.senior.model.externo.PontoFolha;

public class FolhaControllerTest {
	
	/*
	@Before
	public void openSession() {
		PostgresConnector.getSession();
	}
	
	@After
	public void closeSession() {
		PostgresConnector.shutdown();;
	}
	*/
	
	@Test
	public void testConstruirCargoFolha() {
		CargoFolha cargo = new CargoFolha(3500, 0);
		FolhaController fc = new FolhaController();
			
		CargoFolha cargoFolha = fc.construirCargoFolha(cargo.getSalarioBase(), cargo.getPercentualInsalubridade()); 
		assertNotNull(cargoFolha);
	}
	
	@Test
	public void testConstruirFolhaNormal() {
		FolhaController fc = new FolhaController();
		CargoFolha cargo = new CargoFolha(3500, 0);
		CargoFolha cargoFolha = fc.construirCargoFolha(cargo.getSalarioBase(), cargo.getPercentualInsalubridade());
		ColaboradorFolha colaborador = new ColaboradorFolha(0, false, 0, 0, 0);
		PontoFolha ponto = new PontoFolha(0, 0, 0);
		Plr plr = new Plr();
		plr.setPlr(250);
		
		Folha folha = fc.construirFolhaNormal(colaborador, ponto, cargoFolha, plr);
		
		assertNotNull(folha);
		assertTrue(folha.getValorPlr() == 250);
	}
	
	@Test
	public void testConstruirFolhaFerias() {
		FolhaController fc = new FolhaController();
		CargoFolha cargo = new CargoFolha(3500, 0);
		CargoFolha cargoFolha = fc.construirCargoFolha(cargo.getSalarioBase(), cargo.getPercentualInsalubridade());
		ColaboradorFolha colaborador = new ColaboradorFolha(0, false, 0, 0, 0);
		FeriasFolha ferias = new FeriasFolha(0, 0); 
		
		Folha folha = fc.construirFolhaFerias(colaborador, ferias, cargoFolha);
		
		assertNotNull(folha);
		assertTrue(folha.getValorHorasTrabalhadas() == 0);
	}
	
	@Test
	public void testConstruirFolhaHibrida() {
		FolhaController fc = new FolhaController();
		CargoFolha cargo = new CargoFolha(3500, 0);
		CargoFolha cargoFolha = fc.construirCargoFolha(cargo.getSalarioBase(), cargo.getPercentualInsalubridade());
		ColaboradorFolha colaborador = new ColaboradorFolha(0, false, 0, 0, 0);
		FeriasFolha ferias = new FeriasFolha(0, 0);
		PontoFolha ponto = new PontoFolha(0, 0, 0);
		Plr plr = new Plr();
		plr.setPlr(250);
		
		Folha folha = fc.construirFolhaHibrida(colaborador, ponto, cargoFolha, ferias, plr);
		
		assertNotNull(folha);
		assertTrue(folha.getValorPlr() == 250);
	}
	
	@Test
	public void testSaveFolha() {
		FolhaController fc = new FolhaController();
		FolhaDAO db = FolhaDAO.getInstance(PostgresConnector.getSession());
		
		CargoFolha cargo = new CargoFolha(3500, 0);
		CargoFolha cargoFolha = fc.construirCargoFolha(cargo.getSalarioBase(), cargo.getPercentualInsalubridade());
		ColaboradorFolha colaborador = new ColaboradorFolha(0, false, 0, 0, 0);
		PontoFolha ponto = new PontoFolha(0, 0, 0);
		Plr plr = new Plr();
		plr.setPlr(250);
		
		Folha folha = fc.construirFolhaNormal(colaborador, ponto, cargoFolha, plr);
		
		fc.salvarFolha(folha);
		
		assertTrue(db.getAll().size() == 1);
	}
	
	@Test
	public void testEditarFolha() {
		FolhaController fc = new FolhaController();
		FolhaDAO db = FolhaDAO.getInstance(PostgresConnector.getSession());
		
		CargoFolha cargo = new CargoFolha(3500, 0);
		CargoFolha cargoFolha = fc.construirCargoFolha(cargo.getSalarioBase(), cargo.getPercentualInsalubridade());
		ColaboradorFolha colaborador = new ColaboradorFolha(0, false, 0, 0, 0);
		PontoFolha ponto = new PontoFolha(0, 0, 0);
		Plr plr = new Plr();
		plr.setPlr(350);
		
		Folha folha = fc.construirFolhaNormal(colaborador, ponto, cargoFolha, plr);
		
		fc.editarFolha(folha);
		assertTrue(db.getAll().get(0).getValorPlr() == 350);
	}
}