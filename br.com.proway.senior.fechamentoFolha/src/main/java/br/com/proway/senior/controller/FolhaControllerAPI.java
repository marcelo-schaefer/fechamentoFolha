package br.com.proway.senior.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.proway.senior.dto.FolhaDto;
import br.com.proway.senior.model.Folha;

public class FolhaControllerAPI {
	
	FolhaController folhaController = new FolhaController();
	
	public  List<FolhaDto> buscarTodasFolhas() {
		List<FolhaDto> listaFolhaDTO = new ArrayList<FolhaDto>();
		List<Folha> lista = folhaController.getAll();
		for (Folha f : lista) {
			listaFolhaDTO.add(new FolhaDto(f));
		}
		return listaFolhaDTO;
	}
	
	public FolhaDto buscarFolhasPorId(Integer idEmpresa) {
		FolhaDto folha = new FolhaDto(folhaController.getById(idEmpresa));
		return folha;
	}
	
	
	
}


