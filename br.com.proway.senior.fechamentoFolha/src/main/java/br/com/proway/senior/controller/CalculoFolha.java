package br.com.proway.senior.controller;

public class CalculoFolha { 
	
	calcular(){
		PontoFolha ponto = new PontoFolha();
		ColaboradorFolha colab = new ColaboradorFolha();
		Folha folha = new Folha(colab, ponto);
	}

}
