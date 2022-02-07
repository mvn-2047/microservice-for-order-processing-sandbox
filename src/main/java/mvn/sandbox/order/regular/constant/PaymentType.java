package mvn.sandbox.order.regular.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
    CARD("credit_card"),
    CASH("cash_payment"),
    TRANSFER("wire_transfer");

    private final String code;
}