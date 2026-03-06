package com.example.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    @Test
    void deveDepositarValorValido() {
        // Arrange
        ContaBancaria conta = new ContaBancaria(100.0);

        // Act
        conta.depositar(50.0);

        // Assert
        assertEquals(150.0, conta.getSaldo(), "O saldo deve ser a soma do inicial com o depósito.");
    }

    @Test
    void deveLancarExcecaoParaDepositoInvalido() {
        // Arrange
        ContaBancaria conta = new ContaBancaria(100.0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(-10.0), "Depósitos negativos devem lançar IllegalArgumentException.");
    }

    @Test
    void deveSacarValorValido() {
        // Arrange
        ContaBancaria conta = new ContaBancaria(100.0);

        // Act
        conta.sacar(40.0);

        // Assert
        assertEquals(60.0, conta.getSaldo(), "O saldo deve diminuir após o saque.");
    }

    @Test
    void deveLancarExcecaoParaSaqueAcimaDoSaldo() {
        // Arrange
        ContaBancaria conta = new ContaBancaria(50.0);

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> conta.sacar(100.0), "Saques maiores que o saldo devem lançar IllegalStateException.");
    }

    @Test
    void deveManterSaldoCorretoEmMultiplasOperacoes() {
        // Arrange
        ContaBancaria conta = new ContaBancaria(0.0);

        // Act
        conta.depositar(200.0);
        conta.sacar(50.0);
        conta.depositar(10.0);

        // Assert
        assertEquals(160.0, conta.getSaldo(), "O saldo final após múltiplas operações deve ser 160.");
    }
}