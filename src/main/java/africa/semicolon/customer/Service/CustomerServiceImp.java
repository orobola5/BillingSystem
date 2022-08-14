package africa.semicolon.customer.Service;

import africa.semicolon.customer.Dto.request.BillingRequest;
import africa.semicolon.customer.Dto.request.CustomerRequest;
import africa.semicolon.customer.Dto.responses.CustomerResponse;
import africa.semicolon.customer.Exception.CustomerException.CustomerException;
import africa.semicolon.customer.Model.Data.Billing;
import africa.semicolon.customer.Model.Data.Customer;
import africa.semicolon.customer.Model.Data.Invoice;
import africa.semicolon.customer.Model.Message.Message;
import africa.semicolon.customer.Model.Repository.BillingRepository;
import africa.semicolon.customer.Model.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService{
    private final CustomerRepository repository;

    private final BillingRepository billingRepository;


    public CustomerResponse addCustomer(CustomerRequest addCustomerRequest) {
        Customer customer = new Customer();
        customer.setFirstName(addCustomerRequest.getFirstName());
        customer.setLastName(addCustomerRequest.getLastName());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setAddress(addCustomerRequest.getAddress());
        customer.setPassword(addCustomerRequest.getPassword());
        customer.setGender(addCustomerRequest.getGender());
        repository.save(customer);

        Customer savedCustomer = repository.save(customer);

        CustomerResponse response = new CustomerResponse();
        Message message = new Message();
        message.setFirstName(savedCustomer.getFirstName());
        message.setLastName(savedCustomer.getLastName());
        message.setEmail(savedCustomer.getEmail());
        message.setGender(savedCustomer.getGender());
        message.setAddress(savedCustomer.getAddress());

        response.setMessage(message);
        return response;
    }

    @Override
    public String addBillingToCustomer(BillingRequest request) {
       Optional<Customer> customerRepo= repository.findById(request.getUserId());
       Customer customer = customerRepo.get();
       Billing bill = new Billing(customer);
       bill.setTariff(request.getTariff());
       billingRepository.save(bill);
       return "Billing Assigned";
    }

    @Override
    public Invoice generateInvoice(Long customerId) {
        Optional<Billing> billRepo = billingRepository.findBillingByCustomer_Id(customerId);
        Billing bill = billRepo.get();
        Optional<Customer> customerRepo = repository.findById(bill.getCustomer().getId());
        Customer customer = customerRepo.get();
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customer.getFirstName()+" "+customer.getLastName());
        invoice.setAccountNumberToPay(bill.getAccountNumber());
        invoice.setAmountToPay(bill.getTariff());
        return invoice;
    }


//        customer.setBillingDetails(new Billing(addCustomerRequest.getBillingDetails()));
//        String accountNumber= String.valueOf(UUID.randomUUID().getLeastSignificantBits());
//        accountNumber=accountNumber.substring(1,11)+"-01";
//        String tariff=accountNumber;
//        tariff= tariff.substring(1,5);
//        customer.setBillingDetails(new Billing(accountNumber,tariff));
//        billing.setAccountNumber(accountNumber);
//        billing.setTariff(tariff);










    public Optional<Customer> findCustomerByEmail(String email) throws CustomerException {
        log.info("###### FIND BY TITLE {}",email);
        Optional<Customer> customerList=repository.findCustomerByEmail(email);
        if(customerList.isEmpty()){
            Customer customer=new Customer();
            Customer savedCustomer = repository.save(customer);
            log.info("###### FIND BY customerList {}",customerList);
            return Optional.of(savedCustomer);
        }
        throw new CustomerException("customer already exists");


    }


    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(Long id) throws CustomerException {
        return repository.findById(id).orElseThrow(()->new CustomerException("customer does not exist"));
    }
}
