package SRP.Solucao;

public class CPFService {

    public boolean isValid(String cpf) {
        return cpf.length() == 11;
    }
}
