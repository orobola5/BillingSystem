package africa.semicolon.customer.Model.Message;


import africa.semicolon.customer.Model.Data.Billing;
import africa.semicolon.customer.Model.Data.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private  String address;
//    private Set<Billing>billingDetails;





    public String toString(Message message) {
        return
                "Message{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", email='" + email + '\'' +
                        ", gender=" + gender +
                        ", address='" + address + '\'' +

                        '}';

    }


}
