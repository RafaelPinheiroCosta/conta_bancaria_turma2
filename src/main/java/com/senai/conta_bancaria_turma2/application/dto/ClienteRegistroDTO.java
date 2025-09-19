package com.senai.conta_bancaria_turma2.application.dto;

public record ClienteRegistroDTO(
        String nome,
        String cpf,
        ContaResumoDTO contaDTO
) {
}
