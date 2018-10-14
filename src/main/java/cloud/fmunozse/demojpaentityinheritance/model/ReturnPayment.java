package cloud.fmunozse.demojpaentityinheritance.model;

import cloud.fmunozse.demojpaentityinheritance.model.iso2022.ISOCreditTransferTransaction;
import cloud.fmunozse.demojpaentityinheritance.model.iso2022.ISOCreditTransferTransactionConverter;
import cloud.fmunozse.demojpaentityinheritance.model.iso2022.ISOReturnTransaction;
import cloud.fmunozse.demojpaentityinheritance.model.iso2022.ISOReturnTransactionConverter;
import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("return")
public class ReturnPayment extends Payment {

    @Convert(converter = ISOReturnTransactionConverter.class)
    private ISOReturnTransaction payload;

    public ReturnPayment() {
        this.setPaymentType("return");
    }
}