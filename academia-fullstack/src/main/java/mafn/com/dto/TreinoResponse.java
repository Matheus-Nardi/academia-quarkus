package mafn.com.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import mafn.com.model.enums.Dificuldade;
@Data
public class TreinoResponse {
    private String nomeTreino;
    private String nomeAluno;
    private String nomeInstrutor;
    private LocalDate dataHora;
    private Long duracao;
    private Dificuldade dificuldade;
    public TreinoResponse(String nomeTreino, String nomeAluno, String nomeInstrutor, LocalDate dataHora, Long duracao,
            Dificuldade dificuldade) {
        this.nomeTreino = nomeTreino;
        this.nomeAluno = nomeAluno;
        this.nomeInstrutor = nomeInstrutor;
        this.dataHora = dataHora;
        this.duracao = duracao;
        this.dificuldade = dificuldade;
    }

    
}
