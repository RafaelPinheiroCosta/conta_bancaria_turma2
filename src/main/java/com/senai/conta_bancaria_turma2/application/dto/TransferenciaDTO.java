package com.senai.conta_bancaria_turma2.application.dto;

import java.math.BigDecimal;

public record TransferenciaDTO(
        BigDecimal valor,
        String contaDestino
) {
}
