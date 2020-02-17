package OCP.Solucao;

import java.math.BigDecimal;

public class DebitoContaCorrente extends DebitoConta {

    @Override
    public String debitar(BigDecimal valor, String conta) {
        // Debita conta corrente
        return codigoTransacao;
    }
}
