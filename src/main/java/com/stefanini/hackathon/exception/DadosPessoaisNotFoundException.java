package com.stefanini.hackathon.exception;

public class DadosPessoaisNotFoundException extends Exception{
    public DadosPessoaisNotFoundException(Long id) {
       super("Dados Pessoais não encontrado com id:" +id);
    }
}
