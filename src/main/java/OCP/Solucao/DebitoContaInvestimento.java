package OCP.Solucao;

import java.math.BigDecimal;

public class DebitoContaInvestimento extends DebitoConta {

    @Override
    public String debitar(BigDecimal valor, String conta) {
        // Debita conta investimento
        // Isentar taxas
        return codigoTransacao;
    }
}
