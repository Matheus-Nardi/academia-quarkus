package mafn.com.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mafn.com.model.enums.Dificuldade;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreinoResponse {
    private String nomeTreino;
    private String nomeAluno;
    private String nomeInstrutor;
    private LocalDateTime dataHora;
    private Long duracao;
    private Dificuldade dificuldade;
    private String descricaoTreino;
    
}
