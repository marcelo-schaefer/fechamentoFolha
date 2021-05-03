package br.com.proway.senior.builder;

import org.junit.Test;

import br.com.proway.senior.model.CargoFolha;
import br.com.proway.senior.model.ColaboradorFolha;
import br.com.proway.senior.model.FeriasFolha;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.PontoFolha;

public class TesteBuilder {

	@Test
	public void test() {
		ColaboradorFolha colaborador = new ColaboradorFolha(1, true, 100, 25);
		PontoFolha ponto = new PontoFolha(220, 0, 0);
		CargoFolha cargo = new CargoFolha(1500, 0, 0);
		FolhaBuilder folhaBuilder = new FolhaBuilder();
		FeriasFolha folhaFerias = new FeriasFolha();
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolha(colaborador, ponto, folhaFerias, cargo);
		
		Folha folha = folhaBuilder.build();
		
	}

}
