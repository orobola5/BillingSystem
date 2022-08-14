package africa.semicolon.customer.Dto.request;


import lombok.Data;

@Data
public class BillingRequest {
    private Long userId;
    private String tariff;
}
