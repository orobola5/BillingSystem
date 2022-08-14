package africa.semicolon.customer.Controller;

import africa.semicolon.customer.Dto.request.BillingRequest;
import africa.semicolon.customer.Dto.request.CustomerRequest;
import africa.semicolon.customer.Dto.request.InvoiceRequest;
import africa.semicolon.customer.Dto.responses.CustomerResponse;
import africa.semicolon.customer.Exception.CustomerException.CustomerException;
import africa.semicolon.customer.Model.Data.Customer;
import africa.semicolon.customer.Model.Data.Invoice;
import africa.semicolon.customer.Service.CustomerServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerServiceImp service;

    @PostMapping("/addCustomer")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest request){
        return service.addCustomer(request);

    }
    @GetMapping("/email/{email}")
    public Optional<Customer> getCustomerByEmail(@PathVariable String email) throws CustomerException {
        return service.findCustomerByEmail(email);

    }
    @GetMapping("/id/{id}")
    public Customer getCustomerById(@PathVariable Long id) throws CustomerException {

        return service.findById(id);
    }


    @GetMapping("/all")
    public List<Customer> getAllCustomer(){

        return service.findAll();
    }

    @PostMapping("/addBilling")
    public String addBillingToCustomer(@RequestBody BillingRequest request){
        service.addBillingToCustomer(request);
        return "Success";
    }


    @GetMapping("/getInvoice")
    public Invoice generateInvoice(@RequestBody InvoiceRequest request){
        return  service.generateInvoice(request.getCustomerId());
    }
}
