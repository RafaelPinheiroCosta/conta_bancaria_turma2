package com.senai.conta_bancaria_turma2.application.service;

import com.senai.conta_bancaria_turma2.application.dto.ClienteRegistroDTO;
import com.senai.conta_bancaria_turma2.application.dto.ClienteResponseDTO;
import com.senai.conta_bancaria_turma2.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteResponseDTO registarClienteOuAnexarConta(ClienteRegistroDTO dto) {

        var cliente = repository.findByCpfAndAtivoTrue(dto.cpf()).orElseGet(
                () -> repository.save(dto.toEntity())
        );

        var contas = cliente.getContas();
        var novaConta = dto.contaDTO().toEntity(cliente);

        boolean jaTemTipo = contas.stream()
                .anyMatch(c -> c.getClass().equals(novaConta.getClass()) && c.isAtiva());

        if(jaTemTipo)
            throw new RuntimeException("Cliente já possui uma conta ativa deste tipo.");

        cliente.getContas().add(novaConta);


        return ClienteResponseDTO.fromEntity(repository.save(cliente));
    }

    public List<ClienteResponseDTO> listarClientesAtivos() {
        return repository.findAllByAtivoTrue().stream()
                .map(ClienteResponseDTO::fromEntity)
                .toList();
    }
}
