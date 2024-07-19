package mafn.com.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mafn.com.dto.CriarTreinoRequest;
import mafn.com.dto.TreinoResponse;
import mafn.com.model.Treino;
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
        List<Treino> treinos = treinoService.listarTreinos();
        return Response.ok(treinos).build();
    }
}
