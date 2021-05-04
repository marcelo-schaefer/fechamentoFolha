package br.com.proway.senior.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.FeriasFolha;
import br.com.proway.senior.model.externo.PontoFolha;

public class TesteBuilder {

	@Test
	public void testFolhaNormal() {
		ColaboradorFolha colaborador = new ColaboradorFolha(1, true, 100, 25);
		PontoFolha ponto = new PontoFolha(220, 0, 0);
		CargoFolha cargo = new CargoFolha(35000, 0);
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaNormal(colaborador, ponto, cargo);
		Folha folha = folhaBuilder.build();
		
		System.out.println("TESTE FOLHA NORMAL");
		System.out.println(folha.toString());
	}
	
	@Test
	public void testFolhaFerias() {
		ColaboradorFolha colaborador = new ColaboradorFolha(2, true, 100, 25);
		CargoFolha cargo = new CargoFolha(3500, 20);
		FeriasFolha ferias = new FeriasFolha(15, 3);
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaFerias(colaborador, cargo, ferias);
		Folha folha = folhaBuilder.build();
		
		System.out.println("TESTE FOLHA FERIAS");
		System.out.println(folha.toString());
	}
	
	@Test
	public void testFolhaHibrida() {
		ColaboradorFolha colaborador = new ColaboradorFolha(3, true, 100, 25);
		PontoFolha ponto = new PontoFolha(220, 30, 45);
		CargoFolha cargo = new CargoFolha(2578, 10);
		FeriasFolha ferias = new FeriasFolha(20, 10);
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaHibrida(colaborador, ponto, cargo, ferias);
		Folha folha = folhaBuilder.build();
		
		System.out.println("TESTE FOLHA HIBRIDA");
		System.out.println(folha.toString());
	}
	
	@Test
	public void testFolhaNormalDeMesa() {
		ColaboradorFolha colaborador = new ColaboradorFolha(4, true, 100, 15);
		PontoFolha ponto = new PontoFolha(220, 13.58, 7.46);
		CargoFolha cargo = new CargoFolha(1850, 40);
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaNormal(colaborador, ponto, cargo);
		Folha folha = folhaBuilder.build();
		//assertEquals(2466.78, folha.getSalarioBruto(),0.01);
		System.out.println("TESTE FOLHA NORMAL MESA");
		System.out.println(folha.toString());
	}

}
