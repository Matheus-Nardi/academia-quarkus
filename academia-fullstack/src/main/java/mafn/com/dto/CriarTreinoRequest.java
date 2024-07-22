package mafn.com.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mafn.com.model.enums.Dificuldade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CriarTreinoRequest {

    @NotBlank(message = "O nome do treino não pode ser vazio.")
    private String nome;
    @NotBlank(message = "A descrição não pode ser vazia.")
    private String descricao;
    @NotNull(message = "A duração não pode ser nula.")
    private Long duracao;
    private Dificuldade dificuldade;
    @NotNull(message = "O instrutor deve possuir um id.")
    private Long instrutor;
    @NotNull(message = "O aluno deve possuir um id.")
    private Long aluno;

}
