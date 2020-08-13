package br.com.alyson.desafiostefanini.service.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String mensagem){
        super(mensagem);
    }
}
