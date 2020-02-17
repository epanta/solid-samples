package DIP.Solucao.Interfaces;

public class CPFService implements ICPFService {

    public boolean isValid(String cpf) {
        return cpf.length() == 11;
    }
}
