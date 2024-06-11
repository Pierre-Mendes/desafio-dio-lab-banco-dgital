package Validator;

import Interfaces.ContaValidatorInterface;

import java.util.Objects;

public class ContaValidator implements ContaValidatorInterface {

    @Override
    public void validarSaque(double valor, double saldo) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
        }

        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar o saque.");
        }
    }

    @Override
    public void validarTransferencia(double valor, double saldo) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da transferência deve ser maior que zero.");
        }
        if (saldo < valor) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar a transferência.");
        }
    }

    public void callValidate(String nameValidate, double valor, double saldo) {
        if (Objects.equals(nameValidate, "saque")) {
            validarSaque(valor, saldo);
        }

        if (Objects.equals(nameValidate, "transferencia")) {
            validarTransferencia(valor, saldo);
        }
    }
}
