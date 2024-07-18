package mafn.com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriarInstrutorResquest {

    private String nome;
    private String especialidade;
    private String email;
    private String telefone;

}
