package mvn.sandbox.order.regular.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import mvn.sandbox.order.regular.constant.PaymentType;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDto {
    int addressId;
    PaymentType paymentType;
}
