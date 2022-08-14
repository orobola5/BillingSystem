package africa.semicolon.customer.Service;

import africa.semicolon.customer.Dto.request.BillingRequest;
import africa.semicolon.customer.Dto.request.CustomerRequest;
import africa.semicolon.customer.Dto.responses.CustomerResponse;
import africa.semicolon.customer.Exception.CustomerException.CustomerException;
import africa.semicolon.customer.Model.Data.Customer;
import africa.semicolon.customer.Model.Data.Invoice;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
    CustomerResponse addCustomer(CustomerRequest addCustomerRequest );
    String addBillingToCustomer(BillingRequest request);

    Invoice generateInvoice(Long customerId);
   Optional<Customer> findCustomerByEmail(String email) throws CustomerException;
    List<Customer> findAll();

    Customer findById(Long id) throws CustomerException;




}
