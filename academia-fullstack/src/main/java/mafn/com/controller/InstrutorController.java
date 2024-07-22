package mafn.com.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mafn.com.dto.CriarInstrutorResquest;
import mafn.com.model.Instrutor;
import mafn.com.service.InstrutorService;
import mafn.com.utils.ValidarEntradas;

@Path("/instrutores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InstrutorController {

    private InstrutorService instrutorService;
    private Validator validator;

    
    @Inject
    public InstrutorController(InstrutorService instrutorService, Validator validator) {
        this.instrutorService = instrutorService;
        this.validator = validator;
    }


    @POST
    public Response criarInstrutor(CriarInstrutorResquest instrutorRequest){
        Set<ConstraintViolation<CriarInstrutorResquest>> violations = validator.validate(instrutorRequest);
        if(!violations.isEmpty()){
            return ValidarEntradas.validarEntradas(violations).statusCode(Response.Status.BAD_REQUEST);
        }
        Instrutor instrutor = instrutorService.criarInstrutor(instrutorRequest);
        return Response.status(Status.CREATED).entity(instrutor).build();
    }

    @GET
    public Response listarInstrutores(){
        List<Instrutor> instrutores = instrutorService.listarInstrutores();
        instrutores.sort(Comparator.comparing(Instrutor::getNome));
        return Response.ok().entity(instrutores).build();
    }

    @GET
    @Path("/filtros")
    public Response listarInstrutorePorEspecialidade(@QueryParam("especialidade") String especialidade){
        List<Instrutor> instrutores = instrutorService.listarInstrutoresPorEspecialidade(especialidade);
        instrutores.sort(Comparator.comparing(Instrutor::getNome));
        return Response.ok().entity(instrutores).build();
    }

    @PUT
    @Path("{id}")
    public Response atualizarInstrutor(@PathParam("id") Long id , CriarInstrutorResquest instrutorResquestUpdate){
        Set<ConstraintViolation<CriarInstrutorResquest>> violations = validator.validate(instrutorResquestUpdate);
        if(!violations.isEmpty()){
            return ValidarEntradas.validarEntradas(violations).statusCode(Response.Status.BAD_REQUEST);
        }
        if(instrutorService.atualizarInstrutor(id, instrutorResquestUpdate)){
            return Response.noContent().build();
        }

        return Response.status(Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarInstrutor(@PathParam("id") Long id ){
        if(instrutorService.deletarInstrutor(id)){
            return Response.noContent().build();
        }

        return Response.status(Status.NOT_FOUND).build();
    }
}
