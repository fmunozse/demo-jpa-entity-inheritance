package cloud.fmunozse.demojpaentityinheritance.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity(name="payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="paymentType",discriminatorType = DiscriminatorType.STRING)
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(insertable = false, updatable = false)
    private String paymentType;


    private String name;


}
