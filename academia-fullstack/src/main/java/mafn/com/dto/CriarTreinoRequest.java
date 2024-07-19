package mafn.com.dto;

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

    private String nome;
    private String descricao;
    private Long duracao;
    private Dificuldade dificuldade;
    private Long instrutor;
    private Long aluno;

}
