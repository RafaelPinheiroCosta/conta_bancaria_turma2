package com.senai.conta_bancaria_turma2.domain.exceptions;

public class SaldoInsuficienteException extends RuntimeException {
  public SaldoInsuficienteException() {
    super("Saldo insuficiente para realizar a operação.");
  }
}
