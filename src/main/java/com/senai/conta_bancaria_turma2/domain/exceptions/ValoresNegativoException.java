package com.senai.conta_bancaria_turma2.domain.exceptions;

public class ValoresNegativoException extends RuntimeException {
    public ValoresNegativoException(String operacao) {
        super("Não é possível realizar a operação de "
                + operacao + " com valores negativos.");
    }
}
