package mafn.com.utils;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import lombok.Data;

@Data
public class ValidarEntradas {

    private String mensagem;
    private boolean sucesso;
    

    public ValidarEntradas(String mensagem){
        this.mensagem = mensagem;
        this.sucesso = true;
    }

    public String validarEntradas(Set<? extends ConstraintViolation<?>> violacoes) {
        this.sucesso = false;
        this.mensagem = violacoes.stream()
             .map(cv -> cv.getMessage())
             .collect(Collectors.joining(", "));

		return this.mensagem;
    }


   


}
