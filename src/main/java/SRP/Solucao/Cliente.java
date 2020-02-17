package SRP.Solucao;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Cliente {
    private final EmailService emailService;
    private final CPFService cpfService;

    private Integer clientId;
    private String nome;
    private String email;
    private String CPF;
    private Date dataCadastro;

    public boolean isValid() {
        return emailService.isValid(email) && cpfService.isValid(CPF);
    }
}
