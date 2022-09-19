package com.github.pedrohpalmeida.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.github.pedrohpalmeida.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcionário com salário maior do que R$ 10000,00 não pode receber bônus");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
