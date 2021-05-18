package br.com.proway.senior.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.proway.senior.model.Bonificacao;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.externo.CargoFolha;
import br.com.proway.senior.model.externo.ColaboradorFolha;
import br.com.proway.senior.model.externo.Plr;
import br.com.proway.senior.model.externo.PontoFolha;

public class BonificacaoDAOTest {

	@Test
	public void testAdicionarBonificacao() {
		BonificacaoDAO bonificacaoDAO = BonificacaoDAO.getInstance(PostgresConnector.getSession());
		//Variaveis de teste

		Bonificacao bonificacao = new Bonificacao();
		bonificacao.setPorcentagemBonificacaoColaborador(6);
		bonificacaoDAO.insert(bonificacao);	
	}

}
