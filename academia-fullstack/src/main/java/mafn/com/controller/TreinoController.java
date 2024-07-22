package mafn.com.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mafn.com.dto.AtualizarTreinoRequest;
import mafn.com.dto.CriarTreinoRequest;
import mafn.com.dto.TreinoResponse;
import mafn.com.service.TreinoService;

@Path("/treinos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TreinoController {

    private TreinoService treinoService;

    @Inject
    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @POST
    public Response criarTreino(CriarTreinoRequest criarTreinoRequest) {
        treinoService.criarTreino(criarTreinoRequest);
        return Response.status(Response.Status.CREATED).entity(criarTreinoRequest).build();
    }

    @GET
    public Response listarTreinos() {
        List<TreinoResponse> treinos = treinoService.listarTreinos();
        return Response.ok(treinos).build();
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
