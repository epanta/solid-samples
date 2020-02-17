package DIP.Violacao;

import SRP.Solucao.Cliente;
import SRP.Solucao.ClienteRepository;
import SRP.Solucao.EmailService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteService {

    private EmailService emailService;

    public String adicionarCliente(Cliente cliente) {
        if(!cliente.isValid()) return "Dados Invalidos";

        ClienteRepository repo = new ClienteRepository();
        repo.adicionarCLiente(cliente);

        emailService.enviar("panta@gmail.com", cliente.getEmail(), "Bem vindo", "Parabéns está cadastrado");

        return "Cliente cadastrado com sucesso";
    }
}
