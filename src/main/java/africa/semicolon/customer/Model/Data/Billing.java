package africa.semicolon.customer.Model.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "billing")

public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    @Column(nullable = false)
    private String tariff;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Billing(Customer customer) {
        this.accountNumber= String.valueOf(UUID.randomUUID().getLeastSignificantBits()).substring(1,11)+"-01";
        this.customer = customer;
    }

    public Billing() {

    }





}
