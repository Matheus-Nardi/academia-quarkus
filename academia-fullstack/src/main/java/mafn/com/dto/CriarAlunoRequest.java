package mafn.com.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriarAlunoRequest {

    @NotEmpty(message = "O nome não pode ser vazio!")
    private String nome;

    @NotNull(message = "A idade não pode ser nula!")
    private Integer idade;

    @NotNull(message = "O peso não pode ser nulo!")
    private Double peso;

    @NotNull(message = "A altura não pode ser nula!")
    private Double altura;

    @NotEmpty(message = "O email não pode ser vazio!")
    private String email;
    
    private String telefone;
}
