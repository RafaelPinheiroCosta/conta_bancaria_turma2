package com.senai.conta_bancaria_turma2.interface_ui;

import com.senai.conta_bancaria_turma2.application.dto.ContaAtualizacaoDTO;
import com.senai.conta_bancaria_turma2.application.dto.ContaResumoDTO;
import com.senai.conta_bancaria_turma2.application.dto.TransferenciaDTO;
import com.senai.conta_bancaria_turma2.application.dto.ValorSaqueDepositoDTO;
import com.senai.conta_bancaria_turma2.application.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService service;

    @GetMapping
    public ResponseEntity<List<ContaResumoDTO>> listarTodasContas() {
        return ResponseEntity.ok(service.listarTodasContas());
    }

    @GetMapping("/{numeroDaConta}")
    public ResponseEntity<ContaResumoDTO> buscarContaPorNumero(@PathVariable String numeroDaConta) {
        return ResponseEntity.ok(service.buscarContaPorNumero(numeroDaConta));
    }


    @PutMapping("/{numeroConta}")
    public ResponseEntity<ContaResumoDTO> atualizarConta(@PathVariable String numeroConta,
                                                         @RequestBody ContaAtualizacaoDTO dto) {
        return ResponseEntity.ok(service.atualizarConta(numeroConta,dto));
    }

    @DeleteMapping("/{numeroDaConta}")
    public ResponseEntity<Void> deletarConta(@PathVariable String numeroDaConta) {
        service.deletarConta(numeroDaConta);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{numeroConta}/sacar")
    public ResponseEntity<ContaResumoDTO> sacar(@PathVariable String numeroConta,
                                                @RequestBody ValorSaqueDepositoDTO dto) {
        return ResponseEntity.ok(service.sacar(numeroConta, dto));
    }
    @PostMapping("/{numeroConta}/depositar")
    public ResponseEntity<ContaResumoDTO> depositar(@PathVariable String numeroConta,
                                                   @RequestBody ValorSaqueDepositoDTO dto) {
        return ResponseEntity.ok(service.depositar(numeroConta, dto));
    }

    @PostMapping("/{numeroConta}/transferir")
    public ResponseEntity<ContaResumoDTO> transferir(@PathVariable String numeroConta,
                                                     @RequestBody TransferenciaDTO dto) {
        return ResponseEntity.ok(service.transferir(numeroConta, dto));
    }

    @PostMapping("/{numeroDaConta}/rendimento")
    public ResponseEntity<ContaResumoDTO> aplicarRendimento(@PathVariable String numeroDaConta ){
        return ResponseEntity.ok(service.aplicarRendimento(numeroDaConta));
    }
}
