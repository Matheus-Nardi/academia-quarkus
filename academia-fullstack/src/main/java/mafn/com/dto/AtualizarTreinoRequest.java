package mafn.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mafn.com.model.enums.Dificuldade;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarTreinoRequest {
    private String nomeTreino;
    private Dificuldade dificuldade;
    private String descricao;
    private Long duracao;
}
