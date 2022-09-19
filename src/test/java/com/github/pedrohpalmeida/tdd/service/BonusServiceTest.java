package com.github.pedrohpalmeida.tdd.service;

import com.github.pedrohpalmeida.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMaiorQueDezMil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal("25000")));
        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorcentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorcentoParaSalarioDeExtamenteDezMil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
