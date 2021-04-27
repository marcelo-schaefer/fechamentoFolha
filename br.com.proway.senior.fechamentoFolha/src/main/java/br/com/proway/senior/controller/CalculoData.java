package br.com.proway.senior.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.proway.senior.model.Folha;

public class CalculoData implements InterfaceCalculoData{
	
	/**
	 * Pega a dataEmissao atual
	 * 
	 * Vai virar uma classe
	 * 
	 * Seta o atributo dataEmissao com a dataEmissao atual no formato DD/MM/AAAA
	 */
	public void setDataEmissao(Folha folha) {
		LocalDateTime dataEmissaoTime = LocalDateTime.now();
		DateTimeFormatter dataEmissaoFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		folha.setDataEmissao(dataEmissaoTime.format(dataEmissaoFormatada));
	}
	
}
