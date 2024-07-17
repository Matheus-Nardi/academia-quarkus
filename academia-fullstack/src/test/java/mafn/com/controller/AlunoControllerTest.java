package mafn.com.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import mafn.com.dto.CriarAlunoRequest;
import mafn.com.model.Aluno;
import mafn.com.service.AlunoService;;

public class AlunoControllerTest {

    @Mock
    private AlunoService alunoService;

    @InjectMocks
    private AlunoController alunoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve criar um aluno com sucesso!")
    void deveCriarUmAluno() {
        CriarAlunoRequest request = CriarAlunoRequest.builder()
                .nome("Aluno Teste")
                .idade(22)
                .altura(1.88)
                .peso(86.0)
                .email("aluno@test.com")
                .telefone("123456789")
                .build();

        Aluno aluno = new Aluno();
        aluno.setNome("Aluno Teste");
        aluno.setIdade(22);
        aluno.setAltura(1.88);
        aluno.setPeso(86.0);
        aluno.setEmail("aluno@test.com");
        aluno.setTelefone("123456789");

        when(alunoService.criarAluno(any(CriarAlunoRequest.class))).thenReturn(aluno);

        Response response = alunoController.criarAluno(request);

        assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
        assertEquals(aluno, response.getEntity());
    }

    @Test
    @DisplayName("Deve retornar uma lista de alunos!")
    void deveRetornarListaDeAlunos() {
        List<Aluno> alunos = List.of(new Aluno(1L, "Aluno Teste", 22, 88.0, 1.88, "aluno@test.com", "123456789"));

        when(alunoService.listarAlunos()).thenReturn(alunos);

        assertEquals(1, alunos.size());
        assertEquals("Aluno Teste", alunos.get(0).getNome());
    }

    @Test
    @DisplayName("Deve retornar alunos que possua em seu nome 'Cl' ")
    void deveRetornarAlunosQueContenhamClNoNome() {

        List<Aluno> alunos = List.of(new Aluno(1L, "Claudio", 22, 88.0, 1.88, "aluno@test.com", "123456789"),
                new Aluno(2l, "Clara", 22, 66.0, 1.55, "clara@gmail.com", "12345678"));

        when(alunoService.listarAlunosPorNome("Cl")).thenReturn(alunos);

        assertEquals(2, alunos.size(), "A lista deve ter tamanho 2");
        assertEquals(alunos.get(0).getNome(), "Claudio", "O primeiro aluno deve ser Claudio");
        assertEquals(alunos.get(1).getNome(), "Clara", "O segundo aluno deve ser Clara");

    }

    @Test
    @DisplayName("deve atualizar um aluno com sucesso")
    void deveAtualizarUmAluno() {
        CriarAlunoRequest request = CriarAlunoRequest.builder()
                .nome("Aluno Teste")
                .idade(22)
                .altura(1.88)
                .peso(86.0)
                .email("aluno@emailNovo.com")
                .telefone("123456789")
                .build();

        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Aluno Teste");
        aluno.setIdade(22);
        aluno.setAltura(1.88);
        aluno.setPeso(86.0);
        aluno.setEmail("aluno@emailAntigo.com");
        aluno.setTelefone("123456789");

         when(alunoService.atualizarAluno(eq(1L), any(CriarAlunoRequest.class))).thenReturn(true);

        Response response = alunoController.atualizarAluno(1L, request);

        assertEquals(Status.NO_CONTENT.getStatusCode(), response.getStatus(), "Status deve ser NO_CONTENT");
        
    }

}
