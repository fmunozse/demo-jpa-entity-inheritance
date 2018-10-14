package cloud.fmunozse.demojpaentityinheritance.repository;

import cloud.fmunozse.demojpaentityinheritance.model.CreditTransferPayment;
import cloud.fmunozse.demojpaentityinheritance.model.Payment;
import cloud.fmunozse.demojpaentityinheritance.model.ReturnPayment;
import cloud.fmunozse.demojpaentityinheritance.model.iso2022.ISOCreditTransferTransaction;
import cloud.fmunozse.demojpaentityinheritance.model.iso2022.ISOReturnTransaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test(expected = ConstraintViolationException.class)
    public void whenInsertParentWithType_thenThrowException() {

        Payment payment = new Payment();
        //payment.setPaymentType("creditTransfer");

        payment = paymentRepository.save(payment);

        fail();
        //assertThat(payment, is(notNullValue()));
    }

    @Test
    public void whenInsertCreditTransfer_thenPersitAndSearchOk() {
        ISOCreditTransferTransaction isoTrn = new ISOCreditTransferTransaction();
        isoTrn.setCreditPartyAgentId("creditPartyAgentId");

        CreditTransferPayment trn = new CreditTransferPayment();
        trn.setName("name - CreditTransferPayment");
        trn.setPayload(isoTrn);

        trn = paymentRepository.save(trn);

        assertThat(trn.getId(), is(notNullValue()));
        assertThat(trn.getPayload().getCreditPartyAgentId(), is("creditPartyAgentId"));
        assertThat(trn.getName(), is("name - CreditTransferPayment"));
    }

    @Test
    public void whenInsertReturnAndTrn_thenPersistAndSearchOk() {
        ISOCreditTransferTransaction isoTrn = new ISOCreditTransferTransaction();
        isoTrn.setCreditPartyAgentId("creditPartyAgentId");
        CreditTransferPayment trn = new CreditTransferPayment();
        trn.setPayload(isoTrn);

        ISOReturnTransaction isoReturn = new ISOReturnTransaction();
        isoReturn.setIdReturn("idReturn");
        ReturnPayment returnPayment = new ReturnPayment();
        returnPayment.setPayload(isoReturn);


        trn = paymentRepository.save(trn);
        returnPayment = paymentRepository.save(returnPayment);


        assertThat(trn.getPayload().getCreditPartyAgentId(), is("creditPartyAgentId"));
        assertThat(returnPayment.getPayload().getIdReturn(), is("idReturn"));
    }
}