package mafn.com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriarAlunoRequest {

    private String nome;
    private Integer idade;
    private Double peso;
    private Double altura;
    private String email;
    private String telefone;
}
