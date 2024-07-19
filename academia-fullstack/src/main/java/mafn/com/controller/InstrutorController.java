package mafn.com.controller;

import java.util.Comparator;
import java.util.List;

import jakarta.inject.Inject;
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

@Path("/instrutores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InstrutorController {

    private InstrutorService instrutorService;

    
    @Inject
    public InstrutorController(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }


    @POST
    public Response criarInstrutor(CriarInstrutorResquest instrutorRequest){
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
