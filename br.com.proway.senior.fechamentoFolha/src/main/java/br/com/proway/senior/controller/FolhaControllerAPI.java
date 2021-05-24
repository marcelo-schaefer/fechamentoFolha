package br.com.proway.senior.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.dto.FolhaDto;
import br.com.proway.senior.model.Bonificacao;
import br.com.proway.senior.model.Folha;
import br.com.proway.senior.model.FolhaBuilder;
import br.com.proway.senior.model.FolhaDirector;
import br.com.proway.senior.model.externo.interfaces.ICargoFolha;
import br.com.proway.senior.model.externo.interfaces.IColaboradorFolha;
import br.com.proway.senior.model.externo.interfaces.IFeriasFolha;
import br.com.proway.senior.model.externo.interfaces.IPontoFolha;

public class FolhaControllerAPI {

	FolhaController folhaController = new FolhaController();

	public List<FolhaDto> buscarTodasFolhas() {
		List<FolhaDto> listaFolhaDTO = new ArrayList<FolhaDto>();
		List<Folha> lista = folhaController.getAll();
		for (Folha f : lista) {
			listaFolhaDTO.add(new FolhaDto(f));
		}
		return listaFolhaDTO;
	}

	public FolhaDto buscarFolhasPorId(Integer id) {
		FolhaDto folha = new FolhaDto(folhaController.getById(id));
		return folha;
	}
	
	public FolhaDto construirFolhaNormal(IColaboradorFolha colaborador, 
			IPontoFolha ponto, ICargoFolha cargo, Bonificacao bonificacao) {
		FolhaDto folhaNormal = new FolhaDto(folhaController.
				construirFolhaNormal(colaborador, ponto, cargo, bonificacao));
		return folhaNormal;
	}
	
	public FolhaDto construirFolhaFerias(IColaboradorFolha colaborador,
			IFeriasFolha ferias, ICargoFolha cargo) {
		FolhaDto folhaFerias = new FolhaDto(folhaController.
				construirFolhaFerias(colaborador,  ferias,  cargo));
		return folhaFerias;
	}
	
	public FolhaDto construirFolhaHibrida(IColaboradorFolha colaborador, 
			IPontoFolha ponto, ICargoFolha cargo, IFeriasFolha ferias) {
		FolhaDto folhaHibrida = new FolhaDto(folhaController.
				construirFolhaHibrida( colaborador,  ponto,  cargo, ferias));
		return folhaHibrida;
	}

}
