package br.com.alura.desafios.curso3.exceptions;

public class ConsultaViaCEPException extends RuntimeException {
    private String mensagem;

    public ConsultaViaCEPException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
