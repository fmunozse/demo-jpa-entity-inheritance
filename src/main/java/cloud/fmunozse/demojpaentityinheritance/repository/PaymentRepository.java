package cloud.fmunozse.demojpaentityinheritance.repository;

import cloud.fmunozse.demojpaentityinheritance.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
