package com.senai.conta_bancaria_turma2.domain.exceptions;

public class RendimentoInvalidoException extends RuntimeException {
    public RendimentoInvalidoException() {
        super( "Rendimento deve ser aplicado somente em conta poupança!" );
    }
}
