package mvn.sandbox.order.regular.value;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import mvn.sandbox.order.regular.constant.PaymentType;

@Builder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Client {
    int id;
    int addressId;
    PaymentType paymentType;
}
