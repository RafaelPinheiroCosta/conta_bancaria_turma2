package com.senai.conta_bancaria_turma2.domain.exceptions;

public class ContaMesmoTipoException extends RuntimeException {
    public ContaMesmoTipoException() {
        super("O Cliente já possui uma conta do mesmo tipo.");
    }
}
