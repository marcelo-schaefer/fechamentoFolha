package br.com.proway.senior.model;

public class CalculosDesconto implements InterfaceImpostoDeRendaDesconto, InterfaceValeTransporteDesconto,
		InterfaceINSSDesconto, InterfacePlanoDeSaudeDesconto {

	public double calcularDescontoPlanoSaude() {
		Folha folha = new Folha();
		if (folha.getMensalidadePlanoSaude() >= 0) {
			if (folha.getValorCooparticipacaoPlanoSaude() >= 0) {
				folha.setPlanoSaude(folha.getMensalidadePlanoSaude() + folha.getValorCooparticipacaoPlanoSaude());
			} else {
				folha.setValorCooparticipacaoPlanoSaude(0);
				folha.setPlanoSaude(folha.getMensalidadePlanoSaude() + folha.getValorCooparticipacaoPlanoSaude());
			}
		} else {
			folha.setMensalidadePlanoSaude(0);
			folha.setValorCooparticipacaoPlanoSaude(0);
			folha.setPlanoSaude(folha.getMensalidadePlanoSaude() + folha.getValorCooparticipacaoPlanoSaude());
		}

		return folha.getPlanoSaude();
	}

	public double calcularDescontoInss() {
		Folha folha = new Folha();
		folha.setInss(folha.getSalarioBruto() * 0.11);
		return folha.getInss();
	}

	public double calcularDescontoInss(double valorFerias) {
		Folha folha = new Folha();
		folha.setInss(valorFerias * 0.11);
		return folha.getInss();
	}

	public double calcularDescontoImpostoRenda(double valorFerias) {
		Folha folha = new Folha();
		double baseCalculoimpostoRenda = valorFerias - this.calcularValorDeduzirDependente();
		if (baseCalculoimpostoRenda <= 1903.98) {
			folha.setValorImpostoDeRenda(0);
		} else if (baseCalculoimpostoRenda >= 1903.99 && baseCalculoimpostoRenda <= 2826.65) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.075) - 142.80);
		} else if (baseCalculoimpostoRenda >= 2826.66 && baseCalculoimpostoRenda <= 3751.05) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.15) - 354.80);
		} else if (baseCalculoimpostoRenda >= 3751.06 && valorFerias <= 4664.68) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.225) - 636.13);
		} else {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.275) - 869.36);
		}

		return folha.getValorImpostoDeRenda();
	}

	public double calcularDescontoImpostoRenda() {
		Folha folha = new Folha();
		double baseCalculoimpostoRenda = folha.getSalarioBruto() - this.calcularValorDeduzirDependente();
		if (baseCalculoimpostoRenda <= 1903.98) {
			folha.setValorImpostoDeRenda(0);
		} else if (baseCalculoimpostoRenda >= 1903.99 && baseCalculoimpostoRenda <= 2826.65) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.075) - 142.80);
		} else if (baseCalculoimpostoRenda >= 2826.66 && baseCalculoimpostoRenda <= 3751.05) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.15) - 354.80);
		} else if (baseCalculoimpostoRenda >= 3751.06 && baseCalculoimpostoRenda <= 4664.68) {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.225) - 636.13);
		} else {
			folha.setValorImpostoDeRenda((baseCalculoimpostoRenda * 0.275) - 869.36);
		}

		return folha.getValorImpostoDeRenda();
	}

	private double calcularValorDeduzirDependente() {
		Folha folha = new Folha();
		double valor = folha.getNumeroDependentes() * folha.getValorPorDependente();
		return valor;
	}

	public double calcularDescontoValeTransporte() {
		Folha folha = new Folha();
		if (folha.isValeTransporte()) {
			folha.setValorValeTransporte(folha.getSalarioBase() * 0.06);
			if (folha.getValorValeTransporte() > 180) {
				folha.setValorValeTransporte(180);
			}
		} else {
			folha.setValorValeTransporte(0);
		}
		return folha.getValorValeTransporte();

	}

}
