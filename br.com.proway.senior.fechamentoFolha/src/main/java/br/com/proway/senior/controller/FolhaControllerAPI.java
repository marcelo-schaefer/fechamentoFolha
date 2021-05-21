package br.com.proway.senior.controller;

import br.com.proway.senior.dto.FolhaDto;
import br.com.proway.senior.model.Bonificacao;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

public class FolhaControllerAPI {
	
	FolhaController folhaController = new FolhaController();
	
	public Folha construirFolhaNormal(IColaboradorFolha colaborador, IPontoFolha ponto, ICargoFolha cargo, Bonificacao bonificacao) {
		FolhaBuilder folhaBuilder = new FolhaBuilder();
		FolhaDirector director = new FolhaDirector(folhaBuilder);
		return folhaBuilder.build();
	}
	public FolhaDto salvarFolha(FolhaDto folhaDto) {
		return new FolhaDto(folhaController.salvarFolha(folhaDto));
	}

	public void editarFolha(Folha folha) {
		
	}

	public void deletarFolha(Folha folha) {
	}
}


