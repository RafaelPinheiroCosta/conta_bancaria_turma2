package com.senai.conta_bancaria_turma2.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("POUPANCA")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ContaPoupanca extends Conta{

    @Column(precision=10, scale=2)
    private BigDecimal rendimento;

    @Override
    public String getTipo() {
        return "POUPANCA";
    }


    public void aplicarRendimento() {
        var ganho = getSaldo().multiply(rendimento);
        setSaldo(getSaldo().add(ganho));
    }
}
