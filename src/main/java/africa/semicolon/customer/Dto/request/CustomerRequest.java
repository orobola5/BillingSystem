package africa.semicolon.customer.Dto.request;

import africa.semicolon.customer.Model.Data.Billing;
import africa.semicolon.customer.Model.Data.Gender;
import lombok.Data;

@Data
public class CustomerRequest {
    public String password;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private Gender gender;



}
