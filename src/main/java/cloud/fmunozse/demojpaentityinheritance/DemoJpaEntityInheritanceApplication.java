package cloud.fmunozse.demojpaentityinheritance;

import cloud.fmunozse.demojpaentityinheritance.model.CreditTransferPayment;
import cloud.fmunozse.demojpaentityinheritance.model.ReturnPayment;
import cloud.fmunozse.demojpaentityinheritance.model.iso2022.ISOCreditTransferTransaction;
import cloud.fmunozse.demojpaentityinheritance.model.iso2022.ISOReturnTransaction;
import cloud.fmunozse.demojpaentityinheritance.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoJpaEntityInheritanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaEntityInheritanceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData (PaymentRepository repository) {
		return (args -> {

			ISOCreditTransferTransaction isoTrn = new ISOCreditTransferTransaction();
			isoTrn.setPaymentAmount(BigDecimal.valueOf(1.1));
			CreditTransferPayment trn = new CreditTransferPayment();
			trn.setName("name - CreditTransferPayment");
			trn.setPayload(isoTrn);
			repository.save(trn);


			ISOReturnTransaction isoReturn = new ISOReturnTransaction();
			isoReturn.setIdReturn("idReturn");
			ReturnPayment returnPayment = new ReturnPayment();
			returnPayment.setPayload(isoReturn);
			repository.save(returnPayment);

		});
	}
}
