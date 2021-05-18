package br.com.proway.senior.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.proway.senior.model.Plr;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlrDAOTest {
	
	@Test
	public void AtestInsert() {
		PlrDAO plrDao = PlrDAO.getInstance(PostgresConnector.getSession());
		Plr plr = new Plr();
		plr.setVencimento(LocalDate.of(2021, 02, 10));
		plr.setValorPlr(1000);
		plrDao.insert(plr);
		assertTrue(plrDao.getById(25).getValorPlr() == 1000);
	}
	
	@Test
	public void BtestDelete() {
		PlrDAO plrDao = PlrDAO.getInstance(PostgresConnector.getSession());
		plrDao.delete(34);
		assertEquals(plrDao.getAll().size(), 6);
	}
	
	@Test
	public void CtestGetById() {
		PlrDAO plrDao = PlrDAO.getInstance(PostgresConnector.getSession());
		Plr plr = plrDao.getById(30);
		plr.getId();
		assertTrue (plrDao.getById(30).getValorPlr() == 1000);
	}
	
	@Test
	public void DtestGetByDate() {
		PlrDAO plrDao = PlrDAO.getInstance(PostgresConnector.getSession());
		plrDao.getByDate(LocalDate.of(2021, 02, 10));
		assertEquals(plrDao.getById(25).getVencimento(), LocalDate.of(2021,02,10));
	}
	
	@Test
	public void EtestGetAll() {
		PlrDAO plrDao = PlrDAO.getInstance(PostgresConnector.getSession());
		List<Plr> listaPlr = plrDao.getAll();
		assertEquals(listaPlr.size(), 6);
	}
	
	@Test
	public void FtestUpdate() {
		PlrDAO plrDao = PlrDAO.getInstance(PostgresConnector.getSession());
		Plr plr = plrDao.getById(33);
		plr.setValorPlr(8000);
		plrDao.update(plr);
		assertTrue(plrDao.getById(33).getValorPlr() == 8000);
	}
}