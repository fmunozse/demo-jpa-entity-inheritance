package cloud.fmunozse.demojpaentityinheritance.model.iso2022;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ISOCreditTransferTransaction {

    private String id;
    private String creditPartyAgentId;
    private String debitPartyAgentId;
    private BigDecimal paymentAmount;

}
