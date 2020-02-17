package DIP.Solucao.Interfaces;

public interface IEmailService {
    boolean isValid(String email);

    void enviar(String email, String para, String assunto, String mensagem);
}
