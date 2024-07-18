package mafn.com.utils;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.StatusType;
import lombok.Data;

@Data
public class ValidarEntradas {

    private String mensagem;
    private Collection<CampoInvalido> entradasInvalidas;
    private boolean sucesso;
    

    private ValidarEntradas(String mensagem , Collection<CampoInvalido> entradasInvalidas){
        this.mensagem = mensagem;
        this.entradasInvalidas = entradasInvalidas;
        this.sucesso = true;
    }

    public static <T> ValidarEntradas validarEntradas(Set<? extends ConstraintViolation<?>> violacoes) {
        List<CampoInvalido> camposInvalidos = violacoes.stream()
                            .map(cv -> new CampoInvalido(cv.getPropertyPath().toString() , cv.getMessage()))
                            .collect(Collectors.toList());
            String mensagem = "Entrada inválida";

            return new ValidarEntradas(mensagem, camposInvalidos);
    }

    public Response statusCode(StatusType status) {
		return Response.status(status).entity(this).build();
	}


   


}
