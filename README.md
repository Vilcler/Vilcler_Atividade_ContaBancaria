# 🏦 Sistema de Conta Bancária - Testes Unitários com JUnit 5

Este repositório contém uma implementação simples de uma **Conta Bancária** em Java, desenvolvida para demonstrar a aplicação de **Testes Unitários** utilizando o framework **JUnit 5** e o gerenciador de dependências **Gradle**.

O foco principal é a utilização do padrão **AAA (Arrange, Act, Assert)** para garantir que as regras de negócio sejam cumpridas rigorosamente.

---

## 🚀 Tecnologias e Ferramentas
* **Linguagem:** Java 17+
* **Framework de Teste:** JUnit 5 (Jupiter)
* **Build Tool:** Gradle
* **Conceitos:** Testes Unitários, TDD, Padrão AAA

---

## 🧠 Regras de Negócio Implementadas
As operações seguem validações de segurança para evitar estados inconsistentes:
1. **Depósito:** Apenas valores positivos são aceitos.
2. **Saque:** Não é permitido sacar valores negativos ou superiores ao saldo disponível.
3. **Exceções:** O sistema lança `IllegalArgumentException` para valores inválidos e `IllegalStateException` para falta de saldo.

---

## 💻 Implementação do Código

### 1. Classe de Negócio (`ContaBancaria.java`)
Gerencia o estado do saldo e as operações financeiras.

```java
public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        this.saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }
}

```

## 2. Classe de Teste Unitário (ContaBancariaTest.java)
Utiliza o padrão AAA para organizar cada cenário de teste

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

```java
class ContaBancariaTest {

    @Test
    void deveDepositarValorValido() {
        // Arrange (Organizar)
        ContaBancaria conta = new ContaBancaria(100.0);

        // Act (Agir)
        conta.depositar(50.0);

        // Assert (Verificar)
        assertEquals(150.0, conta.getSaldo());
    }

    @Test
    void deveLancarExcecaoParaSaldoInsuficiente() {
        // Arrange
        ContaBancaria conta = new ContaBancaria(50.0);

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> conta.sacar(100.0));
    }
}
```



## 🧪 Por que Testes Automatizados?
Os testes automatizados ajudam a garantir a qualidade do software em 5 pontos chave:

Prevenção de Regressões: Garantem que novas funcionalidades não quebrem o que já funciona.

Feedback Imediato: Detectam erros de lógica e falhas no momento em que o código é escrito.

Documentação Viva: Demonstram exatamente como cada parte do sistema deve se comportar.

Refatoração Segura: Permitem melhorar o código com a confiança de que o comportamento permanece intacto.

Confiabilidade no Deploy: Reduzem testes manuais repetitivos, garantindo entregas mais estáveis.



## 📖 Como executar
1. Clone o repositório.
2. Abra o projeto em sua IDE (IntelliJ IDEA, VS Code ou Eclipse).
3. Navegue até a pasta `src/test/java/`.
4. Clique com o botão direito no arquivo de teste e selecione **"Run Tests"**.

---
Feito com ❤️ por Vilcler Estumano
