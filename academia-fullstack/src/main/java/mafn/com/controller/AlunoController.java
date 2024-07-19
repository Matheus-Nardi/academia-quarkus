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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mafn.com.dto.CriarAlunoRequest;
import mafn.com.model.Aluno;
import mafn.com.service.AlunoService;
import mafn.com.utils.ValidarEntradas;

@Path("/alunos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoController {

    private AlunoService alunoService;
    private Validator validator;


    @Inject
    public AlunoController(AlunoService alunoService , Validator validator) {
        this.alunoService = alunoService;
        this.validator = validator;
    }

    @POST
    public Response criarAluno(CriarAlunoRequest alunoRequest) {
        Set<ConstraintViolation<CriarAlunoRequest>> violations = validator.validate(alunoRequest);
        if(!violations.isEmpty()){
           return ValidarEntradas.validarEntradas(violations).statusCode(Response.Status.BAD_REQUEST);
        }
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
    @Path("{id}")
    public Response atualizarAluno(@PathParam("id") Long id , CriarAlunoRequest alunoRequestUpdate){
        Set<ConstraintViolation<CriarAlunoRequest>> violations = validator.validate(alunoRequestUpdate);
        if(!violations.isEmpty()){
           return ValidarEntradas.validarEntradas(violations).statusCode(Response.Status.BAD_REQUEST);
        }  
        if(alunoService.atualizarAluno(id, alunoRequestUpdate)){
            return Response.noContent().build();
        }
        return Response.status(Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletarAluno(@PathParam("id") Long id){
        if(alunoService.deletarAluno(id)){
            return Response.noContent().build();
        }

        return Response.status(Status.NOT_FOUND).build();
    }
}
