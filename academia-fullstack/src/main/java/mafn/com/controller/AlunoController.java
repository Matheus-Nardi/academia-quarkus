package mafn.com.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mafn.com.dto.CriarAlunoRequest;
import mafn.com.model.Aluno;
import mafn.com.service.AlunoService;

@Path("/alunos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoController {

    private AlunoService alunoService;

    @Inject
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @POST
    public Response criarAluno(CriarAlunoRequest alunoRequest) {
        Aluno aluno = alunoService.criarAluno(alunoRequest);
        return Response.status(Status.CREATED).entity(aluno).build();
    }

    @GET
    public Response listarAlunos() {
        List<Aluno> alunos = alunoService.listarAlunos();
        return Response.ok(alunos).build();
    }

    @GET
    @Path("{nome}")
    public Response listarAlunosPorNome(@PathParam("nome") String nome) {
        List<Aluno> alunos = alunoService.listarAlunosPorNome(nome);
        return Response.ok(alunos).build();
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Response atualizarAluno(@PathParam("id") Long id , CriarAlunoRequest alunoRequestUpdate){
        if(alunoService.atualizarAluno(id, alunoRequestUpdate)){
            return Response.noContent().build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response deletarAluno(@PathParam("id") Long id){
        if(alunoService.deletarAluno(id)){
            return Response.noContent().build();
        }

        return Response.status(Status.NOT_FOUND).build();
    }
}
