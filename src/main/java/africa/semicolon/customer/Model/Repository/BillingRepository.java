package africa.semicolon.customer.Model.Repository;

import africa.semicolon.customer.Model.Data.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillingRepository extends JpaRepository<Billing,Long> {

    Optional<Billing> findBillingByCustomer_Id(Long id);


}
