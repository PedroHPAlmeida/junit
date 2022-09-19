package com.github.pedrohpalmeida.tdd.service;

import com.github.pedrohpalmeida.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @Test
    public void deveriaLancarExceptionParaFuncionarioComSalarioMaiorQueDezMil() {
        BonusService bonusService = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> bonusService.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal("25000"))));
/*        try { // Segunda forma de se lidar com testes de Exception
            bonusService.calcularBonus(new Funcionario("Pedro", LocalDate.now(), new BigDecimal("25000")));
            fail("A Exception não foi lançada"); // Caso a linha de cima não lance a Exception, o teste é forçado a falhar
        } catch (IllegalArgumentException e){
            assertEquals("Funcionário com salário maior do que R$ 10000,00 não pode receber bônus", e.getMessage());
        }*/
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
