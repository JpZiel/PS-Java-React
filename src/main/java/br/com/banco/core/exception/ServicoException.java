package br.com.banco.core.exception;

public class ServicoException extends RuntimeException {

    public ServicoException(String mensagem){
        super(mensagem);
    }
}
