package br.com.proway.senior.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.proway.senior.dao.PlrDAO;
import br.com.proway.senior.dao.PostgresConnector;
import br.com.proway.senior.model.Plr;

public class PlrController {
	/**
	 * Cadastra um novo plr no banco de dados.
	 * 
	 * Verifica se existe um plr cadastrado para um detemirnado periodo. Se sim, lanca uma exception,
	 * se nao, insere este plr no banco de dados.
	 * 
	 * @param data
	 * @param valor
	 * @throws Exception
	 */
	public void cadastrarPlr(LocalDate data, double valor) throws Exception {
		PlrDAO db = PlrDAO.getInstance(PostgresConnector.getSession());
		Plr plr = new Plr();
		plr.setVencimento(data);
		plr.setValorPlr(valor);
		
		ArrayList<Plr> plrsBuscados = (ArrayList<Plr>) db.getAll(); 
		if(!plrsBuscados.isEmpty()) {
			for (Plr plrProcurado : plrsBuscados) {
				if (plrProcurado.getVencimento().getYear() == data.getYear()) {
					if (plrProcurado.getVencimento().getMonth() == data.getMonth()) {
						throw new Exception("PLR ja cadastrado para este per�odo");
					}
				} 
			}
			db.insert(plr);
		} else {
			db.insert(plr);
		}
	}
	
	/**
	 * Busca todas as {@link Plr}s do banco de dados;
	 * 
	 * @return ArrayList<Plr>
	 */
	public ArrayList<Plr> buscarTodosPlr() throws Exception {
		PlrDAO db = PlrDAO.getInstance(PostgresConnector.getSession());
		ArrayList<Plr> plrs = new ArrayList<Plr>();
		try {
			plrs = (ArrayList<Plr>) db.getAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return plrs;
	}
	
	/**
	 * Atualiza {@link Plr}.
	 * 
	 * Busca no banco de dados uma {@link Plr} no mesmo periodo da data inserida e altera
	 * o valor desta {@link Plr} com o valor do parametro valor..
	 * 
	 * @param data
	 * @param valor
	 * @throws Exception
	 */
	public void atualizarPlr(LocalDate data, double valor) throws Exception {
		PlrDAO db = PlrDAO.getInstance(PostgresConnector.getSession());
		boolean plrExiste = false;
		ArrayList<Plr> plrs = (ArrayList<Plr>) db.getAll();
		
		for(Plr plr : plrs) {
			if(plr.getVencimento().getYear() == data.getYear()) {
				if(plr.getVencimento().getMonth() == data.getMonth()) {
					plrExiste = true;
				}
			}
		}
		if(plrExiste) {
			for(Plr plr : plrs) {
				if(plr.getVencimento().getYear() == data.getYear()) {
					if(plr.getVencimento().getMonth() == data.getMonth()) {
						plr.setValorPlr(valor);
						db.update(plr);
					}
				}
			}
		} else {
			throw new Exception("Impossivel atualizar: Plr inexistente.");
		}
	}
	
	/**
	 * Busca o valor de uma {@link Plr} do mes da data passada no parametro.
	 * 
	 * @return
	 */
	public double getValorPlrMes(LocalDate date) {
		PlrDAO db = PlrDAO.getInstance(PostgresConnector.getSession());
		ArrayList<Plr> plrs = (ArrayList<Plr>) db.getAll();
		
		for(Plr plr : plrs) {
			if(plr.getVencimento().getYear() == date.getYear()) {
				if(plr.getVencimento().getMonth() == date.getMonth()) {
					return plr.getValorPlr();
				}
			}
 		}
		return 0.0;
	}
}