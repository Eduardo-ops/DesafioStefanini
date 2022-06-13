package com.stefanini.hackathon.exception;

public class AlunoNotFoundException extends Exception{
    public AlunoNotFoundException(Long id) {
       super("Aluno não encontrado com id:" +id);
    }
}
