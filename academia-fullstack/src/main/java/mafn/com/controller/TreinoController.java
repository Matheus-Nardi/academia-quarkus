package mafn.com.controller;

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
import mafn.com.dto.AtualizarTreinoRequest;
import mafn.com.dto.CriarTreinoRequest;
import mafn.com.dto.TreinoResponse;
import mafn.com.service.TreinoService;
import mafn.com.utils.ValidarEntradas;

@Path("/treinos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TreinoController {

    private TreinoService treinoService;
    private Validator validator;

    @Inject
    public TreinoController(TreinoService treinoService , Validator validator) {
        this.treinoService = treinoService;
        this.validator = validator;
    }

    @POST
    public Response criarTreino(CriarTreinoRequest criarTreinoRequest) {
        Set<ConstraintViolation<CriarTreinoRequest>> violations = validator.validate(criarTreinoRequest);
        if(!violations.isEmpty()){
            ValidarEntradas.validarEntradas(violations).statusCode(Status.BAD_REQUEST);
        }
        treinoService.criarTreino(criarTreinoRequest);
        return Response.status(Response.Status.CREATED).entity(criarTreinoRequest).build();
    }

    @GET
    public Response listarTreinos() {
        List<TreinoResponse> treinos = treinoService.listarTreinos();
        return Response.ok(treinos).build();
    }


    @GET
    @Path("/filtros")
    public Response listarTreinoPorData(@QueryParam ("data") String data) {
        List<TreinoResponse> treinosPorData = treinoService.listarTreinosPorData(data);
        return Response.ok(treinosPorData).build();
    }

    @GET
    @Path("/filtros")
    public Response listarTreinoPorNome(@QueryParam("nome") String nome){
        List<TreinoResponse> treinosPorNome = treinoService.listarTreinoPorNome(nome);
        return Response.ok(treinosPorNome).build();
    }

    @PUT
    @Path("{id}")
    public Response atualizarTreino(@PathParam("id") Long id , AtualizarTreinoRequest atualizarTreinoRequest){
        if(treinoService.atualizarTreino(id, atualizarTreinoRequest)){
            return Response.noContent().build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarTreino(@PathParam("id") Long id){
        if(treinoService.deletarTreino(id)){
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
