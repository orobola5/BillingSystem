package africa.semicolon.customer.Dto.responses;

import africa.semicolon.customer.Model.Data.Gender;
import africa.semicolon.customer.Model.Message.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Message message;

}
