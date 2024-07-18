package mafn.com.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CampoInvalido {
    private String campo;
    private String mensagem;
}
