package africa.semicolon.customer.Model.Data;


import lombok.Data;

@Data
public class Invoice {
    private String customerName;
    private String accountNumberToPay;
    private String amountToPay;
}
