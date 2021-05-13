package br.com.proway.senior.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.PontoFolha;

public class FolhaDAOTest {
 
	@Test
	public void testSalvarFolhaNormalBuilder() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 100, 43, 205);
		PontoFolha ponto = new PontoFolha(220, 2, 1);
		CargoFolha cargo = new CargoFolha(1752, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		Folha folha = director.createFolhaNormal(colab, ponto, cargo);
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		Integer tamanhoAntigo = folhaDAO.getAll().size();
		folhaDAO.insert(folha);
		
		assertEquals(tamanhoAntigo + 1, folhaDAO.getAll().size());
	}
	
	@Test
	public void testDeletarFolhaNormalBuilder() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 100, 43, 205);
		PontoFolha ponto = new PontoFolha(220, 2, 1);
		CargoFolha cargo = new CargoFolha(1752, 20);
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		Folha folha = director.createFolhaNormal(colab, ponto, cargo);
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		folhaDAO.insert(folha);
		Integer tamanhoAntigo = folhaDAO.getAll().size();
		folhaDAO.delete(folha);
		
		assertEquals(tamanhoAntigo - 1, folhaDAO.getAll().size());
	}
	
	@Test
	public void testAtualizarFolhaNormalBuilder() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		Folha primeiraFolha = folhaDAO.getAll().get(folhaDAO.getAll().size() - 1);
		LocalDate dataAntiga = primeiraFolha.getDataEmissao();
		primeiraFolha.setDataEmissao(LocalDate.of(1988, 02, 18));
		folhaDAO.update(primeiraFolha);
		Folha folhaAtualizada = folhaDAO.getAll().get(folhaDAO.getAll().size() - 1);
	
		assertNotEquals(dataAntiga, folhaAtualizada.getDataEmissao());
	}
	
	@Test
	public void testGetById() {
		
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		Folha folha = folhaDAO.getById(5);
		System.out.println(folha.toString());	
	}
	
	@Test
	public void testGetByDate() {
		
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		
		ArrayList<Folha> folhas =  (ArrayList<Folha>) folhaDAO.getByDate(LocalDate.now());
		
		System.out.println(folhas.toString());	
	}
}
