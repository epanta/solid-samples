package OCP.Violacao;

import java.math.BigDecimal;

public class DebitoConta {

    public void debitar(BigDecimal valor, String conta, TipoConta tipoConta){
        if (tipoConta == TipoConta.Corrente) {
            //Debita conta corrente
        }

        if (tipoConta == TipoConta.Poupança) {
            //Valida aniversário da conta
            //Debita conta poupança
        }
    }
}
