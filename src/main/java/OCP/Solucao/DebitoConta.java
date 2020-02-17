package OCP.Solucao;

import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class DebitoConta {

    public String codigoTransacao;
    public abstract String debitar(BigDecimal valor, String conta);
}
