package com.senai.conta_bancaria_turma2.domain.repository;

import com.senai.conta_bancaria_turma2.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,String> {
    Optional<Cliente> findByCpfAndAtivoTrue(String cpf);
}
