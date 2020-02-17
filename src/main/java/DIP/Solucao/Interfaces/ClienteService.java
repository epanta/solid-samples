package DIP.Solucao.Interfaces;

import SRP.Solucao.Cliente;

public class ClienteService implements IClienteService {

    private final IEmailService emailService;
    private final IClienteRepository clienteRepository;

    public ClienteService(IClienteRepository clienteRepository, IEmailService emailService) {
        this.clienteRepository = clienteRepository;
        this.emailService = emailService;
    }

    public String adicionarCliente(Cliente cliente) {
        if(!cliente.isValid()) return "Dados Invalidos";

       clienteRepository.adicionarCliente(cliente);

       emailService.enviar("panta@gmail.com", cliente.getEmail(), "Bem vindo", "Parabéns está cadastrado");

        return "Cliente cadastrado com sucesso";
    }
}
