package br.com.proway.senior.fechamentoFolha;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiltroTest {

	@Test
	public void testGetFolhaPorColaborador() {
		int idFolha = 0;
		int idColaborador = 0;
		Colaborador colaborador = new Colaborador(idColaborador);
		CadastroColaborador cadastro = new CadastroColaborador();
		Folha folha0 = new Folha(idFolha);
		colaborador.setTotalFolhas(folha0);
		cadastro.setColaboradores(colaborador);		
		Filtro filtro = new Filtro();
		Folha folha = filtro.getFolhaPorColaborador(idColaborador, idFolha, cadastro);
		assertEquals(idFolha,(int)folha.getId());
	}

}
