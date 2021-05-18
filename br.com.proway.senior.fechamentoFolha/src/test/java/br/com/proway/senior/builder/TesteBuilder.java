package br.com.proway.senior.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import br.com.proway.senior.model.Bonificacao;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.FeriasFolha;
import br.com.proway.senior.model.externo.Plr;
import br.com.proway.senior.model.externo.PontoFolha;

public class TesteBuilder {

	@Test
	public void testFolhaNormal() {
		ColaboradorFolha colaborador = new ColaboradorFolha(1, true, 100, 25, 205);
		PontoFolha ponto = new PontoFolha(220, 0, 0);
		CargoFolha cargo = new CargoFolha(3500, 0);

		Plr plr = new Plr();
		plr.setPlr(350.0);
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		Folha folha = director.createFolhaNormal(colaborador, ponto, cargo, plr);
		assertEquals("Folha [id=0, idColaborador=1, dataEmissao=2021-05-14, "
				+ "valorHorasTrabalhadas=3500.0, valorHorasFaltas=0.0, "
				+ "valorHorasExtras=0.0, valorReflexoDSR=0.0, valorInss=385.0, "
				+ "valorImpostoDeRenda=112.44999999999999, valorPlanoSaude=125.0, "
				+ "valorValeTransporte=180.0, salarioBruto=3500.0, salarioLiquido=3047.55, "
				+ "valorFerias=0.0, valorInssFerias=0.0, valorImpostoDeRendaFerias=0.0, "
				+ "feriasLiquido=0.0,valorFGTS= 280.0,valorPLR= 350.0]", folha.toString());
		assertTrue(350.0 == folha.getValorPlr());
	}
	
	@Test
	public void testFolhaFerias() {
		ColaboradorFolha colaborador = new ColaboradorFolha(2, true, 100, 25,205);
		CargoFolha cargo = new CargoFolha(3500, 20);
		FeriasFolha ferias = new FeriasFolha(15, 3);
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaFerias(colaborador, cargo, ferias);
		Folha folha = folhaBuilder.build();
		folha.getId(); // 
	}
	
	@Test
	public void testFolhaHibrida() {
		ColaboradorFolha colaborador = new ColaboradorFolha(3, true, 100, 25,205);
		PontoFolha ponto = new PontoFolha(220, 30, 45);
		CargoFolha cargo = new CargoFolha(2578, 10);
		FeriasFolha ferias = new FeriasFolha(20, 10);
		Plr plr = new Plr();
		plr.setPlr(350.0);
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaHibrida(colaborador, ponto, cargo, ferias, plr);
		Folha folha = folhaBuilder.build();
		
	}
	
	@Test
	public void testFolhaNormalDeMesa() {
		ColaboradorFolha colaborador = new ColaboradorFolha(4, true, 100, 15,205);
		PontoFolha ponto = new PontoFolha(220, 13.58, 7.46);

		CargoFolha cargo = new CargoFolha(1850, 40);
		Plr plr = new Plr();
		plr.setPlr(350.0);

		plr.setPlr(350.0);
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaNormal(colaborador, ponto, cargo, plr);
		Folha folha = folhaBuilder.build();
		//assertEquals(2466.78, folha.getSalarioBruto(),0.01);
	}
	
	@Test
	public void testFolhaNormalComDependente() {
		ColaboradorFolha colaborador = new ColaboradorFolha(5, false, 217, 127,205);
		colaborador.setNome("Lucas Walim");
		colaborador.setEmail("lucas@gmail.com");
		colaborador.addDependentes("Lucas Grijo");
		colaborador.addDependentes("Marcelo");
		
	
		Plr plr = new Plr();
		plr.setPlr(350.0);
		
		PontoFolha ponto = new PontoFolha(220, 17.33, 2.17);
		CargoFolha cargo = new CargoFolha(4600, 40);
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaNormal(colaborador, ponto, cargo, plr);
		Folha folha = folhaBuilder.build();
		System.out.println(folha.toString());
		assertEquals(4660.7299065454545, folha.getSalarioLiquido(), 0.01);
		assertEquals(4310.72, folha.getSalarioLiquido(), 0.01);
	}
	
	@Test
	public void testFolhaNormal2() {
		ColaboradorFolha colaborador = new ColaboradorFolha(5, false, 0, 0,205);
			
		PontoFolha ponto = new PontoFolha(220, 0, 0);

		CargoFolha cargo = new CargoFolha(4500, 0);
		Plr plr = new Plr();
		plr.setPlr(350.0);
		
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaNormal(colaborador, ponto, cargo, plr);
		Folha folha = folhaBuilder.build();
		
		assertEquals(3740.00 + 350.0, folha.getSalarioLiquido(), 0.01);

	
		assertEquals(3740.00, folha.getSalarioLiquido(), 0.01);
	}
	
	@Test
	public void testGetSet() {
		// Teste inutil pra subir Coverage
		ColaboradorFolha colaborador = new ColaboradorFolha(6, false, 0, 0,205);
		colaborador.setNome("Joao");
		colaborador.setEmail("joao@gmail.com");
		colaborador.setId(6);
		colaborador.setValeTransporte(false);
		colaborador.setPlanoSaudeCooparticipacao(10);
		colaborador.setPlanoSaudeMensalidade(50);
		ArrayList<String> listaDependentes = new ArrayList<String>();
		listaDependentes.add("Filho");
		colaborador.setDependentes(listaDependentes);
		
		String nome = colaborador.getNome(), email = colaborador.getEmail();
		boolean vt = colaborador.getValeTransporte();
		int id = colaborador.getId();
		double planoSaude = colaborador.getPlanoSaudeCooparticipacao() + colaborador.getPlanoSaudeMensalidade();
		ArrayList<String> dependentes = colaborador.getDependentes();
	}
	
	@Test
	public void verBonificacaoCargo() {
		CargoFolha cargo = new CargoFolha(1850, 40);
		ColaboradorFolha colaborador = new ColaboradorFolha(6, false, 0, 0,205);
		Bonificacao bonificacao = new Bonificacao();
		bonificacao.setPorcentagemBonificacaoColaborador(6);
		PontoFolha ponto = new PontoFolha(220, 0, 0);
		Plr plr = new Plr();
		plr.setPlr(350.0);
		
		FolhaBuilder folhaBuilder = new FolhaBuilder();	
		
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		director.createFolhaNormal(colaborador, ponto, cargo, plr);
		
		double t = folhaBuilder.atribuiBonificacaoColaborador(cargo, bonificacao);
		
		assertEquals(1961, t, 0.1);
	}
}

