package br.com.proway.senior.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.Plr;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.PontoFolha;

public class FolhaDAOTest {
 
	@Test
	public void testInsert() {
		
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 100, 43, 205);
		PontoFolha ponto = new PontoFolha(220, 2, 1);

		CargoFolha cargo = new CargoFolha(1752, 20);
		Plr plr = new Plr();

		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		Folha folha = director.createFolhaNormal(colab, ponto, cargo, plr);
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		
		Integer tamanhoAntigo = folhaDAO.getAll().size();
		System.out.println(tamanhoAntigo);
		folhaDAO.insert(folha);
		
		System.out.println(tamanhoAntigo);
		System.out.println(folhaDAO.getAll().size());
		assertEquals(tamanhoAntigo + 1, folhaDAO.getAll().size());
	}
	
	@Test
	public void testDelete() {
		ColaboradorFolha colab = new ColaboradorFolha(1, false, 100, 43, 205);
		PontoFolha ponto = new PontoFolha(220, 2, 1);
		CargoFolha cargo = new CargoFolha(1752, 20);
		Plr plr = new Plr();
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		Folha folha = director.createFolhaNormal(colab, ponto, cargo, plr);
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		
		folhaDAO.insert(folha);
		Integer tamanhoAntigo = folhaDAO.getAll().size();
		folhaDAO.delete(folha);
		
		assertEquals(tamanhoAntigo - 1, folhaDAO.getAll().size());
	}
	
	@Test
	public void testGetAll() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		List<Folha> listaFolhas = folhaDAO.getAll();
		assertEquals(listaFolhas.size(), 20);
	}
	
	@Test
	public void testUpdate() {
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
		assertEquals(folha.getId(), 5);	
	}
	
	@Test
	public void testGetByDate() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		ColaboradorFolha colab = new ColaboradorFolha(9, false, 100, 43, 205);
		PontoFolha ponto = new PontoFolha(220, 2, 1);
		CargoFolha cargo = new CargoFolha(1752, 20);
		Plr plr = new Plr();
		
		FolhaBuilder builder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(builder);
		
		Folha folha = director.createFolhaNormal(colab, ponto, cargo, plr);
		folhaDAO.insert(folha);
		
		Folha folhaData =  folhaDAO.getByDate(LocalDate.now())
				.get(folhaDAO.getByDate(LocalDate.now()).size() - 1);
		
		assertEquals(folhaData.getDataEmissao(), LocalDate.now());
	}
	
	@Test
	public void testGetDoubleByColumn() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		Folha folha = folhaDAO.getById(5);
		
		List<Folha> folhaValor = folhaDAO.getDoubleByColumn("valorFGTS", 777666.0);
		assertEquals(folhaValor.get(0), folha);
	}
	
	@Test
	public void testGetValuesBetween() {
		FolhaDAO folhaDAO = FolhaDAO.getInstance(PostgresConnector.getSession());
		System.out.println(folhaDAO.getValuesBetween("salarioBruto", 2570.0, 2571.0));
	}
}