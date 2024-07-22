package mafn.com.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriarInstrutorResquest {

    @NotBlank(message = "O nome não pode ser vazio!")
    private String nome;
    @NotBlank(message = "A especialiade não pode ser vazia!")
    private String especialidade;
    @NotBlank(message = "O email não pode ser vazio!")
    private String email;
    @NotBlank(message = "O telefone não pode ser vazio!")
    private String telefone;

}
