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
@DiscriminatorValue("CORRENTE")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class ContaCorrente extends Conta{
    @Column(precision=19, scale=2)
    private BigDecimal limite;
    @Column(precision=19, scale=4)
    private BigDecimal taxa;
}
