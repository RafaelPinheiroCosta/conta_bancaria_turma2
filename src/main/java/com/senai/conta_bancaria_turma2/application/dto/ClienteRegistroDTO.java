package com.senai.conta_bancaria_turma2.application.dto;

import com.senai.conta_bancaria_turma2.domain.entity.Cliente;
import com.senai.conta_bancaria_turma2.domain.entity.Conta;

import java.util.ArrayList;

public record ClienteRegistroDTO(
        String nome,
        String cpf,
        ContaResumoDTO contaDTO
) {
    public Cliente toEntity() {
        return Cliente.builder()
                .ativo(true)
                .nome(this.nome)
                .cpf(this.cpf)
                .contas(new ArrayList<Conta>())
                .build();
    }
}
