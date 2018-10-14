package cloud.fmunozse.demojpaentityinheritance.model;

import cloud.fmunozse.demojpaentityinheritance.model.iso2022.ISOCreditTransferTransaction;
import cloud.fmunozse.demojpaentityinheritance.model.iso2022.ISOCreditTransferTransactionConverter;
import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("creditTransfer")
public class CreditTransferPayment extends Payment {

    @Convert(converter = ISOCreditTransferTransactionConverter.class)
    private ISOCreditTransferTransaction payload;

    public CreditTransferPayment() {
        this.setPaymentType("creditTransfer");
    }
}
