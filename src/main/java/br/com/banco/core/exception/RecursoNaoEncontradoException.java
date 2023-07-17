package br.com.banco.core.exception;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
