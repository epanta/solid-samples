package DIP.Solucao.Interfaces;

import lombok.Data;

import java.util.Date;

@Data
public class Cliente {
    private final IEmailService emailService;
    private final ICPFService cpfService;

    public Cliente(ICPFService cpfService, IEmailService  emailService){
        this.cpfService = cpfService;
        this.emailService = emailService;
    }

    private Integer clientId;
    private String nome;
    private String email;
    private String CPF;
    private Date dataCadastro;

    public boolean isValid() {
        return emailService.isValid(email) && cpfService.isValid(CPF);
    }
}
