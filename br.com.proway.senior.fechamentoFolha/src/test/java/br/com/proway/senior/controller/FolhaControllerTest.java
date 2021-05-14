package br.com.proway.senior.controller;

import org.junit.Test;

import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.Plr;
import br.com.proway.senior.model.externo.PontoFolha;

public class FolhaControllerTest {

	@Test
	public void testConstruir() {
		ColaboradorFolha colaborador = new ColaboradorFolha(1, true, 100, 25, 205);
		
		PontoFolha ponto = new PontoFolha(220, 0, 0);
		CargoFolha cargo = new CargoFolha(35000, 0);
		Plr plr = new Plr();
		plr.setPlr(250.0);
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		
		Folha folha = director.createFolhaNormal(colaborador, ponto, cargo, plr);
	}
}