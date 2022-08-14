package africa.semicolon.customer.Model.Data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name="customer")
@Entity
@NoArgsConstructor
public class Customer {
    @Column(name = "gender")
    private Gender gender;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "password",nullable = false)
    private String password;

//    @OneToMany(mappedBy = "customer",
//    orphanRemoval = true,
//    fetch = FetchType.LAZY,
//    cascade = CascadeType.ALL)
////    @JoinColumn(name = "billing_accountNo",nullable = false)
//    private Set<Billing > billingDetails;

    public Customer(String firstName, String lastName, String email,String password,String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address=address;
        this.password=password;

    }




}
